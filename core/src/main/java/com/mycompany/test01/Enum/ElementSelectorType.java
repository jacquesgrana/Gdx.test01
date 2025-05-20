package com.mycompany.test01.Enum;

import java.util.Objects;

public enum ElementSelectorType {

    FRONT_HQ ("Front Head Quarter", CountryEnum.NO_COUNTRY),
    ARMY_GROUP_HQ ("Army Group Head Quarter", CountryEnum.NO_COUNTRY),
    ARMY_HQ ("Army Head Quarter", CountryEnum.NO_COUNTRY),
    DIVISION_HQ ("Division Head Quarter", CountryEnum.NO_COUNTRY),
    BRIGADE_HQ ("Brigade Head Quarter", CountryEnum.NO_COUNTRY),

    ARTI ("Artillery", CountryEnum.NO_COUNTRY),
    MORTAR_ARTI ("Mortar Artillery", CountryEnum.NO_COUNTRY),
    ROCKET_ARTI ("Rocket Artillery", CountryEnum.NO_COUNTRY),
    PARA_ARTI ("Para Artillery", CountryEnum.NO_COUNTRY),
    PARA_MORTAR_ARTI ("Para Mortar Artillery", CountryEnum.NO_COUNTRY),

    ANTI_TANK ("Anti Tank", CountryEnum.NO_COUNTRY),
    ANTI_AIR ("Anti Air", CountryEnum.NO_COUNTRY),
    HEAVY_ANTI_AIR ("Heavy Anti Air", CountryEnum.NO_COUNTRY),

    INFANTRY ("Infantry", CountryEnum.NO_COUNTRY),
    CAVALRY ("Cavalry", CountryEnum.NO_COUNTRY),
    ENGINEER ("Engineer", CountryEnum.NO_COUNTRY),
    CIVIL_ENGINEER ("Civil Engineer", CountryEnum.NO_COUNTRY),
    BRIDGE_ENGINEER ("Bridge Engineer", CountryEnum.NO_COUNTRY),
    PARA_INF ("Para Infantry", CountryEnum.NO_COUNTRY),
    MARINE_INF ("Marine Infantry", CountryEnum.NO_COUNTRY),
    LOGISTIC ("Logistic", CountryEnum.NO_COUNTRY),

    TANK ("Tank", CountryEnum.NO_COUNTRY),
    HEAVY_TANK ("Heavy Tank", CountryEnum.NO_COUNTRY),
    MOUNTAIN_INF ("Mountain Infantry", CountryEnum.NO_COUNTRY),
    MOUNTAIN_ARTI ("Mountain Artillery", CountryEnum.NO_COUNTRY),
    SKI_INF ("Ski Infantry", CountryEnum.NO_COUNTRY),
    SKI_MACHINE_GUN ("Ski Machine Gun", CountryEnum.NO_COUNTRY),
    GLIDER_INF ("Glider Infantry", CountryEnum.NO_COUNTRY),
    MECHANISED_INF ("Mechanised Infantry", CountryEnum.NO_COUNTRY),
    MOTORISED_INF ("Motorised Infantry", CountryEnum.NO_COUNTRY),
    ASSAULT_GUN ("Assault Gun", CountryEnum.NO_COUNTRY),
    MECHANISED_RECO ("Mechanised Reco", CountryEnum.NO_COUNTRY),
    //MECHANISED_ENGINEER ("Mechanised Engineer", CountryEnum.NO_COUNTRY),
    MOTORISED_ENGINEER ("Motorised Engineer", CountryEnum.NO_COUNTRY),
    MOTORISED_CIVIL_ENGINEER ("Motorised Civil Engineer", CountryEnum.NO_COUNTRY),
    MOTORISED_BRIDGE_ENGINEER ("Motorised Bridge Engineer", CountryEnum.NO_COUNTRY),

    //MOTORISED_LOGISTIC ("Motorised Logistic", CountryEnum.NO_COUNTRY),
    MECHANISED_ARTI ("Mechanised Artillery", CountryEnum.NO_COUNTRY),
    MOTORISED_ARTI ("Motorised Artillery", CountryEnum.NO_COUNTRY),
    MOTORISED_MORTAR_ARTI ("Motorised Mortar Artillery", CountryEnum.NO_COUNTRY),
    MOTORISED_ROCKET_ARTI ("Motorised Rocket Artillery", CountryEnum.NO_COUNTRY),
    MOTORISED_ANTI_TANK ("Motorised Anti Tank", CountryEnum.NO_COUNTRY),
    MOTORISED_ANTI_AIR ("Motorised Anti Air", CountryEnum.NO_COUNTRY),
    MOTORISED_HEAVY_ANTI_AIR ("Motorised Heavy Anti Air", CountryEnum.NO_COUNTRY),

    MOTORCYCLE_INF ("Motorcycle Infantry", CountryEnum.NO_COUNTRY),
    BICYCLE_INF ("Bicycle Infantry", CountryEnum.NO_COUNTRY),

    INFANTRY_RECO_COMPANY ("Infantry Reco Company", CountryEnum.NO_COUNTRY),
    MOTORISED_INF_RECO_COMPANY ("Motorised Infantry Reco Company", CountryEnum.NO_COUNTRY),

    MACHINE_GUN ("Machine Gun", CountryEnum.NO_COUNTRY),

    NO_TYPE("No Type", CountryEnum.NO_COUNTRY),

    // groupes ajoutés
    GROUP_INF_DIVISION ("Generic Infantry Division", CountryEnum.NO_COUNTRY),
    GROUP_ELITE_INF_DIVISION ("Generic Elite Infantry Division", CountryEnum.NO_COUNTRY),
    GROUP_MOTORISED_INF_DIVISION ("Generic Motorised Infantry Division", CountryEnum.NO_COUNTRY),

    // groupes ajoutés spécifiques par country
    GROUP_BLACK_ELITE_MECA_BRIGADE ("Generic Elite Mechanised Brigade", CountryEnum.BLACK_COUNTRY),

    GROUP_RED_MOTORISED_INF_BRIGADE ("Generic Motorised Infantry Brigade", CountryEnum.RED_COUNTRY);



    private final String name;
    private final CountryEnum country;

    ElementSelectorType(String name, CountryEnum country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public CountryEnum getCountry() { return this.country; }

    public boolean equals(ElementSelectorType toCompare) {
        return Objects.equals(this.name, toCompare.getName()) && this.country == toCompare.country;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
