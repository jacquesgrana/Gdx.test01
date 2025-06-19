package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;

public abstract class BomberSquadronAbstract extends AirplaneSquadronAbstract {

    private BomberProps bomberProps;

    public BomberSquadronAbstract() {
        super();
    }

    public BomberSquadronAbstract(AirplaneProps airplaneProps, BomberProps bomberProps) {
        super(airplaneProps);
        this.bomberProps = bomberProps;
    }

    public BomberProps getBomberProps() {
        return bomberProps;
    }

    public void setBomberProps(BomberProps bomberProps) {
        this.bomberProps = bomberProps;
    }
}
