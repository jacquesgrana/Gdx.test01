package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public abstract class FighterSquadronAbstract extends AirplaneSquadronAbstract {


    public FighterSquadronAbstract() {
        super();
    }

    public FighterSquadronAbstract(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        AirplaneProps airplaneProps
    ) {
        super(name, acronym, country, planeType, airplaneProps);
    }
}
