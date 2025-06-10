package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoHeavyAntiAirUnit extends Unit {

    public MotoHeavyAntiAirUnit() {
        super();
    }

    public MotoHeavyAntiAirUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
        ) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_HEAVY_ANTI_AIR, false, isElite, true, isCompany, usesWhiteStroke, regRank);
    }
}
