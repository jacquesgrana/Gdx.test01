package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class AntiAirUnit extends Unit {

    public AntiAirUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isMotorised
        ) {
        super(name, acronym, country, UnitTypeEnum.ANTI_AIR, isElite, isMotorised);
    }
}
