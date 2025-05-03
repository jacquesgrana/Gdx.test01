package com.mycompany.test01.Enum;

public enum CountryEnum {
    RED_COUNTRY ("Red Country"),
    BLUE_COUNTRY("Blue Country"),
    BLACK_COUNTRY ("Black Country"),
    GREEN_COUNTRY ("Green Country"),
    YELLOW_COUNTRY ("Yellow Country"),
    NO_COUNTRY ("No Country");

    private final String name;

    CountryEnum(String name) {
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
