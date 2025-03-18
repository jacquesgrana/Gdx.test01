package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    public InfantryUnit createInfantryUnit(String name) {
        return new InfantryUnit(name);
    }

    public FrontGroup createFrontGroup(String name) {
        return new FrontGroup(name);
    }

    public ArmyGroupGroup createArmyGroupGroup(String name) {
        return new ArmyGroupGroup(name);
    }

    public ArmyGroup createArmyGroup(String name) {
        return new ArmyGroup(name);
    }

    public DivisionGroup createDivisionGroup(String name) {
        return new DivisionGroup(name);
    }

    public BrigadeGroup createBrigadeGroup(String name) {
        return new BrigadeGroup(name);
    }
}
