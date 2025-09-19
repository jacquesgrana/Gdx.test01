package com.mycompany.test01.Factory.CombatProps;

import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Interface.unit.CombatPropsFactoryInterface;

public class CombatPropsGreenCountryFactory implements CombatPropsFactoryInterface {
    private final int MANPOWER_MAX = 1000;
    private final int MANPOWER_MEDIUM = 400;
    private final int MANPOWER_COMPANY = 330;
    private final int MANPOWER_LOW = 200;

    private final int MORALE_LOW = 5;
    private final int MORALE_MEDIUM = 6;
    private final int MORALE_HIGH = 7;
    private final int MORALE_ELITE = 9;

    private final int SOFT_ATTACK_ELITE = 12;
    private final int SOFT_ATTACK_MEDIUM = 9;
    private final int SOFT_ATTACK_LOW = 5;
    private final int SOFT_ATTACK_NON_COMBAT = 0;

    private final int HARD_ATTACK_ELITE = 12;
    private final int HARD_ATTACK_MEDIUM = 9;
    private final int HARD_ATTACK_LOW = 5;
    private final int HARD_ATTACK_NON_COMBAT = 0;


    private final int AIR_ATTACK_ELITE = 13;
    private final int AIR_ATTACK_MEDIUM = 9;
    private final int AIR_ATTACK_LOW = 5;
    private final int AIR_ATTACK_NON_COMBAT = 0;

    private final int SOFT_DEFENSE_ELITE = 12;
    private final int SOFT_DEFENSE_MEDIUM = 9;
    private final int SOFT_DEFENSE_LOW = 5;
    private final int SOFT_DEFENSE_NON_COMBAT = 3;

    private final int HARD_DEFENSE_ELITE = 13;
    private final int HARD_DEFENSE_MEDIUM = 9;
    private final int HARD_DEFENSE_LOW = 5;
    private final int HARD_DEFENSE_NON_COMBAT = 2;

    private final int AIR_DEFENSE_ELITE = 13;
    private final int AIR_DEFENSE_MEDIUM = 9;
    private final int AIR_DEFENSE_LOW = 5;
    private final int AIR_DEFENSE_NON_COMBAT = 0;

    private final int SPEED_FOOT_ELITE = 9;
    private final int SPEED_FOOT_MEDIUM = 7;
    private final int SPEED_FOOT_LOW = 5;

    private final int SPEED_MOTO_ELITE = 14;
    private final int SPEED_MOTO_MEDIUM = 12;
    private final int SPEED_MOTO_LOW = 9;

    private final int SPEED_MECA_ELITE = 15;
    private final int SPEED_MECA_MEDIUM = 12;
    private final int SPEED_MECA_LOW = 10;

    private final int SPEED_BICYCLE_ELITE = 10;
    private final int SPEED_BICYCLE_MEDIUM = 8;
    private final int SPEED_BICYCLE_LOW = 7;

    private final int SPEED_MOTORCYCLE_ELITE = 16;
    private final int SPEED_MOTORCYCLE_MEDIUM = 13;
    private final int SPEED_MOTORCYCLE_LOW = 11;

    private final int SPEED_CAV_ELITE = 13;
    private final int SPEED_CAV_MEDIUM = 11;
    private final int SPEED_CAV_LOW = 10;


    @Override
    public CombatProps getArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }



    @Override
    public CombatProps getMecaArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_LOW,
            false
        );
    }

    @Override
    public CombatProps getMecaArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMecaArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMecaArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_MEDIUM,
            SPEED_MECA_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMortarArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMortarArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMortarArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMortarArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMotoArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            false
        );
    }

    @Override
    public CombatProps getMotoArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMotoMortarArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            false
        );
    }

    @Override
    public CombatProps getMotoMortarArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoMortarArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoMortarArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMotoRocketArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            false
        );
    }

    @Override
    public CombatProps getMotoRocketArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoRocketArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoRocketArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMountainArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMountainArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMountainArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMountainArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaMortarArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaMortarArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaMortarArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getParaMortarArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }

    @Override
    public CombatProps getRocketArtiLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getRocketArtiMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getRocketArtiHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getRocketArtiEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }





    @Override
    public CombatProps getAntiAirLowCombatProps() {
        return new CombatProps(
          MORALE_LOW,
          MANPOWER_MEDIUM,
          SOFT_ATTACK_LOW,
          HARD_ATTACK_LOW,
          AIR_ATTACK_LOW,
          SOFT_DEFENSE_LOW,
          HARD_DEFENSE_LOW,
          AIR_DEFENSE_MEDIUM,
          SPEED_FOOT_MEDIUM,
          true
        );
    }

    @Override
    public CombatProps getAntiAirMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_MEDIUM,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiAirHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiAirEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiTankLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiTankMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiTankHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAntiTankEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getAssaultGunLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_LOW,
            true
        );
    }

    @Override
    public CombatProps getAssaultGunMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getAssaultGunHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_LOW,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getAssaultGunEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_LOW,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getBicycleInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_BICYCLE_LOW,
            true
        );
    }

    @Override
    public CombatProps getBicycleInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_BICYCLE_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getBicycleInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_BICYCLE_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getBicycleInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_BICYCLE_ELITE,
            true
        );
    }

    @Override
    public CombatProps getCavalryInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_CAV_LOW,
            true
        );
    }

    @Override
    public CombatProps getCavalryInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_CAV_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getCavalryInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_CAV_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getCavalryInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_CAV_ELITE,
            true
        );
    }

    @Override
    public CombatProps getEngineerInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW,
            true
        );
    }

    @Override
    public CombatProps getEngineerInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getEngineerInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getEngineerInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getGliderInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW,
            true
        );
    }

    @Override
    public CombatProps getGliderInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getGliderInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getGliderInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getHeavyAntiAirLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM + 1,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getHeavyAntiAirMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_MEDIUM,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM + 2,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getHeavyAntiAirHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE + 1,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getHeavyAntiAirEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE + 2,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getHeavyTankLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM + 1,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM + 1,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_LOW,
            true
        );
    }

    @Override
    public CombatProps getHeavyTankMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM + 2,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM + 2,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getHeavyTankHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE + 1,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE + 1,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getHeavyTankEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM + 1,
            HARD_ATTACK_ELITE + 2,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM + 1,
            HARD_DEFENSE_ELITE + 2,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getInfantryRecoCompLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_COMPANY,
            SOFT_ATTACK_LOW / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_LOW / 3,
            HARD_DEFENSE_LOW / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_FOOT_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getInfantryRecoCompMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_COMPANY,
            SOFT_ATTACK_MEDIUM / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_MEDIUM / 3,
            HARD_DEFENSE_LOW / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getInfantryRecoCompHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_COMPANY,
            SOFT_ATTACK_MEDIUM / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_MEDIUM / 3,
            HARD_DEFENSE_MEDIUM / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_FOOT_MEDIUM + 2,
            true
        );
    }

    @Override
    public CombatProps getInfantryRecoCompEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_COMPANY,
            SOFT_ATTACK_ELITE / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_ELITE / 3,
            HARD_DEFENSE_MEDIUM / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_FOOT_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getInfantryLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW,
            true
        );
    }

    @Override
    public CombatProps getInfantryMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getInfantryHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getInfantryEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMachineGunLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW + 2,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW - 1,
            true
        );
    }

    @Override
    public CombatProps getMachineGunMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM + 2,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM - 1,
            true
        );
    }

    @Override
    public CombatProps getMachineGunHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM + 2,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM - 1,
            true
        );
    }

    @Override
    public CombatProps getMachineGunEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE + 2,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE - 1,
            true
        );
    }

    @Override
    public CombatProps getMarineInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW,
            true
        );
    }

    @Override
    public CombatProps getMarineInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMarineInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMarineInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMecaInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MECA_LOW,
            true
        );
    }

    @Override
    public CombatProps getMecaInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMecaInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMecaInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMecaRecoLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MECA_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getMecaRecoMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getMecaRecoHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getMecaRecoEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MECA_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiAirLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM,
            SPEED_MOTO_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiAirMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_MEDIUM,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiAirHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiAirEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE,
            SPEED_MOTO_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiTankLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiTankMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiTankHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoAntiTankEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMotoEngineerInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotoEngineerInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoEngineerInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoEngineerInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMotoHeavyAntiAirLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM + 1,
            SPEED_MOTO_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotoHeavyAntiAirMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_MEDIUM,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_MEDIUM + 2,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoHeavyAntiAirHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE + 1,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoHeavyAntiAirEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_ELITE,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_ELITE + 2,
            SPEED_MOTO_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMotoInfRecoCompLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_COMPANY,
            SOFT_ATTACK_LOW / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_LOW / 3,
            HARD_DEFENSE_LOW / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_MOTO_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getMotoInfRecoCompMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_COMPANY,
            SOFT_ATTACK_MEDIUM / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_MEDIUM / 3,
            HARD_DEFENSE_LOW / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_MOTO_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getMotoInfRecoCompHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_COMPANY,
            SOFT_ATTACK_MEDIUM / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_MEDIUM / 3,
            HARD_DEFENSE_MEDIUM / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_MOTO_MEDIUM + 2,
            true
        );
    }

    @Override
    public CombatProps getMotoInfRecoCompEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_COMPANY,
            SOFT_ATTACK_ELITE / 3,
            HARD_ATTACK_LOW / 3,
            AIR_ATTACK_LOW / 3,
            SOFT_DEFENSE_ELITE / 3,
            HARD_DEFENSE_MEDIUM / 3,
            AIR_DEFENSE_LOW / 3,
            SPEED_MOTO_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getMotoInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotoInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotoInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTO_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMotorcyleInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTORCYCLE_LOW,
            true
        );
    }

    @Override
    public CombatProps getMotorcyleInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_MOTORCYCLE_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotorcyleInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTORCYCLE_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getMotorcyleInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_MOTORCYCLE_ELITE,
            true
        );
    }

    @Override
    public CombatProps getMountainInfantryLowCombatProps() {
        return new CombatProps(
            MORALE_LOW + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getMountainInfantryMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getMountainInfantryHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getMountainInfantryEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getParaInfLowCombatProps() {
        return new CombatProps(
            MORALE_LOW + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getParaInfMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getParaInfHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getParaInfEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE + 1,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getSkiInfantryLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW + 1,
            true
        );
    }

    @Override
    public CombatProps getSkiInfantryMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getSkiInfantryHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM + 1,
            true
        );
    }

    @Override
    public CombatProps getSkiInfantryEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE + 1,
            true
        );
    }

    @Override
    public CombatProps getSkiMachineGunLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_LOW,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_LOW + 2,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_LOW,
            true
        );
    }

    @Override
    public CombatProps getSkiMachineGunMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM + 2,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getSkiMachineGunHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM + 2,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getSkiMachineGunEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_ELITE,
            HARD_ATTACK_LOW,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_ELITE + 2,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_ELITE,
            true
        );
    }

    @Override
    public CombatProps getTankLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_LOW,
            true
        );
    }

    @Override
    public CombatProps getTankMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_MEDIUM,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_MEDIUM,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_MEDIUM,
            true
        );
    }

    @Override
    public CombatProps getTankHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getTankEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MEDIUM,
            SOFT_ATTACK_MEDIUM,
            HARD_ATTACK_ELITE,
            AIR_ATTACK_LOW,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_ELITE,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MECA_ELITE,
            true
        );
    }

    @Override
    public CombatProps getBridgeEngineerLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_LOW,
            false
        );
    }

    @Override
    public CombatProps getBridgeEngineerMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getBridgeEngineerHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getBridgeEngineerEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }

    @Override
    public CombatProps getCivilEngineerLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_LOW,
            false
        );
    }

    @Override
    public CombatProps getCivilEngineerMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getCivilEngineerHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getCivilEngineerEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }

    @Override
    public CombatProps getLogisticLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_LOW,
            false
        );
    }

    @Override
    public CombatProps getLogisticMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getLogisticHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getLogisticEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMotoBridgeEngineerLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            false
        );
    }

    @Override
    public CombatProps getMotoBridgeEngineerMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoBridgeEngineerHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoBridgeEngineerEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            false
        );
    }

    @Override
    public CombatProps getMotoCivilEngineerLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_LOW,
            false
        );
    }

    @Override
    public CombatProps getMotoCivilEngineerMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoCivilEngineerHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getMotoCivilEngineerEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_NON_COMBAT,
            HARD_DEFENSE_NON_COMBAT,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_MOTO_ELITE,
            false
        );
    }

    @Override
    public CombatProps getHeadQuarterLowCombatProps() {
        return new CombatProps(
            MORALE_LOW,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_NON_COMBAT,
            SPEED_FOOT_LOW,
            false
        );
    }

    @Override
    public CombatProps getHeadQuarterMediumCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_LOW + 1,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getHeadQuarterHighCombatProps() {
        return new CombatProps(
            MORALE_HIGH,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM,
            HARD_DEFENSE_LOW,
            AIR_DEFENSE_LOW,
            SPEED_FOOT_MEDIUM,
            false
        );
    }

    @Override
    public CombatProps getHeadQuarterEliteCombatProps() {
        return new CombatProps(
            MORALE_ELITE,
            MANPOWER_MAX,
            SOFT_ATTACK_NON_COMBAT,
            HARD_ATTACK_NON_COMBAT,
            AIR_ATTACK_NON_COMBAT,
            SOFT_DEFENSE_MEDIUM + 1,
            HARD_DEFENSE_LOW + 1,
            AIR_DEFENSE_LOW + 1,
            SPEED_FOOT_MEDIUM,
            false
        );
    }
}
