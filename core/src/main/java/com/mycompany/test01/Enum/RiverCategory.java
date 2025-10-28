package com.mycompany.test01.Enum;

public enum RiverCategory {
    // NARROW, MEDIUM, WIDE
    NO_RIVER ("No River", 0),
    NARROW ("Narrow River", 2),
    MEDIUM ("Medium River", 4),
    WIDE ("Wide River", 6);

    private final String name;
    private final int lineThickness;

    RiverCategory(String name, int lineThickness) {
        this.name = name;
        this.lineThickness = lineThickness;
    }

    public String getName() {
        return this.name;
    }

    public int getLineThickness() { return lineThickness; }

    @Override
    public String toString() {
        return this.name;
    }
}
