package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new InfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MountainInfantryUnit createMountainInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MountainInfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MountainArtiUnit createMountainArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank)
    {
        return new MountainArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public SkiInfantryUnit createSkiInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiInfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public SkiMachineGunUnit createSkiMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiMachineGunUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public GliderInfantryUnit createGliderInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new GliderInfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank) {
        return new CavalryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, false, usesWhiteStroke, regRank);
    }

    @Override
    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank) {
        return new ParaUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, false, usesWhiteStroke, regRank);
    }

    @Override
    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank) {
        return new MarineUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, false, usesWhiteStroke, regRank);
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new EngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public CivilEngineerUnit createCivilEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new CivilEngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MortarArtiUnit createMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MortarArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public RocketArtiUnit createRocketArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new RocketArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new TankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public HeavyTankUnit createHeavyTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new HeavyTankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public AssaultGun createAssaultGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank){
        return new AssaultGun(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MecaArtiUnit createMecaArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoEngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke, int regRank) {
        return new MecaRecoUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, false, usesWhiteStroke, regRank);
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiTankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoAntiTankUnit createMotoAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiTankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiAirUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoAntiAirUnit createMotoAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiAirUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MachineGunUnit createMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MachineGunUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    public BicycleInfUnit createBicycleUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new BicycleInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    public MotorcycleInfUnit createMotorcycleUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotorcycleInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }

    public LogisticUnit createLogisticUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank)
    {
        return new LogisticUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, false, usesWhiteStroke, regRank);
    }



    @Override
    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new FrontGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroupGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new DivisionGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new BrigadeGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public DivisionGroup createInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.RED_COUNTRY, false, false, false);
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, CountryEnum.RED_COUNTRY, false, false, false, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, CountryEnum.RED_COUNTRY, false, false, false, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, CountryEnum.RED_COUNTRY, false, false, false, 0);

        division.addUnit(inf_01_01);
        division.addUnit(inf_02_01);
        division.addUnit(inf_03_01);
        division.addUnit(inf_01_02);
        division.addUnit(inf_02_02);
        division.addUnit(inf_03_02);
        division.addUnit(inf_01_03);
        division.addUnit(inf_02_03);
        division.addUnit(inf_03_03);

        division.addUnit(art_01);
        division.addUnit(art_02);
        division.addUnit(art_03);

        division.addUnit(anti_tank_01);
        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }

    @Override
    public DivisionGroup createEliteInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.RED_COUNTRY, true, false, true);
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.RED_COUNTRY, true, false, true, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.RED_COUNTRY, true, false, true, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.RED_COUNTRY, true, false, true, 3);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.RED_COUNTRY, true, false, true, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.RED_COUNTRY, true, false, true, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.RED_COUNTRY, true, false, true, 3);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.RED_COUNTRY, true, false, true, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.RED_COUNTRY, true, false, true, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.RED_COUNTRY, true, false, true, 3);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.RED_COUNTRY, true, false, true, 1);
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.RED_COUNTRY, true, false, true, 2);
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.RED_COUNTRY, true, false, true, 3);
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, CountryEnum.RED_COUNTRY, true, false, true, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, CountryEnum.RED_COUNTRY, true, false, true, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, CountryEnum.RED_COUNTRY, true, false, true, 0);


        division.addUnit(inf_01_01);
        division.addUnit(inf_02_01);
        division.addUnit(inf_03_01);
        division.addUnit(inf_01_02);
        division.addUnit(inf_02_02);
        division.addUnit(inf_03_02);
        division.addUnit(inf_01_03);
        division.addUnit(inf_02_03);
        division.addUnit(inf_03_03);

        division.addUnit(art_01);
        division.addUnit(art_02);
        division.addUnit(art_03);

        division.addUnit(anti_tank_01);
        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }

    public DivisionGroup createMotoInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.RED_COUNTRY, false, true, false);

        // 3 * 3 inf
        MotoInfUnit inf_01_01 = new MotoInfUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoInfUnit inf_02_01 = new MotoInfUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        MotoInfUnit inf_03_01 = new MotoInfUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        MotoInfUnit inf_01_02 = new MotoInfUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoInfUnit inf_02_02 = new MotoInfUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        MotoInfUnit inf_03_02 = new MotoInfUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        MotoInfUnit inf_01_03 = new MotoInfUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoInfUnit inf_02_03 = new MotoInfUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        MotoInfUnit inf_03_03 = new MotoInfUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        // 3 tanks
        TankUnit tank_01 = new TankUnit(divName + " tank 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        TankUnit tank_02 = new TankUnit(divName + " tank 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        TankUnit tank_03 = new TankUnit(divName + " tank 3", acronym + "•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        // 3 art
        MotoArtiUnit art_01 = new MotoArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoArtiUnit art_02 = new MotoArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        MotoArtiUnit art_03 = new MotoArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.RED_COUNTRY, false, false, false, 3);
        // 1 Anti tank
        MotoAntiTankUnit anti_tank_01 = new MotoAntiTankUnit(divName + " anti_tank", acronym, CountryEnum.RED_COUNTRY, false, false, false, 0);
        // 1 Eng
        MotoEngineerUnit engineer_01 = new MotoEngineerUnit(divName + " engineer", acronym, CountryEnum.RED_COUNTRY, false, false, false, 0);

        // todo 1 moto reco inf company
        MotoInfRecoCompanyUnit reco_company = new MotoInfRecoCompanyUnit(divName + " reco", acronym, CountryEnum.RED_COUNTRY, false, false, 0);

        division.addUnit(inf_01_01);
        division.addUnit(inf_02_01);
        division.addUnit(inf_03_01);
        division.addUnit(inf_01_02);
        division.addUnit(inf_02_02);
        division.addUnit(inf_03_02);
        division.addUnit(inf_01_03);
        division.addUnit(inf_02_03);
        division.addUnit(inf_03_03);

        division.addUnit(tank_01);
        division.addUnit(tank_02);
        division.addUnit(tank_03);

        division.addUnit(art_01);
        division.addUnit(art_02);
        division.addUnit(art_03);

        division.addUnit(anti_tank_01);
        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }

    public BrigadeGroup createMotoInfBrigade(String brigName, String acronym) {
        BrigadeGroup brigade = new BrigadeGroup(brigName, acronym, CountryEnum.RED_COUNTRY, false, true, false);

        // 3 * 3 inf
        MotoInfUnit inf_01_01 = new MotoInfUnit(brigName + " inf 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoInfUnit inf_02_01 = new MotoInfUnit(brigName + " inf 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);
        MotoInfUnit inf_03_01 = new MotoInfUnit(brigName + " inf 3", acronym + "•3", CountryEnum.RED_COUNTRY, false, false, false, 3);

        TankUnit tank_01 = new TankUnit(brigName + " tank 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        TankUnit tank_02 = new TankUnit(brigName + " tank 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);

        MotoArtiUnit art_01 = new MotoArtiUnit(brigName + " art 1", acronym + "•1", CountryEnum.RED_COUNTRY, false, false, false, 1);
        MotoArtiUnit art_02 = new MotoArtiUnit(brigName + " art 2", acronym + "•2", CountryEnum.RED_COUNTRY, false, false, false, 2);

        brigade.addUnit(inf_01_01);
        brigade.addUnit(inf_02_01);
        brigade.addUnit(inf_03_01);

        brigade.addUnit(tank_01);
        brigade.addUnit(tank_02);

        brigade.addUnit(art_01);
        brigade.addUnit(art_02);

        return brigade;
    }
}
