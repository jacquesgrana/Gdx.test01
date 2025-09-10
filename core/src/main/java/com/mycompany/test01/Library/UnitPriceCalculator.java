package com.mycompany.test01.Library;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
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
            * (ArtiAbstract.class.isAssignableFrom(unit.getClass()) ? 3.0 : 1.0)
        ;
        return Math.toIntExact(round(toReturn));
    }


    public static int getGroupPrice(UnitGroup group) {
        int toReturn  = getUnitPrice((UnitElement) group);
        for (ElementInterface unit : group.getUnits() ) {
            //toReturn += getUnitPrice((UnitElement) unit);
            if(unit instanceof UnitGroup) {
                toReturn += getGroupPrice((UnitGroup) unit);
            }
            else {
                toReturn += getUnitPrice((UnitElement) unit);
            }
        }
        return toReturn;
    }
}
