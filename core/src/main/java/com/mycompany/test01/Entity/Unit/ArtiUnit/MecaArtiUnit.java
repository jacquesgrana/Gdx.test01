package com.mycompany.test01.Entity.Unit.ArtiUnit;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MecaArtiUnit extends ArtiAbstract {

    public MecaArtiUnit() {
        super();
    }

    public MecaArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        CombatProps combatProps,
        ArtiProps artiProps
    ) {
       super(name, acronym, country, UnitTypeEnum.MECHANISED_ARTI, false, isElite, false, isCompany, usesWhiteStroke, regRank, combatProps, artiProps);
    }
}
