package com.mycompany.test01.Enum;

import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Util.GraphicUtil;

public enum FortificationCategory {
    NO_FORTIFICATION ("No Fortification", 0.0f, GraphicUtil.getEmptyTexture()),
    WOOD_LIGHT ("Wood Light", 1.5f, GraphicUtil.fortifWoodLightTexture),
    WOOD_MEDIUM ("Wood Medium", 2.0f, GraphicUtil.fortifWoodMediumTexture),
    CONCRETE_LIGHT ("Concrete Light", 2.5f, GraphicUtil.fortifConcreteLightTexture),
    CONCRETE_MEDIUM ("Concrete Medium", 3.0f, GraphicUtil.fortifConcreteMediumTexture),
    CONCRETE_HEAVY("Concrete Heavy", 3.5f, GraphicUtil.fortifConcreteHeavyTexture);

    private final String name;
    private final float level;
    private final Texture texture;

    FortificationCategory(String name, float level, Texture texture) {
        this.name = name;
        this.level = level;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public float getLevel() {
        return level;
    }

    public Texture getTexture() { return texture; }

    static public FortificationCategory getRandomFortification() {
        float random = (float) Math.random();
        if(random <= 0.75f) return FortificationCategory.NO_FORTIFICATION;
        else if(random > 0.75f && random <= 0.85f) return FortificationCategory.WOOD_LIGHT;
        else if(random > 0.85f && random <= 0.90f) return FortificationCategory.WOOD_MEDIUM;
        else if(random > 0.90f && random <= 0.95f) return FortificationCategory.CONCRETE_LIGHT;
        else if(random > 0.95f && random <= 0.975f) return FortificationCategory.CONCRETE_MEDIUM;
        else return  FortificationCategory.CONCRETE_HEAVY;
        //return HexagonCategory.SAND;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
