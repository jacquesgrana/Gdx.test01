package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class BicycleInfUnit extends Unit {

    public BicycleInfUnit() {
        super();
    }

    public BicycleInfUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.BICYCLE_INF, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
