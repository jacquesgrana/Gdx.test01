package com.mycompany.test01.Interface.airplane;

import com.mycompany.test01.Entity.Airplane.Props.TransportProps;

public interface TransportPropsFactoryInterface {

    public TransportProps getMediumTransportLow();
    public TransportProps getMediumTransportMedium();
    public TransportProps getMediumTransportHigh();

    public TransportProps getHeavyTransportLow();
    public TransportProps getHeavyTransportMedium();
    public TransportProps getHeavyTransportHigh();
}
