package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class HeavyAntiAirUnit extends Unit {

    public HeavyAntiAirUnit() {
        super();
    }

    public HeavyAntiAirUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
        ) {
        super(name, acronym, country, UnitTypeEnum.HEAVY_ANTI_AIR, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
