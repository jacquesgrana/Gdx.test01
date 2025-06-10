package com.mycompany.test01.Serializer;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonWriter;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Entity.Unit.Abstract.Unit;
import com.mycompany.test01.Entity.Unit.Abstract.UnitElement;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Entity.Unit.Group.*;
import com.mycompany.test01.Interface.ElementInterface;

public class UnitElementSerializer {

    private final Json json;

    public UnitElementSerializer() {
        json = new Json();
        json.setOutputType(JsonWriter.OutputType.json); // Pour un JSON lisible, ou OutputType.minimal pour plus petit
        json.setUsePrototypes(false); // Important pour ne pas exiger de constructeurs sans arguments si les champs sont publics ou ont des setters (mais c'est une bonne pratique de les avoir)
        json.setIgnoreUnknownFields(true); // Utile si vous ajoutez des champs plus tard et lisez d'anciens fichiers JSON

        // Indique à LibGDX Json que le champ 'units' dans UnitGroup contient des éléments de type ElementInterface.
        // Cela permet à Json de rechercher l'attribut "class" pour chaque élément afin d'instancier
        // le type concret (Unit ou UnitGroup) lors de la désérialisation.
        json.setElementType(UnitGroup.class, "units", ElementInterface.class);

        // Enregistre les alias de classe pour un JSON plus concis (facultatif mais recommandé)
        // Sans cela, les noms de classe complets (avec package) seront écrits dans le JSON.

        //json.addClassTag("Unit", Unit.class);
        json.addClassTag("InfantryUnit", InfantryUnit.class);
        json.addClassTag("EngineerUnit", EngineerUnit.class);
        json.addClassTag("ArtiUnit", ArtiUnit.class);
        json.addClassTag("AntiTankUnit", AntiTankUnit.class);
        json.addClassTag("InfantryRecoCompanyUnit", InfantryRecoCompanyUnit.class);
        // TODO ajouter les autres classes concrètes
        //json.addClassTag("UnitGroup", UnitGroup.class);
        json.addClassTag("FrontGroup", FrontGroup.class);
        json.addClassTag("ArmyGroupGroup", ArmyGroupGroup.class);
        json.addClassTag("ArmyGroup", ArmyGroup.class);
        json.addClassTag("DivisionGroup", DivisionGroup.class);
        json.addClassTag("BrigadeGroup", BrigadeGroup.class);

        json.addClassTag("UnitGroup", UnitGroup.class);
        json.addClassTag("Unit", Unit.class);

        // Vous n'avez généralement pas besoin d'enregistrer des alias pour les classes abstraites/interfaces
        // si setElementType est utilisé correctement et que les types concrets ont des ClassTags ou sont écrits avec leur nom complet.
    }

    /**
     * Sérialise le UnitGroup racine dans un fichier.
     *
     * @param rootGroup Le UnitGroup racine à sérialiser.
     * @param filePath  Le chemin du fichier où sauvegarder les données (par exemple, "data/units.json").
     */
    /*
    public <T extends UnitGroup> void serialize(T rootGroup, String filePath) {
        if (rootGroup == null) {
            System.err.println("Le rootGroup à sérialiser est null.");
            return;
        }
        try {
            FileHandle file = Gdx.files.local(filePath);
            // MODIFICATION ICI:
            // Utilisez UnitGroup.class comme knownType.
            // Si rootGroup est une instance d'une sous-classe (ex: FrontGroup),
            // le champ "class" sera écrit dans le JSON.
            String jsonData = json.toJson(rootGroup, UnitGroup.class);
            //String jsonData = json.prettyPrint(rootGroup, UnitGroup.class); // si vous préférez prettyPrint

            file.writeString(jsonData, false);
            System.out.println("Sérialisation terminée vers : " + file.path());
        } catch (Exception e) {
            System.err.println("Erreur lors de la sérialisation :");
            e.printStackTrace();
        }
    }
*/

    public <T extends UnitGroup> String serialize(T rootGroup) {
        if (rootGroup == null) {
            Gdx.app.error("UnitElementSerializer", "Le rootGroup à sérialiser est null.");
            return null;
        }

        String jsonData;
        try {
            // Utilisez UnitGroup.class comme knownType.
            // Si rootGroup est une instance d'une sous-classe (ex: FrontGroup),
            // le champ "class" sera écrit dans le JSON.
            jsonData = json.toJson(rootGroup, UnitGroup.class);
            // Si vous préférez un JSON formaté pour la lisibilité (plus lourd) :
            // jsonData = json.prettyPrint(rootGroup, UnitGroup.class);

        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Erreur lors de la conversion de l'objet en JSON.", e);
            return null; // Retourne null si la sérialisation elle-même échoue
        }

        // Appel de la méthode pour sauvegarder la chaîne JSON dans un fichier
        // Vous pourriez vérifier le succès de la sauvegarde ici si saveJsonStringToFile retournait un booléen
        //saveJsonStringToFile(jsonData, filePath);

        return jsonData; // Retourne la chaîne JSON
    }

    /**
     * Sauvegarde une chaîne de caractères (typiquement JSON) dans un fichier spécifié.
     * Cette méthode peut être rendue statique et/ou déplacée dans une classe utilitaire de gestion de fichiers.
     *
     * @param jsonString La chaîne JSON à sauvegarder.
     * @param filePath   Le chemin du fichier où sauvegarder les données.
     */
    public void saveJsonStringToFile(String jsonString, String filePath) {
        if (jsonString == null) {
            Gdx.app.error("UnitElementSerializer", "La chaîne JSON à sauvegarder est null. Sauvegarde annulée pour : " + filePath);
            return;
        }
        if (filePath == null || filePath.trim().isEmpty()) {
            Gdx.app.error("UnitElementSerializer", "Le chemin du fichier pour la sauvegarde est null ou vide. Sauvegarde annulée.");
            return;
        }

        try {
            FileHandle file = Gdx.files.local(filePath);
            file.writeString(jsonString, false); // 'false' pour écraser le fichier s'il existe
            Gdx.app.log("UnitElementSerializer", "Données JSON sauvegardées avec succès vers : " + file.path());
        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Erreur lors de la sauvegarde des données JSON dans le fichier : " + filePath, e);
            // Vous pourriez choisir de lancer une exception ici si l'appelant doit gérer l'échec.
        }
    }

    /**
     * Charge le contenu d'un fichier en tant que chaîne de caractères.
     *
     * @param filePath Le chemin du fichier à lire.
     * @return Le contenu du fichier sous forme de String, ou null si le fichier n'existe pas,
     *         est vide, ou si une erreur de lecture survient.
     */
    public String loadJsonStringFromFile(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            Gdx.app.error("UnitElementSerializer", "Le chemin du fichier pour le chargement est null ou vide.");
            return null;
        }

        FileHandle file = Gdx.files.local(filePath);
        if (!file.exists()) {
            Gdx.app.error("UnitElementSerializer", "Fichier non trouvé pour le chargement : " + filePath);
            return null;
        }

        String jsonData = null;
        try {
            jsonData = file.readString();
            if (jsonData == null || jsonData.isEmpty()) {
                Gdx.app.error("UnitElementSerializer", "Les données du fichier sont null ou vides : " + filePath);
                return null; // Retourne null si le fichier est vide
            }
        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Erreur durant la lecture du fichier : " + filePath, e);
            return null; // Retourne null en cas d'erreur de lecture
        }
        Gdx.app.log("UnitElementSerializer", "Données JSON chargées avec succès depuis : " + filePath);
        return jsonData;
    }

    /**
     * Désérialise un UnitGroup à partir d'une chaîne de données JSON.
     *
     * @param jsonData La chaîne de données JSON à désérialiser.
     * @return Le UnitGroup racine désérialisé, ou null en cas d'erreur ou si les données JSON sont invalides.
     */
    public UnitGroup deserialize(String jsonData) {
        if (jsonData == null || jsonData.isEmpty()) {
            Gdx.app.error("UnitElementSerializer", "Les données JSON à désérialiser sont null ou vides.");
            return null;
        }

        UnitGroup rootGroup = null;
        try {
            // Désérialisez en tant que UnitGroup. LibGDX Json utilisera
            // le champ "class" dans le JSON pour instancier le type concret.
            rootGroup = json.fromJson(UnitGroup.class, jsonData);
        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Erreur durant la désérialisation des données JSON.", e);
            return null;
        }

        if (rootGroup != null) {
            // 1. Réinitialiser le compteur statique UnitElement.unitCounter
            //    en trouvant l'ID le plus élevé dans les données désérialisées.
            int maxId = findMaxId(rootGroup, -1); // Commence la recherche avec -1
            UnitElement.setUnitCounter(maxId + 1);
            Gdx.app.log("UnitElementSerializer", "UnitCounter réinitialisé à : " + UnitElement.getUnitCounter());

            // 2. Reconstruire les références parentes.
            rebuildParentReferences(rootGroup, null);
            Gdx.app.log("UnitElementSerializer", "Références parentes reconstruites pour les données désérialisées.");
        }
        return rootGroup;
    }


    /**
     * Parcourt l'arborescence des éléments pour trouver l'ID le plus élevé.
     * Utile pour réinitialiser le compteur statique UnitElement.unitCounter.
     */

    private int findMaxId(ElementInterface element, int currentMaxId) {
        if (element == null) return currentMaxId;

        int maxId = Math.max(currentMaxId, element.getId());

        if (element instanceof UnitGroup) {
            UnitGroup group = (UnitGroup) element;
            if (group.getUnits() != null) {
                for (ElementInterface child : group.getUnits()) {
                    maxId = findMaxId(child, maxId);
                }
            }
        }
        return maxId;
    }

    /**
     * Parcourt l'arborescence et réaffecte les références parentes.
     * Principalement utile si les références parentes ne sont pas correctement
     * gérées par le sérialiseur par défaut ou si elles ont été marquées comme transitoires.
     */

    private void rebuildParentReferences(ElementInterface element, UnitGroup parent) {
        if (element == null) return;

        element.setParent(parent); // Définit le parent de l'élément actuel

        if (element instanceof UnitGroup) {
            UnitGroup group = (UnitGroup) element;
            if (group.getUnits() != null) {
                for (ElementInterface child : group.getUnits()) {
                    rebuildParentReferences(child, group); // Appel récursif pour les enfants
                }
            }
        }
    }
}
