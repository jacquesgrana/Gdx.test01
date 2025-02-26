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

    public Hexagon(int x, int y, HexagonCategory category, FortificationCategory fortification) {
        this.x = x;
        this.y = y;
        this.category = category;
        this.fortification = fortification;
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

    /*
    public Color getColorFromCategory() {
        Color toReturn = Color.WHITE;
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
            case WATER:
                toReturn = Color.BLUE;
                break;
        }
        return toReturn;
    }*/

    /*
    public Texture getTextureFromCategory() {
        Texture toReturn = GraphicUtil.grassTexture;
        switch (this.category) {
            case GRASS:
                toReturn = GraphicUtil.grassTexture;
                break;
            case FOREST:
                toReturn = GraphicUtil.forestTexture;
                break;
            case SWAMP:
                toReturn = GraphicUtil.swampTexture;
                break;
            case SAND:
                toReturn = GraphicUtil.sandTexture;
                break;
            case WATER:
                toReturn = GraphicUtil.waterTexture;
        }
        return toReturn;
    }*/
}
