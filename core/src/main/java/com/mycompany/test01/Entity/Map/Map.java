package com.mycompany.test01.Entity.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Scenario.Opponent;
import com.mycompany.test01.Entity.Scenario.Scenario;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.LogUtil;
import com.mycompany.test01.Util.MapUtil;
import com.mycompany.test01.Util.UnitUtil;

import java.util.Set;

public class Map {
    public static final int COMPANIES_PER_UNIT = 3;

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

    private MiniMap minimap;

    public Map() {
        this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
        this.displayFlags = new MapDisplayFlags();
        this.minimap = new MiniMap();
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

    public void initMap(
        float mapX, float mapY,
        float mapWidth, float mapHeight
    ) {
        int limitI = this.getLimitI();
        int limitJ = this.getLimitJ();
        this.setHexagonSize(this.getZoomLevel().getHexSize());
        this.setGapX((int) this.getHexagonSize() * 5 / 3);
        this.setGapY((int) this.getHexagonSize() * 3 / 2);
        this.setMargin(10);

        /*
        this.setMapWidth(Gdx.graphics.getWidth() - 500f);
        this.setMapHeight(Gdx.graphics.getHeight() - 230f);

        this.setMapX(50);
        this.setMapY(180);
         */
        this.setMapWidth(mapWidth);
        this.setMapHeight(mapHeight);

        this.setMapX(mapX);
        this.setMapY(mapY);

        this.setMaxI((int) (this.getMapWidth() - this.getMargin() * 2) / (this.getGapX()));
        this.setMaxI(this.getMaxI() % 2 == 0 ? this.getMaxI() : this.getMaxI() - 1);
        this.setMaxI(Math.min(this.getMaxI(), this.getLimitI()));

        this.setMaxJ((int) (this.getMapHeight() - this.getMargin() * 2) / (this.getGapY()));
        this.setMaxJ(this.getMaxJ() % 2 == 0 ? this.getMaxJ() : this.getMaxJ() - 1);
        this.setMaxJ(Math.min(this.getMaxJ(), this.getLimitJ()));

        this.setStartI((int) (limitI - this.getMaxI()) / 2);
        this.setStartI(this.getStartI() % 2 == 0 ? this.getStartI() : this.getStartI() + 1);
        this.setStartI(Math.max(this.getStartI(), 0));
        this.setStartI(Math.min(this.getStartI(), limitI - this.getMaxI()));

        this.setStartJ((int) (limitJ - this.getMaxJ()) / 2);
        this.setStartJ(this.getStartJ() % 2 == 0 ? this.getStartJ() : this.getStartJ() + 1);
        this.setStartJ(Math.max(this.getStartJ(), 0));
        this.setStartJ(Math.min(this.getStartJ(), limitJ - this.getMaxJ()));
    }

    public void initMapFromZoomWrapper() {
        /*
        this.setMapWidth(Gdx.graphics.getWidth() - 500f);
        this.setMapHeight(Gdx.graphics.getHeight() - 230f);

        this.setMapX(50);
        this.setMapY(180);
         */
        this.initMapFromZoom(
            50f,
            180f,
            Gdx.graphics.getWidth() - 500f,
            Gdx.graphics.getHeight() - 230f
            );
    }

    public void initMapFromZoom(float mapX, float mapY, float mapWidth, float mapHeight) {
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

        this.setMapWidth(mapWidth);
        this.setMapHeight(mapHeight);

        this.setMapX(mapX);
        this.setMapY(mapY);

        this.setMaxI((int) (this.getMapWidth() - this.getMargin() * 2) / (this.getGapX()));
        this.setMaxI(this.getMaxI() % 2 == 0 ? this.getMaxI() : this.getMaxI() - 1);
        this.setMaxI(Math.min(this.getMaxI(), limitI));

        this.setMaxJ((int) (this.getMapHeight() - this.getMargin() * 2) / (this.getGapY()));
        this.setMaxJ(this.getMaxJ() % 2 == 0 ? this.getMaxJ() : this.getMaxJ() - 1);
        this.setMaxJ(Math.min(this.getMaxJ(), limitJ));

        this.setStartI(middleI - ( this.getMaxI() / 2 ));
        this.setStartI( this.getStartI() % 2 == 0 ? this.getStartI() : this.getStartI() + 1);
        this.setStartI(Math.max(this.getStartI(), 0));
        this.setStartI(Math.min(this.getStartI(), limitI - this.getMaxI()));

        this.setStartJ(middleJ - ( this.getMaxJ() / 2 ));
        this.setStartJ(this.getStartJ() % 2 == 0 ? this.getStartJ() : this.getStartJ() + 1);
        this.setStartJ(Math.max(this.getStartJ(), 0));
        this.setStartJ(Math.min(this.getStartJ(), limitJ - this.getMaxJ()));
    }


    public void initMiniMap() {
        this.getMinimap().setMiniHexSize(2);
        this.getMinimap().setMiniMapMargin(10);
        //calcul des coordonnées et dimensions de la minimap
        this.getMinimap().setMiniMapWidth(this.getLimitI() * this.getMinimap().getMiniHexSize() + 2 * this.getMinimap().getMiniMapMargin());
        this.getMinimap().setMiniMapHeight(this.getLimitJ() * this.getMinimap().getMiniHexSize() + 2 * this.getMinimap().getMiniMapMargin());
        this.getMinimap().setMiniMapX((int) this.getMapWidth() - this.getMinimap().getMiniMapWidth());
        this.getMinimap().setMiniMapY((int) this.getMapHeight() - this.getMinimap().getMiniMapHeight());
    }


    public void updateMiniMap(int x, int y, Pixmap drawingMapPixmap) {
        x = x - this.getMinimap().getMiniMapX() - this.getMinimap().getMiniMapMargin();
        y = y - this.getMinimap().getMiniMapY() - this.getMinimap().getMiniMapMargin();

        // calcul de j
        int j = (int) y / this.getMinimap().getMiniHexSize();
        int i=0;
        // calcul de i en tenant compte de j%2
        if(j % 2 == 0) {
            i = (int) ((x + this.getMinimap().getMiniHexSize()/2) / this.getMinimap().getMiniHexSize());
        }
        else {
            i = (int) x / this.getMinimap().getMiniHexSize();
        }

        //this.getMap().getStartI()
        // 'cappage'
        // TODO modifier le calcul pour que le rectangle de sélection soit centré sur le clic
        // TODO ajouter la moitié de MaxI et MaxJ ?
        this.setStartI(i < 0 ? 0 : i >= this.getLimitI() - this.getMaxI() ? this.getLimitI() - this.getMaxI() - 1 : i);
        this.setStartJ(j < 0 ? 0 : j >= this.getLimitJ() - this.getMaxJ() ? this.getLimitJ() - this.getMaxJ() - 1 : j);
        // utiliser des valeurs paires
        this.setStartI(this.getStartI() - this.getStartI()%2);
        this.setStartJ(this.getStartJ() - this.getStartJ()%2);
        //this.startI = i;
        //this.startJ = j;
        // dessin du rectangle (faire méthode ?)
        //this.showMiniMap(drawingMapPixmap);

        //this.getMap().getStartJ()
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
        //this.initMap();
        //this.generateBridgesFromRiversAndRoads();
    }

    public MapData getMapData() {
        return new MapData("test", this.getLimitI(), this.getLimitJ(), this.getHexesArray());
    }

    public void drawMap(Pixmap drawingPixmap, Opponent[] opponents, int hexSize) {
        for(int i=0; i < this.getMaxI(); i++) {
            for (int j=0; j < this.getMaxJ(); j++) {
                //int x = getXFromIJ(i, j);
                //int y = getYFromJ(j);

                Texture texture = GraphicUtil.getTextureFromTerrain(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getCategory());

                renderHex(i + startI, j + startJ, texture, drawingPixmap);
                //drawHexagon(drawingPixmap, x, y, this.getHexagonSize(), texture, Color.BLACK);
                //renderHex(i + startI, j + startJ, texture, drawingPixmap);
                texture.dispose();

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
                            i, j, this.getHexagonSize() * 2, // ajouté !!
                            GraphicUtil.getTextureFromFortification(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getFortification()));
                    }
                }

                // dessin des unités
                if(this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getUnits().getUnitsCount() > 0) {

                    // TODO appeler méthode de GraphicUtil qui affiche la pile des unites
                    drawUnitsStackOnHex(i, j, this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getUnits(), hexSize, drawingPixmap);

                    // TODO améliorer !!!
                    //ElementInterface firstLineUnit = this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getUnits().getFirstLine().getHexUnit()[0];
                    //LogUtil.logInfo("unit name : " + firstLineUnit.getName());

                    // TODO passer l'unité en paramètre
                    //drawUnitOnHex(i, j, firstLineUnit, hexSize, drawingPixmap);

                    //textureFirstLine.dispose();
                }



                // dessin du land owner
                // Récupérer le propriétaire de l'hexagone
                CountryEnum ownerCountry = this.getHexesArray().get(i + this.getStartI()).get(j + this.getStartJ()).getOwnerCountry();

                if(ownerCountry != null && ownerCountry != CountryEnum.NO_COUNTRY && this.displayFlags.isOwnerCountryVisible()) {

                    Color ownerColor = GraphicUtil.getTransparentColorFromCountry(ownerCountry, 0.25f);

                    // 2. Créer une texture 1x1 avec cette couleur
                    Texture colorTexture = GraphicUtil.getTextureFromColor(ownerColor);

                        //LogUtil.logInfo("hex a colorer en : " + ownerColor.toString());
                    // 3. Dessiner l'hexagone avec cette texture (sans bordure pour éviter un double contour)

                    // TODO utiliser renderHex ??
                    //drawHexagon(drawingPixmap, x, y, this.getHexagonSize(), colorTexture, Color.BLACK);
                    renderHex(i + startI, j + startJ, colorTexture, drawingPixmap);
                    // 4. Libérer les ressources
                    colorTexture.dispose();
                    //colorPixmap.dispose();
                }

            }
        }

        boolean isBorderShown = this.startI == 0
            || startI + maxI == limitI
            || startJ == 0
            || startJ + maxJ == limitJ;

        // boucle sur les opponents
        if(opponents.length > 0 && isBorderShown) {
            //LogUtil.logInfo("border shown !");
            for (Opponent opponent : opponents) {

                // dessin des borderHexes
                if(!opponent.getBorderHexesOwned().isEmpty()) {
                    for (Hexagon hexagon : opponent.getBorderHexesOwned()) {

                        if(!opponent.getReinfHexesSource().contains(hexagon) && !opponent.getSupplyHexesSource().contains(hexagon)) {
                            //int xx = getXFromIJ(hexagon.getX() - startI, hexagon.getY() - startJ);
                            //int yy = getYFromJ(hexagon.getY() - startJ);
                            Color opponentColor = GraphicUtil.getTransparentColorFromCountry(opponent.getCountry(), 0.40f);
                            Texture opponentColorTexture = GraphicUtil.getTextureFromColor(opponentColor);
                            //drawHexagon(drawingPixmap, xx, yy, this.getHexagonSize(), opponentColorTexture, Color.BLACK);
                            renderHex(hexagon.getX(), hexagon.getY(), opponentColorTexture, drawingPixmap);
                            opponentColorTexture.dispose();
                        }


                    }
                }

                // dessin des reinfHexes
                if(!opponent.getReinfHexesSource().isEmpty()) {
                    for (Hexagon hexagon : opponent.getReinfHexesSource()) {
                        if(!opponent.getSupplyHexesSource().contains(hexagon)) {
                            //int xx = getXFromIJ(hexagon.getX() - startI, hexagon.getY() - startJ);
                            //int yy = getYFromJ(hexagon.getY() - startJ);
                            Color opponentColor = GraphicUtil.getTransparentColorFromCountry(opponent.getCountry(), 0.60f);
                            Texture colorTexture = GraphicUtil.getTextureFromColor(opponentColor);
                            //drawHexagon(drawingPixmap, xx, yy, this.getHexagonSize(), colorTexture, Color.BLACK);
                            renderHex(hexagon.getX(), hexagon.getY(), colorTexture, drawingPixmap);
                            colorTexture.dispose();
                        }
                    }
                }


                // dessin des supplyHexes
                if(!opponent.getSupplyHexesSource().isEmpty()) {
                    for (Hexagon hexagon : opponent.getSupplyHexesSource()) {
                        Color opponentColor = GraphicUtil.getTransparentColorFromCountry(opponent.getCountry(), 0.8f);
                        Texture colorTexture = GraphicUtil.getTextureFromColor(opponentColor);
                        renderHex(hexagon.getX(), hexagon.getY(), colorTexture, drawingPixmap);
                        colorTexture.dispose();
                    }
                }


            }
        }
    }

    public void drawRoadSegment(Pixmap drawingPixmap, int i, int j, RoadCategory roadCategory, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getRoadTextureFromRoadCatAndK(roadCategory, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);
        this.drawPixmapFromTexturePixmap(drawingPixmap, texturePixmap, x, y);
        texture.dispose();
    }

    public void drawRiverSide(Pixmap drawingPixmap, int i, int j, RiverCategory riverCategory, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getRiverTextureFromRiverCatAndK(riverCategory, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);
        this.drawPixmapFromTexturePixmap(drawingPixmap, texturePixmap, x, y);
        texture.dispose();

    }

    public void drawBridgeSide(Pixmap drawingPixmap, int i, int j, BridgeTypeEnum bridgeType, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getTextureSideFromBridge(bridgeType, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);
        this.drawPixmapFromTexturePixmap(drawingPixmap, texturePixmap, x, y);
        texture.dispose();
    }

    public void drawCliffSide(Pixmap drawingPixmap, int i, int j, Cliff cliff, int k) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
        Texture texture = GraphicUtil.getTextureSideFromCliff(cliff, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);
        this.drawPixmapFromTexturePixmap(drawingPixmap, texturePixmap, x, y);
        texture.dispose();
    }

    private void drawPixmapFromTexturePixmap(Pixmap drawingPixmap, Pixmap texturePixmap, int x, int y) {
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
    }

    public void drawFortification(
        Pixmap drawingPixmap,
        int i, int j, int hexagonSize,
        Texture fortifTexture) {
        int x = getXFromIJ(i, j);
        int y = getYFromJ(j);
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

            //texturePixmap.dispose();
        } else {
            System.err.println("Error: Could not convert fortifTexture to Pixmap.");
        }
    }

    public void drawUnitsStackOnHex(int iRel, int jRel, HexUnits units, int hexagonSize, Pixmap drawingPixmap) {
        if (units == null || units.getUnitsCount() == 0) {
            System.err.println("Error: unit null.");
            return;
        }

        int x = getXFromIJ(iRel, jRel);
        int y = getYFromJ(jRel);

        // TODO faire méthode qd ok !!
        OrderedSet<ElementInterface> unitsSet = new OrderedSet<>();
        for (int i = 0; i < COMPANIES_PER_UNIT; i++) {
            if(units.getFirstLine().getHexUnit()[i] != null) {
                unitsSet.add(units.getFirstLine().getHexUnit()[i]);
            }
        }
        for (int i = 0; i < COMPANIES_PER_UNIT; i++) {
            if(units.getSecondLine().getHexUnit()[i] != null) {
                unitsSet.add(units.getSecondLine().getHexUnit()[i]);
            }
        }
        for (int i = 0; i < COMPANIES_PER_UNIT; i++) {
            if(units.getReserve().getHexUnit()[i] != null) {
                unitsSet.add(units.getReserve().getHexUnit()[i]);
            }
        }
        /*
        for (int i = 0; i < COMPANIES_PER_UNIT; i++) {
            if(units.getReserveSup().getHexUnit()[i] != null) {
                unitsSet.add(units.getReserveSup().getHexUnit()[i]);
            }
        }
        for (int i = 0; i < COMPANIES_PER_UNIT; i++) {
            if(units.getReserveMax().getHexUnit()[i] != null) {
                unitsSet.add(units.getReserveMax().getHexUnit()[i]);
            }
        }
        */
        unitsSet.orderedItems().reverse();

        int cpt = 0;
        float pixelByUnitRatio = this.getZoomLevel().getDeltaStack();
        int delta = (int) (unitsSet.orderedItems().size * pixelByUnitRatio);
        for(ElementInterface unit : unitsSet.orderedItems()) {
            cpt++;
            LogUtil.logInfo("unit : name : " + unit.getName() + " / isCompany : " + unit.isCompany() + " / type : " + unit.getType().getName() + " / cpt : " + cpt);


            Pixmap unitPixmap = GraphicUtil.getCounterPixmapFromUnit(unit, hexagonSize, hexagonSize);
            if (unitPixmap != null) {
                drawingPixmap.drawPixmap(
                    unitPixmap,     // Source Pixmap
                    0, 0,        // Source X,Y
                    unitPixmap.getWidth(), unitPixmap.getHeight(), // Source width & height
                    (int) ((x - hexagonSize / 2) - cpt * pixelByUnitRatio) + delta/2, (int) ((y - hexagonSize / 2) - cpt * pixelByUnitRatio) + delta/2,   // Dest X,Y
                    hexagonSize, hexagonSize   // Dest width & height
                );
            }
            unitPixmap.dispose();
        }



        // construire une liste (avec ordre) des unités en ordre inverse (firstline à la fin)
            // boucle sur la liste obtenue
                // dessine l'unité avec un décalage du se vers le nw
    }

    public void drawUnitOnHex(int iRel, int jRel, ElementInterface unit, int hexagonSize, Pixmap drawingPixmap) {
        if (unit == null) {
            System.err.println("Error: unit null.");
            return;
        }

        int x = getXFromIJ(iRel, jRel);
        int y = getYFromJ(jRel);

        Pixmap unitPixmap = GraphicUtil.getCounterPixmapFromUnit(unit, hexagonSize, hexagonSize);

        if (unitPixmap != null) {
            try {
                drawingPixmap.drawPixmap(
                    unitPixmap,                                 // Source Pixmap
                    0, 0,                                       // Source X,Y
                    unitPixmap.getWidth(), unitPixmap.getHeight(), // Source width & height
                    x - hexagonSize / 2, y - hexagonSize / 2,   // Dest X,Y
                    hexagonSize, hexagonSize                     // Dest width & height
                );
            } catch (Exception e) {
                // Utilisez une journalisation plus robuste si possible
                System.err.println("Error drawing unit pixmap: " + e.getMessage());
            } finally {
                // TRÈS IMPORTANT : Libérez la mémoire du pixmap que vous avez créé
                unitPixmap.dispose();
            }
        } else {
            System.err.println("Error: Could not create a Pixmap for the unit.");
        }
    }




    /*
    public void drawUnitsOnHex(int iRel,int jRel, ElementInterface unit, int hexagonSize, Pixmap drawingPixmap) {
        int x = getXFromIJ(iRel, jRel);
        int y = getYFromJ(jRel);

        Texture textureFirstLine = GraphicUtil.getCounterTextureFromUnit(unit);

        if (unit == null) {
            System.err.println("Error: unit null.");
            return; // Exit the method if the texture is null
        }

        textureFirstLine = GraphicUtil.orangeTexture;

        Pixmap texturePixmap = GraphicUtil.textureToPixmapSafe(textureFirstLine, hexagonSize, hexagonSize);
        if (texturePixmap != null) {
            // Draw the texture onto the drawingPixmap, scaling it to fit within the hexagonSize
            try{


                drawingPixmap.drawPixmap(
                    texturePixmap, // Source Pixmap
                    0, 0,     // Source X,Y (top-left of source)
                    texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                    x - hexagonSize/2, y - hexagonSize/2,            // Dest X,Y (top-left of destination)
                    hexagonSize, hexagonSize    // Dest width & height (scaling)
                );

            }
            catch (Exception e) {
                LogUtil.logError("Error : ");
            }


            texturePixmap.dispose();
        } else {
            System.err.println("Error: Could not convert textureFirstLine to Pixmap.");
        }
    }
     */

    private static void drawPixmapClipped(
        Pixmap dst, Pixmap src,
        int srcX, int srcY, int srcW, int srcH,
        int dstX, int dstY, int dstW, int dstH) {

        // Rien à dessiner
        if (dstW <= 0 || dstH <= 0 || srcW <= 0 || srcH <= 0) return;

        // Clipping destination dans [0..dst.width/height)
        int clipX = Math.max(dstX, 0);
        int clipY = Math.max(dstY, 0);
        int clipW = Math.min(dstX + dstW, dst.getWidth()) - clipX;
        int clipH = Math.min(dstY + dstH, dst.getHeight()) - clipY;
        if (clipW <= 0 || clipH <= 0) return;

        // Ratio de scaling entre src et dst
        float scaleX = (float) srcW / (float) dstW;
        float scaleY = (float) srcH / (float) dstH;

        // Ajuste la source pour coller au clip destination
        int adjSrcX = srcX + Math.round((clipX - dstX) * scaleX);
        int adjSrcY = srcY + Math.round((clipY - dstY) * scaleY);
        int adjSrcW = Math.round(clipW * scaleX);
        int adjSrcH = Math.round(clipH * scaleY);

        // Clamp source dans les bornes src
        if (adjSrcX < 0) { adjSrcW += adjSrcX; adjSrcX = 0; }
        if (adjSrcY < 0) { adjSrcH += adjSrcY; adjSrcY = 0; }
        adjSrcW = Math.min(adjSrcW, src.getWidth()  - adjSrcX);
        adjSrcH = Math.min(adjSrcH, src.getHeight() - adjSrcY);
        if (adjSrcW <= 0 || adjSrcH <= 0) return;

        // Dessin sécurisé
        dst.drawPixmap(src,
            adjSrcX, adjSrcY, adjSrcW, adjSrcH,
            clipX,   clipY,   clipW,   clipH);
    }

     /*
    public void drawUnitsOnHex(int iRel, int jRel, Texture textureFirstLine, int hexagonSize, Pixmap drawingPixmap) {
        int x = getXFromIJ(iRel, jRel);
        int y = getYFromJ(jRel);

        if (textureFirstLine == null) {
            System.err.println("Error: textureFirstLine is null.");
            return;
        }

        Texture scaledTexture = null;
        Pixmap scaledPixmap = null;

        try {
            // Créer une texture redimensionnée via GPU
            scaledTexture = GraphicUtil.resizeTexture(textureFirstLine, hexagonSize, hexagonSize);

            if (scaledTexture == null) {
                LogUtil.logError("Failed to resize texture");
                return;
            }

            // Convertir en Pixmap pour dessiner
            scaledPixmap = GraphicUtil.textureToPixmap(scaledTexture);

            if (scaledPixmap != null) {
                drawingPixmap.setBlending(Pixmap.Blending.SourceOver);
                drawingPixmap.drawPixmap(
                    scaledPixmap,
                    x - hexagonSize/2,
                    y - hexagonSize/2
                );
            }

        } catch (Exception e) {
            LogUtil.logError("Error in drawUnitsOnHex: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (scaledPixmap != null) scaledPixmap.dispose();
            if (scaledTexture != null) scaledTexture.dispose();
        }
    }


      */

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
    /*
    private void drawHexagon(Pixmap pixmap, int centerX, int centerY, int size, Texture texture, Color borderColor) {
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
    }*/

    public void renderHex(int hexIAbs, int hexJAbs, Texture texture, Pixmap pixmap) {
        // Calculer les coordonnées du centre de l'hexagone
        int centerX = getXFromIJ(hexIAbs - this.getStartI(), hexJAbs - this.getStartJ());
        int centerY = getYFromJ(hexJAbs - this.getStartJ());
        // Dessiner l'hexagone avec la couleur spécifiée
        //Texture textureGrass = GraphicUtil.loadTexture("texture/texture-grass.png");
        MapUtil.drawHexagon(pixmap, centerX, centerY, this.getHexagonSize(), texture, Color.BLACK);
    }

    public void generateBridgesFromRiversAndRoads() {
        for(int i=0; i < this.getLimitI(); i++) {
            for (int j=0; j < this.getLimitJ(); j++) {
                Hexagon hex = this.getHexesArray().get(i).get(j);
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
                        this.getHexesArray().get(i).get(j).getBridges().getEdges()[k].setBridgeType(bridgeType);
                    }
                    else {
                        this.getHexesArray().get(i).get(j).getBridges().getEdges()[k].setBridgeType(BridgeTypeEnum.NO_BRIDGE);
                    }
                }
            }
        }
    }

    public void showMiniMap(Pixmap drawingMapPixmap) {
        drawingMapPixmap.setColor(Color.BLACK);
        drawingMapPixmap.fillRectangle(this.getMinimap().getMiniMapX(), this.getMinimap().getMiniMapY(), this.getMinimap().getMiniMapWidth(), this.getMinimap().getMiniMapHeight());

        // dessin de la miniMap
        for(int i=0; i<this.getLimitI(); i++) {
            for(int j=0; j<this.getLimitJ(); j++) {
                Color fillColor = GraphicUtil.getColorFromTerrain(this.getHexesArray().get(i).get(j).getCategory());
                drawingMapPixmap.setColor(fillColor);

                for(int k=0; k<this.getMinimap().getMiniHexSize(); k++) {
                    int x = this.getMinimap().getMiniMapX() + this.getMinimap().getMiniMapMargin() + k + i * this.getMinimap().getMiniHexSize();
                    if(j%2==0) x += (int) this.getMinimap().getMiniHexSize() / 2;
                    for(int l=0; l<this.getMinimap().getMiniHexSize(); l++) {
                        int y = this.getMinimap().getMiniMapY() + this.getMinimap().getMiniMapMargin() + l + j * this.getMinimap().getMiniHexSize();
                        drawingMapPixmap.drawPixel(x, y);
                    }
                }
            }
        }

        drawingMapPixmap.setColor(Color.WHITE);
        int selectRectWidth =  this.getMinimap().getMiniHexSize() * this.getMaxI();
        int selectRectHeight = this.getMinimap().getMiniHexSize() * this.getMaxJ();

        int rectX = this.getMinimap().getMiniMapX() + this.getMinimap().getMiniMapMargin() + this.getMinimap().getMiniHexSize() * this.getStartI();
        int rectY = this.getMinimap().getMiniMapY() + this.getMinimap().getMiniMapMargin() + this.getMinimap().getMiniHexSize() * this.getStartJ();
        drawingMapPixmap.drawRectangle(rectX, rectY, selectRectWidth, selectRectHeight);
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

    public boolean isClickInMap(int i, int j) {
        if(i >= 0 && i < this.getMaxI() && j >= 0 && j < this.getMaxJ()) {
            return true;
        }
        else {
            return false;
        }
    }

    // Getters et Setters

    public void setStartI(int startI) {
        this.startI = startI;

        if(startI%2 != 0) startI--;
        if(startI > this.getLimitI() - this.getMaxI()) {
            this.startI = this.getLimitI() - this.getMaxI();
            //this.setStartI(this.getLimitI() - this.getMaxI() - 1);
        }
        else if (startI < 0) {
            this.startI = 0;
            //this.setStartI(0);
        }
        else {
            this.startI = startI;
            //this.setStartI(startI);
        }
    }

    public void setStartJ(int startJ) {
        this.startJ = startJ;

        if(startJ%2 != 0) startJ--;
        if(startJ > this.getLimitJ() - this.getMaxJ()) {
            //this.setStartJ(this.getLimitJ() - this.getMaxJ() - 1);
            this.startJ = this.getLimitJ() - this.getMaxJ();
        }
        else if (startJ < 0) {
            //this.setStartJ(0);
            this.startJ = 0;
        }
        else {
            //this.setStartJ(startJ);
            this.startJ = startJ;
            //this.startJ = startJ % 2 == 0 ? startJ : startJ-1;
        }
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

    public MiniMap getMinimap() {
        return minimap;
    }

    public void setMinimap(MiniMap minimap) {
        this.minimap = minimap;
    }
}
