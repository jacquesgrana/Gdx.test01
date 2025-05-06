package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoAntiTankUnit extends Unit {

    public MotoAntiTankUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        int regRank
    ) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ANTI_TANK, isElite, true, isCompany, regRank);
    }
}
