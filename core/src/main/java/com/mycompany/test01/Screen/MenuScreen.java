package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Main;
import com.mycompany.test01.Util.GraphicUtil;

public class MenuScreen implements Screen {
    private Main game;
    private Stage stage;
    private BitmapFont font;

    public MenuScreen(Main game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        LabelStyle labelStyle = new LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Game Menu", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonWrapperEditMap = new ButtonWrapper(
            "Edit Map",
            font,
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            (int) ((Gdx.graphics.getHeight() / 2f) - 25f),
            200, 50);

        buttonWrapperEditMap.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new EditMapScreen(game));
            }
        });

        stage.addActor(buttonWrapperEditMap.getButton());

        ButtonWrapper buttonWrapperEditArmy = new ButtonWrapper(
            "Edit Army",
            font,
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            (int) ((Gdx.graphics.getHeight() / 2f) - 95f),
            200, 50);

        buttonWrapperEditArmy.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new EditArmyScreen(game));
            }
        });

        stage.addActor(buttonWrapperEditArmy.getButton());
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

    // Autres méthodes de l'interface Screen (laissées vides pour simplifier)
    @Override
    public void show() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}
}


