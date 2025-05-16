package com.mycompany.test01.Serializer;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonWriter;

import com.mycompany.test01.Entity.Unit.*;
import com.mycompany.test01.Interface.ElementInterface;

import com.badlogic.gdx.utils.Json;

import java.io.StringWriter;

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
            FileHandle file = Gdx.files.local(filePath); // Utilise Gdx.files.local, .external, ou .absolute selon vos besoins
            String jsonData = json.prettyPrint(rootGroup, rootGroup.getClass().getModifiers());
            //String jsonData = json.prettyPrint(rootGroup); // prettyPrint pour la lisibilité, toJson pour la concision
            file.writeString(jsonData, false); // false pour écraser le fichier s'il existe
            System.out.println("Sérialisation terminée vers : " + file.path());
        } catch (Exception e) {
            System.err.println("Erreur lors de la sérialisation :");
            e.printStackTrace();
        }
    }
    */

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


    /**
     * Désérialise un UnitGroup à partir d'un fichier.
     *
     * @param filePath Le chemin du fichier à partir duquel charger les données (par exemple, "data/units.json").
     * @return Le UnitGroup racine désérialisé, ou null en cas d'erreur ou si le fichier n'existe pas.
     */

    /*
    public UnitGroup deserialize(String filePath) {
        FileHandle file = Gdx.files.local(filePath);
        if (!file.exists()) {
            Gdx.app.error("UnitElementSerializer", "File not found for deserialization: " + filePath);
            return null;
        }

        String jsonData = file.readString();
        if (jsonData == null || jsonData.isEmpty()) {
            Gdx.app.error("UnitElementSerializer", "File data is null or empty: " + filePath);
            return null;
        }

        UnitGroup rootGroup = null;
        try {
            // Json.fromJson va créer les instances de Unit, UnitGroup,
            // et peupler leurs champs (sauf 'parent' qui est transient).
            // Il utilisera les constructeurs sans argument publics.
            // Pour le champ 'units' dans UnitGroup, il créera une OrderedSet
            // et la remplira avec des instances de Unit ou UnitGroup basées
            // sur l'information "class" dans le JSON.
            // ***************************************************

            //rootGroup = json.fromJson(UnitGroup.class, jsonData);
            rootGroup = json.fromJson(FrontGroup.class, jsonData);
        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Error during deserialization", e);
            return null;
        }

        if (rootGroup != null) {
            // 1. Réinitialiser le compteur statique global des IDs.
            // Ceci est crucial pour que les nouvelles unités créées après le chargement
            // aient des IDs uniques et ne rentrent pas en conflit avec les IDs chargés.
            int maxId = findMaxId(rootGroup, -1); // Commence la recherche avec -1
            UnitElement.setUnitCounter(maxId + 1);
            Gdx.app.log("UnitElementSerializer", "UnitCounter reset to: " + UnitElement.getUnitCounter());

            // 2. Reconstruire les références parentes.
            // C'est ici que nous parcourons l'arbre désérialisé et définissons
            // manuellement le champ 'parent' de chaque élément.
            rebuildParentReferences(rootGroup, null);
            Gdx.app.log("UnitElementSerializer", "Parent references rebuilt for deserialized data.");
        }
        return rootGroup;
    }*/

    public UnitGroup deserialize(String filePath) {
        FileHandle file = Gdx.files.local(filePath);
        if (!file.exists()) {
            Gdx.app.error("UnitElementSerializer", "File not found for deserialization: " + filePath);
            return null;
        }

        String jsonData = file.readString();
        if (jsonData == null || jsonData.isEmpty()) {
            Gdx.app.error("UnitElementSerializer", "File data is null or empty: " + filePath);
            return null;
        }

        UnitGroup rootGroup = null;
        try {
            // MODIFICATION ICI:
            // Désérialisez en tant que UnitGroup. LibGDX Json utilisera
            // le champ "class" dans le JSON pour instancier le type concret.
            rootGroup = json.fromJson(UnitGroup.class, jsonData);
        } catch (Exception e) {
            Gdx.app.error("UnitElementSerializer", "Error during deserialization", e);
            return null;
        }

        if (rootGroup != null) {
            int maxId = findMaxId(rootGroup, -1);
            UnitElement.setUnitCounter(maxId + 1);
            Gdx.app.log("UnitElementSerializer", "UnitCounter reset to: " + UnitElement.getUnitCounter());

            rebuildParentReferences(rootGroup, null);
            Gdx.app.log("UnitElementSerializer", "Parent references rebuilt for deserialized data.");
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
