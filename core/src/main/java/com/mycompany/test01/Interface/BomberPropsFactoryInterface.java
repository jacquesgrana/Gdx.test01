package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Airplane.Props.BomberProps;

public interface BomberPropsFactoryInterface {

    public BomberProps getLightBomberLow();
    public BomberProps getLightBomberMedium();
    public BomberProps getLightBomberHigh();

    public BomberProps getMediumBomberLow();
    public BomberProps getMediumBomberMedium();
    public BomberProps getMediumBomberHigh();

    public BomberProps getHeavyBomberLow();
    public BomberProps getHeavyBomberMedium();
    public BomberProps getHeavyBomberHigh();
}
