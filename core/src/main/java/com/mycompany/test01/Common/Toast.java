package com.mycompany.test01.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.mycompany.test01.Util.SkinUtil;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Toast extends Table {

    public Toast(String message, String mode) {
        super(SkinUtil.getToastSkin(250, 100));
        Skin skin = SkinUtil.getToastSkin(250, 100);
        Color success = new Color(0.1f, 0.8f, 0.1f, 1f);
        Color danger = new Color(0.8f, 0.1f, 0.1f, 1f);
        Label messageLabel = new Label(message, skin, "default"); // Ou utilisez le style par défaut
        messageLabel.setAlignment(Align.center);
        messageLabel.setWrap(true); // Permet au texte de passer à la ligne
        Color labelColor = mode.equals("SUCCESS") ? success : mode.equals("DANGER") ? danger : Color.GRAY;
        messageLabel.setColor(labelColor);
        add(messageLabel).prefWidth(Gdx.graphics.getWidth()).expandX().fillX(); // Occupe 80% de la largeur, par exemple
        pack(); // Ajuste la taille au contenu
    }

    public void show(Stage stage, float duration) {
        // Positionnement initial (par exemple, en bas au centre, hors de l'écran au début)
        setPosition(stage.getWidth() / 2 - getWidth() / 2, -getHeight());
        // Séquence d'actions
        addAction(sequence(
            moveTo(getX(), 50f, 0.5f), // Apparaît en glissant vers le haut
            delay(duration),
            moveTo(getX(), -getHeight(), 0.5f), // Disparaît en glissant vers le bas
            com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor() // Se retire du stage
        ));
        stage.addActor(this);
    }

    // Méthode statique pour un usage facile
    public static void showToast(Stage stage, String message, String mode, float duration) {
        Toast toast = new Toast(message, mode);
        toast.show(stage, duration);
    }
}

// Utilisation :
// Skin mySkin = ...; // Chargez votre skin
// Stage myStage = ...;
// Toast.showToast(myStage, "Ceci est un toast !", mySkin, 3.0f);
