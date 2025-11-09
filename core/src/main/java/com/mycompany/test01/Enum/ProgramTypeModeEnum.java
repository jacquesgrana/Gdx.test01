package com.mycompany.test01.Enum;

public enum ProgramTypeModeEnum {
    REINF ("Reinforcement"),
    RESUPP ("Resupply"),
    UNIT_REINF ("Unit Reinforcement"),
    NO_ACTION ("No Action");

    private final String name;

    ProgramTypeModeEnum(String name) {
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
