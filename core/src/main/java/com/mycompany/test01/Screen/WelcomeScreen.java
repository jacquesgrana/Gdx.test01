package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Main;
import com.mycompany.test01.Util.GraphicUtil;

public class WelcomeScreen implements Screen {
    final Main game;
    final Stage stage;
    final BitmapFont font;

    public WelcomeScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.font = new BitmapFont();

        ButtonWrapper buttonWrapper = new ButtonWrapper(
            "Menu",
            font,
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            (int) (Gdx.graphics.getHeight() / 2f - 50 / 2f + 20f),
            200, 50);
        buttonWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(buttonWrapper.getButton());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
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
