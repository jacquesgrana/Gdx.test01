package com.mycompany.test01.Entity.Scenario;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;

import java.util.Objects;

public class MapObjective {

    private String name = "";
    private String acronym = "";

    private int captureReward = 0;
    private int dailyCaptureReward = 0;
    private int endGameReward = 0;
    private Array<Hexagon> hexagons = new Array<>();

    public MapObjective() {
    }

    // TODO ajouter methodes isInHexagons addHexagon et removeHexagon
    public MapObjective(
        String name,
        String acronym,
        int captureReward,
        int dailyCaptureReward,
        int endGameReward,
        Array<Hexagon> hexagons
    ) {
        this.name = name;
        this.acronym = acronym;
        this.captureReward = captureReward;
        this.dailyCaptureReward = dailyCaptureReward;
        this.endGameReward = endGameReward;
        this.hexagons = hexagons;
    }

    public boolean isHexInHexagons(Hexagon hexagon) {
        return this.getHexagons().contains(hexagon, false);
    }

    public void addHexagon(Hexagon hexagon) {
        if(!this.getHexagons().contains(hexagon, false)) {
           this.getHexagons().add(hexagon);
        }
    }

    public void removeHexagon(Hexagon hexagon) {
        if(this.getHexagons().contains(hexagon, false)) {
            this.getHexagons().removeValue(hexagon, false);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        MapObjective objective = (MapObjective) other;
        return Objects.equals(this.name, objective.name)
            || Objects.equals(this.acronym, objective.acronym);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public int getCaptureReward() {
        return captureReward;
    }

    public void setCaptureReward(int captureReward) {
        this.captureReward = captureReward;
    }

    public int getDailyCaptureReward() {
        return dailyCaptureReward;
    }

    public void setDailyCaptureReward(int dailyCaptureReward) {
        this.dailyCaptureReward = dailyCaptureReward;
    }

    public int getEndGameReward() {
        return endGameReward;
    }

    public void setEndGameReward(int endGameReward) {
        this.endGameReward = endGameReward;
    }

    public Array<Hexagon> getHexagons() {
        return hexagons;
    }

    public void setHexagons(Array<Hexagon> hexagons) {
        this.hexagons = hexagons;
    }
}
