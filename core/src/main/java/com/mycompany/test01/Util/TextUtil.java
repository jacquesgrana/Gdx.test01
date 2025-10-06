package com.mycompany.test01.Util;

public class TextUtil {

    public static String getCleanedText(String rawValue, int fieldLength) {
        String cleanedValue = rawValue != null ?
            rawValue.trim().replaceAll("\\s+", " ") :  // Remplace les espaces multiples par un seul
            "";

        // 3. Validation
        if (cleanedValue.isEmpty()) {
            // Gestion du cas vide (optionnel: afficher un message d'erreur)
            System.err.println("Ce champs ne peut pas être vide");
            // Tu peux aussi mettre en surbrillance le champ:
            // scenarNameField.setStyle(SkinUtil.getErrorTextFieldSkin());
            return "";
        }

        // 4. Limiter la longueur (optionnel)
        //final int MAX_LENGTH = fieldLength;
        if (cleanedValue.length() > fieldLength) {
            cleanedValue = cleanedValue.substring(0, fieldLength);
            //scenarNameField.setText(cleanedValue); // Met à jour le champ
        }

        return cleanedValue;
    }
}
