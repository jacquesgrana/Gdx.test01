package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ParaArtiUnit extends Unit {

    public ParaArtiUnit() {
        super();
    }

    public ParaArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.PARA_ARTI, true, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
