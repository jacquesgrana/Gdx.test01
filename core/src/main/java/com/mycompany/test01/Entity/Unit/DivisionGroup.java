package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class DivisionGroup extends UnitGroup{
    public DivisionGroup() {
        super();
    }

    public DivisionGroup(String name, String acronym, CountryEnum country, boolean isElite, boolean isMotorised) {
        super(name, acronym, country, UnitTypeEnum.DIVISION_HQ, isElite, isMotorised, false, 0, 2);
    }
}
