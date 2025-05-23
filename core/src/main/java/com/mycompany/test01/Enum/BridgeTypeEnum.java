package com.mycompany.test01.Enum;

public enum BridgeTypeEnum {
    NO_BRIDGE("No bridge"),
    LIGHT_BRIDGE("Light Bridge"),
    MEDIUM_BRIDGE("Medium Bridge"),
    HEAVY_BRIDGE("Heavy Bridge");

    private final String name;

    BridgeTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
