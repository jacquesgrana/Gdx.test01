package com.mycompany.test01.Factory.Unit;

import com.mycompany.test01.Entity.Unit.ArtiUnit.*;
import com.mycompany.test01.Entity.Unit.CombatUnit.*;
import com.mycompany.test01.Entity.Unit.Group.*;
import com.mycompany.test01.Entity.Unit.NonCombatUnit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Factory.ArtiProps.ArtiPropsYellowCountryFactory;
import com.mycompany.test01.Factory.CombatProps.CombatPropsYellowCountryFactory;
import com.mycompany.test01.Interface.unit.ArtiPropsFactoryInterface;
import com.mycompany.test01.Interface.unit.CombatPropsFactoryInterface;
import com.mycompany.test01.Interface.unit.UnitFactoryInterface;

public class UnitYellowCountryFactory implements UnitFactoryInterface {
    private final CountryEnum country = CountryEnum.YELLOW_COUNTRY;
    private final CombatPropsFactoryInterface combatPropsFactory = new CombatPropsYellowCountryFactory();
    private final ArtiPropsFactoryInterface artiPropsFactory = new ArtiPropsYellowCountryFactory();

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke,  int regRank) {
        return new InfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getInfantryMediumCombatProps());
    }

    @Override
    public MountainInfantryUnit createMountainInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MountainInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMountainInfantryMediumCombatProps());
    }

    @Override
    public MountainArtiUnit createMountainArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MountainArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMountainArtiMediumCombatProps(), artiPropsFactory.getMountainArtiMedium());
    }

    @Override
    public SkiInfantryUnit createSkiInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getSkiInfantryMediumCombatProps());
    }

    @Override
    public SkiMachineGunUnit createSkiMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new SkiMachineGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getSkiMachineGunMediumCombatProps());
    }

    @Override
    public GliderInfantryUnit createGliderInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new GliderInfantryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getGliderInfMediumCombatProps());
    }

    @Override
    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new CavalryUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getCavalryInfMediumCombatProps());
    }

    @Override
    public ParaInfUnit createParaInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getParaInfMediumCombatProps());
    }

    @Override
    public MarineInfUnit createMarineInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MarineInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMarineInfMediumCombatProps());
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new EngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getEngineerInfMediumCombatProps());
    }

    @Override
    public CivilEngineerUnit createCivilEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new CivilEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getCivilEngineerMediumCombatProps());
    }

    @Override
    public BridgeEngineerUnit createBridgeEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new BridgeEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getBridgeEngineerMediumCombatProps());
    }

    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
    }

    @Override
    public MortarArtiUnit createMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMortarArtiMediumCombatProps(), artiPropsFactory.getMortarMedium());
    }

    @Override
    public MotoMortarArtiUnit createMotoMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoMortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoMortarArtiMediumCombatProps(), artiPropsFactory.getMortarMedium());
    }

    @Override
    public RocketArtiUnit createRocketArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new RocketArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getRocketArtiMediumCombatProps(), artiPropsFactory.getRocketMedium());
    }

    @Override
    public ParaArtiUnit createParaArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getParaArtiMediumCombatProps(), artiPropsFactory.getParaArtiMedium());
    }

    @Override
    public ParaMortarArtiUnit createParaMortarArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new ParaMortarArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getParaMortarArtiMediumCombatProps(), artiPropsFactory.getMortarHigh());
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new TankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getTankMediumCombatProps());
    }

    @Override
    public HeavyTankUnit createHeavyTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new HeavyTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getHeavyTankMediumCombatProps());
    }


    @Override
    public AssaultGunUnit createAssaultGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank){
        return new AssaultGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getAssaultGunMediumCombatProps());
    }


    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMecaInfMediumCombatProps());
    }

    @Override
    public MecaArtiUnit createMecaArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMecaArtiMediumCombatProps(), artiPropsFactory.getMecaArtiMedium());
    }

    @Override
    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoInfMediumCombatProps());
    }

    @Override
    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoEngineerInfMediumCombatProps());
    }

    @Override
    public MotoCivilEngineerUnit createMotoCivilEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoCivilEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoCivilEngineerMediumCombatProps());
    }

    @Override
    public MotoBridgeEngineerUnit createMotoBridgeEngineerUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return  new MotoBridgeEngineerUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoBridgeEngineerMediumCombatProps());
    }

    @Override
    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
    }

    @Override
    public MotoRocketArtiUnit createMotoRocketArtiUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoRocketArtiUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoRocketArtiMediumCombatProps(), artiPropsFactory.getRocketMedium());
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MecaRecoUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMecaRecoMediumCombatProps());
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getAntiTankMediumCombatProps());
    }

    @Override
    public MotoAntiTankUnit createMotoAntiTankUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiTankUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoAntiTankMediumCombatProps());
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new AntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getAntiAirMediumCombatProps());
    }

    @Override
    public MotoAntiAirUnit createMotoAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoAntiAirMediumCombatProps());
    }

    @Override
    public HeavyAntiAirUnit createHeavyAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new HeavyAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getHeavyAntiAirMediumCombatProps());
    }

    @Override
    public MotoHeavyAntiAirUnit createMotoHeavyAntiAirUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoHeavyAntiAirUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotoHeavyAntiAirMediumCombatProps());
    }

    @Override
    public MachineGunUnit createMachineGunUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MachineGunUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMachineGunMediumCombatProps());
    }

    @Override
    public BicycleInfUnit createBicycleUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new BicycleInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getBicycleInfMediumCombatProps());
    }

    @Override
    public MotorcycleInfUnit createMotorcycleInfUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotorcycleInfUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getMotorcyleInfMediumCombatProps());
    }

    @Override
    public LogisticUnit createLogisticUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank)
    {
        return new LogisticUnit(name, acronym, this.country, isElite, false, usesWhiteStroke, regRank, combatPropsFactory.getLogisticMediumCombatProps());
    }

    @Override
    public InfantryRecoCompanyUnit createInfRecoCompanyUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new InfantryRecoCompanyUnit(name, acronym, this.country, isElite, usesWhiteStroke, regRank, combatPropsFactory.getInfantryRecoCompMediumCombatProps());
    }

    @Override
    public MotoInfRecoCompanyUnit createMotoInfRecoCompanyUnit(String name, String acronym, boolean isElite, boolean usesWhiteStroke, int regRank) {
        return new MotoInfRecoCompanyUnit(name, acronym, this.country, isElite, usesWhiteStroke, regRank, combatPropsFactory.getMotoInfRecoCompMediumCombatProps());
    }



    @Override
    public FrontGroup createFrontGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new FrontGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke, combatPropsFactory.getHeadQuarterMediumCombatProps());
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroupGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke, combatPropsFactory.getHeadQuarterMediumCombatProps());
    }

    @Override
    public ArmyGroup createArmyGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new ArmyGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke, combatPropsFactory.getHeadQuarterMediumCombatProps());
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new DivisionGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke, combatPropsFactory.getHeadQuarterMediumCombatProps());
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isPara, boolean isElite, boolean isMotorised, boolean usesWhiteStroke) {
        return new BrigadeGroup(name, acronym, this.country, isPara, isElite, isMotorised, usesWhiteStroke, combatPropsFactory.getHeadQuarterMediumCombatProps());
    }


    @Override
    public DivisionGroup createInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, false, false, false, combatPropsFactory.getHeadQuarterMediumCombatProps());
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", this.country, false, false, false, 1, combatPropsFactory.getInfantryMediumCombatProps());
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", this.country, false, false, false, 2, combatPropsFactory.getInfantryMediumCombatProps());
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", this.country, false, false, false, 1, combatPropsFactory.getInfantryMediumCombatProps());
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", this.country, false, false, false, 2, combatPropsFactory.getInfantryMediumCombatProps());
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", this.country, false, false, false, 1, combatPropsFactory.getInfantryMediumCombatProps());
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", this.country, false, false, false, 2, combatPropsFactory.getInfantryMediumCombatProps());
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", this.country, false, false, false, 1, combatPropsFactory.getArtiHighCombatProps(), artiPropsFactory.getArtiMediumRangeHigh());
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", this.country, false, false, false, 2, combatPropsFactory.getArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", this.country, false, false, false, 3, combatPropsFactory.getArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, this.country, false, false, false, 0, combatPropsFactory.getAntiTankMediumCombatProps());

        AntiAirUnit anti_air_01 = new AntiAirUnit(divName + " anti_air", acronym, this.country, false, false, false, 0, combatPropsFactory.getAntiAirMediumCombatProps());
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, this.country, false, false, false, 0, combatPropsFactory.getEngineerInfMediumCombatProps());

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, this.country, false, false, 0, combatPropsFactory.getEngineerInfMediumCombatProps());

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
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, true, false, true, combatPropsFactory.getHeadQuarterEliteCombatProps());
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", this.country, true, false, true, 1, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", this.country, true, false, true, 2, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", this.country, true, false, true, 3, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_04_01 = new InfantryUnit(divName + " inf 4-1", acronym + "•1•4", this.country, true, false, true, 4, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", this.country, true, false, true, 1, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", this.country, true, false, true, 2, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", this.country, true, false, true, 3, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_04_02 = new InfantryUnit(divName + " inf 4-2", acronym + "•2•4", this.country, true, false, true, 4, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", this.country, true, false, true, 1, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", this.country, true, false, true, 2, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", this.country, true, false, true, 3, combatPropsFactory.getInfantryEliteCombatProps());
        InfantryUnit inf_04_03 = new InfantryUnit(divName + " inf 4-3", acronym + "•3•4", this.country, true, false, true, 4, combatPropsFactory.getInfantryEliteCombatProps());
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", this.country, true, false, true, 1, combatPropsFactory.getArtiEliteCombatProps(), artiPropsFactory.getArtiMediumRangeElite());
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", this.country, true, false, true, 2, combatPropsFactory.getArtiHighCombatProps(), artiPropsFactory.getArtiMediumRangeHigh());
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", this.country, true, false, true, 3, combatPropsFactory.getArtiHighCombatProps(), artiPropsFactory.getArtiMediumRangeHigh());
        MortarArtiUnit art_04 = new MortarArtiUnit(divName + " mortar art 4", acronym + "•4", this.country, true, false, true, 4, combatPropsFactory.getMortarArtiHighCombatProps(), artiPropsFactory.getMortarHigh());
        MortarArtiUnit art_05 = new MortarArtiUnit(divName + " mortar art 5", acronym + "•5", this.country, true, false, true, 5, combatPropsFactory.getMortarArtiHighCombatProps(), artiPropsFactory.getMortarHigh());

        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, this.country, true, false, true, 0, combatPropsFactory.getAntiTankEliteCombatProps());
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, this.country, true, false, true, 0, combatPropsFactory.getEngineerInfEliteCombatProps());

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, this.country, true, true, 0, combatPropsFactory.getInfantryRecoCompEliteCombatProps());


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
        DivisionGroup division = new DivisionGroup(divName, acronym, this.country, false, false, true, false, combatPropsFactory.getHeadQuarterMediumCombatProps());

        // 3 * 3 inf
        MotoInfUnit inf_01_01 = new MotoInfUnit(divName + " inf 1-1", acronym + "•1•1", this.country, false, false, false, 1, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_02_01 = new MotoInfUnit(divName + " inf 2-1", acronym + "•1•2", this.country, false, false, false, 2, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_03_01 = new MotoInfUnit(divName + " inf 3-1", acronym + "•1•3", this.country, false, false, false, 3, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_01_02 = new MotoInfUnit(divName + " inf 1-2", acronym + "•2•1", this.country, false, false, false, 1, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_02_02 = new MotoInfUnit(divName + " inf 2-2", acronym + "•2•2", this.country, false, false, false, 2, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_03_02 = new MotoInfUnit(divName + " inf 3-2", acronym + "•2•3", this.country, false, false, false, 3, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_01_03 = new MotoInfUnit(divName + " inf 1-3", acronym + "•3•1", this.country, false, false, false, 1, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_02_03 = new MotoInfUnit(divName + " inf 2-3", acronym + "•3•2", this.country, false, false, false, 2, combatPropsFactory.getMotoInfMediumCombatProps());
        MotoInfUnit inf_03_03 = new MotoInfUnit(divName + " inf 3-3", acronym + "•3•3", this.country, false, false, false, 3, combatPropsFactory.getMotoInfMediumCombatProps());
        // 3 tanks
        TankUnit tank_01 = new TankUnit(divName + " tank 1", acronym + "•1", this.country, false, false, false, 1, combatPropsFactory.getTankMediumCombatProps());
        TankUnit tank_02 = new TankUnit(divName + " tank 2", acronym + "•2", this.country, false, false, false, 2, combatPropsFactory.getTankMediumCombatProps());
        TankUnit tank_03 = new TankUnit(divName + " tank 3", acronym + "•3", this.country, false, false, false, 3, combatPropsFactory.getTankMediumCombatProps());
        // 3 art
        MotoArtiUnit art_01 = new MotoArtiUnit(divName + " art 1", acronym + "•1", this.country, false, false, false, 1, combatPropsFactory.getMotoArtiHighCombatProps(), artiPropsFactory.getArtiMediumRangeHigh());
        MotoArtiUnit art_02 = new MotoArtiUnit(divName + " art 2", acronym + "•2", this.country, false, false, false, 2, combatPropsFactory.getMotoArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
        MotoArtiUnit art_03 = new MotoArtiUnit(divName + " art 3", acronym + "•3", this.country, false, false, false, 3, combatPropsFactory.getMotoArtiMediumCombatProps(), artiPropsFactory.getArtiMediumRangeMedium());
        // 1 Anti tank
        MotoAntiTankUnit anti_tank_01 = new MotoAntiTankUnit(divName + " anti_tank", acronym, this.country, false, false, false, 0, combatPropsFactory.getMotoArtiMediumCombatProps());
        // 1 Eng
        MotoAntiAirUnit anti_air_01 = new MotoAntiAirUnit(divName + " anti_air", acronym, this.country, false, false, false, 0, combatPropsFactory.getMotoAntiAirMediumCombatProps());
        MotoHeavyAntiAirUnit heavy_anti_air_01 = new MotoHeavyAntiAirUnit(divName + " heavy_anti_air", acronym, this.country, false, false, false, 0, combatPropsFactory.getMotoHeavyAntiAirMediumCombatProps());

        MotoEngineerUnit engineer_01 = new MotoEngineerUnit(divName + " engineer", acronym, this.country, false, false, false, 0, combatPropsFactory.getMotoEngineerInfMediumCombatProps());

        MotoInfRecoCompanyUnit reco_company = new MotoInfRecoCompanyUnit(divName + " reco", acronym, this.country, false, false, 0, combatPropsFactory.getMotoInfRecoCompMediumCombatProps());


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
