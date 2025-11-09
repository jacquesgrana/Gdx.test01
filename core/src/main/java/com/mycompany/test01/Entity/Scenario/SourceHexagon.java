package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Entity.Map.Hexagon;

import java.util.Objects;

public class SourceHexagon {
    private Hexagon hexagon = null;
    private int rank = -1;

    public SourceHexagon() {
    }

    public SourceHexagon(Hexagon hexagon, int rank) {
        this.hexagon = hexagon;
        this.rank = rank;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public void setHexagon(Hexagon hexagon) {
        this.hexagon = hexagon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SourceHexagon that = (SourceHexagon) o;
        return this.hexagon.equals(that.hexagon); //rank == that.rank &&
    }

    @Override
    public int hashCode() {
        return Objects.hash(hexagon, rank);
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
