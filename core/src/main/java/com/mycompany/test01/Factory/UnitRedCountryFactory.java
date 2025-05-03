package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    @Override
    public InfantryUnit createInfantryUnit(String name, boolean isElite) {
        return new InfantryUnit(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public ArtiUnit createArtiUnit(String name, boolean isElite) {
        return new ArtiUnit(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public TankUnit createTankUnit(String name, boolean isElite) {
        return new TankUnit(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public FrontGroup createFrontGroup(String name, boolean isElite) {
        return new FrontGroup(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public ArmyGroupGroup createArmyGroupGroup(String name, boolean isElite) {
        return new ArmyGroupGroup(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public ArmyGroup createArmyGroup(String name, boolean isElite) {
        return new ArmyGroup(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public DivisionGroup createDivisionGroup(String name, boolean isElite) {
        return new DivisionGroup(name, CountryEnum.RED_COUNTRY, isElite);
    }

    @Override
    public BrigadeGroup createBrigadeGroup(String name, boolean isElite) {
        return new BrigadeGroup(name, CountryEnum.RED_COUNTRY, isElite);
    }
}
