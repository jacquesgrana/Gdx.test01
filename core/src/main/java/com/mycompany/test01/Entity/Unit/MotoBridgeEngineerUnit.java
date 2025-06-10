package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoBridgeEngineerUnit extends Unit {

    public MotoBridgeEngineerUnit() {
        super();
    }

    public MotoBridgeEngineerUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.MOTORISED_BRIDGE_ENGINEER, false, isElite, true, isCompany, usesWhiteStroke, regRank);
    }
}
