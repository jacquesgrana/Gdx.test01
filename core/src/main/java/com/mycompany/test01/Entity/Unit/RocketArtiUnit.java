package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class RocketArtiUnit extends ArtiAbstract {

    public RocketArtiUnit() {
        super();
    }

    public RocketArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        ArtiProps artiProps
    ) {
        super(name, acronym, country, UnitTypeEnum.ROCKET_ARTI, false, isElite, false, isCompany, usesWhiteStroke, regRank, artiProps);
    }
}
