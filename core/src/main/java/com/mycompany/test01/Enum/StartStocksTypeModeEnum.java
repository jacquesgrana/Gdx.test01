package com.mycompany.test01.Enum;

public enum StartStocksTypeModeEnum {
    SUPPLY ("Resupply"),
    UNIT_REINF ("Unit Reinforcement"),
    NO_ACTION ("No Action");

    private final String name;

    StartStocksTypeModeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
