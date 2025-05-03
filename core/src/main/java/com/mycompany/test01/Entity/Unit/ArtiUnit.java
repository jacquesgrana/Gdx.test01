package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArtiUnit extends Unit {

    public ArtiUnit(String name, String acronym, CountryEnum country, boolean isElite) {
        super(name, acronym, country, UnitTypeEnum.ARTI, isElite);
    }
}
