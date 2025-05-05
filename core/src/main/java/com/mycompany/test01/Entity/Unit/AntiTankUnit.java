package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class AntiTankUnit extends Unit {

    public AntiTankUnit(String name, String acronym, CountryEnum country, boolean isElite, int regRank) {
        super(name, acronym, country, UnitTypeEnum.ANTI_TANK, isElite, false, 0);
    }
}
