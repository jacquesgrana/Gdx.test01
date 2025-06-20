package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public abstract class BomberSquadronAbstract extends AirplaneSquadronAbstract {

    private BomberProps bomberProps;

    public BomberSquadronAbstract() {
        super();
    }

    public BomberSquadronAbstract(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        AirplaneProps airplaneProps,
        BomberProps bomberProps
    ) {
        super(name, acronym, country, planeType, airplaneProps);
        this.bomberProps = bomberProps;
    }

    public BomberProps getBomberProps() {
        return bomberProps;
    }

    public void setBomberProps(BomberProps bomberProps) {
        this.bomberProps = bomberProps;
    }
}
