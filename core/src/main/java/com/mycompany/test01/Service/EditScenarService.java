package com.mycompany.test01.Service;

import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.mycompany.test01.Entity.Scenario.Scenario;
import com.mycompany.test01.Enum.OpponentSideEnum;

public class EditScenarService {
    private static EditScenarService instance = null;

    private Scenario scenario = null;

    private OpponentSideEnum[] sidesAll = OpponentSideEnum.values();

    public EditScenarService() {
        this.scenario = new Scenario();
        this.getScenario().setSidesCount(2);
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
