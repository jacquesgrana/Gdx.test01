package com.mycompany.test01.Service;

import com.mycompany.test01.Entity.Unit.UnitElement;
import com.mycompany.test01.Enum.CountryEnum;

public class EditArmyService {
    private static EditArmyService instance;

    private UnitElement selectedUnit;
    private CountryEnum selectedCountry; // TODO dans editArmyService

    public EditArmyService() {
        this.selectedUnit = null;
        this.selectedCountry = CountryEnum.NO_COUNTRY;
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
}
