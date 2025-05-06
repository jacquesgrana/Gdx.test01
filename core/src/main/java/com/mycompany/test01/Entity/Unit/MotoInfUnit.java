package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoInfUnit extends Unit {

    public MotoInfUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.MOTORISED_INF, isElite, true, isCompany, regRank);
    }
}
