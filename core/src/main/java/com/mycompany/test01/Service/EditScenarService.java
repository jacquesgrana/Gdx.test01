package com.mycompany.test01.Service;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Entity.Map.MapData;

public class EditScenarService {
    private static EditScenarService instance = null;

    private Array<Array<Hexagon>> hexesArray;
    private int limitI;
    private int limitJ;

    public EditScenarService() {
    }

    public static EditScenarService getInstance() {
        if (instance == null) {
            instance = new EditScenarService();
        }
        return instance;
    }

    public void initMap() {

    }

    public void SetMapData(MapData mapData) {
        limitI = mapData.getLimitI();
        limitJ = mapData.getLimitJ();
        this.hexesArray = new Array<Array<Hexagon>>(limitI);
        for (int i = 0; i < limitI; i++) {
            Array<Hexagon> row = new Array<Hexagon>(limitJ);
            for (int j = 0; j < limitJ; j++) {
                row.add(mapData.getDataTab()[i][j]);
            }
            this.hexesArray.add(row);
        }
        System.out.println("limitI : " + limitI + " / limitJ : " + limitJ);
        initMap();
        //generateBridgesFromRiversAndRoads();
    }


    public Array<Array<Hexagon>> getHexesArray() {
        return hexesArray;
    }

    public void setHexesArray(Array<Array<Hexagon>> hexesArray) {
        this.hexesArray = hexesArray;
    }

    public int getLimitI() {
        return limitI;
    }

    public void setLimitI(int limitI) {
        this.limitI = limitI;
    }

    public int getLimitJ() {
        return limitJ;
    }

    public void setLimitJ(int limitJ) {
        this.limitJ = limitJ;
    }
}
