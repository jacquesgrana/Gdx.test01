package com.mycompany.test01.Entity;

import com.badlogic.gdx.graphics.Color;
import com.mycompany.test01.Enum.HexagonCategory;

public class Hexagon {
    private int x;
    private int y;
    private HexagonCategory category;

    public Hexagon(int x, int y, HexagonCategory category) {
        this.x = x;
        this.y = y;
        this.category = category;
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

    public Color getColorFromCategory() {
        Color toReturn = null;
        switch (this.category) {
            case GRASS:
                toReturn = Color.LIME;
                break;
            case FOREST:
                toReturn = Color.FOREST;
                break;
            case SWAMP:
                toReturn = Color.PURPLE;
                break;
            case SAND:
                toReturn = Color.YELLOW;
                break;
        }
        return toReturn;
    }
}
