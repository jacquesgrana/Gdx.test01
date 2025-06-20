package com.mycompany.test01.Entity.Airplane.Bomber;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.FighterSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class MediumBomberSquadron extends BomberSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_BOMBER;

    public MediumBomberSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public MediumBomberSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps,
        BomberProps bomberProps) {
        super(name, acronym, country, AirplaneTypeEnum.MEDIUM_BOMBER, airplaneProps, bomberProps);
        //this.setPlaneType(airplaneType);
    }
}
