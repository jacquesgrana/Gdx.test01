package com.mycompany.test01.Enum;

public enum FortificationCategory {
    NO_FORTIFICATION,
    WOOD_LIGHT,
    WOOD_MEDIUM,
    CONCRETE_LIGHT,
    CONCRETE_MEDIUM,
    CONCRETE_HEAVY;

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
        return super.toString();
    }
}
