package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, int regRank) {
        return new InfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, regRank);
    }

    @Override
    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new CavalryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new ParaUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MarineUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, int regRank) {
        return new EngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, regRank);
    }


    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, int regRank) {
        return new ArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite,  regRank);
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new TankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MecaInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public MotoInfUnit createMotoInfUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, regRank);
    }

    public MotoEngineerUnit createMotoEngineerUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoEngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, regRank);
    }

    @Override
    public MotoArtiUnit createMotoArtiUnit(String name, String acronym, boolean isElite, int regRank) {
        return new MotoArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite,  regRank);
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new MecaRecoUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new AntiTankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean isMotorised, int regRank) {
        return new AntiAirUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised, regRank);
    }

    @Override
    public FrontGroup createFrontGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new FrontGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ArmyGroupGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public ArmyGroup createArmyGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ArmyGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new DivisionGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new BrigadeGroup(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public DivisionGroup createInfDivision(String divName, String acronym) {
        DivisionGroup division = new DivisionGroup(divName, acronym, CountryEnum.RED_COUNTRY, false, false );
        // 3 * 3 inf
        InfantryUnit inf_01_01 = new InfantryUnit(divName + " inf 1-1", acronym + "b1", CountryEnum.RED_COUNTRY, false, 1);
        InfantryUnit inf_02_01 = new InfantryUnit(divName + " inf 2-1", acronym + "b1", CountryEnum.RED_COUNTRY, false, 2);
        InfantryUnit inf_03_01 = new InfantryUnit(divName + " inf 3-1", acronym + "b1", CountryEnum.RED_COUNTRY, false, 3);
        InfantryUnit inf_01_02 = new InfantryUnit(divName + " inf 1-2", acronym + "b2", CountryEnum.RED_COUNTRY, false, 1);
        InfantryUnit inf_02_02 = new InfantryUnit(divName + " inf 2-2", acronym + "b2", CountryEnum.RED_COUNTRY, false, 2);
        InfantryUnit inf_03_02 = new InfantryUnit(divName + " inf 3-2", acronym + "b2", CountryEnum.RED_COUNTRY, false, 3);
        InfantryUnit inf_01_03 = new InfantryUnit(divName + " inf 1-3", acronym + "b3", CountryEnum.RED_COUNTRY, false, 1);
        InfantryUnit inf_02_03 = new InfantryUnit(divName + " inf 2-3", acronym + "b3", CountryEnum.RED_COUNTRY, false, 2);
        InfantryUnit inf_03_03 = new InfantryUnit(divName + " inf 3-3", acronym + "b3", CountryEnum.RED_COUNTRY, false, 3);
        // 3 art
        ArtiUnit art_01 = new ArtiUnit(divName + " art 1", acronym, CountryEnum.RED_COUNTRY, false, 1);
        ArtiUnit art_02 = new ArtiUnit(divName + " art 2", acronym, CountryEnum.RED_COUNTRY, false, 2);
        ArtiUnit art_03 = new ArtiUnit(divName + " art 3", acronym, CountryEnum.RED_COUNTRY, false, 3);
        // 1 Anti tank
        AntiTankUnit anti_tank_01 = new AntiTankUnit(divName + " anti_tank", acronym, CountryEnum.RED_COUNTRY, false, false, 0);
        // 1 Eng
        EngineerUnit engineer_01 = new EngineerUnit(divName + " engineer", acronym, CountryEnum.RED_COUNTRY, false, 0);
        // todo 1 reco company

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

        return division;
    }
}
