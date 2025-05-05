package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, int regRank);

    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, int regRank);

    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, int regRank);

    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, int regRank);

    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, int regRank);

    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, int regRank);

    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank);

    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised);

    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised);
}
