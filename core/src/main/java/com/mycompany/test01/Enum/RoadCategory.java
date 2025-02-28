package com.mycompany.test01.Enum;

public enum RoadCategory {
    NO_ROAD("No Road", 1.0f, 1.0f),
    PATHWAY("Pathway", 0.80f, 0.65f),
    ROADWAY("Roadway", 0.75f, 0.4f),
    RAILWAY("Railway", 0.75f, 0.4f);

    private final String name;
    private final float costLeg;
    private final float costVehicle;


    RoadCategory(String name, float costLeg, float costVehicle) {
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

    @Override
    public String toString() {
        return name; // Optional: Override toString() for simpler display
    }
}

