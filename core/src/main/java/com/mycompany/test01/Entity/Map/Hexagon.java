package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Screen.EditScenarScreen;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Util.MapUtil;

import java.util.Arrays;

// TODO changer category en terrain ??
public class Hexagon {
    private int x;
    private int y;
    private HexagonCategory category;
    private FortificationCategory fortification;
    private RoadEdges roads;
    private RiverCategory[] rivers;
    private BridgeEdges bridges;
    private Cliff[] cliffs;
    private CountryEnum ownerCountry;

    //private EditScenarService editScenarService = EditScenarService.getInstance();


    public Hexagon() {
        //editScenarService = EditScenarService.getInstance();
    }

    public Hexagon(int x, int y, HexagonCategory category, FortificationCategory fortification, CountryEnum ownerCountry) {
        this.x = x;
        this.y = y;
        this.category = category;
        this.fortification = fortification;
        this.roads = new RoadEdges();
        this.rivers = new RiverCategory[6];
        Arrays.fill(this.rivers, RiverCategory.NO_RIVER);
        this.bridges = new BridgeEdges();
        this.cliffs = new Cliff[6];
        for(int i=0; i<6; i++) {
            this.cliffs[i] = new Cliff();
        }
        this.ownerCountry = ownerCountry;
        //editScenarService = EditScenarService.getInstance();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public HexagonCategory getCategory() {
        return category;
    }

    public void setCategory(HexagonCategory category) {
        this.category = category;
    }

    public FortificationCategory getFortification() {
        return fortification;
    }

    public void setFortification(FortificationCategory fortification) {
        this.fortification = fortification;
    }

    public RoadEdges getRoads() {
        return roads;
    }

    public void setRoads(RoadEdges roads) {
        this.roads = roads;
    }

    public RiverCategory[] getRivers() {
        return rivers;
    }

    public void setRivers(RiverCategory[] rivers) {
        this.rivers = rivers;
    }

    public BridgeEdges getBridges() {
        return bridges;
    }

    public void setBridges(BridgeEdges bridges) {
        this.bridges = bridges;
    }


    public Cliff[] getCliffs() {
        return cliffs;
    }

    public void setCliffs(Cliff[] cliffs) {
        this.cliffs = cliffs;
    }

    public CountryEnum getOwnerCountry() {
        return ownerCountry;
    }

    public void setOwnerCountry(CountryEnum ownerCountry) {
        this.ownerCountry = ownerCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hexagon hexagon = (Hexagon) o;
        return x == hexagon.x && y == hexagon.y;  // Égalité basée sur les coordonnées
    }

    @Override
    public int hashCode() {
        return 31 * x + y;  // Hash basé sur les coordonnées
    }
}
