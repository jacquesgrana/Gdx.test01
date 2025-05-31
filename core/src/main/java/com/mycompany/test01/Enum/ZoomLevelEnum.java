package com.mycompany.test01.Enum;

public enum ZoomLevelEnum {
    CLOSE_VIEW ("Close View", 60),
    NORMAL_VIEW ("Normal View", 45),
    DISTANT_VIEW("Distant View", 30),
    VERY_DISTANT_VIEW("Very Distant View", 20);

    private final String name;
    private final int hexSize;

    ZoomLevelEnum(String name, int hexSize) {
        this.name = name;
        this.hexSize = hexSize;
    }

    public String getName() {
        return name;
    }

    public int getHexSize() {
        return hexSize;
    }

    @Override
    public String toString() {
        return name;
    }
}
