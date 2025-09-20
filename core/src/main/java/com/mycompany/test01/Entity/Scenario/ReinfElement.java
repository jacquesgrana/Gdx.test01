package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronAbstract;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Interface.airplane.AirplaneSquadronElementInterface;

public class ReinfElement {
    private String dateTime;
    private UnitElement[] landUnits;
    private AirplaneSquadronElementInterface[] airUnits;
    private Hexagon reinfHex;
}
