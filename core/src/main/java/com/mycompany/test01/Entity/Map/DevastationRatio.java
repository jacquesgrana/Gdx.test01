package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Config.MapConfig;

public class DevastationRatio {
    private float ratio = MapConfig.MIN_DEVASTATION_RATIO;

    public DevastationRatio() {
    }

    public DevastationRatio(float ratio) {
        setRatio(ratio);
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio > MapConfig.MAX_DEVASTATION_RATIO ? MapConfig.MAX_DEVASTATION_RATIO : Math.max(ratio, MapConfig.MIN_DEVASTATION_RATIO);
    }
}
