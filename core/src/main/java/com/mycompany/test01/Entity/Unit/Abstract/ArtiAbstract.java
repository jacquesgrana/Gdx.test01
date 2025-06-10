package com.mycompany.test01.Entity.Unit.Abstract;

import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public abstract class ArtiAbstract extends Unit {
    private ArtiProps artiProps;

    public ArtiAbstract() {
        super();
        this.artiProps = new ArtiProps();
    }

    public ArtiAbstract(
        String name,
        String acronym,
        CountryEnum country,
        UnitTypeEnum type,
        boolean isPara,
        boolean isElite,
        boolean isMotorised,
        boolean isCompany,
        boolean usesWhiteStroke,
        int regRank,
        ArtiProps artiProps)
    {
        super(name, acronym, country, type, isPara, isElite, isMotorised, isCompany, usesWhiteStroke, regRank);
        this.artiProps = artiProps;
    }

    public ArtiProps getArtiProps() {
        return artiProps;
    }

    public void setArtiProps(ArtiProps artiProps) {
        this.artiProps = artiProps;
    }
}
