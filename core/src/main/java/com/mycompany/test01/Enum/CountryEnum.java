package com.mycompany.test01.Enum;

import com.badlogic.gdx.graphics.Color;

import java.util.Objects;

public enum CountryEnum {
    RED_COUNTRY ("Red Country", new Color(0.85f, 0.16f, 0.16f, 1.0f)),
    BLUE_COUNTRY("Blue Country", new Color(0.12f, 0.47f, 0.88f, 1.0f)),
    BLACK_COUNTRY ("Black Country", new Color(0.15f, 0.15f, 0.15f, 1.0f)),
    GREEN_COUNTRY ("Green Country", new Color(0.27f, 0.64f, 0.25f, 1.0f)),
    YELLOW_COUNTRY ("Yellow Country", new Color(0.98f, 0.85f, 0.27f, 1.0f)),
    BROWN_COUNTRY ("Brown Country", new Color(0.65f, 0.45f, 0.22f, 1.0f)),
    NO_COUNTRY ("No Country", new Color(0f, 0f, 0f, 0f));

    private final String name;
    private final Color color;

    CountryEnum(String name, Color color) {

        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return color;
    }

    public boolean equals(CountryEnum toCompare) {
        return Objects.equals(this.name, toCompare.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
