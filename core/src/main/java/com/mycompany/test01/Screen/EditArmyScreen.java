package com.mycompany.test01.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Common.ButtonWrapper;
import com.mycompany.test01.Common.UnitNode;
import com.mycompany.test01.Main;
import com.mycompany.test01.Util.GraphicUtil;


public class EditArmyScreen implements Screen, InputProcessor { //,
    final Main game;
    private Stage stage;
    private BitmapFont font;
    //private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private final Table leftPanel, centerPanel, rightPanel;
    private Tree<UnitNode, String> tree;
    //private Skin skin;

    /*
    class Node extends Tree.Node<Node, String, TextButton> {
        public Node (String text) {
            super(new TextButton(text, GraphicUtil.getButtonSkin(30,30)));
            setValue(text);
        }
    }
*/
    public EditArmyScreen(Main game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        //shapeRenderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();



        //this.skin = GraphicUtil.getButtonSkin(10, 10);
        //Tree<Label, String> tree = new Tree<>(skin);

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, com.badlogic.gdx.graphics.Color.WHITE);

        Label menuLabel = new Label("Edit Army", labelStyle);
        menuLabel.setPosition(Gdx.graphics.getWidth() / 2f - menuLabel.getWidth() / 2f,
            Gdx.graphics.getHeight() - menuLabel.getHeight() - 20);

        stage.addActor(menuLabel);

        ButtonWrapper buttonBackWrapper = new ButtonWrapper(
            "Back to Menu",
            font,
            (int) (Gdx.graphics.getWidth() / 2f - 200 / 2f),
            20, 200, 50);

        buttonBackWrapper.getButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });

        stage.addActor(buttonBackWrapper.getButton());

        this.leftPanel = createPanel(0);
        stage.addActor(leftPanel);
        this.leftPanel.setVisible(true);

        this.centerPanel = createPanel(1);
        stage.addActor(centerPanel);
        this.centerPanel.setVisible(true);

        this.rightPanel = createPanel(2);
        stage.addActor(rightPanel);
        this.rightPanel.setVisible(true);

        /*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(50, 50, 200, 150);
        shapeRenderer.end();*/

        //stage.addActor(shapeRenderer);

        /*
        this.skin = new Skin();
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
        */
        //this.skin = GraphicUtil.getUnitTreeSkin();
        this.tree = new Tree<>(GraphicUtil.getUnitTreeSkin());

        tree.setPadding(10);
        tree.setIndentSpacing(25);
        tree.setIconSpacing(5, 0);
        tree.setPosition(100, Gdx.graphics.getHeight() - 100f, 1);

        final UnitNode moo1 = new UnitNode("moo1 (add to moo2)");
        final UnitNode moo2 = new UnitNode("moo2 (moo3 to bottom)");
        final UnitNode moo3 = new UnitNode("moo3");
        final UnitNode moo4 = new UnitNode("moo4");
        final UnitNode moo5 = new UnitNode("moo5 (remove moo4)");

        tree.add(moo1);
        tree.add(moo2);
        moo2.add(moo3);
        moo3.add(moo4);
        tree.add(moo5);

        tree.expandAll();

        moo1.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println(moo1.getActor().getText() + ", " + moo1.getValue() + ", " + moo1.getValue().length());
                UnitNode node = new UnitNode("added " + moo2.getChildren().size);
                node.add(new UnitNode("1"));
                node.add(new UnitNode("2"));
                node.setExpanded(MathUtils.randomBoolean());
                moo2.insert(MathUtils.randomBoolean() ? moo2.getChildren().size : MathUtils.random(0, moo2.getChildren().size), node);
            }
        });
        moo2.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                moo2.getChildren().removeValue(moo3, true);
                moo2.getChildren().add(moo3);
                moo2.updateChildren();
            }
        });
        moo5.getActor().addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                UnitNode node = tree.findNode("moo4");
                if (node != null) node.remove();
            }
        });

        stage.addActor(tree);

    }

    private Table createPanel(int columnNumber) {
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x = spacing + columnNumber * (spacing + rectWidth);
        Table panel = new Table();
        panel.defaults().pad(3);
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(GraphicUtil.backgroundColorMedium); // Choisissez la couleur que vous voulez
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Drawable background = new TextureRegionDrawable(new TextureRegion(texture));
        //texture.dispose();
        //panel.setPosition(x, 100f);
        panel.setBounds(x, 100f, rectWidth, rectHeight);
        panel.setBackground(background);

        return panel;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(GraphicUtil.backgroundColorDark.r,
            GraphicUtil.backgroundColorDark.g,
            GraphicUtil.backgroundColorDark.b,
            GraphicUtil.backgroundColorDark.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
        float spacing = 50f;
        float columnCount = 3f;
        float rectWidth = (Gdx.graphics.getWidth() - (columnCount + 1) * spacing) / columnCount;
        float rectHeight = Gdx.graphics.getHeight() - 150f;
        float x1 = spacing;
        float x2 = 2f * spacing + rectWidth;
        float x3 = 3f * spacing + 2f * rectWidth;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(GraphicUtil.backgroundColorMedium);
        shapeRenderer.rect(x1, 100f, rectWidth, rectHeight);
        shapeRenderer.rect(x2, 100f, rectWidth, rectHeight);
        //shapeRenderer.setColor(GraphicUtil.backgroundColorLight);
        shapeRenderer.rect(x3, 100f, rectWidth, rectHeight);
        shapeRenderer.end();
        */
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        font.dispose();
        //shapeRenderer.dispose();
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

}
