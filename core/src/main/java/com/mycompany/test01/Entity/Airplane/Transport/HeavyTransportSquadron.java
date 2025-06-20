package com.mycompany.test01.Entity.Airplane.Transport;

import com.mycompany.test01.Entity.Airplane.Abstract.TransportSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class HeavyTransportSquadron extends TransportSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.HEAVY_TRANSPORT;

    public HeavyTransportSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public HeavyTransportSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps,
        TransportProps transportProps) {
        super(name, acronym, country, AirplaneTypeEnum.HEAVY_TRANSPORT, airplaneProps, transportProps);
        //this.setPlaneType(airplaneType);
    }
}
