package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ParaUnit extends Unit {

    public ParaUnit(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised, int regRank) {
       super(name, acronym, country, UnitTypeEnum.PARA, isElite, isMotorised, regRank);
    }
}
