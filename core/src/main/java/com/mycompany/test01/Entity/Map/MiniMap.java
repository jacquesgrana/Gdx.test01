package com.mycompany.test01.Entity.Map;

public class MiniMap {
    private int miniHexSize = 0;
    private int miniMapMargin = 0;
    private int miniMapWidth = 0;
    private int miniMapHeight = 0;
    private int miniMapX = 0;
    private int miniMapY = 0;

    public MiniMap() {
    }

    public MiniMap(
        int miniHexSize,
        int miniMapMargin,
        int miniMapWidth,
        int miniMapHeight,
        int miniMapX,
        int miniMapY
    ) {
        this.miniHexSize = miniHexSize;
        this.miniMapMargin = miniMapMargin;
        this.miniMapWidth = miniMapWidth;
        this.miniMapHeight = miniMapHeight;
        this.miniMapX = miniMapX;
        this.miniMapY = miniMapY;
    }

    public int getMiniHexSize() {
        return miniHexSize;
    }

    public void setMiniHexSize(int miniHexSize) {
        this.miniHexSize = miniHexSize;
    }

    public int getMiniMapMargin() {
        return miniMapMargin;
    }

    public void setMiniMapMargin(int miniMapMargin) {
        this.miniMapMargin = miniMapMargin;
    }

    public int getMiniMapWidth() {
        return miniMapWidth;
    }

    public void setMiniMapWidth(int miniMapWidth) {
        this.miniMapWidth = miniMapWidth;
    }

    public int getMiniMapHeight() {
        return miniMapHeight;
    }

    public void setMiniMapHeight(int miniMapHeight) {
        this.miniMapHeight = miniMapHeight;
    }

    public int getMiniMapX() {
        return miniMapX;
    }

    public void setMiniMapX(int miniMapX) {
        this.miniMapX = miniMapX;
    }

    public int getMiniMapY() {
        return miniMapY;
    }

    public void setMiniMapY(int miniMapY) {
        this.miniMapY = miniMapY;
    }
}
