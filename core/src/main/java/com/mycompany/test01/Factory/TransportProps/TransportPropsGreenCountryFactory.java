package com.mycompany.test01.Factory.TransportProps;

import com.mycompany.test01.Entity.Airplane.Props.TransportProps;
import com.mycompany.test01.Interface.TransportPropsFactoryInterface;

public class TransportPropsGreenCountryFactory implements TransportPropsFactoryInterface {

    private final int CAPACITY_LOW = 25;
    private final int CAPACITY_MEDIUM = 40;
    private final int CAPACITY_HIGH = 90;


    @Override
    public TransportProps getMediumTransportLow() {
        return new TransportProps(
          CAPACITY_LOW
        );
    }

    @Override
    public TransportProps getMediumTransportMedium() {
        return new TransportProps(
            CAPACITY_LOW + 5
        );
    }

    @Override
    public TransportProps getMediumTransportHigh() {
        return new TransportProps(
            CAPACITY_MEDIUM
        );
    }


    @Override
    public TransportProps getHeavyTransportLow() {
        return new TransportProps(
            CAPACITY_MEDIUM
        );
    }

    @Override
    public TransportProps getHeavyTransportMedium() {
        return new TransportProps(
            CAPACITY_HIGH - 10
        );
    }

    @Override
    public TransportProps getHeavyTransportHigh() {
        return new TransportProps(
            CAPACITY_HIGH
        );
    }
}
