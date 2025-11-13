package com.mycompany.test01.Common;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

public class ScenarReinfLandUnitNode extends Tree.Node<ScenarReinfLandUnitNode, ElementInterface, Table> {

    public ScenarReinfLandUnitNode(ElementInterface unit) {
        super(createNodeActor(unit));
        setValue(unit);
    }

    private static Table createNodeActor(ElementInterface unit) {
        Table nodeContent = new Table();

        // Image de l'unité
        Image unitImage = new Image(GraphicUtil.getCounterTextureFromUnit(unit));

        // Label avec le nom
        String comment = unit.getName();
        Label infoLabel = new Label(comment, SkinUtil.getTreeNodeLabelSkin(100, 40));

        nodeContent.add(unitImage).size(40, 40).spaceRight(10);
        nodeContent.add(infoLabel).size(100, 40);
        nodeContent.setSize(160, 50);

        return nodeContent;
    }
}
