package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name, boolean isElite);

    public ArtiUnit createArtiUnit(String name, boolean isElite);

    public TankUnit createTankUnit(String name, boolean isElite);

    public FrontGroup createFrontGroup(String name, boolean isElite);

    public ArmyGroupGroup createArmyGroupGroup(String name, boolean isElite);

    public ArmyGroup createArmyGroup(String name, boolean isElite);

    public DivisionGroup createDivisionGroup(String name, boolean isElite);

    public BrigadeGroup createBrigadeGroup(String name, boolean isElite);
}
