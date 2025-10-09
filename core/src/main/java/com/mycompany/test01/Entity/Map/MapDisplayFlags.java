package com.mycompany.test01.Entity.Map;

public class MapDisplayFlags {
    private boolean isRiverVisible = true;
    private boolean isRoadVisible = true;
    private boolean isFortificationVisible = true;
    private boolean isCliffVisible = true;
    private boolean isBridgeVisible = true;
    private boolean isOwnerCountryVisible = true;

    public MapDisplayFlags() {
    }

    public MapDisplayFlags(
        boolean isRiverVisible,
        boolean isRoadVisible,
        boolean isFortificationVisible,
        boolean isCliffVisible,
        boolean isBridgeVisible,
        boolean isOwnerCountryVisible
    ) {
        this.isRiverVisible = isRiverVisible;
        this.isRoadVisible = isRoadVisible;
        this.isFortificationVisible = isFortificationVisible;
        this.isCliffVisible = isCliffVisible;
        this.isBridgeVisible = isBridgeVisible;
        this.isOwnerCountryVisible = isOwnerCountryVisible;
    }

    public boolean isRiverVisible() {
        return isRiverVisible;
    }

    public void setRiverVisible(boolean riverVisible) {
        isRiverVisible = riverVisible;
    }

    public boolean isRoadVisible() {
        return isRoadVisible;
    }

    public void setRoadVisible(boolean roadVisible) {
        isRoadVisible = roadVisible;
    }

    public boolean isFortificationVisible() {
        return isFortificationVisible;
    }

    public void setFortificationVisible(boolean fortificationVisible) {
        isFortificationVisible = fortificationVisible;
    }

    public boolean isCliffVisible() {
        return isCliffVisible;
    }

    public void setCliffVisible(boolean cliffVisible) {
        isCliffVisible = cliffVisible;
    }

    public boolean isBridgeVisible() {
        return isBridgeVisible;
    }

    public void setBridgeVisible(boolean bridgeVisible) {
        isBridgeVisible = bridgeVisible;
    }

    public boolean isOwnerCountryVisible() {
        return isOwnerCountryVisible;
    }

    public void setOwnerCountryVisible(boolean ownerCountryVisible) {
        isOwnerCountryVisible = ownerCountryVisible;
    }
}
