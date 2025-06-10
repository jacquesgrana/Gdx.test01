package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class AntiTankUnit extends Unit {

    public AntiTankUnit() {
        super();
    }

    public AntiTankUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
        super(name, acronym, country, UnitTypeEnum.ANTI_TANK, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
