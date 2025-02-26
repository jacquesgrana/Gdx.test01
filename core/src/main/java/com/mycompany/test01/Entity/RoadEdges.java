package com.mycompany.test01.Entity;

public class RoadEdges {

    private RoadEdge[] edges;

    public RoadEdges() {
        this.edges = new RoadEdge[6];
        for(int k=0; k<6; k++) {
            this.edges[k] = new RoadEdge();
        }
    }

    public RoadEdge[] getEdges() {
        return edges;
    }

    public void setEdges(RoadEdge[] edges) {
        this.edges = edges;
    }
}
