package com.mycompany.test01.Entity.Unit.ArtiUnit;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Entity.Unit.Props.CombatProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MountainArtiUnit extends ArtiAbstract {

    public MountainArtiUnit() {
        super();
    }

    public MountainArtiUnit(
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
       super(name, acronym, country, UnitTypeEnum.MOUNTAIN_ARTI, false, isElite, false, isCompany, usesWhiteStroke, regRank, combatProps, artiProps);
    }
}
