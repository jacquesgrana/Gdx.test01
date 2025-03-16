package com.mycompany.test01.Common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mycompany.test01.Util.GraphicUtil;

public class ButtonWrapper {
    private final TextButton button;
    public ButtonWrapper(String text, BitmapFont font, int posX, int posY, int width, int height) {
        // Create a skin
        Skin skin = new Skin();
        skin.add("default-font", font);

        // Create a texture for the button background
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium);
        pixmap.fill();
        pixmap.setColor(GraphicUtil.buttonBorderColorDark); //Border Color
        pixmap.drawRectangle(0, 0, width, height);
        skin.add("button-up", new Texture(pixmap));
        pixmap.dispose();

        Pixmap pixmapHover = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapHover.setColor(GraphicUtil.buttonHoverColorMedium);
        pixmapHover.fill();
        pixmapHover.setColor(GraphicUtil.buttonBorderColorDark); //Border Color
        pixmapHover.drawRectangle(0, 0, width, height);
        skin.add("button-hover", new Texture(pixmapHover));
        pixmapHover.dispose();

        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button-up", Color.WHITE); //Up state
        textButtonStyle.down = skin.newDrawable("button-hover", GraphicUtil.buttonHoverColorMedium);
        textButtonStyle.over = skin.newDrawable("button-hover", GraphicUtil.buttonHoverColorMedium); //Hover State

        textButtonStyle.font = skin.getFont("default-font");
        textButtonStyle.fontColor = Color.WHITE;

        this.button = new TextButton(text, textButtonStyle);
        //button.setPosition( Gdx.graphics.getWidth() / 2f - button.getWidth() / 2f,
        /*
        button.setPosition( Gdx.graphics.getWidth() / 2f - button.getWidth() / 2f,
             Gdx.graphics.getHeight() / 2f - button.getHeight() / 2f);
         */
        button.setPosition( posX, posY);
    }

    public TextButton getButton() {
        return button;
    }
}
