package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class HeavyFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_FIGHTER;

    public HeavyFighterSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public HeavyFighterSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps
    ) {
        super(name, acronym, country, AirplaneTypeEnum.HEAVY_FIGHTER, airplaneProps);
        //this.setPlaneType(airplaneType);
    }
}
