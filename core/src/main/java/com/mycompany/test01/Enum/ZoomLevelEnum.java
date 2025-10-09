package com.mycompany.test01.Enum;

public enum ZoomLevelEnum {
    CLOSE_VIEW ("Close View", 60, 8, 2),
    NORMAL_VIEW ("Normal View", 45, 6, 4),
    DISTANT_VIEW("Distant View", 30, 4, 6),
    VERY_DISTANT_VIEW("Very Distant View", 15, 2, 10);

    private final String name;
    private final int hexSize;
    private final int pathThickness;
    private final int deltaKey;

    ZoomLevelEnum(String name, int hexSize, int pathThickness, int deltaKey) {
        this.name = name;
        this.hexSize = hexSize;
        this.pathThickness = pathThickness;
        this.deltaKey = deltaKey;
    }

    public String getName() {
        return name;
    }

    public int getHexSize() {
        return hexSize;
    }

    public int getPathThickness() {
        return pathThickness;
    }

    public int getDeltaKey() {
        return deltaKey;
    }

    @Override
    public String toString() {
        return name;
    }
}
