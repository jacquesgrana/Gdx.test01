package com.mycompany.test01.Factory.BomberProps;

import com.mycompany.test01.Entity.Airplane.Props.BomberProps;
import com.mycompany.test01.Interface.BomberPropsFactoryInterface;

public class BomberPropsYellowCountryFactory implements BomberPropsFactoryInterface {

    private final int BOMB_ATTACK_LOW = 2;
    private final int BOMB_ATTACK_MEDIUM = 3;
    private final int BOMB_ATTACK_HIGH = 5;

    private final int ACCURACY_LOW = 2;
    private final int ACCURACY_MEDIUM = 4;
    private final int ACCURACY_HIGH = 6;

    @Override
    public BomberProps getLightBomberLow() {
        return new BomberProps(
          BOMB_ATTACK_LOW,
            ACCURACY_LOW
        );
    }

    @Override
    public BomberProps getLightBomberMedium() {
        return new BomberProps(
            BOMB_ATTACK_LOW + 1,
            ACCURACY_MEDIUM
        );
    }

    @Override
    public BomberProps getLightBomberHigh() {
        return new BomberProps(
            BOMB_ATTACK_MEDIUM,
            ACCURACY_HIGH
        );
    }


    @Override
    public BomberProps getMediumBomberLow() {
        return new BomberProps(
            BOMB_ATTACK_MEDIUM - 1,
            ACCURACY_LOW
        );
    }

    @Override
    public BomberProps getMediumBomberMedium() {
        return new BomberProps(
            BOMB_ATTACK_MEDIUM,
            ACCURACY_MEDIUM
        );
    }

    @Override
    public BomberProps getMediumBomberHigh() {
        return new BomberProps(
            BOMB_ATTACK_HIGH - 1,
            ACCURACY_HIGH
        );
    }


    @Override
    public BomberProps getHeavyBomberLow() {
        return new BomberProps(
            BOMB_ATTACK_MEDIUM,
            ACCURACY_LOW
        );
    }

    @Override
    public BomberProps getHeavyBomberMedium() {
        return new BomberProps(
            BOMB_ATTACK_MEDIUM + 1,
            ACCURACY_LOW
        );
    }

    @Override
    public BomberProps getHeavyBomberHigh() {
        return new BomberProps(
            BOMB_ATTACK_HIGH,
            ACCURACY_LOW
        );
    }
}
