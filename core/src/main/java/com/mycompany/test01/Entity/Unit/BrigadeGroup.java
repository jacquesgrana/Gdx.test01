package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class BrigadeGroup extends UnitGroup {
    public BrigadeGroup() {
        super();
    }

    public BrigadeGroup(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, UnitTypeEnum.BRIGADE_HQ, isElite, isMotorised, false, 0, 1);
    }
}
