package com.mycompany.test01.Entity.Airplane.Observer;

import com.mycompany.test01.Entity.Airplane.Abstract.ObserverSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class MediumObserverSquadron extends ObserverSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.MEDIUM_OBSERVER;

    public MediumObserverSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public MediumObserverSquadron(AirplaneProps airplaneProps, ObserverProps observerProps) {
        super(airplaneProps, observerProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
