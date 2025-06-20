package com.mycompany.test01.Entity.Airplane.Bomber;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class HeavyBomberSquadron extends BomberSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_BOMBER;

    public HeavyBomberSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public HeavyBomberSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps,
        BomberProps bomberProps) {
        super(name, acronym, country, AirplaneTypeEnum.HEAVY_BOMBER, airplaneProps, bomberProps);
        //this.setPlaneType(airplaneType);
    }
}
