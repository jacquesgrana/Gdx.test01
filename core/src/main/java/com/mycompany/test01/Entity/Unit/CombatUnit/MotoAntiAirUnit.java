package com.mycompany.test01.Entity.Unit.CombatUnit;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoAntiAirUnit extends Unit {

    public MotoAntiAirUnit() {
        super();
    }

    public MotoAntiAirUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        CombatProps combatProps
        ) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ANTI_AIR, false, isElite, true, isCompany, usesWhiteStroke, regRank, combatProps);
    }
}
