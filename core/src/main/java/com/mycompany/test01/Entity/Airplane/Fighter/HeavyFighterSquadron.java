package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class HeavyFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_FIGHTER;

    public HeavyFighterSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public HeavyFighterSquadron(AirplaneProps airplaneProps) {
        super(airplaneProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
