package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoInfRecoCompanyUnit extends Unit {

    public MotoInfRecoCompanyUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.MOTORISED_INF_RECO_COMPANY, false, isElite, true, true, usesWhiteStroke, regRank);
    }
}
