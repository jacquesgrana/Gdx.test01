package com.mycompany.test01.Entity.Unit.NonCombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class CivilEngineerUnit extends Unit {

    public CivilEngineerUnit() {
        super();
    }

    public CivilEngineerUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.CIVIL_ENGINEER, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
