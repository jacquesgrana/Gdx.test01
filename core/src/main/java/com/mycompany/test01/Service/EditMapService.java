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

public class EditMapService {
    private static EditMapService instance = null;

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

    //roadStartHex
    //roadStartHexNeighbours
    private Hexagon roadStartHex;
    private Hexagon[] roadStartHexNeighbours;

    private Hexagon riverStartHex;
    private Hexagon[] riverStartHexNeighbours;

    private Hexagon cliffStartHex;
    private Hexagon[] cliffStartHexNeighbours;

    private DrawFlagCategory roadDrawFlag = DrawFlagCategory.EMPTY;
    private DrawFlagCategory riverDrawFlag = DrawFlagCategory.EMPTY;
    private DrawFlagCategory cliffDrawFlag = DrawFlagCategory.EMPTY;

    public EditMapService() {}

    public static EditMapService getInstance() {
        if (instance == null) {
            instance = new EditMapService();
        }
        return instance;
    }

    public void initRandomMapArray() {
        this.hexesArray = new Array<Array<Hexagon>>(limitI);
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                HexagonCategory terrainCategory = HexagonCategory.getRandomCategory();
                FortificationCategory fortificationCategory = terrainCategory != HexagonCategory.WATER
                    ? FortificationCategory.getRandomFortification() : FortificationCategory.NO_FORTIFICATION;
                Hexagon hexagon = new Hexagon(i, j,
                    terrainCategory,
                    fortificationCategory);
                /*
                for (int k = 0; k < 6; k++) {
                    hexagon.getRoads().getEdges()[k].setRailway(false);
                }
                */

                // Créer un nouvel objet de type Hexagon
                row.add(hexagon);
            }
            this.hexesArray.add(row);
        }
    }

    public void resetMap() {
        this.hexesArray = new Array<Array<Hexagon>>(limitI);
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {


                Hexagon hexagon = new Hexagon(i, j,
                    HexagonCategory.GRASS,
                    FortificationCategory.NO_FORTIFICATION);
                // Créer un nouvel objet de type Hexagon
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

    public Hexagon getRoadStartHex() {
        return roadStartHex;
    }

    public Hexagon[] getRoadStartHexNeighbours() {
        return roadStartHexNeighbours;
    }

    public void setRoadStartHexNeighbours(Hexagon[] roadStartHexNeighbours) {
        this.roadStartHexNeighbours = roadStartHexNeighbours;
    }

    public void setRoadStartHex(Hexagon roadStartHex) {
        this.roadStartHex = roadStartHex;
    }

    public Hexagon getRiverStartHex() {
        return riverStartHex;
    }

    public void setRiverStartHex(Hexagon riverStartHex) {
        this.riverStartHex = riverStartHex;
    }

    public Hexagon[] getRiverStartHexNeighbours() {
        return riverStartHexNeighbours;
    }

    public void setRiverStartHexNeighbours(Hexagon[] riverStartHexNeighbours) {
        this.riverStartHexNeighbours = riverStartHexNeighbours;
    }

    public Hexagon getCliffStartHex() {
        return cliffStartHex;
    }

    public void setCliffStartHex(Hexagon cliffStartHex) {
        this.cliffStartHex = cliffStartHex;
    }

    public Hexagon[] getCliffStartHexNeighbours() {
        return cliffStartHexNeighbours;
    }

    public void setCliffStartHexNeighbours(Hexagon[] cliffStartHexNeighbours) {
        this.cliffStartHexNeighbours = cliffStartHexNeighbours;
    }

    public DrawFlagCategory getCliffDrawFlag() {
        return cliffDrawFlag;
    }

    public void setCliffDrawFlag(DrawFlagCategory cliffDrawFlag) {
        this.cliffDrawFlag = cliffDrawFlag;
    }

    public DrawFlagCategory getRiverDrawFlag() {
        return riverDrawFlag;
    }

    public void setRiverDrawFlag(DrawFlagCategory riverDrawFlag) {
        this.riverDrawFlag = riverDrawFlag;
    }

    public DrawFlagCategory getRoadDrawFlag() {
        return roadDrawFlag;
    }

    public void setRoadDrawFlag(DrawFlagCategory roadDrawFlag) {
        this.roadDrawFlag = roadDrawFlag;
    }

    public void firstInit() {
        this.limitI = 100;
        this.limitJ = 100;
    }

    public void setLimits(int limitI, int limitJ) {
        this.limitI = limitI;
        this.limitJ = limitJ;
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
        this.startI = this.startI > 0 ? this.startI - this.startI % 2 : 0;
        this.startJ = (int) (this.limitJ - this.maxJ) / 2;
        this.startJ = this.limitJ > 0 ? this.startJ - this.startJ % 2 : 0;
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

        this.roadStartHex = null;
        this.roadStartHexNeighbours = new Hexagon[6];

        this.riverStartHex = null;
        this.riverStartHexNeighbours = new Hexagon[6];

        this.cliffStartHex = null;
        this.cliffStartHexNeighbours = new Hexagon[6];
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

    public int getIFromXY(int x, int y) {
        int j = (int) ((y - this.hexagonSize * 0.5) / (this.hexagonSize * 1.5));
        //System.out.println("j : " + j);
        int i = 0;
        if(j % 2 == 0) {
            i = (int) (x - this.gapX / 2) / this.gapX;
        }
        else {
            i = (int) x / this.gapX;
        }
        return i;
    }

    public int getJFromY(int y) {
        return (int) ((y - this.hexagonSize * 0.5) / (this.hexagonSize * 1.5));
    }

    public void drawMap(Pixmap drawingPixmap, EditMapMode mapMode) {
        // Dessiner les hexagones
        for(int i=0; i < maxI; i++) {
            for (int j=0; j < maxJ; j++) {
                int x = getXFromIJ(i, j);
                int y = getYFromJ(j);
                //Color hexColor = hexesArray.get(i + startI).get(j + startJ).getColorFromCategory();
                // faire méthode dans enum ou GraphicUtil qui renvoie la texture en fonction du terrain

                Texture texture = GraphicUtil.getTextureFromTerrain(this.hexesArray.get(i + startI).get(j + startJ).getCategory());

                // dessine l'hex actif et ses voisins dans le mode Road
                if(roadStartHex != null) {
                    if(i + startI == roadStartHex.getX() && j + startJ == roadStartHex.getY()) texture = GraphicUtil.redTexture;
                    boolean isInRoadStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (i + startI == roadStartHexNeighbours[k].getX() && j + startJ == roadStartHexNeighbours[k].getY()
                        && this.hexesArray.get(i + startI).get(j + startJ).getCategory() != HexagonCategory.WATER) {
                            isInRoadStartNeighbours = true;
                        }
                    }
                    if(isInRoadStartNeighbours) texture = GraphicUtil.orangeTexture;
                }

                // dessine l'hex actif et ses voisins dans le mode River
                if(riverStartHex != null) {
                    if(i + startI == riverStartHex.getX() && j + startJ == riverStartHex.getY()) texture = GraphicUtil.redTexture;
                    boolean isInRiverStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (i + startI == riverStartHexNeighbours[k].getX() && j + startJ == riverStartHexNeighbours[k].getY()
                            && this.hexesArray.get(i + startI).get(j + startJ).getCategory() != HexagonCategory.WATER) {
                            isInRiverStartNeighbours = true;
                        }
                    }
                    if(isInRiverStartNeighbours) texture = GraphicUtil.orangeTexture;
                }

                if(cliffStartHex != null) {
                    if(i + startI == cliffStartHex.getX() && j + startJ == cliffStartHex.getY()) texture = GraphicUtil.redTexture;
                    boolean isInCliffStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (i + startI == cliffStartHexNeighbours[k].getX() && j + startJ == cliffStartHexNeighbours[k].getY()
                            && this.hexesArray.get(i + startI).get(j + startJ).getCategory() != HexagonCategory.WATER) {
                            isInCliffStartNeighbours = true;
                        }
                    }
                    if(isInCliffStartNeighbours) texture = GraphicUtil.orangeTexture;
                }

                drawHexagon(drawingPixmap, x, y, hexagonSize, texture, Color.BLACK);
                //renderHex(i + startI, j + startJ, texture, drawingPixmap);

                // dessin des falaises
                if(mapMode == EditMapMode.CLIFF || mapMode == EditMapMode.RIVER || mapMode == EditMapMode.TERRAIN || mapMode == EditMapMode.MISC || mapMode == EditMapMode.NO_ACTION) {
                    for (int k = 0; k < 6; k++) {
                        if(this.hexesArray.get(i + startI).get(j + startJ).getCliffs()[k].isCliff()) {
                            drawCliffSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getCliffs()[k], k);
                        }
                    }
                }


                // dessin des rivières
                if(mapMode == EditMapMode.RIVER || mapMode == EditMapMode.TERRAIN || mapMode == EditMapMode.MISC || mapMode == EditMapMode.NO_ACTION) {
                    for (int k = 0; k < 6; k++) {
                        if(this.hexesArray.get(i + startI).get(j + startJ).getRivers()[k] != RiverCategory.NO_RIVER) {
                            drawRiverSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getRivers()[k], k);
                        }
                    }
                }

                // dessin des ponts
                if(mapMode == EditMapMode.RIVER || mapMode == EditMapMode.TERRAIN || mapMode == EditMapMode.MISC || mapMode == EditMapMode.NO_ACTION) {
                    for (int k = 0; k < 6; k++) {
                        if(!this.hexesArray.get(i + startI).get(j + startJ).getBridges().getEdges()[k].getBridgeType().equals(BridgeTypeEnum.NO_BRIDGE)) {
                            drawBridgeSide(drawingPixmap, i, j, this.hexesArray.get(i + startI).get(j + startJ).getBridges().getEdges()[k].getBridgeType(), k);
                        }
                    }
                }

                // dessin des routes
                if(mapMode == EditMapMode.ROAD || mapMode == EditMapMode.TERRAIN || mapMode == EditMapMode.MISC || mapMode == EditMapMode.NO_ACTION) {
                    for(int k=0; k<6; k++) {
                        if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isPathway()) {
                            drawRoadSegment(drawingPixmap, i, j, RoadCategory.PATHWAY, k);
                        }
                        if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isRoadway()) {
                            drawRoadSegment(drawingPixmap, i, j, RoadCategory.ROADWAY, k);
                        }
                        if(this.hexesArray.get(i + startI).get(j + startJ).getRoads().getEdges()[k].isRailway()) {
                            drawRoadSegment(drawingPixmap, i, j, RoadCategory.RAILWAY, k);
                        }
                    }
                }

                // dessin des fortifications
                if(this.hexesArray.get(i + startI).get(j + startJ).getFortification() != FortificationCategory.NO_FORTIFICATION
                && (mapMode == EditMapMode.FORTIFICATION || mapMode == EditMapMode.NO_ACTION)) {
                    drawFortification(
                        drawingPixmap,
                        x, y, hexagonSize,
                        GraphicUtil.getTextureFromFortification(this.hexesArray.get(i + startI).get(j + startJ).getFortification()));
                }

            }
        }
    }

    public void generateBridgesFromRiversAndRoads() {
        for(int i=0; i < limitI; i++) {
            for (int j=0; j < limitJ; j++) {
                Hexagon hex = this.hexesArray.get(i).get(j);
                for(int k=0; k<6; k++) {
                    if(
                        !(hex.getRivers()[k].equals(RiverCategory.NO_RIVER)) &&
                            (hex.getRoads().getEdges()[k].isPathway() ||
                                hex.getRoads().getEdges()[k].isRoadway() ||
                                hex.getRoads().getEdges()[k].isRailway()
                            )
                    ) {
                        BridgeTypeEnum bridgeType = hex.getRoads().getEdges()[k].isRailway() ? BridgeTypeEnum.HEAVY_BRIDGE :
                            hex.getRoads().getEdges()[k].isRoadway() ? BridgeTypeEnum.MEDIUM_BRIDGE :
                                hex.getRoads().getEdges()[k].isPathway() ? BridgeTypeEnum.LIGHT_BRIDGE : BridgeTypeEnum.NO_BRIDGE;
                        this.hexesArray.get(i).get(j).getBridges().getEdges()[k].setBridgeType(bridgeType);
                    }
                    else {
                        this.hexesArray.get(i).get(j).getBridges().getEdges()[k].setBridgeType(BridgeTypeEnum.NO_BRIDGE);
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
                x - hexagonSize, y - hexagonSize,            // Dest X,Y (top-left of destination)
                hexagonSize * 2, hexagonSize * 2    // Dest width & height (scaling)
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
                x - hexagonSize, y - hexagonSize,            // Dest X,Y (top-left of destination)
                hexagonSize * 2, hexagonSize * 2    // Dest width & height (scaling)
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
                x - hexagonSize, y - hexagonSize,            // Dest X,Y (top-left of destination)
                hexagonSize * 2, hexagonSize * 2    // Dest width & height (scaling)
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
                x - hexagonSize, y - hexagonSize,            // Dest X,Y (top-left of destination)
                hexagonSize * 2, hexagonSize * 2    // Dest width & height (scaling)
            );
            texturePixmap.dispose();
        }
        texture.dispose();
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

        // 'cappage'
        // TODO modifier le calcul pour que le rectangle de sélection soit centré sur le clic
        // TODO ajouter la moitié de MaxI et MaxJ ?
        this.startI = i < 0 ? 0 : i >= this.limitI - this.maxI ? this.limitI - this.maxI - 1 : i;
        this.startJ = j < 0 ? 0 : j >= this.limitJ - this.maxJ ? this.limitJ - this.maxJ - 1 : j;
        // utiliser des valeurs paires
        this.startI -= this.startI%2;
        this.startJ -= this.startJ%2;
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
                Color fillColor = GraphicUtil.getColorFromTerrain(this.hexesArray.get(i).get(j).getCategory());
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

        drawingMapPixmap.setColor(Color.WHITE);
        int selectRectWidth =  miniHexSize * this.maxI;
        int selectRectHeight = miniHexSize * this.maxJ;

        int rectX = miniMapX + miniMapMargin + miniHexSize * this.startI;
        int rectY = miniMapY + miniMapMargin + miniHexSize * this.startJ;
        drawingMapPixmap.drawRectangle(rectX, rectY, selectRectWidth, selectRectHeight);
    }

    /*
    public void renderNeighbours(Texture drawingTexture, Pixmap drawingMapPixmap) {
        for(int k=0; k<6; k++) {
            if(this.roadStartHexNeighbours[k] != null
                && hexesArray.get(this.roadStartHexNeighbours[k].getX()).get(this.roadStartHexNeighbours[k].getY()).getCategory() != HexagonCategory.WATER) {
                int ii = this.roadStartHexNeighbours[k].getX();
                int jj = this.roadStartHexNeighbours[k].getY();
                // n'affiche que ls hexs de la zone affichée dans la carte
                if (ii - startI >= 0 &&
                    ii - startI < maxI &&
                    jj - startJ >= 0 &&
                    jj - startJ < maxJ
                ) {
                    renderHex( ii, jj, GraphicUtil.orangeTexture, drawingMapPixmap);
                }

            }
        }
        drawingTexture.draw(drawingMapPixmap, 0, 0);
    }*/

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

    public boolean isClickInMap(int i, int j) {
        if(i >= 0 && i < this.maxI && j >= 0 && j < this.maxJ) {
            return true;
        }
        else {
            return false;
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

    public boolean isInNeighboursByMode(int i, int j, EditMapMode mode) {
        //if(this.roadStartHex != null) {
            for(int k=0; k<6; k++) {
                switch(mode) {
                    case ROAD:
                        if(this.roadStartHex != null
                            && this.roadStartHexNeighbours[k] != null
                            && this.roadStartHexNeighbours[k].getX() == i + this.startI
                            &&  this.roadStartHexNeighbours[k].getY() == j + this.startJ) {
                            return true;
                        }
                        break;
                    case RIVER:
                        //System.out.println("k : " + k);
                        if(this.riverStartHex != null
                            && this.riverStartHexNeighbours[k] != null
                            && this.riverStartHexNeighbours[k].getX() == i + this.startI
                            &&  this.riverStartHexNeighbours[k].getY() == j + this.startJ) {
                            return true;
                        }
                        break;
                    case CLIFF:
                        //System.out.println("k : " + k);
                        if(this.cliffStartHex != null
                            && this.cliffStartHexNeighbours[k] != null
                            && this.cliffStartHexNeighbours[k].getX() == i + this.startI
                            &&  this.cliffStartHexNeighbours[k].getY() == j + this.startJ) {
                            return true;
                        }
                        break;
                }

            }
        //}
        return false;
    }

    public int getKFromRoadNeighbours(Hexagon hex) {
        if(this.roadStartHex != null) {
            for(int k=0; k<6; k++) {
                if(this.roadStartHexNeighbours[k] != null
                    && this.roadStartHexNeighbours[k].getX() == hex.getX()
                    &&  this.roadStartHexNeighbours[k].getY() == hex.getY()) {
                    return k;
                }
            }
        }
        return -1;
    }

    public int getKFromRiverNeighbours(Hexagon hex) {
        if(this.riverStartHex != null) {
            for(int k=0; k<6; k++) {
                if(this.riverStartHexNeighbours[k] != null
                    && this.riverStartHexNeighbours[k].getX() == hex.getX()
                    &&  this.riverStartHexNeighbours[k].getY() == hex.getY()) {
                    return k;
                }
            }
        }
        return -1;
    }

    public int getKFromCliffNeighbours(Hexagon hex) {
        if(this.cliffStartHex != null) {
            for(int k=0; k<6; k++) {
                if(this.cliffStartHexNeighbours[k] != null
                    && this.cliffStartHexNeighbours[k].getX() == hex.getX()
                    &&  this.cliffStartHexNeighbours[k].getY() == hex.getY()) {
                    return k;
                }
            }
        }
        return -1;
    }


    public void setRoadForHexes(Hexagon startHex, Hexagon endHex, RoadCategory selectedRoad, int k) {
        //startHex.getRoads().getEdges()
        int iStart = startHex.getX();
        int jStart = startHex.getY();
        int iEnd = endHex.getX();
        int jEnd = endHex.getY();
        int l = 5 - k;
        switch(selectedRoad) {
            case NO_ROAD:
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setPathway(false);
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setRoadway(false);
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setRailway(false);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setPathway(false);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setRoadway(false);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setRailway(false);
                break;
            case PATHWAY:
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setPathway(true);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setPathway(true);
                break;
            case ROADWAY:
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setRoadway(true);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setRoadway(true);
                break;
            case RAILWAY:
                this.hexesArray.get(iStart).get(jStart).getRoads().getEdges()[k].setRailway(true);
                this.hexesArray.get(iEnd).get(jEnd).getRoads().getEdges()[l].setRailway(true);
                break;
        }
        /*
        0 : NW / SE : 5
        1 : NE / SW : 4
        2 : W / E : 3
        3 : E / W : 2
        4 : SW / NE: 1
        5 : SE / NW : 0
        */
    }


    public void setRiverForHexes(Hexagon startHex, Hexagon endHex, RiverCategory selectedRiver, int k) {
        //startHex.getRoads().getEdges()
        int iStart = startHex.getX();
        int jStart = startHex.getY();
        int iEnd = endHex.getX();
        int jEnd = endHex.getY();
        int l = 5 - k;
        switch(selectedRiver) {
            case NO_RIVER:
                this.hexesArray.get(iStart).get(jStart).getRivers()[k] = RiverCategory.NO_RIVER;
                this.hexesArray.get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.NO_RIVER;
                break;
            case NARROW:
                this.hexesArray.get(iStart).get(jStart).getRivers()[k] = RiverCategory.NARROW;
                this.hexesArray.get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.NARROW;
                break;
            case MEDIUM:
                this.hexesArray.get(iStart).get(jStart).getRivers()[k] = RiverCategory.MEDIUM;
                this.hexesArray.get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.MEDIUM;
                break;
            case WIDE:
                this.hexesArray.get(iStart).get(jStart).getRivers()[k] = RiverCategory.WIDE;
                this.hexesArray.get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.WIDE;
                break;
        }
    }

    public MapData getMapData() {
        return new MapData("test", this.limitI, this.limitJ, this.hexesArray);
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
        init();
        generateBridgesFromRiversAndRoads();
    }
}
