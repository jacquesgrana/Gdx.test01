package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean isMotorised);

    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised);
}
