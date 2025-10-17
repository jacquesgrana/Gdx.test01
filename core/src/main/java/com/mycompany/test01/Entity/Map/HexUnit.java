package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Interface.unit.ElementInterface;

public class HexUnit {
    public static final int COMPANIES_PER_UNIT = 3;

    private ElementInterface[] hexUnit;

    public HexUnit() {
        this.hexUnit = new ElementInterface[COMPANIES_PER_UNIT];
        for(int i=0; i<COMPANIES_PER_UNIT; i++) {
            this.hexUnit[i] = null;
        }
    }

    public HexUnit(ElementInterface[] hexUnit) {
        this.hexUnit = hexUnit;
    }

    public ElementInterface[] getHexUnit() {
        return hexUnit;
    }

    public void setHexUnit(ElementInterface[] hexUnit) {
        this.hexUnit = hexUnit;
    }

    public int getUnitCount() {
        int toReturn = 0;

        for(ElementInterface unit : this.hexUnit) {
            if(unit != null) {
                if(unit.isCompany()) {
                    toReturn++;
                }
                else {
                    toReturn += COMPANIES_PER_UNIT;
                }
            }

        }
        return toReturn;
    }

    public boolean addUnit(ElementInterface unitToAdd) {
        boolean toReturn = false;
        if(unitToAdd.isCompany()) {
            /*
            // TODO : pas modulaire , '3' en dur
            if(COMPANY_MAX - this.getUnitCount() == 1 ) {
                this.hexUnit[2] = unitToAdd;
            }
            else if (COMPANY_MAX - this.getUnitCount() == 2) {
                this.hexUnit[1] = unitToAdd;
            }
            else if (COMPANY_MAX - this.getUnitCount() == 3) {
                this.hexUnit[0] = unitToAdd;
            }
            */

            for (int i=0; i<=COMPANIES_PER_UNIT; i++) {
                if(this.getUnitCount() == i) {
                    this.hexUnit[i] = unitToAdd;
                    toReturn = true;
                }
            }
        }
        else {
            if(this.getUnitCount() == 0) {
                this.hexUnit[0] = unitToAdd;
                toReturn = true;
            }
        }
        return toReturn;
    }

    public boolean removeUnit(ElementInterface unitToRemove) {
        for (int i=0; i<COMPANIES_PER_UNIT; i++) {
            if(this.hexUnit[i] != null && this.hexUnit[i].equals(unitToRemove)) {
                this.hexUnit[i] = null;
                this.reconstructHexUnit();
                return true;
            }
        }
        return false;
    }

    public void reconstructHexUnit() {
        if(this.getUnitCount() < COMPANIES_PER_UNIT) {
            ElementInterface[] newTab = new ElementInterface[COMPANIES_PER_UNIT];
            int counter = 0;
            for (int i=0; i<COMPANIES_PER_UNIT; i++) {
                newTab[i] = null;
                if(this.hexUnit[i] != null) {
                    newTab[i - counter] = hexUnit[i];
                }
                else {
                    counter++;
                }
            }
            if (counter > 0) this.setHexUnit(newTab);
        }
    }

    public boolean contains(ElementInterface unitToTest) {
        for (int i=0; i<COMPANIES_PER_UNIT; i++) {
            if(this.hexUnit[i] != null && this.hexUnit[i].equals(unitToTest)) {
                return true;
            }
        }
        return false;
    }
}
