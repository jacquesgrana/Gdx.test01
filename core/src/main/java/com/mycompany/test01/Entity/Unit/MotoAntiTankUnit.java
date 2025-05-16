package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoAntiTankUnit extends Unit {

    public MotoAntiTankUnit() {
        super();
    }

    public MotoAntiTankUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ANTI_TANK, false, isElite, true, isCompany, usesWhiteStroke, regRank);
    }
}
