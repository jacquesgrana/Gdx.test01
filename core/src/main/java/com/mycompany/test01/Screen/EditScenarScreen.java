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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.ZoomLevelEnum;
import com.mycompany.test01.Interface.observer.EditScenarLoadMapObserver;
import com.mycompany.test01.Interface.observer.ToastObserver;
import com.mycompany.test01.Library.HexPathfinderCalculator;
import com.mycompany.test01.Main;
import com.mycompany.test01.Observable.EditScenarLoadMapObservable;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Service.ScenarFileService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

import java.util.ArrayList;
import java.util.List;

public class EditScenarScreen implements Screen {
    private final Main game;
    private final Stage stage;
    private final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;
    private final ToastObservable toastObservable;
    private final EditScenarLoadMapObservable editScenarLoadMapObservable;

    private final ScenarFileService scenarFileService;

    private final EditScenarService editScenarService;
    private final InputMultiplexer inputMultiplexer; // Nouveau champ
    private final EditScenarScreen.EditScenarScreenInputAdapter screenInputAdapter; // Pour la logique d'entrée de l'écran

    private final Table leftMapPanel, rightPanel, bottomRightButtonPanel;
    private Table rightPanelContainer;
    private Table  rightLoadMapPanel;
    private Table rightEditScenarPanel;

    private Table opponentsSidesListPanel;

    private Table opponentsEditPanel;

    private ScrollPane rightScrollPane;

    private boolean isScenarPresent = false;

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
        this.scenarFileService = ScenarFileService.getInstance();
        this.editScenarService = EditScenarService.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        this.editScenarLoadMapObservable = EditScenarLoadMapObservable.getInstance();
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
        this.bottomRightButtonPanel = this.createBottomRightButtonPanel();
        this.stage.addActor(this.bottomRightButtonPanel);

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

    private Table createLeftMapPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));

        panel.setBounds(50f, 180f, Gdx.graphics.getWidth() - 500f, Gdx.graphics.getHeight() - 230f);
        return panel;
    }

    private Table createRightPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorMedium));
        panel.setBounds(Gdx.graphics.getWidth() - 430f, 50f, 380f, Gdx.graphics.getHeight() - 100f);
        panel.pad(20f);

        // 1. Crée un conteneur vide pour héberger les panneaux dynamiques
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


    private Table createBottomRightButtonPanel() { // TODO : corriger nom !!! en ...Left...

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

        return panel;
    }

    private Table createRightEditScenarPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        //panel.setHeight(300);
        panel.pad(20);


        Label scenarNameLabel = new Label("Scenar Name : ", SkinUtil.getLabelSkin(100, 30));
        TextField scenarNameField = new TextField(this.editScenarService.getScenario().getName(), SkinUtil.getTextFieldSkin(150, 30));

        //scenarNameLabel.setPosition(20f, -20f);
        panel.pad(20f)
            .add(scenarNameLabel);
        panel.add(scenarNameField).row();

        Label scenarMapNameLabel = new Label("Map name : " + this.editScenarService.getScenario().getMap().getName(), SkinUtil.getLabelSkin(260, 30));

        //scenarNameLabel.setPosition(20f, -20f);
        panel.add(scenarMapNameLabel).colspan(2);
        panel.row();


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
        panel.pad(20);
        panel.add(scenarSidesCountLabel);
        panel.add(scenarSidesCountSlider);
        panel.row();

        //this.opponentsSidesListPanel = createOpponentsSidesListPanel();
        this.editScenarService.getScenario().initOpponentsFromSidesCount();
        rebuildOpponentsSidesListPanel();
        panel.add(this.opponentsSidesListPanel).colspan(2);
        panel.row();

        return panel;
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
        this.opponentsSidesListPanel.add(titleLabel).colspan(2).padBottom(10).row();

        // 3. Ajouter un bloc par side (exemple : un Label + un bouton par side)
        EditScenarScreen that = this;
        for (int i = 0; i < this.editScenarService.getScenario().getSidesCount(); i++) {
            Table container = new Table();
            Label sideLabel = new Label(this.editScenarService.getScenario().getSides()[i].toString(), SkinUtil.getLabelSkin(80, 25));
            //Button sideButton = new Button(SkinUtil.getButtonSkin(100, 25));
            container.add(sideLabel).row();

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

                    System.out.println("Country chosen for side: " +
                        that.editScenarService.getScenario().getSides()[finalI] + " : " + selectedCountry);
                    System.out.println("country's side : " + that.editScenarService.getScenario().getOpponents()[finalI].getSide().toString());
                }
            });

            container.add(countryOneSelector).row();

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
                boolean isOpponentsOk = that.isScenarPresent;
                for(int i=0; i<that.editScenarService.getScenario().getSidesCount(); i++) {
                    boolean isOpponentOk = that.editScenarService.getScenario().getOpponents()[i].getCountry() != CountryEnum.NO_COUNTRY;
                    if(i<that.editScenarService.getScenario().getSidesCount() - 1) {
                        for(int j=i+1; j<that.editScenarService.getScenario().getSidesCount(); j++) {
                            isOpponentOk &= that.editScenarService.getScenario().getOpponents()[i].getCountry() != that.editScenarService.getScenario().getOpponents()[j].getCountry();
                        }
                    }

                    isOpponentsOk &= isOpponentOk;
                    if(isOpponentsOk) {

                    }

                }
                System.out.println("isOpponentsOk : " + isOpponentsOk);
            }
        });

        // TODO ajouter listener et methode qui affiche le bloc d'edition des opponents

        this.opponentsSidesListPanel.add(buttonValidateOpponents.getButton());
    }

    private void rebuildOpponentsEditPanel() {
        this.opponentsEditPanel = new Table();
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



        // TODO dessin path
        /*
        if(!this.path.isEmpty()) {
            for (Hexagon hex : path ) {
                System.out.println("path hex : i : " + hex.getX() + " : j : " + hex.getY());
                this.editScenarService.renderHex(hex.getX() - this.editScenarService.getStartI(), hex.getY() - this.editScenarService.getStartJ() , GraphicUtil.redTexture, this.drawingMapPixmap);
            }
        }
        */

        // Redraw the map to the pixmap
        editScenarService.getScenario().getMap().drawMap(drawingMapPixmap);

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
    }

    public void displayToastFromObservable(Toast toast){
        toast.show(this.stage, 2f);
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
                int i = this.screen.editScenarService.getScenario().getMap().getIFromXY(x, y);
                int j = this.screen.editScenarService.getScenario().getMap().getJFromY(y);
                //System.out.println("i : " + i + " / j : " + j);

                if (x >= 0 && x <= mapWidth - margin &&
                    y >= 0 && y <= mapHeight - margin) {
                    //System.out.println("clic in !!");

                    if(i >= 0 && i < this.screen.editScenarService.getScenario().getMap().getMaxI() && j >= 0 && j < this.screen.editScenarService.getScenario().getMap().getMaxJ()) {
                        //Hexagon clickedHexagon = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + editMapService.getStartJ());
                        //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                        screen.stage.setKeyboardFocus(null);

                        // TODO ajouter test pathfinder

                        if(screen.isScenarPresent) {
                            this.screen.editScenarService.getScenario().getMap().renderHex( i + this.screen.editScenarService.getScenario().getMap().getStartI(), j + this.screen.editScenarService.getScenario().getMap().getStartJ(), (screen.pathStart == null || screen.pathEnd == null) ? GraphicUtil.redTexture : GraphicUtil.orangeTexture, this.screen.drawingMapPixmap);

                            if (screen.pathStart == null) {
                                screen.pathStart = this.screen.editScenarService.getScenario().getMap().getHexesArray().get(i + this.screen.editScenarService.getScenario().getMap().getStartI()).get(j + this.screen.editScenarService.getScenario().getMap().getStartJ());
                            }
                            else if (screen.pathEnd == null) {
                                screen.pathEnd = this.screen.editScenarService.getScenario().getMap().getHexesArray().get(i + this.screen.editScenarService.getScenario().getMap().getStartI()).get(j + this.screen.editScenarService.getScenario().getMap().getStartJ());

                                // TODO chercher path
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
            int delta = 0;
            switch (this.screen.editScenarService.getScenario().getMap().getZoomLevel()) {
                case CLOSE_VIEW:
                case NORMAL_VIEW:
                    delta = 2;
                    break;
                case DISTANT_VIEW:
                    delta = 4;
                    break;
                case VERY_DISTANT_VIEW:
                    delta = 8;
                    break;
            }
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
