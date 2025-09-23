package com.mycompany.test01.Entity.Map;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Enum.ZoomLevelEnum;

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

    public Map() {
        this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
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
        ZoomLevelEnum zoomLevel
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

    public void setStartI(int startI) {
        this.startI = startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public void setStartJ(int startJ) {
        this.startJ = startJ;
    }

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
}
