package com.mycompany.test01.Service;

import com.mycompany.test01.Entity.Unit.Group.FrontGroup;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Enum.CountryEnum;

public class EditArmyService {
    private static EditArmyService instance;

    private UnitElement selectedUnit;
    private CountryEnum selectedCountry;
    private boolean isTreeRootNodeDefined;
    private FrontGroup rootGroup;


    public EditArmyService() {
        this.selectedUnit = null;
        this.selectedCountry = CountryEnum.NO_COUNTRY;
        this.isTreeRootNodeDefined = false;
        this.rootGroup = null;
    }

    public static EditArmyService getInstance() {
        if (instance == null) {
            instance = new EditArmyService();
        }
        return instance;
    }

    public UnitElement getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(UnitElement selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public CountryEnum getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(CountryEnum selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public boolean isTreeRootNodeDefined() {
        return isTreeRootNodeDefined;
    }

    public void setTreeRootNodeDefined(boolean treeRootNodeDefined) {
        isTreeRootNodeDefined = treeRootNodeDefined;
    }

    public FrontGroup getRootGroup() {
        return rootGroup;
    }

    public void setRootGroup(FrontGroup rootGroup) {
        this.rootGroup = rootGroup;
    }
}
