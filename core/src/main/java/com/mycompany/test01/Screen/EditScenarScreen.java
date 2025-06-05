package com.mycompany.test01.Screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Enum.ZoomLevelEnum;
import com.mycompany.test01.Interface.ToastObserver;
import com.mycompany.test01.Main;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Service.ScenarFileService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

import java.awt.*;

public class EditScenarScreen implements Screen {
    private final Main game;
    private final Stage stage;
    private final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;
    private final ToastObservable toastObservable;

    private final ScenarFileService scenarFileService;

    private final EditScenarService editScenarService;
    private final InputMultiplexer inputMultiplexer; // Nouveau champ
    private final EditScenarScreen.EditScenarScreenInputAdapter screenInputAdapter; // Pour la logique d'entrée de l'écran

    private final Table leftMapPanel, rightPanel, bottomRightButtonPanel;

    private ScrollPane rightScrollPane;

    //private boolean isScenarPresent = false;

    public EditScenarScreen(Main game) {

        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
        this.scenarFileService = ScenarFileService.getInstance();
        this.editScenarService = EditScenarService.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        this.subscribeToObservables();

        this.screenInputAdapter = new EditScenarScreen.EditScenarScreenInputAdapter(this);

        // Configurer InputMultiplexer
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);             // La Stage d'abord, pour que les UI aient la priorité
        inputMultiplexer.addProcessor(screenInputAdapter); // Puis votre logique d'écran personnalisée

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
        panel.pad(20f); // Définir le padding après avoir défini le fond
        Table rightLoadMapPanel = createRightLoadMapPanel();
        //panel.add(rightLoadMapPanel).expand().fill().height(150f); // Utiliser add() et configurer le layout
        panel.add(rightLoadMapPanel).expand().fill().height(150f).top(); // Fixer la hauteur
        return panel;
    }


    private Table createBottomRightButtonPanel() { // TODO : corriger nom !!!

        int padding = 20;
        int panelHeight = 60;
        int buttonHeight = 40;
        int buttonWidth = 140;
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

    private Table createRightLoadMapPanel() {
        Table panel = new Table();
        panel.setBackground(this.getPanelTexture(GraphicUtil.backgroundColorLight));
        //panel.setBounds(20, 20, 340, 150);
        //panel.setWidth(340);
        //panel.setHeight(150);
        //panel.pad(20);
        ButtonWrapper buttonLoadMapWrapper = new ButtonWrapper("Load Map", 0, 0, 140, 40);
        buttonLoadMapWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("click load map");
                scenarFileService.openLoadMapFileChooser();
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
        editScenarService.drawMap(drawingMapPixmap);

        // Create a new texture from the pixmap
        drawingTexture = new Texture(drawingMapPixmap);

    }


    private void subscribeToObservables() {
        if (toastObservable != null) {
            // Création d'un Observer<Toast> anonyme
            toastObservable.subscribe(new ToastObserver() {
                @Override
                public void update(Toast newValue) {
                    EditScenarScreen.this.displayToastFromObservable(newValue);
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
            float mapX = this.screen.editScenarService.getMapX();
            float mapY = this.screen.editScenarService.getMapY();
            float mapWidth = this.screen.editScenarService.getMapWidth();
            float mapHeight = this.screen.editScenarService.getMapHeight();
            int margin = this.screen.editScenarService.getMargin();
            int hexagonSize = this.screen.editScenarService.getHexSize();
            int gapY = this.screen.editScenarService.getGapY();

            //System.out.println("worldCoords.x : " + worldCoords.x + " / worldCoords.y : " + worldCoords.y);
            //System.out.println("screenX : " + screenX + " / screenY : " + screenY);

            int x = (int) (screenX - mapX - margin);
            int y = (int) (screenY - gapY - margin);

            int i = this.screen.editScenarService.getIFromXY(x, y);
            int j = this.screen.editScenarService.getJFromY(y);


            if (x >= 0 && x <= mapWidth - margin &&
                y >= 0 && y <= mapHeight - margin) {
                System.out.println("clic in !!");
                screen.stage.setKeyboardFocus(null);

                if(i >= 0 && i < this.screen.editScenarService.getMaxI() && j >= 0 && j < this.screen.editScenarService.getMaxJ()) {
                    //Hexagon clickedHexagon = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + editMapService.getStartJ());
                    //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                    this.screen.editScenarService.renderHex( i + this.screen.editScenarService.getStartI(), j + this.screen.editScenarService.getStartJ(), GraphicUtil.redTexture, this.screen.drawingMapPixmap);
                    this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);


                    return true;
                }

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
            switch (this.screen.editScenarService.getZoomLevel()) {
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
                    this.screen.editScenarService.setStartI(this.screen.editScenarService.getStartI() + delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.RIGHT:
                    this.screen.editScenarService.setStartI(this.screen.editScenarService.getStartI() - delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.UP:
                    this.screen.editScenarService.setStartJ(this.screen.editScenarService.getStartJ() + delta);
                    this.screen.redrawMap();
                    break;
                case Input.Keys.DOWN:
                    this.screen.editScenarService.setStartJ(this.screen.editScenarService.getStartJ() - delta);
                    this.screen.redrawMap();
                    break;
                case 157: //Input.Keys.PLUS
                    //System.out.println("+ key");
                    switch (this.screen.editScenarService.getZoomLevel()) {
                        case CLOSE_VIEW :
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.CLOSE_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                    }
                    break;
                case 156: //Input.Keys.MINUS
                    //System.out.println("- key");
                    switch (this.screen.editScenarService.getZoomLevel()) {
                        case CLOSE_VIEW :
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case NORMAL_VIEW:
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editScenarService.setZoomLevel(ZoomLevelEnum.VERY_DISTANT_VIEW);
                            this.screen.editScenarService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            break;
                    }
                    break;
                default:
                    break;
                    //System.out.println("Autre touche appuyée");
            }
            return true; // Retourne true pour indiquer que l'événement a été traité
        }

    }
}
