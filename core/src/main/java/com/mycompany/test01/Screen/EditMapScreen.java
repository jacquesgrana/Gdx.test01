package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Entity.Hexagon;
import com.mycompany.test01.Enum.EditMapMode;
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
    private Label modeLabel;

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
                that.modeLabel.setText("Edit Mode : NO_ACTION");
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
                that.modeLabel.setText("Edit Mode : TERRAIN");
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
                that.modeLabel.setText("Edit Mode : RIVER");
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
                that.modeLabel.setText("Edit Mode : ROAD");
            }
        });
        stage.addActor(buttonModeRoadWrapper.getButton());

        ButtonWrapper buttonModeMiscWrapper = new ButtonWrapper(
            "Misc",
            font,
            50 + 4 * (10 + 160), 80, 160, 40);
        //EditMapScreen that = this;
        buttonModeMiscWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.MISC;
                that.modeLabel.setText("Edit Mode : MISC");
            }
        });
        stage.addActor(buttonModeMiscWrapper.getButton());

        drawingMapPixmap = new Pixmap((int) mapService.getMapWidth(),(int) mapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(Color.DARK_GRAY);
        drawingMapPixmap.fill();

        mapService.drawMap(drawingMapPixmap);

        drawingTexture = new Texture(drawingMapPixmap);


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
        mapService.drawMap(drawingMapPixmap);

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
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        /*
        this.mapService.setMapWidth(width - 80f);
        this.mapService.setMapHeight(height - 120f);
        this.mapService.init();
        this.redrawMap();
        */
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

            int j = (int) ((y - hexagonSize * 0.5) / (hexagonSize * 1.5));
            System.out.println("j : " + j);
            int i = 0;
            if(j % 2 == 0) {
                i = (int) (x - mapService.getGapX() / 2) / mapService.getGapX();
            }
            else {
                i = (int) x / mapService.getGapX();
            }
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
                    mapService.renderHex( ii, jj, GraphicUtil.orangeTexture, drawingMapPixmap);
                    drawingTexture.draw(drawingMapPixmap, 0, 0);
                }
            }


            return true; // Indique que l'événement a été traité

            // Le clic est dans la zone de la Pixmap
            //float localX = worldCoords.x - mapX; // Soustraire la marge de 10
            //float localY = mapService.getMapHeight() - (worldCoords.y - mapY); // Soustraire la marge de 10

            /*

            // Calculer quelle tuile hexagonale a été cliquée
            int hexX = (int) (localX / mapService.getGapX());
            int hexY = (int) (localY / mapService.getGapY());

            // Ajuster pour le décalage une ligne sur deux
            if (hexY % 2 == 0) {
                hexX = (int) ((localX + mapService.getGapX() / 2f) / mapService.getGapX());
            }

            // Ajouter le décalage de départ
            hexX += mapService.getStartI();
            hexY += mapService.getStartJ();

            // Vérifier si l'hexagone cliqué est dans les limites de la carte
            if (hexX >= 0 && hexX < mapService.getLimitI() && hexY >= 0 && hexY < mapService.getLimitJ()) {
                System.out.println("Tuile hexagonale cliquée : (" + hexX + ", " + hexY + ")");

                // Ajouter ici la logique pour interagir avec l'hexagone cliqué
                // Par exemple :
                Hexagon clickedHexagon = mapService.getHexesArray().get(hexX).get(hexY);

                System.out.println("hex terrain : " + clickedHexagon.getCategory());
                // Dessiner un hexagone rouge au bon endroit
                mapService.renderHex(hexX, hexY, Color.RED, drawingPixmap);

                // Mettre à jour la texture pour refléter les modifications du Pixmap
                drawingTexture.draw(drawingPixmap, 0, 0);



                return true; // Indique que l'événement a été traité
            }*/
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
        System.out.println("keycode : " + keycode);
        switch (keycode) {
            case Input.Keys.LEFT:
                mapService.setStartI(mapService.getStartI() + delta);
                redrawMap();
                break;
            case Input.Keys.RIGHT:
                mapService.setStartI(mapService.getStartI() - delta);
                redrawMap();
                break;
            case Input.Keys.UP:
                mapService.setStartJ(mapService.getStartJ() + delta);
                redrawMap();
                break;
            case Input.Keys.DOWN:
                mapService.setStartJ(mapService.getStartJ() - delta);
                redrawMap();
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

}
