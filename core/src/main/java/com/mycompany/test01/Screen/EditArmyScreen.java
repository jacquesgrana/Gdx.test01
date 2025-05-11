package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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
    private final Stage stage;
    private final BitmapFont font;
    //private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Table leftPanel, centerPanel, rightPanel, centerButtonPanel;
    private Tree<UnitNode, String> tree;

    private UnitElement selectedUnit;
    private FrontGroup rootGroup;

    //private String selectedUnitName = "nothing selected";
    private final Label selectedUnitNameLabel;
    private final Label selectedUnitTypeLabel;
    private final Label selectedUnitAcronymLabel;
    private final Label selectedUnitParentNameLabel;
    private final Image selectedUnitIcon;

    //private final Table centerButtonPanel;

    private final UnitRedCountryFactory unitRedCountryFactory;
    private final UnitBlackCountryFactory unitBlackCountryFactory;
    private final UnitBlueCountryFactory unitBlueCountryFactory;
    private final UnitBrownCountryFactory unitBrownCountryFactory;

    private ButtonWrapper buttonDeleteWrapper = null;
    private ButtonWrapper buttonAddWrapper = null;
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
        this.stage = new Stage(new ScreenViewport());
        //shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);

        this.font = new BitmapFont();
        this.selectedUnit = null;
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

        this.stage.addActor(buttonBackWrapper.getButton());

        this.leftPanel = createPanel(0);
        this.stage.addActor(this.leftPanel);
        this.leftPanel.setVisible(true);

        this.centerPanel = createPanel(1);
        this.stage.addActor(this.centerPanel);
        this.centerPanel.setVisible(true);

        this.rightPanel = createPanel(2);
        this.stage.addActor(this.rightPanel);
        this.rightPanel.setVisible(true);

        this.centerButtonPanel = createCenterButtonPanel();
        this.centerButtonPanel.setVisible(true);

        this.centerPanel.addActor(this.centerButtonPanel);

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

        selectedUnitParentNameLabel = new Label("nothing selected", labelStyle);
        selectedUnitParentNameLabel.setPosition(20f, centerPanel.getHeight() - selectedUnitTypeLabel.getHeight() - 140f);
        this.centerPanel.addActor(selectedUnitParentNameLabel);

        selectedUnitIcon = new Image(GraphicUtil.getEmptyTexture());
        selectedUnitIcon.setBounds(centerPanel.getWidth() - 128f - 20f,
            centerPanel.getHeight() - 128f - 20f,
            128f,
            128f);
        this.centerPanel.addActor(selectedUnitIcon);

        this.initTree();
        this.fillTree();

        this.leftPanel.addActor(tree);

    }

    private void resetSelectedUnit() {
        this.selectedUnit = null;

        //"nothing selected"
        selectedUnitNameLabel.setText("nothing selected");
        selectedUnitTypeLabel.setText("nothing selected");
        selectedUnitAcronymLabel.setText("nothing selected");
        selectedUnitParentNameLabel.setText("nothing selected");
        selectedUnitIcon.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getEmptyTexture())));

        this.buttonDeleteWrapper.getButton().setDisabled(true);
        this.buttonAddWrapper.getButton().setDisabled(true);
    }

    private void addListenerToRootTreeNode() {
        EditArmyScreen that = this;
        tree.getRootNodes().get(0).getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("click on root");
                that.displayUnitInfos(that.rootGroup);
                tree.getRootNodes().get(0).setExpanded(!tree.getRootNodes().get(0).isExpanded());
            }
        });
    }

    public void initTree() {
        this.tree = new Tree<>(GraphicUtil.getUnitTreeSkin());

        tree.setPadding(10);
        tree.setIndentSpacing(25);
        tree.setIconSpacing(5, 0);
        tree.setPosition(100, Gdx.graphics.getHeight() - 100f, 1);
    }

    public void fillTree() {


        this.rootGroup = unitRedCountryFactory.createFrontGroup("front","1NOR",  false,true, false, true);
        ArmyGroupGroup group01 = unitRedCountryFactory.createArmyGroupGroup("army group 01","GRP1", false, false, false, false);
        ArmyGroup group02 = unitRedCountryFactory.createArmyGroup("army 01","ARM1", true, false, false, true);
        ArmyGroup group03 = unitBlackCountryFactory.createArmyGroup("Army II", "AII", false, true, false, true);
        ArmyGroup group04 = unitBlueCountryFactory.createArmyGroup("Army 2", "2e", false, false, false, false);
        ArmyGroup group05 = unitBrownCountryFactory.createArmyGroup("Army 5", "5th", false, false, false, false);


        rootGroup.addUnit(group01);
        group01.addUnit(group02);

        MotoCivilEngineerUnit moto_civil_eng_01 = unitRedCountryFactory.createMotoCivilEngineerUnit("115th", "115", false, false, 0);
        MotoCivilEngineerUnit moto_civil_eng_02 = unitRedCountryFactory.createMotoCivilEngineerUnit("15th", "15", true, true, 0);

        MotoRocketArtiUnit moto_rocket_arti_01 = unitRedCountryFactory.createMotoRocketArtiUnit("115th", "115", false, false, 4);
        MotoRocketArtiUnit moto_rocket_arti_02 = unitRedCountryFactory.createMotoRocketArtiUnit("11th", "11", true, true, 5);

        ParaInfUnit para_inf_01 = unitRedCountryFactory.createParaInfUnit("62th para", "62", false, false, 1);
        ParaInfUnit para_inf_02 = unitRedCountryFactory.createParaInfUnit("16th para", "16", true, true, 1);

        ParaArtiUnit para_arti_01 = unitRedCountryFactory.createParaArtiUnit("112th", "112", false, false, 0);
        ParaArtiUnit para_arti_02 = unitRedCountryFactory.createParaArtiUnit("2nd", "2", true, true, 5);

        ParaMortarArtiUnit para_mortar_arti_01 = unitRedCountryFactory.createParaMortarArtiUnit("78th", "78", false, false, 0);
        ParaMortarArtiUnit para_mortar_arti_02 = unitRedCountryFactory.createParaMortarArtiUnit("7th", "7", true, true, 0);

        BridgeEngineerUnit bridge_eng_01 = unitRedCountryFactory.createBridgeEngineerUnit("177th", "177", false, false, 0);
        BridgeEngineerUnit bridge_eng_02 = unitRedCountryFactory.createBridgeEngineerUnit("85th", "85", true, true, 0);
        MotoBridgeEngineerUnit moto_bridge_eng_01 = unitRedCountryFactory.createMotoBridgeEngineerUnit("177th", "177", false, false, 0);
        MotoBridgeEngineerUnit moto_bridge_eng_02 = unitRedCountryFactory.createMotoBridgeEngineerUnit("85th", "85", true, true, 0);

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
        group02.addUnit(bridge_eng_01);
        group02.addUnit(bridge_eng_02);
        group02.addUnit(moto_bridge_eng_01);
        group02.addUnit(moto_bridge_eng_02);

        group01.addUnit(group03);

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
        tree.add(GraphicUtil.createTreeFromGroup(this.rootGroup, this));
        // ajouter listener

        /*
        EditArmyScreen that = this;
        tree.getRootNodes().get(0).getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("click on root");
                that.displayUnitInfos(that.rootGroup);
                tree.getRootNodes().get(0).setExpanded(!tree.getRootNodes().get(0).isExpanded());
            }
        });
        */
        addListenerToRootTreeNode();

        tree.expandAll();

        //stage.addActor(tree);
        float rectWidth = (Gdx.graphics.getWidth() - (3 + 1) * 50f) / 3;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        tree.setBounds(0f, -20f, rectWidth, rectHeight);
    }

    public void displayUnitInfos(ElementInterface element) {
        //this.selectedUnitName = name;
        this.selectedUnit = (UnitElement) element;
        if (selectedUnitNameLabel != null) {
            selectedUnitNameLabel.setText("Name : " + this.selectedUnit.getName());
        }
        if (selectedUnitTypeLabel != null) {
            selectedUnitTypeLabel.setText("Type : " + this.selectedUnit.getType().toString());
        }
        //selectedUnitAcronymLabel
        if (selectedUnitAcronymLabel != null) {
            selectedUnitAcronymLabel.setText("Acronym : " + this.selectedUnit.getAcronym());
        }

        if (selectedUnitParentNameLabel != null ) {
            if(this.selectedUnit.getParent() != null) {
                selectedUnitParentNameLabel.setText("Parent Name : " + this.selectedUnit.getParent().getName());
            }
            else {
                selectedUnitParentNameLabel.setText("Parent Name : Root");
            }
        }
        // faire méthode qui génère la texture en fonction de l'element (unité)
        Texture counterTexture = GraphicUtil.getCounterTextureFromUnit(this.selectedUnit);
        //System.out.println("texture : " + counterTexture);
        if (selectedUnitIcon != null) {
            selectedUnitIcon.setDrawable(new TextureRegionDrawable(counterTexture));
        }
        this.buttonDeleteWrapper.getButton().setDisabled(false);
        this.buttonAddWrapper.getButton().setDisabled(!(element instanceof UnitGroup));
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

    private Table createCenterButtonPanel() {
        float padding = 20f;
        Table panel = new Table();
        panel.defaults().pad(2);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorLight);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));

        panel.setBounds(padding, Gdx.graphics.getHeight() - 460f, (Gdx.graphics.getWidth() - 200f) / 3 - 2 * padding, 100);

        panel.setBackground(background);

        this.buttonDeleteWrapper = new ButtonWrapper(
            "Delete Unit",
            font,
            20,
            20, 150, 50);
        EditArmyScreen that = this;

        this.buttonDeleteWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {

                System.out.println("click delete unit");
                if(selectedUnit != null) {

                    //tree.clear();
                    //tree.add(GraphicUtil.createTreeFromGroup(rootGroup, that));

                    //that.tree.updateRootNodes();
                    that.removeSelectedUnitAndUpdateTree();
                }
            }
        });
        this.buttonDeleteWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonDeleteWrapper.getButton());

        this.buttonAddWrapper = new ButtonWrapper(
            "Add Unit",
            font,
            190,
            20, 150, 50);

        this.buttonAddWrapper.getButton().addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                System.out.println("click add unit");
            }
        });
        this.buttonAddWrapper.getButton().setDisabled(true);
        panel.addActor(this.buttonAddWrapper.getButton());
        return panel;
    }

    private void removeSelectedUnitAndUpdateTree() {
        selectedUnit.getParent().removeUnit(selectedUnit);
        //GraphicUtil.printGroup(rootGroup);
        tree.clear();
        UnitNode root = GraphicUtil.createTreeFromGroup(rootGroup, this);
        tree.add(root);
        tree.expandAll();
        addListenerToRootTreeNode();
        tree.invalidateHierarchy();

        // TODO : Raz de selectedUnit
        resetSelectedUnit();
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
