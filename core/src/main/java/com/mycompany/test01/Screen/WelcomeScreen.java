package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mycompany.test01.Main;

public class WelcomeScreen implements Screen {
    final Main game;
    final Stage stage;
    final BitmapFont font;

    public WelcomeScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.font = new BitmapFont();
        // Create a skin
        Skin skin = new Skin();
        skin.add("default-font", font);

        // Create a texture for the button background
        Pixmap pixmap = new Pixmap(200, 50, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        pixmap.setColor(Color.BLACK); //Border Color
        pixmap.drawRectangle(0, 0, 200, 50);
        skin.add("button-up", new Texture(pixmap));
        pixmap.dispose();

        Pixmap pixmapHover = new Pixmap(200, 50, Pixmap.Format.RGBA8888);
        pixmapHover.setColor(Color.CORAL);
        pixmapHover.fill();
        pixmapHover.setColor(Color.BLACK); //Border Color
        pixmapHover.drawRectangle(0, 0, 200, 50);
        skin.add("button-hover", new Texture(pixmapHover));
        pixmapHover.dispose();


        // Configure a TextButtonStyle
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("button-up", Color.WHITE); //Up state
        textButtonStyle.over = skin.newDrawable("button-hover", Color.ORANGE); //Hover State
        textButtonStyle.font = skin.getFont("default-font");
        textButtonStyle.fontColor = Color.WHITE;

        TextButton button = new TextButton("Menu", textButtonStyle);
        button.setPosition(Gdx.graphics.getWidth() / 2f - button.getWidth() / 2f,
            Gdx.graphics.getHeight() / 2f - button.getHeight() / 2f);

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(button);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    // Implement other Screen methods (pause, resume, hide, show) as empty methods
    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void show() {}
}



