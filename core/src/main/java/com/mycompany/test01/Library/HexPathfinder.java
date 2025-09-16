package com.mycompany.test01.Library;
import com.badlogic.gdx.utils.Array;
import java.util.*;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Util.MapUtil;


public class HexPathfinder {
    private Array<Array<Hexagon>> hexesArray;
    private int limitI;
    private int limitJ;
    private int startI;
    private int startJ;

    public HexPathfinder(Array<Array<Hexagon>> hexesArray, int limitI, int limitJ, int startI, int startJ) {
        this.hexesArray = hexesArray;
        this.limitI = limitI;
        this.limitJ = limitJ;
        this.startI = startI;
        this.startJ = startJ;
    }

    /**
     * Trouve le chemin le plus court entre deux hexagones.
     * @param start Hexagone de départ.
     * @param goal Hexagone d'arrivée.
     * @param unit Unité pour laquelle calculer le chemin (optionnel, peut être null).
     * @return Liste d'hexagones (vide si aucun chemin).
     */
    public List<Hexagon> findPath(Hexagon start, Hexagon goal, Unit unit) {
        PriorityQueue<PathNode> openSet = new PriorityQueue<>();
        Set<Hexagon> closedSet = new HashSet<>();
        Map<Hexagon, PathNode> nodeMap = new HashMap<>();

        // Initialisation
        PathNode startNode = new PathNode(start, null, 0, heuristic(start, goal));
        openSet.add(startNode);
        nodeMap.put(start, startNode);

        while (!openSet.isEmpty()) {
            PathNode current = openSet.poll();

            if (current.hexagon == goal) {
                return reconstructPath(current);
            }

            closedSet.add(current.hexagon);

            // Récupère les voisins avec votre méthode existante
            Hexagon[] neighbors = MapUtil.getNeighborhoodHexes(
                current.hexagon.getX() - startI,  // i relatif
                current.hexagon.getY() - startJ,  // j relatif
                startI, startJ, limitI, limitJ, hexesArray
            );

            for (int direction = 0; direction < 6; direction++) {
                Hexagon neighbor = neighbors[direction];
                if (neighbor == null || closedSet.contains(neighbor)) {
                    continue;
                }

                // Calcule le coût en tenant compte de la direction d'entrée
                float movementCost = neighbor.getMovementCost(5 - direction, unit);
                if (movementCost >= Float.POSITIVE_INFINITY) {
                    continue; // Case bloquée
                }

                float tentativeG = current.g + movementCost;

                PathNode neighborNode = nodeMap.get(neighbor);
                if (neighborNode == null || tentativeG < neighborNode.g) {
                    neighborNode = new PathNode(neighbor, current, tentativeG, heuristic(neighbor, goal));
                    nodeMap.put(neighbor, neighborNode);
                    openSet.add(neighborNode);
                }
            }
        }

        return Collections.emptyList(); // Pas de chemin
    }

    // Heuristique pour A* (distance hexagonale)
    private float heuristic(Hexagon a, Hexagon b) {
        /*
        int dx = Math.abs(a.getX() - b.getX());
        int dy = Math.abs(a.getY() - b.getY());
        return (dx + Math.max(0, dy - dx / 2)); // Approximation de la distance hexagonale
        */
        return Hexagon.distance(a, b) * 0.7f; // Coût = distance × 1.0 (ajustable)
    }

    // Reconstruit le chemin à partir du nœud final
    /*
    private List<Hexagon> reconstructPath(PathNode current) {
        List<Hexagon> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current.hexagon);
            current = current.parent;
        }
        return path;
    }*/

    private List<Hexagon> reconstructPath(PathNode current) {
        List<Hexagon> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current.hexagon);
            current = current.parent;
        }
        return path;
    }



}

