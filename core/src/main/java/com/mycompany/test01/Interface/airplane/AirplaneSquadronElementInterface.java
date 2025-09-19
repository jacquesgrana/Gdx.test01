package com.mycompany.test01.Interface.airplane;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public interface AirplaneSquadronElementInterface {

    static int airplaneSquadronCounter = 0;
    public int getId();

    //public int getAirplaneSquadronCounter();

    public String getName();

    public void setName(String name);

    public String getAcronym();

    public void setAcronym(String acronym);

    public CountryEnum getCountry();

    public void setCountry(CountryEnum country);

    public AirplaneTypeEnum getPlaneType();

    public void setPlaneType(AirplaneTypeEnum planeType);

    public AirplaneProps getAirplaneProps();

    public void setAirplaneProps(AirplaneProps airplaneProps);
}
