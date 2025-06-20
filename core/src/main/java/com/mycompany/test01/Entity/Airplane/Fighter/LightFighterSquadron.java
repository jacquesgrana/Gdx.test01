package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class LightFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.LIGHT_FIGHTER;

    public LightFighterSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public LightFighterSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps
    ) {
        super(name, acronym, country, AirplaneTypeEnum.LIGHT_FIGHTER, airplaneProps);
        //this.setPlaneType(airplaneType);
    }
}
