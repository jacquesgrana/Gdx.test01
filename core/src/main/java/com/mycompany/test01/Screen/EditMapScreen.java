package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Main;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Service.MapFileService;
import com.mycompany.test01.Service.EditMapService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

public class EditMapScreen implements Screen, InputProcessor {
    final Main game;
    final Stage stage;
    final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;
    final EditMapService editMapService;
    final MapFileService mapFileService;
    private boolean isMiniMapVisible = false;
    private EditMapMode mode;
    private final Label modeLabel;
    private Label selectedTerrainLabel;
    private Label selectedFortificationLabel;
    private Label selectedRoadLabel;
    private Label selectedRiverLabel;
    private final Table terrainButtonPanel;
    private final Table fortificationButtonPanel;
    private final Table roadButtonPanel;
    private final Table riverButtonPanel;
    private final Table miscButtonPanel;

    private final Skin skin; //Skin for UI elements
    private HexagonCategory selectedTerrain = HexagonCategory.GRASS;
    private FortificationCategory selectedFortification = FortificationCategory.NO_FORTIFICATION;
    private RoadCategory selectedRoad = RoadCategory.NO_ROAD;
    private RiverCategory selectedRiver = RiverCategory.NO_RIVER;

    private RoadDrawFlagCategory roadDrawFlag = RoadDrawFlagCategory.EMPTY;
    private RiverDrawFlagCategory riverDrawFlag = RiverDrawFlagCategory.EMPTY;

    public EditMapScreen(Main game) {
        this.mode = EditMapMode.NO_ACTION;
        this.editMapService = EditMapService.getInstance();
        this.editMapService.init();
        this.mapFileService = MapFileService.getInstance();
        //mapService.updateMapSize();
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);

        this.font = new BitmapFont();
        this.skin = SkinUtil.getButtonSkin(80, 30);
        //this.selectedTerrainPanel = null;
        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Map", labelStyle);
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

        stage.addActor(buttonBackWrapper.getButton());

        // label "selected mode :"
        this.modeLabel = new Label("Edit Mode : " + this.mode, labelStyle);
        this.modeLabel.setPosition(50, 130);
        stage.addActor(this.modeLabel);

        // boutons mode : "no-action", "terrain", "road", "river"
        ButtonWrapper buttonModeNoActionWrapper = new ButtonWrapper(
            "No Action",
            50, 80, 160, 40);
        EditMapScreen that = this;
        buttonModeNoActionWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.NO_ACTION;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                redrawMap();
            }
        });
        stage.addActor(buttonModeNoActionWrapper.getButton());

        ButtonWrapper buttonModeTerrainWrapper = new ButtonWrapper(
            "Terrain",
            50 + 10 + 160, 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeTerrainWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.TERRAIN;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideFortificationButtonPanel();// Show the terrain panel when in terrain mode
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                showTerrainButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeTerrainWrapper.getButton());

        ButtonWrapper buttonModeRiverWrapper = new ButtonWrapper(
            "River",
            50 + 2 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeRiverWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.RIVER;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideMiscButtonPanel();
                showRiverButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeRiverWrapper.getButton());

        ButtonWrapper buttonModeRoadWrapper = new ButtonWrapper(
            "Road",
            50 + 3 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeRoadWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.ROAD;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                showRoadButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeRoadWrapper.getButton());

        ButtonWrapper buttonModeFortificationWrapper = new ButtonWrapper(
            "Fortification",
            50 + 4 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeFortificationWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.FORTIFICATION;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                showFortificationButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeFortificationWrapper.getButton());

        ButtonWrapper buttonModeMiscWrapper = new ButtonWrapper(
            "Miscellaneous",
            50 + 5 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeMiscWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.MISC;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                showMiscButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeMiscWrapper.getButton());

        drawingMapPixmap = new Pixmap((int) editMapService.getMapWidth(),(int) editMapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(GraphicUtil.backgroundColorMedium);
        drawingMapPixmap.fill();

        editMapService.drawMap(drawingMapPixmap, mode);

        drawingTexture = new Texture(drawingMapPixmap);

        terrainButtonPanel = createTerrainButtonPanel();
        fortificationButtonPanel = createFortificationButtonPanel();
        roadButtonPanel = createRoadButtonPanel();
        riverButtonPanel = createRiverButtonPanel();
        miscButtonPanel = createMiscButtonPanel();

        terrainButtonPanel.setVisible(false); // Initially hidden
        fortificationButtonPanel.setVisible(false);
        roadButtonPanel.setVisible(false);
        riverButtonPanel.setVisible(false);
        miscButtonPanel.setVisible(false);
    }

    private void redrawMap() {
        // Dispose of the old texture and pixmap
        if (drawingTexture != null) drawingTexture.dispose();
        if (drawingMapPixmap != null) drawingMapPixmap.dispose();

        // Create a new pixmap
        drawingMapPixmap = new Pixmap((int) editMapService.getMapWidth(),(int) editMapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(GraphicUtil.backgroundColorMedium);
        drawingMapPixmap.fill();

        // Redraw the map to the pixmap
        editMapService.drawMap(drawingMapPixmap, mode);

        // Create a new texture from the pixmap
        drawingTexture = new Texture(drawingMapPixmap);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //redrawMap();

        batch.begin();
        batch.draw(drawingTexture, editMapService.getMapX(), editMapService.getMapY());
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        font.dispose();
        batch.dispose();
        drawingMapPixmap.dispose();
        drawingTexture.dispose();
        skin.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        //this.mapService.firstInit();
        //this.mapService.init();
        //this.redrawMap();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Convertir les coordonnées de l'écran en coordonnées du monde
        Vector3 worldCoords = stage.getCamera().unproject(new Vector3(screenX, screenY, 0));

        // Vérifier si le clic est dans la zone de la carte
        float mapX = editMapService.getMapX();
        float mapY = editMapService.getMapY();
        float mapWidth = editMapService.getMapWidth();
        float mapHeight = editMapService.getMapHeight();
        int margin = editMapService.getMargin();
        int hexagonSize = editMapService.getHexagonSize();

        //System.out.println("worldCoords.x : " + worldCoords.x + " / worldCoords.y : " + worldCoords.y);
        //System.out.println("screenX : " + screenX + " / screenY : " + screenY);

        int x = (int) (screenX - mapX - margin);
        int y = (int) (screenY - 45 - margin);

        int i = editMapService.getIFromXY(x, y);
        int j = editMapService.getJFromY(y);
        //System.out.println("x : " + x + " / y : " + y);

        // tester si miniMap visible et clic dans minimap
        if(this.isMiniMapVisible) {
            if( x > editMapService.getMiniMapX()
                && x < editMapService.getMiniMapX() + editMapService.getMiniMapWidth() - 2 * editMapService.getMiniMapMargin()
                && y > editMapService.getMiniMapY()
                && y < editMapService.getMiniMapY() + editMapService.getMiniMapHeight() - 2 * editMapService.getMiniMapMargin()) {
                //System.out.println("clic in minimap");
                editMapService.updateMiniMap(x, y, drawingMapPixmap);
                //mapService.showMiniMap(drawingMapPixmap);
                //drawingTexture.draw(drawingMapPixmap, 0, 0);
                redrawMap();
                editMapService.showMiniMap(drawingMapPixmap);
                drawingTexture.draw(drawingMapPixmap, 0, 0);

            }
        }
        else if (x >= 0 && x <= mapWidth - margin &&
            y >= 0 && y <= mapHeight - margin) {
            //System.out.println("clic in !!");

            if(this.mode == EditMapMode.NO_ACTION) {
                //int i = mapService.getIFromXY(x, y);
                //int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                //System.out.println("i : " + i);

                if(i >= 0 && i < editMapService.getMaxI() && j >= 0 && j < editMapService.getMaxJ()) {
                    Hexagon clickedHexagon = editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ());
                    //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                    editMapService.renderHex( i + editMapService.getStartI(), j + editMapService.getStartJ(), GraphicUtil.redTexture, drawingMapPixmap);
                    drawingTexture.draw(drawingMapPixmap, 0, 0);
                }

                Hexagon[] neighbours = editMapService.getNeighborhoodHexes(i, j);
                for(int k=0; k<6; k++) {
                    if(neighbours[k] != null) {
                        int ii = neighbours[k].getX();
                        int jj = neighbours[k].getY();
                        if (ii - editMapService.getStartI() >= 0 &&
                            ii - editMapService.getStartI() < editMapService.getMaxI() &&
                            jj - editMapService.getStartJ() >= 0 &&
                            jj - editMapService.getStartJ() < editMapService.getMaxJ()
                        ) {
                            editMapService.renderHex( ii, jj, GraphicUtil.orangeTexture, drawingMapPixmap);
                            drawingTexture.draw(drawingMapPixmap, 0, 0);
                        }

                    }
                }
            }
            else if(this.mode == EditMapMode.TERRAIN) {
                //int i = mapService.getIFromXY(x, y);
                //int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                //System.out.println("i : " + i);

                //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                if(editMapService.isClickInMap(i, j)) {
                    if(editMapService.getHexesArray().get(i+ editMapService.getStartI()).get(j+ editMapService.getStartJ()).getCategory() != this.selectedTerrain) {
                        editMapService.getHexesArray().get(i+ editMapService.getStartI()).get(j+ editMapService.getStartJ()).setCategory(this.selectedTerrain);
                    }
                    redrawMap();
                }
            }
            else if(this.mode == EditMapMode.FORTIFICATION) {
                //int i = mapService.getIFromXY(x, y);
                //int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                //System.out.println("i : " + i);
                //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                if(editMapService.isClickInMap(i, j)) {
                    if(editMapService.getHexesArray().get(i+ editMapService.getStartI()).get(j+ editMapService.getStartJ()).getFortification() != this.selectedFortification) {
                        editMapService.getHexesArray().get(i+ editMapService.getStartI()).get(j+ editMapService.getStartJ()).setFortification(this.selectedFortification);
                    }
                    redrawMap();
                }
            }
            else if(this.mode == EditMapMode.ROAD) {
                redrawMap();
                //int i = mapService.getIFromXY(x, y);
                //int j = mapService.getJFromY(y);
                //Hexagon clickedHexagon = null; // TODO transformer en variable globale : roadStartHex
                //Hexagon[] neighboursForRoad = null; // TODO transformer en variable globale : roadStartHexNeighbours
                if(i >= 0 && i < editMapService.getMaxI() && j >= 0 && j < editMapService.getMaxJ()) {

                    //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                    if(editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                        //System.out.println("old roadDrawFlag : " + roadDrawFlag.toString());

                        if(roadDrawFlag == RoadDrawFlagCategory.EMPTY || roadDrawFlag == RoadDrawFlagCategory.SECOND_CLICK_DONE) {
                            editMapService.setRoadStartHex(editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ()));

                            editMapService.setRoadStartHexNeighbours(editMapService.getNeighborhoodHexes(i, j));
                            redrawMap();

                            roadDrawFlag = RoadDrawFlagCategory.FIRST_CLICK_DONE;

                        }
                        else if(roadDrawFlag == RoadDrawFlagCategory.FIRST_CLICK_DONE && editMapService.isInNeighboursByMode(i, j, EditMapMode.ROAD)) {
                            Hexagon startHex = editMapService.getRoadStartHex();
                            Hexagon endHex = editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ());
                            // -> set les routes pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                            int k = editMapService.getKFromRoadNeighbours(endHex);
                            editMapService.setRoadForHexes(startHex, endHex, selectedRoad, k);
                            editMapService.setRoadStartHex(endHex);
                            editMapService.setRoadStartHexNeighbours(editMapService.getNeighborhoodHexes(i, j));

                            redrawMap();
                            roadDrawFlag = RoadDrawFlagCategory.SECOND_CLICK_DONE;
                        }
                        //System.out.println("new roadDrawFlag : " + roadDrawFlag.toString());
                    }
                    else {
                        editMapService.setRoadStartHex(null);
                        redrawMap();
                    }
                }
                // TODO prévoir bouton pour raz et set roadDrawFlag à "EMPTY" et vider roadStartHex et le tableau des voisins et redessiner la carte
            }
            else if(this.mode == EditMapMode.RIVER) {
                //System.out.println("clic mode river");
                redrawMap();
                if(i >= 0 && i < editMapService.getMaxI() && j >= 0 && j < editMapService.getMaxJ()) {
                    //System.out.println("clic mode river indices ok");

                    if(editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                        //System.out.println("clic mode river indices ok pas water");

                        if(riverDrawFlag == RiverDrawFlagCategory.EMPTY || riverDrawFlag == RiverDrawFlagCategory.SECOND_CLICK_DONE) {
                            //System.out.println("old river flag : " + riverDrawFlag.toString());

                            editMapService.setRiverStartHex(editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ()));
                            editMapService.setRiverStartHexNeighbours(editMapService.getNeighborhoodHexes(i, j));
                            redrawMap();
                            riverDrawFlag = RiverDrawFlagCategory.FIRST_CLICK_DONE;
                            //System.out.println("new river flag : " + riverDrawFlag.toString());

                        }
                        else if(riverDrawFlag == RiverDrawFlagCategory.FIRST_CLICK_DONE && editMapService.isInNeighboursByMode(i, j, EditMapMode.RIVER)) {
                            //System.out.println("old river flag : " + riverDrawFlag.toString());
                            Hexagon startHex = editMapService.getRiverStartHex();
                            Hexagon endHex = editMapService.getHexesArray().get(i + editMapService.getStartI()).get(j + editMapService.getStartJ());
                            // -> set les rivers pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                            int k = editMapService.getKFromRiverNeighbours(endHex);
                            editMapService.setRiverForHexes(startHex, endHex, selectedRiver, k);
                            editMapService.setRiverStartHex(endHex);
                            editMapService.setRiverStartHexNeighbours(editMapService.getNeighborhoodHexes(i, j));

                            redrawMap();
                            riverDrawFlag = RiverDrawFlagCategory.SECOND_CLICK_DONE;
                            //System.out.println("new river flag : " + riverDrawFlag.toString());

                        }
                    }
                    else {
                        editMapService.setRiverStartHex(null);
                        redrawMap();
                    }
                }
            }

            return true; // Indique que l'événement a été traité
        }
        // Si le clic n'est pas sur la carte, déléguer à Stage
        return stage.touchDown(screenX, screenY, pointer, button);
    }



    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        /*
        if (isDrawing) {
            Vector3 worldCoords = stage.getCamera().unproject(new Vector3(screenX, screenY, 0));
            int pixmapX = (int)(worldCoords.x - mapX);
            int pixmapY = (int)(mapHeight - (worldCoords.y - mapY));
            if (pixmapX >= 0 && pixmapX < drawingPixmap.getWidth() && pixmapY >= 0 && pixmapY < drawingPixmap.getHeight()) {
                drawingPixmap.setColor(Color.BLACK);
                drawingPixmap.fillCircle(pixmapX, pixmapY, 5);
                drawingTexture.draw(drawingPixmap, 0, 0);
            }
            return true;
        }*/
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        /*
        if (isDrawing) {
            isDrawing = false;
            return true;
        }*/
        return stage.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        int delta = 2;
        //System.out.println("keycode : " + keycode);
        switch (keycode) {
            case Input.Keys.LEFT:
                if(!this.isMiniMapVisible) {
                    editMapService.setStartI(editMapService.getStartI() + delta);
                    redrawMap();
                }

                break;
            case Input.Keys.RIGHT:
                if(!this.isMiniMapVisible) {
                    editMapService.setStartI(editMapService.getStartI() - delta);
                    redrawMap();
                }
                break;
            case Input.Keys.UP:
                if(!this.isMiniMapVisible) {
                    editMapService.setStartJ(editMapService.getStartJ() + delta);
                    redrawMap();
                }
                break;
            case Input.Keys.DOWN:
                if(!this.isMiniMapVisible) {
                    editMapService.setStartJ(editMapService.getStartJ() - delta);
                    redrawMap();
                }
                break;
            case 74: // 'm/M'
                this.isMiniMapVisible = !this.isMiniMapVisible;
                //System.out.println("isMiniMapVisible : " + this.isMiniMapVisible);
                if(this.isMiniMapVisible) {
                    //System.out.println("Showing miniMap");
                    editMapService.showMiniMap(drawingMapPixmap);
                    drawingTexture.draw(drawingMapPixmap, 0, 0);
                }
                else {
                    redrawMap();
                }
                break;
            default:
                //System.out.println("Autre touche appuyée");
        }
        return true; // Retourne true pour indiquer que l'événement a été traité
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    private Table createTerrainButtonPanel() {
        Table panel = new Table();
        // Ajouter l'image de la texture
        Texture terrainTexture = GraphicUtil.getTextureFromTerrain(this.selectedTerrain);
        Image terrainImage = new Image(terrainTexture);
        terrainImage.setSize(64, 64);
        panel.defaults().pad(7);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedTerrainLabel = new Label("Selected Terrain : " + this.selectedTerrain.toString(), labelStyle);
        //this.selectedTerrainLabel.setPosition(50, 150);
         // Add some padding around the buttons
        panel.add(this.selectedTerrainLabel).colspan(7);
        panel.row();
        // Define the terrain types (you can load these from a file or configuration)
        HexagonCategory[] terrainTypes = {HexagonCategory.FOREST,
        HexagonCategory.GRASS,
        HexagonCategory.SAND,
        HexagonCategory.SWAMP,
        HexagonCategory.WATER,
        HexagonCategory.CITY_LIGHT,
        HexagonCategory.CITY_DENSE};
        EditMapScreen that = this;
        // Create buttons for each terrain type
        for (HexagonCategory terrainType : terrainTypes) {
            TextButton button = new TextButton(terrainType.toString(), skin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    // Handle the terrain selection
                    //System.out.println("Selected terrain: " + terrainType.toString());
                    // You would likely set a "selectedTerrain" variable here
                    // and use it in the touchDown method to apply the terrain.
                    selectedTerrain = terrainType;
                    selectedTerrainLabel.setText("Selected Terrain : " + terrainType.toString());
                    // ajouter update affichage miniature du selectedTerrain
                    terrainImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromTerrain(that.selectedTerrain))));
                }
            });
            panel.add(button);
        }
        panel.row(); // New row for each button (for vertical layout)

        // Ajouter l'image de la texture
        /*
        Texture terrainTexture = GraphicUtil.getTextureFromTerrain(this.selectedTerrain);
        Image terrainImage = new Image(terrainTexture);
        terrainImage.setSize(90, 30);*/
        panel.add(terrainImage).colspan(7).width(64).height(64);
        panel.row();


        // Position the panel in the bottom-right corner
        panel.setPosition(Gdx.graphics.getWidth() - 420f, 80f);
        return panel;
    }

    private Table createFortificationButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);

        //Texture fortificationTexture = GraphicUtil.getTextureFromFortification(this.selectedFortification);
        Image fortificationImage = new Image();
        fortificationImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedFortificationLabel = new Label("Selected Fortification : " + selectedFortification.toString(), labelStyle);
        panel.add(this.selectedFortificationLabel).colspan(5);
        panel.row();

        FortificationCategory[] fortificationTypes = {
            FortificationCategory.NO_FORTIFICATION,
            FortificationCategory.WOOD_LIGHT,
            FortificationCategory.WOOD_MEDIUM,
            FortificationCategory.CONCRETE_LIGHT,
            FortificationCategory.CONCRETE_MEDIUM,
            FortificationCategory.CONCRETE_HEAVY
        };
        EditMapScreen that = this;
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);
        int count = 1;
        for (FortificationCategory fortificationType : fortificationTypes) {
            TextButton button = new TextButton(fortificationType.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //System.out.println("Selected fortification : " + fortificationType.toString());
                    selectedFortification = fortificationType;
                    selectedFortificationLabel.setText("Selected Fortification : " + fortificationType.toString());
                    fortificationImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromFortification(selectedFortification))));
                }
            });
            panel.add(button);
            if(count == 3) panel.row();
            count++;

        }

        panel.row();
        panel.add(fortificationImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createRoadButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);

        Image roadImage = new Image();
        roadImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedRoadLabel = new Label("Selected Road : " + selectedRoad.toString(), labelStyle);
        panel.add(this.selectedRoadLabel).colspan(5);
        panel.row();

        RoadCategory[] roadCategories = {
            RoadCategory.NO_ROAD,
            RoadCategory.PATHWAY,
            RoadCategory.ROADWAY,
            RoadCategory.RAILWAY
        };
        EditMapScreen that = this;
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);

        for (RoadCategory roadCategory : roadCategories) {
            TextButton button = new TextButton(roadCategory.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //System.out.println("Selected fortification: " + fortificationType.toString());
                    selectedRoad = roadCategory;
                    selectedRoadLabel.setText("Selected Road : " + roadCategory.toString());
                    roadImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromRoadForButton(32, 32, 3, selectedRoad))));
                }
            });
            panel.add(button);
        }
        panel.row();
        panel.add(roadImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createRiverButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);

        Image riverImage = new Image();
        riverImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedRiverLabel = new Label("Selected River : " + selectedRiver.toString(), labelStyle);
        panel.add(this.selectedRiverLabel).colspan(5);
        panel.row();

        RiverCategory[] riverCategories = {
            RiverCategory.NO_RIVER,
            RiverCategory.NARROW,
            RiverCategory.MEDIUM,
            RiverCategory.WIDE
        };
        EditMapScreen that = this;
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);

        for (RiverCategory riverCategory : riverCategories) {
            TextButton button = new TextButton(riverCategory.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //System.out.println("Selected fortification: " + fortificationType.toString());
                    selectedRiver = riverCategory;
                    selectedRiverLabel.setText("Selected River : " + riverCategory.toString());
                    riverImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromRiverForButton(32, 32, selectedRiver))));
                }
            });
            panel.add(button);
        }

        panel.row();


        panel.add(riverImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createMiscButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(4);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedRiverLabel = new Label("Miscellaneous :", labelStyle);
        panel.add(this.selectedRiverLabel).colspan(5);
        panel.row();
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);

        TextButton buttonReset = new TextButton("Reset Map", buttonSkin);
        buttonReset.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic reset");
                editMapService.resetMap();
                redrawMap();
            }
        });
        panel.add(buttonReset);

        TextButton buttonSave = new TextButton("Save Map", buttonSkin);
        buttonSave.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic save");
                mapFileService.openSaveMapFileChooser();
                redrawMap();
            }
        });
        panel.add(buttonSave);

        TextButton buttonLoad = new TextButton("Load Map", buttonSkin);
        buttonLoad.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic load");
                mapFileService.openLoadMapFileChooser();

                redrawMap();
            }
        });
        panel.add(buttonLoad);

        TextButton buttonGenBridge = new TextButton("Add Bridge(s)", buttonSkin);
        buttonGenBridge.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic load");
                //mapFileService.openLoadMapFileChooser();
                editMapService.generateBridgesFromRiversAndRoads();
                redrawMap();
            }
        });
        panel.add(buttonGenBridge);

        panel.row();
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private void showTerrainButtonPanel() {
        if (terrainButtonPanel.getParent() == null) {
            stage.addActor(terrainButtonPanel);
        }
        terrainButtonPanel.setVisible(true);
    }

    private void hideTerrainButtonPanel() {
        terrainButtonPanel.setVisible(false);
    }

    private void showFortificationButtonPanel() {
        if (fortificationButtonPanel.getParent() == null) {
            stage.addActor(fortificationButtonPanel);
        }
        fortificationButtonPanel.setVisible(true);
    }

    private void hideFortificationButtonPanel() {
        fortificationButtonPanel.setVisible(false);
    }

    private void showRoadButtonPanel() {
        if (roadButtonPanel.getParent() == null) {
            stage.addActor(roadButtonPanel);
        }
        roadButtonPanel.setVisible(true);
    }

    private void hideRoadButtonPanel() {
        roadButtonPanel.setVisible(false);
    }

    private void showRiverButtonPanel() {
        if (riverButtonPanel.getParent() == null) {
            stage.addActor(riverButtonPanel);
        }
        riverButtonPanel.setVisible(true);
    }

    private void hideRiverButtonPanel() {
        riverButtonPanel.setVisible(false);
    }

    private void showMiscButtonPanel() {
        if (miscButtonPanel.getParent() == null) {
            stage.addActor(miscButtonPanel);
        }
        miscButtonPanel.setVisible(true);
    }

    private void hideMiscButtonPanel() {
        miscButtonPanel.setVisible(false);
    }

    /*
    private Skin createDefaultSkin() {
        Skin skin = new Skin();

        // Generate a default font
        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);

        // Create a texture for the button background
        Pixmap pixmap = new Pixmap(80, 30, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        // Draw a 1-pixel black border
        pixmap.setColor(Color.BLACK);
        pixmap.drawRectangle(0, 0, (int) pixmap.getWidth(), (int) pixmap.getHeight());
        skin.add("button", new Texture(pixmap));

        pixmap.dispose(); // Dispose of the Pixmap!

        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("button", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default-font");
        skin.add("default", textButtonStyle);

        return skin;
    }*/

}
