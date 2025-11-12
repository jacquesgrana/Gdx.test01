package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Common.OnBoardUnit;
import com.mycompany.test01.Entity.Airplane.Abstract.AirplaneSquadronGroup;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;
import com.mycompany.test01.Interface.unit.ElementInterface;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Opponent {
    private int id = 0;
    private String name = "";
    private OpponentSideEnum side = OpponentSideEnum.NO_SIDE;
    private CountryEnum country = CountryEnum.NO_COUNTRY;
    private UnitGroup landArmyGroup = null;
    private AirplaneSquadronGroup airArmyGroup = null;
    private Set<SourceHexagon> supplyHexesSource = new LinkedHashSet<>();
    // TODO créer DTO pour SourceHexagon ??
    private Set<SourceHexagon> reinfHexesSource = new LinkedHashSet<>();
    private Set<Hexagon> borderHexesOwned = new LinkedHashSet<>();
    private Array<ReinfElement> reinfProgram = new Array<>();
    private Array<UnitReinfElement> unitReinProgram = new Array<>();
    private Array<SupplyElement> supplyProgram = new Array<>();
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
        Set<SourceHexagon> supplyHexesSource,
        Set<SourceHexagon> reinfHexesSource,
        Array<ReinfElement> reinfProgram,
        Array<UnitReinfElement> unitReinProgram,
        Array<SupplyElement> supplyProgram,
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

    public boolean isUnitDeployed(ElementInterface unit) {
        OnBoardUnit onBoardUnit = new OnBoardUnit();
        onBoardUnit.setUnit(unit);
        return this.getDeployedUnits().stream().anyMatch((OnBoardUnit u) ->
            u.equals(onBoardUnit)
        );
    }

    public void generateSourceHexesRanks(Set<SourceHexagon> sourceHexagons) {
        int cpt = 0;
        for(SourceHexagon sourceHexagon : sourceHexagons) {
            cpt++;
            sourceHexagon.setRank(cpt);
        }
    }

    public Set<SourceHexagon> getSourceHexagonsAfterRemove(SourceHexagon sourceHexagon, Set<SourceHexagon> sourceHexagons) {
        Set<SourceHexagon> newSet = new LinkedHashSet<>();
        for(SourceHexagon s : sourceHexagons) {
            if(!s.getHexagon().equals(sourceHexagon.getHexagon())) {
                newSet.add(s);
            }
        }
        return newSet;
    }

    // TODO factoriser 1 !!!
    /*
    public void generateReinfHexesSourceRanks() {
        int cpt = 0;
        for(SourceHexagon sourceHexagon : reinfHexesSource) {
            cpt++;
            sourceHexagon.setRank(cpt);
        }
    }*/


    // TODO factoriser 2 !!!
    /*
    public void removeReinfHexesSourceSafe(SourceHexagon sourceHexagon) {
        Set<SourceHexagon> newSet = new LinkedHashSet<>();
        for(SourceHexagon s : this.reinfHexesSource) {
            if(!s.getHexagon().equals(sourceHexagon.getHexagon())) {
                newSet.add(s);
            }
        }
        this.reinfHexesSource = newSet;
    }
     */


    // TODO factoriser 1 !!!
    /*
    public void generateSupplyHexesSourceRanks() {
        int cpt = 0;
        for(SourceHexagon sourceHexagon : supplyHexesSource) {
            cpt++;
            sourceHexagon.setRank(cpt);
        }
    }
    */

    // TODO factoriser 2 !!!
    /*
    public void removeSupplyHexesSourceSafe(SourceHexagon sourceHexagon) {
        Set<SourceHexagon> newSet = new LinkedHashSet<>();
        for(SourceHexagon s : this.supplyHexesSource) {
            if(!s.getHexagon().equals(sourceHexagon.getHexagon())) {
                newSet.add(s);
            }
        }
        this.supplyHexesSource = newSet;
    }
     */

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

    public Set<SourceHexagon> getSupplyHexesSource() {
        return supplyHexesSource;
    }

    public void setSupplyHexesSource(Set<SourceHexagon> supplyHexesSource) {
        this.supplyHexesSource = supplyHexesSource;
    }

    public Set<SourceHexagon> getReinfHexesSource() {
        return reinfHexesSource;
    }

    public void setReinfHexesSource(Set<SourceHexagon> reinfHexesSource) {
        this.reinfHexesSource = reinfHexesSource;
    }

    public Array<ReinfElement> getReinfProgram() {
        return reinfProgram;
    }

    public void setReinfProgram(Array<ReinfElement> reinfProgram) {
        this.reinfProgram = reinfProgram;
    }

    public Array<UnitReinfElement> getUnitReinProgram() {
        return unitReinProgram;
    }

    public void setUnitReinProgram(Array<UnitReinfElement> unitReinProgram) {
        this.unitReinProgram = unitReinProgram;
    }

    public Array<SupplyElement> getSupplyProgram() {
        return supplyProgram;
    }

    public void setSupplyProgram(Array<SupplyElement> supplyProgram) {
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
