package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Factory.UnitBlackCountryFactory;
import com.mycompany.test01.Factory.UnitBlueCountryFactory;
import com.mycompany.test01.Factory.UnitBrownCountryFactory;
import com.mycompany.test01.Factory.UnitRedCountryFactory;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Main;
import com.mycompany.test01.Util.GraphicUtil;


public class EditArmyScreen implements Screen, InputProcessor { //,
    final Main game;
    private Stage stage;
    private BitmapFont font;
    //private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Table leftPanel, centerPanel, rightPanel;
    private Tree<UnitNode, String> tree;

    //private String selectedUnitName = "nothing selected";
    private final Label selectedUnitNameLabel;
    private final Label selectedUnitTypeLabel;
    private final Label selectedUnitAcronymLabel;

    private final Image selectedUnitIcon;


    private UnitRedCountryFactory unitRedCountryFactory;
    private UnitBlackCountryFactory unitBlackCountryFactory;
    private UnitBlueCountryFactory unitBlueCountryFactory;
    private UnitBrownCountryFactory unitBrownCountryFactory;


    //private Skin skin;

    /*
    class Node extends Tree.Node<Node, String, TextButton> {
        public Node (String text) {
            super(new TextButton(text, GraphicUtil.getButtonSkin(30,30)));
            setValue(text);
        }
    }
*/
    public EditArmyScreen(Main game) {
        this.unitRedCountryFactory = new UnitRedCountryFactory();
        this.unitBlackCountryFactory = new UnitBlackCountryFactory();
        this.unitBlueCountryFactory = new UnitBlueCountryFactory();
        this.unitBrownCountryFactory = new UnitBrownCountryFactory();
        this.game = game;
        stage = new Stage(new ScreenViewport());
        //shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        /*
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Roboto_Condensed-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + "•";
        font = generator.generateFont(parameter);
        generator.dispose();*/

        //this.skin = GraphicUtil.getButtonSkin(10, 10);
        //Tree<Label, String> tree = new Tree<>(skin);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Army", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            font,
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            20, 200, 50);

        buttonBackWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(buttonBackWrapper.getButton());

        this.leftPanel = createPanel(0);
        stage.addActor(leftPanel);
        this.leftPanel.setVisible(true);

        this.centerPanel = createPanel(1);
        stage.addActor(centerPanel);
        this.centerPanel.setVisible(true);

        this.rightPanel = createPanel(2);
        stage.addActor(rightPanel);
        this.rightPanel.setVisible(true);

        //Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        selectedUnitNameLabel = new Label("nothing selected", labelStyle);
        selectedUnitNameLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitNameLabel.getHeight() - 20f);
        this.centerPanel.addActor(selectedUnitNameLabel);


        selectedUnitTypeLabel = new Label("nothing selected", labelStyle);
        selectedUnitTypeLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 60f);
        this.centerPanel.addActor(selectedUnitTypeLabel);

        selectedUnitAcronymLabel = new Label("nothing selected", labelStyle);
        selectedUnitAcronymLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 100f);
        this.centerPanel.addActor(selectedUnitAcronymLabel);

        selectedUnitIcon = new Image(GraphicUtil.counterBgRedCountry01Texture);
        selectedUnitIcon.setBounds(centerPanel.getWidth() - 128f - 20f,
            centerPanel.getHeight() - 128f - 20f,
            128f,
            128f);
        this.centerPanel.addActor(selectedUnitIcon);

        this.tree = new Tree<>(GraphicUtil.getUnitTreeSkin());

        tree.setPadding(10);
        tree.setIndentSpacing(25);
        tree.setIconSpacing(5, 0);
        tree.setPosition(100, Gdx.graphics.getHeight() - 100f, 1);

        FrontGroup rootGroup = unitRedCountryFactory.createFrontGroup("front","1NOR",  false,true, false, true);
        ArmyGroupGroup group01 = unitRedCountryFactory.createArmyGroupGroup("army group 01","GRP1", false, false, false, false);
        ArmyGroup group02 = unitRedCountryFactory.createArmyGroup("army 01","ARM1", false, true, false, true);
        ArmyGroup group03 = unitBlackCountryFactory.createArmyGroup("Army II", "AII", false, true, false, true);
        ArmyGroup group04 = unitBlueCountryFactory.createArmyGroup("Army 2", "2e", false, false, false, false);
        ArmyGroup group05 = unitBrownCountryFactory.createArmyGroup("Army 5", "5th", false, false, false, false);

        /*
        InfantryUnit unit01 = unitRedCountryFactory.createInfantryUnit ( "unit 01","125", false, 2);
        CavalryUnit unit02 = unitRedCountryFactory.createCavalryUnit("unit 02","13", false, false, 1);



        InfantryUnit unit03 = unitRedCountryFactory.createInfantryUnit("unit 03","328", true, 3);
        ArtiUnit unit04 = unitRedCountryFactory.createArtiUnit("unit 04","ARM1", true, 4);
        TankUnit unit05 = unitRedCountryFactory.createTankUnit("unit 05","ARM1", false, false, 1);
        AntiTankUnit unit06 = unitRedCountryFactory.createAntiTankUnit("unit 05","ARM1", false, 2);
        AntiAirUnit unit07 = unitRedCountryFactory.createAntiAirUnit("unit 05","ARM1", true, 4);
            //OrderedSet<Element> units = new OrderedSet<>();
        ParaUnit unit08 = unitRedCountryFactory.createParaUnit("unit 08", "501", true, false, 3);
        MarineUnit unit09 = unitRedCountryFactory.createMarineUnit("unit 09", "16M", true, false, 1);
        MarineUnit unit13 = unitRedCountryFactory.createMarineUnit("unit 13", "17M", true, true, 0);

        EngineerUnit unit10 = unitRedCountryFactory.createEngineerUnit("unit10", "512", false, 0);
        MecaInfUnit unit11 = unitRedCountryFactory.createMecaInfUnit("unit11", "117", true, false, 4);
        MecaRecoUnit unit12 = unitRedCountryFactory.createMecaRecoUnit("unit12", "233", false, false, 0);
        MotoInfUnit unit14 = unitRedCountryFactory.createMotoInfUnit("unit14", "33G", true, 3);
        MotoEngineerUnit unit15 = unitRedCountryFactory.createMotoEngineerUnit("unit15", "1102", false, 2);
        MotoArtiUnit unit16 = unitRedCountryFactory.createMotoArtiUnit("unit16", "442", false, 2);

        rootGroup.addUnit(group01);
        rootGroup.addUnit(unit01);
        rootGroup.addUnit(unit02);

        group01.addUnit(group02);
        group01.addUnit(unit03);
        group01.addUnit(unit14);

        group02.addUnit(unit10);
        group02.addUnit(unit11);
        group02.addUnit(unit12);
        group02.addUnit(unit13);
        group02.addUnit(unit15);
        group02.addUnit(unit16);


        group02.addUnit(unit04);
        group02.addUnit(unit05);
        group02.addUnit(unit06);
        group02.addUnit(unit07);
        group02.addUnit(unit08);

        group02.addUnit(unit09);
*/

        rootGroup.addUnit(group01);
        group01.addUnit(group02);
        /*
        MountainInfantryUnit red_mountain_inf_01 = unitRedCountryFactory.createMountainInfUnit("Mtn 755", "755", false, false, 0);
        MountainInfantryUnit red_mountain_inf_02 = unitRedCountryFactory.createMountainInfUnit("Mtn 17", "17", true, true, 0);

        AssaultGun assault_gun_01 = unitRedCountryFactory.createAssaultGunUnit("478 Assault_Gun", "478", false, false, 0);
        AssaultGun assault_gun_02 = unitRedCountryFactory.createAssaultGunUnit("85 Assault_Gun", "85", true, true, 0);

        MountainArtiUnit mountain_arti_01 = unitRedCountryFactory.createMountainArtiUnit("125th Mountain Art", "125", false, false, 1);
        MountainArtiUnit mountain_arti_02 = unitRedCountryFactory.createMountainArtiUnit("82th Mountain Art", "82", true, true, 2);

        SkiInfantryUnit ski_inf_01 = unitRedCountryFactory.createSkiInfUnit("45 Ski", "45", false, false, 0);
        SkiInfantryUnit ski_inf_02 = unitRedCountryFactory.createSkiInfUnit("4 Ski", "4", true, true, 0);

        MecaArtiUnit meca_arti_01 = unitRedCountryFactory.createMecaArtiUnit("302th", "302", false, false, 0);
        MecaArtiUnit meca_arti_02 = unitRedCountryFactory.createMecaArtiUnit("32th", "32", true, true, 0);


        MortarArtiUnit mortar_arti_01 = unitRedCountryFactory.createMortarArtiUnit("118th", "118", false, false, 0);
        MortarArtiUnit mortar_arti_02 = unitRedCountryFactory.createMortarArtiUnit("9th", "9", true, true, 0);

        CivilEngineerUnit civil_eng_01 = unitRedCountryFactory.createCivilEngineerUnit("10th NW", "10NW", false, false, 0);
        CivilEngineerUnit civil_eng_02 = unitRedCountryFactory.createCivilEngineerUnit("2th W", "2W", true, true, 0);

        MachineGunUnit machine_gun_01 = unitRedCountryFactory.createMachineGunUnit("725th", "728", false, false, 0);
        MachineGunUnit machine_gun_02 = unitRedCountryFactory.createMachineGunUnit("122th", "122", true, true, 0);

        RocketArtiUnit rocket_arti_01 = unitRedCountryFactory.createRocketArtiUnit("385th", "385", false, false, 0);
        RocketArtiUnit rocket_arti_02 = unitRedCountryFactory.createRocketArtiUnit("35th", "35", true, true, 0);

        GliderInfantryUnit glider_in_01 = unitRedCountryFactory.createGliderInfUnit("32th", "32", false, false, 0);
        GliderInfantryUnit glider_in_02 = unitRedCountryFactory.createGliderInfUnit("32th", "32", true, true, 0);

         */

        BicycleInfUnit bicycle_inf_01 = unitRedCountryFactory.createBicycleUnit("62th", "62", false, false, 0);
        BicycleInfUnit bicycle_inf_02 = unitRedCountryFactory.createBicycleUnit("6th", "6", true, true, 0);

        MotorcycleInfUnit motorcycle_inf_01 = unitRedCountryFactory.createMotorcycleUnit("62th", "62", false, false, 0);
        MotorcycleInfUnit motorcycle_inf_02 = unitRedCountryFactory.createMotorcycleUnit("6th", "6", true, true, 0);

        HeavyTankUnit heavy_tank_01 = unitRedCountryFactory.createHeavyTankUnit("16th", "16", false, false, 0);
        HeavyTankUnit heavy_tank_02 = unitRedCountryFactory.createHeavyTankUnit("6th", "6", true, true, 0);

        SkiMachineGunUnit ski_mg_01 = unitRedCountryFactory.createSkiMachineGunUnit("372th", "372", false, false, 0);
        SkiMachineGunUnit ski_mg_02 = unitRedCountryFactory.createSkiMachineGunUnit("372th", "372", true, true, 0);

        LogisticUnit logistic_01 = unitRedCountryFactory.createLogisticUnit("16th", "16", false, false, 3);
        LogisticUnit logistic_02 = unitRedCountryFactory.createLogisticUnit("11th", "1", true, true, 0);

        MotoMortarArtiUnit moto_mortar_01 = unitRedCountryFactory.createMotoMortarArtiUnit("115th", "115", false, false, 0);
        MotoMortarArtiUnit moto_mortar_02 = unitRedCountryFactory.createMotoMortarArtiUnit("75th", "75", true, true, 0);

        MotoCivilEngineerUnit moto_civil_eng_01 = unitRedCountryFactory.createMotoCivilEngineerUnit("115th", "115", false, false, 0);
        MotoCivilEngineerUnit moto_civil_eng_02 = unitRedCountryFactory.createMotoCivilEngineerUnit("15th", "15", true, true, 0);

        MotoRocketArtiUnit moto_rocket_arti_01 = unitRedCountryFactory.createMotoRocketArtiUnit("115th", "115", false, false, 4);
        MotoRocketArtiUnit moto_rocket_arti_02 = unitRedCountryFactory.createMotoRocketArtiUnit("11th", "11", true, true, 5);

        ParaInfUnit para_inf_01 = unitRedCountryFactory.createParaUnit("62th para", "62", false, false, 1);
        ParaInfUnit para_inf_02 = unitRedCountryFactory.createParaUnit("16th para", "16", true, true, 1);

        ParaArtiUnit para_arti_01 = unitRedCountryFactory.createParaArtiUnit("112th", "112", false, false, 0);
        ParaArtiUnit para_arti_02 = unitRedCountryFactory.createParaArtiUnit("2nd", "2", true, true, 5);

        ParaMortarArtiUnit para_mortar_arti_01 = unitRedCountryFactory.createParaMortarArtiUnit("78th", "78", false, false, 0);
        ParaMortarArtiUnit para_mortar_arti_02 = unitRedCountryFactory.createParaMortarArtiUnit("7th", "7", true, true, 0);

        /*
        group02.addUnit(red_mountain_inf_01);
        group02.addUnit(red_mountain_inf_02);
        group02.addUnit(assault_gun_01);
        group02.addUnit(assault_gun_02);
        group02.addUnit(mountain_arti_01);
        group02.addUnit(mountain_arti_02);
        group02.addUnit(ski_inf_01);
        group02.addUnit(ski_inf_02);
        group02.addUnit(meca_arti_01);
        group02.addUnit(meca_arti_02);

        group02.addUnit(mortar_arti_01);
        group02.addUnit(mortar_arti_02);
        group02.addUnit(civil_eng_01);
        group02.addUnit(civil_eng_02);
        group02.addUnit(machine_gun_01);
        group02.addUnit(machine_gun_02);
        group02.addUnit(rocket_arti_01);
        group02.addUnit(rocket_arti_02);
        group02.addUnit(glider_in_01);
        group02.addUnit(glider_in_02);
         */

        group02.addUnit(bicycle_inf_01);
        group02.addUnit(bicycle_inf_02);
        group02.addUnit(motorcycle_inf_01);
        group02.addUnit(motorcycle_inf_02);
        group02.addUnit(heavy_tank_01);
        group02.addUnit(heavy_tank_02);
        group02.addUnit(ski_mg_01);
        group02.addUnit(ski_mg_02);
        group02.addUnit(logistic_01);
        group02.addUnit(logistic_02);
        group02.addUnit(moto_mortar_01);
        group02.addUnit(moto_mortar_02);
        group02.addUnit(moto_civil_eng_01);
        group02.addUnit(moto_civil_eng_02);
        group02.addUnit(moto_rocket_arti_01);
        group02.addUnit(moto_rocket_arti_02);
        group02.addUnit(para_inf_01);
        group02.addUnit(para_inf_02);
        group02.addUnit(para_arti_01);
        group02.addUnit(para_arti_02);
        group02.addUnit(para_mortar_arti_01);
        group02.addUnit(para_mortar_arti_02);

        /*
        DivisionGroup elitInfDiv = unitRedCountryFactory.createEliteInfDivision("46th Guard div", "46G");
        group02.addUnit(elitInfDiv);

        DivisionGroup infDiv = unitRedCountryFactory.createInfDivision("455th div", "455");
        group02.addUnit(infDiv);

        DivisionGroup motoInfDiv = unitRedCountryFactory.createMotoInfDivision("78th moto div", "78M");
        group02.addUnit(motoInfDiv);

        BrigadeGroup motoInfBrig = unitRedCountryFactory.createMotoInfBrigade("77th moto brigade", "77M");
        group02.addUnit(motoInfBrig);
        */

        group01.addUnit(group03);


        /*
        MountainInfantryUnit black_mountain_inf_01 = unitBlackCountryFactory.createMountainInfUnit("Mtn 455", "455", false, false, 0);
        MountainInfantryUnit black_mountain_inf_02 = unitBlackCountryFactory.createMountainInfUnit("Mtn 32", "32", true, true, 0);
        AssaultGun black_assault_gun_01 = unitBlackCountryFactory.createAssaultGunUnit("311 Assault_Gun", "311", false, false, 0);
        AssaultGun black_assault_gun_02 = unitBlackCountryFactory.createAssaultGunUnit("12 Assault_Gun", "12", true, true, 0);
        MountainArtiUnit black_mountain_arti_01 = unitBlackCountryFactory.createMountainArtiUnit("14th Mountain Art", "14", false, false, 1);
        MountainArtiUnit black_mountain_arti_02 = unitBlackCountryFactory.createMountainArtiUnit("7th Mountain Art", "7", true, true, 2);
        SkiInfantryUnit black_ski_inf_01 = unitBlackCountryFactory.createSkiInfUnit("45 Ski", "45", false, false, 0);
        SkiInfantryUnit black_ski_inf_02 = unitBlackCountryFactory.createSkiInfUnit("4 Ski", "4", true, true, 0);
        MecaArtiUnit black_meca_arti_01 = unitBlackCountryFactory.createMecaArtiUnit("302th", "302", false, false, 0);
        MecaArtiUnit black_meca_arti_02 = unitBlackCountryFactory.createMecaArtiUnit("32th", "32", true, true, 0);

        MortarArtiUnit black_mortar_arti_01 = unitBlackCountryFactory.createMortarArtiUnit("118th", "118", false, false, 0);
        MortarArtiUnit black_mortar_arti_02 = unitBlackCountryFactory.createMortarArtiUnit("9th", "9", true, true, 0);
        CivilEngineerUnit black_civil_eng_01 = unitBlackCountryFactory.createCivilEngineerUnit("10th NW", "10NW", false, false, 0);
        CivilEngineerUnit black_civil_eng_02 = unitBlackCountryFactory.createCivilEngineerUnit("2th W", "2W", true, true, 0);
        MachineGunUnit black_machine_gun_01 = unitBlackCountryFactory.createMachineGunUnit("725th", "728", false, false, 0);
        MachineGunUnit black_machine_gun_02 = unitBlackCountryFactory.createMachineGunUnit("122th", "122", true, true, 0);
        RocketArtiUnit black_rocket_arti_01 = unitBlackCountryFactory.createRocketArtiUnit("145th", "145", false, false, 0);
        RocketArtiUnit black_rocket_arti_02 = unitBlackCountryFactory.createRocketArtiUnit("8th", "8", true, true, 0);
        GliderInfantryUnit black_glider_in_01 = unitBlackCountryFactory.createGliderInfUnit("32th", "32", false, false, 0);
        GliderInfantryUnit black_glider_in_02 = unitBlackCountryFactory.createGliderInfUnit("32th", "32", true, true, 0);
        */

        BicycleInfUnit black_bicycle_inf_01 = unitBlackCountryFactory.createBicycleUnit("62th", "62", false, false, 0);
        BicycleInfUnit black_bicycle_inf_02 = unitBlackCountryFactory.createBicycleUnit("6th", "6", true, true, 0);
        MotorcycleInfUnit black_motorcycle_inf_01 = unitBlackCountryFactory.createMotorcycleUnit("62th", "62", false, false, 0);
        MotorcycleInfUnit black_motorcycle_inf_02 = unitBlackCountryFactory.createMotorcycleUnit("6th", "6", true, true, 0);
        HeavyTankUnit black_heavy_tank_01 = unitBlackCountryFactory.createHeavyTankUnit("33th", "33", false, false, 0);
        HeavyTankUnit black_heavy_tank_02 = unitBlackCountryFactory.createHeavyTankUnit("7th", "7", true, true, 0);
        SkiMachineGunUnit black_ski_mg_01 = unitBlackCountryFactory.createSkiMachineGunUnit("372th", "372", false, false, 0);
        SkiMachineGunUnit black_ski_mg_02 = unitBlackCountryFactory.createSkiMachineGunUnit("372th", "372", true, true, 0);
        LogisticUnit black_logistic_01 = unitBlackCountryFactory.createLogisticUnit("8th", "8", false, false, 3);
        LogisticUnit black_logistic_02 = unitBlackCountryFactory.createLogisticUnit("3th", "3", true, true, 0);
        MotoMortarArtiUnit black_moto_mortar_01 = unitBlackCountryFactory.createMotoMortarArtiUnit("115th", "115", false, false, 0);
        MotoMortarArtiUnit black_moto_mortar_02 = unitBlackCountryFactory.createMotoMortarArtiUnit("75th", "75", true, true, 0);
        MotoCivilEngineerUnit black_moto_civil_eng_01 = unitBlackCountryFactory.createMotoCivilEngineerUnit("115th", "115", false, false, 0);
        MotoCivilEngineerUnit black_moto_civil_eng_02 = unitBlackCountryFactory.createMotoCivilEngineerUnit("15th", "15", true, true, 0);
        MotoRocketArtiUnit black_moto_rocket_arti_01 = unitBlackCountryFactory.createMotoRocketArtiUnit("328th", "328", false, false, 2);
        MotoRocketArtiUnit black_moto_rocket_arti_02 = unitBlackCountryFactory.createMotoRocketArtiUnit("10th", "10", true, true, 3);

        /*
        group03.addUnit(black_mountain_inf_01);
        group03.addUnit(black_mountain_inf_02);
        group03.addUnit(black_assault_gun_01);
        group03.addUnit(black_assault_gun_02);
        group03.addUnit(black_mountain_arti_01);
        group03.addUnit(black_mountain_arti_02);
        group03.addUnit(black_ski_inf_01);
        group03.addUnit(black_ski_inf_02);
        group03.addUnit(black_meca_arti_01);
        group03.addUnit(black_meca_arti_02);

        group03.addUnit(black_mortar_arti_01);

        group03.addUnit(black_mortar_arti_02);
        group03.addUnit(black_civil_eng_01);
        group03.addUnit(black_civil_eng_02);
        group03.addUnit(black_machine_gun_01);
        group03.addUnit(black_machine_gun_02);
        group03.addUnit(black_rocket_arti_01);
        group03.addUnit(black_rocket_arti_02);
        group03.addUnit(black_glider_in_01);
        group03.addUnit(black_glider_in_02);

 */
        group03.addUnit(black_bicycle_inf_01);
        group03.addUnit(black_bicycle_inf_02);
        group03.addUnit(black_motorcycle_inf_01);
        group03.addUnit(black_motorcycle_inf_02);
        group03.addUnit(black_heavy_tank_01);
        group03.addUnit(black_heavy_tank_02);
        group03.addUnit(black_ski_mg_01);
        group03.addUnit(black_ski_mg_02);
        group03.addUnit(black_logistic_01);
        group03.addUnit(black_logistic_02);
        group03.addUnit(black_moto_mortar_01);
        group03.addUnit(black_moto_mortar_02);
        group03.addUnit(black_moto_civil_eng_01);
        group03.addUnit(black_moto_civil_eng_02);
        group03.addUnit(black_moto_rocket_arti_01);
        group03.addUnit(black_moto_rocket_arti_02);

        group01.addUnit(group04);

        BicycleInfUnit blue_bicycle_inf_01 = unitBlueCountryFactory.createBicycleUnit("62th", "62", false, false, 0);
        BicycleInfUnit blue_bicycle_inf_02 = unitBlueCountryFactory.createBicycleUnit("6th", "6", true, true, 0);
        MotorcycleInfUnit blue_motorcycle_inf_01 = unitBlueCountryFactory.createMotorcycleUnit("62th", "62", false, false, 0);
        MotorcycleInfUnit blue_motorcycle_inf_02 = unitBlueCountryFactory.createMotorcycleUnit("6th", "6", true, true, 0);
        HeavyTankUnit blue_heavy_tank_01 = unitBlueCountryFactory.createHeavyTankUnit("33th", "33", false, false, 0);
        HeavyTankUnit blue_heavy_tank_02 = unitBlueCountryFactory.createHeavyTankUnit("7th", "7", true, true, 0);
        SkiMachineGunUnit blue_ski_mg_01 = unitBlueCountryFactory.createSkiMachineGunUnit("372th", "372", false, false, 0);
        SkiMachineGunUnit blue_ski_mg_02 = unitBlueCountryFactory.createSkiMachineGunUnit("372th", "372", true, true, 0);
        LogisticUnit blue_logistic_01 = unitBlueCountryFactory.createLogisticUnit("8th", "8", false, false, 3);
        LogisticUnit blue_logistic_02 = unitBlueCountryFactory.createLogisticUnit("3th", "3", true, true, 0);
        MotoMortarArtiUnit blue_moto_mortar_01 = unitBlueCountryFactory.createMotoMortarArtiUnit("115th", "115", false, false, 0);
        MotoMortarArtiUnit blue_moto_mortar_02 = unitBlueCountryFactory.createMotoMortarArtiUnit("75th", "75", true, true, 0);
        MotoCivilEngineerUnit blue_moto_civil_eng_01 = unitBlueCountryFactory.createMotoCivilEngineerUnit("115th", "115", false, false, 0);
        MotoCivilEngineerUnit blue_moto_civil_eng_02 = unitBlueCountryFactory.createMotoCivilEngineerUnit("15th", "15", true, true, 0);
        MotoRocketArtiUnit blue_moto_rocket_arti_01 = unitBlueCountryFactory.createMotoRocketArtiUnit("328th", "328", false, false, 2);
        MotoRocketArtiUnit blue_moto_rocket_arti_02 = unitBlueCountryFactory.createMotoRocketArtiUnit("10th", "10", true, true, 3);

        group04.addUnit(blue_bicycle_inf_01);
        group04.addUnit(blue_bicycle_inf_02);
        group04.addUnit(blue_motorcycle_inf_01);
        group04.addUnit(blue_motorcycle_inf_02);
        group04.addUnit(blue_heavy_tank_01);
        group04.addUnit(blue_heavy_tank_02);
        group04.addUnit(blue_ski_mg_01);
        group04.addUnit(blue_ski_mg_02);
        group04.addUnit(blue_logistic_01);
        group04.addUnit(blue_logistic_02);
        group04.addUnit(blue_moto_mortar_01);
        group04.addUnit(blue_moto_mortar_02);
        group04.addUnit(blue_moto_civil_eng_01);
        group04.addUnit(blue_moto_civil_eng_02);
        group04.addUnit(blue_moto_rocket_arti_01);
        group04.addUnit(blue_moto_rocket_arti_02);

        group01.addUnit(group05);

        BicycleInfUnit brown_bicycle_inf_01 = unitBrownCountryFactory.createBicycleUnit("62th", "62", false, false, 0);
        BicycleInfUnit brown_bicycle_inf_02 = unitBrownCountryFactory.createBicycleUnit("6th", "6", true, true, 0);
        MotorcycleInfUnit brown_motorcycle_inf_01 = unitBrownCountryFactory.createMotorcycleUnit("62th", "62", false, false, 0);
        MotorcycleInfUnit brown_motorcycle_inf_02 = unitBrownCountryFactory.createMotorcycleUnit("6th", "6", true, true, 0);
        HeavyTankUnit brown_heavy_tank_01 = unitBrownCountryFactory.createHeavyTankUnit("33th", "33", false, false, 0);
        HeavyTankUnit brown_heavy_tank_02 = unitBrownCountryFactory.createHeavyTankUnit("7th", "7", true, true, 0);
        SkiMachineGunUnit brown_ski_mg_01 = unitBrownCountryFactory.createSkiMachineGunUnit("372th", "372", false, false, 0);
        SkiMachineGunUnit brown_ski_mg_02 = unitBrownCountryFactory.createSkiMachineGunUnit("372th", "372", true, true, 0);
        LogisticUnit brown_logistic_01 = unitBrownCountryFactory.createLogisticUnit("8th", "8", false, false, 3);
        LogisticUnit brown_logistic_02 = unitBrownCountryFactory.createLogisticUnit("3th", "3", true, true, 0);
        MotoMortarArtiUnit brown_moto_mortar_01 = unitBrownCountryFactory.createMotoMortarArtiUnit("115th", "115", false, false, 0);
        MotoMortarArtiUnit brown_moto_mortar_02 = unitBrownCountryFactory.createMotoMortarArtiUnit("75th", "75", true, true, 0);
        MotoCivilEngineerUnit brown_moto_civil_eng_01 = unitBrownCountryFactory.createMotoCivilEngineerUnit("115th", "115", false, false, 0);
        MotoCivilEngineerUnit brown_moto_civil_eng_02 = unitBrownCountryFactory.createMotoCivilEngineerUnit("15th", "15", true, true, 0);
        MotoRocketArtiUnit brown_moto_rocket_arti_01 = unitBrownCountryFactory.createMotoRocketArtiUnit("328th", "328", false, false, 2);
        MotoRocketArtiUnit brown_moto_rocket_arti_02 = unitBrownCountryFactory.createMotoRocketArtiUnit("10th", "10", true, true, 3);

        group05.addUnit(brown_bicycle_inf_01);
        group05.addUnit(brown_bicycle_inf_02);
        group05.addUnit(brown_motorcycle_inf_01);
        group05.addUnit(brown_motorcycle_inf_02);
        group05.addUnit(brown_heavy_tank_01);
        group05.addUnit(brown_heavy_tank_02);
        group05.addUnit(brown_ski_mg_01);
        group05.addUnit(brown_ski_mg_02);
        group05.addUnit(brown_logistic_01);
        group05.addUnit(brown_logistic_02);
        group05.addUnit(brown_moto_mortar_01);
        group05.addUnit(brown_moto_mortar_02);
        group05.addUnit(brown_moto_civil_eng_01);
        group05.addUnit(brown_moto_civil_eng_02);
        group05.addUnit(brown_moto_rocket_arti_01);
        group05.addUnit(brown_moto_rocket_arti_02);

        /*
        DivisionGroup eliteBlackInfDiv = unitBlackCountryFactory.createEliteInfDivision("1st div", "1Div");
        group03.addUnit(eliteBlackInfDiv);

        DivisionGroup blackInfDiv = unitBlackCountryFactory.createInfDivision("455th div", "455");
        group03.addUnit(blackInfDiv);

        DivisionGroup blackMotoInfDiv = unitBlackCountryFactory.createMotoInfDivision("87th div", "87");
        group03.addUnit(blackMotoInfDiv);
        //units.add(rootGroup);
        */
        tree.add(GraphicUtil.createTreeFromGroup(rootGroup, this));
        // ajouter listener

        EditArmyScreen that = this;
        tree.getRootNodes().get(0).getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("click on root");
                that.displayUnitInfos(rootGroup);
                tree.getRootNodes().get(0).setExpanded(!tree.getRootNodes().get(0).isExpanded());
            }
        });

        tree.expandAll();

        //stage.addActor(tree);
        float rectWidth = (Gdx.graphics.getWidth() - (3 + 1) * 50f) / 3;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        tree.setBounds(0f, -20f, rectWidth, rectHeight);
        this.leftPanel.addActor(tree);

    }

    public void displayUnitInfos(ElementInterface element) {
        //this.selectedUnitName = name;
        if (selectedUnitNameLabel != null) {
            selectedUnitNameLabel.setText("Unit Name : " + element.getName());
        }
        if (selectedUnitTypeLabel != null) {
            selectedUnitTypeLabel.setText("Unit Type : " + element.getType().toString());
        }
        //selectedUnitAcronymLabel
        if (selectedUnitAcronymLabel != null) {
            selectedUnitAcronymLabel.setText("Unit Acronym : " + element.getAcronym());
        }
        // faire méthode qui génère la texture en fonction de l'element (unité)
        Texture counterTexture = GraphicUtil.getCounterTextureFromUnit(element);
        //System.out.println("texture : " + counterTexture);
        if (selectedUnitIcon != null) {
            selectedUnitIcon.setDrawable(new TextureRegionDrawable(counterTexture));
        }


        //System.out.println("nom : " + element.getName());
    }


    private Table createPanel(int columnNumber) {
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x = spacing + columnNumber * (spacing + rectWidth);
        Table panel = new Table();
        panel.defaults().pad(3);
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorMedium);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));
        //texture.dispose();
        //panel.setPosition(x, 100f);
        panel.setBounds(x, 100f, rectWidth, rectHeight);
        panel.setBackground(background);

        return panel;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x1 = spacing;
        float x2 = 2f * spacing + rectWidth;
        float x3 = 3f * spacing + 2f * rectWidth;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(GraphicUtil.backgroundColorMedium);
        shapeRenderer.rect(x1, 100f, rectWidth, rectHeight);
        shapeRenderer.rect(x2, 100f, rectWidth, rectHeight);
        //shapeRenderer.setColor(GraphicUtil.backgroundColorLight);
        shapeRenderer.rect(x3, 100f, rectWidth, rectHeight);
        shapeRenderer.end();
        */
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        font.dispose();
        //shapeRenderer.dispose();
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

}
