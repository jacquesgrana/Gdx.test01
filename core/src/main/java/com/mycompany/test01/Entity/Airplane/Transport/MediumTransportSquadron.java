package com.mycompany.test01.Entity.Airplane.Transport;

import com.mycompany.test01.Entity.Airplane.Abstract.BomberSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Abstract.TransportSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class MediumTransportSquadron extends TransportSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_TRANSPORT;

    public MediumTransportSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public MediumTransportSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps,
        TransportProps transportProps) {
        super(name, acronym, country, AirplaneTypeEnum.MEDIUM_TRANSPORT, airplaneProps, transportProps);
        //this.setPlaneType(airplaneType);
    }
}
