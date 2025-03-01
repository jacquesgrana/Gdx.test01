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
import com.mycompany.test01.Entity.Hexagon;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Main;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.mycompany.test01.Service.MapService;
import com.mycompany.test01.Util.GraphicUtil;

public class EditMapScreen implements Screen, InputProcessor {
    final Main game;
    final Stage stage;
    final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;
    final MapService mapService;
    private boolean isMiniMapVisible = false;
    private EditMapMode mode;
    private final Label modeLabel;
    private Label selectedTerrainLabel;
    private Label selectedFortificationLabel;
    private Label selectedRoadLabel;
    private final Table terrainButtonPanel;  // Panel to hold the terrain buttons
    //fortificationButtonPanel
    private final Table fortificationButtonPanel;  // Panel to hold the terrain buttons
    private final Table roadButtonPanel;  // Panel to hold the terrain buttons

    private final Skin skin; //Skin for UI elements
    private HexagonCategory selectedTerrain = HexagonCategory.GRASS;
    private FortificationCategory selectedFortification = FortificationCategory.NO_FORTIFICATION;
    private RoadCategory selectedRoad = RoadCategory.NO_ROAD;

    private RoadDrawFlagCategory roadDrawFlag = RoadDrawFlagCategory.EMPTY;

    public EditMapScreen(Main game) {
        this.mode = EditMapMode.NO_ACTION;
        this.mapService = MapService.getInstance();
        this.mapService.init();
        //mapService.updateMapSize();
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);

        this.font = new BitmapFont();
        this.skin = GraphicUtil.getButtonSkin(80, 30);
        //this.selectedTerrainPanel = null;
        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Map", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            font,
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
            font,
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
                mapService.setRoadStartHex(null);
                redrawMap();
            }
        });
        stage.addActor(buttonModeNoActionWrapper.getButton());

        ButtonWrapper buttonModeTerrainWrapper = new ButtonWrapper(
            "Terrain",
            font,
            50 + 10 + 160, 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeTerrainWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.TERRAIN;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideFortificationButtonPanel();// Show the terrain panel when in terrain mode
                hideRoadButtonPanel();
                showTerrainButtonPanel();
                mapService.setRoadStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeTerrainWrapper.getButton());

        ButtonWrapper buttonModeRiverWrapper = new ButtonWrapper(
            "River",
            font,
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
                mapService.setRoadStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeRiverWrapper.getButton());

        ButtonWrapper buttonModeRoadWrapper = new ButtonWrapper(
            "Road",
            font,
            50 + 3 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeRoadWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.ROAD;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                showRoadButtonPanel();
                mapService.setRoadStartHex(null);
                
                redrawMap();
            }
        });
        stage.addActor(buttonModeRoadWrapper.getButton());

        ButtonWrapper buttonModeFortificationWrapper = new ButtonWrapper(
            "Fortification",
            font,
            50 + 4 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeFortificationWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.FORTIFICATION;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideRoadButtonPanel();
                showFortificationButtonPanel();
                mapService.setRoadStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeFortificationWrapper.getButton());

        ButtonWrapper buttonModeMiscWrapper = new ButtonWrapper(
            "Misc",
            font,
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
                mapService.setRoadStartHex(null);

                redrawMap();
            }
        });
        stage.addActor(buttonModeMiscWrapper.getButton());

        drawingMapPixmap = new Pixmap((int) mapService.getMapWidth(),(int) mapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(Color.DARK_GRAY);
        drawingMapPixmap.fill();

        mapService.drawMap(drawingMapPixmap, mode);

        drawingTexture = new Texture(drawingMapPixmap);

        terrainButtonPanel = createTerrainButtonPanel();
        fortificationButtonPanel = createFortificationButtonPanel();
        roadButtonPanel = createRoadButtonPanel();

        terrainButtonPanel.setVisible(false); // Initially hidden
        fortificationButtonPanel.setVisible(false);
        roadButtonPanel.setVisible(false);
    }

    private void redrawMap() {
        // Dispose of the old texture and pixmap
        if (drawingTexture != null) drawingTexture.dispose();
        if (drawingMapPixmap != null) drawingMapPixmap.dispose();

        // Create a new pixmap
        drawingMapPixmap = new Pixmap((int) mapService.getMapWidth(),(int) mapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(Color.DARK_GRAY);
        drawingMapPixmap.fill();

        // Redraw the map to the pixmap
        mapService.drawMap(drawingMapPixmap, mode);

        // Create a new texture from the pixmap
        drawingTexture = new Texture(drawingMapPixmap);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //redrawMap();

        batch.begin();
        batch.draw(drawingTexture, mapService.getMapX(), mapService.getMapY());
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
        float mapX = mapService.getMapX();
        float mapY = mapService.getMapY();
        float mapWidth = mapService.getMapWidth();
        float mapHeight = mapService.getMapHeight();
        int margin = mapService.getMargin();
        int hexagonSize = mapService.getHexagonSize();

        //System.out.println("worldCoords.x : " + worldCoords.x + " / worldCoords.y : " + worldCoords.y);
        //System.out.println("screenX : " + screenX + " / screenY : " + screenY);

        int x = (int) (screenX - mapX - margin);
        int y = (int) (screenY - 45 - margin);
        //System.out.println("x : " + x + " / y : " + y);

        // tester si miniMap visible et clic dans minimap
        if(this.isMiniMapVisible) {
            if( x > mapService.getMiniMapX()
                && x < mapService.getMiniMapX() + mapService.getMiniMapWidth() - 2 * mapService.getMiniMapMargin()
                && y > mapService.getMiniMapY()
                && y < mapService.getMiniMapY() + mapService.getMiniMapHeight() - 2 * mapService.getMiniMapMargin()) {
                System.out.println("clic in minimap");
                mapService.updateMiniMap(x, y, drawingMapPixmap);
                //mapService.showMiniMap(drawingMapPixmap);
                //drawingTexture.draw(drawingMapPixmap, 0, 0);
                redrawMap();
                mapService.showMiniMap(drawingMapPixmap);
                drawingTexture.draw(drawingMapPixmap, 0, 0);

            }
        }
        else if (x >= 0 && x <= mapWidth - margin &&
            y >= 0 && y <= mapHeight - margin) {
            System.out.println("clic in !!");

            if(this.mode == EditMapMode.NO_ACTION) {
                int i = mapService.getIFromXY(x, y);
                int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                System.out.println("i : " + i);

                if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                    Hexagon clickedHexagon = mapService.getHexesArray().get(i + mapService.getStartI()).get(j + mapService.getStartJ());
                    System.out.println("hex terrain : " + clickedHexagon.getCategory());
                    mapService.renderHex( i + mapService.getStartI(), j + mapService.getStartJ(), GraphicUtil.redTexture, drawingMapPixmap);
                    drawingTexture.draw(drawingMapPixmap, 0, 0);
                }

                Hexagon[] neighbours = mapService.getNeighborhoodHexes(i, j);
                for(int k=0; k<6; k++) {
                    if(neighbours[k] != null) {
                        int ii = neighbours[k].getX();
                        int jj = neighbours[k].getY();
                        if (ii - mapService.getStartI() >= 0 &&
                            ii - mapService.getStartI() < mapService.getMaxI() &&
                            jj - mapService.getStartJ() >= 0 &&
                            jj - mapService.getStartJ() < mapService.getMaxJ()
                        ) {
                            mapService.renderHex( ii, jj, GraphicUtil.orangeTexture, drawingMapPixmap);
                            drawingTexture.draw(drawingMapPixmap, 0, 0);
                        }

                    }
                }
            }
            else if(this.mode == EditMapMode.TERRAIN) {
                int i = mapService.getIFromXY(x, y);
                int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                System.out.println("i : " + i);

                //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                if(mapService.isClickInMap(i, j)) {
                    if(mapService.getHexesArray().get(i+mapService.getStartI()).get(j+mapService.getStartJ()).getCategory() != this.selectedTerrain) {
                        mapService.getHexesArray().get(i+mapService.getStartI()).get(j+mapService.getStartJ()).setCategory(this.selectedTerrain);
                    }
                    redrawMap();
                }
            }
            else if(this.mode == EditMapMode.FORTIFICATION) {
                int i = mapService.getIFromXY(x, y);
                int j = mapService.getJFromY(y);
                //int i = (int) x / mapService.getGapX();
                System.out.println("i : " + i);
                //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                if(mapService.isClickInMap(i, j)) {
                    if(mapService.getHexesArray().get(i+mapService.getStartI()).get(j+mapService.getStartJ()).getFortification() != this.selectedFortification) {
                        mapService.getHexesArray().get(i+mapService.getStartI()).get(j+mapService.getStartJ()).setFortification(this.selectedFortification);
                    }
                    redrawMap();
                }
            }
            else if(this.mode == EditMapMode.ROAD) {
                redrawMap();
                int i = mapService.getIFromXY(x, y);
                int j = mapService.getJFromY(y);
                //Hexagon clickedHexagon = null; // TODO transformer en variable globale : roadStartHex
                //Hexagon[] neighboursForRoad = null; // TODO transformer en variable globale : roadStartHexNeighbours
                if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {

                    //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                    if(mapService.getHexesArray().get(i + mapService.getStartI()).get(j + mapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                        //System.out.println("old roadDrawFlag : " + roadDrawFlag.toString());

                        if(roadDrawFlag == RoadDrawFlagCategory.EMPTY || roadDrawFlag == RoadDrawFlagCategory.SECOND_CLICK_DONE) {
                            mapService.setRoadStartHex(mapService.getHexesArray().get(i + mapService.getStartI()).get(j + mapService.getStartJ()));

                            //mapService.renderHex( mapService.getRoadStartHex().getX(), mapService.getRoadStartHex().getY(), GraphicUtil.redTexture, drawingMapPixmap);
                            //drawingTexture.draw(drawingMapPixmap, 0, 0);

                            mapService.setRoadStartHexNeighbours(mapService.getNeighborhoodHexes(i, j));
                            redrawMap();

                            roadDrawFlag = RoadDrawFlagCategory.FIRST_CLICK_DONE;
                            //neighboursForRoad = mapService.getNeighborhoodHexes(i, j);

                            // mapService.renderNeighbours(drawingTexture, drawingMapPixmap);
                        }
                        else if(roadDrawFlag == RoadDrawFlagCategory.FIRST_CLICK_DONE && mapService.isInNeighbours(i, j)) {
                            Hexagon startHex = mapService.getRoadStartHex();
                            Hexagon endHex = mapService.getHexesArray().get(i + mapService.getStartI()).get(j + mapService.getStartJ());
                            // -> set les routes pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                            int k = mapService.getKFromRoadNeighbours(endHex);
                            mapService.setRoadForHexes(startHex, endHex, selectedRoad, k);
                            mapService.setRoadStartHex(endHex);
                            mapService.setRoadStartHexNeighbours(mapService.getNeighborhoodHexes(i, j));

                            redrawMap();
                            roadDrawFlag = RoadDrawFlagCategory.SECOND_CLICK_DONE;
                        }
                        //System.out.println("new roadDrawFlag : " + roadDrawFlag.toString());
                    }
                    else {
                        mapService.setRoadStartHex(null);
                        redrawMap();
                    }
                }

                /*
                 * si 1e click (click et roadDrawFlag à "EMPTY" ou "SECOND_CLICK_DONE")
                 *          -> set le roadStartHex (null a l'init) sur l'hex cliqué
                 *          -> set roadDrawFlag à "FIRST_CLICK_DONE" (3 valeurs : "EMPTY" "FIRST_CLICK_DONE" "SECOND_CLICK_DONE")
                 *          -> provoque le dessin de l'hex cliqué et de ses voisins dans renderMap
                 * si 2e click (click et roadDrawFlag à "FIRST_CLICK_DONE") sur un hex voisin
                 *          -> extraire k (indice du tableau des hex voisins
                 *              qui indique quel hex est ciblé : NW-NE-W-E-SW-SE) dans le tableau des hex voisins
                 *          -> set le roadStartHex sur hex cliqué
                 *          -> set les routes pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                 *          -> redessine la carte
                 *          -> set roadDrawFlag à "SECOND_CLICK_DONE"
                 *
                 * TODO prévoir bouton pour raz et set roadDrawFlag à "EMPTY" et vider roadStartHex et le tableau des voisins et redessiner la carte
                 *
                 */
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
                    mapService.setStartI(mapService.getStartI() + delta);
                    redrawMap();
                }

                break;
            case Input.Keys.RIGHT:
                if(!this.isMiniMapVisible) {
                    mapService.setStartI(mapService.getStartI() - delta);
                    redrawMap();
                }
                break;
            case Input.Keys.UP:
                if(!this.isMiniMapVisible) {
                    mapService.setStartJ(mapService.getStartJ() + delta);
                    redrawMap();
                }
                break;
            case Input.Keys.DOWN:
                if(!this.isMiniMapVisible) {
                    mapService.setStartJ(mapService.getStartJ() - delta);
                    redrawMap();
                }
                break;
            case 74: // 'm/M'
                this.isMiniMapVisible = !this.isMiniMapVisible;
                System.out.println("isMiniMapVisible : " + this.isMiniMapVisible);
                if(this.isMiniMapVisible) {
                    System.out.println("Showing miniMap");
                    mapService.showMiniMap(drawingMapPixmap);
                    drawingTexture.draw(drawingMapPixmap, 0, 0);
                }
                else {
                    redrawMap();
                }
                break;
            default:
                System.out.println("Autre touche appuyée");
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
        panel.defaults().pad(5);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedTerrainLabel = new Label("Selected Terrain : " + this.selectedTerrain.toString(), labelStyle);
        //this.selectedTerrainLabel.setPosition(50, 150);
         // Add some padding around the buttons
        panel.add(this.selectedTerrainLabel).colspan(5);
        panel.row();
        // Define the terrain types (you can load these from a file or configuration)
        HexagonCategory[] terrainTypes = {HexagonCategory.FOREST,
        HexagonCategory.GRASS,
        HexagonCategory.SAND,
        HexagonCategory.SWAMP,
        HexagonCategory.WATER};
        EditMapScreen that = this;
        // Create buttons for each terrain type
        for (HexagonCategory terrainType : terrainTypes) {
            TextButton button = new TextButton(terrainType.toString(), skin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    // Handle the terrain selection
                    System.out.println("Selected terrain: " + terrainType.toString());
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
        panel.add(terrainImage).colspan(5).width(64).height(64);
        panel.row();


        // Position the panel in the bottom-right corner
        panel.setPosition(Gdx.graphics.getWidth() - 270f, 80f);
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
        Skin buttonSkin = GraphicUtil.getButtonSkin(160, 30);
        int count = 1;
        for (FortificationCategory fortificationType : fortificationTypes) {
            TextButton button = new TextButton(fortificationType.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("Selected fortification : " + fortificationType.toString());
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
        Skin buttonSkin = GraphicUtil.getButtonSkin(160, 30);

        for (RoadCategory roadCategory : roadCategories) {
            TextButton button = new TextButton(roadCategory.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //System.out.println("Selected fortification: " + fortificationType.toString());
                    selectedRoad = roadCategory;
                    selectedRoadLabel.setText("Selected Road : " + roadCategory.toString());
                    roadImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromRoad(32, 32, 3, selectedRoad))));
                }
            });
            panel.add(button);
        }
        panel.row();
        panel.add(roadImage).colspan(5).width(32).height(32);
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
