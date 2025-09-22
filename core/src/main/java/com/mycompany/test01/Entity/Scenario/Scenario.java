package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.OpponentSideEnum;

public class Scenario {

    private String name;
    private OpponentSideEnum[] sides;
    private int sidesCount;
    private Opponent[] opponents;
    private MapObjective[] objectives;
    private Array<Array<Hexagon>> hexesArray;
    private int limitI, limitJ;

    public Scenario() {
    }

    public Scenario(
        String name,
        OpponentSideEnum[] sides,
        int sidesCount,
        Opponent[] opponents,
        MapObjective[] objectives,
        Array<Array<Hexagon>> hexesArray,
        int limitI,
        int limitJ
    ) {
        this.name = name;
        this.sides = sides;
        this.sidesCount = sidesCount;
        this.opponents = opponents;
        this.objectives = objectives;
        this.hexesArray = hexesArray;
        this.limitI = limitI;
        this.limitJ = limitJ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpponentSideEnum[] getSides() {
        return sides;
    }

    public void setSides(OpponentSideEnum[] sides) {
        this.sides = sides;
    }

    public int getSidesCount() {
        return sidesCount;
    }

    public void setSidesCount(int sidesCount) {
        this.sidesCount = sidesCount;
    }

    public Opponent[] getOpponents() {
        return opponents;
    }

    public void setOpponents(Opponent[] opponents) {
        this.opponents = opponents;
    }

    public MapObjective[] getObjectives() {
        return objectives;
    }

    public void setObjectives(MapObjective[] objectives) {
        this.objectives = objectives;
    }

    public Array<Array<Hexagon>> getHexesArray() {
        return hexesArray;
    }

    public void setHexesArray(Array<Array<Hexagon>> hexesArray) {
        this.hexesArray = hexesArray;
    }

    public int getLimitI() {
        return limitI;
    }

    public void setLimitI(int limitI) {
        this.limitI = limitI;
    }

    public int getLimitJ() {
        return limitJ;
    }

    public void setLimitJ(int limitJ) {
        this.limitJ = limitJ;
    }
}
