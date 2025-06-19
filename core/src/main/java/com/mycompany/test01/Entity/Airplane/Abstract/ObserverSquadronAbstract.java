package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;

public abstract class ObserverSquadronAbstract extends AirplaneSquadronAbstract {

    private ObserverProps observerProps;

    public ObserverSquadronAbstract() {
        super();
    }

    public ObserverSquadronAbstract(AirplaneProps airplaneProps, ObserverProps observerProps) {
        super(airplaneProps);
        this.observerProps = observerProps;
    }

    public ObserverProps getObserverProps() {
        return observerProps;
    }

    public void setObserverProps(ObserverProps observerProps) {
        this.observerProps = observerProps;
    }
}
