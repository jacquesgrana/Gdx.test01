package com.mycompany.test01.Factory.ObserverProps;

import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;
import com.mycompany.test01.Interface.ObserverPropsFactoryInterface;

public class ObserverPropsBrownCountryFactory implements ObserverPropsFactoryInterface {

    private final int VISION_RANGE_LOW = 5;
    private final int VISION_RANGE_MEDIUM = 7;
    private final int VISION_RANGE_HIGH = 10;

    private final int VISION_ACCURACY_LOW = 6;
    private final int VISION_ACCURACY_MEDIUM = 8;
    private final int VISION_ACCURACY_HIGH = 12;

    @Override
    public ObserverProps getLightObserverLow() {
        return new ObserverProps(
            VISION_RANGE_LOW,
            VISION_ACCURACY_LOW
        );
    }

    @Override
    public ObserverProps getLightObserverMedium() {
        return new ObserverProps(
            VISION_RANGE_LOW + 1,
            VISION_ACCURACY_MEDIUM
        );
    }

    @Override
    public ObserverProps getLightObserverHigh() {
        return new ObserverProps(
            VISION_RANGE_MEDIUM,
            VISION_ACCURACY_HIGH
        );
    }

    @Override
    public ObserverProps getMediumObserverLow() {
        return new ObserverProps(
            VISION_RANGE_MEDIUM,
            VISION_ACCURACY_LOW
        );
    }

    @Override
    public ObserverProps getMediumObserverMedium() {
        return new ObserverProps(
            VISION_RANGE_HIGH - 1,
            VISION_ACCURACY_MEDIUM
        );
    }

    @Override
    public ObserverProps getMediumObserverHigh() {
        return new ObserverProps(
            VISION_RANGE_HIGH,
            VISION_ACCURACY_HIGH
        );
    }
}
