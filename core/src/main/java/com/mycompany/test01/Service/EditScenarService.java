package com.mycompany.test01.Service;

import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.mycompany.test01.Entity.Scenario.Scenario;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.Enum.OpponentSideEnum;

public class EditScenarService {
    private final int DEFAULT_SIDE_COUNT = 2;

    private static EditScenarService instance = null;

    private Scenario scenario = null;

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

    public boolean isOpponentsOk() {
        boolean isOpponentsOk = true;
        for(int i=0; i<this.getScenario().getSidesCount(); i++) {
            boolean isOpponentOk = this.getScenario().getOpponents()[i].getCountry() != CountryEnum.NO_COUNTRY;
            if(i<this.getScenario().getSidesCount() - 1) {
                for(int j=i+1; j<this.getScenario().getSidesCount(); j++) {
                    isOpponentOk &= this.getScenario().getOpponents()[i].getCountry() != this.getScenario().getOpponents()[j].getCountry();
                }
            }
            isOpponentsOk &= isOpponentOk;
        }
        return isOpponentsOk;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
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
