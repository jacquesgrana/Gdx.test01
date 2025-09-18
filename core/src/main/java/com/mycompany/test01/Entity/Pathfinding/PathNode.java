package com.mycompany.test01.Entity.Pathfinding;

import com.mycompany.test01.Entity.Map.Hexagon;

public class PathNode implements Comparable<PathNode> {
    private Hexagon hexagon;
    private PathNode parent;
    private float g; // Coût depuis le départ
    private float h; // Heuristique
    private float f; // f = g + h

    public PathNode(Hexagon hexagon, PathNode parent, float g, float h) {
        this.hexagon = hexagon;
        this.parent = parent;
        this.g = g;
        this.h = h;
        this.f = g + h;
    }

    @Override
    public int compareTo(PathNode other) {
        return Float.compare(this.f, other.f);
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public void setHexagon(Hexagon hexagon) {
        this.hexagon = hexagon;
    }

    public PathNode getParent() {
        return parent;
    }

    public void setParent(PathNode parent) {
        this.parent = parent;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }
}

