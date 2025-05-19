package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.FileChooserListener.DesktopArmyGroupFileChooserListener;
import com.mycompany.test01.FileChooserListener.DesktopArmyRootFileChooserListener;
import com.mycompany.test01.Common.DesktopFileChooser;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserInterface;
import com.mycompany.test01.Serializer.UnitElementSerializer;
//import games.spooky.gdx.nativefilechooser.NativeFileChooser;

public class ArmyFileService {
    private static ArmyFileService instance = null;

    public static final String GAME_DATA_FILE_PATH = "game_data/";
    public static final String ARMY_FILE_PATH = GAME_DATA_FILE_PATH + "armies/";
    public static final String GROUP_FILE_PATH = GAME_DATA_FILE_PATH + "groups/";
    //private final Json json;
    private final FileChooserInterface fileChooser;
    private final UnitElementSerializer unitElementSerializer;
    private final EditArmyService editArmyService;

    private UnitGroup rootToSave;
    private UnitGroup groupToSave;
    private UnitGroup rootLoaded;

    //private UnitElement selectedUnit;

    public ArmyFileService() {
        this.fileChooser = new DesktopFileChooser(); // Utilisez une implémentation spécifique à la plateforme
        this.unitElementSerializer = new UnitElementSerializer();
        this.editArmyService = EditArmyService.getInstance();
        this.rootToSave = null;
        this.groupToSave = null;
        this.rootLoaded = null;
        //this.selectedUnit = null;
    }

    public static ArmyFileService getInstance() {
        if (instance == null) {
            instance = new ArmyFileService();
        }
        return instance;
    }

    public void openLoadArmyRootFileChooser() {
        checkOrInitDirs();
        DesktopArmyRootFileChooserListener fileChooserlistener = new DesktopArmyRootFileChooserListener();
        fileChooser.openLoadFileChooser(fileChooserlistener, ARMY_FILE_PATH);
    }

    public void openSaveArmyRootFileChooser() {
        checkOrInitDirs();
        DesktopArmyRootFileChooserListener fileChooserlistener = new DesktopArmyRootFileChooserListener();
        fileChooser.openSaveFileChooser(fileChooserlistener, ARMY_FILE_PATH);
    }

    public void openLoadArmyGroupFileChooser() {
        checkOrInitDirs();
        DesktopArmyGroupFileChooserListener fileChooserlistener = new DesktopArmyGroupFileChooserListener();
        fileChooser.openLoadFileChooser(fileChooserlistener, GROUP_FILE_PATH);
    }

    public void openSaveArmyGroupFileChooser() {
        checkOrInitDirs();
        DesktopArmyGroupFileChooserListener fileChooserlistener = new DesktopArmyGroupFileChooserListener();
        fileChooser.openSaveFileChooser(fileChooserlistener, GROUP_FILE_PATH);
    }

    private void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle armyDir = Gdx.files.local(ARMY_FILE_PATH);
        if(!armyDir.exists()) armyDir.mkdirs();
        FileHandle groupDir = Gdx.files.local(GROUP_FILE_PATH);
        if(!groupDir.exists()) groupDir.mkdirs();
    }

    public void saveArmyRootData(String filePath) { //GameData data, String filePath
        //FileHandle file = Gdx.files.local(MAP_FILE_PATH + fileName + ".json");
        FileHandle file = Gdx.files.absolute(filePath);
        /*
        if (!file.parent().exists()) {
            file.parent().mkdirs();
        }*/
        //data.setCreationDate(data.getCreationDate() == -1 ? System.currentTimeMillis() : data.getCreationDate());
        //data.setModificationDate(System.currentTimeMillis());
        //String jsonString = json.toJson(data);
        String jsonString = unitElementSerializer.serialize(this.rootToSave);
        file.writeString(jsonString, false);
    }

    public void saveArmyGroupData(String filePath) {
        FileHandle file = Gdx.files.absolute(filePath);
        UnitGroup selectedGroup = (UnitGroup) editArmyService.getSelectedUnit();
        selectedGroup.setParent(null);
        String jsonString = unitElementSerializer.serialize(selectedGroup);
        file.writeString(jsonString, false);
    }

    public UnitGroup loadArmyData(String filePath) { //String filePath
        FileHandle file = Gdx.files.absolute(filePath);

        if (file.exists()) {
            // TODO ajouter une vérification des données !!!

            String jsonString = file.readString();
            try {
                UnitGroup group = unitElementSerializer.deserialize(jsonString);
                return group;
            }
            catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }

            return null;
        }
        return null;
    }

    public UnitGroup getRootToSave() {
        return rootToSave;
    }

    public void setRootToSave(UnitGroup rootToSave) {
        this.rootToSave = rootToSave;
    }

    public UnitGroup getGroupToSave() {
        return groupToSave;
    }

    public void setGroupToSave(UnitGroup groupToSave) {
        this.groupToSave = groupToSave;
    }

    public UnitGroup getRootLoaded() {
        return rootLoaded;
    }

    public void setRootLoaded(UnitGroup rootLoaded) {
        this.rootLoaded = rootLoaded;
    }

    /*
    public UnitElement getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(UnitElement selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
     */
}
