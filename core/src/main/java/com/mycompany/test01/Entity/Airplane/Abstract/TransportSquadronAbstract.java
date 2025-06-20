package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public abstract class TransportSquadronAbstract extends AirplaneSquadronAbstract {

    private TransportProps transportProps;

    public TransportSquadronAbstract() {
        super();
    }

    public TransportSquadronAbstract(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        AirplaneProps airplaneProps,
        TransportProps transportProps) {
        super(name, acronym, country, planeType, airplaneProps);
        this.transportProps = transportProps;
    }

    public TransportProps getTransportProps() {
        return transportProps;
    }

    public void setTransportProps(TransportProps transportProps) {
        this.transportProps = transportProps;
    }
}
