package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class HeavyTankUnit extends Unit {

    public HeavyTankUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
        super(name, acronym, country, UnitTypeEnum.HEAVY_TANK, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
