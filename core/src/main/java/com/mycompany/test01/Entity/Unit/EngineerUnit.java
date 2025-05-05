package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class EngineerUnit extends Unit {

    public EngineerUnit(String name, String acronym, CountryEnum country, boolean isElite, int regRank) {
       super(name, acronym, country, UnitTypeEnum.ENGINEER, isElite, false, regRank);
    }
}
