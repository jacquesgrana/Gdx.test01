package com.mycompany.test01.Enum;

public enum HexagonCategory {
    GRASS("Grass" , 1.5f, 1.5f),
    FOREST("Forest", 2.5f, 3.0f),
    SWAMP("Swamp", 3.0f, Float.POSITIVE_INFINITY),
    SAND("Sand", 1.5f, 1.7f),
    WATER("Water", Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
    CITY_LIGHT("City Light", 1.2f, 1.75f),
    CITY_DENSE("City Dense", 1.3f, 2.0f);

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
