package com.mycompany.test01.Entity.Unit.ArtiUnit;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class MotoArtiUnit extends ArtiAbstract {

    public MotoArtiUnit() {
        super();
    }

    public MotoArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        ArtiProps artiProps) {
        super(name, acronym, country, UnitTypeEnum.MOTORISED_ARTI, false, isElite, true, isCompany, usesWhiteStroke, regRank, artiProps);
    }
}
