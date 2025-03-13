package com.mycompany.test01.Entity;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Util.GraphicUtil;

public class UnitNode extends Tree.Node<UnitNode, String, TextButton> {
    public UnitNode (String text) {
        super(new TextButton(text, GraphicUtil.getButtonSkin(30,30)));
        setValue(text);
    }
}
