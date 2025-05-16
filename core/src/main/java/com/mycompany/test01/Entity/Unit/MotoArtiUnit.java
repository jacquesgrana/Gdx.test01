package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoArtiUnit extends Unit {

    public MotoArtiUnit() {
        super();
    }

    public MotoArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ARTI, isElite, false, true, isCompany, usesWhiteStroke, regRank);
    }
}
