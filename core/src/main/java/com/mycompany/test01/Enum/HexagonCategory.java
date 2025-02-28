package com.mycompany.test01.Enum;

public enum HexagonCategory {
    GRASS("Grass" , 1.0f, 0.8f),
    FOREST("Forest", 0.6f, 0.25f),
    SWAMP("Swamp", 0.4f, 0.2f),
    SAND("Sand", 0.75f, 0.5f),
    WATER("Water", 0.0f, 0.0f);

    private final String name;
    private final float costLeg;
    private final float costVehicle;

    HexagonCategory(String name, float costLeg, float costVehicle) {
        this.name = name;
        this.costLeg = costLeg;
        this.costVehicle = costVehicle;
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

    static public HexagonCategory getRandomCategory() {
        float random = (float) Math.random();
        if(random <= 0.5f) return HexagonCategory.GRASS;
        else if(random > 0.5f && random <= 0.75f) return HexagonCategory.FOREST;
        else if(random > 0.75f && random <= 0.8625f) return HexagonCategory.SAND;
        else if(random > 0.8625f && random <= 0.95f) return HexagonCategory.WATER;
        else return  HexagonCategory.SWAMP;
        //return HexagonCategory.SAND;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
