package com.mycompany.test01.Common;

import com.mycompany.test01.Entity.Unit.*;

public class UnitFactory {

    public static InfantryUnit createInfantryUnit(int id, String name) {
        return new InfantryUnit(id, name);
    }

    public static FrontGroup createFrontGroup(int id, String name) {
        return new FrontGroup(id, name);
    }

    public static ArmyGroupGroup createArmyGroupGroup(int id, String name) {
        return new ArmyGroupGroup(id, name);
    }

    public static ArmyGroup createArmyGroup(int id, String name) {
        return new ArmyGroup(id, name);
    }

    public static DivisionGroup createDivisionGroup(int id, String name) {
        return new DivisionGroup(id, name);
    }

    public static BrigadeGroup createBrigadeGroup(int id, String name) {
        return new BrigadeGroup(id, name);
    }
}
