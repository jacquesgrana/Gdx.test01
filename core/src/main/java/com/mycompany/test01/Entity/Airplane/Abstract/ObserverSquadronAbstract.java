package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public abstract class ObserverSquadronAbstract extends AirplaneSquadronAbstract {

    private ObserverProps observerProps;

    public ObserverSquadronAbstract() {
        super();
    }

    public ObserverSquadronAbstract(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        AirplaneProps airplaneProps,
        ObserverProps observerProps) {
        super(name, acronym, country, planeType, airplaneProps);
        this.observerProps = observerProps;
    }

    public ObserverProps getObserverProps() {
        return observerProps;
    }

    public void setObserverProps(ObserverProps observerProps) {
        this.observerProps = observerProps;
    }
}
