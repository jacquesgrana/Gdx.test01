package com.mycompany.test01.Common;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mycompany.test01.Util.SkinUtil;

public class ButtonWrapper {
    private final TextButton button;
    public ButtonWrapper(String text, BitmapFont font, int posX, int posY, int width, int height) {
        this.button = new TextButton(text, SkinUtil.getButtonSkin(width, height));
        button.setPosition( posX, posY);
    }

    public TextButton getButton() {
        return button;
    }
}
