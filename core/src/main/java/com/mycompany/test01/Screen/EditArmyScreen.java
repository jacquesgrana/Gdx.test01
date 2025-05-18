package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.ElementSelectorType;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Interface.Observer;
import com.mycompany.test01.Interface.ToastObserver;
import com.mycompany.test01.Interface.UnitGroupObserver;
import com.mycompany.test01.Main;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Serializer.UnitElementSerializer;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;
import com.mycompany.test01.Util.UnitUtil;

import java.util.Arrays;
import java.util.Objects;


public class EditArmyScreen implements Screen, InputProcessor { //, Observer<UnitGroup>
    final Main game;
    private final Stage stage;
    private final BitmapFont font;
    //private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Table leftPanel, centerPanel, rightPanel, centerButtonPanel, rightSelectPanel, leftCreateRootPanel;
    private final ScrollPane leftScrollPane;
    private Tree<UnitNode, String> tree;

    private UnitElement selectedUnit;
    private CountryEnum selectedCountry;
    private FrontGroup rootGroup;
    private boolean isTreeRootNodeDefined; // TODO finir

    // TODO List<UnitTypeEnum> allValuesList = Stream.of(UnitTypeEnum.values()).collect(Collectors.toList());
    private ElementSelectorType[] unitSelectorList;
    //private String selectedUnitName = "nothing selected";
    private final Label selectedUnitNameLabel;
    private final Label selectedUnitTypeLabel;
    private final Label selectedUnitAcronymLabel;
    private final Label selectedUnitParentNameLabel;

    //private final Label selectedCountryLabel;
    private final Image selectedUnitIcon;

    private final ArmyFileService armyFileService;

    private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;
    //private final Table centerButtonPanel;

    //private final UnitRedCountryFactory unitRedCountryFactory;
    //private final UnitBlackCountryFactory unitBlackCountryFactory;
    //private final UnitBlueCountryFactory unitBlueCountryFactory;
    //private final UnitBrownCountryFactory unitBrownCountryFactory;

    private ButtonWrapper buttonDeleteWrapper = null;
    private ButtonWrapper buttonAddWrapper = null;
    private ButtonWrapper buttonSaveAllWrapper = null;
    private ButtonWrapper buttonLoadAllWrapper = null;
    private ButtonWrapper buttonAddGroupWrapper = null;
    private ButtonWrapper buttonSaveGroupWrapper = null;


    private SelectBox<ElementSelectorType> selectUnitBox;
    //private SelectBox<CountryEnum> selectCountryBox;


    private final Skin unitTreeSkin;

    private final UnitElementSerializer unitElementSerializer;

    //private Skin skin;

    /*
    class Node extends Tree.Node<Node, String, TextButton> {
        public Node (String text) {
            super(new TextButton(text, GraphicUtil.getButtonSkin(30,30)));
            setValue(text);
        }
    }
*/
    public EditArmyScreen(Main game) {
        //this.unitRedCountryFactory = new UnitRedCountryFactory();
        //this.unitBlackCountryFactory = new UnitBlackCountryFactory();
        //this.unitBlueCountryFactory = new UnitBlueCountryFactory();
        //this.unitBrownCountryFactory = new UnitBrownCountryFactory();
        this.unitElementSerializer = new UnitElementSerializer();
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        //shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);

        this.font = new BitmapFont();
        this.selectedUnit = null;
        this.isTreeRootNodeDefined = false;
        this.selectedCountry = CountryEnum.NO_COUNTRY;
        this.armyFileService = ArmyFileService.getInstance();
        this.armyFileService.setSelectedUnit(this.selectedUnit);

        // *******************************************************

        //this.unitGroupObservable = new UnitGroupObservable();
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();

        this.subscribeToObservables();

        //this.unitRootGroupObservable.subscribe(this);

        // *******************************************************

        //this.selectedCountryLabel = new Label(getSelectedCountry().toString(), SkinUtil.getLabelSkin(200, 30));

        this.unitSelectorList = new ElementSelectorType[(int) Arrays.stream(ElementSelectorType.values()).count()]; // TODO 100?

        this.unitTreeSkin = SkinUtil.getUnitTreeSkin();
        /*
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto_Condensed-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + "•";
        font = generator.generateFont(parameter);
        generator.dispose();*/

        //this.skin = GraphicUtil.getButtonSkin(10, 10);
        //Tree<Label, String> tree = new Tree<>(skin);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Army", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            20, 200, 50);

        buttonBackWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        this.stage.addActor(buttonBackWrapper.getButton());

        this.leftPanel = createPanel(0);
        //scrollPaneSkin = SkinUtil.getScrollPaneSkin(200, 300);
        this.stage.addActor(this.leftPanel);
        this.leftPanel.setVisible(true);

        this.centerPanel = createPanel(1);
        this.stage.addActor(this.centerPanel);
        this.centerPanel.setVisible(true);

        this.rightPanel = createPanel(2);
        this.stage.addActor(this.rightPanel);
        this.rightPanel.setVisible(true);

        this.leftCreateRootPanel = createLeftCreateRootPanel();
        this.leftPanel.addActor(leftCreateRootPanel);

        this.centerButtonPanel = createCenterButtonPanel();
        this.centerButtonPanel.setVisible(true);

        this.centerPanel.addActor(this.centerButtonPanel);

        //Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        selectedUnitNameLabel = new Label("nothing selected", labelStyle);
        selectedUnitNameLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitNameLabel.getHeight() - 20f);
        this.centerPanel.addActor(selectedUnitNameLabel);


        selectedUnitTypeLabel = new Label("nothing selected", labelStyle);
        selectedUnitTypeLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 60f);
        this.centerPanel.addActor(selectedUnitTypeLabel);

        selectedUnitAcronymLabel = new Label("nothing selected", labelStyle);
        selectedUnitAcronymLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 100f);
        this.centerPanel.addActor(selectedUnitAcronymLabel);

        selectedUnitParentNameLabel = new Label("nothing selected", labelStyle);
        selectedUnitParentNameLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 140f);
        this.centerPanel.addActor(selectedUnitParentNameLabel);

        selectedUnitIcon = new Image(GraphicUtil.getEmptyTexture());
        selectedUnitIcon.setBounds(centerPanel.getWidth() - 128f - 20f,
            centerPanel.getHeight() - 128f - 20f,
            128f,
            128f);
        this.centerPanel.addActor(selectedUnitIcon);

        this.initTree(); // TODO : laisser ?
        //this.fillTree();
        this.leftScrollPane = createLeftScrollPane();
        this.leftPanel.addActor(this.leftScrollPane);
        this.updateLeftPanelFromBoolean();

        this.rightSelectPanel = createRightSelectPanel();
        this.rightSelectPanel.setVisible(false); // à modifier qd tt sera ok
        this.rightPanel.addActor(rightSelectPanel);
    }


    private void updateLeftPanelFromBoolean() {
        leftScrollPane.setVisible(this.isTreeRootNodeDefined);
        leftCreateRootPanel.setVisible(!this.isTreeRootNodeDefined);
    }

    private void resetSelectedUnit() {
        this.selectedUnit = null;
        this.armyFileService.setSelectedUnit(this.selectedUnit);

        //"nothing selected"
        selectedUnitNameLabel.setText("nothing selected");
        selectedUnitTypeLabel.setText("nothing selected");
        selectedUnitAcronymLabel.setText("nothing selected");
        selectedUnitParentNameLabel.setText("nothing selected");
        selectedUnitIcon.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getEmptyTexture())));

        this.buttonDeleteWrapper.getButton().setDisabled(true);
        this.buttonAddWrapper.getButton().setDisabled(true);
        this.buttonAddGroupWrapper.getButton().setDisabled(true);
        this.buttonSaveAllWrapper.getButton().setDisabled(rootGroup == null || rootGroup.getUnits().size == 0);
        this.buttonSaveGroupWrapper.getButton().setDisabled(true);
        /*
        if(rootGroup != null) {
            this.buttonSaveAllWrapper.getButton().setDisabled(rootGroup.getUnits().size == 0);
        }
        else {
            this.buttonSaveAllWrapper.getButton().setDisabled(true);
        }*/

        this.buttonLoadAllWrapper.getButton().setDisabled(false);
    }

    private void addListenerToRootTreeNode() {
        EditArmyScreen that = this;
        tree.getRootNodes().get(0).getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("click on root");
                that.displayUnitInfos(that.rootGroup);
                //tree.getRootNodes().get(0).setExpanded(!tree.getRootNodes().get(0).isExpanded());
            }
        });
    }

    public void initTree() {
        this.tree = new Tree<>(unitTreeSkin);
        //tree.setStyle(unitTreeSkin.get("default", Tree.TreeStyle.class));
        tree.setPadding(10);
        tree.setIndentSpacing(30);
        tree.setIconSpacing(10, 20);
        tree.setPosition(100, Gdx.graphics.getHeight() - 100f, 1);
        float rectWidth = (Gdx.graphics.getWidth() - (3 + 1) * 50f) / 3;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        tree.setBounds(0f, -20f, rectWidth, rectHeight);
    }

    /*
    public void setRootNode() {
        UnitNode rootNode = GraphicUtil.createTreeFromGroup(rootGroup, this);
    }
    */

    private void updateTreeFromRoot() {
        //tree.clear(); // TODO : fait perdre le style !!!!!!!!!!!!!!!
        UnitNode rootNode = GraphicUtil.createTreeFromGroup(rootGroup, this);
        tree.add(rootNode);
        tree.expandAll();
        addListenerToRootTreeNode();
        tree.invalidateHierarchy();
    }

    public void displayUnitInfos(ElementInterface element) {
        //this.selectedUnitName = name;
        this.selectedUnit = (UnitElement) element;
        this.armyFileService.setSelectedUnit(this.selectedUnit);

        // TODO if inutiles ?!!
        if (selectedUnitNameLabel != null) {
            selectedUnitNameLabel.setText("Name : " + this.selectedUnit.getName());
        }
        if (selectedUnitTypeLabel != null) {
            selectedUnitTypeLabel.setText("Type : " + this.selectedUnit.getType().toString());
        }
        //selectedUnitAcronymLabel
        if (selectedUnitAcronymLabel != null) {
            selectedUnitAcronymLabel.setText("Acronym : " + this.selectedUnit.getAcronym());
        }

        if (selectedUnitParentNameLabel != null ) {
            if(this.selectedUnit.getParent() != null) {
                selectedUnitParentNameLabel.setText("Parent Name : " + this.selectedUnit.getParent().getName());
            }
            else {
                selectedUnitParentNameLabel.setText("Parent Name : Root");
            }
        }
        Texture counterTexture = GraphicUtil.getCounterTextureFromUnit(this.selectedUnit);
        //System.out.println("texture : " + counterTexture);
        if (selectedUnitIcon != null) {
            selectedUnitIcon.setDrawable(new TextureRegionDrawable(counterTexture));
        }
        this.buttonDeleteWrapper.getButton().setDisabled(false);
        this.buttonAddWrapper.getButton().setDisabled(!(element instanceof UnitGroup));
        this.buttonAddGroupWrapper.getButton().setDisabled(!(element instanceof UnitGroup));
        // TODO simplifier en une seule ligne
        if((element instanceof UnitGroup) && (!element.equals(rootGroup))) {
            UnitGroup unitGroup = (UnitGroup) element;
            this.buttonSaveGroupWrapper.getButton().setDisabled(unitGroup.getUnits().size <= 0);
        }
        else {
            this.buttonSaveGroupWrapper.getButton().setDisabled(true);
        }
        this.rightSelectPanel.setVisible(false);
        // TODO valider ?? --> oui ??
        /*
        if (element instanceof UnitGroup) {
            this.setSelectedCountry(element.getCountry());
            //this.selectedCountryLabel.setText(this.getSelectedCountry().toString());
            //this.selectCountryBox.setSelected(this.getSelectedCountry());
            //this.selectedCountryLabel.setText(this.getSelectedCountry().toString());
        }
        */

        //System.out.println("nom : " + element.getName());
    }

    private Table createPanel(int columnNumber) {
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x = spacing + columnNumber * (spacing + rectWidth);
        Table panel = new Table();
        panel.defaults().pad(3);
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorMedium);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));
        //texture.dispose();
        //panel.setPosition(x, 100f);
        panel.setBounds(x, 100f, rectWidth, rectHeight);
        panel.setBackground(background);

        return panel;
    }

    private Table createLeftCreateRootPanel() {
        Table panel = new Table();
        panel.defaults().pad(1);
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorLight);
        pixmap.fill();
        EditArmyScreen that = this;

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));

        panel.setBounds(50f, Gdx.graphics.getHeight() - 500f, (Gdx.graphics.getWidth() - 200f) / 3 - 100f, 260f);

        panel.setBackground(background);

        Label selectedRootCountryLabel = new Label(getSelectedCountry().toString(), SkinUtil.getLabelSkin(200, 30));

        SelectBox<CountryEnum> selectRootCountryBox = new SelectBox<>(SkinUtil.getSelectorSkin(150, 30));
        selectRootCountryBox.setItems(
            CountryEnum.BLACK_COUNTRY,
            CountryEnum.BLUE_COUNTRY,
            CountryEnum.BROWN_COUNTRY,
            //CountryEnum.GREEN_COUNTRY,
            CountryEnum.RED_COUNTRY
            //CountryEnum.YELLOW_COUNTRY,
        );
        // Création du label qui sera mis à jour
        //final Label countryLabel = new Label(getSelectedCountry().toString(), GraphicUtil.getLabelSkin(200, 30));

        // Ajout du listener pour gérer l'événement de sélection
        selectRootCountryBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                setSelectedCountry(selectRootCountryBox.getSelected());
                //System.out.println("selected country : " + selectCountryBox.getSelected());
                selectedRootCountryLabel.setText(that.getSelectedCountry().toString());
            }
        });
        selectedRootCountryLabel.setPosition(20, 100);
        panel.add(selectRootCountryBox).width(150);
        panel.add(selectedRootCountryLabel).width(200);
        panel.row();

        // Création des labels et champs de saisie
        Label nameLabel = new Label("Name:", SkinUtil.getLabelSkin(150, 30));
        TextField nameField = new TextField("", SkinUtil.getTextFieldSkin(150, 30));

        Label acronymLabel = new Label("Acronym:", SkinUtil.getLabelSkin(150, 30));
        TextField acronymField = new TextField("", SkinUtil.getTextFieldSkin(150, 30));

        // Création de la table
        panel.add(nameLabel).padRight(10);
        panel.add(nameField).width(150).padBottom(5);
        panel.row();
        panel.add(acronymLabel).padRight(10);
        panel.add(acronymField).width(150);

        // Création du skin pour les CheckBox
        Skin checkBoxSkin = SkinUtil.getCheckBoxSkin(24);

        // Création des cases à cocher
        CheckBox isEliteCheckBox = new CheckBox(" Elite", checkBoxSkin);
        //CheckBox isCompanyCheckBox = new CheckBox(" Company", checkBoxSkin);

        // Ajout à la table (par exemple, sous les champs de saisie)
        panel.row().padTop(10);
        panel.add(isEliteCheckBox).center().colspan(2);

        ButtonWrapper buttonValidateWrapper = new ButtonWrapper(
            "Add Front Group",
            20,
            20, 150, 50);
        buttonValidateWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                //System.out.println("click validate add unit");

                if(
                    !nameField.getText().isEmpty()
                        && !acronymField.getText().isEmpty()
                        && !selectedRootCountryLabel.getText().toString().equals(CountryEnum.NO_COUNTRY.toString())
                ) {
                    System.out.println("unitType, nameField and acronymField ok !!");
                    String unitName = nameField.getText();
                    String unitAcronym = acronymField.getText();
                    boolean isUnitElite = isEliteCheckBox.isChecked();
                    //boolean isUnitCompany = isCompanyCheckBox.isChecked();
                    CountryEnum unitCountry = that.getSelectedCountry();
                    // TODO faire méthode qui gère l'ajout dans le tree et qui appelle une librairie pour la création de l'unité avec les paramètres
                    that.getAndAddNewRootUnitInTree(unitName, unitAcronym, isUnitElite, unitCountry);
                }

            }
        });

        panel.addActor(buttonValidateWrapper.getButton());
        panel.row();
        return panel;
    }

    private Table createRightSelectPanel() {
        Table panel = new Table();
        panel.defaults().pad(2);

        // TODO faire méthode ?
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorLight);
        pixmap.fill();
        EditArmyScreen that = this;

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));

        panel.setBounds(50f, Gdx.graphics.getHeight() - 500f, (Gdx.graphics.getWidth() - 200f) / 3 - 100f, 300f);

        panel.setBackground(background);

        // TODO (améliorer : set le pays à la création du FrontGroup racine)
        //this.selectCountryBox = new SelectBox<>(SkinUtil.getSelectorSkin(150, 30));
        /*
        this.selectCountryBox.setItems(
            CountryEnum.BLACK_COUNTRY,
            CountryEnum.BLUE_COUNTRY,
            CountryEnum.BROWN_COUNTRY,
            //CountryEnum.GREEN_COUNTRY,
            CountryEnum.RED_COUNTRY
            //CountryEnum.YELLOW_COUNTRY,
            );
            */
        // Création du label qui sera mis à jour
        //final Label countryLabel = new Label(getSelectedCountry().toString(), GraphicUtil.getLabelSkin(200, 30));

        // Ajout du listener pour gérer l'événement de sélection
        /*
        this.selectCountryBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                setSelectedCountry(selectCountryBox.getSelected());
                //System.out.println("selected country : " + selectCountryBox.getSelected());
                that.selectedCountryLabel.setText(that.getSelectedCountry().toString());
            }
        });
        */

        //panel.add(selectCountryBox).width(150);
        //panel.add(selectedCountryLabel).width(200);
        panel.row();

        // TODO ajouter un sélecteur pour choisir l'unité
        this.selectUnitBox = new SelectBox<>(SkinUtil.getSelectorSkin(200, 30));
        //this.selectCountryBox = new SelectBox<>(GraphicUtil.getSelectorSkin(150, 30));

        /*
        Array<ElementSelectorType> gdxArray = new Array<>(ElementSelectorType.values());
        selectUnitBox.setItems(gdxArray);
         */

        /*
        System.out.println("selected country : " + getSelectedCountry());
        // Filtrer avec Stream API
        ElementSelectorType[] filteredTypes = Arrays.stream(ElementSelectorType.values())
            .filter(type -> type.getCountry().equals(CountryEnum.NO_COUNTRY) ||
                type.getCountry().equals(getSelectedCountry()))
            .toArray(ElementSelectorType[]::new);

        // Convertir en Array de libGDX
        Array<ElementSelectorType> gdxArray = new Array<>(filteredTypes);
        selectUnitBox.setItems(gdxArray);
        */
        this.updateUnitSelectorList(); // TODO vérifier si utile

        final Label unitTypeLabel = new Label("Nothing Selected", SkinUtil.getLabelSkin(200, 30));
        this.selectUnitBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //setSelectedCountry();
                unitTypeLabel.setText(selectUnitBox.getSelected().toString());
            }
        });


        panel.add(selectUnitBox).width(150);
        panel.add(unitTypeLabel).width(200);
        panel.row();

        SelectBox<Integer> selectRegRankBox = new SelectBox<Integer>(SkinUtil.getSelectorSkin(200, 30));
        final Label unitRegRankLabel = new Label("0", SkinUtil.getLabelSkin(200, 30));

        selectRegRankBox.setItems(0, 1, 2, 3, 4, 5);
        selectRegRankBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //setSelectedCountry();
                unitRegRankLabel.setText(selectRegRankBox.getSelected());
            }
        });

        panel.add(selectRegRankBox).width(150);
        panel.add(unitRegRankLabel).width(200);
        panel.row();

        // Création des labels et champs de saisie
        Label nameLabel = new Label("Name:", SkinUtil.getLabelSkin(150, 30));
        TextField nameField = new TextField("", SkinUtil.getTextFieldSkin(150, 30));

        Label acronymLabel = new Label("Acronym:", SkinUtil.getLabelSkin(150, 30));
        TextField acronymField = new TextField("", SkinUtil.getTextFieldSkin(150, 30));

        // Création de la table
        panel.add(nameLabel).padRight(10);
        panel.add(nameField).width(150).padBottom(5);
        panel.row();
        panel.add(acronymLabel).padRight(10);
        panel.add(acronymField).width(150);

        // Création du skin pour les CheckBox
        Skin checkBoxSkin = SkinUtil.getCheckBoxSkin(24);

        // Création des cases à cocher
        CheckBox isEliteCheckBox = new CheckBox(" Elite", checkBoxSkin);
        //CheckBox isCompanyCheckBox = new CheckBox(" Company", checkBoxSkin);

        // Ajout à la table (par exemple, sous les champs de saisie)
        panel.row().padTop(10);
        panel.add(isEliteCheckBox).center().colspan(2);

        //panel.add(isCompanyCheckBox).left().colspan(2);

        ButtonWrapper buttonValidateWrapper = new ButtonWrapper(
            "Validate",
            0,
            0, 150, 50);
        buttonValidateWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click validate add unit");
                if(
                    !nameField.getText().isEmpty()
                        && !acronymField.getText().isEmpty()
                        && !Objects.equals(unitTypeLabel.getText().toString(), "Nothing Selected")
                ) {
                    System.out.println("unitType, nameField and acronymField ok !!");
                    String unitName = nameField.getText();
                    String unitAcronym = acronymField.getText();
                    boolean isUnitElite = isEliteCheckBox.isChecked();
                    //boolean isUnitCompany = isCompanyCheckBox.isChecked();
                    CountryEnum unitCountry = that.getSelectedCountry();
                    ElementSelectorType unitType = selectUnitBox.getSelected();
                    int unitRegRank = (int) selectRegRankBox.getSelected();
                    that.getAndAddNewUnitInTree(unitName, unitAcronym, isUnitElite, unitCountry, unitType, unitRegRank);
                    that.rightSelectPanel.setVisible(false);
                }
            }
        });

        panel.row().padTop(10);
        panel.add(buttonValidateWrapper.getButton());
        return panel;
    }

    private ScrollPane createLeftScrollPane()
    {   float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        //float padding = 50f;
        //float width = (Gdx.graphics.getWidth() - 200f) / 3 - 2 * padding;
        ScrollPane leftScrollPane = new ScrollPane(tree, SkinUtil.getScrollPaneSkin((int) rectWidth, (int) rectHeight));
        leftScrollPane.setBounds(0f, 0f, rectWidth, rectHeight);

        return leftScrollPane;
    }

    private Table createCenterButtonPanel() {
        float padding = 20f;
        Table panel = new Table();
        //panel.defaults().pad(2);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorLight);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));

        panel.setBounds(padding, Gdx.graphics.getHeight() - 510f, (Gdx.graphics.getWidth() - 200f) / 3 - 2 * padding, 170);

        panel.setBackground(background);

        //buttonSaveAllWrapper
        this.buttonDeleteWrapper = new ButtonWrapper(
            "Delete Unit",
            20,
            90, 150, 50);
        EditArmyScreen that = this;

        this.buttonDeleteWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                System.out.println("click delete unit");
                if(selectedUnit != null) {

                    //tree.clear();
                    //tree.add(GraphicUtil.createTreeFromGroup(rootGroup, that));

                    //that.tree.updateRootNodes();
                    that.removeSelectedUnitAndUpdateTree();
                }
            }
        });
        this.buttonDeleteWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonDeleteWrapper.getButton());

        this.buttonAddWrapper = new ButtonWrapper(
            "Add Unit",
            190,
            90, 150, 50);

        //EditArmyScreen that = this;
        this.buttonAddWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click add unit");
                //if (selectedUnit instanceof )
                that.rightSelectPanel.setVisible(true); // à modifier qd tt sera ok
                that.updateUnitSelectorList();
            }
        });
        this.buttonAddWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonAddWrapper.getButton());


        this.buttonAddGroupWrapper = new ButtonWrapper(
            "Add Group",
            360,
            90, 150, 50);

        //EditArmyScreen that = this;
        this.buttonAddGroupWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click add group");
                that.loadArmyGroupFromFile();
            }
        });
        this.buttonAddGroupWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonAddGroupWrapper.getButton());



        panel.row();


        this.buttonLoadAllWrapper = new ButtonWrapper(
            "Load All",
            20,
            20, 150, 50);

        //EditArmyScreen that = this;
        this.buttonLoadAllWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click load all");
                //if (selectedUnit instanceof )
                that.loadRootGroupFromFile();

            }
        });
        //this.buttonLoadAllWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonLoadAllWrapper.getButton());

        this.buttonSaveAllWrapper = new ButtonWrapper(
            "Save All",
            190,
            20, 150, 50);

        //EditArmyScreen that = this;
        this.buttonSaveAllWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click save all");
                //if (selectedUnit instanceof )
                that.saveRootGroupToFile();

            }
        });
        this.buttonSaveAllWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonSaveAllWrapper.getButton());

        this.buttonSaveGroupWrapper = new ButtonWrapper(
            "Save Group",
            360,
            20, 150, 50);

        //EditArmyScreen that = this;
        this.buttonSaveGroupWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click save group");
                //if (selectedUnit instanceof )
                //that.saveRootGroupToFile();
                that.saveArmyGroupToFile();
            }
        });
        this.buttonSaveGroupWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonSaveGroupWrapper.getButton());

        //buttonSaveGroupWrapper

        return panel;
    }

    private void saveArmyGroupToFile() {
        armyFileService.setSelectedUnit(this.selectedUnit);
        armyFileService.openSaveArmyGroupFileChooser();
    }

    private void saveRootGroupToFile() {
        // TODO utiliser le file chooser de FileService

        //String jsonData = this.unitElementSerializer.serialize(rootGroup);
        //this.unitElementSerializer.saveJsonStringToFile(jsonData, "test.json");

        // set le rootGroup du service
        armyFileService.setRootToSave(rootGroup);
        armyFileService.openSaveArmyRootFileChooser();
    }

    private void loadRootGroupFromFile() {
        armyFileService.openLoadArmyRootFileChooser();
    }

    private void loadArmyGroupFromFile() {
        armyFileService.openLoadArmyGroupFileChooser();
    }

    private void subscribeToObservables() {
        if (this.unitRootGroupObservable != null) {
            // Création d'un Observer<UnitGroup> anonyme
            unitRootGroupObservable.subscribe(new UnitGroupObserver() {
                @Override
                public void update(UnitGroup newValue) {
                    EditArmyScreen.this.updateRootFromObservable(newValue);
                }
            });
            // Alternativement, si vous voulez utiliser UnitGroupObserver (s'il existe et est une interface fonctionnelle ou que vous l'implémentez ici)
            // unitGroupObservable.subscribe(new UnitGroupObserver() {
            //     @Override
            //     public void update(UnitGroup newValue) {
            //         EditArmyScreen.this.handleUnitGroupUpdate(newValue);
            //     }
            // });
        }

        if (toastObservable != null) {
            // Création d'un Observer<Toast> anonyme
            toastObservable.subscribe(new ToastObserver() {
                @Override
                public void update(Toast newValue) {
                    EditArmyScreen.this.displayToastFromObservable(newValue);
                }
            });
            // Alternativement, si vous voulez utiliser ToastObserver
            // toastObservable.subscribe(new ToastObserver() {
            //     @Override
            //     public void update(Toast newValue) {
            //         EditArmyScreen.this.handleToastUpdate(newValue);
            //     }
            // });
        }
    }


    //@Override
    public void updateRootFromObservable(UnitGroup newValue) {
        //System.out.println("update observer side");
        this.armyFileService.setRootLoaded(newValue);
        this.updateRootAndTree();
        Toast toast = new Toast("File loaded", "SUCCESS");
        toast.show(this.stage, 2f);
    }


    //@Override
    public void displayToastFromObservable(Toast toast){
        toast.show(this.stage, 2f);
    }


    public void updateRootAndTree() {
        this.rootGroup = (FrontGroup) armyFileService.getRootLoaded();
        this.armyFileService.setRootToSave(this.rootGroup);
        initTree();
        leftScrollPane.setActor(tree);
        this.isTreeRootNodeDefined = true;
        this.selectedCountry = rootGroup.getCountry();
        updateTreeFromRoot();
        updateLeftPanelFromBoolean();
        //resetSelectedUnit();
        this.buttonSaveAllWrapper.getButton().setDisabled(false);
        this.buttonSaveGroupWrapper.getButton().setDisabled(true);
    }

    private void updateUnitSelectorList() {
        this.unitSelectorList = Arrays.stream(ElementSelectorType.values())
            .filter(type -> (type.getCountry().equals(CountryEnum.NO_COUNTRY) ||
                type.getCountry().equals(getSelectedCountry())) && !type.equals(ElementSelectorType.NO_TYPE))
            .toArray(ElementSelectorType[]::new);
        //that.unitSelectorList = filteredTypes;
        // Convertir en Array de libGDX
        Array<ElementSelectorType> gdxArray = new Array<>(this.unitSelectorList);
        this.selectUnitBox.setItems(gdxArray);
    }

    private void getAndAddNewUnitInTree(
        String unitName,
        String unitAcronym,
        boolean isUnitElite,
        CountryEnum unitCountry,
        ElementSelectorType unitType,
        int unitRegRank
    ) {
        UnitElement newUnit = UnitUtil.getNewUnitFromSelection(unitName, unitAcronym, isUnitElite, unitCountry, unitType, unitRegRank);
        UnitGroup group = (UnitGroup) this.selectedUnit;
        group.addUnit(newUnit);
        initTree();
        leftScrollPane.setActor(tree);
        updateTreeFromRoot();
        //resetSelectedUnit();
        this.buttonSaveAllWrapper.getButton().setDisabled(false);
    }

    private void getAndAddNewRootUnitInTree(
        String unitName,
        String unitAcronym,
        boolean isUnitElite,
        CountryEnum unitCountry
    ) {
        UnitElement newRoot = UnitUtil.getNewUnitFromSelection(unitName, unitAcronym, isUnitElite, unitCountry, ElementSelectorType.FRONT_HQ, 0);
        this.rootGroup = (FrontGroup) newRoot;
        this.armyFileService.setRootToSave(this.rootGroup);
        //this.selectedUnit = this.rootGroup;
        initTree();
        leftScrollPane.setActor(tree);
        updateTreeFromRoot();
        this.isTreeRootNodeDefined = true;
        this.updateLeftPanelFromBoolean();
    }

    private void removeSelectedUnitAndUpdateTree() {
        if(!selectedUnit.equals(rootGroup)) {
            selectedUnit.getParent().removeUnit(selectedUnit);
            //GraphicUtil.printGroup(rootGroup);
            initTree();
            leftScrollPane.setActor(tree);
            updateTreeFromRoot();
            resetSelectedUnit();
            this.buttonSaveAllWrapper.getButton().setDisabled(rootGroup.getUnits().size == 0);
            this.buttonSaveGroupWrapper.getButton().setDisabled(true);
        }
        else {
            // TODO : enlever le try/catch ??
            try {
                rootGroup = null;
                this.armyFileService.setRootToSave(this.rootGroup);
                isTreeRootNodeDefined = false;
                updateLeftPanelFromBoolean();
                resetSelectedUnit();
                this.buttonSaveAllWrapper.getButton().setDisabled(true);
                this.buttonSaveGroupWrapper.getButton().setDisabled(true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x1 = spacing;
        float x2 = 2f * spacing + rectWidth;
        float x3 = 3f * spacing + 2f * rectWidth;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(GraphicUtil.backgroundColorMedium);
        shapeRenderer.rect(x1, 100f, rectWidth, rectHeight);
        shapeRenderer.rect(x2, 100f, rectWidth, rectHeight);
        //shapeRenderer.setColor(GraphicUtil.backgroundColorLight);
        shapeRenderer.rect(x3, 100f, rectWidth, rectHeight);
        shapeRenderer.end();
        */
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    public CountryEnum getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(CountryEnum selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    @Override
    public void resize(int i, int i1) {

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
        stage.dispose();
        font.dispose();
        //shapeRenderer.dispose();
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

}
