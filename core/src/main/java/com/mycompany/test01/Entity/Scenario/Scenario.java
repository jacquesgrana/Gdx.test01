package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Enum.OpponentSideEnum;

public class Scenario {

    private String name;
    private OpponentSideEnum[] sides;
    private int sidesCount;
    private Opponent[] opponents;

    private MapObjective[] objectives;

    public Scenario() {
    }

    public Scenario(
        String name,
        OpponentSideEnum[] sides,
        int sidesCount,
        Opponent[] opponents,
        MapObjective[] objectives
    ) {
        this.name = name;
        this.sides = sides;
        this.sidesCount = sidesCount;
        this.opponents = opponents;
        this.objectives = objectives;
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
}
