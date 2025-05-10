package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class BrigadeGroup extends UnitGroup {
    public BrigadeGroup() {
        super();
    }

    public BrigadeGroup(
        String name,
        String acronym,
        CountryEnum country,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean usesWhiteStroke
    ) {
        super(name, acronym, country, UnitTypeEnum.BRIGADE_HQ, isPara, isElite, isMotorised, false, usesWhiteStroke, 0, 1);
    }
}
