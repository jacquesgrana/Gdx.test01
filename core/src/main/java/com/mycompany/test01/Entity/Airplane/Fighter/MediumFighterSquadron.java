package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class MediumFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_FIGHTER;

    public MediumFighterSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public MediumFighterSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps
    ) {
        super(name, acronym, country, AirplaneTypeEnum.MEDIUM_FIGHTER, airplaneProps);
        //this.setPlaneType(airplaneType);
    }
}
