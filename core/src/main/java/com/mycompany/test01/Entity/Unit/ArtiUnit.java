package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Entity.Unit.Abstract.ArtiAbstract;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public class ArtiUnit extends ArtiAbstract {

    public ArtiUnit() {
        super();
    }

    public ArtiUnit(
        String name,
        String acronym,
        CountryEnum country,
        boolean isElite,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        ArtiProps artiProps) {
        super(name, acronym, country, UnitTypeEnum.ARTI, false, isElite, false, isCompany, usesWhiteStroke, regRank, artiProps);
    }
}
