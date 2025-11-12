package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Interface.airplane.AirplaneSquadronElementInterface;

import java.util.Objects;

public class ReinfElement {
    private int dayNumber = 1;
    private OrderedSet<UnitElement> landUnits = new OrderedSet<>();
    private OrderedSet<AirplaneSquadronElementInterface> airUnits = new OrderedSet<>();
    private SourceHexagon reinfHex = null;

    public ReinfElement() {
    }

    public ReinfElement(
        int dayNumber,
        OrderedSet<UnitElement> landUnits,
        OrderedSet<AirplaneSquadronElementInterface> airUnits,
        SourceHexagon reinfHex
    ) {
        this.dayNumber = dayNumber;
        this.landUnits = landUnits;
        this.airUnits = airUnits;
        this.reinfHex = reinfHex;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReinfElement that = (ReinfElement) o;
        return dayNumber == that.dayNumber && Objects.equals(landUnits, that.landUnits) && Objects.equals(airUnits, that.airUnits) && Objects.equals(reinfHex, that.reinfHex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, landUnits, airUnits, reinfHex);
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
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

    public SourceHexagon getReinfHex() {
        return reinfHex;
    }

    public void setReinfHex(SourceHexagon reinfHex) {
        this.reinfHex = reinfHex;
    }
}
