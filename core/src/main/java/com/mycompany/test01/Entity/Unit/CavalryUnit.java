package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class CavalryUnit extends Unit {

    public CavalryUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isMotorised, // todo : enlever !!!
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.CAVALRY, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
