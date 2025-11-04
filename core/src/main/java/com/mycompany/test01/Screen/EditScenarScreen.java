package com.mycompany.test01.Screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.*;
import com.mycompany.test01.Config.MapConfig;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Scenario.MapObjective;
import com.mycompany.test01.Entity.Scenario.Opponent;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.observer.EditScenarLoadMapObserver;
import com.mycompany.test01.Interface.observer.ToastObserver;
import com.mycompany.test01.Interface.observer.UnitGroupObserver;
import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Library.HexPathfinderCalculator;
import com.mycompany.test01.Main;
import com.mycompany.test01.Observable.EditScenarLoadMapObservable;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Service.ScenarFileService;
import com.mycompany.test01.Util.*;
import jdk.jpackage.internal.Log;

import java.util.*;
import java.util.List;

public class EditScenarScreen implements Screen {

    // TODO déplacer dans le service
    //private final int MAX_BRUSH_SIZE = 10;
    //private final int MIN_BRUSH_SIZE = 0;

    private final Main game;
    private final Stage stage;
    private final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;

    public EditScenarModeEnum editMode;

    private boolean isLandUnitsTreeOpen = false;

    private final ToastObservable toastObservable;
    private final EditScenarLoadMapObservable editScenarLoadMapObservable;
    private final UnitRootGroupObservable unitRootGroupObservable;

    private final ScenarFileService scenarFileService;
    private final ArmyFileService armyFileService;

    public final EditScenarService editScenarService;
    private final InputMultiplexer inputMultiplexer; // Nouveau champ
    private final EditScenarScreen.EditScenarScreenInputAdapter screenInputAdapter; // Pour la logique d'entrée de l'écran



    private final Table leftMapPanel, rightPanel, bottomLeftButtonPanel;
    private Table rightPanelContainer;
    private Table  rightLoadMapPanel;
    private Table rightEditScenarPanel;

    private Table opponentsSidesListPanel;
    private Table opponentsEditPanel;
    private Table selectedOpponentEditPanel;
    private Table landUnitsTreePanel;

    private Table objectivesEditPanel;

    private Table startDateEditPanel;

    private Label scenarMapBrushSizeLabel;
    public Label editModeLabel;

    private Slider scenarMapBrushSideSlider;

    private ScrollPane rightScrollPane;

    private Image landArmyGroupIcon = null;
    public Image selectedUnitIcon= null;

    private boolean isScenarPresent = false;
    private boolean isObjectivesPanelOpen = false;
    private boolean isStartDatePanelOpen = false;

    private Hexagon pathStart, pathEnd;
    private List<Hexagon> path;

    public EditScenarScreen(Main game) {
        this.pathStart = null;
        this.pathEnd = null;
        this.path = new ArrayList<>();

        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();

        this.editMode = EditScenarModeEnum.NO_ACTION;

        this.scenarFileService = ScenarFileService.getInstance();
        this.armyFileService = ArmyFileService.getInstance();
        this.editScenarService = EditScenarService.getInstance();

        this.toastObservable = ToastObservable.getInstance();
        this.editScenarLoadMapObservable = EditScenarLoadMapObservable.getInstance();
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.subscribeToObservables();

        this.screenInputAdapter = new EditScenarScreen.EditScenarScreenInputAdapter(this);

        // Configurer InputMultiplexer
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(screenInputAdapter);
        inputMultiplexer.addProcessor(stage);

        Gdx.input.setInputProcessor(inputMultiplexer);    // Définir le multiplexeur comme processeur principal
        this.drawingTexture = GraphicUtil.getEmptyTexture();


        this.leftMapPanel = this.createLeftMapPanel();
        this.stage.addActor(this.leftMapPanel);
        this.rightPanel = this.createRightPanel();
        this.rightScrollPane = new ScrollPane(this.rightPanel, SkinUtil.getScrollPaneSkin(380, Gdx.graphics.getHeight() - 100));
        this.rightScrollPane.setBounds(Gdx.graphics.getWidth() - 430f, 50f, 380f, Gdx.graphics.getHeight() - 100f);
        this.stage.addActor(this.rightScrollPane);
        this.bottomLeftButtonPanel = this.createBottomLeftButtonPanel();
        this.stage.addActor(this.bottomLeftButtonPanel);

        Label.LabelStyle labelStyle = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Scenario", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);
        EditScenarScreen that = this;
        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            20, 200, 50);

        buttonBackWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(buttonBackWrapper.getButton());
    }

    private Table createMapFiltersCheckboxesPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);
        EditScenarScreen that = this;

        CheckBox checkBoxRiver = new CheckBox(" River", SkinUtil.getCheckBoxSkin(25));
        checkBoxRiver.setChecked(true);
        checkBoxRiver.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //System.out.println("change river checkbox");
                that.editScenarService.getScenario().getMap().getDisplayFlags().setRiverVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isRiverVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxRiver);

        CheckBox checkBoxRoad = new CheckBox(" Road", SkinUtil.getCheckBoxSkin(25));
        checkBoxRoad.setChecked(true);
        checkBoxRoad.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setRoadVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isRoadVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxRoad);

        CheckBox checkBoxFort = new CheckBox(" Fort.", SkinUtil.getCheckBoxSkin(25));
        checkBoxFort.setChecked(true);
        checkBoxFort.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setFortificationVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isFortificationVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxFort);

        CheckBox checkBoxCliff = new CheckBox(" Cliff", SkinUtil.getCheckBoxSkin(25));
        checkBoxCliff.setChecked(true);
        checkBoxCliff.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setCliffVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isCliffVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxCliff);

        CheckBox checkBoxBridge = new CheckBox(" Bridge", SkinUtil.getCheckBoxSkin(25));
        checkBoxBridge.setChecked(true);
        checkBoxBridge.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setBridgeVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isBridgeVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxBridge);

        CheckBox checkBoxOwner = new CheckBox(" Owner", SkinUtil.getCheckBoxSkin(25));
        checkBoxOwner.setChecked(true);
        checkBoxOwner.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setOwnerCountryVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isOwnerCountryVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxOwner);

        CheckBox checkBoxObjective = new CheckBox(" Obj.", SkinUtil.getCheckBoxSkin(25));
        checkBoxObjective.setChecked(true);
        checkBoxObjective.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setMapObjectiveVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isMapObjectiveVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxObjective);

        CheckBox checkBoxBorderHex = new CheckBox(" Border", SkinUtil.getCheckBoxSkin(25));
        checkBoxBorderHex.setChecked(true);
        checkBoxBorderHex.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setBorderHexeVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isBorderHexeVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxBorderHex);

        CheckBox checkBoxUnit = new CheckBox(" Unit", SkinUtil.getCheckBoxSkin(25));
        checkBoxUnit.setChecked(true);
        checkBoxUnit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                that.editScenarService.getScenario().getMap().getDisplayFlags().setUnitVisible(!that.editScenarService.getScenario().getMap().getDisplayFlags().isUnitVisible());
                that.redrawMap();
            }
        });
        panel.add(checkBoxUnit);

        return  panel;
    }

    private Table createLeftMapPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));

        //panel.addActor(createMapFiltersCheckboxesPanel());

        panel.setBounds(50f, 180f, Gdx.graphics.getWidth() - 500f, Gdx.graphics.getHeight() - 230f);
        return panel;
    }

    private Table createRightPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        panel.setBounds(Gdx.graphics.getWidth() - 430f, 50f, 380f, Gdx.graphics.getHeight() - 100f);
        panel.pad(20f);

        this.rightPanelContainer = new Table(); // <-- Conteneur unique
        panel.add(this.rightPanelContainer)
            .expandX()  // Occupe toute la largeur disponible
            .fillX()// Étire le contenu horizontalement
            .expandY()
            //.fillY()
            //.height(300f) // Hauteur fixe (ajuste selon tes besoins)
            .top();      // Alignement en haut

        // 2. Initialise les panneaux (mais ne les ajoute pas encore)
        this.rightLoadMapPanel = createRightLoadMapPanel();
        this.rightLoadMapPanel.setVisible(false);

        this.rightEditScenarPanel = createRightEditScenarPanel();
        this.rightEditScenarPanel.setVisible(false);

        return panel;
    }

    // Méthodes pour basculer entre les panneaux
    public void showLoadMapPanel() {
        this.rightPanelContainer.clear(); // Vide le conteneur
        this.rightPanelContainer.add(this.rightLoadMapPanel)
            .expand()  // Occupe tout l'espace
            .fill();   // Étire le panneau
        this.rightLoadMapPanel.setVisible(true);
        this.rightEditScenarPanel.setVisible(false);
    }

    public void showEditScenarPanel() {
        this.rightPanelContainer.clear(); // Vide le conteneur
        this.rightPanelContainer.add(this.rightEditScenarPanel)
            .expand()  // Occupe tout l'espace
            .fill();   // Étire le panneau
        this.rightEditScenarPanel.setVisible(true);
        this.rightLoadMapPanel.setVisible(false);
    }


   private Table createBottomLeftButtonPanel() { // TODO : corriger nom !!! en ...Left...

        int padding = 20;
        int panelHeight = 60;
        int buttonHeight = 40;
        int buttonWidth = 140;
        EditScenarScreen that = this;
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        panel.setBounds(50f, 100f, Gdx.graphics.getWidth() - 500f, panelHeight);
        //panel.columnDefaults(3);
        int posY = (panelHeight - buttonHeight) / 2;
        ButtonWrapper buttonNewScenarWrapper = new ButtonWrapper(
            "New Scenario",
            padding, posY, buttonWidth, buttonHeight);

        buttonNewScenarWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click new scenario");
                //that.rightLoadMapPanel.setVisible(true);
                //that.rightEditScenarPanel.setVisible(false);
                that.showLoadMapPanel();
                //TODO creer scenario
                //that.editScenarService.initScenar();
            }
        });
        panel.addActor(buttonNewScenarWrapper.getButton());

        ButtonWrapper buttonLoadScenarWrapper = new ButtonWrapper(
            "Load Scenario",
            padding + 1 * (padding + buttonWidth), posY, buttonWidth, buttonHeight);

        buttonLoadScenarWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click load scenario");
            }
        });
        panel.addActor(buttonLoadScenarWrapper.getButton());

        ButtonWrapper buttonSaveScenarWrapper = new ButtonWrapper(
            "Save Scenario",
            padding + 2 * (padding + buttonWidth), posY, buttonWidth, buttonHeight);

        buttonSaveScenarWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click save scenario");
            }
        });
        panel.addActor(buttonSaveScenarWrapper.getButton());


        panel.add(this.createMapFiltersCheckboxesPanel()).padLeft(420f);

        this.editModeLabel = new Label("Edit Mode : " + this.editMode.getName(), SkinUtil.getLabelSkin(200, 30));

        panel.add(this.editModeLabel).padLeft(20);

        return panel;
    }

    private Table createRightEditScenarPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        //panel.pad(20); // Padding global du panel (optionnel)

        // --- Solution pour coller Label + TextField ---
        // Désactive TOUT padding/espacement par défaut
        panel.defaults().padBottom(20).space(0);

        // Crée les éléments avec des styles minimalistes
        Label scenarNameLabel = new Label("Scenar Name : ", SkinUtil.getLabelSkin(80, 30));
        TextField scenarNameField = new TextField(
            this.editScenarService.getScenario().getName(),
            SkinUtil.getTextFieldSkin(80, 30)
        );

        scenarNameField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // 1. Récupérer la valeur brute
                String cleanedValue = TextUtil.getCleanedText(scenarNameField.getText(), 20);
                editScenarService.getScenario().setName(cleanedValue);
                scenarNameField.setText(cleanedValue);

                // 6. (Optionnel) Mettre à jour l'affichage si nécessaire
                //scenarNameField.setText("Scenar Name : " + cleanedValue);
            }
        });




        // Ajoute une Table imbriquée pour contrôler précisément l'alignement
        Table nameRow = new Table();
        nameRow.defaults().pad(0).space(0); // Pas d'espace ni padding

        // Ajoute le Label et le TextField dans la sous-Table
        nameRow.add(scenarNameLabel).left(); // Aligné à gauche
        nameRow.add(scenarNameField)
            .left()  // Aligné à gauche
            .width(120) // Largeur fixe (ajustable)
            .expandX(); // Occupe l'espace restant

        // Ajoute la sous-Table au panel principal
        panel.add(nameRow).colspan(2).padTop(20).padLeft(20).fillX().row();


        Label scenarMapNameLabel = new Label(
            "Map name : " + this.editScenarService.getScenario().getMap().getName(),
            SkinUtil.getLabelSkin(200, 30)
        );
        panel.add(scenarMapNameLabel).colspan(2).padLeft(20).left().row();


        Table opponentsPanel = createOpponentsPanel();
        panel.add(opponentsPanel).colspan(2);
        //panel.setBounds(50f, 100f, Gdx.graphics.getWidth() - 500f, panelHeight);

        return panel;
    }

    private Table createOpponentsPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        //panel.setHeight(300);

        Label scenarSidesCountLabel = new Label("Sides count : " + this.editScenarService.getScenario().getSidesCount(), SkinUtil.getLabelSkin(100, 30));

        Slider scenarSidesCountSlider = new Slider(2f, 6f, 1f, false, SkinUtil.getSliderSkin(200, 30, 20)); // min, max, step, vertical
        scenarSidesCountSlider.setValue(this.editScenarService.getScenario().getSidesCount()); // Valeur par défaut

        /*
        Table nameRow = new Table();
        nameRow.defaults().pad(0).space(0); // Pas d'espace ni padding

        // Ajoute le Label et le TextField dans la sous-Table
        nameRow.add(scenarNameLabel).left(); // Aligné à gauche
        nameRow.add(scenarNameField)
            .left()  // Aligné à gauche
            .width(120) // Largeur fixe (ajustable)
            .expandX(); // Occupe l'espace restant

        // Ajoute la sous-Table au panel principal
        panel.add(nameRow).colspan(2).padTop(20).padLeft(20).fillX().row();
         */


        EditScenarScreen that = this;
        scenarSidesCountSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                scenarSidesCountLabel.setText("Sides count : " + (int) scenarSidesCountSlider.getValue());
                that.editScenarService.getScenario().setSidesCount((int) scenarSidesCountSlider.getValue());
                that.editScenarService.getScenario().setSidesFromCount();
                //that.opponentsSidesListPanel = createOpponentsSidesListPanel();
                that.editScenarService.getScenario().initOpponentsFromSidesCount();
                rebuildOpponentsSidesListPanel();

                //that.displaySidesPanel();
            }
        });
        //panel.pad(20);
        Table sidesRow = new Table();
        sidesRow.defaults().pad(0).space(0);


        sidesRow.add(scenarSidesCountLabel).left().padLeft(20);
        sidesRow.add(scenarSidesCountSlider).left().padLeft(20)  // Aligné à gauche
            .width(120) // Largeur fixe (ajustable)
            .expandX();
        panel.add(sidesRow);
        panel.row();

        //this.opponentsSidesListPanel = createOpponentsSidesListPanel();
        this.editScenarService.getScenario().initOpponentsFromSidesCount();
        rebuildOpponentsSidesListPanel();
        panel.add(this.opponentsSidesListPanel).colspan(2);
        panel.row();


        Table buttonsRow = new Table();

        ButtonWrapper buttonSetObjectives = new ButtonWrapper(
            "Objectives",
            0, 0,
            100, 30);

        // listener
        buttonSetObjectives.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if(that.isScenarPresent) {
                    //System.out.println("opponents ok !");
                    //Toast.showToast(that.stage, "Set Objectives", ColorStyleEnum.SUCCESS, 2f);
                    //that.redrawMap();
                    //that.updateEditMode(EditScenarModeEnum.SET_OBJECTIVES);
                    that.isObjectivesPanelOpen = !that.isObjectivesPanelOpen;
                    that.rebuildObjectivesEditPanel();
                    // TODO fermer les autres panels ? (startDate)

                }
                else {
                    //System.out.println("opponents ko !");
                    Toast.showToast(that.stage, "Scenario problem", ColorStyleEnum.WARNING, 2f);
                }
            }
        });


        buttonsRow.add(buttonSetObjectives.getButton()).padLeft(0).padTop(20).colspan(1);

        ButtonWrapper buttonResetEditModeWrapper = new ButtonWrapper("Reset Mode", 0, 0, 120, 30);

        buttonResetEditModeWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                //System.out.println("click load all");
                //if (selectedUnit instanceof )
                that.redrawMap();
                that.updateEditMode(EditScenarModeEnum.NO_ACTION);
            }
        });

        //buttonResetEditModeWrapper.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

        buttonsRow.add(buttonResetEditModeWrapper.getButton()).padLeft(20).padTop(20).colspan(1).row();

        panel.add(buttonsRow).colspan(2).row();

        Table dateButtonsRow = new Table();
        // TODO ajouter bouton de la startDate
        ButtonWrapper buttonStartDateWrapper = new ButtonWrapper("Start Date", 0, 0, 120, 30);

        buttonStartDateWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                //LogUtil.logInfo("click start date");
                if(that.isScenarPresent) {
                    that.isStartDatePanelOpen = !that.isStartDatePanelOpen;
                    that.rebuildStartDateEditPanel();
                    // TODO fermer l'autre panel ? (objectives)
                }
            }
        });

        dateButtonsRow.add(buttonStartDateWrapper.getButton()).colspan(2).row();

        // TODO ajouter slider pour la durée en jour
        Label durationLabel = new Label("Duration : 1", SkinUtil.getLabelSkin(120, 30));
        Slider durationSlider = new Slider(1, 120, 1, false, SkinUtil.getSliderSkin(180, 30, 20));

        //EditScenarScreen that = this;
        durationSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                durationLabel.setText("Duration : " + (int) durationSlider.getValue());
                that.editScenarService.getScenario().setDuration((int) durationSlider.getValue());
                //that.rebuildStartDateEditPanel();
            }
        });

        dateButtonsRow.add(durationLabel).spaceTop(20);
        dateButtonsRow.add(durationSlider).spaceTop(20).padLeft(10).row();

        panel.add(dateButtonsRow).spaceTop(20).colspan(2).row();

        // TODO appeler rebuildStartDateEditPanel
        this.rebuildStartDateEditPanel();
        panel.add(startDateEditPanel).spaceTop(20).colspan(2).row();

        this.rebuildObjectivesEditPanel();
        panel.add(objectivesEditPanel).spaceTop(20).colspan(2).row();

        this.rebuildOpponentsEditPanel();
        panel.add(opponentsEditPanel).spaceTop(20).fillX().expandX().colspan(2).spaceBottom(20);
        panel.row();

        return panel;
    }
    /*
        that.editScenarService.setSelectedUnit(element);
        that.editMode = EditScenarModeEnum.DEPLOY_UNITS;
        that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());

        Texture unitTexture = GraphicUtil.getCounterTextureFromUnit(element);
        //LogUtil.logInfo("Texture : " + unitTexture.getHeight() + " " + unitTexture.getWidth() + " " + unitTexture.getTextureData());
        that.selectedUnitIcon = new Image(unitTexture);
        that.selectedUnitIcon.setWidth(80);
        that.selectedUnitIcon.setHeight(80);
        that.rebuildSelectedOpponentEditPanel();
     */

    // TODO créer rebuildStartDateEditPanel()

    private void rebuildStartDateEditPanel() {
        //this.startDateEditPanel ==
        if (this.startDateEditPanel != null) {
            this.startDateEditPanel.clear();
        } else {
            this.startDateEditPanel = new Table();
            this.startDateEditPanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        }

        if(isStartDatePanelOpen) {
            EditScenarScreen that = this;

            Label titleLabel = new Label("Start Date : " + this.editScenarService.getScenario().getStartDate().toString(), SkinUtil.getLabelSkin(160, 30));
            this.startDateEditPanel.add(titleLabel).colspan(2).row();
            Table fieldcontainer = new Table();

            // TODO ajouter slider pour le jour de startDate
            Label startDayLabel = new Label("day : " + this.editScenarService.getScenario().getStartDate().getDay(), SkinUtil.getLabelSkin(120, 30));
            Slider startDaySlider = new Slider(1, this.editScenarService.getScenario().getStartDate().getMonthDuration(), 1, false, SkinUtil.getSliderSkin(180, 30, 20));
            startDaySlider.setValue(this.editScenarService.getScenario().getStartDate().getDay());
            startDaySlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    startDayLabel.setText("day : " + (int) startDaySlider.getValue());
                    that.editScenarService.getScenario().getStartDate().setDay((int) startDaySlider.getValue());
                    //that.rebuildStartDateEditPanel();
                }
            });
            fieldcontainer.add(startDayLabel).spaceTop(20);
            fieldcontainer.add(startDaySlider).spaceTop(20).padLeft(10).row();

            // TODO ajouter slider pour le mois de startDate
            Label startMonthLabel = new Label("month : " + this.editScenarService.getScenario().getStartDate().getMonth(), SkinUtil.getLabelSkin(120, 30));
            Slider startMonthSlider = new Slider(1, 12, 1, false, SkinUtil.getSliderSkin(180, 30, 20));
            startMonthSlider.setValue(this.editScenarService.getScenario().getStartDate().getMonth());
            startMonthSlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    startMonthLabel.setText("month : " + (int) startMonthSlider.getValue());
                    that.editScenarService.getScenario().getStartDate().setMonth((int) startMonthSlider.getValue());
                    //LogUtil.logInfo("avant rebuild");
                    //that.rebuildStartDateEditPanel();
                }
            });
            fieldcontainer.add(startMonthLabel).spaceTop(20);
            fieldcontainer.add(startMonthSlider).spaceTop(20).padLeft(10).row();

            ButtonWrapper buttonValidateStartDateWrapper = new ButtonWrapper("Validate", 0, 0, 120, 30);

            buttonValidateStartDateWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //LogUtil.logInfo("click validate");
                    that.editScenarService.getScenario().getStartDate().setDay((int) startDaySlider.getValue());
                    that.editScenarService.getScenario().getStartDate().setMonth((int) startMonthSlider.getValue());
                    that.rebuildStartDateEditPanel();
                }
            });
            fieldcontainer.add(buttonValidateStartDateWrapper.getButton()).colspan(2).spaceTop(20).row();


            this.startDateEditPanel.add(fieldcontainer).spaceTop(20).colspan(2).row();
        }
    }

    private void rebuildObjectivesEditPanel() {
        if (this.objectivesEditPanel != null) {
            this.objectivesEditPanel.clear();
        } else {
            this.objectivesEditPanel = new Table();
            this.objectivesEditPanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        }
        // TODO set le selectedObjective à null
        this.editScenarService.setSelectedObjective(null);
        if(isObjectivesPanelOpen) {
            Label titlelLabel = new Label("Objectives", SkinUtil.getLabelSkin(100, 30));
            this.objectivesEditPanel.add(titlelLabel).colspan(2).spaceBottom(20).row();

            Table newObjectiveContainer = new Table();

            Label nameLabel = new Label("Name :", SkinUtil.getLabelSkin(80, 30));
            TextField nameTextField = new TextField("", SkinUtil.getTextFieldSkin(120, 30));
            newObjectiveContainer.add(nameLabel);
            newObjectiveContainer.add(nameTextField).padLeft(20).row();

            // TODO : Set l'acronym comme pour les unités (cf screen)
            Label acronymLabel = new Label("Acronym :", SkinUtil.getLabelSkin(80, 30));
            TextField acronymTextField = new TextField("", SkinUtil.getTextFieldSkin(120, 30));
            newObjectiveContainer.add(acronymLabel);
            newObjectiveContainer.add(acronymTextField).padLeft(20).row();

            // TODO utiliser des constantes de Config pour les sliders et labels
            //Slider scenarSidesCountSlider = new Slider(2f, 6f, 1f, false, SkinUtil.getSliderSkin(200, 30, 20));
            Label captureRewardLabel = new Label("Capture : 100", SkinUtil.getLabelSkin(120, 30));
            Slider captureRewardSlider = new Slider(100f, 1600f, 100f, false, SkinUtil.getSliderSkin(200, 30, 20));

            EditScenarScreen that = this;
            captureRewardSlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    captureRewardLabel.setText("Capture : " + (int) captureRewardSlider.getValue());
                    //that.rebuildObjectivesEditPanel();
                }
            });

            newObjectiveContainer.add(captureRewardLabel);
            newObjectiveContainer.add(captureRewardSlider).padLeft(10).row();

            Label dailyRewardLabel = new Label("Daily : 5", SkinUtil.getLabelSkin(120, 30));
            Slider dailyRewardSlider = new Slider(5f, 250f, 5f, false, SkinUtil.getSliderSkin(200, 30, 20));

            dailyRewardSlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    dailyRewardLabel.setText("Daily : " + (int) dailyRewardSlider.getValue());
                    //that.rebuildObjectivesEditPanel();
                }
            });

            newObjectiveContainer.add(dailyRewardLabel);
            newObjectiveContainer.add(dailyRewardSlider).padLeft(10).row();

            Label endGameRewardLabel = new Label("End Game : 100", SkinUtil.getLabelSkin(120, 30));
            Slider endGameRewardSlider = new Slider(100f, 3200f, 100f, false, SkinUtil.getSliderSkin(200, 30, 20));

            endGameRewardSlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    endGameRewardLabel.setText("End Game : " + (int) endGameRewardSlider.getValue());
                    //that.rebuildObjectivesEditPanel();
                }
            });

            newObjectiveContainer.add(endGameRewardLabel);
            newObjectiveContainer.add(endGameRewardSlider).padLeft(10).row();

            ButtonWrapper buttonAddObjectiveWrapper = new ButtonWrapper("Add", 0, 0, 120, 30);

            buttonAddObjectiveWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //LogUtil.logInfo("click add");
                    boolean isNewObjectiveOk = !nameTextField.getText().isEmpty();
                    isNewObjectiveOk &= !acronymTextField.getText().isEmpty();
                    if(isNewObjectiveOk) {
                        String name = nameTextField.getText();
                        String acronym = acronymTextField.getText();
                        int captureReward = (int) captureRewardSlider.getValue();
                        int dailyReward = (int) dailyRewardSlider.getValue();
                        int endGameReward = (int) endGameRewardSlider.getValue();

                        MapObjective newObjective = new MapObjective(name, acronym, captureReward, dailyReward, endGameReward, new Array<>());
                        if(!that.editScenarService.getScenario().getObjectives().contains(newObjective, false)) {
                            that.editScenarService.getScenario().getObjectives().add(newObjective);
                            Toast.showToast(that.stage, "New objective added",ColorStyleEnum.SUCCESS , 2f);
                        }
                        that.rebuildObjectivesEditPanel();
                    }
                    //LogUtil.logInfo("objectives size : " + that.editScenarService.getScenario().getObjectives().size);
                }
            });
            newObjectiveContainer.add(buttonAddObjectiveWrapper.getButton()).colspan(2).spaceTop(20).row();

            this.objectivesEditPanel.add(newObjectiveContainer).colspan(2).row();

            if(!that.editScenarService.getScenario().getObjectives().isEmpty()) {
                Table objectivesListContainer = new Table();
               for(MapObjective obj : that.editScenarService.getScenario().getObjectives()) {
                Table row = new Table();
                Label rowContent = new Label(obj.getName() + " / " + obj.getAcronym() + " / " + obj.getCaptureReward() + " / " + obj.getDailyCaptureReward() + " / " + obj.getEndGameReward(), SkinUtil.getLabelSkin(280, 30));
                row.add(rowContent);

                ButtonWrapper addHexButton = new ButtonWrapper("+", 0, 0, 30, 30);

                   addHexButton.getButton().addListener(new ChangeListener() {
                       @Override
                       public void changed(ChangeEvent changeEvent, Actor actor) {
                           //LogUtil.logInfo("click delete");

                           // TODO set le selectedObjective
                           that.editScenarService.setSelectedObjective(obj);
                           that.updateEditMode(EditScenarModeEnum.SET_OBJECTIVES);
                           // passer en mode SET_OBJECTIVES
                       }
                   });

                row.add(addHexButton.getButton());

                ButtonWrapper deleteButton = new ButtonWrapper("X", 0, 0, 30, 30);

               deleteButton.getButton().addListener(new ChangeListener() {
                   @Override
                   public void changed(ChangeEvent changeEvent, Actor actor) {
                       //LogUtil.logInfo("click delete");
                       that.editScenarService.getScenario().getObjectives().removeValue(obj, true);
                       that.rebuildObjectivesEditPanel();
                       that.redrawMap();
                       Toast.showToast(that.stage, "Objective deleted",ColorStyleEnum.SUCCESS , 2f);

                    }
               });
               row.add(deleteButton.getButton()).row();
               objectivesListContainer.add(row).colspan(2).spaceTop(10).row();
               }

                this.objectivesEditPanel.add(objectivesListContainer).spaceTop(20).colspan(2).row();
            }

        }
    }
//selectedObjective
    private void rebuildLandUnitsTreePanel() {
        //this.landUnitsTreePanel = new Table();
        if (this.landUnitsTreePanel != null) {
            this.landUnitsTreePanel.clear();
        } else {
            this.landUnitsTreePanel = new Table();
            this.landUnitsTreePanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        }


        if(this.editScenarService.getSelectedOpponent().getLandArmyGroup() != null && isLandUnitsTreeOpen) {
            //Label titleLabel = new Label("Land Units Tree :", SkinUtil.getLabelSkin(160, 30));
            //this.landUnitsTreePanel.add(titleLabel).padTop(20).width(160).row();
            Tree<ScenarUnitNode, String> landUnitsTree = new Tree<>(SkinUtil.getUnitTreeSkin());

            // TODO : vérifier que ça sert à qqchose
            /*
            landUnitsTree.setPadding(10);
            landUnitsTree.setIndentSpacing(30);
            landUnitsTree.setIconSpacing(10, 20);
            landUnitsTree.setPosition(100, Gdx.graphics.getHeight() - 100f, 1);
            //float rectWidth = (Gdx.graphics.getWidth() - (3 + 1) * 50f) / 3;
            //float rectHeight = Gdx.graphics.getHeight() - 150f;
            landUnitsTree.setBounds(0f, -20f, 300, 800);

             */

            ScenarUnitNode rootNode = GraphicUtil.createScenarTreeFromGroup(this.editScenarService.getSelectedOpponent().getLandArmyGroup(), this);
            landUnitsTree.add(rootNode);
            EditScenarScreen that = this;

            landUnitsTree.getRootNodes().get(0).getActor().addListener(new ClickListener() {
                public void clicked (InputEvent event, float x, float y) {
                    //LogUtil.logInfo("clic on root : " + that.editScenarService.getSelectedOpponent().getLandArmyGroup().getName());
                    OnBoardUnit onBoardUnit = new OnBoardUnit();
                    onBoardUnit.setUnit(that.editScenarService.getSelectedOpponent().getLandArmyGroup());
                    boolean isDeployed = that.editScenarService.getSelectedOpponent().getDeployedUnits().stream().anyMatch((OnBoardUnit unit) ->
                        unit.equals(onBoardUnit)
                    );
                    if(!isDeployed) {
                        //landUnitsTree.getRootNodes().get(0).getActor().background(new TextureRegionDrawable(GraphicUtil.orangeTexture));
                        that.editScenarService.setSelectedUnit(that.editScenarService.getSelectedOpponent().getLandArmyGroup());
                        that.updateEditMode(EditScenarModeEnum.DEPLOY_UNITS);
                        that.rebuildSelectedOpponentEditPanel();
                        // TODO set le TreeNode : landUnitsTree.getRootNodes().get(0).getActor()
                        //that.editScenarService.setSelectedTreeNode(landUnitsTree.getRootNodes().get(0));



                    }

                }
            });
            landUnitsTree.expandAll();
            ScrollPane treeScrollPane = new ScrollPane(landUnitsTree, SkinUtil.getScrollPaneSkin(320, 800));
            this.landUnitsTreePanel.add(treeScrollPane).padTop(20).width(320).colspan(3).row();
            this.landUnitsTreePanel.invalidateHierarchy();
        }
    }

    private void rebuildOpponentsSidesListPanel() {
        // 1. Nettoyer l'ancien panel
        if (this.opponentsSidesListPanel != null) {
            this.opponentsSidesListPanel.clear();
        } else {
            this.opponentsSidesListPanel = new Table();
            this.opponentsSidesListPanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        }

        // 2. Ajouter un titre
        Label titleLabel = new Label(
            "Sides (" + this.editScenarService.getScenario().getSidesCount() + "):",
            SkinUtil.getLabelSkin(100, 30)
        );
        this.opponentsSidesListPanel.add(titleLabel).colspan(2).padBottom(10).padTop(20).row();

        // 3. Ajouter un bloc par side (exemple : un Label + un bouton par side)
        EditScenarScreen that = this;
        for (int i = 0; i < this.editScenarService.getScenario().getSidesCount(); i++) {
            Table container = new Table();
            Label sideLabel = new Label(this.editScenarService.getScenario().getSides()[i].toString(), SkinUtil.getLabelSkin(80, 25));
            //Button sideButton = new Button(SkinUtil.getButtonSkin(100, 25));
            container.add(sideLabel).colspan(1);

            SelectBox<CountryEnum> countryOneSelector = new SelectBox<>(SkinUtil.getSelectorSkin(200, 30));
            CountryEnum[] items = CountryEnum.values();
            countryOneSelector.setItems(items);
            countryOneSelector.setSelected(CountryEnum.NO_COUNTRY);

            int finalI = i;
            countryOneSelector.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    // Pas de cast nécessaire : on utilise directement countryOneSelector
                    CountryEnum selectedCountry = countryOneSelector.getSelected();
                    that.editScenarService.getScenario().getOpponents()[finalI].setCountry(selectedCountry);
                    that.editScenarService.getScenario().getOpponents()[finalI].setName("Opponent " + (finalI+1));

                    //System.out.println("Country chosen for side: " + that.editScenarService.getScenario().getSides()[finalI] + " : " + selectedCountry);
                    //System.out.println("country's side : " + that.editScenarService.getScenario().getOpponents()[finalI].getSide().toString());
                }
            });

            container.add(countryOneSelector).colspan(1).row();

            this.opponentsSidesListPanel.add(container).colspan(2).row();
            //this.opponentsSidesListPanel.add(sideButton).row();
        }

        ButtonWrapper buttonValidateOpponents = new ButtonWrapper(
            "Validate",
            0, 0,
            100, 30);

        buttonValidateOpponents.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if(that.isScenarPresent && that.editScenarService.getScenario().isOpponentsOk()) {
                    //System.out.println("opponents ok !");
                    Toast.showToast(that.stage, "Opponents ok", ColorStyleEnum.SUCCESS, 2f);
                    // TODO afficher editOpponentPanel
                    that.rebuildOpponentsEditPanel();
                    that.rebuildSelectedOpponentEditPanel();
                }
                else {
                    //System.out.println("opponents ko !");
                    Toast.showToast(that.stage, "Opponents ko", ColorStyleEnum.WARNING, 2f);
                }
            }
        });


        this.opponentsSidesListPanel.add(buttonValidateOpponents.getButton()).center().pad(0).spaceTop(20);
    }

    private void rebuildOpponentsEditPanel() {
        if (this.opponentsEditPanel != null) {
            this.opponentsEditPanel.clear();
        } else {
            this.opponentsEditPanel = new Table();
            this.opponentsEditPanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        }

        this.opponentsEditPanel.pad(20);
        SelectBox<Opponent> opponentSelector = new SelectBox<>(SkinUtil.getSelectorSkin(200, 30));
        if(this.editScenarService.getScenario().getOpponents().length > 0) {
            Opponent[] items = this.editScenarService.getScenario().getOpponents();
            opponentSelector.setItems(items);
            this.editScenarService.setSelectedOpponent(items[0]);
        }
        //opponentSelector.setSelected(CountryEnum.NO_COUNTRY);

        EditScenarScreen that = this;
        opponentSelector.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Opponent selectedOpponent = opponentSelector.getSelected();
                that.editScenarService.setSelectedOpponent(selectedOpponent);
                that.rebuildSelectedOpponentEditPanel();
            }
        });
        this.opponentsEditPanel.add(opponentSelector).colspan(2).row();

        this.rebuildSelectedOpponentEditPanel();
        this.opponentsEditPanel.add(this.selectedOpponentEditPanel).row();
    }

    public void rebuildSelectedOpponentEditPanel() {
        EditScenarScreen that = this;
        if (this.selectedOpponentEditPanel != null) {
            this.selectedOpponentEditPanel.clear();
        } else {
            this.selectedOpponentEditPanel = new Table();
            this.selectedOpponentEditPanel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        }

        if(this.editScenarService.getSelectedOpponent() != null) {
            Label selectedOpponentNameLabel = new Label("Name : ", SkinUtil.getLabelSkin(80, 25));
            this.selectedOpponentEditPanel.add(selectedOpponentNameLabel).colspan(1).padTop(20);
            TextField selectedOpponentNameTextField = new TextField(this.editScenarService.getSelectedOpponent().getName(), SkinUtil.getTextFieldSkin(150, 30));

            selectedOpponentNameTextField.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    // 1. Récupérer la valeur brute
                    String cleanedValue = TextUtil.getCleanedText(selectedOpponentNameTextField.getText(), 20);
                    editScenarService.getSelectedOpponent().setName(cleanedValue);
                    selectedOpponentNameTextField.setText(cleanedValue);

                    // 6. (Optionnel) Mettre à jour l'affichage si nécessaire
                    //scenarNameField.setText("Scenar Name : " + cleanedValue);
                }
            });

            this.selectedOpponentEditPanel.add(selectedOpponentNameTextField).colspan(1).padTop(20).row();

            Label selectedOpponentSideLabel = new Label("Side : " + this.editScenarService.getSelectedOpponent().getSide().getName(), SkinUtil.getLabelSkin(80, 25));
            this.selectedOpponentEditPanel.add(selectedOpponentSideLabel).colspan(2).align(Align.left).row();

            Label selectedOpponentCountryLabel = new Label("Country : " + this.editScenarService.getSelectedOpponent().getCountry().getName(), SkinUtil.getLabelSkin(80, 25));
            this.selectedOpponentEditPanel.add(selectedOpponentCountryLabel).colspan(2).align(Align.left).row();

            ButtonWrapper buttonSetOwnedHexesWrapper = new ButtonWrapper("Owned Hexes", 0, 0, 120, 30);

            buttonSetOwnedHexesWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.redrawMap();
                    that.updateEditMode(EditScenarModeEnum.OWNED_HEXES);

                    //that.editMode = EditScenarModeEnum.OWNED_HEXES;
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                }
            });

            buttonSetOwnedHexesWrapper.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            this.selectedOpponentEditPanel.add(buttonSetOwnedHexesWrapper.getButton()).padTop(20).align(Align.center).colspan(2).row();

            // TODO nouveau bouton reset mode
            /*
            ButtonWrapper buttonResetEditModeWrapper = new ButtonWrapper("Reset Mode", 0, 0, 120, 30);

            buttonResetEditModeWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.redrawMap();
                    that.updateEditMode(EditScenarModeEnum.NO_ACTION);

                    //that.editMode = EditScenarModeEnum.NO_ACTION;
                    // TODO faire méthode ?
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                }
            });

            //buttonResetEditModeWrapper.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            this.selectedOpponentEditPanel.add(buttonResetEditModeWrapper.getButton()).padTop(20).align(Align.center).row();
            */



            //this.scenarMapBrushSizeLabel this.scenarMapBrushSideSlider
            this.scenarMapBrushSizeLabel = new Label("Brush Size : " + this.editScenarService.getMapBrushSize(), SkinUtil.getLabelSkin(100, 30));

            this.scenarMapBrushSideSlider = new Slider(MapConfig.MIN_BRUSH_SIZE, MapConfig.MAX_BRUSH_SIZE, 1f, false, SkinUtil.getSliderSkin(200, 30, 20)); // min, max, step, vertical
            scenarMapBrushSideSlider.setValue(this.editScenarService.getMapBrushSize());

            scenarMapBrushSideSlider.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    scenarMapBrushSizeLabel.setText("Brush Size : " + (int) scenarMapBrushSideSlider.getValue());
                    that.editScenarService.setMapBrushSize((int) scenarMapBrushSideSlider.getValue());
                    // rebuildOpponentsSidesListPanel();
                }
            });

            this.selectedOpponentEditPanel.add(scenarMapBrushSizeLabel).padTop(20);
            this.selectedOpponentEditPanel.add(scenarMapBrushSideSlider).padTop(20).row();

            Table buttonHexesContainer = new Table();

            ButtonWrapper buttonEdgesHexes = new ButtonWrapper("Edges" , 0, 0, 80, 30);

            buttonEdgesHexes.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            // TODO : ajouter change listener
            buttonEdgesHexes.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.redrawMap();
                    that.updateEditMode(EditScenarModeEnum.EDGES_HEXES);

                    //that.editMode = EditScenarModeEnum.EDGES_HEXES;
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                }
            });

            buttonHexesContainer.add(buttonEdgesHexes.getButton());

            ButtonWrapper buttonReinfHexes = new ButtonWrapper("Reinf" , 0, 0, 80, 30);

            buttonReinfHexes.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            // TODO : ajouter change listener
            buttonReinfHexes.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.redrawMap();
                    that.updateEditMode(EditScenarModeEnum.REINF_HEXES);

                    //that.editMode = EditScenarModeEnum.REINF_HEXES;
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                }
            });
            buttonHexesContainer.add(buttonReinfHexes.getButton()).padLeft(20).padRight(20);

            ButtonWrapper buttonSupplyHexes = new ButtonWrapper("Supply" , 0, 0, 80, 30);

            buttonSupplyHexes.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            // TODO : ajouter change listener
            buttonSupplyHexes.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.redrawMap();
                    that.updateEditMode(EditScenarModeEnum.SUPPLY_HEXES);

                    //that.editMode = EditScenarModeEnum.SUPPLY_HEXES;
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                }
            });

            buttonHexesContainer.add(buttonSupplyHexes.getButton()).row();

            this.selectedOpponentEditPanel.add(buttonHexesContainer).padTop(20).colspan(2).row();

            Table landArmyButtonsContainer = new Table();

            ButtonWrapper buttonLoadArmyGroupWrapper = new ButtonWrapper("Load Army", 0, 0, 80, 30);

            buttonLoadArmyGroupWrapper.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY);

            buttonLoadArmyGroupWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //System.out.println("click load all");
                    //if (selectedUnit instanceof )
                    that.loadRootGroupFromFile();
                    //that.rebuildLandUnitsTreePanel();
                }
            });

            landArmyButtonsContainer.add(buttonLoadArmyGroupWrapper.getButton()).row();
/*
            ButtonWrapper buttonDeployUnitsWrapper = new ButtonWrapper("Deploy", 0, 0, 80, 30);

            buttonDeployUnitsWrapper.getButton().setDisabled(this.editScenarService.getSelectedOpponent().getCountry() == CountryEnum.NO_COUNTRY || this.editScenarService.getSelectedOpponent().getLandArmyGroup() == null);

            buttonDeployUnitsWrapper.getButton().addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    //LogUtil.logInfo("click deploy units");
                    that.updateEditMode(EditScenarModeEnum.DEPLOY_UNITS);

                    //that.editMode = EditScenarModeEnum.DEPLOY_UNITS;
                    //that.editModeLabel.setText("Edit Mode : " + that.editMode.getName());
                    UnitRedCountryFactory factory = new UnitRedCountryFactory();
                    double randomName = Math.random();
                    String randomAcronym = String.valueOf(Math.round(randomName*10000));

                    double randomIsElite = Math.random();
                    boolean isElite = randomIsElite > 0.67;

                    double randomUnit = Math.random();
                    UnitElement unit = randomUnit > 0.5 ? factory.createInfRecoCompanyUnit(
                        randomAcronym, randomAcronym, isElite, isElite, 0) : factory.createAssaultGunUnit(
                        randomAcronym, randomAcronym, isElite, isElite, 0);

                    //UnitElement unit = factory.createInfRecoCompanyUnit(randomAcronym, randomAcronym, isElite, isElite, 0);
                    that.editScenarService.setSelectedUnit(unit);
                    //that.updateSelectedUnitIcon(unit);

                    //Texture unitTexture = GraphicUtil.getCounterTextureFromUnit(unit);
                    //LogUtil.logInfo("Texture : " + unitTexture.getHeight() + " " + unitTexture.getWidth() + " " + unitTexture.getTextureData());
                    //that.selectedUnitIcon = new Image(unitTexture);
                    //that.selectedUnitIcon.setWidth(80);
                    //that.selectedUnitIcon.setHeight(80);
                    that.rebuildSelectedOpponentEditPanel();
                }
            });

            landArmyButtonsContainer.add(buttonDeployUnitsWrapper.getButton()).padLeft(20).row();
*/
            this.landArmyGroupIcon = new Image(this.getLandArmyGroupTextureFromOpponent(this.editScenarService.getSelectedOpponent()));
            this.landArmyGroupIcon.setWidth(80);
            this.landArmyGroupIcon.setHeight(80);

            this.landArmyGroupIcon.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //LogUtil.logInfo("click land army icon");
                    that.isLandUnitsTreeOpen = !that.isLandUnitsTreeOpen;
                    that.rebuildLandUnitsTreePanel();
                }
            });

            landArmyButtonsContainer.add(this.landArmyGroupIcon).width(80).padTop(20).height(80);

            if(this.editScenarService.getSelectedUnit() != null) {
                that.updateSelectedUnitIcon(this.editScenarService.getSelectedUnit());
                //this.selectedUnitIcon = new Image(GraphicUtil.getCounterTextureFromUnit(this.editScenarService.getSelectedUnit()));
                //this.selectedUnitIcon.setWidth(80);
                //this.selectedUnitIcon.setHeight(80);

                landArmyButtonsContainer.add(selectedUnitIcon).padLeft(20).padTop(20).width(80).height(80);
            }
            this.selectedOpponentEditPanel.add(landArmyButtonsContainer).padTop(20).colspan(2).row();

            this.rebuildLandUnitsTreePanel();
            this.selectedOpponentEditPanel.add(this.landUnitsTreePanel).width(240).pad(20).colspan(2).row();



        }
    }

    private void loadRootGroupFromFile() {
        //this.armyFileService.openLoadArmyRootFileChooser();
        this.armyFileService.openLoadArmyRootFileChooser("EDIT_SCENAR_SCREEN");
    }

    private Texture getLandArmyGroupTextureFromOpponent(Opponent selectedOpponent) {
        Texture toReturn = GraphicUtil.getEmptyTexture();
        if(this.editScenarService.getSelectedOpponent().getCountry() != CountryEnum.NO_COUNTRY) {
            try {
                if(editScenarService.getSelectedOpponent().getLandArmyGroup() != null) {
                    toReturn = GraphicUtil.getCounterTextureFromUnit((ElementInterface) editScenarService.getSelectedOpponent().getLandArmyGroup());
                }
            }
            catch (Exception e) {
                LogUtil.logError("Texture Error", e);
                //e.printStackTrace();
            }

        }
        return toReturn;
    }

/*
    private Table createOpponentsSidesListPanel() {
        Table panel = new Table();
        panel.padTop(20);
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        System.out.println("sides count : " + this.editScenarService.getScenario().getSidesCount());
        Label titleLabel =  new Label("Sides : " + this.editScenarService.getScenario().getSidesCount(), SkinUtil.getLabelSkin(100, 30));
        panel.add(titleLabel);
        return panel;
    }
 */

    private Table createRightLoadMapPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        //panel.setBounds(20, 20, 340, 150);
        //panel.setWidth(340);
        //panel.setHeight(150f);
        //panel.pad(20);
        //EditScenarScreen that = this;
        panel.pad(20);

        ButtonWrapper buttonLoadMapWrapper = new ButtonWrapper("Load Map", 0, 0, 140, 40);
        buttonLoadMapWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("click load map");
                scenarFileService.openLoadMapFileChooser();
                //if(editScenarService.getScenario().getMap().getHexesArray() != null) that.isScenarPresent = true;
                redrawMap();
            }
        });


        panel.add(buttonLoadMapWrapper.getButton()).center();
        return panel;
    }

    private Drawable getPanelTexture(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        //Drawable background = new TextureRegionDrawable(new TextureRegion(texture));
        return new TextureRegionDrawable(new TextureRegion(texture));
    }


    private void redrawMap() {
        // Dispose of the old texture and pixmap
        if (drawingTexture != null) drawingTexture.dispose();
        if (drawingMapPixmap != null) drawingMapPixmap.dispose();

        // Create a new pixmap
        drawingMapPixmap = new Pixmap(Gdx.graphics.getWidth() - 500, Gdx.graphics.getHeight() - 230, Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(GraphicUtil.backgroundColorMedium);
        drawingMapPixmap.fill();


        // Redraw the map to the pixmap
        editScenarService.getScenario().getMap().drawMap(drawingMapPixmap, this.editScenarService.getScenario().getOpponents(), editScenarService.getScenario().getObjectives(), this.editScenarService.getScenario().getMap().getHexagonSize());

        // Create a new texture from the pixmap
        drawingTexture = new Texture(drawingMapPixmap);

    }

/*
    private void drawPath() {
        if(!this.path.isEmpty()) {
            for (Hexagon hex : path ) {
                //System.out.println("path hex : i : " + hex.getX() + " : j : " + hex.getY());
                this.editScenarService.renderHex(hex.getX(), hex.getY(), GraphicUtil.redTexture, this.drawingMapPixmap);
            }
        }
    }
*/

    /**
     * Dessine le chemin en reliant les hexagones par des lignes épaisses continues
     * @param lineColor Couleur des lignes
     * @param lineWidth Épaisseur des lignes en pixels
     */
    private void drawPath(Color lineColor, int lineWidth) {
        if (this.path.isEmpty()) return;

        /*
        // Dessiner d'abord les hexagones du chemin
        for (Hexagon hex : path) {
            this.editScenarService.renderHex(hex.getX(), hex.getY(), GraphicUtil.redTexture, this.drawingMapPixmap);
        }
        */

        // ****************************************************

        // Relier les centres des hexagones par des lignes épaisses
        for (int i = 0; i < path.size() - 1; i++) {
            Hexagon current = path.get(i);
            Hexagon next = path.get(i + 1);

            int x1 = this.editScenarService.getScenario().getMap().getXFromIJ(current.getX() - editScenarService.getScenario().getMap().getStartI(), current.getY() - editScenarService.getScenario().getMap().getStartJ());
            int y1 = this.editScenarService.getScenario().getMap().getYFromJ(current.getY() - editScenarService.getScenario().getMap().getStartJ());
            int x2 = this.editScenarService.getScenario().getMap().getXFromIJ(next.getX() - editScenarService.getScenario().getMap().getStartI(), next.getY() - editScenarService.getScenario().getMap().getStartJ());
            int y2 = this.editScenarService.getScenario().getMap().getYFromJ(next.getY() - editScenarService.getScenario().getMap().getStartJ());

            GraphicUtil.drawThickLine(x1, y1, x2, y2, lineColor, lineWidth, drawingMapPixmap);
        }
    }

    /**
     * Algorithme de Bresenham modifié pour dessiner des lignes épaisses continues
     * TODO : deplace dans un util ou ailleurs
     * ajouter drawingMapPixmap en paramètre
     */
    /*
    private void drawThickLine(int x1, int y1, int x2, int y2, Color color, int width) {
        // Calculer la distance entre les points
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        // Sauvegarder la couleur actuelle
        //Color oldColor = new Color(drawingMapPixmap.getColor());
        drawingMapPixmap.setColor(color);

        while (true) {
            // Dessiner un cercle (ou un carré) autour du point pour créer l'épaisseur
            for (int w = -width/2; w <= width/2; w++) {
                for (int h = -width/2; h <= width/2; h++) {
                    if (w*w + h*h <= (width/2)*(width/2)) { // Cercle pour des bords lisses
                        drawingMapPixmap.drawPixel(x1 + w, y1 + h);
                    }
                }
            }

            if (x1 == x2 && y1 == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }

        // Restaurer la couleur précédente
        //drawingMapPixmap.setColor(oldColor);
    }
    */

    private void hideLoadMapAndDisplayScenarRightPanel(Boolean isScenarPresent) {
        this.isScenarPresent = isScenarPresent;
        //this.rightLoadMapPanel.setVisible(!isScenarPresent);
        //this.rightEditScenarPanel.setVisible(isScenarPresent);
        this.showEditScenarPanel();
    }


    private void subscribeToObservables() {
        EditScenarScreen that = this;
        if (toastObservable != null) {
            // Création d'un Observer<Toast> anonyme
            toastObservable.subscribe(new ToastObserver() {
                @Override
                public void update(Toast newValue) {
                    EditScenarScreen.this.displayToastFromObservable(newValue);
                }
            });
        }
        if (editScenarLoadMapObservable != null) {
            editScenarLoadMapObservable.subscribe(new EditScenarLoadMapObserver() {
                @Override
                public void update(Boolean newValue) {
                    //System.out.println("update observer editscenarscreen");
                    that.hideLoadMapAndDisplayScenarRightPanel(newValue);
                }
            });
        }
        if (this.unitRootGroupObservable != null) {
            // Création d'un Observer<UnitGroup> anonyme
            unitRootGroupObservable.subscribe(new UnitGroupObserver() {
                @Override
                public void update(UnitGroup newValue) {
                    EditScenarScreen.this.updateRootFromObservable(newValue);
                    that.rebuildSelectedOpponentEditPanel();
                }
            });
        }
    }

    public void updateRootFromObservable(UnitGroup newValue) {
        // TODO : tester si pays ok
        if(newValue.getCountry() == this.editScenarService.getSelectedOpponent().getCountry()) {
            //this.armyFileService.setRootLoaded(newValue); // TODO : ne sert à rien ??
            this.editScenarService.getSelectedOpponent().setLandArmyGroup(newValue);
            //UnitUtil.printGroup(newValue);
        }
        else {
            Toast.showToast(this.stage, "Bad country error !",ColorStyleEnum.WARNING , 4f);
        }
            // si oui : affecter
            // sinon ?? -> toast warning ??

    }

    public void displayToastFromObservable(Toast toast){
        toast.show(this.stage, 2f);
    }

    public void updateEditMode(EditScenarModeEnum editMode) {
        this.editMode = editMode;
        this.editModeLabel.setText("Edit Mode : " + editMode.getName());
    }

    public void updateSelectedUnitIcon(ElementInterface unit) {
        Texture unitTexture = GraphicUtil.getEmptyTexture();
        if(unit != null) {
            unitTexture = GraphicUtil.getCounterTextureFromUnit(unit);
        }
        this.selectedUnitIcon = new Image(unitTexture);
        this.selectedUnitIcon.setWidth(80);
        this.selectedUnitIcon.setHeight(80);
        //this.rebuildSelectedOpponentEditPanel();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        batch.begin();
        batch.draw(drawingTexture, 50, 180);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

    private void setBrushHexesOwnerCountry(
        int iRel, int jRel,
        int startI, int startJ,
        int limitI, int limitJ,
        Array<Array<Hexagon>> hexesArray,
        int dist,
        CountryEnum ownerCountry
    ) {
        Set<Hexagon> brushContent = MapUtil.getNeighborhoodHexesExtended(
            iRel, jRel,
            startI, startJ,
            limitI, limitJ,
            hexesArray,
            dist
        );
        Hexagon hex = hexesArray.get(iRel + startI).get(jRel + startJ);

        ownerCountry = hex.getOwnerCountry() != ownerCountry ? ownerCountry : CountryEnum.NO_COUNTRY;
        for (Hexagon h : brushContent) {
            h.setOwnerCountry(ownerCountry);
        }
    }

    private static class EditScenarScreenInputAdapter extends InputAdapter {
        private final EditScenarScreen screen; // Référence à votre écran pour accéder à ses membres

        public EditScenarScreenInputAdapter(EditScenarScreen screen) {
            this.screen = screen;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if (this.screen.isScenarPresent) {
                float mapX = this.screen.editScenarService.getScenario().getMap().getMapX();
                float mapY = this.screen.editScenarService.getScenario().getMap().getMapY();
                float mapWidth = this.screen.editScenarService.getScenario().getMap().getMapWidth();
                float mapHeight = this.screen.editScenarService.getScenario().getMap().getMapHeight();
                int margin = this.screen.editScenarService.getScenario().getMap().getMargin();
                int hexagonSize = this.screen.editScenarService.getScenario().getMap().getHexagonSize();
                int gapY = this.screen.editScenarService.getScenario().getMap().getGapY();

                //System.out.println("worldCoords.x : " + worldCoords.x + " / worldCoords.y : " + worldCoords.y);
                //System.out.println("screenX : " + screenX + " / screenY : " + screenY);
                //System.out.println("mapX : " + mapX + " / mapY" + mapY);
                int x = (int) (screenX - mapX - margin);
                int y = (int) (screenY - mapX - margin); // mapX : 50 meme valeur que le y du haut de la map
                //System.out.println("x : " + x + " / y : " + y);
                int iRel = this.screen.editScenarService.getScenario().getMap().getIFromXY(x, y);
                int jRel = this.screen.editScenarService.getScenario().getMap().getJFromY(y);
                //System.out.println("i : " + i + " / j : " + j);

                // TODO faire méthode boolean
                if (x >= 0 && x <= mapWidth - margin &&
                    y >= 0 && y <= mapHeight - margin) {
                    //System.out.println("clic in !!");

                    if(this.screen.editScenarService.getScenario().getMap().isHexInMap(iRel, jRel)) {
                        //Hexagon clickedHexagon = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + editMapService.getStartJ());
                        //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                        screen.stage.setKeyboardFocus(null);

                        int iAbs = iRel + this.screen.editScenarService.getScenario().getMap().getStartI();
                        int jAbs = jRel + this.screen.editScenarService.getScenario().getMap().getStartJ();
                        Hexagon clickedHex = this.screen.editScenarService.getScenario().getMap().getHexesArray().get(iAbs).get(jAbs);
                        boolean isHexInEdges = this.screen.editScenarService.getScenario().getMap().isHexInEdges(iAbs, jAbs);

                        if(screen.editMode == EditScenarModeEnum.NO_ACTION) {
                            this.screen.editScenarService.getScenario().getMap().renderHex( iRel + this.screen.editScenarService.getScenario().getMap().getStartI(), jRel + this.screen.editScenarService.getScenario().getMap().getStartJ(), (screen.pathStart == null || screen.pathEnd == null) ? GraphicUtil.redTexture : GraphicUtil.orangeTexture, this.screen.drawingMapPixmap);

                            if (screen.pathStart == null) {
                                screen.pathStart = this.screen.editScenarService.getScenario().getMap().getHexesArray().get(iRel + this.screen.editScenarService.getScenario().getMap().getStartI()).get(jRel + this.screen.editScenarService.getScenario().getMap().getStartJ());
                            }
                            else if (screen.pathEnd == null) {
                                screen.pathEnd = this.screen.editScenarService.getScenario().getMap().getHexesArray().get(iRel + this.screen.editScenarService.getScenario().getMap().getStartI()).get(jRel + this.screen.editScenarService.getScenario().getMap().getStartJ());

                                HexPathfinderCalculator pathfinder = new HexPathfinderCalculator(
                                    this.screen.editScenarService.getScenario().getMap().getHexesArray(),
                                    this.screen.editScenarService.getScenario().getMap().getLimitI(),
                                    this.screen.editScenarService.getScenario().getMap().getLimitJ(),
                                    this.screen.editScenarService.getScenario().getMap().getStartI(),
                                    this.screen.editScenarService.getScenario().getMap().getStartJ()
                                );
                                this.screen.path = pathfinder.findPath(
                                    this.screen.pathStart,
                                    this.screen.pathEnd,
                                    null
                                );
                                //System.out.println("path : " + this.screen.path.toString());
                                // afficher path
                                this.screen.drawPath(
                                    Color.GREEN,
                                    this.screen.editScenarService.getScenario().getMap().getZoomLevel().getPathThickness());
                            }
                            else {
                                this.screen.pathStart = null;
                                this.screen.pathEnd = null;
                                this.screen.path = new ArrayList<>();
                                this.screen.redrawMap();
                            }
                        }
                        else if(screen.editMode == EditScenarModeEnum.OWNED_HEXES) {

                            //hex.setOwnerCountry(hex.getOwnerCountry() != selectedCountry ? selectedCountry : CountryEnum.NO_COUNTRY);
                            this.screen.setBrushHexesOwnerCountry(
                                iRel, jRel,
                                this.screen.editScenarService.getScenario().getMap().getStartI(),
                                this.screen.editScenarService.getScenario().getMap().getStartJ(),
                                this.screen.editScenarService.getScenario().getMap().getLimitI(),
                                this.screen.editScenarService.getScenario().getMap().getLimitJ(),
                                this.screen.editScenarService.getScenario().getMap().getHexesArray(),
                                this.screen.editScenarService.getMapBrushSize(),
                                this.screen.editScenarService.getSelectedOpponent().getCountry()
                            );
                            this.screen.redrawMap();
                        }
                        else if(screen.editMode == EditScenarModeEnum.EDGES_HEXES) {
                            // si hex cliqué sur un bord alors ajout de l'hex au set des edgesHexes de l'opponent
                            /*
                            boolean isHexInEdges = iAbs == 0
                                || jAbs == 0
                                || iAbs == this.screen.editScenarService.getScenario().getMap().getLimitI() - 1
                                || jAbs == this.screen.editScenarService.getScenario().getMap().getLimitJ() - 1;

                             */
                            //boolean isHexInEdges = this.screen.editScenarService.getScenario().getMap().isHexInEdges(iAbs, jAbs);
                            if(isHexInEdges) {
                                //LogUtil.logInfo("Click in edges !!");
                                if(!this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().contains(clickedHex)) {
                                    this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().add(clickedHex);
                                    //LogUtil.logInfo("getBorderHexesOwned size : " + this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().size());
                                }
                                else {
                                    this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().remove(clickedHex);
                                }
                                this.screen.redrawMap();
                            }

                        }
                        else if(screen.editMode == EditScenarModeEnum.REINF_HEXES) {
                            /*
                            boolean isHexInEdges = iAbs == 0
                                || jAbs == 0
                                || iAbs == this.screen.editScenarService.getScenario().getMap().getLimitI() - 1
                                || jAbs == this.screen.editScenarService.getScenario().getMap().getLimitJ() - 1;

                             */
                            //boolean isHexInEdges = this.screen.editScenarService.getScenario().getMap().isHexInEdges(iAbs, jAbs);
                            if(isHexInEdges && this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().contains(clickedHex)) {
                                //LogUtil.logInfo("Click in edges !!");
                                if (!this.screen.editScenarService.getSelectedOpponent().getReinfHexesSource().contains(clickedHex)) {
                                    this.screen.editScenarService.getSelectedOpponent().getReinfHexesSource().add(clickedHex);
                                    //LogUtil.logInfo("getReinfHexesSource size : " + this.screen.editScenarService.getSelectedOpponent().getReinfHexesSource().size());
                                }
                                else {
                                    this.screen.editScenarService.getSelectedOpponent().getReinfHexesSource().remove(clickedHex);
                                }
                            }
                            this.screen.redrawMap();
                        }
                        else if(screen.editMode == EditScenarModeEnum.SUPPLY_HEXES
                        ) {
                            /*
                            boolean isHexInEdges = iAbs == 0
                                || jAbs == 0
                                || iAbs == this.screen.editScenarService.getScenario().getMap().getLimitI() - 1
                                || jAbs == this.screen.editScenarService.getScenario().getMap().getLimitJ() - 1;

                             */
                            //boolean isHexInEdges = this.screen.editScenarService.getScenario().getMap().isHexInEdges(iAbs, jAbs);
                            if(isHexInEdges && this.screen.editScenarService.getSelectedOpponent().getBorderHexesOwned().contains(clickedHex)) {
                                //LogUtil.logInfo("Click in edges !!");
                                if (!this.screen.editScenarService.getSelectedOpponent().getSupplyHexesSource().contains(clickedHex)) {
                                    this.screen.editScenarService.getSelectedOpponent().getSupplyHexesSource().add(clickedHex);
                                    //LogUtil.logInfo("getSupplyHexesSource size : " + this.screen.editScenarService.getSelectedOpponent().getSupplyHexesSource().size());
                                }
                                else {
                                    this.screen.editScenarService.getSelectedOpponent().getSupplyHexesSource().remove(clickedHex);
                                }
                            }

                            this.screen.redrawMap();
                        }
                        else if(screen.editMode == EditScenarModeEnum.DEPLOY_UNITS) {
                            //Hexagon hex = screen.editScenarService.getScenario().getMap().getHexesArray().get(iAbs).get(jAbs);
                            boolean isHexInOwnedHexes = clickedHex.getOwnerCountry() == screen.editScenarService.getSelectedOpponent().getCountry();
                            if(screen.editScenarService.getSelectedUnit() != null && isHexInOwnedHexes) {
                                //LogUtil.logInfo("selected unit not null");


                                clickedHex.getUnits().addUnitToUnits(screen.editScenarService.getSelectedUnit());

                                OnBoardUnit onBoardUnit = new OnBoardUnit(screen.editScenarService.getSelectedUnit(), iAbs, jAbs);
                                this.screen.editScenarService.getSelectedOpponent().getDeployedUnits().add(onBoardUnit);

                                this.screen.redrawMap();
                                this.screen.updateEditMode(EditScenarModeEnum.NO_ACTION);
                                this.screen.editScenarService.setSelectedUnit(null);
                                this.screen.updateSelectedUnitIcon(null);

                                //this.screen.rebuildLandUnitsTreePanel();

                                this.screen.rebuildSelectedOpponentEditPanel();

                                //this.screen.editMode = EditScenarModeEnum.NO_ACTION;
                                //this.screen.editModeLabel.setText("Edit Mode : " + this.screen.editMode.getName());
                            }
                        }
                        else if(screen.editMode == EditScenarModeEnum.SET_OBJECTIVES) {
                            //Array<MapObjective> objectives = screen.editScenarService.getScenario().getObjectives();

                            boolean isHexInObjectives = screen.editScenarService.getScenario().isHexInObjectives(clickedHex);

                            if(screen.editScenarService.getSelectedObjective() != null) {
                                boolean isHexInSelectedObjective = screen.editScenarService.getSelectedObjective().isHexInHexagons(clickedHex);
                                if(!isHexInSelectedObjective) {
                                    if(!isHexInObjectives) {
                                        screen.editScenarService.getSelectedObjective().addHexagon(clickedHex);
                                    }
                                }
                                else {
                                    screen.editScenarService.getSelectedObjective().removeHexagon(clickedHex);
                                }
                            }

                            /*
                            if(isHexInObjectives) {
                                LogUtil.logInfo("in objectives");

                                if(screen.editScenarService.getScenario().getMapObjectiveFromHex(clickedHex) != null) {
                                    screen.editScenarService.getScenario().getMapObjectiveFromHex(clickedHex).getHexagons().removeValue(clickedHex, false);
                                }
                            }
                            else {
                                LogUtil.logInfo("not in objectives");
                                Array<Hexagon> newHexagons = new Array<>();
                                newHexagons.add(clickedHex);
                                MapObjective newObjective = new MapObjective("Test", "TEST", 1000, 10, 500, newHexagons);
                                objectives.add(newObjective);
                            }
                             */

                            this.screen.redrawMap();
                        }

                        /*
                        this.screen.editScenarService.renderHex( i + this.screen.editScenarService.getStartI(), j + this.screen.editScenarService.getStartJ(), GraphicUtil.redTexture, this.screen.drawingMapPixmap);
                         */
                        this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return this.screen.stage.touchUp(screenX, screenY, pointer, button);
        }

        @Override
        public boolean keyDown(int keycode) {
            int delta = this.screen.editScenarService.getScenario().getMap().getZoomLevel().getDeltaKey();

            //System.out.println("keycode : " + keycode);
            switch (keycode) {
                case Input.Keys.LEFT:
                    this.screen.editScenarService.getScenario().getMap().setStartI(this.screen.editScenarService.getScenario().getMap().getStartI() - delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.RIGHT:
                    this.screen.editScenarService.getScenario().getMap().setStartI(this.screen.editScenarService.getScenario().getMap().getStartI() + delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.UP:
                    this.screen.editScenarService.getScenario().getMap().setStartJ(this.screen.editScenarService.getScenario().getMap().getStartJ() - delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.DOWN:
                    this.screen.editScenarService.getScenario().getMap().setStartJ(this.screen.editScenarService.getScenario().getMap().getStartJ() + delta);
                    this.screen.redrawMap();
                    break;
                case 157: //Input.Keys.PLUS
                    //System.out.println("+ key");
                    switch (this.screen.editScenarService.getScenario().getMap().getZoomLevel()) {
                        case CLOSE_VIEW :
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.CLOSE_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                    }
                    break;
                case 156: //Input.Keys.MINUS
                    //System.out.println("- key");
                    switch (this.screen.editScenarService.getScenario().getMap().getZoomLevel()) {
                        case CLOSE_VIEW :
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.VERY_DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            break;
                    }
                    break;
                case 154 :
                    this.screen.editScenarService.setMapBrushSize(
                        this.screen.editScenarService.getMapBrushSize() > MapConfig.MAX_BRUSH_SIZE - 1 ? MapConfig.MAX_BRUSH_SIZE : this.screen.editScenarService.getMapBrushSize() + 1
                    );
                    this.screen.rebuildSelectedOpponentEditPanel();
                    break;
                case 155:
                    this.screen.editScenarService.setMapBrushSize(
                        this.screen.editScenarService.getMapBrushSize() < MapConfig.MIN_BRUSH_SIZE + 1 ? MapConfig.MIN_BRUSH_SIZE : this.screen.editScenarService.getMapBrushSize() - 1
                    );
                    this.screen.rebuildSelectedOpponentEditPanel();
                    break;
                default:
                    return false;
                    //break;
                    //System.out.println("Autre touche appuyée");
            }
            return true; // Retourne true pour indiquer que l'événement a été traité
        }

        @Override
        public boolean scrolled(float amountX, float amountY) {
            // Récupérer la position de la souris
            int mouseX = Gdx.input.getX();
            int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY(); // Conversion coordonnées LibGDX

            // Vérifier si la souris est au-dessus du ScrollPane
            if (mouseX >= this.screen.rightScrollPane.getX() &&
                mouseX <= this.screen.rightScrollPane.getX() + this.screen.rightScrollPane.getWidth() &&
                mouseY >= this.screen.rightScrollPane.getY() &&
                mouseY <= this.screen.rightScrollPane.getY() + this.screen.rightScrollPane.getHeight()) {
                return false; // Laisser le ScrollPane gérer l'événement
            }
            else {
                // amountY est la valeur de défilement de la molette de la souris
                // > 0 signifie que la molette est déplacée vers le bas
                // < 0 signifie que la molette est déplacée vers le haut
                //System.out.println("molette !!");
                if (amountY > 0) {
                    // La molette est déplacée vers le bas
                    //System.out.println("molette dezoom");

                    switch (this.screen.editScenarService.getScenario().getMap().getZoomLevel()) {
                        case CLOSE_VIEW :
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.VERY_DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            break;
                    }
                } else if (amountY < 0) {
                    // La molette est déplacée vers le haut
                    //System.out.println("molette zoom");

                    switch (this.screen.editScenarService.getScenario().getMap().getZoomLevel()) {
                        case CLOSE_VIEW :
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.CLOSE_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            this.screen.editScenarService.getScenario().getMap().setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.getScenario().getMap().initMapFromZoomWrapper();
                            this.screen.redrawMap();
                            break;
                    }
                }
                return true; // ou false si vous ne voulez pas consommer l'événement
            }
        }

    }
}
