package com.mycompany.test01.Util;

import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Enum.BridgeTypeEnum;
import com.mycompany.test01.Enum.RiverCategory;
import com.mycompany.test01.Service.EditScenarService;

public class MovementUtil {
    private static final EditScenarService editScenarService = EditScenarService.getInstance();

    private static float getBaseMovementCost(Unit unit, Hexagon hex) {
        /*
        switch (category) {
            case GRASS:
                return 1.5f;
            case FOREST:
                return 2.5f;
            case WATER:
                return Float.POSITIVE_INFINITY;
            case SWAMP:
                return 3.5f;
            case SAND:
                return 1.7f;
            case CITY_DENSE:
                return 2.0f;
            case CITY_LIGHT:
                return 1.75f;
            default:
                return 1.0f;
        }
        */
        if(unit == null) {
            return hex.getCategory().getCostVehicle();
        }
        else {
            return UnitUtil.hasVehicle(unit) ? hex.getCategory().getCostVehicle() : hex.getCategory().getCostLeg();
        }
    }

    /**
     * Calcule le coût total pour entrer dans cet hexagone depuis un voisin.
     * @param fromDirection Direction d'où vient l'unité (0-5 :
     * 0:NW, 1:NE, 2:W, 3:E, 4:SW, 5:SE)
     * @param unit Unité concernée (peut être null).
     * @return Coût total (1 = normal, >1 = difficile, Float.POSITIVE_INFINITY = bloqué).
     */
    public static float getMovementCost(int fromDirection, Unit unit, Hexagon hex) {
        // 1. Coût de base selon le terrain
        float cost = getBaseMovementCost(unit, hex);

        // rivières
        if(hex.getBridges().getEdges()[fromDirection].getBridgeType() == BridgeTypeEnum.NO_BRIDGE) {
            if(hex.getRivers()[fromDirection] != RiverCategory.NO_RIVER ) {
                if(hex.getRivers()[fromDirection] == RiverCategory.NARROW) {
                    cost += 4.0f;
                }
                else {
                    cost = Float.POSITIVE_INFINITY;
                }
            }
        }
        else {
            cost = 1.0f;
        }


        // falaises
        Hexagon[] neighbours = MapUtil.getNeighborhoodHexes(
            hex.getX() - editScenarService.getScenario().getMap().getStartI(),  // i relatif
            hex.getY() - editScenarService.getScenario().getMap().getStartJ(),  // j relatif
            editScenarService.getScenario().getMap().getStartI(), editScenarService.getScenario().getMap().getStartJ(), editScenarService.getScenario().getMap().getLimitI(), editScenarService.getScenario().getMap().getLimitJ(), editScenarService.getScenario().getMap().getHexesArray()
        );
        Hexagon next = neighbours[fromDirection]; // (fromDirection + 3) % 6
        if(next.getCliffs()[5 - fromDirection].isCliff() || hex.getCliffs()[fromDirection].isCliff()) {
            cost = Float.POSITIVE_INFINITY;
        }

        // routes
        if(hex.getRoads().getEdges()[fromDirection].isRoadway()){
            cost = 0.9f;
        }
        else if(hex.getRoads().getEdges()[fromDirection].isRailway()) {
            cost = 1.0f;
        }
        else if(hex.getRoads().getEdges()[fromDirection].isPathway()) {
            cost = 1.1f;
        }

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
