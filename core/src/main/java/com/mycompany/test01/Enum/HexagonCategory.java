package com.mycompany.test01.Enum;

public enum HexagonCategory {
    GRASS,
    FOREST,
    SWAMP,
    SAND;


    static public HexagonCategory getRandomCategory() {
        float random = (float) Math.random();
        if(random <= 0.5f) return HexagonCategory.GRASS;
        else if(random > 0.5f && random <= 0.75f) return HexagonCategory.FOREST;
        else if(random > 0.75f && random <= 0.8625f) return HexagonCategory.SAND;
        else return  HexagonCategory.SWAMP;
        //return HexagonCategory.SAND;
    }
}
