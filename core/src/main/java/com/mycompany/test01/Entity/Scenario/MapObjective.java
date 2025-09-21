package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Entity.Map.Hexagon;

public class MapObjective {

    private String name = "";
    private String acronym = "";

    private int dailyCaptureReward = 0;
    private Hexagon hexagon = null;

    public MapObjective() {
    }

    public MapObjective(String name, String acronym, int dailyCaptureReward, Hexagon hexagon) {
        this.name = name;
        this.acronym = acronym;
        this.dailyCaptureReward = dailyCaptureReward;
        this.hexagon = hexagon;
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

    public int getDailyCaptureReward() {
        return dailyCaptureReward;
    }

    public void setDailyCaptureReward(int dailyCaptureReward) {
        this.dailyCaptureReward = dailyCaptureReward;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public void setHexagon(Hexagon hexagon) {
        this.hexagon = hexagon;
    }
}
