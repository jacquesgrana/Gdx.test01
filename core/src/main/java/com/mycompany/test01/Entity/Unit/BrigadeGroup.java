package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class BrigadeGroup extends UnitGroup {
    public BrigadeGroup() {
        super();
    }

    public BrigadeGroup(String name, CountryEnum country) {
        super(name, country, UnitTypeEnum.BRIGADE_HQ);
    }
}
