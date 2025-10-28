package com.mycompany.test01.Enum;

import com.badlogic.gdx.graphics.Color;
import com.mycompany.test01.Util.GraphicUtil;

public enum RoadCategory {
    NO_ROAD("No Road", 1.0f, 1.0f, Color.WHITE),
    PATHWAY("Pathway", 0.80f, 0.65f, Color.BROWN),
    ROADWAY("Roadway", 0.75f, 0.4f, Color.LIGHT_GRAY),
    RAILWAY("Railway", 0.75f, 0.4f, Color.BLACK);

    private final String name;
    private final float costLeg;
    private final float costVehicle;
    private final Color lineColor;


    RoadCategory(String name, float costLeg, float costVehicle, Color lineColor) {
        this.name = name;
        this.costLeg = costLeg;
        this.costVehicle = costVehicle;
        this.lineColor = lineColor;
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

    public Color getLineColor() { return lineColor; }

    @Override
    public String toString() {
        return name; // Optional: Override toString() for simpler display
    }
}

