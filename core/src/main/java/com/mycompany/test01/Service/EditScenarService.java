package com.mycompany.test01.Service;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Common.OnBoardUnit;
import com.mycompany.test01.Common.ScenarUnitNode;
import com.mycompany.test01.Config.ScenarConfig;
import com.mycompany.test01.Entity.Scenario.Opponent;
import com.mycompany.test01.Entity.Scenario.Scenario;
import com.mycompany.test01.Interface.unit.ElementInterface;

public class EditScenarService {
    //private final int DEFAULT_SIDE_COUNT = 2;

    private static EditScenarService instance = null;

    private Scenario scenario = null;

    private Opponent selectedOpponent = null;

    private ElementInterface selectedUnit = null;

    //private ScenarUnitNode selectedTreeNode;

    // TODO : passer dans la map du scenar?
    private int mapBrushSize = 0;

    //private OpponentSideEnum[] sidesAll = OpponentSideEnum.values();

    public EditScenarService() {
        this.scenario = new Scenario();
        this.getScenario().setSidesCount(ScenarConfig.DEFAULT_SIDE_COUNT);
        this.getScenario().setSidesFromCount();
        //this.zoomLevel = ZoomLevelEnum.NORMAL_VIEW;
    }

    public static EditScenarService getInstance() {
        if (instance == null) {
            instance = new EditScenarService();
        }
        return instance;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Opponent getSelectedOpponent() {
        return selectedOpponent;
    }

    public void setSelectedOpponent(Opponent selectedOpponent) {
        this.selectedOpponent = selectedOpponent;
    }

    public int getMapBrushSize() {
        return mapBrushSize;
    }

    public void setMapBrushSize(int mapBrushSize) {
        this.mapBrushSize = mapBrushSize;
    }

    public ElementInterface getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(ElementInterface selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    /*
    public ScenarUnitNode getSelectedTreeNode() {
        return selectedTreeNode;
    }

    public void setSelectedTreeNode(ScenarUnitNode selectedTreeNode) {
        this.selectedTreeNode = selectedTreeNode;
    }

     */


    /*
    public void setSidesFromCount() {
        this.getScenario().setSides(new OpponentSideEnum[6]);
        int cpt = 0;
        for (int i=0; i<6; i++) {
            this.getScenario().getSides()[i] = OpponentSideEnum.NO_SIDE;
            if(cpt < this.getScenario().getSidesCount()) {
                this.getScenario().getSides()[i] = this.sidesAll[i];
            }
            System.out.println("side n°" + i + " : " +  this.getScenario().getSides()[i].toString());
            cpt++;
        }
    }*/
}
