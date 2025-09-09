package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class EngineerUnit extends Unit {

    public EngineerUnit() {
        super();
    }

    public EngineerUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        CombatProps combatProps) {
       super(name, acronym, country, UnitTypeEnum.ENGINEER, false, isElite, false, isCompany, usesWhiteStroke, regRank, combatProps);
    }
}
