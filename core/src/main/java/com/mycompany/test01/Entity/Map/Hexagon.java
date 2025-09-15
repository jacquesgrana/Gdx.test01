package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.FortificationCategory;
import com.mycompany.test01.Enum.HexagonCategory;
import com.mycompany.test01.Enum.RiverCategory;

import java.util.Arrays;

// TODO changer category en terrain ??
public class Hexagon {
    private int x;
    private int y;
    private HexagonCategory category;
    private FortificationCategory fortification;
    private RoadEdges roads;
    private RiverCategory[] rivers;
    private BridgeEdges bridges;
    private Cliff[] cliffs;


    public Hexagon() {
    }

    public Hexagon(int x, int y, HexagonCategory category, FortificationCategory fortification) {
        this.x = x;
        this.y = y;
        this.category = category;
        this.fortification = fortification;
        this.roads = new RoadEdges();
        this.rivers = new RiverCategory[6];
        Arrays.fill(this.rivers, RiverCategory.NO_RIVER);
        this.bridges = new BridgeEdges();
        this.cliffs = new Cliff[6];
        for(int i=0; i<6; i++) {
            this.cliffs[i] = new Cliff();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public HexagonCategory getCategory() {
        return category;
    }

    public void setCategory(HexagonCategory category) {
        this.category = category;
    }

    public FortificationCategory getFortification() {
        return fortification;
    }

    public void setFortification(FortificationCategory fortification) {
        this.fortification = fortification;
    }

    public RoadEdges getRoads() {
        return roads;
    }

    public void setRoads(RoadEdges roads) {
        this.roads = roads;
    }

    public RiverCategory[] getRivers() {
        return rivers;
    }

    public void setRivers(RiverCategory[] rivers) {
        this.rivers = rivers;
    }

    public BridgeEdges getBridges() {
        return bridges;
    }

    public void setBridges(BridgeEdges bridges) {
        this.bridges = bridges;
    }


    public Cliff[] getCliffs() {
        return cliffs;
    }

    public void setCliffs(Cliff[] cliffs) {
        this.cliffs = cliffs;
    }

    private float getBaseMovementCost(Unit unit) {
        switch (category) {
            case GRASS:
                return 1.2f;
            case FOREST:
                return 2.5f;
            case WATER:
                return Float.POSITIVE_INFINITY;
            case SWAMP:
                return 3.5f;
            case SAND:
                return 1.4f;
            case CITY_DENSE:
                return 1.2f;
            case CITY_LIGHT:
                return 1.0f;
            default:
                return 1.0f;
        }
    }

    /**
     * Calcule le coût total pour entrer dans cet hexagone depuis un voisin.
     * @param fromDirection Direction d'où vient l'unité (0-5, où 0=N, 1=NE, etc.).
     * @param unit Unité concernée (peut être null).
     * @return Coût total (1 = normal, >1 = difficile, Integer.MAX_VALUE = bloqué).
     */
    public float getMovementCost(int fromDirection, Unit unit) {
        // 1. Coût de base selon le terrain
        float cost = getBaseMovementCost(unit);

        /*
        // 2. Vérifie les rivières (sans pont = bloqué, sauf unité amphibie)
        if (this.rivers[fromDirection] != RiverCategory.NO_RIVER) {
            if (!this.bridges.getEdges()[fromDirection]) {
                if (unit == null || !unit.isAmphibious()) {
                    return Integer.MAX_VALUE; // Bloqué
                } else {
                    cost *= 1.5f; // Unité amphibie : coût doublé (ex: traversée lente)
                }
            }
            // Sinon, il y a un pont : pas de malus supplémentaire
        }

        // 3. Vérifie les falaises (bloquant sauf unité volante)
        if (this.cliffs[fromDirection].isBlocking()) {
            if (unit == null || !unit.isFlying()) {
                return Integer.MAX_VALUE; // Bloqué
            }
            // Unité volante : ignore les falaises
        }

        // 4. Bonus si route dans la direction d'entrée
        if (this.roads.hasRoad(fromDirection)) {
            cost = Math.max(1, cost / 2); // Réduit le coût de moitié (minimum 1)
        }

        // 5. Malus si fortification (sauf si unité est propriétaire)
        if (this.fortification != FortificationCategory.NONE) {
            if (unit == null || !unit.ownsFortification(this)) {
                cost *= 2; // Coût doublé pour traverser une fortification ennemie
            }
        }
        */
        return cost;
    }

    /**
     * Calcule la distance entre deux hexagones (en coordonnées cubiques).
     * Retourne un float pour plus de précision.
     */
    public static float distance(Hexagon a, Hexagon b) {
        // Conversion en coordonnées cubiques (q, r, s)
        float q1 = a.getX();
        float r1 = a.getY() - (a.getX() - (a.getX() & 1)) / 2f; // Décalage pour les lignes paires
        float q2 = b.getX();
        float r2 = b.getY() - (b.getX() - (b.getX() & 1)) / 2f;

        return (Math.abs(q1 - q2) + Math.abs(q1 + r1 - q2 - r2) + Math.abs(r1 - r2)) / 2f;
    }


}
