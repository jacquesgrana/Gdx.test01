package com.mycompany.test01.Enum;

public enum AirplaneTypeEnum {
    LIGHT_FIGHTER ("Light Fighter"),
    MEDIUM_FIGHTER ("Medium Fighter"),
    HEAVY_FIGHTER ("Heavy Fighter"),

    MEDIUM_BOMBER ("Medium Bomber"),
    HEAVY_BOMBER ("Heavy Bomber"),

    LIGHT_OBSERVER ("Light Observer"),
    MEDIUM_OBSERVER ("Medium Observer"),

    MEDIUM_TRANSPORT ("Medium Transport"),
    HEAVY_TRANSPORT ("Heavy Transport"),

    NO_TYPE ("No Type");

    private final String name;

    AirplaneTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
