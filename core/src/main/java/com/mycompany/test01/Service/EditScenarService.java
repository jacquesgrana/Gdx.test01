package com.mycompany.test01.Service;

import com.mycompany.test01.Entity.Scenario.Opponent;
import com.mycompany.test01.Entity.Scenario.Scenario;

public class EditScenarService {
    private final int DEFAULT_SIDE_COUNT = 2;

    private static EditScenarService instance = null;

    private Scenario scenario = null;

    private Opponent selectedOpponent = null;

    //private OpponentSideEnum[] sidesAll = OpponentSideEnum.values();

    public EditScenarService() {
        this.scenario = new Scenario();
        this.getScenario().setSidesCount(DEFAULT_SIDE_COUNT);
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
