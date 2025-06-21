package com.mycompany.test01.Factory.Airplane;

import com.mycompany.test01.Entity.Airplane.Bomber.HeavyBomberSquadron;
import com.mycompany.test01.Entity.Airplane.Bomber.LightBomberSquadron;
import com.mycompany.test01.Entity.Airplane.Bomber.MediumBomberSquadron;
import com.mycompany.test01.Entity.Airplane.Fighter.HeavyFighterSquadron;
import com.mycompany.test01.Entity.Airplane.Fighter.LightFighterSquadron;
import com.mycompany.test01.Entity.Airplane.Fighter.MediumFighterSquadron;
import com.mycompany.test01.Entity.Airplane.Observer.LightObserverSquadron;
import com.mycompany.test01.Entity.Airplane.Observer.MediumObserverSquadron;
import com.mycompany.test01.Entity.Airplane.Transport.HeavyTransportSquadron;
import com.mycompany.test01.Entity.Airplane.Transport.MediumTransportSquadron;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Factory.AirplaneProps.AirplanePropsBlackCountryFactory;
import com.mycompany.test01.Factory.AirplaneProps.AirplanePropsRedCountryFactory;
import com.mycompany.test01.Factory.BomberProps.BomberPropsBlackCountryFactory;
import com.mycompany.test01.Factory.BomberProps.BomberPropsRedCountryFactory;
import com.mycompany.test01.Factory.ObserverProps.ObserverPropsBlackCountryFactory;
import com.mycompany.test01.Factory.ObserverProps.ObserverPropsRedCountryFactory;
import com.mycompany.test01.Factory.TransportProps.TransportPropsBlackCountryFactory;
import com.mycompany.test01.Factory.TransportProps.TransportPropsRedCountryFactory;
import com.mycompany.test01.Interface.*;

public class AirplaneSquadronRedCountryFactory implements AirplaneSquadronFactoryInterface {
    private final CountryEnum country = CountryEnum.RED_COUNTRY;
    private final AirplanePropsFactoryInterface airplanePropsFactory = new AirplanePropsRedCountryFactory();
    private final BomberPropsFactoryInterface bomberPropsFactory = new BomberPropsRedCountryFactory();
    private final ObserverPropsFactoryInterface observerPropsFactory = new ObserverPropsRedCountryFactory();
    private final TransportPropsFactoryInterface transportPropsFactory = new TransportPropsRedCountryFactory();

    @Override
    public LightFighterSquadron createLightFighterSquadronLow(String name, String acronym) {
        return new LightFighterSquadron(
            name, acronym, country, airplanePropsFactory.getLightFighterLow()
        );
    }

    @Override
    public LightFighterSquadron createLightFighterSquadronMedium(String name, String acronym) {
        return new LightFighterSquadron(
            name, acronym, country, airplanePropsFactory.getLightFighterMedium()
        );
    }

    @Override
    public LightFighterSquadron createLightFighterSquadronHigh(String name, String acronym) {
        return new LightFighterSquadron(
            name, acronym, country, airplanePropsFactory.getLightFighterHigh()
        );
    }

    @Override
    public MediumFighterSquadron createMediumFighterSquadronLow(String name, String acronym) {
        return new MediumFighterSquadron(
            name, acronym, country, airplanePropsFactory.getMediumFighterLow()
        );
    }

    @Override
    public MediumFighterSquadron createMediumFighterSquadronMedium(String name, String acronym) {
        return new MediumFighterSquadron(
            name, acronym, country, airplanePropsFactory.getMediumFighterMedium()
        );
    }

    @Override
    public MediumFighterSquadron createMediumFighterSquadronHigh(String name, String acronym) {
        return new MediumFighterSquadron(
            name, acronym, country, airplanePropsFactory.getMediumFighterHigh()
        );
    }

    @Override
    public HeavyFighterSquadron createHeavyFighterSquadronLow(String name, String acronym) {
        return new HeavyFighterSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyFighterLow()
        );
    }

    @Override
    public HeavyFighterSquadron createHeavyFighterSquadronMedium(String name, String acronym) {
        return new HeavyFighterSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyFighterMedium()
        );
    }

    @Override
    public HeavyFighterSquadron createHeavyFighterSquadronHigh(String name, String acronym) {
        return new HeavyFighterSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyFighterHigh()
        );
    }

    @Override
    public LightBomberSquadron createLightBomberSquadronLow(String name, String acronym) {
        return new LightBomberSquadron(
            name, acronym, country, airplanePropsFactory.getLightBomberLow(), bomberPropsFactory.getLightBomberLow()
        );
    }

    @Override
    public LightBomberSquadron createLightBomberSquadronMedium(String name, String acronym) {
        return new LightBomberSquadron(
            name, acronym, country, airplanePropsFactory.getLightBomberMedium(), bomberPropsFactory.getLightBomberMedium()
        );
    }

    @Override
    public LightBomberSquadron createLightBomberSquadronHigh(String name, String acronym) {
        return new LightBomberSquadron(
            name, acronym, country, airplanePropsFactory.getLightBomberHigh(), bomberPropsFactory.getLightBomberHigh()
        );
    }

    @Override
    public MediumBomberSquadron createMediumBomberSquadronLow(String name, String acronym) {
        return new MediumBomberSquadron(
            name, acronym, country, airplanePropsFactory.getMediumBomberLow(), bomberPropsFactory.getMediumBomberLow()
        );
    }

    @Override
    public MediumBomberSquadron createMediumBomberSquadronMedium(String name, String acronym) {
        return new MediumBomberSquadron(
            name, acronym, country, airplanePropsFactory.getMediumBomberMedium(), bomberPropsFactory.getMediumBomberMedium()
        );
    }

    @Override
    public MediumBomberSquadron createMediumBomberSquadronHigh(String name, String acronym) {
        return new MediumBomberSquadron(
            name, acronym, country, airplanePropsFactory.getMediumBomberHigh(), bomberPropsFactory.getMediumBomberHigh()
        );
    }

    @Override
    public HeavyBomberSquadron createHeavyBomberSquadronLow(String name, String acronym) {
        return new HeavyBomberSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyBomberLow(), bomberPropsFactory.getHeavyBomberLow()
        );
    }

    @Override
    public HeavyBomberSquadron createHeavyBomberSquadronMedium(String name, String acronym) {
        return new HeavyBomberSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyBomberMedium(), bomberPropsFactory.getHeavyBomberMedium()
        );
    }

    @Override
    public HeavyBomberSquadron createHeavyBomberSquadronHigh(String name, String acronym) {
        return new HeavyBomberSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyBomberHigh(), bomberPropsFactory.getHeavyBomberHigh()
        );
    }

    @Override
    public LightObserverSquadron createLightObserverSquadronLow(String name, String acronym) {
        return new LightObserverSquadron(
            name, acronym, country, airplanePropsFactory.getLightObserverLow(), observerPropsFactory.getLightObserverLow()
        );
    }

    @Override
    public LightObserverSquadron createLightObserverSquadronMedium(String name, String acronym) {
        return new LightObserverSquadron(
            name, acronym, country, airplanePropsFactory.getLightObserverMedium(), observerPropsFactory.getLightObserverMedium()
        );
    }

    @Override
    public LightObserverSquadron createLightObserverSquadronHigh(String name, String acronym) {
        return new LightObserverSquadron(
            name, acronym, country, airplanePropsFactory.getLightObserverHigh(), observerPropsFactory.getLightObserverHigh()
        );
    }

    @Override
    public MediumObserverSquadron createMediumObserverSquadronLow(String name, String acronym) {
        return new MediumObserverSquadron(
            name, acronym, country, airplanePropsFactory.getMediumObserverLow(), observerPropsFactory.getMediumObserverLow()
        );
    }

    @Override
    public MediumObserverSquadron createMediumObserverSquadronMedium(String name, String acronym) {
        return new MediumObserverSquadron(
            name, acronym, country, airplanePropsFactory.getMediumObserverMedium(), observerPropsFactory.getMediumObserverMedium()
        );
    }

    @Override
    public MediumObserverSquadron createMediumObserverSquadronHigh(String name, String acronym) {
        return new MediumObserverSquadron(
            name, acronym, country, airplanePropsFactory.getMediumObserverHigh(), observerPropsFactory.getMediumObserverHigh()
        );
    }

    @Override
    public MediumTransportSquadron createMediumTransportSquadronLow(String name, String acronym) {
        return new MediumTransportSquadron(
            name, acronym, country, airplanePropsFactory.getMediumTransportLow(), transportPropsFactory.getMediumTransportLow()
        );
    }

    @Override
    public MediumTransportSquadron createMediumTransportSquadronMedium(String name, String acronym) {
        return new MediumTransportSquadron(
            name, acronym, country, airplanePropsFactory.getMediumTransportMedium(), transportPropsFactory.getMediumTransportMedium()
        );
    }

    @Override
    public MediumTransportSquadron createMediumTransportSquadronHigh(String name, String acronym) {
        return new MediumTransportSquadron(
            name, acronym, country, airplanePropsFactory.getMediumTransportHigh(), transportPropsFactory.getMediumTransportHigh()
        );
    }

    @Override
    public HeavyTransportSquadron createHeavyTransportSquadronLow(String name, String acronym) {
        return new HeavyTransportSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyTransportLow(), transportPropsFactory.getHeavyTransportLow()
        );
    }

    @Override
    public HeavyTransportSquadron createHeavyTransportSquadronMedium(String name, String acronym) {
        return new HeavyTransportSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyTransportMedium(), transportPropsFactory.getHeavyTransportMedium()
        );
    }

    @Override
    public HeavyTransportSquadron createHeavyTransportSquadronHigh(String name, String acronym) {
        return new HeavyTransportSquadron(
            name, acronym, country, airplanePropsFactory.getHeavyTransportHigh(), transportPropsFactory.getHeavyTransportHigh()
        );
    }
}
