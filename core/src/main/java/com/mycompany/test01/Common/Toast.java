package com.mycompany.test01.Common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.SkinUtil;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Toast extends Table {

    private String message;
    private ColorStyleEnum mode;

    /*
    public Toast(String message, String mode) {
        super(SkinUtil.getToastSkin(250, 60));
        Skin skin = SkinUtil.getToastSkin(250, 60);
        Color success = GraphicUtil.toastSuccessBackgroundColor;
        Color danger = GraphicUtil.toastDangerBackgroundColor;
        Label messageLabel = new Label(message, skin, "default"); // Ou utilisez le style par défaut
        messageLabel.setAlignment(Align.center);
        messageLabel.setWrap(true); // Permet au texte de passer à la ligne
        Color labelBackgroundColor = mode.equals("SUCCESS") ? success : mode.equals("DANGER") ? danger : Color.GRAY;
        Color textColor = GraphicUtil.toastFontColor;

       // messageLabel.setColor(labelBackgroundColor);
        add(messageLabel).prefWidth(Gdx.graphics.getWidth()).expandX().fillX(); // Gdx.graphics.getWidth()
        pack(); // Ajuste la taille au contenu
    }*/

    public Toast(String message, ColorStyleEnum mode) {
        super(SkinUtil.getToastSkin());
        Skin skin = SkinUtil.getToastSkin();
        this.message = message;
        this.mode = mode;
        // Choisir le nom du Drawable de fond basé sur le mode
        String backgroundDrawableName;
        if (ColorStyleEnum.SUCCESS.equals(this.mode)) {
            backgroundDrawableName = "toast-background-success";
        } else if (ColorStyleEnum.DANGER.equals(this.mode)) {
            backgroundDrawableName = "toast-background-danger";
        } else if (ColorStyleEnum.INFO.equals(this.mode)) {
            backgroundDrawableName = "toast-background-info";
        } else if (ColorStyleEnum.WARNING.equals(this.mode)) {
            backgroundDrawableName = "toast-background-warning";
        } else {
            backgroundDrawableName = "toast-background-default"; // Cas par défaut
        }

        // Appliquer le fond à la Table (le Toast lui-même)
        this.setBackground(skin.getDrawable(backgroundDrawableName));

        // Créer le Label en utilisant le style "default" du skin
        Label messageLabel = new Label(this.message, skin, "default");
        messageLabel.setAlignment(Align.center);
        messageLabel.setWrap(true);

        // Ajouter le label à la table (Toast) avec du padding
        // et le faire s'étendre pour remplir la largeur disponible.
        this.add(messageLabel)
            .prefWidth(Gdx.graphics.getWidth() * 1f) // Par exemple, 80% de la largeur de l'écran
            .minHeight(40f) // Une hauteur minimale pour le toast
            .padTop(10f)
            .padBottom(10f)
            //.padLeft(20f)
            //.padRight(20f)
            .expandX()
            .fillX();

        this.pack(); // Ajuste la taille de la Table (Toast) à son contenu et padding
    }

    public void show(Stage stage, float duration) {
        // Positionnement initial (par exemple, en bas au centre, hors de l'écran au début)
        setPosition(stage.getWidth() / 2 - getWidth() / 2, -getHeight());
        // Séquence d'actions
        addAction(sequence(
            moveTo(getX(), 0f, 0.5f), // Apparaît en glissant vers le haut
            delay(duration),
            moveTo(getX(), -getHeight(), 0.5f), // Disparaît en glissant vers le bas
            com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor() // Se retire du stage
        ));
        stage.addActor(this);
    }

    // Méthode statique pour un usage facile
    public static void showToast(Stage stage, String message, ColorStyleEnum mode, float duration) {
        Toast toast = new Toast(message, mode);
        toast.show(stage, duration);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ColorStyleEnum getMode() {
        return mode;
    }

    public void setMode(ColorStyleEnum mode) {
        this.mode = mode;
    }
}
