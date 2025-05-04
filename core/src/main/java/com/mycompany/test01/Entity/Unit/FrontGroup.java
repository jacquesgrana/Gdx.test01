package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class FrontGroup extends UnitGroup {

    public FrontGroup() {
        super();
    }

    public FrontGroup(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, UnitTypeEnum.FRONT_HQ, isElite, isMotorised, 0);
    }
}
