package com.mycompany.test01.Entity;

public class RoadEdge {
    private boolean pathway;
    private boolean roadway;
    private boolean railway;

    public RoadEdge() {
        this.pathway = false;
        this.roadway = false;
        this.railway = false;
    }

    public boolean isPathway() {
        return pathway;
    }

    public void setPathway(boolean path) {
        this.pathway = path;
    }

    public boolean isRoadway() {
        return roadway;
    }

    public void setRoadway(boolean road) {
        this.roadway = road;
    }

    public boolean isRailway() {
        return railway;
    }

    public void setRailway(boolean railway) {
        this.railway = railway;
    }
}
