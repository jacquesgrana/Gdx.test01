package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitBlackCountryFactory implements UnitFactoryInterface {

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, int regRank) {
        return new InfantryUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new CavalryUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new ParaUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MarineUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, int regRank) {
        return new EngineerUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }


    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, int regRank) {
        return new ArtiUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false,  regRank);
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new TankUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MecaInfUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoInfUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoEngineerUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoArtiUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false,  regRank);
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MecaRecoUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised, false, regRank);
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, int regRank) {
        return new AntiTankUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public MotoAntiTankUnit createMotoAntiTankUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoAntiTankUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, int regRank) {
        return new AntiAirUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public MotoAntiAirUnit createMotoAntiAirUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoAntiAirUnit(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, false, regRank);
    }

    @Override
    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new FrontGroup(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised);
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ArmyGroupGroup(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised);
    }

    @Override
    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ArmyGroup(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised);
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new DivisionGroup(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised);
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new BrigadeGroup(name, acronym, CountryEnum.BLACK_COUNTRY, isElite, isMotorised);
    }

    @Override
    public DivisionGroup createInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.BLACK_COUNTRY, false, false );
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, CountryEnum.BLACK_COUNTRY, false, false, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, CountryEnum.BLACK_COUNTRY, false, false, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, CountryEnum.BLACK_COUNTRY, false, false, 0);

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
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.BLACK_COUNTRY, true, false );
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.BLACK_COUNTRY, true, false, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.BLACK_COUNTRY, true, false, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.BLACK_COUNTRY, true, false, 3);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.BLACK_COUNTRY, true, false, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.BLACK_COUNTRY, true, false, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.BLACK_COUNTRY, true, false, 3);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.BLACK_COUNTRY, true, false, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.BLACK_COUNTRY, true, false, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.BLACK_COUNTRY, true, false, 3);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.BLACK_COUNTRY, true, false, 1);
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.BLACK_COUNTRY, true, false, 2);
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.BLACK_COUNTRY, true, false, 3);
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, CountryEnum.BLACK_COUNTRY, true, false, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, CountryEnum.BLACK_COUNTRY, true, false, 0);

        // todo 1 reco inf company
        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, CountryEnum.BLACK_COUNTRY, true, false, 0);


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
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.BLACK_COUNTRY, false, true);

        // 3 * 3 inf
        MotoInfUnit inf_01_01 = new MotoInfUnit(divName + " inf 1-1", acronym + "•1•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        MotoInfUnit inf_02_01 = new MotoInfUnit(divName + " inf 2-1", acronym + "•1•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        MotoInfUnit inf_03_01 = new MotoInfUnit(divName + " inf 3-1", acronym + "•1•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        MotoInfUnit inf_01_02 = new MotoInfUnit(divName + " inf 1-2", acronym + "•2•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        MotoInfUnit inf_02_02 = new MotoInfUnit(divName + " inf 2-2", acronym + "•2•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        MotoInfUnit inf_03_02 = new MotoInfUnit(divName + " inf 3-2", acronym + "•2•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        MotoInfUnit inf_01_03 = new MotoInfUnit(divName + " inf 1-3", acronym + "•3•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        MotoInfUnit inf_02_03 = new MotoInfUnit(divName + " inf 2-3", acronym + "•3•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        MotoInfUnit inf_03_03 = new MotoInfUnit(divName + " inf 3-3", acronym + "•3•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        // 3 art
        MotoArtiUnit art_01 = new MotoArtiUnit(divName + " art 1", acronym + "•1", CountryEnum.BLACK_COUNTRY, false, false, 1);
        MotoArtiUnit art_02 = new MotoArtiUnit(divName + " art 2", acronym + "•2", CountryEnum.BLACK_COUNTRY, false, false, 2);
        MotoArtiUnit art_03 = new MotoArtiUnit(divName + " art 3", acronym + "•3", CountryEnum.BLACK_COUNTRY, false, false, 3);
        // 1 Anti tank
        MotoAntiTankUnit anti_tank_01 = new MotoAntiTankUnit(divName + " anti_tank", acronym, CountryEnum.BLACK_COUNTRY, false, false, 0);
        // 1 Eng
        MotoEngineerUnit engineer_01 = new MotoEngineerUnit(divName + " engineer", acronym, CountryEnum.BLACK_COUNTRY, false, false, 0);

        InfantryRecoCompanyUnit reco_company = new InfantryRecoCompanyUnit(divName + " reco", acronym, CountryEnum.BLACK_COUNTRY, false, true, 0);


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
}
