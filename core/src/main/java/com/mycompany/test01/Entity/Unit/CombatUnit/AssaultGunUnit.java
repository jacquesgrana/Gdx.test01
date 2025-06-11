package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class AssaultGunUnit extends Unit {

    public AssaultGunUnit() {
        super();
    }

    public AssaultGunUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank) {
        super(name, acronym, country, UnitTypeEnum.ASSAULT_GUN, false, isElite, false, isCompany, usesWhiteStroke, regRank);
    }
}
