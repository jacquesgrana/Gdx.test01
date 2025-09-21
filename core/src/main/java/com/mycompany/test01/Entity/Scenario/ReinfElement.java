package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Interface.airplane.AirplaneSquadronElementInterface;

public class ReinfElement {
    private String dateTime = "";
    private OrderedSet<UnitElement> landUnits = new OrderedSet<>();
    private OrderedSet<AirplaneSquadronElementInterface> airUnits = new OrderedSet<>();
    private Hexagon reinfHex = null;

    public ReinfElement() {
    }

    public ReinfElement(
        String dateTime,
        OrderedSet<UnitElement> landUnits,
        OrderedSet<AirplaneSquadronElementInterface> airUnits,
        Hexagon reinfHex
    ) {
        this.dateTime = dateTime;
        this.landUnits = landUnits;
        this.airUnits = airUnits;
        this.reinfHex = reinfHex;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public OrderedSet<UnitElement> getLandUnits() {
        return landUnits;
    }

    public void setLandUnits(OrderedSet<UnitElement> landUnits) {
        this.landUnits = landUnits;
    }

    public OrderedSet<AirplaneSquadronElementInterface> getAirUnits() {
        return airUnits;
    }

    public void setAirUnits(OrderedSet<AirplaneSquadronElementInterface> airUnits) {
        this.airUnits = airUnits;
    }

    public Hexagon getReinfHex() {
        return reinfHex;
    }

    public void setReinfHex(Hexagon reinfHex) {
        this.reinfHex = reinfHex;
    }
}
