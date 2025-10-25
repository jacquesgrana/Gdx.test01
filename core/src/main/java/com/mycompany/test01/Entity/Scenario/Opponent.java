package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedSet;
import com.mycompany.test01.Common.OnBoardUnit;
import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronGroup;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Entity.Unit.Group.ArmyGroup;
import com.mycompany.test01.Entity.Unit.Group.FrontGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;

import java.util.HashSet;
import java.util.Set;

public class Opponent {
    private int id = 0;
    private String name = "";
    private OpponentSideEnum side = OpponentSideEnum.NO_SIDE;
    private CountryEnum country = CountryEnum.NO_COUNTRY;
    private UnitGroup landArmyGroup = null;
    private AirplaneSquadronGroup airArmyGroup = null;
    private Set<Hexagon> supplyHexesSource = new HashSet<>();
    private Set<Hexagon> reinfHexesSource = new HashSet<>();
    private OrderedSet<ReinfElement> reinfProgram = new OrderedSet<>();
    private OrderedSet<UnitReinfElement> unitReinProgram = new OrderedSet<>();
    private OrderedSet<SupplyElement> supplyProgram = new OrderedSet<>();
    private Set<Hexagon> borderHexesOwned = new HashSet<>();
    //private OrderedSet<Hexagon> ownedHexes = new OrderedSet<>();
    private SupplyElement initialRootSupplyStock = new SupplyElement();
    private float supplyRatio = 0f;
    private float reinfRatio = 0f;
    private Set<OnBoardUnit> deployedUnits = new HashSet<>();


    public Opponent() {
    }

    public Opponent(
        int id,
        String name,
        OpponentSideEnum side,
        CountryEnum country,
        UnitGroup landArmyGroup,
        AirplaneSquadronGroup airArmyGroup,
        Set<Hexagon> supplyHexesSource,
        Set<Hexagon> reinfHexesSource,
        OrderedSet<ReinfElement> reinfProgram,
        OrderedSet<UnitReinfElement> unitReinProgram,
        OrderedSet<SupplyElement> supplyProgram,
        // TODO : utiliser List?
        //OrderedSet<Hexagon> ownedBorderHexes,
        Set<Hexagon> borderHexesOwned,
        //OrderedSet<Hexagon> ownedHexes,
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
        //this.supplyingSource = supplyingSource;
        this.supplyHexesSource = supplyHexesSource;
        this.reinfHexesSource = reinfHexesSource;
        this.reinfProgram = reinfProgram;
        this.unitReinProgram = unitReinProgram;
        this.supplyProgram = supplyProgram;
        this.borderHexesOwned = borderHexesOwned;
        //this.ownedHexes = ownedHexes;
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

    public UnitGroup getLandArmyGroup() {
        return landArmyGroup;
    }

    public void setLandArmyGroup(UnitGroup landArmyGroup) {
        this.landArmyGroup = landArmyGroup;
    }

    public AirplaneSquadronGroup getAirArmyGroup() {
        return airArmyGroup;
    }

    public void setAirArmyGroup(AirplaneSquadronGroup airArmyGroup) {
        this.airArmyGroup = airArmyGroup;
    }

    public Set<Hexagon> getSupplyHexesSource() {
        return supplyHexesSource;
    }

    public void setSupplyHexesSource(Set<Hexagon> supplyHexesSource) {
        this.supplyHexesSource = supplyHexesSource;
    }

    public Set<Hexagon> getReinfHexesSource() {
        return reinfHexesSource;
    }

    public void setReinfHexesSource(Set<Hexagon> reinfHexesSource) {
        this.reinfHexesSource = reinfHexesSource;
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

    public Set<Hexagon> getBorderHexesOwned() {
        return borderHexesOwned;
    }

    public void setBorderHexesOwned(Set<Hexagon> borderHexesOwned) {
        this.borderHexesOwned = borderHexesOwned;
    }

/*
    public OrderedSet<Hexagon> getOwnedHexes() {
        return ownedHexes;
    }

    public void setOwnedHexes(OrderedSet<Hexagon> ownedHexes) {
        this.ownedHexes = ownedHexes;
    }
     */

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

    public Set<OnBoardUnit> getDeployedUnits() {
        return deployedUnits;
    }

    public void setDeployedUnits(Set<OnBoardUnit> deployedUnits) {
        this.deployedUnits = deployedUnits;
    }

    @Override
    public String toString() {
        return name;
    }
}
