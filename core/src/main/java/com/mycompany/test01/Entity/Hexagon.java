package com.mycompany.test01.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Enum.FortificationCategory;
import com.mycompany.test01.Enum.HexagonCategory;
import com.mycompany.test01.Util.GraphicUtil;

// TODO changer category en terrain ??
public class Hexagon {
    private int x;
    private int y;
    private HexagonCategory category;
    private FortificationCategory fortification;
    private RoadEdges roads;

    public Hexagon() {
    }

    public Hexagon(int x, int y, HexagonCategory category, FortificationCategory fortification) {
        this.x = x;
        this.y = y;
        this.category = category;
        this.fortification = fortification;
        this.roads = new RoadEdges();
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

}
