package com.mycompany.test01.Interface.airplane;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;

public interface AirplanePropsFactoryInterface {

    public AirplaneProps getLightFighterLow();
    public AirplaneProps getLightFighterMedium();
    public AirplaneProps getLightFighterHigh();

    public AirplaneProps getMediumFighterLow();
    public AirplaneProps getMediumFighterMedium();
    public AirplaneProps getMediumFighterHigh();

    public AirplaneProps getHeavyFighterLow();
    public AirplaneProps getHeavyFighterMedium();
    public AirplaneProps getHeavyFighterHigh();


    public AirplaneProps getLightBomberLow();
    public AirplaneProps getLightBomberMedium();
    public AirplaneProps getLightBomberHigh();

    public AirplaneProps getMediumBomberLow();
    public AirplaneProps getMediumBomberMedium();
    public AirplaneProps getMediumBomberHigh();

    public AirplaneProps getHeavyBomberLow();
    public AirplaneProps getHeavyBomberMedium();
    public AirplaneProps getHeavyBomberHigh();


    public AirplaneProps getLightObserverLow();
    public AirplaneProps getLightObserverMedium();
    public AirplaneProps getLightObserverHigh();

    public AirplaneProps getMediumObserverLow();
    public AirplaneProps getMediumObserverMedium();
    public AirplaneProps getMediumObserverHigh();


    public AirplaneProps getMediumTransportLow();
    public AirplaneProps getMediumTransportMedium();
    public AirplaneProps getMediumTransportHigh();

    public AirplaneProps getHeavyTransportLow();
    public AirplaneProps getHeavyTransportMedium();
    public AirplaneProps getHeavyTransportHigh();
}
