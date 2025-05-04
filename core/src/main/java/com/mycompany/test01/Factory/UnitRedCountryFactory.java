package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    @Override
    public InfantryUnit createInfantryUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new InfantryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    public CavalryUnit createCavalryUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new CavalryUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public ParaUnit createParaUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ParaUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public MarineUnit createMarineUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new MarineUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public EngineerUnit createEngineerUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new EngineerUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }


    @Override
    public ArtiUnit createArtiUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new ArtiUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public TankUnit createTankUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new TankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public MecaInfUnit createMecaInfUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new MecaInfUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public MecaRecoUnit createMecaRecoUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new MecaRecoUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public AntiTankUnit createAntiTankUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new AntiTankUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
    }

    @Override
    public AntiAirUnit createAntiAirUnit(String name, String acronym, boolean isElite, boolean isMotorised) {
        return new AntiAirUnit(name, acronym, CountryEnum.RED_COUNTRY, isElite, isMotorised);
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
}
