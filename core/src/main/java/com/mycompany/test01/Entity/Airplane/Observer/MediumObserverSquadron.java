package com.mycompany.test01.Entity.Airplane.Observer;

import com.mycompany.test01.Entity.Airplane.Abstract.ObserverSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class MediumObserverSquadron extends ObserverSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_OBSERVER;

    public MediumObserverSquadron() {
        super();
        this.setPlaneType(airplaneType);
    }

    public MediumObserverSquadron(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneProps airplaneProps,
        ObserverProps observerProps) {
        super(name, acronym, country, AirplaneTypeEnum.MEDIUM_OBSERVER, airplaneProps, observerProps);
        //this.setPlaneType(airplaneType);
    }
}
