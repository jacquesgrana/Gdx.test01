package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoCivilEngineerUnit extends Unit {

    public MotoCivilEngineerUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.MOTORISED_CIVIL_ENGINEER, false, isElite, true, isCompany, usesWhiteStroke, regRank);
    }
}
