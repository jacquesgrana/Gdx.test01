package com.mycompany.test01.Enum;

public enum EditMapMode {
    NO_ACTION ("No Action"),
    TERRAIN ("Terrain"),
    RIVER("River"),
    ROAD("Road"),
    FORTIFICATION("Fortification"),
    MISC("Miscellaneous");

    private final String name;

    EditMapMode(String name) {
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
