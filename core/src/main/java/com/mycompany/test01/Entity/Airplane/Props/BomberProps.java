package com.mycompany.test01.Entity.Airplane.Props;

public class BomberProps {

    private int bombAttack;
    private int accuracy;

    public BomberProps() {
        this.bombAttack = 1;
        this.accuracy = 0;
    }

    public BomberProps(int bombAttack, int accuracy) {
        this.bombAttack = bombAttack;
        this.accuracy = accuracy;
    }

    public int getBombAttack() {
        return bombAttack;
    }

    public void setBombAttack(int bombAttack) {
        this.bombAttack = bombAttack;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
