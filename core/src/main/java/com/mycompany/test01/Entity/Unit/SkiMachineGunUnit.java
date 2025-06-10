package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class SkiMachineGunUnit extends Unit {

    public SkiMachineGunUnit() {
        super();
    }

    public SkiMachineGunUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank
    ) {
       super(name, acronym, country, UnitTypeEnum.SKI_MACHINE_GUN, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
