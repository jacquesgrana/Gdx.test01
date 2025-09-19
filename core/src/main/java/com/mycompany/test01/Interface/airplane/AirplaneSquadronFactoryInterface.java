package com.mycompany.test01.Interface.airplane;

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

public interface AirplaneSquadronFactoryInterface {

    public LightFighterSquadron createLightFighterSquadronLow(
        String name,
        String acronym
    );
    public LightFighterSquadron createLightFighterSquadronMedium(
        String name,
        String acronym
    );
    public LightFighterSquadron createLightFighterSquadronHigh(
        String name,
        String acronym
    );

    public MediumFighterSquadron createMediumFighterSquadronLow(
        String name,
        String acronym
    );
    public MediumFighterSquadron createMediumFighterSquadronMedium(
        String name,
        String acronym
    );
    public MediumFighterSquadron createMediumFighterSquadronHigh(
        String name,
        String acronym
    );

    public HeavyFighterSquadron createHeavyFighterSquadronLow(
        String name,
        String acronym
    );
    public HeavyFighterSquadron createHeavyFighterSquadronMedium(
        String name,
        String acronym
    );
    public HeavyFighterSquadron createHeavyFighterSquadronHigh(
        String name,
        String acronym
    );


    public LightBomberSquadron createLightBomberSquadronLow(
        String name,
        String acronym
    );
    public LightBomberSquadron createLightBomberSquadronMedium(
        String name,
        String acronym
    );
    public LightBomberSquadron createLightBomberSquadronHigh(
        String name,
        String acronym
    );

    public MediumBomberSquadron createMediumBomberSquadronLow(
        String name,
        String acronym
    );
    public MediumBomberSquadron createMediumBomberSquadronMedium(
        String name,
        String acronym
    );
    public MediumBomberSquadron createMediumBomberSquadronHigh(
        String name,
        String acronym
    );

    public HeavyBomberSquadron createHeavyBomberSquadronLow(
        String name,
        String acronym
    );
    public HeavyBomberSquadron createHeavyBomberSquadronMedium(
        String name,
        String acronym
    );
    public HeavyBomberSquadron createHeavyBomberSquadronHigh(
        String name,
        String acronym
    );


    public LightObserverSquadron createLightObserverSquadronLow(
        String name,
        String acronym
    );
    public LightObserverSquadron createLightObserverSquadronMedium(
        String name,
        String acronym
    );
    public LightObserverSquadron createLightObserverSquadronHigh(
        String name,
        String acronym
    );

    public MediumObserverSquadron createMediumObserverSquadronLow(
        String name,
        String acronym
    );
    public MediumObserverSquadron createMediumObserverSquadronMedium(
        String name,
        String acronym
    );
    public MediumObserverSquadron createMediumObserverSquadronHigh(
        String name,
        String acronym
    );


    public MediumTransportSquadron createMediumTransportSquadronLow(
        String name,
        String acronym
    );
    public MediumTransportSquadron createMediumTransportSquadronMedium(
        String name,
        String acronym
    );
    public MediumTransportSquadron createMediumTransportSquadronHigh(
        String name,
        String acronym
    );

    public HeavyTransportSquadron createHeavyTransportSquadronLow(
        String name,
        String acronym
    );
    public HeavyTransportSquadron createHeavyTransportSquadronMedium(
        String name,
        String acronym
    );
    public HeavyTransportSquadron createHeavyTransportSquadronHigh(
        String name,
        String acronym
    );
}
