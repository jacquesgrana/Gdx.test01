package com.mycompany.test01.Entity.Airplane.Props;

public class ObserverProps {

    private int visionRange;
    private int visionAccuracy;

    public ObserverProps() {
        this.visionRange = 1;
        this.visionAccuracy = 1;
    }

    public ObserverProps(int visionRange, int visionAccuracy) {
        this.visionRange = visionRange;
        this.visionAccuracy = visionAccuracy;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    public int getVisionAccuracy() {
        return visionAccuracy;
    }

    public void setVisionAccuracy(int visionAccuracy) {
        this.visionAccuracy = visionAccuracy;
    }
}
