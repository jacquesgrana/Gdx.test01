package com.mycompany.test01.Entity.Airplane.Group;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronAbstract;

public class AirplaneSquadronGroup {
    OrderedSet<AirplaneSquadronAbstract> airplaneSquadrons = new OrderedSet<>();

    public AirplaneSquadronGroup() {
        this.airplaneSquadrons = new OrderedSet<>();
    }

    public AirplaneSquadronGroup(OrderedSet<AirplaneSquadronAbstract> airplanes) {
        this.airplaneSquadrons = airplanes;
    }

    public void addAirplaneSquadron(AirplaneSquadronAbstract element) {
        if(element != null) {
            this.airplaneSquadrons.add(element);
        }
    }

    public void removeAirplaneSquadron(AirplaneSquadronAbstract element) {
        if(element != null && this.airplaneSquadrons.contains(element)) {
            this.airplaneSquadrons.remove(element);
        }
    }

    public OrderedSet<AirplaneSquadronAbstract> getAirplanes() {
        return airplaneSquadrons;
    }

    public void setAirplanes(OrderedSet<AirplaneSquadronAbstract> airplanes) {
        this.airplaneSquadrons = airplanes;
    }
}
