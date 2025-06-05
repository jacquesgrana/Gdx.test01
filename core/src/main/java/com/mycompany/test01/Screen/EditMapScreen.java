package com.mycompany.test01.Screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.ToastObserver;
import com.mycompany.test01.Main;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Service.MapFileService;
import com.mycompany.test01.Service.EditMapService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.MapUtil;
import com.mycompany.test01.Util.SkinUtil;

public class EditMapScreen implements Screen {
    final Main game;
    final Stage stage;
    final BitmapFont font;
    final SpriteBatch batch;
    private Pixmap drawingMapPixmap;
    private Texture drawingTexture = null;
    final EditMapService editMapService;
    final MapFileService mapFileService;
    private boolean isMiniMapVisible = false;
    private EditMapMode mode;
    private final Label modeLabel;
    private Label selectedTerrainLabel;
    private Label selectedFortificationLabel;
    private Label selectedRoadLabel;
    private Label selectedRiverLabel;
    private final Table terrainButtonPanel;
    private final Table fortificationButtonPanel;
    private final Table roadButtonPanel;
    private final Table riverButtonPanel;
    private final Table miscButtonPanel;
    private final Table newMapPanel;

    //private final Skin skin; //Skin for UI elements
    private HexagonCategory selectedTerrain = HexagonCategory.GRASS;
    private FortificationCategory selectedFortification = FortificationCategory.NO_FORTIFICATION;
    private RoadCategory selectedRoad = RoadCategory.NO_ROAD;
    private RiverCategory selectedRiver = RiverCategory.NO_RIVER;

    // TODO déplacer dans le service ?
    //private DrawFlagCategory roadDrawFlag = DrawFlagCategory.EMPTY;
    //private DrawFlagCategory riverDrawFlag = DrawFlagCategory.EMPTY;
    //private DrawFlagCategory cliffDrawFlag = DrawFlagCategory.EMPTY;

    private final ToastObservable toastObservable;

    private final InputMultiplexer inputMultiplexer; // Nouveau champ
    private EditMapScreenInputAdapter screenInputAdapter; // Pour la logique d'entrée de l'écran
    private TextField sizeXField; // Pour y accéder plus tard
    private TextField sizeYField; // Pour y accéder plus tard

    //private boolean isMapVisble;

    public EditMapScreen(Main game) {
        this.mode = EditMapMode.NO_ACTION;
        this.editMapService = EditMapService.getInstance();
        this.editMapService.firstInit();
        this.editMapService.init();
        this.editMapService.resetMap();

        this.mapFileService = MapFileService.getInstance();

        this.toastObservable = ToastObservable.getInstance();
        this.subscribeToObservables();
        //mapService.updateMapSize();
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.batch = new SpriteBatch();

        //Gdx.input.setInputProcessor(this);
        //InputMultiplexer im = new InputMultiplexer();
        // first let the stage see the event (so buttons, text‐fields, etc. work)
        //im.addProcessor(stage);
        // then send it to your screen for map‐editing logic
        //im.addProcessor(this);
        //Gdx.input.setInputProcessor(im);
        //Gdx.input.setInputProcessor(stage);


        this.font = new BitmapFont();

        this.screenInputAdapter = new EditMapScreenInputAdapter(this);

        // Configurer InputMultiplexer
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);             // La Stage d'abord, pour que les UI aient la priorité
        inputMultiplexer.addProcessor(screenInputAdapter); // Puis votre logique d'écran personnalisée

        Gdx.input.setInputProcessor(inputMultiplexer);    // Définir le multiplexeur comme processeur principal

        //this.isMapVisble = true;
        //this.skin = SkinUtil.getButtonSkin(80, 30);

        //editMapService.initRandomMapArray();
        //this.selectedTerrainPanel = null;
        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Map", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            20, 200, 50);

        buttonBackWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(buttonBackWrapper.getButton());

        // label "selected mode :"
        this.modeLabel = new Label("Edit Mode : " + this.mode, labelStyle);
        this.modeLabel.setPosition(50, 130);
        stage.addActor(this.modeLabel);

        // boutons mode : "no-action", "terrain", "road", "river"
        ButtonWrapper buttonModeNoActionWrapper = new ButtonWrapper(
            "No Action",
            50, 80, 140, 40);
        EditMapScreen that = this;
        buttonModeNoActionWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.NO_ACTION;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeNoActionWrapper.getButton());

        ButtonWrapper buttonModeTerrainWrapper = new ButtonWrapper(
            "Terrain",
            50 + 10 + 140, 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeTerrainWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.TERRAIN;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideFortificationButtonPanel();// Show the terrain panel when in terrain mode
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                showTerrainButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeTerrainWrapper.getButton());

        ButtonWrapper buttonModeRiverWrapper = new ButtonWrapper(
            "River",
            50 + 2 * (10 + 140), 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeRiverWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.RIVER;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                showRiverButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeRiverWrapper.getButton());

        ButtonWrapper buttonModeRoadWrapper = new ButtonWrapper(
            "Road",
            50 + 3 * (10 + 140), 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeRoadWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.ROAD;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                showRoadButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeRoadWrapper.getButton());

        ButtonWrapper buttonModeFortificationWrapper = new ButtonWrapper(
            "Fortification",
            50 + 4 * (10 + 140), 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeFortificationWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.FORTIFICATION;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                showFortificationButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeFortificationWrapper.getButton());

        ButtonWrapper buttonModeCliffWrapper = new ButtonWrapper(
            "Cliff",
            50 + 5 * (10 + 140), 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeCliffWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.CLIFF;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                hideMiscButtonPanel();
                hideNewMapPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeCliffWrapper.getButton());


        ButtonWrapper buttonModeMiscWrapper = new ButtonWrapper(
            "Miscellaneous",
            50 + 6 * (10 + 140), 80, 140, 40);
        //EditMapScreen that = this;
        buttonModeMiscWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                that.mode = EditMapMode.MISC;
                that.modeLabel.setText("Edit Mode : " + that.mode.toString());
                hideTerrainButtonPanel();
                hideFortificationButtonPanel();
                hideRoadButtonPanel();
                hideRiverButtonPanel();
                showMiscButtonPanel();
                that.editMapService.setRoadStartHex(null);
                that.editMapService.setRiverStartHex(null);
                that.editMapService.setCliffStartHex(null);
                that.editMapService.setCliffDrawFlag(DrawFlagCategory.EMPTY);

                redrawMap();
            }
        });
        stage.addActor(buttonModeMiscWrapper.getButton());



        terrainButtonPanel = createTerrainButtonPanel();
        fortificationButtonPanel = createFortificationButtonPanel();
        roadButtonPanel = createRoadButtonPanel();
        riverButtonPanel = createRiverButtonPanel();
        miscButtonPanel = createMiscButtonPanel();

        terrainButtonPanel.setVisible(false); // Initially hidden
        fortificationButtonPanel.setVisible(false);
        roadButtonPanel.setVisible(false);
        riverButtonPanel.setVisible(false);
        miscButtonPanel.setVisible(false);

        // TODO : déplacer ??
        this.newMapPanel = createNewMapPanel();
        this.newMapPanel.setVisible(false);
        //panel.add(newMapPanel);
        stage.addActor(newMapPanel);

        drawingMapPixmap = new Pixmap((int) editMapService.getMapWidth(),(int) editMapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(GraphicUtil.backgroundColorMedium);
        drawingMapPixmap.fill();
        editMapService.drawMap(drawingMapPixmap, mode);
        drawingTexture = new Texture(drawingMapPixmap);
    }

    private void subscribeToObservables() {
        if (toastObservable != null) {
            // Création d'un Observer<Toast> anonyme
            toastObservable.subscribe(new ToastObserver() {
                @Override
                public void update(Toast newValue) {
                    EditMapScreen.this.displayToastFromObservable(newValue);
                }
            });
        }
    }

    public void displayToastFromObservable(Toast toast){
        toast.show(this.stage, 2f);
    }

    private void redrawMap() {
        // Dispose of the old texture and pixmap
        if (drawingTexture != null) drawingTexture.dispose();
        if (drawingMapPixmap != null) drawingMapPixmap.dispose();

        // Create a new pixmap
        drawingMapPixmap = new Pixmap((int) editMapService.getMapWidth(),(int) editMapService.getMapHeight(), Pixmap.Format.RGBA8888);
        drawingMapPixmap.setColor(GraphicUtil.backgroundColorMedium);
        drawingMapPixmap.fill();

        // Redraw the map to the pixmap
        editMapService.drawMap(drawingMapPixmap, mode);

        // Create a new texture from the pixmap
        drawingTexture = new Texture(drawingMapPixmap);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //redrawMap();

        batch.begin();
        batch.draw(drawingTexture, editMapService.getMapX(), editMapService.getMapY());
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        font.dispose();
        batch.dispose();
        drawingMapPixmap.dispose();
        drawingTexture.dispose();
        //skin.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        //this.mapService.firstInit();
        //this.mapService.init();
        //this.redrawMap();
    }

    @Override
    public void show() {
        //Gdx.input.setInputProcessor(this);
        //InputMultiplexer im = new InputMultiplexer();
        // first let the stage see the event (so buttons, text‐fields, etc. work)
        //im.addProcessor(stage);
        // then send it to your screen for map‐editing logic
        //im.addProcessor(this);
        //Gdx.input.setInputProcessor(im);

        Gdx.input.setInputProcessor(inputMultiplexer);
        // Toujours s'assurer que le multiplexeur est actif
    }

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    private Table createTerrainButtonPanel() {
        Table panel = new Table();
        // Ajouter l'image de la texture
        Texture terrainTexture = GraphicUtil.getTextureFromTerrain(this.selectedTerrain);
        Image terrainImage = new Image(terrainTexture);
        terrainImage.setSize(64, 64);
        panel.defaults().pad(7);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedTerrainLabel = new Label("Selected Terrain : " + this.selectedTerrain.toString(), labelStyle);
        //this.selectedTerrainLabel.setPosition(50, 150);
         // Add some padding around the buttons
        panel.add(this.selectedTerrainLabel).colspan(7);
        panel.row();
        // Define the terrain types (you can load these from a file or configuration)
        HexagonCategory[] terrainTypes = {HexagonCategory.FOREST,
        HexagonCategory.GRASS,
        HexagonCategory.SAND,
        HexagonCategory.SWAMP,
        HexagonCategory.WATER,
        HexagonCategory.CITY_LIGHT,
        HexagonCategory.CITY_DENSE};
        EditMapScreen that = this;
        // Create buttons for each terrain type
        Skin buttonSkin = SkinUtil.getButtonSkin(80, 30);

        for (HexagonCategory terrainType : terrainTypes) {
            TextButton button = new TextButton(terrainType.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    // Handle the terrain selection
                    //System.out.println("Selected terrain: " + terrainType.toString());
                    // You would likely set a "selectedTerrain" variable here
                    // and use it in the touchDown method to apply the terrain.
                    selectedTerrain = terrainType;
                    selectedTerrainLabel.setText("Selected Terrain : " + terrainType.toString());
                    // ajouter update affichage miniature du selectedTerrain
                    terrainImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromTerrain(that.selectedTerrain))));
                }
            });
            panel.add(button);
        }
        panel.row(); // New row for each button (for vertical layout)

        // Ajouter l'image de la texture
        /*
        Texture terrainTexture = GraphicUtil.getTextureFromTerrain(this.selectedTerrain);
        Image terrainImage = new Image(terrainTexture);
        terrainImage.setSize(90, 30);*/
        panel.add(terrainImage).colspan(7).width(64).height(64);
        panel.row();


        // Position the panel in the bottom-right corner
        panel.setPosition(Gdx.graphics.getWidth() - 420f, 80f);
        return panel;
    }

    private Table createFortificationButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);

        //Texture fortificationTexture = GraphicUtil.getTextureFromFortification(this.selectedFortification);
        Image fortificationImage = new Image();
        fortificationImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedFortificationLabel = new Label("Selected Fortification : " + selectedFortification.toString(), labelStyle);
        panel.add(this.selectedFortificationLabel).colspan(5);
        panel.row();

        FortificationCategory[] fortificationTypes = {
            FortificationCategory.NO_FORTIFICATION,
            FortificationCategory.WOOD_LIGHT,
            FortificationCategory.WOOD_MEDIUM,
            FortificationCategory.CONCRETE_LIGHT,
            FortificationCategory.CONCRETE_MEDIUM,
            FortificationCategory.CONCRETE_HEAVY
        };
        EditMapScreen that = this;
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);
        int count = 1;
        for (FortificationCategory fortificationType : fortificationTypes) {
            TextButton button = new TextButton(fortificationType.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //System.out.println("Selected fortification : " + fortificationType.toString());
                    selectedFortification = fortificationType;
                    selectedFortificationLabel.setText("Selected Fortification : " + fortificationType.toString());
                    fortificationImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromFortification(selectedFortification))));
                }
            });
            panel.add(button);
            if(count == 3) panel.row();
            count++;

        }

        panel.row();
        panel.add(fortificationImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createRoadButtonPanel() {
        Table panel = new Table();
        panel.defaults().pad(5);

        Image roadImage = new Image();
        roadImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        this.selectedRoadLabel = new Label("Selected Road : " + selectedRoad.toString(), labelStyle);
        panel.add(this.selectedRoadLabel).colspan(5);
        panel.row();

        RoadCategory[] roadCategories = {
            RoadCategory.NO_ROAD,
            RoadCategory.PATHWAY,
            RoadCategory.ROADWAY,
            RoadCategory.RAILWAY
        };
        EditMapScreen that = this;
        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);

        for (RoadCategory roadCategory : roadCategories) {
            TextButton button = new TextButton(roadCategory.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("Selected road : " + roadCategory.toString());
                    selectedRoad = roadCategory;
                    selectedRoadLabel.setText("Selected Road : " + roadCategory.toString());
                    roadImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromRoadForButton(32, 32, 3, selectedRoad))));
                }
            });
            panel.add(button);
        }
        panel.row();
        panel.add(roadImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createRiverButtonPanel() {
        //EditMapScreen that = this;
        Table panel = new Table();
        panel.defaults().pad(5);

        Image riverImage = new Image();
        riverImage.setSize(32, 32);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        selectedRiverLabel = new Label("Selected River : " + selectedRiver.toString(), labelStyle);
        panel.add(this.selectedRiverLabel).colspan(5);
        panel.row();

        RiverCategory[] riverCategories = {
            RiverCategory.NO_RIVER,
            RiverCategory.NARROW,
            RiverCategory.MEDIUM,
            RiverCategory.WIDE
        };

        Skin buttonSkin = SkinUtil.getButtonSkin(160, 30);

        for (RiverCategory riverCategory : riverCategories) {
            TextButton button = new TextButton(riverCategory.toString(), buttonSkin);

            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {

                    selectedRiver = riverCategory;
                    System.out.println("Selected river : " + riverCategory.toString());
                    //System.out.println("is selectedRiverLabel exists ? : " + (selectedRiverLabel != null));
                    selectedRiverLabel.setText("Selected River : " + riverCategory.toString()); // TODO : marche pas !!!!!!
                    riverImage.setDrawable(new TextureRegionDrawable(new TextureRegion(GraphicUtil.getTextureFromRiverForButton(32, 32, selectedRiver))));
                }
            });
            panel.add(button);
        }

        panel.row();

        panel.add(riverImage).colspan(5).width(32).height(32);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 80f);
        return panel;
    }

    private Table createMiscButtonPanel() {
        EditMapScreen that = this;
        Table panel = new Table();
        panel.defaults().pad(5);


        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);
        Label miscLabel = new Label("Miscellaneous :", labelStyle);
        panel.add(miscLabel).colspan(5);
        panel.row();


        Skin buttonSkin = SkinUtil.getButtonSkin(100, 30);
        TextButton buttonReset = new TextButton("Reset Map", buttonSkin);
        /*
        buttonReset.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic reset");
                editMapService.resetMap();
                redrawMap();
                Toast.showToast(that.stage, "Map reset", ColorStyleEnum.SUCCESS, 2f);
            }
        });
        */

        buttonReset.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                editMapService.resetMap();
                redrawMap();
                Toast.showToast(that.stage, "Map reset", ColorStyleEnum.SUCCESS, 2f);
            }
        });
        panel.add(buttonReset);

        TextButton buttonSave = new TextButton("Save Map", buttonSkin);
        buttonSave.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic save");
                mapFileService.openSaveMapFileChooser();
                redrawMap();
            }
        });
        panel.add(buttonSave);

        TextButton buttonLoad = new TextButton("Load Map", buttonSkin);
        buttonLoad.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic load");
                mapFileService.openLoadMapFileChooser();

                redrawMap();
            }
        });
        panel.add(buttonLoad);

        TextButton buttonGenBridge = new TextButton("Add Bridge(s)", buttonSkin);
        buttonGenBridge.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic load");
                //mapFileService.openLoadMapFileChooser();
                editMapService.generateBridgesFromRiversAndRoads();
                redrawMap();
                Toast.showToast(that.stage, "Brigde(s) generated", ColorStyleEnum.SUCCESS, 2f);
            }
        });
        panel.add(buttonGenBridge);

        TextButton buttonNewMap = new TextButton("New map", buttonSkin);
        buttonNewMap.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //System.out.println("clic load");
                //mapFileService.openLoadMapFileChooser();
                //editMapService.generateBridgesFromRiversAndRoads();
                //redrawMap();
                //Toast.showToast(that.stage, "Brigde(s) generated", ColorStyleEnum.SUCCESS, 2f);
                //that.newMapPanel.setVisible(true);
                that.showNewMapPanel();
            }
        });
        panel.add(buttonNewMap);

        panel.row();
        //this.newMapPanel = createNewMapPanel();
        //this.newMapPanel.setVisible(false);
        //panel.add(newMapPanel);

        //panel.row();
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 100f);
        return panel;
    }

    private Table createNewMapPanel() {
        EditMapScreen that = this;
        Table panel = new Table();
        panel.columnDefaults(3);
        //panel.defaults().center();
        //panel.pad(20);
        // Champ de texte pour la taille X (entiers uniquement)
        this.sizeXField = new TextField("", SkinUtil.getTextFieldSkin(150, 30)); // Utilisez votre skin
        sizeXField.setTextFieldFilter(new TextField.TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                return Character.isDigit(c); // Accepte uniquement les chiffres
            }
        });
        this.sizeXField.setMessageText("" + this.editMapService.getLimitI());

        panel.add(sizeXField);

        this.sizeYField = new TextField("", SkinUtil.getTextFieldSkin(150, 30)); // Utilisez votre skin
        sizeYField.setTextFieldFilter(new TextField.TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                return Character.isDigit(c); // Accepte uniquement les chiffres
            }
        });
        sizeYField.setMessageText("" + this.editMapService.getLimitJ());
        panel.add(sizeYField);

        TextButton validateNewMapButton = new TextButton("Validate", SkinUtil.getButtonSkin(80, 30));

        validateNewMapButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int newWidth = Integer.parseInt(sizeXField.getText());
                int newHeight = Integer.parseInt(sizeYField.getText());
                newWidth = newWidth >= 50 ? Math.min(newWidth, 200) : 50;
                newHeight = newHeight >= 50 ? Math.min(newHeight, 200) : 50;
                System.out.println("width : " + newWidth + " / height : " + newHeight);
                that.editMapService.setLimits(newWidth, newHeight);
                that.editMapService.init();
                that.editMapService.resetMap();
                that.redrawMap();
                //that.newMapPanel.setVisible(false);
                that.hideNewMapPanel();
                Toast.showToast(that.stage, "New map", ColorStyleEnum.SUCCESS, 2f);
            }
        });
        panel.add(validateNewMapButton);
        panel.row();
        //panel.setBounds(Gdx.graphics.getWidth() - 380f, 50f, 200f, 40f);
        panel.setPosition(Gdx.graphics.getWidth() - 380f, 50f);

        return panel;
    }

    private void showTerrainButtonPanel() {
        if (terrainButtonPanel.getParent() == null) {
            stage.addActor(terrainButtonPanel);
        }
        terrainButtonPanel.setVisible(true);
    }

    private void hideTerrainButtonPanel() {
        terrainButtonPanel.setVisible(false);
    }

    private void showFortificationButtonPanel() {
        if (fortificationButtonPanel.getParent() == null) {
            stage.addActor(fortificationButtonPanel);
        }
        fortificationButtonPanel.setVisible(true);
    }

    private void hideFortificationButtonPanel() {
        fortificationButtonPanel.setVisible(false);
    }

    private void showRoadButtonPanel() {
        if (roadButtonPanel.getParent() == null) {
            stage.addActor(roadButtonPanel);
        }
        roadButtonPanel.setVisible(true);
    }

    private void hideRoadButtonPanel() {
        roadButtonPanel.setVisible(false);
        this.editMapService.setRoadDrawFlag(DrawFlagCategory.EMPTY);

    }

    private void showRiverButtonPanel() {
        if (riverButtonPanel.getParent() == null) {
            stage.addActor(riverButtonPanel);
        }
        riverButtonPanel.setVisible(true);
    }

    private void hideRiverButtonPanel() {
        riverButtonPanel.setVisible(false);
        this.editMapService.setRiverDrawFlag(DrawFlagCategory.EMPTY);

    }

    private void showMiscButtonPanel() {
        if (miscButtonPanel.getParent() == null) {
            stage.addActor(miscButtonPanel);
        }
        miscButtonPanel.setVisible(true);
    }

    private void hideMiscButtonPanel() {
        miscButtonPanel.setVisible(false);
    }

    private void showNewMapPanel() {
        //newMapPanel
        if (newMapPanel.getParent() == null) {
            stage.addActor(newMapPanel);
        }
        newMapPanel.setVisible(true);
    }

    private void hideNewMapPanel() {
        newMapPanel.setVisible(false);
    }

    private static class EditMapScreenInputAdapter extends InputAdapter {
        private final EditMapScreen screen; // Référence à votre écran pour accéder à ses membres

        public EditMapScreenInputAdapter(EditMapScreen screen) {
            this.screen = screen;
        }

        // copier gestion des evenements
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            // Convertir les coordonnées de l'écran en coordonnées du monde
            //Vector3 worldCoords = this.screen.stage.getCamera().unproject(new Vector3(screenX, screenY, 0));

            // Vérifier si le clic est dans la zone de la carte
            float mapX = this.screen.editMapService.getMapX();
            float mapY = this.screen.editMapService.getMapY();
            float mapWidth = this.screen.editMapService.getMapWidth();
            float mapHeight = this.screen.editMapService.getMapHeight();
            int margin = this.screen.editMapService.getMargin();
            int hexagonSize = this.screen.editMapService.getHexagonSize();
            int gapY = this.screen.editMapService.getGapY();

            //System.out.println("worldCoords.x : " + worldCoords.x + " / worldCoords.y : " + worldCoords.y);
            //System.out.println("screenX : " + screenX + " / screenY : " + screenY);

            int x = (int) (screenX - mapX - margin);
            int y = (int) (screenY - mapX - margin); // 45

            int i = this.screen.editMapService.getIFromXY(x, y);
            int j = this.screen.editMapService.getJFromY(y);
            //System.out.println("x : " + x + " / y : " + y);

            // tester si miniMap visible et clic dans minimap
            if(this.screen.isMiniMapVisible) {
                if( x > this.screen.editMapService.getMiniMapX()
                    && x < this.screen.editMapService.getMiniMapX() + this.screen.editMapService.getMiniMapWidth() - 2 * this.screen.editMapService.getMiniMapMargin()
                    && y > this.screen.editMapService.getMiniMapY()
                    && y < this.screen.editMapService.getMiniMapY() + this.screen.editMapService.getMiniMapHeight() - 2 * this.screen.editMapService.getMiniMapMargin())
                {
                    screen.stage.setKeyboardFocus(null);
                    //System.out.println("clic in minimap");
                    this.screen.editMapService.updateMiniMap(x, y, this.screen.drawingMapPixmap);
                    //mapService.showMiniMap(drawingMapPixmap);
                    //drawingTexture.draw(drawingMapPixmap, 0, 0);
                    this.screen.redrawMap();
                    this.screen.editMapService.showMiniMap(this.screen.drawingMapPixmap);
                    this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);

                }
            }
            else if (x >= 0 && x <= mapWidth - margin &&
                y >= 0 && y <= mapHeight - margin) {
                //System.out.println("clic in !!");
                screen.stage.setKeyboardFocus(null);
                if(this.screen.mode == EditMapMode.NO_ACTION) {
                    //int i = mapService.getIFromXY(x, y);
                    //int j = mapService.getJFromY(y);
                    //int i = (int) x / mapService.getGapX();
                    //System.out.println("i : " + i);

                    if(i >= 0 && i < this.screen.editMapService.getMaxI() && j >= 0 && j < this.screen.editMapService.getMaxJ()) {
                        //Hexagon clickedHexagon = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + editMapService.getStartJ());
                        //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                        this.screen.editMapService.renderHex( i + this.screen.editMapService.getStartI(), j + this.screen.editMapService.getStartJ(), GraphicUtil.redTexture, this.screen.drawingMapPixmap);
                        this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);
                    }

                    Hexagon[] neighbours = MapUtil.getNeighborhoodHexes(
                        i,
                        j,
                        this.screen.editMapService.getStartI(),
                        this.screen.editMapService.getStartJ(),
                        this.screen.editMapService.getLimitI(),
                        this.screen.editMapService.getLimitJ(),
                        this.screen.editMapService.getHexesArray()
                    );
                    for(int k=0; k<6; k++) {
                        if(neighbours[k] != null) {
                            int ii = neighbours[k].getX();
                            int jj = neighbours[k].getY();
                            if (ii - this.screen.editMapService.getStartI() >= 0 &&
                                ii - this.screen.editMapService.getStartI() < this.screen.editMapService.getMaxI() &&
                                jj - this.screen.editMapService.getStartJ() >= 0 &&
                                jj - this.screen.editMapService.getStartJ() < this.screen.editMapService.getMaxJ()
                            ) {
                                this.screen.editMapService.renderHex( ii, jj, GraphicUtil.orangeTexture, this.screen.drawingMapPixmap);
                                this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);
                            }

                        }
                    }
                }
                else if(this.screen.mode == EditMapMode.TERRAIN) {
                    //int i = mapService.getIFromXY(x, y);
                    //int j = mapService.getJFromY(y);
                    //int i = (int) x / mapService.getGapX();
                    //System.out.println("i : " + i);

                    //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                    if(this.screen.editMapService.isClickInMap(i, j)) {
                        if(this.screen.editMapService.getHexesArray().get(i+ this.screen.editMapService.getStartI()).get(j+ this.screen.editMapService.getStartJ()).getCategory() != this.screen.selectedTerrain) {
                            this.screen.editMapService.getHexesArray().get(i+ this.screen.editMapService.getStartI()).get(j+ this.screen.editMapService.getStartJ()).setCategory(this.screen.selectedTerrain);
                        }
                        this.screen.redrawMap();
                    }
                }
                else if(this.screen.mode == EditMapMode.FORTIFICATION) {
                    //int i = mapService.getIFromXY(x, y);
                    //int j = mapService.getJFromY(y);
                    //int i = (int) x / mapService.getGapX();
                    //System.out.println("i : " + i);
                    //if(i >= 0 && i < mapService.getMaxI() && j >= 0 && j < mapService.getMaxJ()) {
                    if(this.screen.editMapService.isClickInMap(i, j)) {
                        if(this.screen.editMapService.getHexesArray().get(i+ this.screen.editMapService.getStartI()).get(j+ this.screen.editMapService.getStartJ()).getFortification() != this.screen.selectedFortification) {
                            this.screen.editMapService.getHexesArray().get(i+ this.screen.editMapService.getStartI()).get(j+ this.screen.editMapService.getStartJ()).setFortification(this.screen.selectedFortification);
                        }
                        this.screen.redrawMap();
                    }
                }
                else if(this.screen.mode == EditMapMode.ROAD) {
                    this.screen.redrawMap();
                    //int i = mapService.getIFromXY(x, y);
                    //int j = mapService.getJFromY(y);
                    //Hexagon clickedHexagon = null; // TODO transformer en variable globale : roadStartHex
                    //Hexagon[] neighboursForRoad = null; // TODO transformer en variable globale : roadStartHexNeighbours
                    if(i >= 0 && i < this.screen.editMapService.getMaxI() && j >= 0 && j < this.screen.editMapService.getMaxJ()) {

                        //System.out.println("hex terrain : " + clickedHexagon.getCategory());
                        if(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                            //System.out.println("old roadDrawFlag : " + roadDrawFlag.toString());

                            if(this.screen.editMapService.getRoadDrawFlag() == DrawFlagCategory.EMPTY || this.screen.editMapService.getRoadDrawFlag() == DrawFlagCategory.SECOND_CLICK_DONE) {
                                this.screen.editMapService.setRoadStartHex(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()));

                                this.screen.editMapService.setRoadStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));
                                this.screen.redrawMap();

                                //this.screen.roadDrawFlag = DrawFlagCategory.FIRST_CLICK_DONE;
                                this.screen.editMapService.setRoadDrawFlag(DrawFlagCategory.FIRST_CLICK_DONE);
                            }
                            else if(this.screen.editMapService.getRoadDrawFlag() == DrawFlagCategory.FIRST_CLICK_DONE && this.screen.editMapService.isInNeighboursByMode(i, j, EditMapMode.ROAD)) {
                                Hexagon startHex = this.screen.editMapService.getRoadStartHex();
                                Hexagon endHex = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ());
                                // -> set les routes pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                                int k = this.screen.editMapService.getKFromRoadNeighbours(endHex);
                                this.screen.editMapService.setRoadForHexes(startHex, endHex, this.screen.selectedRoad, k);
                                this.screen.editMapService.setRoadStartHex(endHex);
                                this.screen.editMapService.setRoadStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));

                                this.screen.redrawMap();
                                //this.screen.roadDrawFlag = DrawFlagCategory.SECOND_CLICK_DONE;
                                this.screen.editMapService.setRoadDrawFlag(DrawFlagCategory.SECOND_CLICK_DONE);
                            }
                            //System.out.println("new roadDrawFlag : " + roadDrawFlag.toString());
                        }
                        else {
                            this.screen.editMapService.setRoadStartHex(null);
                            this.screen.redrawMap();
                        }
                    }
                    // TODO prévoir bouton pour raz et set roadDrawFlag à "EMPTY" et vider roadStartHex et le tableau des voisins et redessiner la carte
                }
                else if(this.screen.mode == EditMapMode.RIVER) {
                    //System.out.println("clic mode river");
                    this.screen.redrawMap();
                    if(i >= 0 && i < this.screen.editMapService.getMaxI() && j >= 0 && j < this.screen.editMapService.getMaxJ()) {
                        //System.out.println("clic mode river indices ok");

                        if(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                            //System.out.println("clic mode river indices ok pas water");

                            if(this.screen.editMapService.getRiverDrawFlag() == DrawFlagCategory.EMPTY || this.screen.editMapService.getRiverDrawFlag() == DrawFlagCategory.SECOND_CLICK_DONE) {
                                //System.out.println("old river flag : " + riverDrawFlag.toString());

                                this.screen.editMapService.setRiverStartHex(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()));
                                this.screen.editMapService.setRiverStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));
                                this.screen.redrawMap();
                                //this.screen.riverDrawFlag = DrawFlagCategory.FIRST_CLICK_DONE;
                                this.screen.editMapService.setRiverDrawFlag(DrawFlagCategory.FIRST_CLICK_DONE);
                                //System.out.println("new river flag : " + riverDrawFlag.toString());

                            }
                            else if(this.screen.editMapService.getRiverDrawFlag() == DrawFlagCategory.FIRST_CLICK_DONE && this.screen.editMapService.isInNeighboursByMode(i, j, EditMapMode.RIVER)) {
                                //System.out.println("old river flag : " + riverDrawFlag.toString());
                                Hexagon startHex = this.screen.editMapService.getRiverStartHex();
                                Hexagon endHex = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ());
                                // -> set les rivers pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                                int k = this.screen.editMapService.getKFromRiverNeighbours(endHex);
                                this.screen.editMapService.setRiverForHexes(startHex, endHex, this.screen.selectedRiver, k);
                                this.screen.editMapService.setRiverStartHex(endHex);
                                this.screen.editMapService.setRiverStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));

                                this.screen.redrawMap();
                                //this.screen.riverDrawFlag = DrawFlagCategory.SECOND_CLICK_DONE;
                                this.screen.editMapService.setRiverDrawFlag(DrawFlagCategory.SECOND_CLICK_DONE);
                                //System.out.println("new river flag : " + riverDrawFlag.toString());

                            }
                        }
                        else {
                            this.screen.editMapService.setRiverStartHex(null);
                            this.screen.redrawMap();
                        }
                    }
                }
                else if(this.screen.mode == EditMapMode.CLIFF) {
                    this.screen.redrawMap();
                    if(i >= 0 && i < this.screen.editMapService.getMaxI() && j >= 0 && j < this.screen.editMapService.getMaxJ()) {
                        //System.out.println("click in map for add cliff");
                        if(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()).getCategory() != HexagonCategory.WATER) {
                            if(this.screen.editMapService.getCliffDrawFlag() == DrawFlagCategory.EMPTY || this.screen.editMapService.getCliffDrawFlag() == DrawFlagCategory.SECOND_CLICK_DONE) {
                                this.screen.editMapService.setCliffStartHex(this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ()));
                                this.screen.editMapService.setCliffStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));
                                this.screen.redrawMap();
                                //this.screen.cliffDrawFlag = DrawFlagCategory.FIRST_CLICK_DONE;
                                this.screen.editMapService.setCliffDrawFlag(DrawFlagCategory.FIRST_CLICK_DONE);
                            }
                            else if(this.screen.editMapService.getCliffDrawFlag() == DrawFlagCategory.FIRST_CLICK_DONE && this.screen.editMapService.isInNeighboursByMode(i, j, EditMapMode.CLIFF)) {
                                Hexagon startHex = this.screen.editMapService.getCliffStartHex();
                                Hexagon endHex = this.screen.editMapService.getHexesArray().get(i + this.screen.editMapService.getStartI()).get(j + this.screen.editMapService.getStartJ());
                                // -> set les rivers pour les deux hex en fonction du roadStartHex, du selectedRoad et de k
                                int k = this.screen.editMapService.getKFromCliffNeighbours(endHex);
                                //this.screen.editMapService.setRiverForHexes(startHex, endHex, this.screen.selectedRiver, k);
                                startHex.getCliffs()[k].setCliff(!startHex.getCliffs()[k].isCliff());
                                this.screen.editMapService.setCliffStartHex(endHex);
                                this.screen.editMapService.setCliffStartHexNeighbours(MapUtil.getNeighborhoodHexes(
                                    i,
                                    j,
                                    this.screen.editMapService.getStartI(),
                                    this.screen.editMapService.getStartJ(),
                                    this.screen.editMapService.getLimitI(),
                                    this.screen.editMapService.getLimitJ(),
                                    this.screen.editMapService.getHexesArray()
                                ));

                                this.screen.redrawMap();
                                //this.screen.cliffDrawFlag = DrawFlagCategory.SECOND_CLICK_DONE;
                                this.screen.editMapService.setCliffDrawFlag(DrawFlagCategory.SECOND_CLICK_DONE);
                            }

                        }
                        else {
                            this.screen.editMapService.setCliffStartHex(null);
                            this.screen.redrawMap();
                        }

                    }
                }

                return true; // Indique que l'événement a été traité
            }
            // Si le clic n'est pas sur la carte, déléguer à Stage
            //return this.screen.stage.touchDown(screenX, screenY, pointer, button);
            return false;
        }

        /*
        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return false;
        }
        */

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return this.screen.stage.touchUp(screenX, screenY, pointer, button);
        }

        /*
        @Override
        public boolean touchCancelled(int i, int i1, int i2, int i3) {
            return false;
        }

         */

        @Override
        public boolean keyDown(int keycode) {
            int delta = 2;
            //System.out.println("keycode : " + keycode);
            switch (keycode) {
                case Input.Keys.LEFT:
                    if(!this.screen.isMiniMapVisible) {
                        this.screen.editMapService.setStartI(this.screen.editMapService.getStartI() + delta);
                        this.screen.redrawMap();
                    }

                    break;
                case Input.Keys.RIGHT:
                    if(!this.screen.isMiniMapVisible) {
                        this.screen.editMapService.setStartI(this.screen.editMapService.getStartI() - delta);
                        this.screen.redrawMap();
                    }
                    break;
                case Input.Keys.UP:
                    if(!this.screen.isMiniMapVisible) {
                        this.screen.editMapService.setStartJ(this.screen.editMapService.getStartJ() + delta);
                        this.screen.redrawMap();
                    }
                    break;
                case Input.Keys.DOWN:
                    if(!this.screen.isMiniMapVisible) {
                        this.screen.editMapService.setStartJ(this.screen.editMapService.getStartJ() - delta);
                        this.screen.redrawMap();
                    }
                    break;
                case 74: // 'm/M'
                    this.screen.isMiniMapVisible = !this.screen.isMiniMapVisible;
                    //System.out.println("isMiniMapVisible : " + this.isMiniMapVisible);
                    if(this.screen.isMiniMapVisible) {
                        //System.out.println("Showing miniMap");
                        this.screen.editMapService.showMiniMap(this.screen.drawingMapPixmap);
                        this.screen.drawingTexture.draw(this.screen.drawingMapPixmap, 0, 0);
                    }
                    else {
                        this.screen.redrawMap();
                    }
                    break;

                case 157: //Input.Keys.PLUS
                    //System.out.println("+ key");
                    switch (this.screen.editMapService.getZoomLevel()) {
                        case CLOSE_VIEW :
                            break;
                        case NORMAL_VIEW:
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.CLOSE_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                    }
                    break;
                case 156: //Input.Keys.MINUS
                    //System.out.println("- key");
                    switch (this.screen.editMapService.getZoomLevel()) {
                        case CLOSE_VIEW :
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.NORMAL_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case NORMAL_VIEW:
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.DISTANT_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case DISTANT_VIEW:
                            this.screen.editMapService.setZoomLevel(ZoomLevelEnum.VERY_DISTANT_VIEW);
                            this.screen.editMapService.initMapFromZoom();
                            this.screen.redrawMap();
                            break;
                        case VERY_DISTANT_VIEW:
                            break;
                    }
                    break;
                default:
                    return false;
                    //System.out.println("Autre touche appuyée");
            }
            return true; // Retourne true pour indiquer que l'événement a été traité
        }

        /*
        @Override
        public boolean keyUp(int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(float amountX, float amountY) {
            return false;
        }*/
    }

}
