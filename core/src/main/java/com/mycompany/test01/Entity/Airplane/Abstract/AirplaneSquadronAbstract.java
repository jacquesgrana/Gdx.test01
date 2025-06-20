package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;
import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public abstract class AirplaneSquadronAbstract {

    private static int airplaneSquadronCounter = 0;

    protected int id;
    private String name;
    private String acronym;
    private CountryEnum country;
    private AirplaneTypeEnum planeType;
    private AirplaneProps airplaneProps;

    public AirplaneSquadronAbstract() {
        this.id = AirplaneSquadronAbstract.airplaneSquadronCounter;
        this.name = "";
        this.acronym = "";
        this.country = CountryEnum.NO_COUNTRY;
        this.planeType = AirplaneTypeEnum.NO_TYPE;
        this.airplaneProps = new AirplaneProps();
        AirplaneSquadronAbstract.airplaneSquadronCounter++;
    }

    public AirplaneSquadronAbstract(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        AirplaneProps airplaneProps
    ) {
        this.name = name;
        this.acronym = acronym;
        this.country = country;
        this.planeType = planeType;
        this.airplaneProps = airplaneProps;
    }

    public int getId() {
        return id;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
    */

    public static int getAirplaneSquadronCounter() {
        return airplaneSquadronCounter;
    }

    /*
    public static void setAirplaneSquadronCounter(int airplaneSquadronCounter) {
        AirplaneSquadron.airplaneSquadronCounter = airplaneSquadronCounter;
    }
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public AirplaneTypeEnum getPlaneType() {
        return planeType;
    }

    public void setPlaneType(AirplaneTypeEnum planeType) {
        this.planeType = planeType;
    }

    public AirplaneProps getAirplaneProps() {
        return airplaneProps;
    }

    public void setAirplaneProps(AirplaneProps airplaneProps) {
        this.airplaneProps = airplaneProps;
    }
}
