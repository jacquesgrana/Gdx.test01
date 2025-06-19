package com.mycompany.test01.Entity.Airplane.Observer;

import com.mycompany.test01.Entity.Airplane.Abstract.ObserverSquadronAbstract;
import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;

public class LightObserverSquadron extends ObserverSquadronAbstract {

private final AirplaneTypeEnum airplaneType = AirplaneTypeEnum.LIGHT_OBSERVER;

    public LightObserverSquadron() {
        super();
        this.getAirplaneProps().setPlaneType(airplaneType);
    }

    public LightObserverSquadron(AirplaneProps airplaneProps, ObserverProps observerProps) {
        super(airplaneProps, observerProps);
        this.getAirplaneProps().setPlaneType(airplaneType);
    }
}
