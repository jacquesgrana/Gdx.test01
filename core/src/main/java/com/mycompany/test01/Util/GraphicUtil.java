package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Entity.Unit.Unit;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Enum.*;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Screen.EditArmyScreen;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GraphicUtil {


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

    public static Texture counterTypeIconHQTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-hq@4x.png");
    public static Texture counterTypeIconArtTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-arti@4x.png");
    public static Texture counterTypeIconInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-inf@4x.png");
    public static Texture counterTypeIconTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-tank@4x.png");
    public static Texture counterTypeIconParaTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-para@4x.png");
    public static Texture counterTypeIconAntiAirTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-anti-air@4x.png");
    public static Texture counterTypeIconAntiTankTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-anti-tank@4x.png");
    public static Texture counterTypeIconCavTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-cav@4x.png");
    public static Texture counterTypeIconEngTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-eng@4x.png");
    public static Texture counterTypeIconMarTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-mar@4x.png");
    public static Texture counterTypeIconMecaInfTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-meca-inf@4x.png");
    public static Texture counterTypeIconMecaRecoTexture = loadTextureFromFile("texture/unit/counter-type-icon/texture-unit-icon-type-meca-reco@4x.png");

    public static Texture counterAddOnReg1_4Texture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-reg-1-4@4x.png");
    public static Texture counterAddOnReg2_4Texture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-reg-2-4@4x.png");
    public static Texture counterAddOnReg3_4Texture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-reg-3-4@4x.png");
    public static Texture counterAddOnReg4_4Texture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-reg-4-4@4x.png");
    public static Texture counterAddOnCompTexture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-comp@4x.png");
    public static Texture counterAddOnMotTexture = loadTextureFromFile("texture/unit/counter-addon/counter-addon-mot@4x.png");

    public static Color backgroundColorDark = new Color(0.1f, 0.1f, 0.12f, 1);
    public static Color backgroundColorMedium = new Color(0.15f, 0.15f, 0.18f, 1);
    public static Color backgroundColorLight = new Color(0.2f, 0.2f, 0.25f, 1);

    public static Color buttonColorMedium = new Color( 0.25f, 0.25f, 0.31f, 1);
    public static Color buttonHoverColorMedium = new Color(0.85f, 0.25f, 0.25f, 1);
    public static Color buttonBorderColorDark = new Color(0.05f, 0.05f, 0.06f, 1);
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

    public static Texture getEmptyTexture() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 0); // Transparent black
        pixmap.fill();
        Texture emptyTexture = new Texture(pixmap);
        pixmap.dispose(); // Dispose of the Pixmap immediately
        return emptyTexture;
    }

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

    public static UnitNode createTreeFromGroup(UnitGroup group, Screen screen) {
        // Créer un nœud pour le groupe actuel
        UnitNode groupNode = new UnitNode(group);

        // ajouter listener
        /*
        EditArmyScreen that = (EditArmyScreen) screen;
        groupNode.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("clic group");
                that.displayUnitInfos(groupNode.getValue());
                groupNode.setExpanded(!groupNode.isExpanded());
            }
        });*/

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
                        childGroupNode.setExpanded(!childGroupNode.isExpanded());
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

            // ajouter listener
            groupNode.getActor().addListener(new ClickListener() {
                public void clicked (InputEvent event, float x, float y) {
                    //System.out.println("clic group");
                    EditArmyScreen that = (EditArmyScreen) screen;
                    that.displayUnitInfos(groupNode.getValue());
                    groupNode.setExpanded(!groupNode.isExpanded());

                }
            });
        }
        return groupNode;
    }

    public static Texture getCounterTextureFromUnit(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        Texture background = getCountryTexture(unit);
        Texture typeIcon = getUnitTypeTexture(unit);

        // choix des addons en fonction de l'unité
        Texture motorisedAddon = getMotorisedAddonTexture(unit);

        toReturn = stackTextures(background, typeIcon, motorisedAddon);

        // Ajouter le texte de l'acronyme à la texture
        String acronym = unit.getAcronym();
        toReturn = drawTextOnTexture(toReturn, acronym);
        return toReturn;
    }

    public static Texture drawTextOnTexture(Texture input, String text) {
        int width = input.getWidth(), height = input.getHeight();
        FrameBuffer fbo = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        SpriteBatch batch = new SpriteBatch();

        BitmapFont font = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-110.fnt"));
        //BitmapFont font = new BitmapFont(Gdx.files.internal("bitmapfont/RobotoCondensed-Black-16.fnt"));

        font.setColor(Color.BLACK);

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
        float y = (height + layout.height) / 2 - layout.height;
        font.draw(batch, layout, x, y); // texte centré

        batch.end();
        fbo.end();

        Texture t = fbo.getColorBufferTexture(); // ATTENTION texture retournée !
        // tu ne la disopses pas maintenant si tu t’en resserras
        font.dispose();
        batch.dispose();
        //fbo.dispose();
        return t;
    }


    public static Texture stackTextures(Texture background, Texture typeIcon, Texture motorisedAddon) {
        // Empilement des textures
        // On suppose que background, typeIcon et motorisedAddon sont de même taille
        int width = background.getWidth();
        int height = background.getHeight();

        // Copier la texture de fond dans un pixmap
        Pixmap pixmapBackground = textureToPixmap(background);
        Pixmap pixmapTypeIcon = textureToPixmap(typeIcon);
        Pixmap pixmapMotorisedAddon = textureToPixmap(motorisedAddon);

        // Vérification de la taille de pixmap pour l'icône
        int xTypeIcon = (width - pixmapTypeIcon.getWidth()) / 2;
        int yTypeIcon = (height - pixmapTypeIcon.getHeight()) / 2;

        // Empile l'icône type sur le fond
        pixmapBackground.drawPixmap(pixmapTypeIcon, xTypeIcon, yTypeIcon);

        // Vérification de la taille de pixmap pour motorisedAddon
        int xMotorisedAddon = (width - pixmapMotorisedAddon.getWidth()) / 2;
        int yMotorisedAddon = (height - pixmapMotorisedAddon.getHeight()) / 2;

        // Empile motorisedAddon sur le fond
        pixmapBackground.drawPixmap(pixmapMotorisedAddon, xMotorisedAddon, yMotorisedAddon);

        // Création de la texture résultante
        Texture toReturn = new Texture(pixmapBackground);

        // Libération de la RAM des pixmaps    pixmapBackground.dispose();
        pixmapTypeIcon.dispose();
        pixmapMotorisedAddon.dispose();

        // Renvoi du résultat
        return toReturn;
    }

    public static Texture getMotorisedAddonTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        if(unit.isMotorised()) {
            toReturn = counterAddOnMotTexture;
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
            case YELLOW_COUNTRY:
                toReturn = unit.isElite() ? counterBgYellowCountry01Texture : counterBgYellowCountry02Texture;
                break;
        }
        return toReturn;
    }

    public static Texture getUnitTypeTexture(ElementInterface unit) {
        Texture toReturn = getEmptyTexture();
        // choix de l'icon du type en fonction du type
        switch (unit.getType()) {
            case ARTI:
                toReturn = counterTypeIconArtTexture;
                break;
            case PARA:
                toReturn = counterTypeIconParaTexture;
                break;
            case TANK:
                toReturn = counterTypeIconTankTexture;
                break;
            case MARINE:
                toReturn = counterTypeIconMarTexture;
                break;
            case ENGINEER:
                toReturn = counterTypeIconEngTexture;
                break;
            case INFANTRY:
                toReturn = counterTypeIconInfTexture;
                break;
            case ANTI_AIR:
                toReturn = counterTypeIconAntiAirTexture;
                break;
            case ANTI_TANK:
                toReturn = counterTypeIconAntiTankTexture;
                break;
            case CAVALRY:
                toReturn = counterTypeIconCavTexture;
                break;
            case MECHANISED_INF:
                toReturn = counterTypeIconMecaInfTexture;
                break;
            case MECHANISED_RECO:
                toReturn = counterTypeIconMecaRecoTexture;
                break;
            case BRIGADE_HQ:
            case DIVISION_HQ:
            case ARMY_HQ:
            case ARMY_GROUP_HQ:
            case FRONT_HQ:
                toReturn = counterTypeIconHQTexture;
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
