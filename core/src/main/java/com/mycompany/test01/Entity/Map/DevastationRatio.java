package com.mycompany.test01.Entity.Map;

public class DevastationRatio {
    private float ratio = 0.0f;

    public DevastationRatio() {
    }

    public DevastationRatio(float ratio) {
        this.ratio = ratio;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio > 1.0f ? 1.0f : Math.max(ratio, 0.0f);
    }
}
