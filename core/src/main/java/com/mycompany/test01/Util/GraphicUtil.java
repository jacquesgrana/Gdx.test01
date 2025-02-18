package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Enum.HexagonCategory;

public class GraphicUtil {


    public static Texture grassTexture = loadTextureFromFile("texture/texture-grass.png");
    public static Texture forestTexture = loadTextureFromFile("texture/texture-forest.png");
    public static Texture sandTexture = loadTextureFromFile("texture/texture-sand.png");
    public static Texture swampTexture = loadTextureFromFile("texture/texture-swamp.png");
    public static Texture waterTexture = loadTextureFromFile("texture/texture-water.png");
    public static Texture redTexture = loadTextureFromFile("texture/texture-red.png");
    public static Texture orangeTexture = loadTextureFromFile("texture/texture-orange.png");

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
}
