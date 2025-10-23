package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Interface.unit.ElementInterface;

public class HexUnits {

    private HexUnit firstLine;
    private HexUnit secondLine;
    private HexUnit reserve;

    private HexUnit reserveSup;
    private HexUnit reserveMax;

    public HexUnits() {
        this.firstLine = new HexUnit();
        this.secondLine = new HexUnit();
        this.reserve = new HexUnit();
        this.reserveSup = new HexUnit();
        this.reserveMax = new HexUnit();
    }

    public HexUnits(HexUnit firstLine, HexUnit secondLine, HexUnit reserve, HexUnit reserveSup, HexUnit reserveMax) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.reserve = reserve;
        this.reserveSup = reserveSup;
        this.reserveMax = reserveMax;
    }

    public HexUnit getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(HexUnit firstLine) {
        this.firstLine = firstLine;
    }

    public HexUnit getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(HexUnit secondLine) {
        this.secondLine = secondLine;
    }

    public HexUnit getReserve() {
        return reserve;
    }

    public void setReserve(HexUnit reserve) {
        this.reserve = reserve;
    }

    public HexUnit getReserveSup() {
        return reserveSup;
    }

    public void setReserveSup(HexUnit reserveSup) {
        this.reserveSup = reserveSup;
    }

    public HexUnit getReserveMax() {
        return reserveMax;
    }

    public void setReserveMax(HexUnit reserveMax) {
        this.reserveMax = reserveMax;
    }

    // TODO ne plus utiliser reserveSup et reserveMax
    public boolean addUnitToUnits(ElementInterface unitToAdd) {
        boolean ok = false;
        if (unitToAdd.isCompany()) {
            if(this.firstLine.getUnitCount() < HexUnit.COMPANIES_PER_UNIT) {
                ok = this.firstLine.addUnit(unitToAdd);
            }
            else if(this.secondLine.getUnitCount() < HexUnit.COMPANIES_PER_UNIT) {
                ok = this.secondLine.addUnit(unitToAdd);
            }
            else if(this.reserve.getUnitCount() < HexUnit.COMPANIES_PER_UNIT) {
                ok = this.reserve.addUnit(unitToAdd);
            }
            /*
            else if(this.reserveSup.getUnitCount() < HexUnit.COMPANIES_PER_UNIT) {
                ok = this.reserveSup.addUnit(unitToAdd);
            }
            else if(this.reserveMax.getUnitCount() < HexUnit.COMPANIES_PER_UNIT) {
                ok = this.reserveMax.addUnit(unitToAdd);
            }
            */
        }
        else {
            if(this.firstLine.getUnitCount() == 0) {
                ok = this.firstLine.addUnit(unitToAdd);
            }
            else if(this.secondLine.getUnitCount() == 0) {
                ok = this.secondLine.addUnit(unitToAdd);
            }
            else if(this.reserve.getUnitCount() == 0) {
                ok = this.reserve.addUnit(unitToAdd);
            }
            else if(this.reserveSup.getUnitCount() == 0) {
                ok = this.reserveSup.addUnit(unitToAdd);
            }
            else if(this.reserveMax.getUnitCount() == 0) {
                ok = this.reserveMax.addUnit(unitToAdd);
            }
        }
        return ok;
    }

    public int getUnitsCount() {
        int toReturn = 0;
        toReturn += this.firstLine.getUnitCount();
        toReturn += this.secondLine.getUnitCount();
        toReturn += this.reserve.getUnitCount();
        toReturn += this.reserveSup.getUnitCount();
        toReturn += this.reserveMax.getUnitCount();
        return toReturn;
    }
}
