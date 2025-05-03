package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class InfantryUnit extends Unit {

    public InfantryUnit(String name, CountryEnum country, boolean isElite) {
       super(name, country, UnitTypeEnum.INFANTRY, isElite);
    }
}
