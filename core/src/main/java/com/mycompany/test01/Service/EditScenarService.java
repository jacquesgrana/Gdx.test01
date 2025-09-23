package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Cliff;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Entity.Scenario.Scenario;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.MapUtil;

public class EditScenarService {
    private static EditScenarService instance = null;

    //private Array<Array<Hexagon>> hexesArray;
    //private int limitI;
    //private int limitJ;
    //private int gapX, gapY, margin;
    //private int maxI, maxJ, startI, startJ;
    //private float mapX, mapY, mapWidth, mapHeight;

    //private int hexSize;

    //private ZoomLevelEnum zoomLevel;

    private Scenario scenario = null;

    public EditScenarService() {
        this.scenario = new Scenario();
        //this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
    }

    public static EditScenarService getInstance() {
        if (instance == null) {
            instance = new EditScenarService();
        }
        return instance;
    }

    /*
    public void initScenar() {
        this.scenario = new Scenario();
    }*/

    // TODO : rendre limitI, limitJ, maxI, maxJ pairs !!!
    public void initMap() {
        int limitI = this.getScenario().getMap().getLimitI();
        int limitJ = this.getScenario().getMap().getLimitJ();
        this.getScenario().getMap().setHexagonSize(this.getScenario().getMap().getZoomLevel().getHexSize());
        //this.gapX = (int) this.getScenario().getMap().getHexagonSize() * 5 / 3;
        this.getScenario().getMap().setGapX((int) this.getScenario().getMap().getHexagonSize() * 5 / 3);
        //this.gapY = (int) this.getScenario().getMap().getHexagonSize() * 3 / 2;
        this.getScenario().getMap().setGapY((int) this.getScenario().getMap().getHexagonSize() * 3 / 2);
        //this.margin = 10;
        this.getScenario().getMap().setMargin(10);

        //this.mapWidth = Gdx.graphics.getWidth() - 500f; // TODO : chercher valeur juste
        this.getScenario().getMap().setMapWidth( Gdx.graphics.getWidth() - 500f);

        //this.mapHeight = Gdx.graphics.getHeight() - 230f; // TODO : chercher valeur juste
        this.getScenario().getMap().setMapHeight(Gdx.graphics.getHeight() - 230f);

        //this.maxI = (int) (this.mapWidth - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapX());
        this.getScenario().getMap().setMaxI((int) (this.getScenario().getMap().getMapWidth() - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapX()));
        //this.maxI = this.maxI % 2 == 0 ? this.maxI : this.maxI - 1;
        this.getScenario().getMap().setMaxI(this.getScenario().getMap().getMaxI() % 2 == 0 ? this.getScenario().getMap().getMaxI() : this.getScenario().getMap().getMaxI() - 1);
        //this.maxI = Math.min(this.maxI, this.getScenario().getMap().getLimitI());
        this.getScenario().getMap().setMaxI(Math.min(this.getScenario().getMap().getMaxI(), this.getScenario().getMap().getLimitI()));
        //this.maxJ = (int) (this.mapHeight - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapY());
        this.getScenario().getMap().setMaxJ((int) (this.getScenario().getMap().getMapHeight() - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapY()));
        //this.maxJ = this.maxJ % 2 == 0 ? this.maxJ : this.maxJ - 1;
        this.getScenario().getMap().setMaxJ(this.getScenario().getMap().getMaxJ() % 2 == 0 ? this.getScenario().getMap().getMaxJ() : this.getScenario().getMap().getMaxJ() - 1);

        //this.maxJ = Math.min(this.maxJ, this.getScenario().getMap().getLimitJ());
        this.getScenario().getMap().setMaxJ(Math.min(this.getScenario().getMap().getMaxJ(), this.getScenario().getMap().getLimitJ()));

        //this.mapX = 50;
        this.getScenario().getMap().setMapX(50);
        //this.mapY = 180;
        this.getScenario().getMap().setMapY(180);

        //this.startI = (int) (limitI - this.getScenario().getMap().getMaxI()) / 2;
        this.getScenario().getMap().setStartI((int) (limitI - this.getScenario().getMap().getMaxI()) / 2);

        //this.startI = this.getScenario().getMap().getStartI() % 2 == 0 ? this.getScenario().getMap().getStartI() : this.getScenario().getMap().getStartI() + 1;
        this.getScenario().getMap().setStartI(this.getScenario().getMap().getStartI() % 2 == 0 ? this.getScenario().getMap().getStartI() : this.getScenario().getMap().getStartI() + 1);

        //this.startI = Math.max(this.getScenario().getMap().getStartI(), 0);
        this.getScenario().getMap().setStartI(Math.max(this.getScenario().getMap().getStartI(), 0));

        //this.startI = Math.min(this.getScenario().getMap().getStartI(), limitI - this.getScenario().getMap().getMaxI());
        this.getScenario().getMap().setStartI(Math.min(this.getScenario().getMap().getStartI(), limitI - this.getScenario().getMap().getMaxI()));


        //this.startJ = (int) (limitJ - this.getScenario().getMap().getMaxJ()) / 2;
        this.getScenario().getMap().setStartJ((int) (limitJ - this.getScenario().getMap().getMaxJ()) / 2);

        //this.startJ = this.getScenario().getMap().getStartJ() % 2 == 0 ? this.getScenario().getMap().getStartJ() : this.getScenario().getMap().getStartJ() + 1;
        this.getScenario().getMap().setStartJ(this.getScenario().getMap().getStartJ() % 2 == 0 ? this.getScenario().getMap().getStartJ() : this.getScenario().getMap().getStartJ() + 1);

        //this.startJ = Math.max(this.getScenario().getMap().getStartJ(), 0);
        this.getScenario().getMap().setStartJ(Math.max(this.getScenario().getMap().getStartJ(), 0));

        //this.startJ = Math.min(this.getScenario().getMap().getStartJ(), limitJ - this.getScenario().getMap().getMaxJ());
        this.getScenario().getMap().setStartJ(Math.min(this.getScenario().getMap().getStartJ(), limitJ - this.getScenario().getMap().getMaxJ()));

    }

    public void initMapFromZoom() {
        int limitI = this.getScenario().getMap().getLimitI();
        int limitJ = this.getScenario().getMap().getLimitJ();
        int middleI = this.getScenario().getMap().getStartI() + ( this.getScenario().getMap().getMaxI() / 2 );
        //middleI = middleI % 2 == 0 ? middleI : middleI - 1;
        middleI -= middleI % 2;
        int middleJ = this.getScenario().getMap().getStartJ() + ( this.getScenario().getMap().getMaxJ() / 2 );
        //middleJ = middleJ % 2 == 0 ? middleJ : middleJ - 1;
        middleJ -= middleJ % 2;

        //this.hexSize = this.zoomLevel.getHexSize();
        this.getScenario().getMap().setHexagonSize(this.getScenario().getMap().getZoomLevel().getHexSize());
        //this.gapX = (int) this.getScenario().getMap().getHexagonSize() * 5 / 3;
        //this.getScenario().getMap().getGapX()
        this.getScenario().getMap().setGapX((int) this.getScenario().getMap().getHexagonSize() * 5 / 3);
        //this.gapY = (int) this.getScenario().getMap().getHexagonSize() * 3 / 2;
        this.getScenario().getMap().setGapY((int) this.getScenario().getMap().getHexagonSize() * 3 / 2);
        //this.margin = 10;
        this.getScenario().getMap().setMargin(10);

        //this.mapWidth = Gdx.graphics.getWidth() - 500f;
        this.getScenario().getMap().setMapWidth(Gdx.graphics.getWidth() - 500f);

        //this.mapHeight = Gdx.graphics.getHeight() - 230f;
        this.getScenario().getMap().setMapHeight(Gdx.graphics.getHeight() - 230f);

        //this.maxI = (int) (this.mapWidth - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapX());
        this.getScenario().getMap().setMaxI((int) (this.getScenario().getMap().getMapWidth() - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapX()));
        //this.maxI = this.maxI % 2 == 0 ? this.maxI : this.maxI - 1;
        this.getScenario().getMap().setMaxI(this.getScenario().getMap().getMaxI() % 2 == 0 ? this.getScenario().getMap().getMaxI() : this.getScenario().getMap().getMaxI() - 1);
        //this.maxI = Math.min(this.getScenario().getMap().getMaxI(), limitI);
        this.getScenario().getMap().setMaxI(Math.min(this.getScenario().getMap().getMaxI(), limitI));
        //this.maxJ = (int) (this.mapHeight - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapY());
        this.getScenario().getMap().setMaxJ((int) (this.getScenario().getMap().getMapHeight() - this.getScenario().getMap().getMargin() * 2) / (this.getScenario().getMap().getGapY()));
        //this.maxJ = this.getScenario().getMap().getMaxJ() % 2 == 0 ? this.getScenario().getMap().getMaxJ() : this.getScenario().getMap().getMaxJ() - 1;
        this.getScenario().getMap().setMaxJ(this.getScenario().getMap().getMaxJ() % 2 == 0 ? this.getScenario().getMap().getMaxJ() : this.getScenario().getMap().getMaxJ() - 1);

        //this.maxJ = Math.min(this.getScenario().getMap().getMaxJ(), limitJ);
        this.getScenario().getMap().setMaxJ(Math.min(this.getScenario().getMap().getMaxJ(), limitJ));

        //this.mapX = 50;
        this.getScenario().getMap().setMapX(50);
        //this.mapY = 180;
        this.getScenario().getMap().setMapY(180);

        //this.startI = middleI - ( this.getScenario().getMap().getMaxI() / 2 );
        this.getScenario().getMap().setStartI(middleI - ( this.getScenario().getMap().getMaxI() / 2 ));

        //this.startI = this.getScenario().getMap().getStartI() % 2 == 0 ? this.getScenario().getMap().getStartI() : this.getScenario().getMap().getStartI() + 1;
        this.getScenario().getMap().setStartI( this.getScenario().getMap().getStartI() % 2 == 0 ? this.getScenario().getMap().getStartI() : this.getScenario().getMap().getStartI() + 1);

        //this.startI = Math.max(this.getScenario().getMap().getStartI(), 0);
        this.getScenario().getMap().setStartI(Math.max(this.getScenario().getMap().getStartI(), 0));

        //this.startI = Math.min(this.getScenario().getMap().getStartI(), limitI - this.getScenario().getMap().getMaxI());
        this.getScenario().getMap().setStartI(Math.min(this.getScenario().getMap().getStartI(), limitI - this.getScenario().getMap().getMaxI()));


        //this.startJ = middleJ - ( this.getScenario().getMap().getMaxJ() / 2 );
        this.getScenario().getMap().setStartJ(middleJ - ( this.getScenario().getMap().getMaxJ() / 2 ));

        //this.startJ = this.getScenario().getMap().getStartJ() % 2 == 0 ? this.getScenario().getMap().getStartJ() : this.getScenario().getMap().getStartJ() + 1;
        this.getScenario().getMap().setStartJ(this.getScenario().getMap().getStartJ() % 2 == 0 ? this.getScenario().getMap().getStartJ() : this.getScenario().getMap().getStartJ() + 1);

        //this.startJ = Math.max(this.getScenario().getMap().getStartJ(), 0);
        this.getScenario().getMap().setStartJ(Math.max(this.getScenario().getMap().getStartJ(), 0));

        //this.startJ = Math.min(this.getScenario().getMap().getStartJ(), limitJ - this.getScenario().getMap().getMaxJ());
        this.getScenario().getMap().setStartJ(Math.min(this.getScenario().getMap().getStartJ(), limitJ - this.getScenario().getMap().getMaxJ()));

    }

    public void SetMapData(MapData mapData) {
        this.getScenario().getMap().setLimitI(mapData.getLimitI());
        this.getScenario().getMap().setLimitJ(mapData.getLimitJ());

        int limitI = this.getScenario().getMap().getLimitI();
        int limitJ = this.getScenario().getMap().getLimitJ();
        this.getScenario().getMap().setHexesArray(new Array<Array<Hexagon>>(limitI));
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                row.add(mapData.getDataTab()[i][j]);
            }
            this.getScenario().getMap().getHexesArray().add(row);
        }
        //System.out.println("limitI : " + limitI + " / limitJ : " + limitJ);
        initMap();
        //generateBridgesFromRiversAndRoads();
    }

    public void drawMap(Pixmap drawingPixmap) {
        for(int i=0; i < this.getScenario().getMap().getMaxI(); i++) {
            for (int j=0; j < this.getScenario().getMap().getMaxJ(); j++) {
                int x = getXFromIJ(i, j);
                int y = getYFromJ(j);

                Texture texture = GraphicUtil.getTextureFromTerrain(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getCategory());

                drawHexagon(drawingPixmap, x, y, this.getScenario().getMap().getHexagonSize(), texture, Color.BLACK);
                //renderHex(i + startI, j + startJ, texture, drawingPixmap);

                for (int k = 0; k < 6; k++) {
                    if(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getCliffs()[k].isCliff()) {
                        drawCliffSide(drawingPixmap, i, j, this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getCliffs()[k], k);
                    }
                    if(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getRivers()[k] != RiverCategory.NO_RIVER) {
                        drawRiverSide(drawingPixmap, i, j, this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getRivers()[k], k);
                    }
                    if(!this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getBridges().getEdges()[k].getBridgeType().equals(BridgeTypeEnum.NO_BRIDGE)) {
                        drawBridgeSide(drawingPixmap, i, j, this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getBridges().getEdges()[k].getBridgeType(), k);
                    }
                    if(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getRoads().getEdges()[k].isPathway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.PATHWAY, k);
                    }
                    if(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getRoads().getEdges()[k].isRoadway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.ROADWAY, k);
                    }
                    if(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getRoads().getEdges()[k].isRailway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.RAILWAY, k);
                    }
                    if(!this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getFortification().equals(FortificationCategory.NO_FORTIFICATION)) {
                        drawFortification(
                            drawingPixmap,
                            x, y, this.getScenario().getMap().getHexagonSize() * 2, // ajouté !!
                            GraphicUtil.getTextureFromFortification(this.getScenario().getMap().getHexesArray().get(i + this.getScenario().getMap().getStartI()).get(j + this.getScenario().getMap().getStartJ()).getFortification()));

                    }
                }
            }
        }
    }

    private void drawRoadSegment(Pixmap drawingPixmap, int i, int j, RoadCategory roadCategory, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getRoadTextureFromRoadCatAndK(roadCategory, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        // TODO faire méthode !!?
        if (texturePixmap != null) {
            // Draw the texture onto the drawingPixmap, scaling it to fit within the hexagonSize
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - this.getScenario().getMap().getHexagonSize(), y - this.getScenario().getMap().getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getScenario().getMap().getHexagonSize() * 2, this.getScenario().getMap().getHexagonSize() * 2    // Dest width & height (scaling)
            );

            texturePixmap.dispose();
        }
        texture.dispose();
    }

    private void drawRiverSide(Pixmap drawingPixmap, int i, int j, RiverCategory riverCategory, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getRiverTextureFromRiverCatAndK(riverCategory, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        // TODO faire méthode !!?
        if (texturePixmap != null) {
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - this.getScenario().getMap().getHexagonSize(), y - this.getScenario().getMap().getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getScenario().getMap().getHexagonSize() * 2, this.getScenario().getMap().getHexagonSize() * 2    // Dest width & height (scaling)
            );
            texturePixmap.dispose();
        }
        texture.dispose();

    }

    private void drawBridgeSide(Pixmap drawingPixmap, int i, int j, BridgeTypeEnum bridgeType, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getTextureSideFromBridge(bridgeType, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        // TODO faire méthode !!?
        if (texturePixmap != null) {
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - this.getScenario().getMap().getHexagonSize(), y - this.getScenario().getMap().getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getScenario().getMap().getHexagonSize() * 2, this.getScenario().getMap().getHexagonSize() * 2    // Dest width & height (scaling)
            );
            texturePixmap.dispose();
        }
        texture.dispose();
    }

    private void drawCliffSide(Pixmap drawingPixmap, int i, int j, Cliff cliff, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getTextureSideFromCliff(cliff, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        // TODO faire méthode !!?
        if (texturePixmap != null) {
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - this.getScenario().getMap().getHexagonSize(), y - this.getScenario().getMap().getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getScenario().getMap().getHexagonSize() * 2, this.getScenario().getMap().getHexagonSize() * 2    // Dest width & height (scaling)
            );
            texturePixmap.dispose();
        }
        texture.dispose();
    }

    /**
     * Draws a textured hexagon onto the provided Pixmap.
     *
     * @param pixmap       The Pixmap to draw on.
     * @param centerX      The x-coordinate of the hexagon's center.
     * @param centerY      The y-coordinate of the hexagon's center.
     * @param size         The size (radius) of the hexagon.
     * @param texture      The texture to fill the hexagon with.  Must be non-null
     * @param borderColor  The color of the hexagon's border.
     */
    public void drawHexagon(Pixmap pixmap, int centerX, int centerY, int size, Texture texture, Color borderColor) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * (i + 0.5);
            xPoints[i] = (int) (centerX + size * Math.cos(angle));
            yPoints[i] = (int) (centerY + size * Math.sin(angle));
        }

        // Fill with texture
        pixmap.setColor(Color.WHITE); // Important: set to white for texture drawing

        //Get the pixel data from the texture
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        if (texturePixmap != null) {
            for (int y = centerY - size; y <= centerY + size; y++) {
                for (int x = centerX - size; x <= centerX + size; x++) {
                    if (MapUtil.isInsideHexagon(x, y, xPoints, yPoints)) {
                        // Sample the texture
                        int textureX = (int) (((x - (centerX - size)) / (double) (2 * size)) * texturePixmap.getWidth());
                        int textureY = (int) (((y - (centerY - size)) / (double) (2 * size)) * texturePixmap.getHeight());

                        //Adjust textureX and textureY in case they are out of bounds
                        textureX = Math.max(0, Math.min(textureX, texturePixmap.getWidth() - 1));
                        textureY = Math.max(0, Math.min(textureY, texturePixmap.getHeight() - 1));

                        int pixelColor = texturePixmap.getPixel(textureX, textureY);
                        pixmap.drawPixel(x, y, pixelColor);
                    }
                }
            }
            texturePixmap.dispose();
        }


        // Contour
        pixmap.setColor(borderColor);
        for (int i = 0; i < 6; i++) {
            int j = (i + 1) % 6;
            pixmap.drawLine(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
        }
    }

    public void renderHex(int hexI, int hexJ, Texture texture, Pixmap pixmap) {
        // Calculer les coordonnées du centre de l'hexagone
        int centerX = getXFromIJ(hexI - this.getScenario().getMap().getStartI(), hexJ - this.getScenario().getMap().getStartJ());
        int centerY = getYFromJ(hexJ - this.getScenario().getMap().getStartJ());
        // Dessiner l'hexagone avec la couleur spécifiée
        //Texture textureGrass = GraphicUtil.loadTexture("texture/texture-grass.png");
        drawHexagon(pixmap, centerX, centerY, this.getScenario().getMap().getHexagonSize(), texture, Color.BLACK);
    }

    public static void drawFortification(
        Pixmap drawingPixmap,
        int x, int y, int hexagonSize,
        Texture fortifTexture) {

        // Check for null texture to avoid NullPointerException
        if (fortifTexture == null) {
            System.err.println("Error: fortifTexture is null.  Cannot draw fortification.");
            return; // Exit the method if the texture is null
        }

        // Get the pixel data from the texture
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(fortifTexture);

        if (texturePixmap != null) {
            // Draw the texture onto the drawingPixmap, scaling it to fit within the hexagonSize
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - hexagonSize/2, y - hexagonSize/2,            // Dest X,Y (top-left of destination)
                hexagonSize, hexagonSize    // Dest width & height (scaling)
            );

            texturePixmap.dispose();
        } else {
            System.err.println("Error: Could not convert fortifTexture to Pixmap.");
        }
    }

    /*
    private boolean isInsideHexagon(int x, int y, int[] xPoints, int[] yPoints) {
        boolean inside = false;
        for (int i = 0, j = 5; i < 6; j = i++) {
            if (((yPoints[i] > y) != (yPoints[j] > y)) &&
                (x < (xPoints[j] - xPoints[i]) * (y - yPoints[i]) / (yPoints[j] - yPoints[i]) + xPoints[i])) {
                inside = !inside;
            }
        }
        return inside;
    }*/

    public int getXFromIJ(int i, int j) {
        int toReturn = (int) this.getScenario().getMap().getGapX() * i + this.getScenario().getMap().getGapX() / 2 + this.getScenario().getMap().getMargin();
        if( j % 2 == 0) {
            toReturn += (int) this.getScenario().getMap().getGapX() / 2;
        }
        return toReturn;
    }

    public int getYFromJ (int j) {
        return this.getScenario().getMap().getGapY() * j + this.getScenario().getMap().getHexagonSize() + this.getScenario().getMap().getMargin();
    }

    /*
    public Array<Array<Hexagon>> getHexesArray() {
        return hexesArray;
    }

    public void setHexesArray(Array<Array<Hexagon>> hexesArray) {
        this.hexesArray = hexesArray;
    }

    public int getLimitI() {
        return limitI;
    }

    public void setLimitI(int limitI) {
        this.limitI = limitI;
    }

    public int getLimitJ() {
        return limitJ;
    }

    public void setLimitJ(int limitJ) {
        this.limitJ = limitJ;
    }*/

    /*
    public ZoomLevelEnum getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(ZoomLevelEnum zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
    */

    /*
    public int getStartI() {
        return startI;
    }
     */

    public void setStartI(int startI) {
        if(startI%2 != 0) startI--;
        if(startI > this.getScenario().getMap().getLimitI() - this.getScenario().getMap().getMaxI() - 1) {
            //this.startI = this.getScenario().getMap().getLimitI() - this.getScenario().getMap().getMaxI() - 1;
            this.getScenario().getMap().setStartI(this.getScenario().getMap().getLimitI() - this.getScenario().getMap().getMaxI() - 1);
        }
        else if (startI < 0) {
            //this.startI = 0;
            this.getScenario().getMap().setStartI(0);
        }
        else {
            //this.startI = startI;
            this.getScenario().getMap().setStartI(startI);
        }
        //this.startI = startI + this.maxI > this.limitI ? this.limitI - this.maxI : this.startI < 0 ? 0 : startI;
    }

    /*
    public int getStartJ() {
        return startJ;
    }
    */

    public void setStartJ(int startJ) {
        if(startJ%2 != 0) startJ--;
        if(startJ > this.getScenario().getMap().getLimitJ() - this.getScenario().getMap().getMaxJ() - 1) {
            this.getScenario().getMap().setStartJ(this.getScenario().getMap().getLimitJ() - this.getScenario().getMap().getMaxJ() - 1);
        }
        else if (startJ < 0) {
            this.getScenario().getMap().setStartJ(0);
        }
        else {
            this.getScenario().getMap().setStartJ(startJ);
        }
    }

    public int getIFromXY(int x, int y) {
        //int j = (int) ((y - this.hexSize * 0.5) / (this.hexSize * 1.5));
        int j = getJFromY(y);
        //System.out.println("j : " + j);

        int i = 0;
        if(j % 2 == 0) {
            i = (int) (x - this.getScenario().getMap().getGapX() / 2) / this.getScenario().getMap().getGapX();
        }
        else {
            i = (int) x / this.getScenario().getMap().getGapX();
        }
        return i;
    }

    public int getJFromY(int y) {
        return (int) ((y - this.getScenario().getMap().getHexagonSize() * 0.5) / (this.getScenario().getMap().getHexagonSize() * 1.475)); // !!!!!!!!!!!!!!!!!!
    }

    /*
    public float getMapX() {
        return mapX;
    }
     */

    /*
    public int getMargin() {
        return margin;
    }
     */

    /*
    public int getMaxJ() {
        return maxJ;
    }
     */

    /*
    public int getGapY() {
        return gapY;
    }
     */

    /*
    public int getGapX() {
        return gapX;
    }
    */

    /*
    public float getMapY() {
        return mapY;
    }
     */

    /*
    public float getMapWidth() {
        return mapWidth;
    }
     */

    /*
    public float getMapHeight() {
        return mapHeight;
    }
     */

    /*
    public int getHexSize() {
        return hexSize;
    }*/

    /*
    public int getMaxI() {
        return maxI;
    }
     */

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
