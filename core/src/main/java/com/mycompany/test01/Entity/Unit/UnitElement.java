package com.mycompany.test01.Entity.Unit;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;
import com.mycompany.test01.Interface.ElementInterface;

import java.util.Objects;

public abstract class UnitElement implements ElementInterface {
    private static int unitCounter = 0;
    protected int id;
    protected String name;
    protected CountryEnum country;
    protected UnitTypeEnum type;

    public UnitElement() {
        this.id = unitCounter;
        this.name = "";
        this.country = CountryEnum.NO_COUNTRY;
        this.type = UnitTypeEnum.NO_TYPE;
        unitCounter++;
    }

    public UnitElement(String name, CountryEnum country, UnitTypeEnum type) {
        this.id = unitCounter;
        this.name = name;
        this.country = country;
        this.type = type;
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

    public static int getUnitCounter() {
        return unitCounter;
    }

    public static void setUnitCounter(int unitCounter) {
        UnitElement.unitCounter = unitCounter;
    }
}
