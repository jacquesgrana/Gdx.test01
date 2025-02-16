package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GraphicUtil {


    public static Texture grassTexture = loadTexture("texture/texture-grass.png");
    public static Texture forestTexture = loadTexture("texture/texture-forest.png");
    public static Texture sandTexture = loadTexture("texture/texture-sand.png");
    public static Texture swampTexture = loadTexture("texture/texture-swamp.png");
    public static Texture redTexture = loadTexture("texture/texture-red.png");
    public static Texture orangeTexture = loadTexture("texture/texture-orange.png");

    /**
     * Creates a Texture from an image file located in the assets' folder.
     *
     * @param filePath The path to the image file within the assets' folder.
     *                 For example, "textures/grass.png".
     * @return A Texture object if the file was found and loaded successfully,
     *         or null if there was an error (e.g., file not found).
     */
    public static Texture loadTexture(String filePath) {
        try {
            Texture texture = new Texture(Gdx.files.internal(filePath));
            return texture;
        } catch (Exception e) {
            System.err.println("Error loading texture from file: " + filePath);
            e.printStackTrace();  // Print the stack trace for debugging
            return null;
        }
    }
}
