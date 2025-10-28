package com.mycompany.test01.Enum;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Util.GraphicUtil;

public enum HexagonCategory {
    GRASS("Grass" , 1.5f, 1.5f, Color.LIME, GraphicUtil.grassTexture),
    FOREST("Forest", 2.5f, 3.0f, Color.FOREST, GraphicUtil.forestTexture),
    SWAMP("Swamp", 3.0f, Float.POSITIVE_INFINITY, Color.PURPLE, GraphicUtil.swampTexture),
    SAND("Sand", 1.5f, 1.7f, Color.YELLOW, GraphicUtil.sandTexture),
    WATER("Water", Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Color.BLUE, GraphicUtil.waterTexture),
    CITY_LIGHT("City Light", 1.2f, 1.75f, Color.LIGHT_GRAY, GraphicUtil.cityLightTexture),
    CITY_DENSE("City Dense", 1.3f, 2.0f, Color.DARK_GRAY, GraphicUtil.cityDenseTexture);

    private final String name;
    private final float costLeg;
    private final float costVehicle;
    private final Color color;
    private final Texture texture;

    HexagonCategory(String name, float costLeg, float costVehicle, Color color, Texture texture) {
        this.name = name;
        this.costLeg = costLeg;
        this.costVehicle = costVehicle;
        this.color = color;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public float getCostLeg() {
        return costLeg;
    }

    public float getCostVehicle() {
        return costVehicle;
    }

    public Color getColor() { return color; }

    public Texture getTexture() { return texture; }

    static public HexagonCategory getRandomCategory() {
        float random = (float) Math.random();
        if(random <= 0.5f) return HexagonCategory.GRASS;
        else if(random > 0.5f && random <= 0.75f) return HexagonCategory.FOREST;
        else if(random > 0.75f && random <= 0.8625f) return HexagonCategory.SAND;
        else if(random > 0.8625f && random <= 0.95f) return HexagonCategory.WATER;
        else if(random > 0.9f && random <= 0.975f) return HexagonCategory.CITY_LIGHT;
        else if(random > 0.975f && random <= 0.9825f) return HexagonCategory.CITY_DENSE;
        else return  HexagonCategory.SWAMP;
        //return HexagonCategory.SAND;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
