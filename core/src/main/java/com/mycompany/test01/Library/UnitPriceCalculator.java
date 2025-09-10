package com.mycompany.test01.Library;

import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;

public class UnitPriceCalculator {

    public static int getUnitPrice(UnitElement unit) {
        int toReturn = 0;
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
        return toReturn;
    }

    public static int getGroupPrice(UnitGroup group) {
        return 0;
    }
}
