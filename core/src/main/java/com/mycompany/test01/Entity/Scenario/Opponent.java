package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronGroup;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Group.FrontGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;

public class Opponent {
    private OpponentSideEnum side;
    private CountryEnum country;
    private FrontGroup landArmyGroup;
    private AirplaneSquadronGroup airArmyGroup;
    private Hexagon supplyingSource;
    private OrderedSet<ReinfElement> reinfProgram;
    //private OrderedSet<UnitReinfElement> unitReinProgram;
    //private OrderedSet<SupplyElement> supplyProgram;
    private Hexagon[] ownedBorderHexes;
    private Hexagon[] ownedHexes;
    private int initialRootSupplyStock;
    private float supplyRatio;
    private float reinfRatio;

}
