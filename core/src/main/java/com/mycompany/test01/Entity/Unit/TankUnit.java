package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class TankUnit extends Unit {

    public TankUnit(String name, String acronym, CountryEnum country, boolean isElite) {
        super(name, acronym, country, UnitTypeEnum.TANK, isElite);
    }
}
