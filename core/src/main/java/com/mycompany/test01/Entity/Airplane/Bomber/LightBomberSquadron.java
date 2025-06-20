package com.mycompany.test01.Entity.Airplane.Bomber;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class LightBomberSquadron extends BomberSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.LIGHT_BOMBER;

    public LightBomberSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public LightBomberSquadron(AirplaneProps airplaneProps, BomberProps bomberProps) {
        super(airplaneProps, bomberProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
