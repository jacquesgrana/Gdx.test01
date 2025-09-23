package com.mycompany.test01.Util;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.RoadCategory;

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

/*
    public static void drawRoadSegment(
        Pixmap drawingPixmap,
        int i, int j,
        RoadCategory roadCategory,
        int k,
        int hexagonSize,
        int margin,
        int gapX,
        int gapY
    ) {
        int x = getXFromIJ(i, j, gapX, margin);
        int y = getYFromJ(j, gapY, margin, hexagonSize);
        Texture texture = GraphicUtil.getRoadTextureFromRoadCatAndK(roadCategory, k);
        Pixmap texturePixmap = GraphicUtil.textureToPixmap(texture);

        // TODO faire méthode !!?
        if (texturePixmap != null) {
            // Draw the texture onto the drawingPixmap, scaling it to fit within the hexagonSize
            drawingPixmap.drawPixmap(
                texturePixmap, // Source Pixmap
                0, 0,            // Source X,Y (top-left of source)
                texturePixmap.getWidth(), texturePixmap.getHeight(), // Source width & height
                x - hexagonSize, y - hexagonSize,            // Dest X,Y (top-left of destination)
                hexagonSize * 2, hexagonSize * 2    // Dest width & height (scaling)
            );

            texturePixmap.dispose();
        }
        texture.dispose();
    }

    public static int getXFromIJ(int i, int j, int gapX, int margin) {
        int toReturn = (int) gapX * i + gapX / 2 + margin;
        if( j % 2 == 0) {
            toReturn += (int) gapX / 2;
        }
        return toReturn;
    }

    public static int getYFromJ (int j, int gapY, int margin, int hexagonSize) {
        return gapY * j + hexagonSize + margin;
    }*/

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
}
