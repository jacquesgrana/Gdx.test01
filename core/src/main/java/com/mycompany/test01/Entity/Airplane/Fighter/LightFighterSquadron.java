package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class LightFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.LIGHT_FIGHTER;

    public LightFighterSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public LightFighterSquadron(AirplaneProps airplaneProps) {
        super(airplaneProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
