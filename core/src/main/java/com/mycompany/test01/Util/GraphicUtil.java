package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mycompany.test01.Enum.FortificationCategory;
import com.mycompany.test01.Enum.HexagonCategory;

public class GraphicUtil {


    public static Texture grassTexture = loadTextureFromFile("texture/terrain/texture-grass.png");
    public static Texture forestTexture = loadTextureFromFile("texture/terrain/texture-forest.png");
    public static Texture sandTexture = loadTextureFromFile("texture/terrain/texture-sand.png");
    public static Texture swampTexture = loadTextureFromFile("texture/terrain/texture-swamp.png");
    public static Texture waterTexture = loadTextureFromFile("texture/terrain/texture-water.png");
    public static Texture redTexture = loadTextureFromFile("texture/terrain/texture-red.png");
    public static Texture orangeTexture = loadTextureFromFile("texture/terrain/texture-orange.png");

    public static Texture fortifConcreteLightTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-light.png");
    public static Texture fortifConcreteMediumTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-medium.png");
    public static Texture fortifConcreteHeavyTexture = loadTextureFromFile("texture/fortification/texture-fortif-concrete-heavy.png");

    public static Texture fortifWoodLightTexture = loadTextureFromFile("texture/fortification/texture-fortif-wood-light.png");
    public static Texture fortifWoodMediumTexture = loadTextureFromFile("texture/fortification/texture-fortif-wood-medium.png");

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
            Texture texture = new Texture(Gdx.files.internal(filePath));
            return texture;
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
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        // Draw a 1-pixel black border
        pixmap.setColor(Color.BLACK);
        pixmap.drawRectangle(0, 0, (int) pixmap.getWidth(), (int) pixmap.getHeight());
        skin.add("button", new Texture(pixmap));

        pixmap.dispose(); // Dispose of the Pixmap!

        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button", Color.WHITE);
        textButtonStyle.down = skin.newDrawable("button", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default-font");
        skin.add("default", textButtonStyle);

        return skin;
    }

    public static Pixmap textureToPixmap(Texture texture) {
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        return texture.getTextureData().consumePixmap();
    }
}
