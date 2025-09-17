package com.mycompany.test01.Enum;

public enum ZoomLevelEnum {
    CLOSE_VIEW ("Close View", 60, 8),
    NORMAL_VIEW ("Normal View", 45, 6),
    DISTANT_VIEW("Distant View", 30, 4),
    VERY_DISTANT_VIEW("Very Distant View", 15, 2);

    private final String name;
    private final int hexSize;
    private final int pathThickness;

    ZoomLevelEnum(String name, int hexSize, int pathThickness) {
        this.name = name;
        this.hexSize = hexSize;
        this.pathThickness = pathThickness;
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

    @Override
    public String toString() {
        return name;
    }
}
