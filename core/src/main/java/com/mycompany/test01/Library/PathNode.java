package com.mycompany.test01.Library;

import com.mycompany.test01.Entity.Map.Hexagon;

class PathNode implements Comparable<PathNode> {
    Hexagon hexagon;
    PathNode parent;
    float g; // Coût depuis le départ
    float h; // Heuristique
    float f; // f = g + h

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
}

