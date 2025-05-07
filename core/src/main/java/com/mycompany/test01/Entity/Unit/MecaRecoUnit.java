package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MecaRecoUnit extends Unit {

    public MecaRecoUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isMotorised,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.MECHANISED_RECO, isElite, isMotorised, isCompany, usesWhiteStroke, regRank);
    }
}
