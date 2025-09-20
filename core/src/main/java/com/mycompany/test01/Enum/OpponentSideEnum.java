package com.mycompany.test01.Enum;

public enum OpponentSideEnum {
    SIDE_ONE("Side One"),
    SIDE_TWO("Side Two"),
    SIDE_THREE("Side Three"),
    SIDE_FOUR("Side Four"),
    NO_SIDE("No Side");

    private final String name;

    OpponentSideEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
