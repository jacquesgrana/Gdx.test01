package com.mycompany.test01.Entity;

import com.badlogic.gdx.utils.Array;

public class MapData {
    private String name;
    private long creationDate;
    private long modificationDate;
    private Hexagon[][] dataTab;
    private int limitI;
    private int limitJ;

    public MapData(String name, int limitI, int limitJ, Array<Array<Hexagon>> dataSource) {
        this.name = name;
        this.creationDate = -1;
        this.modificationDate = -1;
        //int limitI = dataSource.size;
        //int limitJ = dataSource.get(0).size;
        this.limitI = limitI;
        this.limitJ = limitJ;
        this.dataTab = new Hexagon[limitI][limitJ];
        for (int i = 0; i < limitI; i++) {
            for (int j = 0; j < limitJ; j++) {
                this.dataTab[i][j] = dataSource.get(i).get(j);
            }
        }
    }

    public MapData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(long modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Hexagon[][] getDataTab() {
        return dataTab;
    }

    public void setDataTab(Hexagon[][] dataTab) {
        this.dataTab = dataTab;
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
