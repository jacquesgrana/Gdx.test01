package com.mycompany.test01.Library;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.UnitTypeEnum;
import com.mycompany.test01.Interface.ElementInterface;

import static java.lang.Math.round;

public class UnitPriceCalculator {

    public static int getUnitPrice(UnitElement unit) {
        /*
        System.out.println("type : " + unit.getType());

        System.out.println("moral max : " + unit.getCombatProps().getMoralMax());
        System.out.println("manpower max : " + unit.getCombatProps().getManpowerMax());
        System.out.println("speed max : " + unit.getCombatProps().getSpeed());
        System.out.println("soft attack : " + unit.getCombatProps().getSoftAttack());
        System.out.println("hard attack : " + unit.getCombatProps().getHardAttack());
        System.out.println("air attack : " + unit.getCombatProps().getAirAttack());
        System.out.println("soft defense : " + unit.getCombatProps().getSoftDefense());
        System.out.println("hard defense : " + unit.getCombatProps().getHardDefense());
        System.out.println("air defense : " + unit.getCombatProps().getAirDefense());
        System.out.println("is combat unit : " + unit.getCombatProps().isCombatUnit());
        System.out.println("is elite unit : " + unit.isElite());
        System.out.println("is para unit : " + unit.isPara());
        System.out.println("is motorised unit : " + unit.isMotorised());
        System.out.println("is company : " + unit.isCompany());
         */
        double toReturn = 100
            * (unit.getCombatProps().getMoralMax() / 10f)
            * (unit.getCombatProps().getManpowerMax() / 1000f)
            * (unit.getCombatProps().getSpeed() / 10f)
            * (unit.getCombatProps().isCombatUnit() ? 1.0 : 0.5)
            * (unit.isElite() ? 1.5 : 1.0)
            * (unit.isPara() ? 1.25 : 1.0)
            * (unit.isMotorised() ? 1.10 : 1.0)
            * (unit.isCompany() ? 0.33 : 1.0)
            * getUnitTypeRatio(unit.getType())
            //* (ArtiAbstract.class.isAssignableFrom(unit.getClass()) ? 4.0 : 1.0)
            //* (ArtiAbstract.class.isAssignableFrom(unit.getClass()) ? (double) ((ArtiAbstract) unit).getArtiProps().getRange() / 6.0 : 1.0)
        ;
        return Math.toIntExact(round(toReturn));
    }


    public static int getGroupPrice(UnitGroup group) {
        int toReturn  = getUnitPrice((UnitElement) group);
        if(!group.getUnits().isEmpty()) {
            for (ElementInterface unit : group.getUnits() ) {
                if(unit instanceof UnitGroup) {
                    toReturn += getGroupPrice((UnitGroup) unit);
                }
                else {
                    toReturn += getUnitPrice((UnitElement) unit);
                }
            }
        }
        return toReturn;
    }

    public static float getUnitTypeRatio(UnitTypeEnum unitType) {
        float toReturn = 1.0f;
        switch (unitType) {
            case FRONT_HQ:
            case ARMY_GROUP_HQ:
            case ARMY_HQ:
            case DIVISION_HQ:
            case BRIGADE_HQ:
                toReturn = 1.2f;
                break;

            case ARTI:
            case PARA_ARTI:
                toReturn = 4.0f;
                break;
            case MORTAR_ARTI:
            case PARA_MORTAR_ARTI:
                toReturn = 3.0f;
                break;
            case ROCKET_ARTI:
                toReturn = 3.5f;
                break;

            case ANTI_TANK:
                toReturn = 1.2f;
                break;
            case ANTI_AIR:
                toReturn = 1.3f;
                break;
            case HEAVY_ANTI_AIR:
                toReturn = 1.5f;
                break;

            case INFANTRY:
                toReturn = 1.0f;
                break;
            case PARA_INF:
            case MARINE_INF:
                toReturn = 2.0f;
                break;
            case CAVALRY:
                toReturn = 0.6f;
                break;
            case ENGINEER:
                toReturn = 1.5f;
                break;
            case CIVIL_ENGINEER:
                toReturn = 1.3f;
                break;
            case BRIDGE_ENGINEER:
                toReturn = 1.6f;
                break;
            case LOGISTIC:
                toReturn = 1.5f;
                break;

            case TANK:
                toReturn = 2.5f;
                break;
            case HEAVY_TANK:
                toReturn = 3.5f;
                break;

            case MOUNTAIN_INF:
                toReturn = 1.8f;
                break;
            case MOUNTAIN_ARTI:
                toReturn = 4.5f;
                break;

            case SKI_INF:
                toReturn = 1.5f;
                break;
            case SKI_MACHINE_GUN:
                toReturn = 2.0f;
                break;
            case GLIDER_INF:
                toReturn = 2.2f;
                break;

            case ASSAULT_GUN:
                toReturn = 2.4f;
                break;

            case MECHANISED_INF:
                toReturn = 2.5f;
                break;
            case MECHANISED_RECO:
                toReturn = 2.6f;
                break;
            case MECHANISED_ARTI:
                toReturn = 2.5f * 3.0f;
                break;

            case MOTORISED_INF:
                toReturn = 1.75f;
                break;
            case MOTORISED_ENGINEER:
                toReturn = 1.5f * 1.75f;
                break;
            case MOTORISED_CIVIL_ENGINEER:
                toReturn = 1.3f * 1.75f;
                break;
            case MOTORISED_BRIDGE_ENGINEER:
                toReturn = 1.6f * 1.75f;
                break;
            case MOTORISED_ARTI:
                toReturn = 1.75f * 4.0f;
                break;
            case MOTORISED_MORTAR_ARTI:
                toReturn = 1.75f * 3.0f;
                break;
            case MOTORISED_ROCKET_ARTI:
                toReturn = 1.75f * 3.5f;
                break;

            case MOTORISED_ANTI_TANK:
                toReturn = 1.75f * 1.2f;
                break;
            case MOTORISED_ANTI_AIR:
                toReturn = 1.75f * 1.3f;
                break;
            case MOTORISED_HEAVY_ANTI_AIR:
                toReturn = 1.75f * 1.5f;
                break;

            case MOTORCYCLE_INF:
                toReturn = 1.6f;
                break;
            case BICYCLE_INF:
                toReturn = 1.1f;
                break;

            case INFANTRY_RECO_COMPANY:
                toReturn = 1.2f;
                break;
            case MOTORISED_INF_RECO_COMPANY:
                toReturn = 1.75f * 1.2f;
                break;

            case MACHINE_GUN:
                toReturn = 1.4f;
                break;
            case NO_TYPE:
                toReturn = 1.0f;
                break;
        }
        return toReturn;
    }
}
