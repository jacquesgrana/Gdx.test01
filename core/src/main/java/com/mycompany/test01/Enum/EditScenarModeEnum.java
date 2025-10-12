package com.mycompany.test01.Enum;

public enum EditScenarModeEnum {
    NO_ACTION ("No Action"),
    OWNED_HEXES ("Owned Hexes"),
    EDGES_HEXES ("Edges Hexes"),
    SUPPLY_HEXES ("Supply Edges");

    private final String name;

    EditScenarModeEnum(String name) {
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
