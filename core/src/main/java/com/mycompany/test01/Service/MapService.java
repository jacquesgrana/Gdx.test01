package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Hexagon;
import com.mycompany.test01.Enum.HexagonCategory;
import com.mycompany.test01.Util.GraphicUtil;

public class MapService {
    private static MapService instance = null;

    private Array<Array<Hexagon>> hexesArray;
    private int hexagonSize; // La moitié de 60px
    private int gapX;
    private int gapY;
    private int maxI, maxJ;
    private float mapX, mapY, mapWidth, mapHeight;
    private int startI;
    private int startJ;
    private int limitI;
    private int limitJ;
    private int margin;

    private int miniHexSize;
    private int miniMapMargin;
    //calcul des coordonnées et dimensions de la minimap
    private int miniMapWidth;
    private int miniMapHeight;
    private int miniMapX;
    private int miniMapY;

    public MapService() {}

    public static MapService getInstance() {
        if (instance == null) {
            instance = new MapService();
        }
        return instance;
    }

    public void initRandomMapArray() {
        this.hexesArray = new Array<Array<Hexagon>>(limitI);
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                Hexagon hexagon = new Hexagon(i, j, HexagonCategory.getRandomCategory()); // Créer un nouvel objet de type Hexagon
                row.add(hexagon);
            }
            this.hexesArray.add(row);
        }
    }

    public Array<Array<Hexagon>> getHexesArray() {
        return this.hexesArray;
    }

    public int getMaxI() {
        return this.maxI;
    }

    public int getMaxJ() {
        return this.maxJ;
    }

    public int getStartI() {
        return startI;
    }

    public void setStartI(int startI) {
        if(startI > this.limitI - this.maxI) {
            this.startI = this.limitI - this.maxI;
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
        if(startJ > this.limitJ - this.maxJ) {
            this.startJ = this.limitJ - this.maxJ;
        }
        else if (startJ < 0) {
            this.startJ = 0;
        }
        else {
            this.startJ = startJ;
        }
    }

    public float getMapWidth() {
        return mapWidth;
    }

    public float getMapHeight() {
        return mapHeight;
    }

    public void setMapWidth(float mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setMapHeight(float mapHeight) {
        this.mapHeight = mapHeight;
    }

    public float getMapX() {
        return mapX;
    }

    public float getMapY() {
        return mapY;
    }

    public int getGapX() {
        return gapX;
    }

    public int getGapY() {
        return gapY;
    }

    public int getLimitI() {
        return limitI;
    }

    public int getLimitJ() {
        return limitJ;
    }

    public int getMargin() {
        return margin;
    }

    public int getHexagonSize() {
        return hexagonSize;
    }

    public int getMiniHexSize() {
        return miniHexSize;
    }

    public int getMiniMapMargin() {
        return miniMapMargin;
    }

    public int getMiniMapWidth() {
        return miniMapWidth;
    }

    public int getMiniMapHeight() {
        return miniMapHeight;
    }

    public int getMiniMapX() {
        return miniMapX;
    }

    public int getMiniMapY() {
        return miniMapY;
    }

    public void firstInit() {
        this.limitI = 250;
        this.limitJ = 250;
    }

    public void init() {
        this.hexagonSize = 30; // La moitié de 60px
        this.gapX = 50;
        this.gapY = 45;
        this.margin = 10;

        this.mapWidth = Gdx.graphics.getWidth() - 80f;
        this.mapHeight = Gdx.graphics.getHeight() - 210f;
        this.maxI = (int) (this.mapWidth - this.margin * 2) / (this.gapX);
        this.maxJ = (int) (this.mapHeight - this.margin * 2) / (this.gapY); // TODO verifier si this.hexagonSize n'est pas mieux
        this.startI = (int) (this.limitI - this.maxI) / 2;
        this.startJ = (int) (this.limitJ - this.maxJ) / 2;

        this.mapX = Gdx.graphics.getWidth() / 2f - this.mapWidth / 2f;
        //this.mapY = Gdx.graphics.getHeight() / 2f - this.mapHeight / 2f;
        this.mapY = 160f;

        this.miniHexSize = 2;
        this.miniMapMargin = 10;
        //calcul des coordonnées et dimensions de la minimap
        this.miniMapWidth = this.limitI * miniHexSize + 2 * miniMapMargin;
        this.miniMapHeight = this.limitJ * miniHexSize + 2 * miniMapMargin;
        this.miniMapX = (int) this.mapWidth - miniMapWidth;
        this.miniMapY = (int) this.mapHeight - miniMapHeight;
    }

    public int getXFromIJ(int i, int j) {
        int toReturn = (int) this.gapX * i + this.gapX / 2 + this.margin;
        if( j % 2 == 0) {
            toReturn += (int) this.gapX / 2;
        }
        return toReturn;
    }

    public int getYFromJ (int j) {
        return this.gapY * j + this.hexagonSize + this.margin;
    }

    public Hexagon[] getNeighborhoodHexes(int i, int j) {
        Hexagon[] toReturn = new Hexagon[6];
        for (int k=0; k<6; k++) {
            if(j % 2 == 0) {
                switch (k) {
                    case 0 :
                        if(j-1 >= 0) {
                            Hexagon northWest = this.hexesArray.get(i+this.startI).get(j-1+this.startJ);
                            toReturn[k] = northWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 1 :
                        if(i+1 < this.maxI && j-1 >= 0) {
                            Hexagon northEast = this.hexesArray.get(i+1+this.startI).get(j-1+this.startJ);
                            toReturn[k] = northEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 2 :
                        if(i-1 >= 0) {
                            Hexagon west = this.hexesArray.get(i-1+this.startI).get(j+this.startJ);
                            toReturn[k] = west;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 3 :
                        if(i+1 < this.maxI) {
                            Hexagon east = this.hexesArray.get(i+1+this.startI).get(j+this.startJ);
                            toReturn[k] = east;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 4 :
                        if(j+1 < this.maxJ) {
                            Hexagon southWest = this.hexesArray.get(i+this.startI).get(j+1+this.startJ);
                            toReturn[k] = southWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 5 :
                        if(i+1 < this.maxI && j+1 < this.maxJ) {
                            Hexagon southEast = this.hexesArray.get(i+1+this.startI).get(j+1+this.startJ);
                            toReturn[k] = southEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                }
            }
            else {
                switch (k) {
                    case 0 :
                        if(i-1 >= 0 && j-1 >= 0) {
                            Hexagon northWest = this.hexesArray.get(i-1+this.startI).get(j-1+this.startJ);
                            toReturn[k] = northWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 1 :
                        if(j-1 >= 0) {
                            Hexagon northEast = this.hexesArray.get(i+this.startI).get(j-1+this.startJ);
                            toReturn[k] = northEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 2 :
                        if(i-1 >= 0) {
                            Hexagon west = this.hexesArray.get(i-1+this.startI).get(j+this.startJ);
                            toReturn[k] = west;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 3 :
                        if(i+1 < this.maxI) {
                            Hexagon east = this.hexesArray.get(i+1+this.startI).get(j+this.startJ);
                            toReturn[k] = east;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 4 :
                        if(i-1 >= 0 && j+1 < this.maxJ) {
                            Hexagon southWest = this.hexesArray.get(i-1+this.startI).get(j+1+this.startJ);
                            toReturn[k] = southWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 5 :
                        if(j+1 < this.maxJ) {
                            Hexagon southEast = this.hexesArray.get(i+this.startI).get(j+1+this.startJ);
                            toReturn[k] = southEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                }
            }

        }

        return toReturn;
    }

    public void drawMap(Pixmap drawingPixmap
                        ) {
        // Dessiner les hexagones
        for(int i=0; i < maxI; i++) {
            for (int j=0; j < maxJ; j++) {
                /*
                int x = i * gapX + gapX / 2 + 10;
                int y = j * gapY + hexagonSize + 10;
                if( j % 2 == 0) x += gapX / 2;
                */
                int x = getXFromIJ(i, j);
                int y = getYFromJ(j);
                //Color hexColor = hexesArray.get(i + startI).get(j + startJ).getColorFromCategory();
                // faire méthode dans enum ou GraphicUtil qui renvoie la texture en fonction du terrain
                Texture texture = this.hexesArray.get(i + startI).get(j + startJ).getTextureFromCategory();

                drawHexagon(drawingPixmap, x, y, hexagonSize, texture, Color.BLACK);
            }
        }
    }

    public void updateMiniMap(int x, int y, Pixmap drawingMapPixmap) {
        x = x - miniMapX - miniMapMargin;
        y = y - miniMapY - miniMapMargin;
        // calcul des coordonnées du coin gauche du rectangle de sélection
        //x = (int) x - miniMapWidth / 2;
        //y = (int) y - miniMapHeight / 2;

        // calcul de j
        int j = (int) y / miniHexSize;
        int i=0;
        // calcul de i en tenant compte de j%2
        if(j % 2 == 0) {
            i = (int) ((x + miniHexSize/2) / miniHexSize);
        }
        else {
            i = (int) x / miniHexSize;
        }

        /*
        if (i < 0) {
             i = 0;
        }
        else if (i >= this.limitI - this.maxI) {
            i = this.limitI - this.maxI - 1;
        }
        if (j < 0) {
            j = 0;
        }
        else if (j >= this.limitJ - this.maxJ) {
            j = this.limitJ - this.maxJ - 1;
        }
        */

        // 'cappage'
        this.startI = i < 0 ? 0 : i >= this.limitI - this.maxI ? this.limitI - this.maxI - 1 : i;
        this.startJ = j < 0 ? 0 : j >= this.limitJ - this.maxJ ? this.limitJ - this.maxJ - 1 : j;
        //this.startI = i;
        //this.startJ = j;
        // dessin du rectangle (faire méthode ?)
        //this.showMiniMap(drawingMapPixmap);
    }

    public void showMiniMap(Pixmap drawingMapPixmap) {
        drawingMapPixmap.setColor(Color.BLACK);
        drawingMapPixmap.fillRectangle(miniMapX, miniMapY, miniMapWidth, miniMapHeight);

        // dessin de la miniMap
        for(int i=0; i<this.limitI; i++) {
            for(int j=0; j<this.limitJ; j++) {
                Color fillColor = this.hexesArray.get(i).get(j).getColorFromCategory();
                drawingMapPixmap.setColor(fillColor);


                for(int k=0; k<miniHexSize; k++) {
                    int x = miniMapX + miniMapMargin + k + i * miniHexSize;
                    if(j%2==0) x += (int) miniHexSize / 2;
                    for(int l=0; l<miniHexSize; l++) {
                        int y = miniMapY + miniMapMargin + l + j * miniHexSize;
                        drawingMapPixmap.drawPixel(x, y);
                    }
                }
            }
        }

        // dessin du rectangle de la carte visible
        //
        drawingMapPixmap.setColor(Color.WHITE);
        int selectRectWidth =  miniHexSize * this.maxI;
        int selectRectHeight = miniHexSize * this.maxJ;

        int rectX = miniMapX + miniMapMargin + miniHexSize * this.startI;
        int rectY = miniMapY + miniMapMargin + miniHexSize * this.startJ;
        //pixmap.drawPixel(x, y);
        drawingMapPixmap.drawRectangle(rectX, rectY, selectRectWidth, selectRectHeight);
        //drawingMapPixmap.drawLine(rectX, rectY, rectX + selectRectWidth, rectY);
        //drawingMapPixmap.drawLine(rectX, rectY + selectRectHeight, rectX + selectRectWidth, rectY + selectRectHeight);
        //drawingMapPixmap.drawLine(rectX, rectY, rectX, rectY + selectRectHeight);
        //drawingMapPixmap.drawLine(rectX + selectRectWidth, rectY, rectX + selectRectWidth, rectY + selectRectHeight);
    }

    public void renderHex(int hexI, int hexJ, Texture texture, Pixmap pixmap) {
        // Calculer les coordonnées du centre de l'hexagone
        /*
        int centerX = (hexI - startI) * gapX + gapX / 2 + 10; // Ajouter la marge de 10
        int centerY = (hexJ - startJ) * gapY + hexagonSize + 10; // Ajouter la marge de 10
        if ((hexJ - startJ) % 2 == 0) {
            centerX += gapX / 2; // Décalage pour les lignes paires
        }
        */
        int centerX = getXFromIJ(hexI - startI, hexJ - startJ);
        int centerY = getYFromJ(hexJ - startJ);
        // Dessiner l'hexagone avec la couleur spécifiée
        //Texture textureGrass = GraphicUtil.loadTexture("texture/texture-grass.png");
        drawHexagon(pixmap, centerX, centerY, hexagonSize, texture, Color.BLACK);
    }
    /*
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
        Pixmap texturePixmap = textureToPixmap(texture);

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
    /*
    public void drawHexagon(Pixmap pixmap, int centerX, int centerY, int size, Color fillColor, Color borderColor) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * (i + 0.5);
            xPoints[i] = (int) (centerX + size * Math.cos(angle));
            yPoints[i] = (int) (centerY + size * Math.sin(angle));
        }

        // Remplissage
        pixmap.setColor(fillColor);
        for (int y = centerY - size; y <= centerY + size; y++) {
            for (int x = centerX - size; x <= centerX + size; x++) {
                if (isInsideHexagon(x, y, xPoints, yPoints)) {
                    pixmap.drawPixel(x, y);
                }
            }
        }

        // Contour
        pixmap.setColor(borderColor);
        for (int i = 0; i < 6; i++) {
            int j = (i + 1) % 6;
            pixmap.drawLine(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
        }
    }*/

    public Pixmap textureToPixmap(Texture texture) {
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        Pixmap pixmap = texture.getTextureData().consumePixmap();
        return pixmap;
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
}
