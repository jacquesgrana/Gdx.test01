package com.mycompany.test01.Util;

import com.mycompany.test01.Entity.Unit.UnitElement;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.ElementSelectorType;
import com.mycompany.test01.Factory.UnitBlackCountryFactory;
import com.mycompany.test01.Factory.UnitBlueCountryFactory;
import com.mycompany.test01.Factory.UnitBrownCountryFactory;
import com.mycompany.test01.Factory.UnitRedCountryFactory;

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
        // green factory
        UnitRedCountryFactory unitRedCountryFactory = new UnitRedCountryFactory();
        // yellow factory
        UnitElement toReturn = null;

        switch (unitType) {
            case FRONT_HQ:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createFrontGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createFrontGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createFrontGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createFrontGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ARMY_GROUP_HQ:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createArmyGroupGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createArmyGroupGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createArmyGroupGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createArmyGroupGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ARMY_HQ:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createArmyGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createArmyGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createArmyGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createArmyGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case DIVISION_HQ:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createDivisionGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createDivisionGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createDivisionGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createDivisionGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case BRIGADE_HQ:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createBrigadeGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createBrigadeGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createBrigadeGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createBrigadeGroup(
                            unitName,
                            unitAcronym,
                            false,
                            isUnitElite,
                            false,
                            isUnitElite);
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank);
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite
                            ,0);
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MORTAR_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ROCKET_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case PARA_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createParaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createParaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createParaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createParaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case PARA_MORTAR_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createParaMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createParaMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createParaMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createParaMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ANTI_TANK:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ANTI_AIR:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case HEAVY_ANTI_AIR:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case INFANTRY:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createInfantryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createInfantryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createInfantryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createInfantryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case CAVALRY:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createCavalryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createCavalryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createCavalryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createCavalryUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case CIVIL_ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case BRIDGE_ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case PARA_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createParaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createParaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createParaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createParaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MARINE_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMarineInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMarineInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMarineInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMarineInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case LOGISTIC:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createLogisticUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createLogisticUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createLogisticUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createLogisticUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case TANK:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case HEAVY_TANK:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createHeavyTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createHeavyTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createHeavyTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createHeavyTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOUNTAIN_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMountainInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMountainInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMountainInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMountainInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOUNTAIN_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMountainArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMountainArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMountainArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMountainArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case SKI_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createSkiInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createSkiInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createSkiInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createSkiInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case SKI_MACHINE_GUN:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createSkiMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createSkiMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createSkiMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createSkiMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case GLIDER_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createGliderInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createGliderInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createGliderInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createGliderInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MECHANISED_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMecaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMecaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMecaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMecaInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case ASSAULT_GUN:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createAssaultGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createAssaultGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createAssaultGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createAssaultGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MECHANISED_RECO:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMecaRecoUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMecaRecoUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMecaRecoUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMecaRecoUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_CIVIL_ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoCivilEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_BRIDGE_ENGINEER:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoBridgeEngineerUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MECHANISED_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMecaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMecaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMecaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMecaArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_MORTAR_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoMortarArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_ROCKET_ARTI:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoRocketArtiUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_ANTI_TANK:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoAntiTankUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_ANTI_AIR:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_HEAVY_ANTI_AIR:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoHeavyAntiAirUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORCYCLE_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotorcycleInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotorcycleInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotorcycleInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotorcycleInfUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case BICYCLE_INF:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createBicycleUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createBicycleUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createBicycleUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createBicycleUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case INFANTRY_RECO_COMPANY:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MOTORISED_INF_RECO_COMPANY:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoInfRecoCompanyUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case MACHINE_GUN:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMachineGunUnit(
                            unitName,
                            unitAcronym,
                            isUnitElite,
                            isUnitElite,
                            unitRegRank
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case GROUP_INF_DIVISION:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case GROUP_ELITE_INF_DIVISION:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createEliteInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createEliteInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createEliteInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createEliteInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }
                break;
            case GROUP_MOTORISED_INF_DIVISION:
                switch (unitCountry) {
                    case BLACK_COUNTRY:
                        toReturn = unitBlackCountryFactory.createMotoInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BLUE_COUNTRY:
                        toReturn = unitBlueCountryFactory.createMotoInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                    case BROWN_COUNTRY:
                        toReturn = unitBrownCountryFactory.createMotoInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case GREEN_COUNTRY:
                        break;
                         */
                    case RED_COUNTRY:
                        toReturn = unitRedCountryFactory.createMotoInfDivision(
                            unitName,
                            unitAcronym
                        );
                        break;
                        /*
                    case YELLOW_COUNTRY:
                        break;
                         */
                }                break;
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
