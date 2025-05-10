package com.mycompany.test01.Enum;

public enum UnitTypeEnum {
    FRONT_HQ ("Front Head Quarter"),
    ARMY_GROUP_HQ ("Army Group Head Quarter"),
    ARMY_HQ ("Army Head Quarter"),
    DIVISION_HQ ("Division Head Quarter"),
    BRIGADE_HQ ("Brigade Head Quarter"),

    ARTI ("Artillery"),
    MORTAR_ARTI ("Mortar Artillery"),
    ROCKET_ARTI ("Rocket Artillery"),
    PARA_ARTI ("Para Artillery"),
    PARA_MORTAR_ARTI ("Para Mortar Artillery"),


    ANTI_TANK ("Anti Tank"),
    ANTI_AIR ("Anti Air"),
    HEAVY_ANTI_AIR ("Heavy Anti Air"),


    INFANTRY ("Infantry"),
    CAVALRY ("Cavalry"),
    ENGINEER ("Engineer"),
    CIVIL_ENGINEER ("Civil Engineer"),
    PARA_INF ("Para Infantry"),
    MARINE_INF ("Marine Infantry"),
    LOGISTIC ("Logistic"),

    TANK ("Tank"),
    HEAVY_TANK ("Heavy Tank"),
    MOUNTAIN_INF ("Mountain Infantry"),
    MOUNTAIN_ARTI ("Mountain Artillery"),
    SKI_INF ("Ski Infantry"),
    SKI_MACHINE_GUN ("Ski Machine Gun"),
    GLIDER_INF ("Glider Infantry"),
    MECHANISED_INF ("Mechanised Infantry"),
    MOTORISED_INF ("Motorised Infantry"),
    ASSAULT_GUN ("Assault Gun"),
    MECHANISED_RECO ("Mechanised Reco"),
    MECHANISED_ENGINEER ("Mechanised Engineer"),
    MOTORISED_ENGINEER ("Motorised Engineer"),
    MOTORISED_CIVIL_ENGINEER ("Motorised Civil Engineer"),

    MOTORISED_LOGISTIC ("Motorised Logistic"),
    MECHANISED_ARTI ("Mechanised Artillery"),
    MOTORISED_ARTI ("Motorised Artillery"),
    MOTORISED_MORTAR_ARTI ("Motorised Mortar Artillery"),
    MOTORISED_ROCKET_ARTI ("Motorised Rocket Artillery"),
    MOTORISED_ANTI_TANK ("Motorised Anti Tank"),
    MOTORISED_ANTI_AIR ("Motorised Anti Air"),
    MOTORISED_HEAVY_ANTI_AIR ("Motorised Heavy Anti Air"),

    MOTORCYCLE_INF ("Motorcycle Infantry"),
    BICYCLE_INF ("Bicycle Infantry"),

    INFANTRY_RECO_COMPANY ("Infantry Reco Company"),
    MOTORISED_INF_RECO_COMPANY ("Motorised Infantry Reco Company"),

    MACHINE_GUN ("Machine Gun"),

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
