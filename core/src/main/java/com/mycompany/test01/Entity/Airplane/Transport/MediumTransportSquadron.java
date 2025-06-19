package com.mycompany.test01.Entity.Airplane.Transport;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.TransportSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class MediumTransportSquadron extends TransportSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_TRANSPORT;

    public MediumTransportSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public MediumTransportSquadron(AirplaneProps airplaneProps, TransportProps transportProps) {
        super(airplaneProps, transportProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
