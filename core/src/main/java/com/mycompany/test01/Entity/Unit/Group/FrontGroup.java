package com.mycompany.test01.Entity.Unit.Group;

import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class FrontGroup extends UnitGroup {

    public FrontGroup() {
        super();
    }

    public FrontGroup(
        String name,
        String acronym,
        CountryEnum country,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean usesWhiteStroke,
        CombatProps combatProps
    ) {
        super(name, acronym, country, UnitTypeEnum.FRONT_HQ, isPara, isElite, isMotorised, false, usesWhiteStroke, 0, 5, combatProps);
    }
}
