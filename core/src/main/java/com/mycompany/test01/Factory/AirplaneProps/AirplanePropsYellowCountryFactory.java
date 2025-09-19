package com.mycompany.test01.Factory.AirplaneProps;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Interface.airplane.AirplanePropsFactoryInterface;

public class AirplanePropsYellowCountryFactory implements AirplanePropsFactoryInterface {

    private final int PLANE_COUNT_LOW = 12;
    private final int PLANE_COUNT_MEDIUM = 24;
    private final int PLANE_COUNT_HIGH = 36;

    private final int AIR_DEFENSE_LOW = 3;
    private final int AIR_DEFENSE_MEDIUM = 6;
    private final int AIR_DEFENSE_HIGH = 10;

    private final int AIR_ATTACK_LOW = 5;
    private final int AIR_ATTACK_MEDIUM = 7;
    private final int AIR_ATTACK_HIGH = 12;

    private final int MORAL_LOW = 4;
    private final int MORAL_MEDIUM = 5;
    private final int MORAL_HIGH = 7;

    private final int AGILITY_LOW = 3;
    private final int AGILITY_MEDIUM = 6;
    private final int AGILITY_HIGH = 9;

    private final int SPEED_LOW = 5;
    private final int SPEED_MEDIUM = 8;
    private final int SPEED_HIGH = 11;

    private final int RANGE_LOW = 5;
    private final int RANGE_MEDIUM = 7;
    private final int RANGE_HIGH = 10;

    private final int VISIBILITY_LOW = 3;
    private final int VISIBILITY_MEDIUM = 5;
    private final int VISIBILITY_HIGH = 8;


    @Override
    public AirplaneProps getLightFighterLow() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_MEDIUM - 2,
            AIR_ATTACK_MEDIUM - 2,
            MORAL_LOW,
            AGILITY_MEDIUM - 1,
            SPEED_MEDIUM,
            RANGE_LOW,
            VISIBILITY_MEDIUM + 1
        );
    }

    @Override
    public AirplaneProps getLightFighterMedium() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_MEDIUM,
            AIR_ATTACK_MEDIUM,
            MORAL_MEDIUM,
            AGILITY_MEDIUM,
            SPEED_MEDIUM + 2,
            RANGE_LOW + 1,
            VISIBILITY_MEDIUM
        );
    }

    @Override
    public AirplaneProps getLightFighterHigh() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_HIGH,
            AIR_ATTACK_HIGH,
            MORAL_HIGH,
            AGILITY_HIGH,
            SPEED_HIGH,
            RANGE_MEDIUM,
            VISIBILITY_LOW
        );
    }


    @Override
    public AirplaneProps getMediumFighterLow() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_MEDIUM - 2,
            AIR_ATTACK_MEDIUM - 2,
            MORAL_LOW,
            AGILITY_MEDIUM - 1,
            SPEED_MEDIUM,
            RANGE_MEDIUM - 1,
            VISIBILITY_MEDIUM + 1
        );
    }

    @Override
    public AirplaneProps getMediumFighterMedium() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_MEDIUM,
            AIR_ATTACK_MEDIUM,
            MORAL_MEDIUM,
            AGILITY_MEDIUM,
            SPEED_MEDIUM + 2,
            RANGE_HIGH - 1,
            VISIBILITY_MEDIUM
        );
    }

    @Override
    public AirplaneProps getMediumFighterHigh() {
        return new AirplaneProps(
            PLANE_COUNT_HIGH,
            AIR_DEFENSE_HIGH,
            AIR_ATTACK_HIGH,
            MORAL_HIGH,
            AGILITY_HIGH,
            SPEED_HIGH,
            RANGE_HIGH,
            VISIBILITY_LOW
        );
    }


    @Override
    public AirplaneProps getHeavyFighterLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_MEDIUM - 2,
            AIR_ATTACK_MEDIUM - 2,
            MORAL_LOW,
            AGILITY_LOW - 1,
            SPEED_MEDIUM,
            RANGE_HIGH - 1,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getHeavyFighterMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_MEDIUM,
            AIR_ATTACK_MEDIUM,
            MORAL_MEDIUM,
            AGILITY_LOW,
            SPEED_MEDIUM,
            RANGE_HIGH,
            VISIBILITY_HIGH
        );
    }

    @Override
    public AirplaneProps getHeavyFighterHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_HIGH,
            AIR_ATTACK_HIGH,
            MORAL_HIGH,
            AGILITY_MEDIUM,
            SPEED_MEDIUM,
            RANGE_HIGH,
            VISIBILITY_HIGH - 1
        );
    }




    @Override
    public AirplaneProps getLightBomberLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW - 1,
            AIR_ATTACK_LOW - 2,
            MORAL_LOW,
            AGILITY_MEDIUM - 1,
            SPEED_MEDIUM,
            RANGE_MEDIUM - 1,
            VISIBILITY_MEDIUM + 1
        );
    }

    @Override
    public AirplaneProps getLightBomberMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW,
            AIR_ATTACK_LOW - 1,
            MORAL_MEDIUM,
            AGILITY_MEDIUM,
            SPEED_MEDIUM + 1,
            RANGE_MEDIUM,
            VISIBILITY_MEDIUM
        );
    }

    @Override
    public AirplaneProps getLightBomberHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 1,
            AIR_ATTACK_LOW,
            MORAL_HIGH,
            AGILITY_MEDIUM + 1,
            SPEED_HIGH,
            RANGE_MEDIUM + 1,
            VISIBILITY_MEDIUM - 1
        );
    }


    @Override
    public AirplaneProps getMediumBomberLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_MEDIUM - 1,
            AIR_ATTACK_LOW - 1,
            MORAL_LOW,
            AGILITY_LOW + 1,
            SPEED_MEDIUM - 1,
            RANGE_HIGH - 1,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getMediumBomberMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_MEDIUM,
            AIR_ATTACK_LOW,
            MORAL_MEDIUM,
            AGILITY_MEDIUM,
            SPEED_MEDIUM,
            RANGE_HIGH,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getMediumBomberHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_MEDIUM + 1,
            AIR_ATTACK_LOW + 1,
            MORAL_HIGH,
            AGILITY_MEDIUM,
            SPEED_MEDIUM,
            RANGE_HIGH,
            VISIBILITY_HIGH
        );
    }


    @Override
    public AirplaneProps getHeavyBomberLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_HIGH - 1,
            AIR_ATTACK_MEDIUM - 1,
            MORAL_LOW,
            AGILITY_LOW,
            SPEED_LOW - 1,
            RANGE_HIGH - 1,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getHeavyBomberMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_HIGH,
            AIR_ATTACK_MEDIUM,
            MORAL_MEDIUM,
            AGILITY_LOW,
            SPEED_LOW,
            RANGE_HIGH,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getHeavyBomberHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_HIGH + 1,
            AIR_ATTACK_MEDIUM,
            MORAL_HIGH,
            AGILITY_LOW,
            SPEED_LOW + 1,
            RANGE_HIGH,
            VISIBILITY_HIGH
        );
    }




    @Override
    public AirplaneProps getLightObserverLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW - 1,
            AIR_ATTACK_LOW - 2,
            MORAL_LOW,
            AGILITY_MEDIUM,
            SPEED_MEDIUM,
            RANGE_MEDIUM - 1,
            VISIBILITY_LOW + 1
        );
    }

    @Override
    public AirplaneProps getLightObserverMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW,
            AIR_ATTACK_LOW - 1,
            MORAL_MEDIUM,
            AGILITY_MEDIUM + 1,
            SPEED_MEDIUM + 1,
            RANGE_MEDIUM,
            VISIBILITY_LOW
        );
    }

    @Override
    public AirplaneProps getLightObserverHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 1,
            AIR_ATTACK_LOW,
            MORAL_HIGH,
            AGILITY_HIGH,
            SPEED_HIGH,
            RANGE_MEDIUM + 1,
            VISIBILITY_LOW
        );
    }


    @Override
    public AirplaneProps getMediumObserverLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW - 1,
            AIR_ATTACK_LOW - 2,
            MORAL_LOW,
            AGILITY_MEDIUM,
            SPEED_MEDIUM,
            RANGE_HIGH - 1,
            VISIBILITY_MEDIUM + 1
        );
    }

    @Override
    public AirplaneProps getMediumObserverMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW,
            AIR_ATTACK_LOW - 1,
            MORAL_MEDIUM,
            AGILITY_MEDIUM + 1,
            SPEED_MEDIUM + 1,
            RANGE_HIGH,
            VISIBILITY_MEDIUM
        );
    }

    @Override
    public AirplaneProps getMediumObserverHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 1,
            AIR_ATTACK_LOW,
            MORAL_HIGH,
            AGILITY_MEDIUM + 1,
            SPEED_MEDIUM + 1,
            RANGE_HIGH + 1,
            VISIBILITY_MEDIUM - 1
        );
    }




    @Override
    public AirplaneProps getMediumTransportLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW - 1,
            AIR_ATTACK_LOW - 2,
            MORAL_LOW,
            AGILITY_MEDIUM,
            SPEED_LOW,
            RANGE_HIGH - 1,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getMediumTransportMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW,
            AIR_ATTACK_LOW - 1,
            MORAL_MEDIUM,
            AGILITY_MEDIUM + 1,
            SPEED_LOW + 1,
            RANGE_HIGH,
            VISIBILITY_HIGH
        );
    }

    @Override
    public AirplaneProps getMediumTransportHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 1,
            AIR_ATTACK_LOW,
            MORAL_HIGH,
            AGILITY_MEDIUM + 1,
            SPEED_LOW + 1,
            RANGE_HIGH + 1,
            VISIBILITY_HIGH - 1
        );
    }


    @Override
    public AirplaneProps getHeavyTransportLow() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW,
            AIR_ATTACK_LOW - 2,
            MORAL_LOW,
            AGILITY_MEDIUM,
            SPEED_LOW,
            RANGE_HIGH - 1,
            VISIBILITY_HIGH + 1
        );
    }

    @Override
    public AirplaneProps getHeavyTransportMedium() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 1,
            AIR_ATTACK_LOW - 1,
            MORAL_MEDIUM,
            AGILITY_MEDIUM + 1,
            SPEED_LOW + 1,
            RANGE_HIGH,
            VISIBILITY_HIGH
        );
    }

    @Override
    public AirplaneProps getHeavyTransportHigh() {
        return new AirplaneProps(
            PLANE_COUNT_LOW,
            AIR_DEFENSE_LOW + 2,
            AIR_ATTACK_LOW,
            MORAL_HIGH,
            AGILITY_MEDIUM + 1,
            SPEED_LOW + 1,
            RANGE_HIGH + 1,
            VISIBILITY_HIGH - 1
        );
    }
}
