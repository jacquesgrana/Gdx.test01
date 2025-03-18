package com.mycompany.test01.Interface;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public interface ElementInterface {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public CountryEnum getCountry();

    public void setCountry(CountryEnum country);

    public UnitTypeEnum getType();

    public void setType(UnitTypeEnum type);

    public boolean equals(ElementInterface element);

    public int hashCode();
}
