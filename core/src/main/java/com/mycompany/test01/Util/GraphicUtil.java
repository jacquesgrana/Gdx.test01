package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mycompany.test01.Common.OnBoardUnit;
import com.mycompany.test01.Common.ScenarUnitNode;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Entity.Map.Cliff;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Screen.EditArmyScreen;
import com.mycompany.test01.Screen.EditScenarScreen;

import java.nio.ByteBuffer;

public class GraphicUtil {

    public static Texture groupTreeIconGroupTexture = loadTextureFromFile("texture/icon/texture-group@4x.png");
    public static Texture groupTreeIconUnitTexture = loadTextureFromFile("texture/icon/texture-unit@4x.png");


    public static Texture grassTexture = loadTextureFromFile("texture/terrain/texture-grass.png");
    public static Texture forestTexture = loadTextureFromFile("texture/terrain/texture-forest.png");
    public static Texture sandTexture = loadTextureFromFile("texture/terrain/texture-sand.png");
    public static Texture swampTexture = loadTextureFromFile("texture/terrain/texture-swamp.png");
    public static Texture waterTexture = loadTextureFromFile("texture/terrain/texture-water.png");
    public static Texture cityLightTexture = loadTextureFromFile("texture/terrain/texture-city-light.png");
    public static Texture cityDenseTexture = loadTextureFromFile("texture/terrain/texture-city-dense.png");

    public static Texture redTexture = loadTextureFromFile("texture/terrain/texture-red.png");
    public static Texture orangeTexture = loadTextureFromFile("texture/terrain/texture-orange.png");

    public static Texture fortifConcreteLightTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-light.png");
    public static Texture fortifConcreteMediumTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-medium.png");
    public static Texture fortifConcreteHeavyTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-heavy.png");

    public static Texture fortifWoodLightTexture = loadTextureFromFile("texture/fortification/texture-fortif-wood-light.png");
    public static Texture fortifWoodMediumTexture = loadTextureFromFile("texture/fortification/texture-fortif-wood-medium.png");

    public static Texture pathway0NWTexture = loadTextureFromFile("texture/road/pathway/texture-0-nw-pathway.png");
    public static Texture pathway1NETexture = loadTextureFromFile("texture/road/pathway/texture-1-ne-pathway.png");
    public static Texture pathway2WTexture = loadTextureFromFile("texture/road/pathway/texture-2-w-pathway.png");
    public static Texture pathway3ETexture = loadTextureFromFile("texture/road/pathway/texture-3-e-pathway.png");
    public static Texture pathway4SWTexture = loadTextureFromFile("texture/road/pathway/texture-4-sw-pathway.png");
    public static Texture pathway5SETexture = loadTextureFromFile("texture/road/pathway/texture-5-se-pathway.png");

    public static Texture roadway0NWTexture = loadTextureFromFile("texture/road/roadway/texture-0-nw-roadway.png");
    public static Texture roadway1NETexture = loadTextureFromFile("texture/road/roadway/texture-1-ne-roadway.png");
    public static Texture roadway2WTexture = loadTextureFromFile("texture/road/roadway/texture-2-w-roadway.png");
    public static Texture roadway3ETexture = loadTextureFromFile("texture/road/roadway/texture-3-e-roadway.png");
    public static Texture roadway4SWTexture = loadTextureFromFile("texture/road/roadway/texture-4-sw-roadway.png");
    public static Texture roadway5SETexture = loadTextureFromFile("texture/road/roadway/texture-5-se-roadway.png");

    public static Texture railway0NWTexture = loadTextureFromFile("texture/road/railway/texture-0-nw-railway.png");
    public static Texture railway1NETexture = loadTextureFromFile("texture/road/railway/texture-1-ne-railway.png");
    public static Texture railway2WTexture = loadTextureFromFile("texture/road/railway/texture-2-w-railway.png");
    public static Texture railway3ETexture = loadTextureFromFile("texture/road/railway/texture-3-e-railway.png");
    public static Texture railway4SWTexture = loadTextureFromFile("texture/road/railway/texture-4-sw-railway.png");
    public static Texture railway5SETexture = loadTextureFromFile("texture/road/railway/texture-5-se-railway.png");

    public static Texture riverNarrow0NWTexture = loadTextureFromFile("texture/river/narrow/texture-0-nw-narrow.png");
    public static Texture riverNarrow1NETexture = loadTextureFromFile("texture/river/narrow/texture-1-ne-narrow.png");
    public static Texture riverNarrow2WTexture = loadTextureFromFile("texture/river/narrow/texture-2-w-narrow.png");
    public static Texture riverNarrow3ETexture = loadTextureFromFile("texture/river/narrow/texture-3-e-narrow.png");
    public static Texture riverNarrow4SWTexture = loadTextureFromFile("texture/river/narrow/texture-4-sw-narrow.png");
    public static Texture riverNarrow5SETexture = loadTextureFromFile("texture/river/narrow/texture-5-se-narrow.png");

    public static Texture riverMedium0NWTexture = loadTextureFromFile("texture/river/medium/texture-0-nw-medium.png");
    public static Texture riverMedium1NETexture = loadTextureFromFile("texture/river/medium/texture-1-ne-medium.png");
    public static Texture riverMedium2WTexture = loadTextureFromFile("texture/river/medium/texture-2-w-medium.png");
    public static Texture riverMedium3ETexture = loadTextureFromFile("texture/river/medium/texture-3-e-medium.png");
    public static Texture riverMedium4SWTexture = loadTextureFromFile("texture/river/medium/texture-4-sw-medium.png");
    public static Texture riverMedium5SETexture = loadTextureFromFile("texture/river/medium/texture-5-se-medium.png");

    public static Texture riverWide0NWTexture = loadTextureFromFile("texture/river/wide/texture-0-nw-wide.png");
    public static Texture riverWide1NETexture = loadTextureFromFile("texture/river/wide/texture-1-ne-wide.png");
    public static Texture riverWide2WTexture = loadTextureFromFile("texture/river/wide/texture-2-w-wide.png");
    public static Texture riverWide3ETexture = loadTextureFromFile("texture/river/wide/texture-3-e-wide.png");
    public static Texture riverWide4SWTexture = loadTextureFromFile("texture/river/wide/texture-4-sw-wide.png");
    public static Texture riverWide5SETexture = loadTextureFromFile("texture/river/wide/texture-5-se-wide.png");

    public static Texture bridgeLight0NWTexture = loadTextureFromFile("texture/bridge/light/texture-0-nw-light-bridge.png");
    public static Texture bridgeLight1NETexture = loadTextureFromFile("texture/bridge/light/texture-1-ne-light-bridge.png");
    public static Texture bridgeLight2WTexture = loadTextureFromFile("texture/bridge/light/texture-2-w-light-bridge.png");
    public static Texture bridgeLight3ETexture = loadTextureFromFile("texture/bridge/light/texture-3-e-light-bridge.png");
    public static Texture bridgeLight4SWTexture = loadTextureFromFile("texture/bridge/light/texture-4-sw-light-bridge.png");
    public static Texture bridgeLight5SETexture = loadTextureFromFile("texture/bridge/light/texture-5-se-light-bridge.png");

    public static Texture bridgeMedium0NWTexture = loadTextureFromFile("texture/bridge/medium/texture-0-nw-medium-bridge.png");
    public static Texture bridgeMedium1NETexture = loadTextureFromFile("texture/bridge/medium/texture-1-ne-medium-bridge.png");
    public static Texture bridgeMedium2WTexture = loadTextureFromFile("texture/bridge/medium/texture-2-w-medium-bridge.png");
    public static Texture bridgeMedium3ETexture = loadTextureFromFile("texture/bridge/medium/texture-3-e-medium-bridge.png");
    public static Texture bridgeMedium4SWTexture = loadTextureFromFile("texture/bridge/medium/texture-4-sw-medium-bridge.png");
    public static Texture bridgeMedium5SETexture = loadTextureFromFile("texture/bridge/medium/texture-5-se-medium-bridge.png");

    public static Texture bridgeHeavy0NWTexture = loadTextureFromFile("texture/bridge/heavy/texture-0-nw-heavy-bridge.png");
    public static Texture bridgeHeavy1NETexture = loadTextureFromFile("texture/bridge/heavy/texture-1-ne-heavy-bridge.png");
    public static Texture bridgeHeavy2WTexture = loadTextureFromFile("texture/bridge/heavy/texture-2-w-heavy-bridge.png");
    public static Texture bridgeHeavy3ETexture = loadTextureFromFile("texture/bridge/heavy/texture-3-e-heavy-bridge.png");
    public static Texture bridgeHeavy4SWTexture = loadTextureFromFile("texture/bridge/heavy/texture-4-sw-heavy-bridge.png");
    public static Texture bridgeHeavy5SETexture = loadTextureFromFile("texture/bridge/heavy/texture-5-se-heavy-bridge.png");

    public static Texture clff0NWTexture = loadTextureFromFile("texture/cliff/texture-0-nw-cliff.png");
    public static Texture clff1NETexture = loadTextureFromFile("texture/cliff/texture-1-ne-cliff.png");
    public static Texture clff2WTexture = loadTextureFromFile("texture/cliff/texture-2-w-cliff.png");
    public static Texture clff3ETexture = loadTextureFromFile("texture/cliff/texture-3-e-cliff.png");
    public static Texture clff4SWTexture = loadTextureFromFile("texture/cliff/texture-4-sw-cliff.png");
    public static Texture clff5SETexture = loadTextureFromFile("texture/cliff/texture-5-se-cliff.png");

    public static Texture counterBgRedCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-red-country-01@4x.png");
    public static Texture counterBgRedCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-red-country-02@4x.png");
    public static Texture counterBgBlueCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-blue-country-01@4x.png");
    public static Texture counterBgBlueCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-blue-country-02@4x.png");
    public static Texture counterBgBlackCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-black-country-01@4x.png");
    public static Texture counterBgBlackCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-black-country-02@4x.png");
    public static Texture counterBgGreenCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-green-country-01@4x.png");
    public static Texture counterBgGreenCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-green-country-02@4x.png");
    public static Texture counterBgYellowCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-yellow-country-01@4x.png");
    public static Texture counterBgYellowCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-yellow-country-02@4x.png");
    public static Texture counterBgBrownCountry01Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-brown-country-01@4x.png");
    public static Texture counterBgBrownCountry02Texture = loadTextureFromFile("texture/unit/counter-bg/texture-counter-bg-brown-country-02@4x.png");


    public static Texture counterTypeIconBSHQTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-hq@4x.png");
    public static Texture counterTypeIconBSArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-arti@4x.png");
    public static Texture counterTypeIconBSMortarArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-mortar-arti@4x.png");
    public static Texture counterTypeIconBSRocketArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-rocket-arti@4x.png");
    public static Texture counterTypeIconBSInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-inf@4x.png");
    public static Texture counterTypeIconBSMountainInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-mountain-inf@4x.png");
    public static Texture counterTypeIconBSMountainArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-mountain-arti@4x.png");
    public static Texture counterTypeIconBSSkiInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-ski-inf@4x.png");
    public static Texture counterTypeIconBSSkiMachineGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-ski-machine-gun@4x.png");
    public static Texture counterTypeIconBSGliderInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-glider-inf@4x.png");
    public static Texture counterTypeIconBSTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-tank@4x.png");
    public static Texture counterTypeIconBSHeavyTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-heavy-tank@4x.png");
    public static Texture counterTypeIconBSAssaultGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-assault-gun@4x.png");
    //public static Texture counterTypeIconBSParaTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-para@4x.png");
    public static Texture counterTypeIconBSAntiAirTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-anti-air@4x.png");
    public static Texture counterTypeIconBSHeavyAntiAirTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-heavy-anti-air@4x.png");
    public static Texture counterTypeIconBSAntiTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-anti-tank@4x.png");
    public static Texture counterTypeIconBSCavTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-cav@4x.png");
    public static Texture counterTypeIconBSEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-eng@4x.png");
    public static Texture counterTypeIconBSCivilEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-civil-eng@4x.png");
    public static Texture counterTypeIconBSMarTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-mar@4x.png");
    public static Texture counterTypeIconBSMecaInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-meca-inf@4x.png");
    public static Texture counterTypeIconBSMecaArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-meca-arti@4x.png");
    public static Texture counterTypeIconBSMecaRecoTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-meca-reco@4x.png");
    public static Texture counterTypeIconBSMachineGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-machine-gun@4x.png");
    public static Texture counterTypeIconBSBicycleInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-bicycle-inf@4x.png");
    public static Texture counterTypeIconBSMotorcycleInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-motorcycle-inf@4x.png");
    public static Texture counterTypeIconBSLogisticTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-logistic@4x.png");
    public static Texture counterTypeIconBSBridgeEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/black-stroke/texture-unit-icon-type-bridge-eng@4x.png");

    //texture-unit-icon-type-logistic@4x

    public static Texture counterTypeIconWSHQTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-hq@4x.png");
    public static Texture counterTypeIconWSArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-arti@4x.png");
    public static Texture counterTypeIconWSMortarArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-mortar-arti@4x.png");
    public static Texture counterTypeIconWSRocketArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-rocket-arti@4x.png");
    public static Texture counterTypeIconWSInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-inf@4x.png");
    public static Texture counterTypeIconWSMountainInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-mountain-inf@4x.png");
    public static Texture counterTypeIconWSMountainArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-mountain-arti@4x.png");
    public static Texture counterTypeIconWSSkiInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-ski-inf@4x.png");
    public static Texture counterTypeIconWSSkiMachineGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-ski-machine-gun@4x.png");
    public static Texture counterTypeIconWSGliderInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-glider-inf@4x.png");
    public static Texture counterTypeIconWSTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-tank@4x.png");
    public static Texture counterTypeIconWSHeavyTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-heavy-tank@4x.png");
    public static Texture counterTypeIconWSAssaultGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-assault-gun@4x.png");
    //public static Texture counterTypeIconWSParaTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-para@4x.png");
    public static Texture counterTypeIconWSAntiAirTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-anti-air@4x.png");
    public static Texture counterTypeIconWSHeavyAntiAirTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-heavy-anti-air@4x.png");
    public static Texture counterTypeIconWSAntiTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-anti-tank@4x.png");
    public static Texture counterTypeIconWSCavTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-cav@4x.png");
    public static Texture counterTypeIconWSEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-eng@4x.png");
    public static Texture counterTypeIconWSCivilEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-civil-eng@4x.png");
    public static Texture counterTypeIconWSMarTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-mar@4x.png");
    public static Texture counterTypeIconWSMecaInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-meca-inf@4x.png");
    public static Texture counterTypeIconWSMecaArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-meca-arti@4x.png");
    public static Texture counterTypeIconWSMecaRecoTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-meca-reco@4x.png");
    public static Texture counterTypeIconWSMachineGunTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-machine-gun@4x.png");
    public static Texture counterTypeIconWSBicycleInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-bicycle-inf@4x.png");
    public static Texture counterTypeIconWSMotorcycleInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-motorcycle-inf@4x.png");
    public static Texture counterTypeIconWSLogisticTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-logistic@4x.png");
    public static Texture counterTypeIconWSBridgeEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/white-stroke/texture-unit-icon-type-bridge-eng@4x.png");


    public static Texture counterAddOnBSReg1_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-reg-1-5@4x.png");
    public static Texture counterAddOnBSReg2_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-reg-2-5@4x.png");
    public static Texture counterAddOnBSReg3_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-reg-3-5@4x.png");
    public static Texture counterAddOnBSReg4_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-reg-4-5@4x.png");
    public static Texture counterAddOnBSReg5_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-reg-5-5@4x.png");

    public static Texture counterAddOnBSLevel1_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-level-1-5@4x.png");
    public static Texture counterAddOnBSLevel2_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-level-2-5@4x.png");
    public static Texture counterAddOnBSLevel3_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-level-3-5@4x.png");
    public static Texture counterAddOnBSLevel4_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-level-4-5@4x.png");
    public static Texture counterAddOnBSLevel5_5Texture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-level-5-5@4x.png");

    public static Texture counterAddOnBSCompTexture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-comp@4x.png");
    public static Texture counterAddOnBSMotTexture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-mot@4x.png");
    public static Texture counterAddOnBSParaTexture = loadTextureFromFile("texture/unit/counter-addon/black-stroke/counter-addon-para@4x.png");

    public static Texture counterAddOnWSReg1_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-reg-1-5@4x.png");
    public static Texture counterAddOnWSReg2_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-reg-2-5@4x.png");
    public static Texture counterAddOnWSReg3_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-reg-3-5@4x.png");
    public static Texture counterAddOnWSReg4_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-reg-4-5@4x.png");
    public static Texture counterAddOnWSReg5_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-reg-5-5@4x.png");


    public static Texture counterAddOnWSLevel1_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-level-1-5@4x.png");
    public static Texture counterAddOnWSLevel2_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-level-2-5@4x.png");
    public static Texture counterAddOnWSLevel3_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-level-3-5@4x.png");
    public static Texture counterAddOnWSLevel4_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-level-4-5@4x.png");
    public static Texture counterAddOnWSLevel5_5Texture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-level-5-5@4x.png");

    public static Texture counterAddOnWSCompTexture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-comp@4x.png");
    public static Texture counterAddOnWSMotTexture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-mot@4x.png");
    public static Texture counterAddOnWSParaTexture = loadTextureFromFile("texture/unit/counter-addon/white-stroke/counter-addon-para@4x.png");

    public static Color backgroundColorDark = new Color(0.1f, 0.1f, 0.12f, 1);
    public static Color backgroundColorMedium = new Color(0.15f, 0.15f, 0.18f, 1);
    public static Color backgroundColorLight = new Color(0.2f, 0.2f, 0.25f, 1);

    public static Color buttonColorMedium = new Color( 0.25f, 0.25f, 0.31f, 1);
    public static Color buttonHoverColorMedium = new Color(0.85f, 0.25f, 0.25f, 1);
    public static Color buttonDownColorMedium = new Color(0.55f, 0.15f, 0.18f, 1);
    public static Color buttonDisabledColorMedium = new Color(0.18f, 0.18f, 0.2f, 1);

    public static Color buttonHoverColorMediumDark = new Color(0.75f, 0.20f, 0.20f, 1);
    public static Color buttonHoverColorMediumLight = new Color(0.95f, 0.30f, 0.30f, 1);

    //buttonHoverColorMediumDark et buttonHoverColorMediumLight
    public static Color buttonBorderColorDark = new Color(0.05f, 0.05f, 0.06f, 1);

    public static Color textDisabledColorMedium = new Color(0.20f, 0.20f, 0.23f, 1);

    // Couleurs spécifiques pour le Toast (à définir selon vos préférences)
    public static Color toastBackgroundColor = new Color(1f, 1f, 1f, 1f); // Noir semi-transparent
    public static Color toastFontColor = backgroundColorDark; //new Color(0.9020f, 0.7843f, 0.1176f, 1.0f);
    public static Color toastBorderColor = new Color(0.5f, 0.5f, 0.5f, 0.85f); // Gris semi-transparent pour la bordure

    //public static Color getToastSuccessBackgroundColor = new Color(0.1f, 0.8f, 0.1f, 1f);
    public static Color toastSuccessBackgroundColor = new Color(0.2353f, 1f, 0.1961f, 1f);
    public static Color toastDangerBackgroundColor = new Color(1f, 0.2353f, 0.1961f, 1f);
    public static Color toastInfoBackgroundColor = new Color(0.1176f, 0.3529f, 1f, 1f);
    public static Color toastWarningBackgroundColor = new Color(0.9412f, 0.5098f, 0.0784f, 1.0f);

    public static Color colorRed = new Color(1f, 0f, 0f, 1f);
    public static Color colorOrange = new Color(1f, 0.5f, 0f, 1f);
    public static Color colorYellow = new Color(1f, 1f, 0f, 1f);
    public static Color colorGreen = new Color(0f, 1f, 0f, 1f);
    public static Color colorBlue = new Color(0f, 0f, 1f, 1f);
    public static Color colorPurple = new Color(0.5f, 0f, 1f, 1f);

    // Dans GraphicUtil.java, ajoutez ces champs en haut de la classe

    // Vous devez charger ces polices une seule fois au lancement de votre jeu.
    // Par exemple : regularFont = new BitmapFont(Gdx.files.internal("fonts/my-font.fnt"));
    public static BitmapFont regularFont = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-110-++.fnt"));
    public static BitmapFont whiteStrokeFont  = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-110-WB.fnt"));

    // Outil pour mesurer la taille du texte
    private static final GlyphLayout layout = new GlyphLayout();

    /**
     * Creates a Texture from an image file located in the assets' folder.
     *
     * @param filePath The path to the image file within the assets' folder.
     *                 For example, "textures/grass.png".
     * @return A Texture object if the file was found and loaded successfully,
     *         or null if there was an error (e.g., file not found).
     */
    public static Texture loadTextureFromFile(String filePath) {
        try {
            return new Texture(Gdx.files.internal(filePath));
            //return texture;
        } catch (Exception e) {
            System.err.println("Error loading texture from file: " + filePath);
            e.printStackTrace();  // Print the stack trace for debugging
            return null;
        }
    }

    public static Texture getTextureFromTerrain(HexagonCategory terrain) {
        switch (terrain) {
            case FOREST:
                return forestTexture;
            case GRASS:
                return grassTexture;
            case SAND:
                return sandTexture;
            case SWAMP:
                return swampTexture;
            case WATER:
                return waterTexture;
            case CITY_LIGHT:
                return cityLightTexture;
            case CITY_DENSE:
                return cityDenseTexture;
        }
        return redTexture;
    }

    public static Texture getTextureFromFortification(FortificationCategory fortification) {
        switch (fortification) {
            case WOOD_LIGHT:
                return fortifWoodLightTexture;
            case WOOD_MEDIUM:
                return fortifWoodMediumTexture;
            case CONCRETE_LIGHT:
                return fortifConcreteLightTexture;
            case CONCRETE_MEDIUM:
                return fortifConcreteMediumTexture;
            case CONCRETE_HEAVY:
                return fortifConcreteHeavyTexture;
            case NO_FORTIFICATION:
                return getEmptyTexture();
        }
        return getEmptyTexture();
    }

    public static Texture getTextureSideFromCliff(Cliff cliff, int side) {
        Texture toReturn = getEmptyTexture();
        if(cliff.isCliff()) {
            switch (side) {
                case 0 :
                    toReturn = clff0NWTexture;
                    break;
                case 1:
                    toReturn = clff1NETexture;
                    break;
                case 2:
                    toReturn = clff2WTexture;
                    break;
                case 3:
                    toReturn = clff3ETexture;
                    break;
                case 4:
                    toReturn = clff4SWTexture;
                    break;
                case 5:
                    toReturn = clff5SETexture;
                    break;
            }
        }
        return  toReturn;
    }

    public static Texture getTextureSideFromBridge(BridgeTypeEnum bridgeType, int side) {
        Texture toReturn = getEmptyTexture();

        switch (bridgeType) {
            case LIGHT_BRIDGE:
                switch (side) {
                    case 0 :
                        toReturn = bridgeLight0NWTexture;
                        break;
                    case 1:
                        toReturn = bridgeLight1NETexture;
                        break;
                    case 2:
                        toReturn = bridgeLight2WTexture;
                        break;
                    case 3:
                        toReturn = bridgeLight3ETexture;
                        break;
                    case 4:
                        toReturn = bridgeLight4SWTexture;
                        break;
                    case 5:
                        toReturn = bridgeLight5SETexture;
                        break;
                }
                break;
            case MEDIUM_BRIDGE:
                switch (side) {
                    case 0 :
                        toReturn = bridgeMedium0NWTexture;
                        break;
                    case 1:
                        toReturn = bridgeMedium1NETexture;
                        break;
                    case 2:
                        toReturn = bridgeMedium2WTexture;
                        break;
                    case 3:
                        toReturn = bridgeMedium3ETexture;
                        break;
                    case 4:
                        toReturn = bridgeMedium4SWTexture;
                        break;
                    case 5:
                        toReturn = bridgeMedium5SETexture;
                        break;
                }
                break;
            case HEAVY_BRIDGE:
                switch (side) {
                    case 0 :
                        toReturn = bridgeHeavy0NWTexture;
                        break;
                    case 1:
                        toReturn = bridgeHeavy1NETexture;
                        break;
                    case 2:
                        toReturn = bridgeHeavy2WTexture;
                        break;
                    case 3:
                        toReturn = bridgeHeavy3ETexture;
                        break;
                    case 4:
                        toReturn = bridgeHeavy4SWTexture;
                        break;
                    case 5:
                        toReturn = bridgeHeavy5SETexture;
                        break;
                }
                break;
        }

        return toReturn;
    }

    public static Texture getEmptyTexture() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 0); // Transparent black
        pixmap.fill();
        Texture emptyTexture = new Texture(pixmap);
        pixmap.dispose(); // Dispose of the Pixmap immediately
        return emptyTexture;
    }

    public static Pixmap textureToPixmap(Texture texture) {
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        return texture.getTextureData().consumePixmap();
    }

    public static Color getColorFromTerrain(HexagonCategory category) {
        Color toReturn = Color.WHITE;
        switch (category) {
            case GRASS:
                toReturn = Color.LIME;
                break;
            case FOREST:
                toReturn = Color.FOREST;
                break;
            case SWAMP:
                toReturn = Color.PURPLE;
                break;
            case SAND:
                toReturn = Color.YELLOW;
                break;
            case WATER:
                toReturn = Color.BLUE;
                break;
            case CITY_LIGHT:
                toReturn = Color.LIGHT_GRAY;
                break;
            case CITY_DENSE:
                toReturn = Color.DARK_GRAY;
        }
        return toReturn;
    }

    /**
     * Creates a Texture containing a horizontal line with variable thickness and color.
     *
     * @param width         The width of the texture (and the length of the line).
     * @param height        The height of the texture.  The line will be centered vertically.
     * @param lineThickness The thickness of the horizontal line (in pixels).
     * @return A Texture object containing the horizontal line.  The caller is responsible for disposing of the Texture.
     * @throws IllegalArgumentException if width, height, or lineThickness are invalid.
     */
    public static Texture getTextureFromRoadForButton(int width, int height,
                                             int lineThickness, RoadCategory roadCategory) {
        // Validate parameters
        if (width <= 0 || height <= 0 || lineThickness <= 0) {
            throw new IllegalArgumentException("Width, height, and lineThickness must be positive.");
        }
        Color lineColor = Color.BLUE;
        switch(roadCategory) {
        case PATHWAY:
            lineColor = Color.BROWN;
            break;
        case ROADWAY:
            lineColor = Color.LIGHT_GRAY;
            break;
        case RAILWAY:
            lineColor = Color.BLACK;
            break;
        case NO_ROAD:
            return GraphicUtil.getEmptyTexture();
        }

        // Create Pixmap
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Set background color to light gray
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();  // Fill the entire Pixmap with light gray

        // Calculate line Y position (center the line)
        int lineY = (height / 2) - (lineThickness / 2);

        // Set color and draw the line
        pixmap.setColor(lineColor);
        pixmap.fillRectangle(0, lineY, width, lineThickness);

        // Create Texture from Pixmap
        Texture texture = new Texture(pixmap);

        // Dispose of Pixmap (texture has a copy now)
        pixmap.dispose();

        return texture;
    }

    public static Texture getTextureFromRiverForButton(int width, int height,
                                                RiverCategory riverCategory)
    {
        // Validate parameters
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width, height, and lineThickness must be positive.");
        }
        int lineThickness = 1;
        Color lineColor = Color.BLUE;
        switch(riverCategory) {
            case NARROW:
                lineThickness = 2;
                break;
            case MEDIUM:
                lineThickness = 4;
                break;
            case WIDE:
                lineThickness = 6;
                break;
            case NO_RIVER:
                return GraphicUtil.getEmptyTexture();
        }

        // Create Pixmap
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Set background color to light gray
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();  // Fill the entire Pixmap with light gray

        // Calculate line Y position (center the line)
        int lineY = (height / 2) - (lineThickness / 2);

        // Set color and draw the line
        pixmap.setColor(lineColor);
        pixmap.fillRectangle(0, lineY, width, lineThickness);

        // Create Texture from Pixmap
        Texture texture = new Texture(pixmap);

        // Dispose of Pixmap (texture has a copy now)
        pixmap.dispose();

        return texture;
    }

    // TODO : déplacer dans UnitUtil ?
    public static ScenarUnitNode createScenarTreeFromGroup(UnitGroup group, Screen screen) {
        // Créer un nœud pour le groupe actuel
        ScenarUnitNode groupNode = new ScenarUnitNode(group);

        // Parcourir les unités du groupe
        for (ElementInterface element : group.getUnits()) {
            if (element instanceof UnitGroup) {
                // Si c'est un sous-groupe, appel récursif
                ScenarUnitNode childGroupNode = createScenarTreeFromGroup((UnitGroup) element, screen);
                groupNode.add(childGroupNode); // Ajouter le sous-groupe au nœud actuel
                // ajouter listener
                childGroupNode.getActor().addListener(new ClickListener() {
                    public void clicked (InputEvent event, float x, float y) {
                        //System.out.println("click on group");
                        if (screen instanceof EditScenarScreen) {
                            EditScenarScreen that = (EditScenarScreen) screen;
                            OnBoardUnit onBoardUnit = new OnBoardUnit();
                            onBoardUnit.setUnit(element);
                            boolean isDeployed = that.editScenarService.getSelectedOpponent().getDeployedUnits().stream().anyMatch((OnBoardUnit unit) ->
                                unit.equals(onBoardUnit)
                            );
                            if(!isDeployed) {
                                //that.displayUnitInfos(element);
                                that.editScenarService.setSelectedUnit(element);
                                that.updateEditMode(EditScenarModeEnum.DEPLOY_UNITS);
                                that.rebuildSelectedOpponentEditPanel();
                            }
                        }
                        //childGroupNode.setExpanded(!childGroupNode.isExpanded());
                    }
                });

            } else if (element instanceof Unit) {
                // Si c'est une unité, créer un nœud simple
                ScenarUnitNode unitNode = new ScenarUnitNode((Unit) element);
                groupNode.add(unitNode); // Ajouter l'unité au nœud actuel
                // ajouter listener
                unitNode.getActor().addListener(new ClickListener() {
                    public void clicked (InputEvent event, float x, float y) {
                        //System.out.println("click on unit");
                        if (screen instanceof EditScenarScreen) {
                            EditScenarScreen that = (EditScenarScreen) screen;

                            OnBoardUnit onBoardUnit = new OnBoardUnit();
                            onBoardUnit.setUnit(element);
                            boolean isDeployed = that.editScenarService.getSelectedOpponent().getDeployedUnits().stream().anyMatch((OnBoardUnit unit) ->
                                unit.equals(onBoardUnit)
                            );
                            if(!isDeployed) {
                                //that.displayUnitInfos(element);
                                that.editScenarService.setSelectedUnit(element);
                                that.updateEditMode(EditScenarModeEnum.DEPLOY_UNITS);
                                that.rebuildSelectedOpponentEditPanel();
                            }

                        }
                    }
                });
            }
        }
        return groupNode;
    }

    // TODO : déplacer dans UnitUtil ?
    public static UnitNode createTreeFromGroup(UnitGroup group, Screen screen) {
        // Créer un nœud pour le groupe actuel
        UnitNode groupNode = new UnitNode(group);

        // Parcourir les unités du groupe
        for (ElementInterface element : group.getUnits()) {
            if (element instanceof UnitGroup) {
                // Si c'est un sous-groupe, appel récursif
                UnitNode childGroupNode = createTreeFromGroup((UnitGroup) element, screen);
                groupNode.add(childGroupNode); // Ajouter le sous-groupe au nœud actuel
                // ajouter listener
                childGroupNode.getActor().addListener(new ClickListener() {
                    public void clicked (InputEvent event, float x, float y) {
                        //System.out.println("click on group");
                        if (screen instanceof EditArmyScreen) {
                            EditArmyScreen that = (EditArmyScreen) screen;
                            that.displayUnitInfos(element);
                        }
                        //childGroupNode.setExpanded(!childGroupNode.isExpanded());
                    }
                });

            } else if (element instanceof Unit) {
                // Si c'est une unité, créer un nœud simple
                UnitNode unitNode = new UnitNode((Unit) element);
                groupNode.add(unitNode); // Ajouter l'unité au nœud actuel
                // ajouter listener
                unitNode.getActor().addListener(new ClickListener() {
                    public void clicked (InputEvent event, float x, float y) {
                        //System.out.println("click on unit");
                        if (screen instanceof EditArmyScreen) {
                            EditArmyScreen that = (EditArmyScreen) screen;
                            that.displayUnitInfos(element);
                        }
                    }
                });
            }
        }
        return groupNode;
    }

    // TODO : déplacer dans UnitUtil ?
    public static Texture getCounterTextureFromUnit(ElementInterface unit) {
        //Texture toReturn = getEmptyTexture();
        Texture background = getCountryTexture(unit);
        Texture typeIcon = getUnitTypeTexture(unit);

        // choix des addons en fonction de l'unité
        Texture paraAddon = getParaAddonTexture(unit);
        Texture motorisedAddon = getMotorisedAddonTexture(unit);
        Texture regRankAddon = getRegRankAddonTexture(unit);
        Texture companyAddon = getCompanyAddonTexture(unit);

        Texture levelAddon = getEmptyTexture();
        if(unit instanceof UnitGroup) {
            //UnitGroup group = (UnitGroup) unit;
            //System.out.println("unit group level : " + ((UnitGroup) unit).getLevel());
            levelAddon = getLevelAddonTexture((UnitGroup) unit);
        }

        Texture toReturn = stackTextures(background, typeIcon, paraAddon, motorisedAddon, regRankAddon, levelAddon, companyAddon);

        // Ajouter le texte de l'acronyme à la texture
        String acronym = unit.getAcronym();
        if(unit.isUsesWhiteStroke()) {
            toReturn = drawTextOnTexture(toReturn, acronym, true);
        }
        else {
            toReturn = drawTextOnTexture(toReturn, acronym, false);

        }
        //toReturn = drawTextOnTexture(toReturn, acronym);
        return toReturn;
    }

    // Dans votre classe GraphicUtil.java

    /**
     * Superpose un Pixmap source sur un Pixmap de destination.
     * Cette méthode gère la conversion de la Texture en Pixmap et sa libération.
     * @param destination Le Pixmap sur lequel dessiner.
     * @param textureSource La Texture à dessiner.
     * @param width La largeur de dessin (pour la mise à l'échelle).
     * @param height La hauteur de dessin (pour la mise à l'échelle).
     */
    private static void drawOnPixmap(Pixmap destination, Texture textureSource, int width, int height) {

        if (textureSource == null || destination == null) {
            return;
        }

        // Convertit la texture en un pixmap temporaire, mis à l'échelle à la bonne taille
        Pixmap pixmapSource = textureToPixmapSafe(textureSource, width, height);

        if (pixmapSource != null) {
            // Dessine le pixmap source sur la destination
            destination.drawPixmap(
                pixmapSource,
                0, 0, pixmapSource.getWidth(), pixmapSource.getHeight(), // Rectangle source (entier)
                0, 0, width, height                                  // Rectangle destination (entier)
            );

            // Libère immédiatement le pixmap temporaire pour éviter les fuites de mémoire
            pixmapSource.dispose();
        }
    }


    // Dans GraphicUtil.java

    public static Pixmap getCounterPixmapFromUnit(ElementInterface unit, int width, int height) {
        // --- Étape 1: Créer le Pixmap de base ---
        Texture backgroundTexture = getCountryTexture(unit);
        Pixmap finalPixmap = textureToPixmapSafe(backgroundTexture, width, height);
        if (finalPixmap == null) {
            finalPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
            finalPixmap.setColor(0, 0, 0, 0);
            finalPixmap.fill();
        }

        // IMPORTANT: Pour un meilleur rendu du texte redimensionné, utilisez le filtre BiLinear.
        // Il va lisser les pixels et éviter un effet d'escalier.
        finalPixmap.setFilter(Pixmap.Filter.BiLinear);

        // --- Étape 2: Superposer les addons ---
        // (Le code pour drawOnPixmap reste le même qu'avant)
        drawOnPixmap(finalPixmap, getUnitTypeTexture(unit), width, height);
        drawOnPixmap(finalPixmap, getParaAddonTexture(unit), width, height);
        drawOnPixmap(finalPixmap, getMotorisedAddonTexture(unit), width, height);
        drawOnPixmap(finalPixmap, getRegRankAddonTexture(unit), width, height);
        if (unit instanceof UnitGroup) {
            drawOnPixmap(finalPixmap, getLevelAddonTexture((UnitGroup) unit), width, height);
        }
        drawOnPixmap(finalPixmap, getCompanyAddonTexture(unit), width, height);

        // --- ÉTAPE 3: Dessiner l'acronyme (appel simplifié) ---
        String acronym = unit.getAcronym();
        if (acronym != null && !acronym.isEmpty()) {
            BitmapFont fontToUse = unit.isUsesWhiteStroke() ? whiteStrokeFont : regularFont;

            if (fontToUse != null) {
                // L'appel est plus simple: on passe juste le pixmap et la zone cible (le pixmap entier).
                // La méthode s'occupe du reste (calcul du ratio, centrage).
                drawTextOnPixmap(finalPixmap, fontToUse, acronym, width, height);
            } else {
                System.err.println("Attention: La police pour le rendu du compteur est nulle.");
            }
        }

        // --- Étape 4: Retourner le résultat ---
        return finalPixmap;
    }


    /**
     * Dessine du texte directement sur un Pixmap en utilisant un BitmapFont.
     * Cette méthode est "thread-safe" car elle n'utilise que des opérations Pixmap (CPU).
     *
     * @param destination Le Pixmap sur lequel dessiner.
     * @param font La police à utiliser.
     * @param text Le texte à afficher.
     * @param x La coordonnée X du coin supérieur gauche du texte.
     * @param y La coordonnée Y du coin supérieur gauche du texte (baseline).
     */
    /*
    public static void drawTextOnPixmap(Pixmap destination, BitmapFont font, String text, int x, int y) {
        BitmapFont.BitmapFontData fontData = font.getData();

        // Obtenir le Pixmap de la texture de la police.
        // C'est la partie la plus coûteuse, mais nécessaire.
        Texture fontTexture = font.getRegion().getTexture();
        Pixmap fontPixmap = textureToPixmapSafe(fontTexture, fontTexture.getWidth(), fontTexture.getHeight());

        if (fontPixmap == null) {
            System.err.println("Impossible de convertir la texture de la police en Pixmap.");
            return;
        }

        int cursorX = x;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            BitmapFont.Glyph glyph = fontData.getGlyph(c);

            if (glyph != null) {
                // Dessine le glyphe (le caractère) du Pixmap de la police vers le Pixmap de destination
                destination.drawPixmap(
                    fontPixmap,                                 // Pixmap source (la police)
                    glyph.srcX, glyph.srcY,                     // Coordonnées source (coin sup-gauche du caractère)
                    glyph.width, glyph.height,                  // Taille du caractère dans la source
                    cursorX + glyph.xoffset, y + glyph.yoffset, // Coordonnées destination (avec décalages)
                    glyph.width, glyph.height                   // Taille dans la destination (pas de mise à l'échelle)
                );
                cursorX += glyph.xadvance;
            }
        }

        // Très important : libérer le pixmap de la police créé temporairement
        fontPixmap.dispose();
    }

     */

    // Dans GraphicUtil.java

    /**
     * Dessine du texte directement sur un Pixmap, en le redimensionnant et en le centrant
     * pour qu'il s'insère dans la zone de destination.
     * Cette méthode est "thread-safe".
     *
     * @param destination Le Pixmap sur lequel dessiner.
     * @param font La police à utiliser.
     * @param text Le texte à afficher.
     * @param destWidth La largeur de la zone cible pour le texte.
     * @param destHeight La hauteur de la zone cible pour le texte.
     */
    public static void drawTextOnPixmap(Pixmap destination, BitmapFont font, String text, int destWidth, int destHeight) {
        BitmapFont.BitmapFontData fontData = font.getData();

        // Étape 1: Calculer la taille native du texte pour déterminer le ratio
        layout.setText(font, text);
        //float nativeWidth = layout.width;
        float nativeHeight = layout.height;

        // Calculer l'échelle en fonction de la hauteur et de la largeur
        //float scaleWidth = (destWidth * 0.5f) / nativeWidth;
        float scale = (destHeight * 0.175f) / nativeHeight;
        //float scale = Math.min(scaleWidth, scaleHeight);

        // Recalculer la largeur et hauteur finales avec le ratio
        float finalWidth = layout.width * scale;
        float finalHeight = layout.height * scale;

        // Calculer le point de départ (coin supérieur gauche) pour centrer le texte
        float startX = (destWidth - finalWidth) / 2f;
        float startY = ((destHeight - finalHeight) / 2f) + finalHeight * 2.4f;


        // Étape 2: Obtenir le Pixmap de la texture de la police
        Texture fontTexture = font.getRegion().getTexture();
        Pixmap fontPixmap = textureToPixmapSafe(fontTexture, fontTexture.getWidth(), fontTexture.getHeight());

        if (fontPixmap == null) {
            System.err.println("Impossible de convertir la texture de la police en Pixmap.");
            return;
        }

        // Étape 3: Dessiner chaque caractère un par un, en appliquant le ratio
        float cursorX = startX;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            BitmapFont.Glyph glyph = fontData.getGlyph(c);

            if (glyph != null) {
                // Appliquer le ratio à toutes les dimensions du caractère
                float scaledGlyphWidth = glyph.width * scale;
                float scaledGlyphHeight = glyph.height * scale;
                float scaledXOffset = glyph.xoffset * scale;
                float scaledYOffset = glyph.yoffset * scale;

                // Dessiner le glyphe redimensionné sur le Pixmap de destination
                destination.drawPixmap(
                    fontPixmap,
                    glyph.srcX, glyph.srcY,
                    glyph.width, glyph.height,
                    (int)(cursorX + scaledXOffset), (int)(startY + scaledYOffset), // Position de destination
                    (int)scaledGlyphWidth, (int)scaledGlyphHeight                   // Taille de destination (avec redimensionnement)
                );

                // Avancer le curseur
                cursorX += glyph.xadvance * scale;
            }
        }

        fontPixmap.dispose();
    }


    /*
    public static Texture resizeTexture(Texture original, int width, int height) {
        FrameBuffer fbo = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        SpriteBatch batch = new SpriteBatch();

        fbo.begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(original, 0, 0, width, height);
        batch.end();

        fbo.end();

        // Créer une texture permanente depuis le FBO
        Pixmap pixmap = Pixmap.createFromFrameBuffer(0, 0, width, height);
        Texture result = new Texture(pixmap);

        pixmap.dispose();
        batch.dispose();
        fbo.dispose();

        return result;
    }
     */

    /*
    public static Texture resizeTextureSimple(Texture original, int width, int height) {
        // Obtenir le Pixmap source
        if (!original.getTextureData().isPrepared()) {
            original.getTextureData().prepare();
        }
        Pixmap source = original.getTextureData().consumePixmap();

        // Créer le Pixmap destination
        Pixmap dest = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        dest.setFilter(Pixmap.Filter.BiLinear);

        // Redimensionner avec drawPixmap (version étendue qui fonctionne)
        dest.drawPixmap(source,
            0, 0, source.getWidth(), source.getHeight(),  // source rect
            0, 0, width, height);                          // dest rect

        Texture result = new Texture(dest);

        source.dispose();
        dest.dispose();

        return result;
    }
     */


    // Dans votre classe GraphicUtil

    /**
     * Lit les pixels du FrameBuffer et retourne un Pixmap correctement orienté.
     * @param x Coordonnée X du coin inférieur gauche de la zone à capturer.
     * @param y Coordonnée Y du coin inférieur gauche de la zone à capturer.
     * @param w Largeur de la zone à capturer.
     * @param h Hauteur de la zone à capturer.
     * @return Un nouveau Pixmap, correctement orienté (axe Y inversé).
     */
    private static Pixmap getFlippedFrameBufferPixmap(int x, int y, int w, int h) {
        // 1. Capture du FrameBuffer (l'image sera à l'envers)
        Pixmap upsideDownPixmap = Pixmap.createFromFrameBuffer(x, y, w, h);

        // 2. Création d'un Pixmap de destination
        Pixmap flippedPixmap = new Pixmap(w, h, upsideDownPixmap.getFormat());

        // 3. Dessiner le pixmap inversé sur le pixmap final en inversant les coordonnées Y
        // On lit le pixmap source de bas en haut et on l'écrit sur la destination de haut en bas.
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                flippedPixmap.drawPixel(col, row, upsideDownPixmap.getPixel(col, h - 1 - row));
            }
        }

        // 4. Libérer le pixmap intermédiaire
        upsideDownPixmap.dispose();

        return flippedPixmap;
    }


    public static Pixmap textureToPixmapSafe(Texture texture, int targetW, int targetH) {
        if (texture == null) return null;

        // --- Première approche (CPU) ---
        // (Cette partie ne change pas)
        try {
            TextureData td = texture.getTextureData();
            if (td != null && !(td instanceof com.badlogic.gdx.graphics.glutils.GLOnlyTextureData)) {
                if (!td.isPrepared()) td.prepare();
                Pixmap pm = td.consumePixmap();
                if (pm != null && (pm.getWidth() != targetW || pm.getHeight() != targetH)) {
                    Pixmap scaled = new Pixmap(targetW, targetH, Pixmap.Format.RGBA8888);
                    scaled.setFilter(Pixmap.Filter.BiLinear);
                    scaled.drawPixmap(pm, 0, 0, pm.getWidth(), pm.getHeight(), 0, 0, targetW, targetH);
                    //pm.dispose(); // Important de disposer le pixmap original s'il a été consommé !
                    return scaled;
                }
                return pm;
            }
        } catch (Throwable t) {
            // En cas d'échec, on passe à la méthode de secours FBO
            System.err.println("Info: Could not consume pixmap directly, falling back to FBO render. " + t.getMessage());
        }

        // --- Méthode de secours (GPU / FBO) ---

        FrameBuffer fbo = null;
        SpriteBatch batch = null;
        try {
            fbo = new FrameBuffer(Pixmap.Format.RGBA8888, targetW, targetH, false);
            fbo.begin();
            Gdx.gl.glClearColor(0, 0, 0, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            // Pas besoin de glViewport ici, le FBO s'en charge.
            batch = new SpriteBatch();
            batch.getProjectionMatrix().setToOrtho2D(0, 0, targetW, targetH); // Configuration importante !

            batch.begin();
            // On dessine la texture à l'envers (flipped) pour qu'elle soit à l'endroit dans le FBO
            // vu que le FBO lui-même a un système de coordonnées inversé par rapport à l'écran.
            // Paramètres de draw: texture, x, y, width, height, srcX, srcY, srcWidth, srcHeight, flipX, flipY
            batch.draw(texture, 0, 0, targetW, targetH, 0, 0, texture.getWidth(), texture.getHeight(), false, true);
            batch.end();

            // NOUVELLE FAÇON DE FAIRE : Utiliser Pixmap.createFromFrameBuffer
            // Pas besoin de retourner l'image manuellement si on a dessiné "flipped"
            return Pixmap.createFromFrameBuffer(0, 0, targetW, targetH);

        } finally {
            if (batch != null) batch.dispose();
            // fbo.end() est appelé implicitement par fbo.dispose() s'il est encore actif
            if (fbo != null) fbo.dispose();
        }

    }

    public static Texture drawTextOnTexture(Texture input, String text, boolean usesWhiteStroke) {
        int width = input.getWidth(), height = input.getHeight();
        FrameBuffer fbo = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        SpriteBatch batch = new SpriteBatch();


        //RobotoCondensed-Black-110-++.fnt
        //RobotoCondensed-Black-110.fnt
        //BitmapFont font = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-16.fnt"));

        //RobotoCondensed-Black-110-WB
        BitmapFont font = new BitmapFont();
        if(usesWhiteStroke) {
            font = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-110-WB.fnt"));
            font.setColor(Color.WHITE);
        }
        else {
            font = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-110-++.fnt"));
            font.setColor(Color.BLACK);
        }

        OrthographicCamera camera = new OrthographicCamera(width, height);
        camera.setToOrtho(true, width, height); // Camera "Y vers le bas" = sens UI classique
        batch.setProjectionMatrix(camera.combined);

        fbo.begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        batch.begin();
        batch.draw(input, 0, 0, width, height); // fond
        GlyphLayout layout = new GlyphLayout(font, text);
        float x = (width - layout.width) / 2f;
        float y = (height + layout.height) / 2 - layout.height - 5;
        font.draw(batch, layout, x, y); // texte centré

        batch.end();
        fbo.end();

        // Créer une copie de la texture du framebuffer
        //Texture originalTexture = fbo.getColorBufferTexture();

        // Méthode 1: Utiliser un Pixmap pour créer une copie
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        ByteBuffer buffer = BufferUtils.newByteBuffer(width * height * 4);
        Gdx.gl.glBindFramebuffer(GL20.GL_FRAMEBUFFER, fbo.getFramebufferHandle());
        Gdx.gl.glReadPixels(0, 0, width, height, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, buffer);
        pixmap.getPixels().put(buffer);
        pixmap.getPixels().position(0);
        Texture textureCopy = new Texture(pixmap);

        // Libérer les ressources
        pixmap.dispose();
        font.dispose();
        batch.dispose();
        fbo.dispose();

        return textureCopy;
    }


    public static Texture stackTextures(Texture background, Texture typeIcon, Texture paraAddon, Texture motorisedAddon, Texture regRankAddon, Texture levelAddon, Texture companyAddon) {
        // Empilement des textures
        int width = background.getWidth();
        int height = background.getHeight();

        // Copier la texture de fond dans un pixmap
        Pixmap pixmapBackground = textureToPixmap(background);
        Pixmap pixmapTypeIcon = textureToPixmap(typeIcon);
        Pixmap pixmapParaAddon = textureToPixmap(paraAddon);
        Pixmap pixmapMotorisedAddon = textureToPixmap(motorisedAddon);
        Pixmap pixmapRegRankAddon = textureToPixmap(regRankAddon);
        Pixmap pixmapLevelAddon = textureToPixmap(levelAddon);
        Pixmap pixmapCompanyAddon = textureToPixmap(companyAddon);

        // Vérification de la taille de pixmap pour l'icône
        int xTypeIcon = (width - pixmapTypeIcon.getWidth()) / 2;
        int yTypeIcon = (height - pixmapTypeIcon.getHeight()) / 2;

        // Empile l'icône type sur le fond
        pixmapBackground.drawPixmap(pixmapTypeIcon, xTypeIcon, yTypeIcon);

        // Vérification de la taille de pixmap pour motorisedAddon
        int xParaAddon = (width - pixmapParaAddon.getWidth()) / 2;
        int yParaAddon = (height - pixmapParaAddon.getHeight()) / 2;

        // Empile motorisedAddon sur le fond
        pixmapBackground.drawPixmap(pixmapParaAddon, xParaAddon, yParaAddon);

        // Vérification de la taille de pixmap pour motorisedAddon
        int xMotorisedAddon = (width - pixmapMotorisedAddon.getWidth()) / 2;
        int yMotorisedAddon = (height - pixmapMotorisedAddon.getHeight()) / 2;

        // Empile motorisedAddon sur le fond
        pixmapBackground.drawPixmap(pixmapMotorisedAddon, xMotorisedAddon, yMotorisedAddon);

        //regRankAddon
        int xRegRankAddon = (width - pixmapRegRankAddon.getWidth()) / 2;
        int yRegRankAddon = (height - pixmapRegRankAddon.getHeight()) / 2;

        pixmapBackground.drawPixmap(pixmapRegRankAddon, xRegRankAddon, yRegRankAddon);

        int xLevelAddon = (width - pixmapLevelAddon.getWidth()) / 2;
        int yLevelAddon = (height - pixmapLevelAddon.getHeight()) / 2;

        pixmapBackground.drawPixmap(pixmapLevelAddon, xLevelAddon, yLevelAddon);

        int xCompanyAddon = (width - pixmapCompanyAddon.getWidth()) / 2;
        int yCompanyAddon = (height - pixmapCompanyAddon.getHeight()) / 2;

        pixmapBackground.drawPixmap(pixmapCompanyAddon, xCompanyAddon, yCompanyAddon);

        // Création de la texture résultante
        Texture toReturn = new Texture(pixmapBackground);

        // Libération de la RAM des pixmaps
        pixmapBackground.dispose();
        pixmapTypeIcon.dispose();
        // todo : régler problème des dispose()
        //if(!pixmapMotorisedAddon.equals(textureToPixmap(getEmptyTexture()))) pixmapMotorisedAddon.dispose();
        //if(!pixmapRegRankAddon.equals(textureToPixmap(getEmptyTexture()))) pixmapRegRankAddon.dispose();

        // Renvoi du résultat
        return toReturn;
    }

    public static Texture getLevelAddonTexture(UnitGroup group) {
        Texture toReturn = getEmptyTexture();
        switch (group.getLevel()) {
            case 1 :
                toReturn = group.isUsesWhiteStroke() ? counterAddOnWSLevel1_5Texture : counterAddOnBSLevel1_5Texture;
                break;
            case 2 :
                toReturn = group.isUsesWhiteStroke() ? counterAddOnWSLevel2_5Texture : counterAddOnBSLevel2_5Texture;
                //toReturn = counterAddOnBSLevel2_5Texture;
                break;
            case 3 :
                toReturn = group.isUsesWhiteStroke() ? counterAddOnWSLevel3_5Texture : counterAddOnBSLevel3_5Texture;
                //toReturn = counterAddOnBSLevel3_5Texture;
                break;
            case 4 :
                toReturn = group.isUsesWhiteStroke() ? counterAddOnWSLevel4_5Texture : counterAddOnBSLevel4_5Texture;
                //toReturn = counterAddOnBSLevel4_5Texture;
                break;
            case 5 :
                toReturn = group.isUsesWhiteStroke() ? counterAddOnWSLevel5_5Texture : counterAddOnBSLevel5_5Texture;
                //toReturn = counterAddOnBSLevel5_5Texture;
                break;
        }
        return toReturn;
    }

    public static Texture getRegRankAddonTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        switch(unit.getRegRank()) {
            case 1:
                toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSReg1_5Texture : counterAddOnBSReg1_5Texture;
                break;
            case 2:
                toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSReg2_5Texture : counterAddOnBSReg2_5Texture;
                //toReturn = counterAddOnBSReg2_4Texture;
                break;
            case 3:
                toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSReg3_5Texture : counterAddOnBSReg3_5Texture;
                //toReturn = counterAddOnBSReg3_4Texture;
                break;
            case 4:
                toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSReg4_5Texture : counterAddOnBSReg4_5Texture;
                //toReturn = counterAddOnBSReg4_4Texture;
                break;
            case 5:
                toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSReg5_5Texture : counterAddOnBSReg5_5Texture;
                //toReturn = counterAddOnBSReg4_4Texture;
                break;
        }
        return toReturn;
    }

    public static Texture getMotorisedAddonTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        if(unit.isMotorised()) {
            toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSMotTexture : counterAddOnBSMotTexture;
        }
        return toReturn;
    }

    public static Texture getParaAddonTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        if(unit.isPara()) {
            toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSParaTexture : counterAddOnBSParaTexture;
        }
        return toReturn;
    }

    public static Texture getCompanyAddonTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        if(unit.isCompany()) {
            toReturn = unit.isUsesWhiteStroke() ? counterAddOnWSCompTexture : counterAddOnBSCompTexture;
        }
        return toReturn;
    }

    public static Texture getCountryTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        // choix du bg de l'unité en fonction du pays
        switch (unit.getCountry()) {
            case RED_COUNTRY:
                toReturn = unit.isElite() ? counterBgRedCountry01Texture : counterBgRedCountry02Texture;
                break;
            case BLUE_COUNTRY:
                toReturn = unit.isElite() ? counterBgBlueCountry01Texture : counterBgBlueCountry02Texture;
                break;
            case GREEN_COUNTRY:
                toReturn = unit.isElite() ? counterBgGreenCountry01Texture : counterBgGreenCountry02Texture;
                break;
            case BLACK_COUNTRY:
                toReturn = unit.isElite() ? counterBgBlackCountry01Texture : counterBgBlackCountry02Texture;
                break;
            case YELLOW_COUNTRY:
                toReturn = unit.isElite() ? counterBgYellowCountry01Texture : counterBgYellowCountry02Texture;
                break;
            case BROWN_COUNTRY:
                toReturn = unit.isElite() ? counterBgBrownCountry01Texture : counterBgBrownCountry02Texture;
                break;
        }
        return toReturn;
    }

    public static Texture getUnitTypeTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        // choix de l'icon du type en fonction du type
        switch (unit.getType()) {
            case ARTI:
            case PARA_ARTI:
            case MOTORISED_ARTI:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSArtTexture : counterTypeIconBSArtTexture;
                break;
            case MECHANISED_ARTI:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMecaArtTexture : counterTypeIconBSMecaArtTexture;
                break;
            case MORTAR_ARTI:
            case PARA_MORTAR_ARTI:
            case MOTORISED_MORTAR_ARTI:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMortarArtTexture : counterTypeIconBSMortarArtTexture;
                break;
            case ROCKET_ARTI:
            case MOTORISED_ROCKET_ARTI:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSRocketArtTexture : counterTypeIconBSRocketArtTexture;
                break;
                /*
            case PARA_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSParaTexture : counterTypeIconBSParaTexture;
                break;
                */
            case TANK:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSTankTexture : counterTypeIconBSTankTexture;
                break;
            case HEAVY_TANK:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSHeavyTankTexture : counterTypeIconBSHeavyTankTexture;
                break;
            case ASSAULT_GUN:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSAssaultGunTexture : counterTypeIconBSAssaultGunTexture;
                break;
            case MARINE_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMarTexture : counterTypeIconBSMarTexture;
                break;
            case ENGINEER:
            case MOTORISED_ENGINEER:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSEngTexture : counterTypeIconBSEngTexture;
                break;
            case CIVIL_ENGINEER:
            case MOTORISED_CIVIL_ENGINEER:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSCivilEngTexture : counterTypeIconBSCivilEngTexture;
                break;
            case BRIDGE_ENGINEER:
            case MOTORISED_BRIDGE_ENGINEER:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSBridgeEngTexture : counterTypeIconBSBridgeEngTexture;
                break;
            case INFANTRY:
            case PARA_INF:
            case MOTORISED_INF:
            case INFANTRY_RECO_COMPANY:
            case MOTORISED_INF_RECO_COMPANY:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSInfTexture : counterTypeIconBSInfTexture;
                break;
            case MOUNTAIN_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMountainInfTexture : counterTypeIconBSMountainInfTexture;
                break;
            case MOUNTAIN_ARTI:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMountainArtTexture : counterTypeIconBSMountainArtTexture;
                break;
            case SKI_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSSkiInfTexture : counterTypeIconBSSkiInfTexture;
                break;
            case SKI_MACHINE_GUN:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSSkiMachineGunTexture : counterTypeIconBSSkiMachineGunTexture;
                break;
            case GLIDER_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSGliderInfTexture : counterTypeIconBSGliderInfTexture;
                break;
            case ANTI_AIR:
            case MOTORISED_ANTI_AIR:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSAntiAirTexture : counterTypeIconBSAntiAirTexture;
                break;
            case HEAVY_ANTI_AIR:
            case MOTORISED_HEAVY_ANTI_AIR:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSHeavyAntiAirTexture : counterTypeIconBSHeavyAntiAirTexture;
                break;
            case ANTI_TANK:
            case MOTORISED_ANTI_TANK:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSAntiTankTexture : counterTypeIconBSAntiTankTexture;
                break;
            case CAVALRY:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSCavTexture : counterTypeIconBSCavTexture;
                break;
            case MECHANISED_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMecaInfTexture : counterTypeIconBSMecaInfTexture;
                break;
            case MECHANISED_RECO:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMecaRecoTexture : counterTypeIconBSMecaRecoTexture;
                break;
            case BRIGADE_HQ:
            case DIVISION_HQ:
            case ARMY_HQ:
            case ARMY_GROUP_HQ:
            case FRONT_HQ:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSHQTexture : counterTypeIconBSHQTexture;
                break;
            case MACHINE_GUN:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMachineGunTexture : counterTypeIconBSMachineGunTexture;
                break;
            case BICYCLE_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSBicycleInfTexture : counterTypeIconBSBicycleInfTexture;
                break;
            case MOTORCYCLE_INF:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSMotorcycleInfTexture : counterTypeIconBSMotorcycleInfTexture;
                break;
            case LOGISTIC:
                toReturn = unit.isUsesWhiteStroke() ? counterTypeIconWSLogisticTexture : counterTypeIconBSLogisticTexture;
                break;
        }
        return toReturn;
    }

    public static Texture getRoadTextureFromRoadCatAndK(RoadCategory roadCategory, int k) {
        Texture texture = GraphicUtil.getEmptyTexture();;
        switch (roadCategory) {
            case PATHWAY:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.pathway0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.pathway1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.pathway2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.pathway3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.pathway4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.pathway5SETexture;
                        break;
                }
                break;
            case ROADWAY:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.roadway0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.roadway1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.roadway2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.roadway3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.roadway4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.roadway5SETexture;
                        break;
                }
                break;
            case RAILWAY:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.railway0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.railway1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.railway2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.railway3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.railway4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.railway5SETexture;
                        break;
                }
                break;
            default:
                texture = GraphicUtil.getEmptyTexture();
                break;
        }
        return texture;
    }

    public static Texture getRiverTextureFromRiverCatAndK(RiverCategory riverCategory, int k) {
        Texture texture = GraphicUtil.getEmptyTexture();

        switch(riverCategory) {
            case NARROW:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.riverNarrow0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.riverNarrow1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.riverNarrow2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.riverNarrow3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.riverNarrow4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.riverNarrow5SETexture;
                        break;
                }
                break;
            case MEDIUM:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.riverMedium0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.riverMedium1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.riverMedium2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.riverMedium3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.riverMedium4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.riverMedium5SETexture;
                        break;
                }
                break;
            case WIDE:
                switch (k) {
                    case 0:
                        texture = GraphicUtil.riverWide0NWTexture;
                        break;
                    case 1:
                        texture = GraphicUtil.riverWide1NETexture;
                        break;
                    case 2:
                        texture = GraphicUtil.riverWide2WTexture;
                        break;
                    case 3:
                        texture = GraphicUtil.riverWide3ETexture;
                        break;
                    case 4:
                        texture = GraphicUtil.riverWide4SWTexture;
                        break;
                    case 5:
                        texture = GraphicUtil.riverWide5SETexture;
                        break;
                }
                break;
            default:
                texture = GraphicUtil.getEmptyTexture();
                break;
        }
        return texture;
    }

    /**
     * Algorithme de Bresenham modifié pour dessiner des lignes épaisses continues
     * TODO : deplace dans un util ou ailleurs
     * ajouter drawingMapPixmap en paramètre
     */
    public static void drawThickLine(
        int x1, int y1,
        int x2, int y2,
        Color color,
        int width,
        Pixmap drawingMapPixmap
    ) {
        // Calculer la distance entre les points
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        // Sauvegarder la couleur actuelle
        //Color oldColor = new Color(drawingMapPixmap.getColor());
        drawingMapPixmap.setColor(color);

        while (true) {
            // Dessiner un cercle (ou un carré) autour du point pour créer l'épaisseur
            for (int w = -width/2; w <= width/2; w++) {
                for (int h = -width/2; h <= width/2; h++) {
                    if (w*w + h*h <= (width/2)*(width/2)) { // Cercle pour des bords lisses
                        drawingMapPixmap.drawPixel(x1 + w, y1 + h);
                    }
                }
            }

            if (x1 == x2 && y1 == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }

    }

    public static Color getTransparentColorFromCountry(CountryEnum ownerCountry, float alpha) {
        Color toReturn = ownerCountry.getColor();
        alpha = alpha < 0 ? 0 : alpha > 1 ? 1 : alpha;
        toReturn.a = alpha;
        return toReturn;
    }

    public static Color getTransparentColor(Color color, float alpha) {
        alpha = alpha < 0 ? 0 : alpha > 1 ? 1 : alpha;
        color.a = alpha;
        return color;
    }

    public static Texture getTextureFromColor(Color color) {
        Pixmap colorPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        colorPixmap.setColor(color);
        colorPixmap.fill();
        return new Texture(colorPixmap);
    }
}
