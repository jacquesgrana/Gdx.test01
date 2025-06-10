package com.mycompany.test01.Entity.Unit.Group;

import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArmyGroupGroup extends UnitGroup {
    public ArmyGroupGroup() {
        super();
    }

    public ArmyGroupGroup(
        String name,
        String acronym,
        CountryEnum country,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean usesWhiteStroke
    ) {
        super(name, acronym, country, UnitTypeEnum.ARMY_GROUP_HQ, isPara, isElite, isMotorised, false, usesWhiteStroke, 0, 4);
    }
}
