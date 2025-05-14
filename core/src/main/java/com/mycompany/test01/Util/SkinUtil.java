package com.mycompany.test01.Util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SkinUtil {
    public static Skin getButtonSkin(int width, int height) {
        Skin skin = new Skin();

        // Generate a default font
        BitmapFont font = new BitmapFont();
        skin.add("default-font", font);

        // Create a texture for the button background
        Pixmap pixmapUp = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapUp.setColor(GraphicUtil.buttonColorMedium);
        pixmapUp.fill();
        // Draw a 1-pixel black border
        pixmapUp.setColor(GraphicUtil.buttonBorderColorDark);
        pixmapUp.drawRectangle(0, 0, (int) pixmapUp.getWidth(), (int) pixmapUp.getHeight());
        skin.add("button-up", new Texture(pixmapUp));
        pixmapUp.dispose(); // Dispose of the Pixmap!

        Pixmap pixmapHover = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapHover.setColor(GraphicUtil.buttonHoverColorMedium);
        pixmapHover.fill();
        pixmapHover.setColor(GraphicUtil.buttonBorderColorDark); //Border Color
        pixmapHover.drawRectangle(0, 0, width, height);
        skin.add("button-hover", new Texture(pixmapHover));
        pixmapHover.dispose();

        Pixmap pixmapDown = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapDown.setColor(GraphicUtil.buttonDownColorMedium);
        pixmapDown.fill();
        pixmapDown.setColor(GraphicUtil.buttonBorderColorDark);
        pixmapDown.drawRectangle(0, 0, width, height);
        skin.add("button-down", new Texture(pixmapDown));
        pixmapDown.dispose();

        Pixmap pixmapDisabled = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmapDisabled.setColor(GraphicUtil.buttonDisabledColorMedium);
        //pixmapDisabled.setColor(Color.BLUE);
        pixmapDisabled.fill();
        pixmapDisabled.setColor(GraphicUtil.buttonBorderColorDark); //Border Color
        pixmapDisabled.drawRectangle(0, 0, width, height);
        skin.add("button-disabled", new Texture(pixmapDisabled));
        pixmapDisabled.dispose();

        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(skin.get("button-up", Texture.class)));
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(skin.get("button-hover", Texture.class)));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(skin.get("button-down", Texture.class)));
        textButtonStyle.disabled = new TextureRegionDrawable(new TextureRegion(skin.get("button-disabled", Texture.class)));
        textButtonStyle.font = skin.getFont("default-font");

        // Ajouter une couleur de texte pour l'état désactivé
        textButtonStyle.disabledFontColor = GraphicUtil.textDisabledColorMedium;

        skin.add("default", textButtonStyle);

        return skin;
    }


    public static Skin getCheckBoxSkin(int size) {
        Skin skin = new Skin();

        // Police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Fond de la case (non cochée)
        Pixmap unchecked = new Pixmap(size, size, Pixmap.Format.RGBA8888);
        unchecked.setColor(0.7f, 0.7f, 0.7f, 1f); // gris clair
        unchecked.fill();
        skin.add("checkbox-unchecked", new Texture(unchecked));
        unchecked.dispose();

        // Fond de la case (cochée)
        Pixmap checked = new Pixmap(size, size, Pixmap.Format.RGBA8888);
        checked.setColor(0.2f, 0.7f, 0.2f, 1f); // vert
        checked.fill();
        // Ajoute une croix blanche
        checked.setColor(1, 1, 1, 1);
        int margin = size / 4;
        checked.drawLine(margin, margin, size - margin, size - margin);
        checked.drawLine(margin, size - margin, size - margin, margin);
        skin.add("checkbox-checked", new Texture(checked));
        checked.dispose();

        // Style du CheckBox
        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();
        checkBoxStyle.checkboxOff = skin.newDrawable("checkbox-unchecked");
        checkBoxStyle.checkboxOn = skin.newDrawable("checkbox-checked");
        checkBoxStyle.font = skin.getFont("default");
        checkBoxStyle.fontColor = Color.WHITE;

        skin.add("default", checkBoxStyle);

        return skin;
    }


    public static Skin getTextFieldSkin(int width, int height) {
        Skin skin = new Skin();

        // Génère une police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Crée un fond pour le TextField
        Pixmap bgPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(GraphicUtil.buttonColorMedium); // à définir dans GraphicUtil
        bgPixmap.fill();
        skin.add("textfield-bg", new Texture(bgPixmap));
        bgPixmap.dispose();

        // Crée le curseur (fin trait vertical blanc)
        Pixmap cursorPixmap = new Pixmap(2, height, Pixmap.Format.RGBA8888);
        cursorPixmap.setColor(Color.WHITE);
        cursorPixmap.fill();
        skin.add("textfield-cursor", new Texture(cursorPixmap));
        cursorPixmap.dispose();

        // Crée la sélection (bleu clair semi-transparent)
        Pixmap selectionPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        selectionPixmap.setColor(0.3f, 0.5f, 1f, 0.5f);
        selectionPixmap.fill();
        skin.add("textfield-selection", new Texture(selectionPixmap));
        selectionPixmap.dispose();

        // Style du TextField
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = skin.getFont("default");
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = skin.newDrawable("textfield-bg");
        textFieldStyle.cursor = skin.newDrawable("textfield-cursor");
        textFieldStyle.selection = skin.newDrawable("textfield-selection");

        skin.add("default", textFieldStyle);

        return skin;
    }



    public static Skin getLabelSkin(int width, int height) {
        Skin skin = new Skin();

        // Génère une police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Crée un fond pour le label (optionnel, tu peux l'enlever si tu veux un fond transparent)
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium); // à définir dans GraphicUtil, par exemple Color.CLEAR ou une couleur douce
        pixmap.fill();
        skin.add("label-bg", new Texture(pixmap));
        pixmap.dispose();

        // Crée le style du label
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = skin.getFont("default");
        labelStyle.background = skin.newDrawable("label-bg"); // optionnel, retire cette ligne pour un label sans fond

        skin.add("default", labelStyle);

        return skin;
    }

    public static Skin getTreeNodeLabelSkin(int width, int height) {
        Skin skin = new Skin();

        // Génère une police par défaut
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Crée un fond pour le label (optionnel, tu peux l'enlever si tu veux un fond transparent)
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorMedium); // à définir dans GraphicUtil, par exemple Color.CLEAR ou une couleur douce
        pixmap.fill();
        skin.add("label-bg", new Texture(pixmap));
        pixmap.dispose();

        // Crée le style du label
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = skin.getFont("default");
        labelStyle.background = skin.newDrawable("label-bg"); // optionnel, retire cette ligne pour un label sans fond

        skin.add("default", labelStyle);

        return skin;
    }


    public static Skin getSelectorSkin(int width, int height) {
        Skin skin = new Skin();

        // Generate a default font
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        // Create textures for different states
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.buttonColorMedium);
        pixmap.fill();
        pixmap.setColor(GraphicUtil.buttonBorderColorDark);
        pixmap.drawRectangle(0, 0, width, height);
        skin.add("selectbox", new Texture(pixmap));

        // Create a background for the dropdown list
        Pixmap listBg = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        listBg.setColor(GraphicUtil.buttonColorMedium);
        listBg.fill();
        listBg.setColor(GraphicUtil.buttonBorderColorDark);
        listBg.drawRectangle(0, 0, width, height);
        skin.add("list-bg", new Texture(listBg));

        // Create a selection background
        Pixmap selectionBg = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        selectionBg.setColor(GraphicUtil.buttonHoverColorMedium);
        selectionBg.fill();
        skin.add("selection", new Texture(selectionBg));

        // Dispose pixmaps
        pixmap.dispose();
        listBg.dispose();
        selectionBg.dispose();

        // Create ScrollPane style (required by SelectBox)
        ScrollPane.ScrollPaneStyle scrollPaneStyle = new ScrollPane.ScrollPaneStyle();
        skin.add("default", scrollPaneStyle);

        // Create List style (required by SelectBox)
        List.ListStyle listStyle = new List.ListStyle();
        listStyle.font = skin.getFont("default");
        listStyle.selection = skin.newDrawable("selection");
        listStyle.background = skin.newDrawable("list-bg");
        skin.add("default", listStyle);

        // Create SelectBox style
        SelectBox.SelectBoxStyle selectBoxStyle = new SelectBox.SelectBoxStyle();
        selectBoxStyle.font = skin.getFont("default");
        selectBoxStyle.background = skin.newDrawable("selectbox");
        selectBoxStyle.scrollStyle = skin.get(ScrollPane.ScrollPaneStyle.class);
        selectBoxStyle.listStyle = skin.get(List.ListStyle.class);
        selectBoxStyle.background = skin.newDrawable("selectbox");
        skin.add("default", selectBoxStyle);

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
        treeStyle.selection = skin.newDrawable("white", GraphicUtil.backgroundColorLight);
        skin.add("default", treeStyle);
        return skin;
    }

    public static Skin getScrollPaneSkin(int width, int height) {
        Skin skin = new Skin();

        // Fond du ScrollPane
        Pixmap bgPixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        bgPixmap.setColor(GraphicUtil.backgroundColorMedium); // même fond que les boutons
        bgPixmap.fill();
        skin.add("scrollpane-bg", new Texture(bgPixmap));
        bgPixmap.dispose();

        // ScrollBar vertical (fond)
        int barWidth = 20;
        Pixmap vBarPixmap = new Pixmap(barWidth, height, Pixmap.Format.RGBA8888);
        // vBarPixmap.setColor(0.2f, 0.2f, 0.2f, 0.7f); // gris foncé semi-transparent TODO : utiliser une couleur de GraphicUtil
        vBarPixmap.setColor(GraphicUtil.backgroundColorLight); // gris foncé semi-transparent TODO : utiliser une couleur de GraphicUtil

        vBarPixmap.fill();
        skin.add("vscroll", new Texture(vBarPixmap));
        vBarPixmap.dispose();

        // ScrollBar vertical (knob)
        Pixmap vKnobPixmap = new Pixmap(barWidth, 32, Pixmap.Format.RGBA8888);
        //vKnobPixmap.setColor(0.7f, 0.7f, 0.7f, 1f); // gris clair
        vKnobPixmap.setColor(GraphicUtil.buttonColorMedium); // gris clair

        vKnobPixmap.fill();
        skin.add("vscroll-knob", new Texture(vKnobPixmap));
        vKnobPixmap.dispose();

        // ScrollBar horizontal (fond)
        Pixmap hBarPixmap = new Pixmap(width, barWidth, Pixmap.Format.RGBA8888);
        hBarPixmap.setColor(0.2f, 0.2f, 0.2f, 0.7f);
        hBarPixmap.fill();
        skin.add("hscroll", new Texture(hBarPixmap));
        hBarPixmap.dispose();

        // ScrollBar horizontal (knob)
        Pixmap hKnobPixmap = new Pixmap(32, barWidth, Pixmap.Format.RGBA8888);
        hKnobPixmap.setColor(0.7f, 0.7f, 0.7f, 1f);
        hKnobPixmap.fill();
        skin.add("hscroll-knob", new Texture(hKnobPixmap));
        hKnobPixmap.dispose();

        // Style du ScrollPane
        ScrollPane.ScrollPaneStyle scrollPaneStyle = new ScrollPane.ScrollPaneStyle();
        scrollPaneStyle.background = new TextureRegionDrawable(new TextureRegion(skin.get("scrollpane-bg", Texture.class)));
        scrollPaneStyle.vScroll = new TextureRegionDrawable(new TextureRegion(skin.get("vscroll", Texture.class)));
        scrollPaneStyle.vScrollKnob = new TextureRegionDrawable(new TextureRegion(skin.get("vscroll-knob", Texture.class)));
        scrollPaneStyle.hScroll = new TextureRegionDrawable(new TextureRegion(skin.get("hscroll", Texture.class)));
        scrollPaneStyle.hScrollKnob = new TextureRegionDrawable(new TextureRegion(skin.get("hscroll-knob", Texture.class)));

        skin.add("default", scrollPaneStyle);

        return skin;
    }

}
