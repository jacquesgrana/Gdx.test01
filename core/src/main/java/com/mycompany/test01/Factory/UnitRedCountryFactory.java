package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Interface.UnitFactoryInterface;

public class UnitRedCountryFactory implements UnitFactoryInterface {

    public InfantryUnit createInfantryUnit(String name) {
        return new InfantryUnit(name, CountryEnum.RED_COUNTRY);
    }

    public FrontGroup createFrontGroup(String name) {
        return new FrontGroup(name, CountryEnum.RED_COUNTRY);
    }

    public ArmyGroupGroup createArmyGroupGroup(String name) {
        return new ArmyGroupGroup(name, CountryEnum.RED_COUNTRY);
    }

    public ArmyGroup createArmyGroup(String name) {
        return new ArmyGroup(name, CountryEnum.RED_COUNTRY);
    }

    public DivisionGroup createDivisionGroup(String name) {
        return new DivisionGroup(name, CountryEnum.RED_COUNTRY);
    }

    public BrigadeGroup createBrigadeGroup(String name) {
        return new BrigadeGroup(name, CountryEnum.RED_COUNTRY);
    }
}
