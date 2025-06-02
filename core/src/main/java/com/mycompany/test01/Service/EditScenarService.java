package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Cliff;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Util.GraphicUtil;

public class EditScenarService {
    private static EditScenarService instance = null;

    private Array<Array<Hexagon>> hexesArray;
    private int limitI;
    private int limitJ;
    private int gapX, gapY, margin;
    private int maxI, maxJ, startI, startJ;
    private float mapX, mapY, mapWidth, mapHeight;
    private int hexSize;

    private ZoomLevelEnum zoomLevel;

    public EditScenarService() {
        this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
    }

    public static EditScenarService getInstance() {
        if (instance == null) {
            instance = new EditScenarService();
        }
        return instance;
    }

    public void initMap() {
        this.hexSize = this.zoomLevel.getHexSize();
        this.gapX = (int) this.hexSize * 5 / 3;
        this.gapY = (int) this.hexSize * 3 / 2;
        this.margin = 10;

        this.mapWidth = Gdx.graphics.getWidth() - 500f; // TODO : chercher valeur juste
        this.mapHeight = Gdx.graphics.getHeight() - 230f; // TODO : chercher valeur juste
        this.maxI = (int) (this.mapWidth - this.margin * 2) / (this.gapX);
        this.maxI = Math.min(this.maxI, this.limitI);
        this.maxJ = (int) (this.mapHeight - this.margin * 2) / (this.gapY);
        this.maxJ = Math.min(this.maxJ, this.limitJ);
        this.mapX = 50;
        this.mapY = 180;

        this.startI = (int) (this.limitI - this.maxI) / 2;
        //this.startI = this.startI % 2 == 0 ? startI : startI - 1;
        this.startI = this.startI % 2 == 0 ? this.startI : this.startI % 2 <= 0.5 ? this.startI - 1 : this.startI + 1;
        this.startI = Math.max(this.startI, 0);
        //this.startI = maxI + startI > limitI ? maxI + limitI : startI;
        this.startI = Math.min(startI, limitI - maxI);


        this.startJ = (int) (this.limitJ - this.maxJ) / 2;
        //this.startJ = this.startJ % 2 == 0 ? startJ : startJ - 1;
        this.startJ = this.startJ % 2 == 0 ? this.startJ : this.startJ % 2 <= 0.5 ? this.startJ - 1 : this.startJ + 1;
        this.startJ = Math.max(this.startJ, 0);
        //this.startJ = maxJ + startJ > limitJ ? maxJ + limitJ : startJ;
        this.startJ = Math.min(startJ, limitJ - maxJ);

    }

    public void initMapFromZoom() {
        int middleI = this.startI + ( this.maxI / 2 );
        middleI = middleI % 2 == 0 ? middleI : middleI - 1;
        int middleJ = this.startJ + ( this.maxJ / 2 );
        middleJ = middleJ % 2 == 0 ? middleJ : middleJ - 1;

        this.hexSize = this.zoomLevel.getHexSize();
        this.gapX = (int) this.hexSize * 5 / 3;
        this.gapY = (int) this.hexSize * 3 / 2;
        this.margin = 10;

        this.mapWidth = Gdx.graphics.getWidth() - 500f; // TODO : chercher valeur juste
        this.mapHeight = Gdx.graphics.getHeight() - 230f; // TODO : chercher valeur juste
        this.maxI = (int) (this.mapWidth - this.margin * 2) / (this.gapX);
        this.maxI = Math.min(this.maxI, this.limitI);
        this.maxJ = (int) (this.mapHeight - this.margin * 2) / (this.gapY);
        this.maxJ = Math.min(this.maxJ, this.limitJ);
        this.mapX = 50;
        this.mapY = 180;

        // TODO calcul pour rester centré sur le milieu !!!!
        // TODO : marche pas pour le dezoom

        this.startI = middleI - ( this.maxI / 2 );
        this.startI = this.startI % 2 == 0 ? this.startI : this.startI % 2 <= 0.5 ? this.startI - 1 : this.startI + 1;
        this.startI = Math.max(this.startI, 0);
        this.startI = Math.min(startI, limitI - maxI);

        this.startJ = middleJ - ( this.maxJ / 2 );
        this.startJ = this.startJ % 2 == 0 ? this.startJ : this.startJ % 2 <= 0.5 ? this.startJ - 1 : this.startJ + 1;
        this.startJ = Math.max(this.startJ, 0);
        this.startJ = Math.min(startJ, limitJ - maxJ);
        //this.startJ = this.startJ % 2 == 0 ? this.startJ : this.startJ - 1;

        /*
        float centerX = mapX + mapWidth / 2;
        float centerY = mapY + mapHeight / 2;
        int centerI = (int) (centerX - mapX - margin) / gapX + startI;
        int centerJ = (int) (centerY - mapY - margin) / gapY + startJ;

        this.startI = centerI - (this.maxI / 2);
        this.startI = this.startI % 2 == 0 ? this.startI : this.startI - 1;
        this.startJ = centerJ - (this.maxJ / 2);
        this.startJ = this.startJ % 2 == 0 ? this.startJ : this.startJ - 1;
*/
    }

    public void SetMapData(MapData mapData) {
        limitI = mapData.getLimitI();
        limitJ = mapData.getLimitJ();
        this.hexesArray = new Array<Array<Hexagon>>(limitI);
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                row.add(mapData.getDataTab()[i][j]);
            }
            this.hexesArray.add(row);
        }
        //System.out.println("limitI : " + limitI + " / limitJ : " + limitJ);
        initMap();
        //generateBridgesFromRiversAndRoads();
    }

    public void drawMap(Pixmap drawingPixmap) {
        for(int i=0; i < maxI; i++) {
            for (int j=0; j < maxJ; j++) {
                int x = getXFromIJ(i, j);
                int y = getYFromJ(j);

                Texture texture = GraphicUtil.getTextureFromTerrain(this.hexesArray.get(i + startI).get(j + startJ).getCategory());

                drawHexagon(drawingPixmap, x, y, hexSize, texture, Color.BLACK);
                //renderHex(i + startI, j + startJ, texture, drawingPixmap);

                for (int k = 0; k < 6; k++) {
                    if(this.hexesArray.get(i + startI).get(j + startJ).getCliffs()[k].isCliff()) {
                        drawCliffSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getCliffs()[k], k);
                    }
                    if(this.hexesArray.get(i + startI).get(j + startJ).getRivers()[k] != RiverCategory.NO_RIVER) {
                        drawRiverSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getRivers()[k], k);
                    }
                    if(!this.hexesArray.get(i + startI).get(j + startJ).getBridges().getEdges()[k].getBridgeType().equals(BridgeTypeEnum.NO_BRIDGE)) {
                        drawBridgeSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getBridges().getEdges()[k].getBridgeType(), k);
                    }
                    if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isPathway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.PATHWAY, k);
                    }
                    if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isRoadway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.ROADWAY, k);
                    }
                    if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isRailway()) {
                        drawRoadSegment(drawingPixmap, i, j, RoadCategory.RAILWAY, k);
                    }
                    if(!this.hexesArray.get(i + startI).get(j + startJ).getFortification().equals(FortificationCategory.NO_FORTIFICATION)) {
                        drawFortification(
                            drawingPixmap,
                            x, y, hexSize * 2, // ajouté !!
                            GraphicUtil.getTextureFromFortification(this.hexesArray.get(i + startI).get(j + startJ).getFortification()));

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
                x - hexSize, y - hexSize,            // Dest X,Y (top-left of destination)
                hexSize * 2, hexSize * 2    // Dest width & height (scaling)
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
                x - hexSize, y - hexSize,            // Dest X,Y (top-left of destination)
                hexSize * 2, hexSize * 2    // Dest width & height (scaling)
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
                x - hexSize, y - hexSize,            // Dest X,Y (top-left of destination)
                hexSize * 2, hexSize * 2    // Dest width & height (scaling)
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
                x - hexSize, y - hexSize,            // Dest X,Y (top-left of destination)
                hexSize * 2, hexSize * 2    // Dest width & height (scaling)
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
                    if (isInsideHexagon(x, y, xPoints, yPoints)) {
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

    private boolean isInsideHexagon(int x, int y, int[] xPoints, int[] yPoints) {
        boolean inside = false;
        for (int i = 0, j = 5; i < 6; j = i++) {
            if (((yPoints[i] > y) != (yPoints[j] > y)) &&
                (x < (xPoints[j] - xPoints[i]) * (y - yPoints[i]) / (yPoints[j] - yPoints[i]) + xPoints[i])) {
                inside = !inside;
            }
        }
        return inside;
    }

    public int getXFromIJ(int i, int j) {
        int toReturn = (int) this.gapX * i + this.gapX / 2 + this.margin;
        if( j % 2 == 0) {
            toReturn += (int) this.gapX / 2;
        }
        return toReturn;
    }

    public int getYFromJ (int j) {
        return this.gapY * j + this.hexSize + this.margin;
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

    public ZoomLevelEnum getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(ZoomLevelEnum zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public int getStartI() {
        return startI;
    }

    public void setStartI(int startI) {
        if(startI%2 != 0) startI--;
        if(startI > this.limitI - this.maxI - 1) {
            this.startI = this.limitI - this.maxI - 1;
        }
        else if (startI < 0) {
            this.startI = 0;
        }
        else {
            this.startI = startI;
        }
        //this.startI = startI + this.maxI > this.limitI ? this.limitI - this.maxI : this.startI < 0 ? 0 : startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public void setStartJ(int startJ) {
        if(startJ%2 != 0) startJ--;
        if(startJ > this.limitJ - this.maxJ - 1) {
            this.startJ = this.limitJ - this.maxJ - 1;
        }
        else if (startJ < 0) {
            this.startJ = 0;
        }
        else {
            this.startJ = startJ;
        }
    }
}
