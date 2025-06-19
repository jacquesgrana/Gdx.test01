package com.mycompany.test01.Entity.Airplane.Bomber;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class MediumBomberSquadron extends BomberSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_BOMBER;

    public MediumBomberSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public MediumBomberSquadron(AirplaneProps airplaneProps, BomberProps bomberProps) {
        super(airplaneProps, bomberProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
