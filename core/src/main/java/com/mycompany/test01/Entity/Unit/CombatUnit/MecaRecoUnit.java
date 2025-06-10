package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MecaRecoUnit extends Unit {

    public MecaRecoUnit() {
        super();
    }

    public MecaRecoUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
       super(name, acronym, country, UnitTypeEnum.MECHANISED_RECO, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
