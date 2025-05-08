package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;

public interface UnitFactoryInterface {
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MountainInfantryUnit createMountainInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MountainArtiUnit createMountainArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public SkiInfantryUnit createSkiInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank);

    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank);

    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank);

    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public AssaultGun createAssaultGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank);

    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite,boolean usesWhiteStroke, int regRank);

    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank);

    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MotoAntiTankUnit createMotoAntiTankUnit(String name, String acronym, boolean usesWhiteStroke, boolean isElite, int regRank);

    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    public MotoAntiAirUnit createMotoAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank);

    // todo : reco inf et reco moto inf company

    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke);

    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke);

    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke);

    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke);

    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke);


    public DivisionGroup createInfDivision(String name, String acronym);

    public DivisionGroup createEliteInfDivision(String name, String acronym);

    public DivisionGroup createMotoInfDivision(String name, String acronym);

}
