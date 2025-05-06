package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class InfantryUnit extends Unit {

    public InfantryUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.INFANTRY, isElite, false, isCompany, regRank);
    }
}
