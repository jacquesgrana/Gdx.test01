package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.BufferUtils;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Entity.Unit.Unit;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Screen.EditArmyScreen;

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
/*
    public static Skin getButtonSkin(int width, int height) {
        Skin skin = new Skin();

        // Generate a default font
        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);

        // Create a texture for the button background
        // 80 / 30
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium);
        pixmap.fill();
        // Draw a 1-pixel black border
        pixmap.setColor(GraphicUtil.buttonBorderColorDark);
        pixmap.drawRectangle(0, 0, (int) pixmap.getWidth(), (int) pixmap.getHeight());
        skin.add("button-up", new Texture(pixmap));
        pixmap.dispose(); // Dispose of the Pixmap!

        Pixmap pixmapHover = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapHover.setColor(GraphicUtil.buttonHoverColorMedium);
        pixmapHover.fill();
        pixmapHover.setColor(GraphicUtil.buttonBorderColorDark); //Border Color
        pixmapHover.drawRectangle(0, 0, width, height);
        skin.add("button-hover", new Texture(pixmapHover));
        pixmapHover.dispose();


        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button-up", Color.WHITE);
        textButtonStyle.over = skin.newDrawable("button-hover", GraphicUtil.buttonHoverColorMedium); //Hover State
        textButtonStyle.down = skin.newDrawable("button-hover", GraphicUtil.buttonHoverColorMedium);
        textButtonStyle.font = skin.getFont("default-font");
        skin.add("default", textButtonStyle);

        return skin;
    }


    public static Skin getCheckBoxSkin(int size) {
        Skin skin = new Skin();

        // Police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Fond de la case (non cochée)
        Pixmap unchecked = new Pixmap(size, size, Pixmap.Format.RGBA8888);
        unchecked.setColor(0.7f, 0.7f, 0.7f, 1f); // gris clair
        unchecked.fill();
        skin.add("checkbox-unchecked", new Texture(unchecked));
        unchecked.dispose();

        // Fond de la case (cochée)
        Pixmap checked = new Pixmap(size, size, Pixmap.Format.RGBA8888);
        checked.setColor(0.2f, 0.7f, 0.2f, 1f); // vert
        checked.fill();
        // Ajoute une croix blanche
        checked.setColor(1, 1, 1, 1);
        int margin = size / 4;
        checked.drawLine(margin, margin, size - margin, size - margin);
        checked.drawLine(margin, size - margin, size - margin, margin);
        skin.add("checkbox-checked", new Texture(checked));
        checked.dispose();

        // Style du CheckBox
        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();
        checkBoxStyle.checkboxOff = skin.newDrawable("checkbox-unchecked");
        checkBoxStyle.checkboxOn = skin.newDrawable("checkbox-checked");
        checkBoxStyle.font = skin.getFont("default");
        checkBoxStyle.fontColor = Color.WHITE;

        skin.add("default", checkBoxStyle);

        return skin;
    }


    public static Skin getTextFieldSkin(int width, int height) {
        Skin skin = new Skin();

        // Génère une police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Crée un fond pour le TextField
        Pixmap bgPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(GraphicUtil.buttonColorMedium); // à définir dans GraphicUtil
        bgPixmap.fill();
        skin.add("textfield-bg", new Texture(bgPixmap));
        bgPixmap.dispose();

        // Crée le curseur (fin trait vertical blanc)
        Pixmap cursorPixmap = new Pixmap(2, height, Pixmap.Format.RGBA8888);
        cursorPixmap.setColor(Color.WHITE);
        cursorPixmap.fill();
        skin.add("textfield-cursor", new Texture(cursorPixmap));
        cursorPixmap.dispose();

        // Crée la sélection (bleu clair semi-transparent)
        Pixmap selectionPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        selectionPixmap.setColor(0.3f, 0.5f, 1f, 0.5f);
        selectionPixmap.fill();
        skin.add("textfield-selection", new Texture(selectionPixmap));
        selectionPixmap.dispose();

        // Style du TextField
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = skin.getFont("default");
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = skin.newDrawable("textfield-bg");
        textFieldStyle.cursor = skin.newDrawable("textfield-cursor");
        textFieldStyle.selection = skin.newDrawable("textfield-selection");

        skin.add("default", textFieldStyle);

        return skin;
    }



    public static Skin getLabelSkin(int width, int height) {
        Skin skin = new Skin();

        // Génère une police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Crée un fond pour le label (optionnel, tu peux l'enlever si tu veux un fond transparent)
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium); // à définir dans GraphicUtil, par exemple Color.CLEAR ou une couleur douce
        pixmap.fill();
        skin.add("label-bg", new Texture(pixmap));
        pixmap.dispose();

        // Crée le style du label
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = skin.getFont("default");
        labelStyle.background = skin.newDrawable("label-bg"); // optionnel, retire cette ligne pour un label sans fond

        skin.add("default", labelStyle);

        return skin;
    }


    public static Skin getSelectorSkin(int width, int height) {
        Skin skin = new Skin();

        // Generate a default font
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Create textures for different states
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium);
        pixmap.fill();
        pixmap.setColor(GraphicUtil.buttonBorderColorDark);
        pixmap.drawRectangle(0, 0, width, height);
        skin.add("selectbox", new Texture(pixmap));

        // Create a background for the dropdown list
        Pixmap listBg = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        listBg.setColor(GraphicUtil.buttonColorMedium);
        listBg.fill();
        listBg.setColor(GraphicUtil.buttonBorderColorDark);
        listBg.drawRectangle(0, 0, width, height);
        skin.add("list-bg", new Texture(listBg));

        // Create a selection background
        Pixmap selectionBg = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        selectionBg.setColor(GraphicUtil.buttonHoverColorMedium);
        selectionBg.fill();
        skin.add("selection", new Texture(selectionBg));

        // Dispose pixmaps
        pixmap.dispose();
        listBg.dispose();
        selectionBg.dispose();

        // Create ScrollPane style (required by SelectBox)
        ScrollPane.ScrollPaneStyle scrollPaneStyle = new ScrollPane.ScrollPaneStyle();
        skin.add("default", scrollPaneStyle);

        // Create List style (required by SelectBox)
        List.ListStyle listStyle = new List.ListStyle();
        listStyle.font = skin.getFont("default");
        listStyle.selection = skin.newDrawable("selection");
        listStyle.background = skin.newDrawable("list-bg");
        skin.add("default", listStyle);

        // Create SelectBox style
        SelectBox.SelectBoxStyle selectBoxStyle = new SelectBox.SelectBoxStyle();
        selectBoxStyle.font = skin.getFont("default");
        selectBoxStyle.background = skin.newDrawable("selectbox");
        selectBoxStyle.scrollStyle = skin.get(ScrollPane.ScrollPaneStyle.class);
        selectBoxStyle.listStyle = skin.get(List.ListStyle.class);
        selectBoxStyle.background = skin.newDrawable("selectbox");
        skin.add("default", selectBoxStyle);

        return skin;
    }


    public static Skin getUnitTreeSkin() {
        Skin skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);
        skin.add("default-color", Color.WHITE);
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));
        pixmap.dispose();

        // Créer les styles nécessaires pour Tree
        Tree.TreeStyle treeStyle = new Tree.TreeStyle();
        treeStyle.plus = skin.newDrawable("white", Color.BLACK);
        treeStyle.minus = skin.newDrawable("white", Color.GRAY);
        treeStyle.selection = skin.newDrawable("white", Color.BLUE);
        skin.add("default", treeStyle);
        return skin;
    }
    */

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
    public static void printGroup(UnitGroup group) {

        // Parcourir les unités du groupe
        for (ElementInterface element : group.getUnits()) {
            if (element instanceof UnitGroup) {
                printGroup((UnitGroup) element);


            } else if (element instanceof Unit) {

            }
            System.out.println("type : " + element.getType() + " / Name : " + element.getName());
        }
    }

    // TODO : déplacer dans UnitUtil ?
    public static Texture getCounterTextureFromUnit(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
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

        toReturn = stackTextures(background, typeIcon, paraAddon, motorisedAddon, regRankAddon, levelAddon, companyAddon);

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
        if(unit.isPara()) { // TODO : remplacer par isPara()
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

    /*
            moo1.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println(moo1.getActor().getText() + ", " + moo1.getValue() + ", " + moo1.getValue().length());
                UnitNode node = new UnitNode("added " + moo2.getChildren().size);
                node.add(new UnitNode("1"));
                node.add(new UnitNode("2"));
                node.setExpanded(MathUtils.randomBoolean());
                moo2.insert(MathUtils.randomBoolean() ? moo2.getChildren().size : MathUtils.random(0, moo2.getChildren().size), node);
            }
        });
        moo2.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                moo2.getChildren().removeValue(moo3, true);
                moo2.getChildren().add(moo3);
                moo2.updateChildren();
            }
        });
        moo5.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                UnitNode node = tree.findNode("moo4");
                if (node != null) node.remove();
            }
        });
     */
}
