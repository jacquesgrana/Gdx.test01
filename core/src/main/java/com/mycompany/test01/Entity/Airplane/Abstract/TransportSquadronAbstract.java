package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;

public abstract class TransportSquadronAbstract extends AirplaneSquadronAbstract {

    private TransportProps transportProps;

    public TransportSquadronAbstract() {
        super();
    }

    public TransportSquadronAbstract(AirplaneProps airplaneProps, TransportProps transportProps) {
        super(airplaneProps);
        this.transportProps = transportProps;
    }

    public TransportProps getTransportProps() {
        return transportProps;
    }

    public void setTransportProps(TransportProps transportProps) {
        this.transportProps = transportProps;
    }
}
