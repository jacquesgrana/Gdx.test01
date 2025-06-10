package com.mycompany.test01.Common;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mycompany.test01.Interface.ElementInterface;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

public class UnitNode extends Tree.Node<UnitNode, ElementInterface, Table> {
    public UnitNode(ElementInterface unit) {
        super(createNodeActor(unit));
        setValue(unit);
    }

    private static Table createNodeActor(ElementInterface unit) {
        Table nodeContent = new Table();

        Image unitImage = new Image(GraphicUtil.getCounterTextureFromUnit(unit));
        Label infoLabel = new Label(
            unit.getName() + " / "
                + unit.getAcronym() + " / "
                + unit.getType().toString(),
            SkinUtil.getTreeNodeLabelSkin(310, 60)
        );

        nodeContent.add(unitImage).size(60, 60).padRight(5);
        nodeContent.add(infoLabel).expandX().fillX();
        /*
        Image groupImage = new Image(GraphicUtil.groupTreeIconUnitTexture);
        if (unit instanceof UnitGroup) {
            groupImage = new Image(GraphicUtil.groupTreeIconGroupTexture);
        }
        nodeContent.add(groupImage).size(32, 32).padLeft(10);
        */
        //nodeContent.setFillParent(true); -> marche très mal
        return nodeContent;
    }
}


/*
public class UnitNode extends Tree.Node<UnitNode, ElementInterface, TextButton> {
    public UnitNode (ElementInterface unit) {
        super(new TextButton(unit.getId() + " / "
            + unit.getName() + " / "
            + unit.getCountry().toString() + " / "
            + unit.getType().toString(), SkinUtil.getButtonSkin(30,30)));
        setValue(unit);
    }
}*/
