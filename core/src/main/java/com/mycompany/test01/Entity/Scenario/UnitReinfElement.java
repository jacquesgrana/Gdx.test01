package com.mycompany.test01.Entity.Scenario;

import com.mycompany.test01.Entity.Map.Hexagon;

import java.util.Objects;

public class UnitReinfElement {

    private int dayNumber = 1;
    private int infEngReinf = 0;
    private int artiReinf = 0;
    private int atAaReinf = 0;
    private int tankReinf = 0;
    private int hqReinf = 0;
    private int paraReinf = 0;
    private int marineReinf = 0;
    private int mountainReinf = 0;
    private SourceHexagon unitReinfSource = null;

    public UnitReinfElement() {
    }

    public UnitReinfElement(
        int dayNumber,
        int infEngReinf,
        int artiReinf,
        int atAaReinf,
        int tankReinf,
        int hqReinf,
        int paraReinf,
        int marineReinf,
        int mountainReinf,
        SourceHexagon unitReinfSource
    ) {
        this.dayNumber = dayNumber;
        this.infEngReinf = infEngReinf;
        this.artiReinf = artiReinf;
        this.atAaReinf = atAaReinf;
        this.tankReinf = tankReinf;
        this.hqReinf = hqReinf;
        this.paraReinf = paraReinf;
        this.marineReinf = marineReinf;
        this.mountainReinf = mountainReinf;
        this.unitReinfSource = unitReinfSource;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitReinfElement that = (UnitReinfElement) o;
        return dayNumber == that.dayNumber && infEngReinf == that.infEngReinf && artiReinf == that.artiReinf && atAaReinf == that.atAaReinf && tankReinf == that.tankReinf && hqReinf == that.hqReinf && paraReinf == that.paraReinf && marineReinf == that.marineReinf && mountainReinf == that.mountainReinf && Objects.equals(unitReinfSource, that.unitReinfSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, infEngReinf, artiReinf, atAaReinf, tankReinf, hqReinf, paraReinf, marineReinf, mountainReinf, unitReinfSource);
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getInfEngReinf() {
        return infEngReinf;
    }

    public void setInfEngReinf(int infEngReinf) {
        this.infEngReinf = infEngReinf;
    }

    public int getArtiReinf() {
        return artiReinf;
    }

    public void setArtiReinf(int artiReinf) {
        this.artiReinf = artiReinf;
    }

    public int getAtAaReinf() {
        return atAaReinf;
    }

    public void setAtAaReinf(int atAaReinf) {
        this.atAaReinf = atAaReinf;
    }

    public int getTankReinf() {
        return tankReinf;
    }

    public void setTankReinf(int tankReinf) {
        this.tankReinf = tankReinf;
    }

    public int getHqReinf() {
        return hqReinf;
    }

    public void setHqReinf(int hqReinf) {
        this.hqReinf = hqReinf;
    }

    public int getParaReinf() {
        return paraReinf;
    }

    public void setParaReinf(int paraReinf) {
        this.paraReinf = paraReinf;
    }

    public int getMarineReinf() {
        return marineReinf;
    }

    public void setMarineReinf(int marineReinf) {
        this.marineReinf = marineReinf;
    }

    public int getMountainReinf() {
        return mountainReinf;
    }

    public void setMountainReinf(int mountainReinf) {
        this.mountainReinf = mountainReinf;
    }

    public SourceHexagon getUnitReinfSource() {
        return unitReinfSource;
    }

    public void setUnitReinfSource(SourceHexagon unitReinfSource) {
        this.unitReinfSource = unitReinfSource;
    }
}
