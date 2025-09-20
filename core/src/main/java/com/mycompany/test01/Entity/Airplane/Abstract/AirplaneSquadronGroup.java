package com.mycompany.test01.Entity.Airplane.Abstract;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Interface.airplane.AirplaneSquadronElementInterface;

public class AirplaneSquadronGroup {
    private String name;
    private String acronym;
    private OrderedSet<AirplaneSquadronElementInterface> planes;
}
