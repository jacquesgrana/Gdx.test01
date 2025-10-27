package com.mycompany.test01.Common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.mycompany.test01.Interface.unit.ElementInterface;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

public class ScenarUnitNode extends Tree.Node<ScenarUnitNode, ElementInterface, Table> {

    public ScenarUnitNode(ElementInterface unit, boolean isDeployed) {
        super(createNodeActor(unit, isDeployed));
        setValue(unit);
    }

    private static Table createNodeActor(ElementInterface unit, boolean isDeployed) {
        Table nodeContent = new Table();

        // Indicateur de statut coloré
        Image statusIndicator = createStatusIndicator(isDeployed);

        // Image de l'unité
        Image unitImage = new Image(GraphicUtil.getCounterTextureFromUnit(unit));

        // Label avec le nom
        String comment = unit.getName();
        //comment += isDeployed ? " / DEP" : " / NDEP";
        Label infoLabel = new Label(comment, SkinUtil.getTreeNodeLabelSkin(120, 60));

        // Assemblage : indicateur à gauche, puis image, puis label
        nodeContent.add(statusIndicator).size(20, 20).padRight(5);
        nodeContent.add(unitImage).size(60, 60).padRight(5);
        nodeContent.add(infoLabel).size(120, 60);
        nodeContent.setSize(205, 80); // Ajusté pour inclure l'indicateur

        return nodeContent;
    }

    private static Image createStatusIndicator(boolean isDeployed) {
        // Créer un cercle coloré
        Pixmap pixmap = new Pixmap(20, 20, Pixmap.Format.RGBA8888);

        // Choisir la couleur selon le statut
        Color color = isDeployed ? GraphicUtil.colorGreen : GraphicUtil.colorOrange;
        pixmap.setColor(color);

        // Dessiner un cercle (ou un carré avec fill())
        pixmap.fillCircle(10, 10, 8);

        // Optionnel : ajouter un contour
        pixmap.setColor(Color.WHITE);
        pixmap.drawCircle(10, 10, 8);

        Texture texture = new Texture(pixmap);
        pixmap.dispose();

        return new Image(texture);
    }
}
