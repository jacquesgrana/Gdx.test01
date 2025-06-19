package com.mycompany.test01.Entity.Airplane.Abstract;

import com.mycompany.test01.Entity.Airplane.Props.AirplaneProps;

public abstract class AirplaneSquadronAbstract {

    private static int airplaneSquadronCounter = 0;

    protected int id;
    private AirplaneProps airplaneProps;

    public AirplaneSquadronAbstract() {
        this.id = AirplaneSquadronAbstract.airplaneSquadronCounter;
        this.airplaneProps = new AirplaneProps();
        AirplaneSquadronAbstract.airplaneSquadronCounter++;
    }

    public AirplaneSquadronAbstract(AirplaneProps airplaneProps) {
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

    public AirplaneProps getAirplaneProps() {
        return airplaneProps;
    }

    public void setAirplaneProps(AirplaneProps airplaneProps) {
        this.airplaneProps = airplaneProps;
    }
}
