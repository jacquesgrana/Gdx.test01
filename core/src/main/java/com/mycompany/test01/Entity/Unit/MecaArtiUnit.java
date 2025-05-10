package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MecaArtiUnit extends Unit {

    public MecaArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.MECHANISED_ARTI, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
