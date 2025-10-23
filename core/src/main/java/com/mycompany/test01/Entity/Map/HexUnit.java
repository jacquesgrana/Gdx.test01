package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Util.LogUtil;

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

        //LogUtil.logInfo("getUnitCount : hexUnitSize : " + this.hexUnit.length );
        int cpt = 0;
        for(ElementInterface unit : this.hexUnit) {
            if(unit != null) {
                cpt++;
                //LogUtil.logInfo("getUnitCount : isCompany : " + unit.isCompany());
                if(unit.isCompany()) {
                    toReturn++;
                }
                else {
                    toReturn += COMPANIES_PER_UNIT;
                }
            }

        }
        //LogUtil.logInfo("getUnitCount : non null count : " + cpt);
        return toReturn;
    }

    public boolean addUnit(ElementInterface unitToAdd) {
        boolean toReturn = false;
        if(unitToAdd.isCompany()) {

            LogUtil.logInfo("add company unit : getUnitCount av ajout : " + this.getUnitCount());

            /*
            for (int i=0; i<COMPANIES_PER_UNIT; i++) {
                if(this.getUnitCount() == i) {
                    this.hexUnit[i] = unitToAdd;
                    toReturn = true;
                }
            }*/

            if(this.getUnitCount() < COMPANIES_PER_UNIT) {
                this.hexUnit[getUnitCount()] = unitToAdd;
            }

            LogUtil.logInfo("add company unit : getUnitCount ap ajout : " + this.getUnitCount());

        }
        else {
            LogUtil.logInfo("add non company unit : getUnitCount av ajout : " + this.getUnitCount());

            if(this.getUnitCount() == 0) {
                this.hexUnit[0] = unitToAdd;
                toReturn = true;
            }
            LogUtil.logInfo("add non company unit : getUnitCount ap ajout : " + this.getUnitCount());

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
