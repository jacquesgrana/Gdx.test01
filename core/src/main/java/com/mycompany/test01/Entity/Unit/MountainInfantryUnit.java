package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MountainInfantryUnit extends Unit {

    public MountainInfantryUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.MOUNTAIN_INF, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
