package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class InfantryRecoCompanyUnit extends Unit {

    public InfantryRecoCompanyUnit() {
        super();
    }

    public InfantryRecoCompanyUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.INFANTRY_RECO_COMPANY, false, isElite, false, true, usesWhiteStroke, regRank);
    }
}
