package com.mycompany.test01.Entity.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.MapUtil;

public class Map {
    private String name = "Default map name";
    private Array<Array<Hexagon>> hexesArray;
    private int limitI = 0;
    private int limitJ = 0;
    private int gapX = 0, gapY = 0, margin = 0;
    private int maxI = 0, maxJ = 0, startI = 0, startJ = 0;
    private float mapX = 0, mapY = 0, mapWidth = 0, mapHeight = 0;
    private int hexagonSize = 0;
    private ZoomLevelEnum zoomLevel;

    private MapDisplayFlags displayFlags;

    public Map() {
        this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
        this.displayFlags = new MapDisplayFlags();
    }

    public Map(
        String name,
        Array<Array<Hexagon>> hexesArray,
        int limitI, int limitJ,
        int gapX, int gapY,
        int margin,
        int maxI, int maxJ,
        int startI, int startJ,
        float mapX, float mapY,
        float mapWidth, float mapHeight,
        int hexagonSize,
        ZoomLevelEnum zoomLevel,
        MapDisplayFlags displayFlags
    ) {
        this.name = name;
        this.hexesArray = hexesArray;
        this.limitI = limitI;
        this.limitJ = limitJ;
        this.gapX = gapX;
        this.gapY = gapY;
        this.margin = margin;
        this.maxI = maxI;
        this.maxJ = maxJ;
        this.startI = startI;
        this.startJ = startJ;
        this.mapX = mapX;
        this.mapY = mapY;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.hexagonSize = hexagonSize;
        this.zoomLevel = zoomLevel;
        this.displayFlags = displayFlags;
    }

    // méthodes d'instance

    public void initMap() {
        int limitI = this.getLimitI();
        int limitJ = this.getLimitJ();
        this.setHexagonSize(this.getZoomLevel().getHexSize());
        this.setGapX((int) this.getHexagonSize() * 5 / 3);
        this.setGapY((int) this.getHexagonSize() * 3 / 2);
        this.setMargin(10);

        this.setMapWidth( Gdx.graphics.getWidth() - 500f);

        this.setMapHeight(Gdx.graphics.getHeight() - 230f);

        this.setMaxI((int) (this.getMapWidth() - this.getMargin() * 2) / (this.getGapX()));
        this.setMaxI(this.getMaxI() % 2 == 0 ? this.getMaxI() : this.getMaxI() - 1);
        this.setMaxI(Math.min(this.getMaxI(), this.getLimitI()));
        this.setMaxJ((int) (this.getMapHeight() - this.getMargin() * 2) / (this.getGapY()));
        this.setMaxJ(this.getMaxJ() % 2 == 0 ? this.getMaxJ() : this.getMaxJ() - 1);
        this.setMaxJ(Math.min(this.getMaxJ(), this.getLimitJ()));

        this.setMapX(50);
        this.setMapY(180);

        this.setStartI((int) (limitI - this.getMaxI()) / 2);
        this.setStartI(this.getStartI() % 2 == 0 ? this.getStartI() : this.getStartI() + 1);
        this.setStartI(Math.max(this.getStartI(), 0));
        this.setStartI(Math.min(this.getStartI(), limitI - this.getMaxI()));

        this.setStartJ((int) (limitJ - this.getMaxJ()) / 2);
        this.setStartJ(this.getStartJ() % 2 == 0 ? this.getStartJ() : this.getStartJ() + 1);
        this.setStartJ(Math.max(this.getStartJ(), 0));
        this.setStartJ(Math.min(this.getStartJ(), limitJ - this.getMaxJ()));
    }

    public void initMapFromZoom() {
        int limitI = this.getLimitI();
        int limitJ = this.getLimitJ();
        int middleI = this.getStartI() + ( this.getMaxI() / 2 );
        middleI -= middleI % 2;
        int middleJ = this.getStartJ() + ( this.getMaxJ() / 2 );
        middleJ -= middleJ % 2;

        this.setHexagonSize(this.getZoomLevel().getHexSize());
        this.setGapX((int) this.getHexagonSize() * 5 / 3);
        this.setGapY((int) this.getHexagonSize() * 3 / 2);
        this.setMargin(10);

        this.setMapWidth(Gdx.graphics.getWidth() - 500f);
        this.setMapHeight(Gdx.graphics.getHeight() - 230f);

        this.setMaxI((int) (this.getMapWidth() - this.getMargin() * 2) / (this.getGapX()));
        this.setMaxI(this.getMaxI() % 2 == 0 ? this.getMaxI() : this.getMaxI() - 1);
        this.setMaxI(Math.min(this.getMaxI(), limitI));

        this.setMaxJ((int) (this.getMapHeight() - this.getMargin() * 2) / (this.getGapY()));
        this.setMaxJ(this.getMaxJ() % 2 == 0 ? this.getMaxJ() : this.getMaxJ() - 1);
        this.setMaxJ(Math.min(this.getMaxJ(), limitJ));

        this.setMapX(50);
        this.setMapY(180);

        this.setStartI(middleI - ( this.getMaxI() / 2 ));
        this.setStartI( this.getStartI() % 2 == 0 ? this.getStartI() : this.getStartI() + 1);
        this.setStartI(Math.max(this.getStartI(), 0));
        this.setStartI(Math.min(this.getStartI(), limitI - this.getMaxI()));

        this.setStartJ(middleJ - ( this.getMaxJ() / 2 ));
        this.setStartJ(this.getStartJ() % 2 == 0 ? this.getStartJ() : this.getStartJ() + 1);
        this.setStartJ(Math.max(this.getStartJ(), 0));
        this.setStartJ(Math.min(this.getStartJ(), limitJ - this.getMaxJ()));
    }

    public void setMapData(MapData mapData) {
        this.setLimitI(mapData.getLimitI());
        this.setLimitJ(mapData.getLimitJ());

        int limitI = this.getLimitI();
        int limitJ = this.getLimitJ();
        this.setHexesArray(new Array<Array<Hexagon>>(limitI));
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                row.add(mapData.getDataTab()[i][j]);
            }
            this.getHexesArray().add(row);
        }
        //System.out.println("limitI : " + limitI + " / limitJ : " + limitJ);
        this.initMap();
        //generateBridgesFromRiversAndRoads();
    }

    public void drawMap(Pixmap drawingPixmap) {
        for(int i=0; i < this.getMaxI(); i++) {
            for (int j=0; j < this.getMaxJ(); j++) {
                int x = getXFromIJ(i, j);
                int y = getYFromJ(j);

                Texture texture = GraphicUtil.getTextureFromTerrain(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getCategory());

                drawHexagon(drawingPixmap, x, y, this.getHexagonSize(), texture, Color.BLACK);
                //renderHex(i + startI, j + startJ, texture, drawingPixmap);

                for (int k = 0; k < 6; k++) {
                    if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getCliffs()[k].isCliff()
                        && this.displayFlags.isCliffVisible()) {
                        drawCliffSide(drawingPixmap, i, j, this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getCliffs()[k], k);
                    }
                    if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getRivers()[k] != RiverCategory.NO_RIVER
                        && this.displayFlags.isRiverVisible()) {
                        drawRiverSide(drawingPixmap, i, j, this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getRivers()[k], k);
                    }
                    if(!this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getBridges().getEdges()[k].getBridgeType().equals(BridgeTypeEnum.NO_BRIDGE)
                        && this.displayFlags.isBridgeVisible()) {
                        drawBridgeSide(drawingPixmap, i, j, this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getBridges().getEdges()[k].getBridgeType(), k);
                    }
                    if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getRoads().getEdges()[k].isPathway()
                        && this.displayFlags.isRoadVisible()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.PATHWAY, k);
                    }
                    if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getRoads().getEdges()[k].isRoadway()
                        && this.displayFlags.isRoadVisible()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.ROADWAY, k);
                    }
                    if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getRoads().getEdges()[k].isRailway()
                        && this.displayFlags.isRoadVisible()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.RAILWAY, k);
                    }
                    if(!this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getFortification().equals(FortificationCategory.NO_FORTIFICATION)
                        && this.displayFlags.isFortificationVisible()) {
                        drawFortification(
                            drawingPixmap,
                            x, y, this.getHexagonSize() * 2, // ajouté !!
                            GraphicUtil.getTextureFromFortification(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getFortification()));

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
                x - this.getHexagonSize(), y - this.getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getHexagonSize() * 2, this.getHexagonSize() * 2    // Dest width & height (scaling)
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
                x - this.getHexagonSize(), y - this.getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getHexagonSize() * 2, this.getHexagonSize() * 2    // Dest width & height (scaling)
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
                x - this.getHexagonSize(), y - this.getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getHexagonSize() * 2, this.getHexagonSize() * 2    // Dest width & height (scaling)
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
                x - this.getHexagonSize(), y - this.getHexagonSize(),            // Dest X,Y (top-left of destination)
                this.getHexagonSize() * 2, this.getHexagonSize() * 2    // Dest width & height (scaling)
            );
            texturePixmap.dispose();
        }
        texture.dispose();
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
        int centerX = getXFromIJ(hexI - this.getStartI(), hexJ - this.getStartJ());
        int centerY = getYFromJ(hexJ - this.getStartJ());
        // Dessiner l'hexagone avec la couleur spécifiée
        //Texture textureGrass = GraphicUtil.loadTexture("texture/texture-grass.png");
        drawHexagon(pixmap, centerX, centerY, this.getHexagonSize(), texture, Color.BLACK);
    }

    public int getXFromIJ(int i, int j) {
        int toReturn = (int) this.getGapX() * i + this.getGapX() / 2 + this.getMargin();
        if( j % 2 == 0) {
            toReturn += (int) this.getGapX() / 2;
        }
        return toReturn;
    }

    public int getYFromJ (int j) {
        return this.getGapY() * j + this.getHexagonSize() + this.getMargin();
    }

    public int getIFromXY(int x, int y) {
        //int j = (int) ((y - this.hexSize * 0.5) / (this.hexSize * 1.5));
        int j = getJFromY(y);
        //System.out.println("j : " + j);

        int i = 0;
        if(j % 2 == 0) {
            i = (int) (x - this.getGapX() / 2) / this.getGapX();
        }
        else {
            i = (int) x / this.getGapX();
        }
        return i;
    }

    public int getJFromY(int y) {
        return (int) ((y - this.getHexagonSize() * 0.5) / (this.getHexagonSize() * 1.475)); // !!!!!!!!!!!!!!!!!!
    }

    // Getters et Setters

    public void setStartI(int startI) {
        this.startI = startI;
        /*
        if(startI%2 != 0) startI--;
        if(startI > this.getLimitI() - this.getMaxI() - 1) {
            this.startI = this.getLimitI() - this.getMaxI() - 1;
            //this.setStartI(this.getLimitI() - this.getMaxI() - 1);
        }
        else if (startI < 0) {
            this.startI = 0;
            //this.setStartI(0);
        }
        else {
            this.startI = startI;
            //this.setStartI(startI);
        }*/
    }

    public void setStartJ(int startJ) {
        this.startJ = startJ;
        /*
        if(startJ%2 != 0) startJ--;
        if(startJ > this.getLimitJ() - this.getMaxJ() - 1) {
            //this.setStartJ(this.getLimitJ() - this.getMaxJ() - 1);
            this.startJ = this.getLimitJ() - this.getMaxJ() - 1;
        }
        else if (startJ < 0) {
            //this.setStartJ(0);
            this.startJ = 0;
        }
        else {
            //this.setStartJ(startJ);
            this.startJ = startJ;
        }*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    }

    public int getGapX() {
        return gapX;
    }

    public void setGapX(int gapX) {
        this.gapX = gapX;
    }

    public int getGapY() {
        return gapY;
    }

    public void setGapY(int gapY) {
        this.gapY = gapY;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getMaxI() {
        return maxI;
    }

    public void setMaxI(int maxI) {
        this.maxI = maxI;
    }

    public int getMaxJ() {
        return maxJ;
    }

    public void setMaxJ(int maxJ) {
        this.maxJ = maxJ;
    }

    public int getStartI() {
        return startI;
    }

    /*
    public void setStartI(int startI) {
        this.startI = startI;
    }*/

    public int getStartJ() {
        return startJ;
    }

    /*
    public void setStartJ(int startJ) {
        this.startJ = startJ;
    }*/

    public float getMapX() {
        return mapX;
    }

    public void setMapX(float mapX) {
        this.mapX = mapX;
    }

    public float getMapY() {
        return mapY;
    }

    public void setMapY(float mapY) {
        this.mapY = mapY;
    }

    public float getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(float mapWidth) {
        this.mapWidth = mapWidth;
    }

    public float getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(float mapHeight) {
        this.mapHeight = mapHeight;
    }

    public int getHexagonSize() {
        return hexagonSize;
    }

    public void setHexagonSize(int hexagonSize) {
        this.hexagonSize = hexagonSize;
    }

    public ZoomLevelEnum getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(ZoomLevelEnum zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public MapDisplayFlags getDisplayFlags() {
        return displayFlags;
    }

    public void setDisplayFlags(MapDisplayFlags displayFlags) {
        this.displayFlags = displayFlags;
    }
}
