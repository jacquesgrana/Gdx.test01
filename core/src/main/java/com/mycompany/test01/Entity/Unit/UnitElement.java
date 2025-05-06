package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;
import com.mycompany.test01.Interface.ElementInterface;

import java.util.Objects;


/*
todo : ajouter booleen isElite + ajouter int regPosition (0 - 3) + ajouter booleen isCompany
 */
public abstract class UnitElement implements ElementInterface {
    private static int unitCounter = 0;
    protected int id;
    protected String name;
    protected String acronym;
    protected CountryEnum country;
    protected UnitTypeEnum type;
    protected boolean isElite;
    protected boolean isMotorised;
    protected boolean isCompany;
    protected int regRank;

    public UnitElement() {
        this.id = unitCounter;
        this.name = "";
        this.acronym = "";
        this.country = CountryEnum.NO_COUNTRY;
        this.type = UnitTypeEnum.NO_TYPE;
        isElite = false;
        isMotorised = false;
        isCompany = false;
        regRank = 0;
        unitCounter++;
    }

    public UnitElement(
        String name,
        String acronym,
        CountryEnum country,
        UnitTypeEnum type,
        boolean isElite,
        boolean isMotorised,
        boolean isCompany,
        int regRank
    ) {
        this.id = unitCounter;
        this.name = name;
        this.acronym = acronym;
        this.country = country;
        this.type = type;
        this.isElite = isElite;
        this.isMotorised = isMotorised;
        this.isCompany = isCompany;
        this.regRank = regRank;
        unitCounter++;
    }

    public boolean equals(ElementInterface element) {
        if (element == null) return false; // || getClass() != element.getClass()
        return element.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAcronym() {
        return acronym;
    }

    @Override
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public CountryEnum getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    @Override
    public UnitTypeEnum getType() {
        return type;
    }

    @Override
    public void setType(UnitTypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean isElite() {
        return this.isElite;
    }

    @Override
    public void setIsElite(boolean isElite) {
        this.isElite = isElite;
    }

    @Override
    public boolean isMotorised() {
        return this.isMotorised;
    }

    @Override
    public void setIsMotorised(boolean isMotorised) {
        this.isMotorised = isMotorised;
    }

    @Override
    public boolean isCompany(){
        return  this.isCompany;
    }

    @Override
    public void setIsCompany(boolean isCompany){
        this.isCompany = isCompany;
    }

    @Override
    public int getRegRank() {
        return regRank;
    }

    @Override
    public void setRegRank(int regRank) {
        this.regRank = regRank;
    }

    public static int getUnitCounter() {
        return unitCounter;
    }

    public static void setUnitCounter(int unitCounter) {
        UnitElement.unitCounter = unitCounter;
    }
}
