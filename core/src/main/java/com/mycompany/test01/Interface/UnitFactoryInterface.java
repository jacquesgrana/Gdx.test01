package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite);

    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite);

    public ParaUnit createParaUnit(String name, String acronym, boolean isElite);

    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite);

    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite);

    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite);

    public TankUnit createTankUnit(String name, String acronym, boolean isElite);

    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite);

    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite);

    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite);

    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite);

    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite);

    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite);

    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite);

    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite);

    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite);
}
