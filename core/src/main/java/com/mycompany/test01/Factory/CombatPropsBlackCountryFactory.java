package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Interface.CombatPropsFactoryInterface;

public class CombatPropsBlackCountryFactory implements CombatPropsFactoryInterface {
    private int MANPOWER_MAX = 1000;
    private int MANPOWER_MEDIUM = 400;
    private int MANPOWER_COMPANY = 330;
    private int MANPOWER_LOW = 200;

    private int MORALE_MEDIUM = 6;
    private int MORALE_ELITE = 8;

    private int SOFT_ATTACK_ELITE = 14;
    private int SOFT_ATTACK_MEDIUM = 10;
    private int SOFT_ATTACK_LOW = 6;
    private int SOFT_ATTACK_NON_COMBAT = 0;

    private int HARD_ATTACK_ELITE = 16;
    private int HARD_ATTACK_MEDIUM = 12;
    private int HARD_ATTACK_LOW = 7;
    private int HARD_ATTACK_NON_COMBAT = 0;


    private int AIR_ATTACK_ELITE = 12;
    private int AIR_ATTACK_MEDIUM = 8;
    private int AIR_ATTACK_LOW = 4;
    private int AIR_ATTACK_NON_COMBAT = 0;


    private int SOFT_DEFENSE_ELITE = 12;
    private int SOFT_DEFENSE_MEDIUM = 8;
    private int SOFT_DEFENSE_LOW = 4;
    private int SOFT_DEFENSE_NON_COMBAT = 3;


    private int HARD_DEFENSE_ELITE = 14;
    private int HARD_DEFENSE_MEDIUM = 10;
    private int HARD_DEFENSE_LOW = 4;
    private int HARD_DEFENSE_NON_COMBAT = 2;


    private int AIR_DEFENSE_ELITE = 12;
    private int AIR_DEFENSE_MEDIUM = 8;
    private int AIR_DEFENSE_LOW = 4;
    private int AIR_DEFENSE_NON_COMBAT = 0;

    private int SPEED_FOOT_ELITE = 8;
    private int SPEED_FOOT_MEDIUM = 6;
    private int SPEED_FOOT_LOW = 4;

    private int SPEED_MOTO_ELITE = 12;
    private int SPEED_MOTO_MEDIUM = 10;
    private int SPEED_MOTO_LOW = 8;

    private int SPEED_MECA_ELITE = 14;
    private int SPEED_MECA_MEDIUM = 12;
    private int SPEED_MECA_LOW = 10;

    @Override
    public CombatProps getArtiLowCombatProps() {
        return new CombatProps(
            MORALE_MEDIUM,
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
        return null;
    }

    @Override
    public CombatProps getArtiEliteCombatProps() {
        return null;
    }



    @Override
    public CombatProps getMecaArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMortarArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMortarArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMortarArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMortarArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoMortarArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoMortarArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoMortarArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoMortarArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoRocketArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoRocketArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoRocketArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoRocketArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaMortarArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaMortarArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaMortarArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaMortarArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getRocketArtiLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getRocketArtiMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getRocketArtiHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getRocketArtiEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiAirLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiAirMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiAirHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiAirEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiTankLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiTankMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiTankHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAntiTankEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAssaultGunLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAssaultGunMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAssaultGunHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getAssaultGunEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBicycleInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBicycleInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBicycleInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBicycleInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCavalryLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCavalryInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCavalryInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCavalryInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getEngineerInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getEngineerInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getEngineerInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getGliderInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getGliderInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getGliderInfInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getGliderInfInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyAntiAirLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyAntiAirMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyAntiAirHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyAntiAirEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyTankLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyTankMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyTankHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getHeavyTankEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryRecoCompLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryRecoCompMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryRecoCompHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryRecoCompEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getInfantryEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMachineGunLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMachineGunMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMachineGunHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMachineGunEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMarineInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMarineInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMarineInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMarineInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaRecoLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaRecoMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaRecoHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMecaRecoEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiAirLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiAirMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiAirHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiAirEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiTankLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiTankMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiTankHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoAntiTankEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoEngineerInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoEngineerInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoEngineerInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoHeavyAntiAirLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoHeavyAntiAirMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoHeavyAntiAirHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoHeavyAntiAirEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfRecoCompLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfRecoCompMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfRecoCompHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfRecoCompEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotorcyleInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotorcyleInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotorcyleInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotorcyleInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainInfantryLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainInfantryMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainInfantryHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMountainInfantryEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaInfLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaInfMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaInfHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getParaInfEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiInfantryLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiInfantryMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiInfantryHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiInfantryEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiMachineGunLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiMachineGunMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiMachineGunHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getSkiMachineGunEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getTankLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getTankMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getTankHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getTankEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBridgeEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBridgeEngineerMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBridgeEngineerHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBridgeEngineerEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCivilEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCivilEngineerMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCivilEngineerHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getCivilEngineerEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getLogisticLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getLogisticMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getLogisticHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getLogisticEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoBridgeEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoBridgeEngineerMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoBridgeEngineerHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoBridgeEngineerEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoCivilEngineerLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoCivilEngineerMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoCivilEngineerHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getMotoCivilEngineerEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyGroupLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyGroupMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyGroupHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getArmyGroupEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBrigadeLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBrigadeMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBrigadeHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getBrigadeEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getDivisionLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getDivisionMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getDivisionHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getDivisionEliteCombatProps() {
        return null;
    }

    @Override
    public CombatProps getFrontLowCombatProps() {
        return null;
    }

    @Override
    public CombatProps getFrontMediumCombatProps() {
        return null;
    }

    @Override
    public CombatProps getFrontHighCombatProps() {
        return null;
    }

    @Override
    public CombatProps getFrontEliteCombatProps() {
        return null;
    }
}
