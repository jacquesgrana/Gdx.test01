package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoRocketArtiUnit extends Unit {

    public MotoRocketArtiUnit() {
        super();
    }

    public MotoRocketArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ROCKET_ARTI, false, isElite, true, isCompany, usesWhiteStroke, regRank);
    }
}
