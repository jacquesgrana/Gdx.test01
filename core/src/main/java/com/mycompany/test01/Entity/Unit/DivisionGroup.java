package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class DivisionGroup extends UnitGroup{
    public DivisionGroup() {
        super();
    }

    public DivisionGroup(String name, CountryEnum country) {
        super(name, country, UnitTypeEnum.DIVISION_HQ);
    }
}
