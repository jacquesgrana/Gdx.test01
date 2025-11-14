package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Interface.airplane.AirplaneSquadronElementInterface;

import java.util.Objects;

public class ReinfElement {
    private int dayNumber = 1;
    private UnitGroup landGroup = null;
    private OrderedSet<AirplaneSquadronElementInterface> airUnits = new OrderedSet<>();
    private SourceHexagon reinfHex = null;

    public ReinfElement() {
    }

    public ReinfElement(
        int dayNumber,
        UnitGroup landGroup,
        OrderedSet<AirplaneSquadronElementInterface> airUnits,
        SourceHexagon reinfHex
    ) {
        this.dayNumber = dayNumber;
        this.landGroup = landGroup;
        this.airUnits = airUnits;
        this.reinfHex = reinfHex;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReinfElement that = (ReinfElement) o;
        return dayNumber == that.dayNumber && Objects.equals(landGroup, that.landGroup) && Objects.equals(airUnits, that.airUnits) && Objects.equals(reinfHex, that.reinfHex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, landGroup, airUnits, reinfHex);
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public UnitGroup getLandGroup() {
        return landGroup;
    }

    public void setLandGroup(UnitGroup landGroup) {
        this.landGroup = landGroup;
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
