package com.mycompany.test01.Entity.Unit.Group;

import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class DivisionGroup extends UnitGroup {
    public DivisionGroup() {
        super();
    }

    public DivisionGroup(
        String name,
        String acronym,
        CountryEnum country,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean usesWhiteStroke) {
        super(name, acronym, country, UnitTypeEnum.DIVISION_HQ, isPara, isElite, isMotorised, false, usesWhiteStroke, 0, 2);
    }
}
