package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Airplane.Props.ObserverProps;

public interface ObserverPropsFactoryInterface {

    public ObserverProps getLightObserverLow();
    public ObserverProps getLightObserverMedium();
    public ObserverProps getLightObserverHigh();

    public ObserverProps getMediumObserverLow();
    public ObserverProps getMediumObserverMedium();
    public ObserverProps getMediumObserverHigh();

}
