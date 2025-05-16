package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class LogisticUnit extends Unit {

    public LogisticUnit() {
        super();
    }

    public LogisticUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.LOGISTIC, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
