package com.mycompany.test01.Entity.Airplane.Bomber;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class HeavyBomberSquadron extends BomberSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_BOMBER;

    public HeavyBomberSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public HeavyBomberSquadron(AirplaneProps airplaneProps, BomberProps bomberProps) {
        super(airplaneProps, bomberProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
