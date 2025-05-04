package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MarineUnit extends Unit {

    public MarineUnit(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
       super(name, acronym, country, UnitTypeEnum.MARINE, isElite, isMotorised);
    }
}
