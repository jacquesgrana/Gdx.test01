package com.mycompany.test01.Util;

import com.mycompany.test01.Entity.Unit.UnitElement;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.ElementSelectorType;
import com.mycompany.test01.Factory.*;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitUtil {

    public static UnitElement getNewUnitFromSelection(
        String unitName,
        String unitAcronym,
        boolean isUnitElite,
        CountryEnum unitCountry,
        ElementSelectorType unitType,
        int unitRegRank
    ) {
        UnitBlackCountryFactory unitBlackCountryFactory = new UnitBlackCountryFactory();
        UnitBlueCountryFactory unitBlueCountryFactory = new UnitBlueCountryFactory();
        UnitBrownCountryFactory unitBrownCountryFactory = new UnitBrownCountryFactory();
        UnitGreenCountryFactory unitGreenCountryFactory = new UnitGreenCountryFactory();
        UnitRedCountryFactory unitRedCountryFactory = new UnitRedCountryFactory();
        UnitYellowCountryFactory unitYellowCountryFactory = new UnitYellowCountryFactory();

        UnitFactoryInterface unitFactory= null;

        switch (unitCountry) {
            case BLACK_COUNTRY:
                unitFactory = unitBlackCountryFactory;
                break;
            case BLUE_COUNTRY:
                unitFactory = unitBlueCountryFactory;
                break;
            case BROWN_COUNTRY:
                unitFactory = unitBrownCountryFactory;
                break;
            case GREEN_COUNTRY:
                unitFactory = unitGreenCountryFactory;
                break;
            case RED_COUNTRY:
                unitFactory = unitRedCountryFactory;
                break;
            case YELLOW_COUNTRY:
                unitFactory = unitYellowCountryFactory;
                break;
            default:
                unitFactory = unitRedCountryFactory;
                break;
        }
        UnitElement toReturn = null;

        switch (unitType) {
            case FRONT_HQ:
                toReturn = unitFactory.createFrontGroup(
                    unitName,
                    unitAcronym,
                    false,
                    isUnitElite,
                    false,
                    isUnitElite);
                break;
            case ARMY_GROUP_HQ:
                toReturn = unitFactory.createArmyGroupGroup(
                    unitName,
                    unitAcronym,
                    false,
                    isUnitElite,
                    false,
                    isUnitElite);
                break;
            case ARMY_HQ:
                toReturn = unitFactory.createArmyGroup(
                    unitName,
                    unitAcronym,
                    false,
                    isUnitElite,
                    false,
                    isUnitElite);
                break;
            case DIVISION_HQ:
                toReturn = unitFactory.createDivisionGroup(
                    unitName,
                    unitAcronym,
                    false,
                    isUnitElite,
                    false,
                    isUnitElite);
                break;
            case BRIGADE_HQ:
                toReturn = unitFactory.createBrigadeGroup(
                    unitName,
                    unitAcronym,
                    false,
                    isUnitElite,
                    false,
                    isUnitElite);
                break;
            case ARTI:
                toReturn = unitFactory.createArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank);
                break;
            case MORTAR_ARTI:
                toReturn = unitFactory.createMortarArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case ROCKET_ARTI:
                toReturn = unitFactory.createRocketArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case PARA_ARTI:
                toReturn = unitFactory.createParaArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case PARA_MORTAR_ARTI:
                toReturn = unitFactory.createParaMortarArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case ANTI_TANK:
                toReturn = unitFactory.createAntiTankUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case ANTI_AIR:
                toReturn = unitFactory.createAntiAirUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case HEAVY_ANTI_AIR:
                toReturn = unitFactory.createHeavyAntiAirUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case INFANTRY:
                toReturn = unitFactory.createInfantryUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case CAVALRY:
                toReturn = unitFactory.createCavalryUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case ENGINEER:
                toReturn = unitFactory.createEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case CIVIL_ENGINEER:
                toReturn = unitFactory.createCivilEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case BRIDGE_ENGINEER:
                toReturn = unitFactory.createBridgeEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case PARA_INF:
                toReturn = unitFactory.createParaInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MARINE_INF:
                toReturn = unitFactory.createMarineInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case LOGISTIC:
                toReturn = unitFactory.createLogisticUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case TANK:
                toReturn = unitFactory.createTankUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case HEAVY_TANK:
                toReturn = unitFactory.createHeavyTankUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOUNTAIN_INF:
                toReturn = unitFactory.createMountainInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOUNTAIN_ARTI:
                toReturn = unitFactory.createMountainArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case SKI_INF:
                toReturn = unitFactory.createSkiInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case SKI_MACHINE_GUN:
                toReturn = unitFactory.createSkiMachineGunUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case GLIDER_INF:
                toReturn = unitFactory.createGliderInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MECHANISED_INF:
                toReturn = unitFactory.createMecaInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_INF:
                toReturn = unitFactory.createMotoInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case ASSAULT_GUN:
                toReturn = unitFactory.createAssaultGunUnit(
                unitName,
                unitAcronym,
                isUnitElite,
                isUnitElite,
                unitRegRank
            );
                break;
            case MECHANISED_RECO:
                toReturn = unitFactory.createMecaRecoUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_ENGINEER:
                toReturn = unitFactory.createMotoEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_CIVIL_ENGINEER:
                toReturn = unitFactory.createMotoCivilEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_BRIDGE_ENGINEER:
                toReturn = unitFactory.createMotoBridgeEngineerUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MECHANISED_ARTI:
                toReturn = unitFactory.createMecaArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_ARTI:
                toReturn = unitFactory.createMotoArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_MORTAR_ARTI:
                toReturn = unitFactory.createMotoMortarArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_ROCKET_ARTI:
                toReturn = unitFactory.createMotoRocketArtiUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_ANTI_TANK:
                toReturn = unitFactory.createMotoAntiTankUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_ANTI_AIR:
                toReturn = unitFactory.createMotoAntiAirUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_HEAVY_ANTI_AIR:
                toReturn = unitFactory.createMotoHeavyAntiAirUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORCYCLE_INF:
                toReturn = unitFactory.createMotorcycleInfUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case BICYCLE_INF:
                toReturn = unitFactory.createBicycleUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case INFANTRY_RECO_COMPANY:
                toReturn = unitFactory.createInfRecoCompanyUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MOTORISED_INF_RECO_COMPANY:
                toReturn = unitFactory.createMotoInfRecoCompanyUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case MACHINE_GUN:
                toReturn = unitFactory.createMachineGunUnit(
                    unitName,
                    unitAcronym,
                    isUnitElite,
                    isUnitElite,
                    unitRegRank
                );
                break;
            case GROUP_INF_DIVISION:
                    toReturn = unitFactory.createInfDivision(
                    unitName,
                    unitAcronym
                );
                break;
            case GROUP_ELITE_INF_DIVISION:
                    toReturn = unitFactory.createEliteInfDivision(
                        unitName,
                        unitAcronym
                    );
                break;
            case GROUP_MOTORISED_INF_DIVISION:
                toReturn = unitFactory.createMotoInfDivision(
                    unitName,
                    unitAcronym
                );
                break;
            case GROUP_RED_MOTORISED_INF_BRIGADE:
                // traitement pour GROUP_RED_MOTORISED_INF_BRIGADE
                if(unitCountry.equals(CountryEnum.RED_COUNTRY)) {
                    toReturn = unitRedCountryFactory.createMotoInfBrigade(
                        unitName,
                        unitAcronym
                    );
                }
                break;

            case NO_TYPE:
                // traitement pour NO_TYPE
                break;
        }
        return toReturn;
    }
}
