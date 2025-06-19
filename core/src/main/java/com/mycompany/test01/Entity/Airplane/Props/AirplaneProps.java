package com.mycompany.test01.Entity.Airplane.Props;

import com.mycompany.test01.Enum.AirplaneTypeEnum;
import com.mycompany.test01.Enum.CountryEnum;

public class AirplaneProps {
    private String name;
    private String acronym;
    private CountryEnum country;
    private AirplaneTypeEnum planeType;
    private int planeMaxCount;
    private int airAttack;
    private int airDefense;
    private int moralMax;
    private int maneuverability;
    private int speedMax;
    private int rangeMax;
    private int visibility;
    //private int accuracy;

    public AirplaneProps() {
        this.name = "";
        this.acronym = "";
        this.country = CountryEnum.NO_COUNTRY;
        this.planeType = AirplaneTypeEnum.NO_TYPE;
        this.planeMaxCount = 1;
        this.airDefense = 1;
        this.airAttack = 1;
        this.moralMax = 2;
        this.maneuverability = 1;
        this.speedMax = 2;
        this.rangeMax = 3;
        this.visibility = 1;
        //this.accuracy = 1;
    }

    public AirplaneProps(
        String name,
        String acronym,
        CountryEnum country,
        AirplaneTypeEnum planeType,
        int planeMaxCount,
        int airDefense,
        int airAttack,
        int moralMax,
        int maneuverability,
        int speedMax,
        int rangeMax,
        int visibility
    ) {
        this.name = name;
        this.acronym = acronym;
        this.country = country;
        this.planeType = planeType;
        this.planeMaxCount = planeMaxCount;
        this.airDefense = airDefense;
        this.airAttack = airAttack;
        this.moralMax = moralMax;
        this.maneuverability = maneuverability;
        this.speedMax = speedMax;
        this.rangeMax = rangeMax;
        this.visibility = visibility;
        //this.accuracy = accuracy;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPlaneMaxCount() {
        return planeMaxCount;
    }

    public void setPlaneMaxCount(int planeMaxCount) {
        this.planeMaxCount = planeMaxCount;
    }

    public int getAirAttack() {
        return airAttack;
    }

    public void setAirAttack(int airAttack) {
        this.airAttack = airAttack;
    }

    public int getAirDefense() {
        return airDefense;
    }

    public void setAirDefense(int airDefense) {
        this.airDefense = airDefense;
    }

    public int getMoralMax() {
        return moralMax;
    }

    public void setMoralMax(int moralMax) {
        this.moralMax = moralMax;
    }

    public int getManeuverability() {
        return maneuverability;
    }

    public void setManeuverability(int maneuverability) {
        this.maneuverability = maneuverability;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
