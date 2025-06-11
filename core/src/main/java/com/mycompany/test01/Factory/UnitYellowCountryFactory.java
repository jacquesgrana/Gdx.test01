package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.ArtiUnit.*;
import com.mycompany.test01.Entity.Unit.CombatUnit.*;
import com.mycompany.test01.Entity.Unit.Group.*;
import com.mycompany.test01.Entity.Unit.NonCombatUnit.*;
import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitYellowCountryFactory implements UnitFactoryInterface {
    private final CountryEnum country = CountryEnum.YELLOW_COUNTRY;

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke,  int regRank) {
        return new InfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MountainInfantryUnit createMountainInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MountainInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MountainArtiUnit createMountainArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MountainArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(6, 3, 2, 6));
    }

    @Override
    public SkiInfantryUnit createSkiInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public SkiMachineGunUnit createSkiMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiMachineGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public GliderInfantryUnit createGliderInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new GliderInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new CavalryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public ParaInfUnit createParaInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MarineInfUnit createMarineInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MarineInfUnit(name, acronym, this.country, isElite,false, usesWhiteStroke, regRank);
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new EngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public CivilEngineerUnit createCivilEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new CivilEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public BridgeEngineerUnit createBridgeEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new BridgeEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(10, 2, 1, 6));
    }

    @Override
    public MortarArtiUnit createMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(3, 3, 2, 3));
    }

    @Override
    public MotoMortarArtiUnit createMotoMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoMortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(3, 2, 1, 4));
    }

    @Override
    public RocketArtiUnit createRocketArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new RocketArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(7, 9, 3, 4));
    }

    @Override
    public ParaArtiUnit createParaArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(9, 4, 2, 6));
    }

    @Override
    public ParaMortarArtiUnit createParaMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaMortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(4, 4, 2, 4));
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new TankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public HeavyTankUnit createHeavyTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new HeavyTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }


    @Override
    public AssaultGunUnit createAssaultGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank){
        return new AssaultGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }


    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MecaArtiUnit createMecaArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(7, 5, 3, 3));
    }

    @Override
    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoCivilEngineerUnit createMotoCivilEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoCivilEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoBridgeEngineerUnit createMotoBridgeEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new MotoBridgeEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(10, 2, 1, 6));
    }

    @Override
    public MotoRocketArtiUnit createMotoRocketArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoRocketArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, new ArtiProps(5, 10,4, 4));
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaRecoUnit(name, acronym, this.country, isElite,false, usesWhiteStroke, regRank);
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoAntiTankUnit createMotoAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoAntiAirUnit createMotoAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public HeavyAntiAirUnit createHeavyAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new HeavyAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotoHeavyAntiAirUnit createMotoHeavyAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoHeavyAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MachineGunUnit createMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MachineGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public BicycleInfUnit createBicycleUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new BicycleInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public MotorcycleInfUnit createMotorcycleInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotorcycleInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public LogisticUnit createLogisticUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank)
    {
        return new LogisticUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank);
    }

    @Override
    public InfantryRecoCompanyUnit createInfRecoCompanyUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new InfantryRecoCompanyUnit(name, acronym, this.country, isElite, usesWhiteStroke, regRank);
    }

    @Override
    public MotoInfRecoCompanyUnit createMotoInfRecoCompanyUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoInfRecoCompanyUnit(name, acronym, this.country, isElite, usesWhiteStroke, regRank);
    }



    @Override
    public FrontGroup createFrontGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new FrontGroup(name, acronym, this.country,isPara, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroupGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public ArmyGroup createArmyGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new DivisionGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke);
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new BrigadeGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke);
    }


    @Override
    public DivisionGroup createInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, false, false, false );
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", this.country, false, false, false, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", this.country, false, false, false, 2);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", this.country, false, false, false, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", this.country, false, false, false, 2);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", this.country, false, false, false, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", this.country, false, false, false, 2);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", this.country, false, false, false, 1, new ArtiProps(12, 4, 2, 12));
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", this.country, false, false, false, 2, new ArtiProps(10, 2, 1, 6));
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", this.country, false, false, false, 3, new ArtiProps(10, 2, 1, 6));
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, this.country, false, false, false, 0);

        AntiAirUnit anti_air_01 = new AntiAirUnit(divName + " anti_air", acronym, this.country, false, false, false, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, this.country, false, false, false, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, this.country, false, false, 0);

        division.addUnit(inf_01_01);
        division.addUnit(inf_02_01);
        division.addUnit(inf_01_02);
        division.addUnit(inf_02_02);
        division.addUnit(inf_01_03);
        division.addUnit(inf_02_03);

        division.addUnit(art_01);
        division.addUnit(art_02);
        division.addUnit(art_03);

        division.addUnit(anti_tank_01);
        division.addUnit(anti_air_01);
        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }

    @Override
    public DivisionGroup createEliteInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, true, false, true );
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", this.country, true, false, true, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", this.country, true, false, true, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", this.country, true, false, true, 3);
        InfantryUnit inf_04_01 = new InfantryUnit(divName + " inf 4-1", acronym + "•1•4", this.country, true, false, true, 4);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", this.country, true, false, true, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", this.country, true, false, true, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", this.country, true, false, true, 3);
        InfantryUnit inf_04_02 = new InfantryUnit(divName + " inf 4-2", acronym + "•2•4", this.country, true, false, true, 4);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", this.country, true, false, true, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", this.country, true, false, true, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", this.country, true, false, true, 3);
        InfantryUnit inf_04_03 = new InfantryUnit(divName + " inf 4-3", acronym + "•3•4", this.country, true, false, true, 4);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", this.country, true, false, true, 1, new ArtiProps(14, 5, 3, 12));
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", this.country, true, false, true, 2, new ArtiProps(12, 3, 2, 6));
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", this.country, true, false, true, 3, new ArtiProps(12, 3, 2, 6));
        MortarArtiUnit art_04 = new MortarArtiUnit(divName + " mortar art 4", acronym + "•4", this.country, true, false, true, 4,  new ArtiProps(3, 3, 2, 3));
        MortarArtiUnit art_05 = new MortarArtiUnit(divName + " mortar art 5", acronym + "•5", this.country, true, false, true, 5,  new ArtiProps(3, 3, 2, 3));

        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, this.country, true, false, true, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, this.country, true, false, true, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, this.country, true, true, 0);


        division.addUnit(inf_01_01);
        division.addUnit(inf_02_01);
        division.addUnit(inf_03_01);
        division.addUnit(inf_04_01);
        division.addUnit(inf_01_02);
        division.addUnit(inf_02_02);
        division.addUnit(inf_03_02);
        division.addUnit(inf_04_02);
        division.addUnit(inf_01_03);
        division.addUnit(inf_02_03);
        division.addUnit(inf_03_03);
        division.addUnit(inf_04_03);

        division.addUnit(art_01);
        division.addUnit(art_02);
        division.addUnit(art_03);
        division.addUnit(art_04);
        division.addUnit(art_05);
        division.addUnit(anti_tank_01);
        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }

    public DivisionGroup createMotoInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, false, true, false);

        // 3 * 3 inf
        MotoInfUnit inf_01_01 = new MotoInfUnit(divName + " inf 1-1", acronym + "•1•1", this.country, false, false, false, 1);
        MotoInfUnit inf_02_01 = new MotoInfUnit(divName + " inf 2-1", acronym + "•1•2", this.country, false, false, false, 2);
        MotoInfUnit inf_03_01 = new MotoInfUnit(divName + " inf 3-1", acronym + "•1•3", this.country, false, false, false, 3);
        MotoInfUnit inf_01_02 = new MotoInfUnit(divName + " inf 1-2", acronym + "•2•1", this.country, false, false, false, 1);
        MotoInfUnit inf_02_02 = new MotoInfUnit(divName + " inf 2-2", acronym + "•2•2", this.country, false, false, false, 2);
        MotoInfUnit inf_03_02 = new MotoInfUnit(divName + " inf 3-2", acronym + "•2•3", this.country, false, false, false, 3);
        MotoInfUnit inf_01_03 = new MotoInfUnit(divName + " inf 1-3", acronym + "•3•1", this.country, false, false, false, 1);
        MotoInfUnit inf_02_03 = new MotoInfUnit(divName + " inf 2-3", acronym + "•3•2", this.country, false, false, false, 2);
        MotoInfUnit inf_03_03 = new MotoInfUnit(divName + " inf 3-3", acronym + "•3•3", this.country, false, false, false, 3);
        // 3 tanks
        TankUnit tank_01 = new TankUnit(divName + " tank 1", acronym + "•1", this.country, false, false, false, 1);
        TankUnit tank_02 = new TankUnit(divName + " tank 2", acronym + "•2", this.country, false, false, false, 2);
        TankUnit tank_03 = new TankUnit(divName + " tank 3", acronym + "•3", this.country, false, false, false, 3);
        // 3 art
        MotoArtiUnit art_01 = new MotoArtiUnit(divName + " art 1", acronym + "•1", this.country, false, false, false, 1, new ArtiProps(12, 4, 2, 12));
        MotoArtiUnit art_02 = new MotoArtiUnit(divName + " art 2", acronym + "•2", this.country, false, false, false, 2, new ArtiProps(10, 2, 1, 6));
        MotoArtiUnit art_03 = new MotoArtiUnit(divName + " art 3", acronym + "•3", this.country, false, false, false, 3, new ArtiProps(10, 2, 1, 6));
        // 1 Anti tank
        MotoAntiTankUnit anti_tank_01 = new MotoAntiTankUnit(divName + " anti_tank", acronym, this.country, false, false, false, 0);
        // 1 Eng
        MotoAntiAirUnit anti_air_01 = new MotoAntiAirUnit(divName + " anti_air", acronym, this.country, false, false, false, 0);
        MotoHeavyAntiAirUnit heavy_anti_air_01 = new MotoHeavyAntiAirUnit(divName + " heavy_anti_air", acronym, this.country, false, false, false, 0);

        MotoEngineerUnit engineer_01 = new MotoEngineerUnit(divName + " engineer", acronym, this.country, false, false, false, 0);

        MotoInfRecoCompanyUnit reco_company = new MotoInfRecoCompanyUnit(divName + " reco", acronym, this.country, false, false, 0);


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
        division.addUnit(anti_air_01);
        division.addUnit(heavy_anti_air_01);

        division.addUnit(engineer_01);

        division.addUnit(reco_company);

        return division;
    }
}
