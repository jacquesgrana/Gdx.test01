package com.mycompany.test01.Entity.Map;

import com.mycompany.test01.Enum.BridgeTypeEnum;

public class BridgeEdge {
    private BridgeTypeEnum bridgeType;
    private boolean isBroken;

    public BridgeEdge() {
        this.bridgeType = BridgeTypeEnum.NO_BRIDGE;
        this.isBroken = false;
    }

    public BridgeTypeEnum getBridgeType() {
        return bridgeType;
    }

    public void setBridgeType(BridgeTypeEnum bridgeType) {
        this.bridgeType = bridgeType;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
