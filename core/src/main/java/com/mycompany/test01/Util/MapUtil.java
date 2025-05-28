package com.mycompany.test01.Util;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;

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
}
