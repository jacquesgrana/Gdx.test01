package com.mycompany.test01.Enum;

public enum UnitTypeEnum {
    FRONT_HQ ("Front Head Quarter"),
    ARMY_GROUP_HQ ("Army Group Head Quarter"),
    ARMY_HQ ("Army Head Quarter"),
    DIVISION_HQ ("Division Head Quarter"),
    BRIGADE_HQ ("Brigade Head Quarter"),

    ARTI ("Artillery"),
    ANTI_TANK ("Anti Tank"),
    ANTI_AIR ("Anti Air"),

    INFANTRY ("Infantry"),
    CAVALRY ("Cavalry"),
    ENGINEER ("Engineer"),
    CIVIL_ENGINEER ("Civil Engineer"),
    PARA ("Para troop"),
    MARINE ("Marine troop"),
    LOGISTIC ("Logistic"),

    TANK ("Tank"),
    MECHANISED_INF ("Mechanised Infantry"),
    MOTORISED_INF ("Motorised Infantry"),
    ASSAULT_GUN ("Assault Gun"),
    MECHANISED_RECO ("Mechanised Reco"),
    MECHANISED_ENGINEER ("Mechanised Engineer"),
    MOTORISED_ENGINEER ("Motorised Engineer"),
    MOTORISED_LOGISTIC ("Motorised Logistic"),
    MECHANISED_ARTI ("Mechanised Artillery"),
    MOTORISED_ARTI ("Motorised Artillery"),
    MOTORISED_ANTI_TANK ("Motorised Anti Tank"),
    MOTORISED_ANTI_AIR ("Motorised Anti Air"),

    INFANTRY_RECO_COMPANY ("Infantry Reco Company"),

    NO_TYPE("No Type");

    private final String name;

    UnitTypeEnum(String name) {
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
