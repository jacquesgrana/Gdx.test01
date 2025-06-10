package com.mycompany.test01.Entity.Unit.Props;

public class CombatProps {
    // class ? -> enum?
    // tier ? -> enum?

    private int moralMax;
    //private int orgaMax;
    private int manpowerMax;
    private int softAttack;
    private int hardAttack;
    private int airAttack;
    private int softDefense;
    private int hardDefense;
    private int airDefense;
    private int speed;
    private boolean isCombatUnit;

    public CombatProps() {
    }

    public CombatProps(
        int moralMax,
        int manpowerMax,
        int softAttack,
        int hardAttack,
        int airAttack,
        int softDefense,
        int hardDefense,
        int airDefense,
        int speed,
        boolean isCombatUnit
    ) {
        this.moralMax = moralMax;
        this.manpowerMax = manpowerMax;
        this.softAttack = softAttack;
        this.hardAttack = hardAttack;
        this.airAttack = airAttack;
        this.softDefense = softDefense;
        this.hardDefense = hardDefense;
        this.airDefense = airDefense;
        this.speed = speed;
        this.isCombatUnit = isCombatUnit;
    }

    public int getMoralMax() {
        return moralMax;
    }

    public void setMoralMax(int moralMax) {
        this.moralMax = moralMax;
    }

    public int getManpowerMax() {
        return manpowerMax;
    }

    public void setManpowerMax(int manpowerMax) {
        this.manpowerMax = manpowerMax;
    }

    public int getSoftAttack() {
        return softAttack;
    }

    public void setSoftAttack(int softAttack) {
        this.softAttack = softAttack;
    }

    public int getHardAttack() {
        return hardAttack;
    }

    public void setHardAttack(int hardAttack) {
        this.hardAttack = hardAttack;
    }

    public int getAirAttack() {
        return airAttack;
    }

    public void setAirAttack(int airAttack) {
        this.airAttack = airAttack;
    }

    public int getSoftDefense() {
        return softDefense;
    }

    public void setSoftDefense(int softDefense) {
        this.softDefense = softDefense;
    }

    public int getHardDefense() {
        return hardDefense;
    }

    public void setHardDefense(int hardDefense) {
        this.hardDefense = hardDefense;
    }

    public int getAirDefense() {
        return airDefense;
    }

    public void setAirDefense(int airDefense) {
        this.airDefense = airDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isCombatUnit() {
        return isCombatUnit;
    }

    public void setCombatUnit(boolean combatUnit) {
        isCombatUnit = combatUnit;
    }
}
