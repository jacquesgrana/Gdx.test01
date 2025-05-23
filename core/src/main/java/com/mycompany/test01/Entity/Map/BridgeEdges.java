package com.mycompany.test01.Entity.Map;

public class BridgeEdges {

    private BridgeEdge[] edges;

    public BridgeEdges() {
        this.edges = new BridgeEdge[6];
        for(int k=0; k<6; k++) {
            this.edges[k] = new BridgeEdge();
        }
    }

    public BridgeEdge[] getEdges() {
        return edges;
    }

    public void setEdges(BridgeEdge[] edges) {
        this.edges = edges;
    }
}
