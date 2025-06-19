package com.mycompany.test01.Entity.Airplane.Transport;

import com.mycompany.test01.Entity.Airplane.Abstract.TransportSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class HeavyTransportSquadron extends TransportSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_TRANSPORT;

    public HeavyTransportSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public HeavyTransportSquadron(AirplaneProps airplaneProps, TransportProps transportProps) {
        super(airplaneProps, transportProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
