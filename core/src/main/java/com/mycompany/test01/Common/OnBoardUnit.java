package com.mycompany.test01.Common;

import com.mycompany.test01.Interface.unit.ElementInterface;

public class OnBoardUnit {
    private ElementInterface unit;
    private int iAbs;
    private int jAbs;

    public OnBoardUnit() {
        this.unit = null;
        this.iAbs = -1;
        this.jAbs = -1;
    }

    public OnBoardUnit(ElementInterface unit, int iAbs, int jAbs) {
        this.unit = unit;
        this.iAbs = iAbs;
        this.jAbs = jAbs;
    }

    public ElementInterface getUnit() {
        return unit;
    }

    public void setUnit(ElementInterface unit) {
        this.unit = unit;
    }

    public int getiAbs() {
        return iAbs;
    }

    public void setiAbs(int iAbs) {
        this.iAbs = iAbs;
    }

    public int getjAbs() {
        return jAbs;
    }

    public void setjAbs(int jAbs) {
        this.jAbs = jAbs;
    }

    public boolean equals(OnBoardUnit other) {
        return this.unit.equals(other.getUnit());
    }
}
