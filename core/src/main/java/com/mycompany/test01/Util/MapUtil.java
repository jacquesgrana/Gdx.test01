package com.mycompany.test01.Util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.RoadCategory;

import java.util.HashSet;
import java.util.Set;

public class MapUtil {

    /**
     *
     * @param i : indice venant de l'affichage, sans prise en compte de startI
     * @param j: indice venant de l'affichage, sans prise en compte de startJ
     * @param startI : indice de la zone affichée (qui affiche une partie de la carte)
     * @param startJ : indice de la zone affichée (qui affiche une partie de la carte)
     * @param limitI : indice max
     * @param limitJ : indice max
     * @param hexesArray : contient les données de la carte
     * @return tableau des hex voisins si dans les limites (0>= <limitI et 0>= <limitJ) (hex null si hors de la carte)
     */
    public static Hexagon[] getNeighborhoodHexes(int i, int j, int startI, int startJ, int limitI, int limitJ, Array<Array<Hexagon>> hexesArray) {
        Hexagon[] toReturn = new Hexagon[6];
        for (int k=0; k<6; k++) {
            if(j % 2 == 0) {
                switch (k) {
                    case 0 : //NW
                        if(j-1+startJ >= 0) {
                            Hexagon northWest = hexesArray.get(i+startI).get(j-1+startJ);
                            toReturn[k] = northWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 1 : //NE
                        if(i+1+startI < limitI && j-1+startJ >= 0) {
                            Hexagon northEast = hexesArray.get(i+1+startI).get(j-1+startJ);
                            toReturn[k] = northEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 2 : //W
                        if(i-1+startI >= 0) {
                            Hexagon west = hexesArray.get(i-1+startI).get(j+startJ);
                            toReturn[k] = west;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 3 : //E
                        if(i+1+startI < limitI) {
                            Hexagon east = hexesArray.get(i+1+startI).get(j+startJ);
                            toReturn[k] = east;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 4 : //SW
                        if(j+1+startJ < limitJ) {
                            Hexagon southWest = hexesArray.get(i+startI).get(j+1+startJ);
                            toReturn[k] = southWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 5 : //SE
                        if(i+1+startI < limitI && j+1+startJ < limitJ) {
                            Hexagon southEast = hexesArray.get(i+1+startI).get(j+1+startJ);
                            toReturn[k] = southEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                }
            }
            else {
                switch (k) {
                    case 0 : //NW
                        if(i-1+startI >= 0 && j-1+startJ >= 0) {
                            Hexagon northWest = hexesArray.get(i-1+startI).get(j-1+startJ);
                            toReturn[k] = northWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 1 : //NE
                        if(j-1+startJ >= 0) {
                            Hexagon northEast = hexesArray.get(i+startI).get(j-1+startJ);
                            toReturn[k] = northEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 2 : //W
                        if(i-1+startI >= 0) {
                            Hexagon west = hexesArray.get(i-1+startI).get(j+startJ);
                            toReturn[k] = west;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 3 : //E
                        if(i+1+startI < limitI) {
                            Hexagon east = hexesArray.get(i+1+startI).get(j+startJ);
                            toReturn[k] = east;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 4 : //SW
                        if(i-1+startI >= 0 && j+1+startJ < limitJ) {
                            Hexagon southWest = hexesArray.get(i-1+startI).get(j+1+startJ);
                            toReturn[k] = southWest;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                    case 5 : //SE
                        if(j+1+startJ < limitJ) {
                            Hexagon southEast = hexesArray.get(i+startI).get(j+1+startJ);
                            toReturn[k] = southEast;
                        }
                        else {
                            toReturn[k] = null;
                        }
                        break;
                }
            }

        }

        return toReturn;
    }

    public static Set<Hexagon> getNeighborhoodHexesExtended(int i, int j, int startI, int startJ, int limitI, int limitJ, Array<Array<Hexagon>> hexesArray, int dist) {
        Set<Hexagon> toReturn = new HashSet<>();
        Set<Hexagon> currentLayer = new HashSet<>();

        // Ajouter l'hexagone de départ
        if (i + startI >= 0 && i + startI < limitI && j + startJ >= 0 && j + startJ < limitJ) {
            Hexagon startHex = hexesArray.get(i + startI).get(j + startJ);
            if (startHex != null) {
                currentLayer.add(startHex);
                toReturn.add(startHex);
            }
        }

        // Pour chaque niveau de distance
        for (int d = 0; d < dist; d++) {
            Set<Hexagon> nextLayer = new HashSet<>();

            // Pour chaque hexagone de la couche actuelle
            for (Hexagon hex : currentLayer) {
                int hexI = hex.getX() - startI;
                int hexJ = hex.getY() - startJ;

                // Récupérer ses voisins
                Hexagon[] neighbours = getNeighborhoodHexes(hexI, hexJ, startI, startJ, limitI, limitJ, hexesArray);

                // Ajouter les voisins non-null
                for (Hexagon neighbour : neighbours) {
                    if (neighbour != null && !toReturn.contains(neighbour)) {
                        nextLayer.add(neighbour);
                        toReturn.add(neighbour);
                    }
                }
            }
            currentLayer = nextLayer;
        }
        return toReturn;
    }


    public static boolean isInsideHexagon(int x, int y, int[] xPoints, int[] yPoints) {
        boolean inside = false;
        for (int i = 0, j = 5; i < 6; j = i++) {
            if (((yPoints[i] > y) != (yPoints[j] > y)) &&
                (x < (xPoints[j] - xPoints[i]) * (y - yPoints[i]) / (yPoints[j] - yPoints[i]) + xPoints[i])) {
                inside = !inside;
            }
        }
        return inside;
    }

    /**
     * Draws a textured hexagon onto the provided Pixmap.
     *
     * @param pixmap       The Pixmap to draw on.
     * @param centerX      The x-coordinate of the hexagon's center.
     * @param centerY      The y-coordinate of the hexagon's center.
     * @param size         The size (radius) of the hexagon.
     * @param texture      The texture to fill the hexagon with.  Must be non-null
     * @param borderColor  The color of the hexagon's border.
     */
    public static void drawHexagon(Pixmap pixmap, int centerX, int centerY, int size, Texture texture, Color borderColor) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * (i + 0.5);
            xPoints[i] = (int) (centerX + size * Math.cos(angle));
            yPoints[i] = (int) (centerY + size * Math.sin(angle));
        }

        // Fill with texture
        pixmap.setColor(Color.WHITE); // Important: set to white for texture drawing

        //Get the pixel data from the texture
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        if (texturePixmap != null) {
            for (int y = centerY - size; y <= centerY + size; y++) {
                for (int x = centerX - size; x <= centerX + size; x++) {
                    if (MapUtil.isInsideHexagon(x, y, xPoints, yPoints)) {
                        // Sample the texture
                        int textureX = (int) (((x - (centerX - size)) / (double) (2 * size)) * texturePixmap.getWidth());
                        int textureY = (int) (((y - (centerY - size)) / (double) (2 * size)) * texturePixmap.getHeight());

                        //Adjust textureX and textureY in case they are out of bounds
                        textureX = Math.max(0, Math.min(textureX, texturePixmap.getWidth() - 1));
                        textureY = Math.max(0, Math.min(textureY, texturePixmap.getHeight() - 1));

                        int pixelColor = texturePixmap.getPixel(textureX, textureY);
                        pixmap.drawPixel(x, y, pixelColor);
                    }
                }
            }
            texturePixmap.dispose();
        }


        // Contour
        pixmap.setColor(borderColor);
        for (int i = 0; i < 6; i++) {
            int j = (i + 1) % 6;
            pixmap.drawLine(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
        }
    }
}
