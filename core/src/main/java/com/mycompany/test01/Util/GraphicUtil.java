package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Enum.FortificationCategory;
import com.mycompany.test01.Enum.HexagonCategory;
import com.mycompany.test01.Enum.RiverCategory;
import com.mycompany.test01.Enum.RoadCategory;

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
        skin.add("button", new Texture(pixmap));
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
        textButtonStyle.up = skin.newDrawable("button", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("button", GraphicUtil.buttonHoverColorMedium);
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
}
