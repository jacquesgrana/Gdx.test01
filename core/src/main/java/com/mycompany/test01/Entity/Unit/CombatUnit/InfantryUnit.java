package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class InfantryUnit extends Unit {

    public InfantryUnit() {
        super();
    }

    public InfantryUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        CombatProps combatProps
    ) {
       super(name, acronym, country, UnitTypeEnum.INFANTRY, false, isElite, false, isCompany, usesWhiteStroke, regRank, combatProps);
    }
}
