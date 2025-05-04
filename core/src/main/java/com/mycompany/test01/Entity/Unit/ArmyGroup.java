package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArmyGroup extends UnitGroup{
    public ArmyGroup() {
        super();
    }

    public ArmyGroup(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, UnitTypeEnum.ARMY_HQ, isElite, isMotorised);
    }
}
