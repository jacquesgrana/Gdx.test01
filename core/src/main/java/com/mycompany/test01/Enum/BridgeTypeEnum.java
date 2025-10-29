package com.mycompany.test01.Enum;

public enum BridgeTypeEnum {
    NO_BRIDGE("No bridge", 0),
    LIGHT_BRIDGE("Light Bridge", 2),
    MEDIUM_BRIDGE("Medium Bridge", 3),
    HEAVY_BRIDGE("Heavy Bridge", 6);

    private final String name;
    private final int repairDelay;

    BridgeTypeEnum(String name, int repairDelay) {
        this.name = name;
        this.repairDelay = repairDelay;
    }

    public String getName() {
        return name;
    }

    public int getRepairDelay(){return repairDelay;}

    @Override
    public String toString() {
        return this.getName();
    }
}
