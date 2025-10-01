package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronGroup;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Group.FrontGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;

public class Opponent {
    private int id = 0;
    private String name = "";
    private OpponentSideEnum side = OpponentSideEnum.NO_SIDE;
    private CountryEnum country = CountryEnum.NO_COUNTRY;
    private FrontGroup landArmyGroup = null;
    private AirplaneSquadronGroup airArmyGroup = null;
    private Hexagon supplyingSource = null;
    private OrderedSet<ReinfElement> reinfProgram = new OrderedSet<>();
    private OrderedSet<UnitReinfElement> unitReinProgram = new OrderedSet<>();
    private OrderedSet<SupplyElement> supplyProgram = new OrderedSet<>();
    private OrderedSet<Hexagon> ownedBorderHexes = new OrderedSet<>();
    private OrderedSet<Hexagon> ownedHexes = new OrderedSet<>();
    private SupplyElement initialRootSupplyStock = new SupplyElement();
    private float supplyRatio = 0f;
    private float reinfRatio = 0f;

    public Opponent() {
    }

    public Opponent(
        int id,
        String name,
        OpponentSideEnum side,
        CountryEnum country,
        FrontGroup landArmyGroup,
        AirplaneSquadronGroup airArmyGroup,
        Hexagon supplyingSource,
        OrderedSet<ReinfElement> reinfProgram,
        OrderedSet<UnitReinfElement> unitReinProgram,
        OrderedSet<SupplyElement> supplyProgram,
        OrderedSet<Hexagon> ownedBorderHexes,
        OrderedSet<Hexagon> ownedHexes,
        SupplyElement initialRootSupplyStock,
        float supplyRatio,
        float reinfRatio
    ) {
        this.id = id;
        this.name = name;
        this.side = side;
        this.country = country;
        this.landArmyGroup = landArmyGroup;
        this.airArmyGroup = airArmyGroup;
        this.supplyingSource = supplyingSource;
        this.reinfProgram = reinfProgram;
        this.unitReinProgram = unitReinProgram;
        this.supplyProgram = supplyProgram;
        this.ownedBorderHexes = ownedBorderHexes;
        this.ownedHexes = ownedHexes;
        this.initialRootSupplyStock = initialRootSupplyStock;
        this.supplyRatio = supplyRatio;
        this.reinfRatio = reinfRatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpponentSideEnum getSide() {
        return side;
    }

    public void setSide(OpponentSideEnum side) {
        this.side = side;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public FrontGroup getLandArmyGroup() {
        return landArmyGroup;
    }

    public void setLandArmyGroup(FrontGroup landArmyGroup) {
        this.landArmyGroup = landArmyGroup;
    }

    public AirplaneSquadronGroup getAirArmyGroup() {
        return airArmyGroup;
    }

    public void setAirArmyGroup(AirplaneSquadronGroup airArmyGroup) {
        this.airArmyGroup = airArmyGroup;
    }

    public Hexagon getSupplyingSource() {
        return supplyingSource;
    }

    public void setSupplyingSource(Hexagon supplyingSource) {
        this.supplyingSource = supplyingSource;
    }

    public OrderedSet<ReinfElement> getReinfProgram() {
        return reinfProgram;
    }

    public void setReinfProgram(OrderedSet<ReinfElement> reinfProgram) {
        this.reinfProgram = reinfProgram;
    }

    public OrderedSet<UnitReinfElement> getUnitReinProgram() {
        return unitReinProgram;
    }

    public void setUnitReinProgram(OrderedSet<UnitReinfElement> unitReinProgram) {
        this.unitReinProgram = unitReinProgram;
    }

    public OrderedSet<SupplyElement> getSupplyProgram() {
        return supplyProgram;
    }

    public void setSupplyProgram(OrderedSet<SupplyElement> supplyProgram) {
        this.supplyProgram = supplyProgram;
    }

    public OrderedSet<Hexagon> getOwnedBorderHexes() {
        return ownedBorderHexes;
    }

    public void setOwnedBorderHexes(OrderedSet<Hexagon> ownedBorderHexes) {
        this.ownedBorderHexes = ownedBorderHexes;
    }

    public OrderedSet<Hexagon> getOwnedHexes() {
        return ownedHexes;
    }

    public void setOwnedHexes(OrderedSet<Hexagon> ownedHexes) {
        this.ownedHexes = ownedHexes;
    }

    public SupplyElement getInitialRootSupplyStock() {
        return initialRootSupplyStock;
    }

    public void setInitialRootSupplyStock(SupplyElement initialRootSupplyStock) {
        this.initialRootSupplyStock = initialRootSupplyStock;
    }

    public float getSupplyRatio() {
        return supplyRatio;
    }

    public void setSupplyRatio(float supplyRatio) {
        this.supplyRatio = supplyRatio;
    }

    public float getReinfRatio() {
        return reinfRatio;
    }

    public void setReinfRatio(float reinfRatio) {
        this.reinfRatio = reinfRatio;
    }

    @Override
    public String toString() {
        return
            country + " / " +
            side + " / " +
            name;
    }
}
