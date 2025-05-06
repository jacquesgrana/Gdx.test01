package com.mycompany.test01.Interface;

import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.UnitTypeEnum;

public interface ElementInterface {
    public int getId();

    public void setId(int id);

    public String getName();

    public String getAcronym();

    public void setAcronym(String acronym);

    public void setName(String name);

    public CountryEnum getCountry();

    public void setCountry(CountryEnum country);

    public UnitTypeEnum getType();

    public void setType(UnitTypeEnum type);

    public boolean isElite();

    public void setIsElite(boolean isElite);

    public boolean isMotorised();

    public void setIsMotorised(boolean isMotorised);

    public boolean isCompany();

    public void setIsCompany(boolean isCompany);

    public int getRegRank();

    public void setRegRank(int regRank);

    public boolean equals(ElementInterface element);

    public int hashCode();
}
