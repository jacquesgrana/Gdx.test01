package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class AssaultGun extends Unit {

    public AssaultGun() {
        super();
    }

    public AssaultGun(
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
