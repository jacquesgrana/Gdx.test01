package com.mycompany.test01.Enum;

public enum ZoomLevelEnum {
    CLOSE_VIEW ("Close View", 60, 8, 2, 4),
    NORMAL_VIEW ("Normal View", 45, 6, 4, 3),
    DISTANT_VIEW("Distant View", 30, 4, 6, 2),
    VERY_DISTANT_VIEW("Very Distant View", 15, 2, 10, 1);

    private final String name;
    private final int hexSize;
    private final int pathThickness;
    private final int deltaKey;
    private final int deltaStack;

    ZoomLevelEnum(String name, int hexSize, int pathThickness, int deltaKey, int deltaStack) {
        this.name = name;
        this.hexSize = hexSize;
        this.pathThickness = pathThickness;
        this.deltaKey = deltaKey;
        this.deltaStack = deltaStack;
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

    public int getDeltaStack() { return deltaStack; }

    @Override
    public String toString() {
        return name;
    }
}
