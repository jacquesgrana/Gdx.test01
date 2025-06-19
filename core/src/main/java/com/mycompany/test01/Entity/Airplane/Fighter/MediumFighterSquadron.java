package com.mycompany.test01.Entity.Airplane.Fighter;

import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class MediumFighterSquadron extends FighterSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_FIGHTER;

    public MediumFighterSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public MediumFighterSquadron(AirplaneProps airplaneProps) {
        super(airplaneProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
