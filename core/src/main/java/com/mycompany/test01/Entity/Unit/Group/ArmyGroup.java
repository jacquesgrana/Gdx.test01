package com.mycompany.test01.Entity.Unit.Group;

import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArmyGroup extends UnitGroup {
    public ArmyGroup() {
        super();
    }

    public ArmyGroup(
        String name,
        String acronym,
        CountryEnum country,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean usesWhiteStroke,
        CombatProps combatProps) {
        super(name, acronym, country, UnitTypeEnum.ARMY_HQ, isPara, isElite, isMotorised, false, usesWhiteStroke, 0, 3, combatProps);
    }
}
