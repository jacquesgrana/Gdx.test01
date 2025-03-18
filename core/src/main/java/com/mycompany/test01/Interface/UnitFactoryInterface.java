package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name);

    public FrontGroup createFrontGroup(String name);

    public ArmyGroupGroup createArmyGroupGroup(String name);

    public ArmyGroup createArmyGroup(String name);

    public DivisionGroup createDivisionGroup(String name);

    public BrigadeGroup createBrigadeGroup(String name);
}
