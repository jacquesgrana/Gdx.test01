package com.mycompany.test01.Enum;

public enum FortificationCategory {
    NO_FORTIFICATION ("No Fortification", 0.0f),
    WOOD_LIGHT ("Wood Light", 1.5f),
    WOOD_MEDIUM ("Wood Medium", 2.0f),
    CONCRETE_LIGHT ("Concrete Light", 2.5f),
    CONCRETE_MEDIUM ("Concrete Medium", 3.0f),
    CONCRETE_HEAVY("Concrete Heavy", 3.5f);

    private final String name;
    private final float level;

    FortificationCategory(String name, float level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public float getLevel() {
        return level;
    }

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
