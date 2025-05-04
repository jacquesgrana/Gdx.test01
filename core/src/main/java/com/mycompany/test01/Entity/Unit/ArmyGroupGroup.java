package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArmyGroupGroup extends UnitGroup {
    public ArmyGroupGroup() {
        super();
    }

    public ArmyGroupGroup(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, UnitTypeEnum.ARMY_GROUP_HQ, isElite, isMotorised, 0);
    }
}
