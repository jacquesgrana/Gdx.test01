package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class SkiInfantryUnit extends Unit {

    public SkiInfantryUnit() {
        super();
    }

    public SkiInfantryUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.SKI_INF, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
