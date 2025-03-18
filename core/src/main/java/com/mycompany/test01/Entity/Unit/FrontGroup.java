package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class FrontGroup extends UnitGroup {

    public FrontGroup() {
        super();
    }

    public FrontGroup(String name, CountryEnum country) {
        super(name, country, UnitTypeEnum.FRONT_HQ);
    }
}
