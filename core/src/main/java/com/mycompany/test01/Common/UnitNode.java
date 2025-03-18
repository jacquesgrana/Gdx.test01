package com.mycompany.test01.Common;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Util.GraphicUtil;

public class UnitNode extends Tree.Node<UnitNode, ElementInterface, TextButton> {
    public UnitNode (ElementInterface unit) {
        super(new TextButton(unit.getId() + " / " + unit.getName(), GraphicUtil.getButtonSkin(30,30)));
        setValue(unit);
    }
}
