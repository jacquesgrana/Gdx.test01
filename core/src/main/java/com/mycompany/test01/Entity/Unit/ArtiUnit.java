package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArtiUnit extends Unit {

    public ArtiUnit(String name, CountryEnum country, boolean isElite) {
        super(name, country, UnitTypeEnum.ARTI, isElite);
    }
}
