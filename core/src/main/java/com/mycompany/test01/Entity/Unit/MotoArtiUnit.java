package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoArtiUnit extends Unit {

    public MotoArtiUnit(String name, String acronym, CountryEnum country, boolean isElite, int regRank) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ARTI, isElite, true, regRank);
    }
}
