package com.mycompany.test01.Enum;

public enum RiverCategory {
    // NARROW, MEDIUM, WIDE
    NO_RIVER ("No River"),
    NARROW ("Narrow River"),
    MEDIUM ("Medium River"),
    WIDE ("Wide River");

    private final String name;

    RiverCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
