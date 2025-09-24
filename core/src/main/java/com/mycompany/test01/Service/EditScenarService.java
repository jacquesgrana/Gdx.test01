package com.mycompany.test01.Service;

import com.mycompany.test01.Entity.Scenario.Scenario;

public class EditScenarService {
    private static EditScenarService instance = null;

    private Scenario scenario = null;

    public EditScenarService() {
        this.scenario = new Scenario();
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
}
