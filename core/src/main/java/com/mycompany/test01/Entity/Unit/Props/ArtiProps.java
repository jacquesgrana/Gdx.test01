package com.mycompany.test01.Entity.Unit.Props;

public class ArtiProps {
    private int range;
    private int artAttack;
    private int artDefense;
    private int prepDelay;

    public ArtiProps() {
        super();
        this.range = 6;
        this.artAttack = 4;
        this.artDefense = 2;
        this.prepDelay = 3;
    }

    public ArtiProps(int range, int artAttack, int artDefense, int prepDelay) {
        this.range = range;
        this.artAttack = artAttack;
        this.artDefense = artDefense;
        this.prepDelay = prepDelay;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getArtAttack() {
        return artAttack;
    }

    public void setArtAttack(int artAttack) {
        this.artAttack = artAttack;
    }

    public int getArtDefense() {
        return artDefense;
    }

    public void setArtDefense(int artDefense) {
        this.artDefense = artDefense;
    }

    public int getPrepDelay() {
        return prepDelay;
    }

    public void setPrepDelay(int prepDelay) {
        this.prepDelay = prepDelay;
    }
}
