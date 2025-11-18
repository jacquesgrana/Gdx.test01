package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Config.MapConfig;
import com.mycompany.test01.Entity.Map.*;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.LogUtil;

import java.util.Arrays;

public class EditMapService {
    private static EditMapService instance = null;

    //private final int MAX_BRUSH_SIZE = 10;
    //private final int MIN_BRUSH_SIZE = 0;
    private int mapBrushSize = 0;
    private Map map;

    // TODO faire objet MiniMap
    //private int miniHexSize;
    //private int miniMapMargin;
    //private int miniMapWidth;
    //private int miniMapHeight;
    //private int miniMapX;
    //private int miniMapY;

    private Hexagon roadStartHex;
    private Hexagon[] roadStartHexNeighbours;

    private Hexagon riverStartHex;
    private Hexagon[] riverStartHexNeighbours;

    private Hexagon cliffStartHex;
    private Hexagon[] cliffStartHexNeighbours;

    private DrawFlagCategory roadDrawFlag = DrawFlagCategory.EMPTY;
    private DrawFlagCategory riverDrawFlag = DrawFlagCategory.EMPTY;
    private DrawFlagCategory cliffDrawFlag = DrawFlagCategory.EMPTY;

    public EditMapService() {
        //this.displayFlags = new MapDisplayFlags();
        //this.getMap().setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
        this.map = new Map();
        //this.getMap().setDisplayFlags(new MapDisplayFlags());
    }


    public static EditMapService getInstance() {
        if (instance == null) {
            instance = new EditMapService();
        }
        return instance;
    }
    // TODO : rendre limitI, limitJ, maxI, maxJ pairs !!!
/*
    public void initRandomMapArray() {
        this.getMap().setHexesArray(new Array<Array<Hexagon>>(this.getMap().getLimitI()));
        for (int i = 0; i < this.getMap().getLimitI(); i++) {
            Array<Hexagon> row = new Array<Hexagon>(this.getMap().getLimitJ());
            for (int j = 0; j < this.getMap().getLimitJ(); j++) {
                HexagonCategory terrainCategory = HexagonCategory.getRandomCategory();
                FortificationCategory fortificationCategory = terrainCategory != HexagonCategory.WATER
                    ? FortificationCategory.getRandomFortification() : FortificationCategory.NO_FORTIFICATION;
                Hexagon hexagon = new Hexagon(i, j,
                    terrainCategory,
                    fortificationCategory);


                // Créer un nouvel objet de type Hexagon
                row.add(hexagon);
            }
            this.getMap().getHexesArray().add(row);
        }
    }
    */

    public void resetMap() {
        this.getMap().setHexesArray(new Array<Array<Hexagon>>(this.getMap().getLimitI()));
        for (int i = 0; i < this.getMap().getLimitI(); i++) {
            Array<Hexagon> row = new Array<Hexagon>(this.getMap().getLimitJ());
            for (int j = 0; j < this.getMap().getLimitJ(); j++) {

                RiverCategory[] rivers = new RiverCategory[6];
                Arrays.fill(rivers, RiverCategory.NO_RIVER);
                Cliff[] cliffs = new Cliff[6];
                for(int k=0; k<6; k++) {
                    cliffs[k] = new Cliff();
                }
                Hexagon hexagon = new Hexagon(
                    i,
                    j,
                    HexagonCategory.GRASS,
                    FortificationCategory.NO_FORTIFICATION,
                    new RoadEdges(),
                    rivers,
                    new BridgeEdges(),
                    cliffs,
                    CountryEnum.NO_COUNTRY,
                    new HexUnits(),
                    new DevastationRatio());
                // Créer un nouvel objet de type Hexagon
                row.add(hexagon);
            }
            this.getMap().getHexesArray().add(row);
        }
    }

    /*
    public int getMiniHexSize() {
        return miniHexSize;
    }*/

    /*
    public int getMiniMapMargin() {
        return miniMapMargin;
    }*/

    /*
    public int getMiniMapWidth() {
        return miniMapWidth;
    }
     */

    /*
    public int getMiniMapHeight() {
        return miniMapHeight;
    }
     */

    /*
    public int getMiniMapX() {
        return miniMapX;
    }
     */

    /*
    public int getMiniMapY() {
        return miniMapY;
    }
     */

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
        //this.limitI = 100;
        //this.getMap().setLimitI(100);
        //this.limitJ = 100;
        //this.getMap().setLimitJ(100);
        setLimits(100, 100);
    }

    public void setLimits(int limitI, int limitJ) {
        this.getMap().setLimitI(limitI % 2 == 0 ? limitI : limitI - 1);
        this.getMap().setLimitJ(limitJ % 2 == 0 ? limitJ : limitJ - 1);
    }

    public void init() {
        //this.hexagonSize = 30;
        // La moitié de 60px

        this.getMap().initMap(40f, 160f, Gdx.graphics.getWidth() - 80f, Gdx.graphics.getHeight() - 210f);

        this.getMap().initMiniMap();
        this.initStartHexes();
    }

    public void initMapFromZoom() {
        this.getMap().initMapFromZoom(40f, 160f, Gdx.graphics.getWidth() - 80f, Gdx.graphics.getHeight() - 210f);

        this.getMap().initMiniMap();
        this.initStartHexes();
    }

    public void initStartHexes() {
        this.roadStartHex = null;
        this.roadStartHexNeighbours = new Hexagon[6];

        this.riverStartHex = null;
        this.riverStartHexNeighbours = new Hexagon[6];

        this.cliffStartHex = null;
        this.cliffStartHexNeighbours = new Hexagon[6];
    }

    public void drawMap(Pixmap drawingPixmap, EditMapMode mapMode) {
        // Dessiner les hexagones
        for(int i=0; i < this.getMap().getMaxI(); i++) {
            for (int j=0; j < this.getMap().getMaxJ(); j++) {
                //int x = this.getMap().getXFromIJ(i, j);
                //int y = this.getMap().getYFromJ(j);
                //Color hexColor = hexesArray.get(i + startI).get(j + startJ).getColorFromCategory();
                // faire méthode dans enum ou GraphicUtil qui renvoie la texture en fonction du terrain

                Texture texture = this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCategory().getTexture();
                Texture textureTransp = null;
                // dessine l'hex actif et ses voisins dans le mode Road
                if(roadStartHex != null) {
                    if(i + this.getMap().getStartI() == roadStartHex.getX() && j + this.getMap().getStartJ() == roadStartHex.getY()) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorRed, 0.25f));
                    boolean isInRoadStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (this.roadStartHexNeighbours[k] != null && i + this.getMap().getStartI() == roadStartHexNeighbours[k].getX() && j + this.getMap().getStartJ() == roadStartHexNeighbours[k].getY()
                        && this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCategory() != HexagonCategory.WATER) {
                            isInRoadStartNeighbours = true;
                        }
                    }
                    if(isInRoadStartNeighbours) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorBlue, 0.2f));
                }

                // dessine l'hex actif et ses voisins dans le mode River
                if(riverStartHex != null) {
                    if(i + this.getMap().getStartI() == riverStartHex.getX() && j + this.getMap().getStartJ() == riverStartHex.getY()) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorRed, 0.25f));
                    boolean isInRiverStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (riverStartHexNeighbours[k] != null && i + this.getMap().getStartI() == riverStartHexNeighbours[k].getX() && j + this.getMap().getStartJ() == riverStartHexNeighbours[k].getY()
                            && this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCategory() != HexagonCategory.WATER) {
                            isInRiverStartNeighbours = true;
                        }
                    }
                    if(isInRiverStartNeighbours) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorBlue, 0.2f));
                }

                // dessine l'hex actif et ses voisins dans le mode Cliff
                if(cliffStartHex != null) {
                    if(i + this.getMap().getStartI() == cliffStartHex.getX() && j + this.getMap().getStartJ() == cliffStartHex.getY()) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorRed, 0.25f));
                    boolean isInCliffStartNeighbours = false;
                    for(int k=0; k<6; k++) {
                        if (cliffStartHexNeighbours[k] != null && i + this.getMap().getStartI() == cliffStartHexNeighbours[k].getX() && j + this.getMap().getStartJ() == cliffStartHexNeighbours[k].getY()
                            && this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCategory() != HexagonCategory.WATER) {
                            isInCliffStartNeighbours = true;
                        }
                    }
                    if(isInCliffStartNeighbours) textureTransp = GraphicUtil.getTextureFromColor(GraphicUtil.getTransparentColor(GraphicUtil.colorBlue, 0.2f));
                }

                //LogUtil.logInfo("Texture transp : " + textureTransp.toString());

                // Dessin du terrain
                //this.getMap().drawHexagon(drawingPixmap, x, y, this.getMap().getHexagonSize(), texture, Color.BLACK);
                this.getMap().renderHex(i + this.getMap().getStartI(), j + this.getMap().getStartJ(), texture, drawingPixmap);
                // Dessin de la couleur d'édition transparente si besoin
                if(textureTransp != null) {
                    //this.getMap().drawHexagon(drawingPixmap, x, y, this.getMap().getHexagonSize(), textureTransp, Color.BLACK);
                    this.getMap().renderHex(i + this.getMap().getStartI(), j + this.getMap().getStartJ(), textureTransp, drawingPixmap);
                }


                // dessin des falaises
                if(this.getMap().getDisplayFlags().isCliffVisible())
                {
                    for (int k = 0; k < 6; k++) {
                        if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCliffs()[k].isCliff()) {
                            this.getMap().drawCliffSide(drawingPixmap, i, j, this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getCliffs()[k], k);
                        }
                    }
                }


                // dessin des rivières
                if(this.getMap().getDisplayFlags().isRiverVisible())
                {
                    for (int k = 0; k < 6; k++) {
                        if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getRivers()[k] != RiverCategory.NO_RIVER) {
                            this.getMap().drawRiverSide(drawingPixmap, i, j, this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getRivers()[k], k);
                        }
                    }
                }

                // dessin des ponts
                if(this.getMap().getDisplayFlags().isBridgeVisible()) {
                    for (int k = 0; k < 6; k++) {
                        if(!this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getBridges().getEdges()[k].getBridgeType().equals(BridgeTypeEnum.NO_BRIDGE)) {
                            this.getMap().drawBridgeSide(drawingPixmap, i, j, this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getBridges().getEdges()[k].getBridgeType(), k);
                        }
                    }
                }

                // dessin des routes
                if(this.getMap().getDisplayFlags().isRoadVisible()) {
                    for(int k=0; k<6; k++) {
                        if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getRoads().getEdges()[k].isPathway()) {
                            this.getMap().drawRoadSegment(drawingPixmap, i, j, RoadCategory.PATHWAY, k);
                        }
                        if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getRoads().getEdges()[k].isRoadway()) {
                            this.getMap().drawRoadSegment(drawingPixmap, i, j, RoadCategory.ROADWAY, k);
                        }
                        if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getRoads().getEdges()[k].isRailway()) {
                            this.getMap().drawRoadSegment(drawingPixmap, i, j, RoadCategory.RAILWAY, k);
                        }
                    }
                }

                // dessin des fortifications
                if(this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getFortification() != FortificationCategory.NO_FORTIFICATION
                && this.getMap().getDisplayFlags().isFortificationVisible()) {
                    this.getMap().drawFortification(
                        drawingPixmap,
                        i, j, this.getMap().getHexagonSize() * 2, // ajouté !!
                        this.getMap().getHexesArray().get(i + this.getMap().getStartI()).get(j + this.getMap().getStartJ()).getFortification().getTexture());
                }

            }
        }
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

    public boolean isInNeighboursByMode(int i, int j, EditMapMode mode) {
        //if(this.roadStartHex != null) {
            for(int k=0; k<6; k++) {
                switch(mode) {
                    case ROAD:
                        if(this.roadStartHex != null
                            && this.roadStartHexNeighbours[k] != null
                            && this.roadStartHexNeighbours[k].getX() == i + this.getMap().getStartI()
                            &&  this.roadStartHexNeighbours[k].getY() == j + this.getMap().getStartJ()) {
                            return true;
                        }
                        break;
                    case RIVER:
                        //System.out.println("k : " + k);
                        if(this.riverStartHex != null
                            && this.riverStartHexNeighbours[k] != null
                            && this.riverStartHexNeighbours[k].getX() == i + this.getMap().getStartI()
                            &&  this.riverStartHexNeighbours[k].getY() == j + this.getMap().getStartJ()) {
                            return true;
                        }
                        break;
                    case CLIFF:
                        //System.out.println("k : " + k);
                        if(this.cliffStartHex != null
                            && this.cliffStartHexNeighbours[k] != null
                            && this.cliffStartHexNeighbours[k].getX() == i + this.getMap().getStartI()
                            &&  this.cliffStartHexNeighbours[k].getY() == j + this.getMap().getStartJ()) {
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
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setPathway(false);
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setRoadway(false);
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setRailway(false);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setPathway(false);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setRoadway(false);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setRailway(false);
                break;
            case PATHWAY:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setPathway(true);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setPathway(true);
                break;
            case ROADWAY:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setRoadway(true);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setRoadway(true);
                break;
            case RAILWAY:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRoads().getEdges()[k].setRailway(true);
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRoads().getEdges()[l].setRailway(true);
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
                this.getMap().getHexesArray().get(iStart).get(jStart).getRivers()[k] = RiverCategory.NO_RIVER;
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.NO_RIVER;
                break;
            case NARROW:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRivers()[k] = RiverCategory.NARROW;
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.NARROW;
                break;
            case MEDIUM:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRivers()[k] = RiverCategory.MEDIUM;
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.MEDIUM;
                break;
            case WIDE:
                this.getMap().getHexesArray().get(iStart).get(jStart).getRivers()[k] = RiverCategory.WIDE;
                this.getMap().getHexesArray().get(iEnd).get(jEnd).getRivers()[l] = RiverCategory.WIDE;
                break;
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getMAX_BRUSH_SIZE() {
        return MapConfig.MAX_BRUSH_SIZE;
    }

    public int getMIN_BRUSH_SIZE() {
        return MapConfig.MIN_BRUSH_SIZE;
    }

    public int getMapBrushSize() {
        return mapBrushSize;
    }

    public void setMapBrushSize(int mapBrushSize) {
        this.mapBrushSize = mapBrushSize;
    }
}
