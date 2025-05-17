package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.mycompany.test01.Common.DesktopArmyFileChooserlistener;
import com.mycompany.test01.Common.DesktopFileChooser;
import com.mycompany.test01.Common.DesktopMapFileChooserlistener;
import com.mycompany.test01.Entity.Unit.ArmyGroup;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserInterface;
import com.mycompany.test01.Serializer.UnitElementSerializer;
//import games.spooky.gdx.nativefilechooser.NativeFileChooser;

public class ArmyFileService {
    private static ArmyFileService instance = null;

    public static final String GAME_DATA_FILE_PATH = "game_data/";
    public static final String ARMY_FILE_PATH = GAME_DATA_FILE_PATH + "armies/";
    //private final Json json;
    private final FileChooserInterface fileChooser;
    private final UnitElementSerializer unitElementSerializer;

    private UnitGroup rootToSave;
    private UnitGroup rootLoaded;

    //NativeFileChooser fileChooser;

    public ArmyFileService() {
        //json = new Json();
        //NativeFileChooser fileChooser = new NativeFileChooser();
        this.fileChooser = new DesktopFileChooser(); // Utilisez une implémentation spécifique à la plateforme
        this.unitElementSerializer = new UnitElementSerializer();
        this.rootToSave = null;
        this.rootLoaded = null;
    }

    public static ArmyFileService getInstance() {
        if (instance == null) {
            instance = new ArmyFileService();
        }
        return instance;
    }

    public void openLoadArmyFileChooser() {
        checkOrInitDirs();
        DesktopArmyFileChooserlistener fileChooserlistener = new DesktopArmyFileChooserlistener();
        fileChooser.openLoadFileChooser(fileChooserlistener, ARMY_FILE_PATH);
    }

    public void openSaveArmyFileChooser() {
        checkOrInitDirs();
        DesktopArmyFileChooserlistener fileChooserlistener = new DesktopArmyFileChooserlistener();
        fileChooser.openSaveFileChooser(fileChooserlistener, ARMY_FILE_PATH);
    }

    private void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle armyDir = Gdx.files.local(ARMY_FILE_PATH);
        if(!armyDir.exists()) armyDir.mkdirs();
    }

    public void saveArmyData(String filePath) { //GameData data, String filePath
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

    public UnitGroup loadArmyData(String filePath) { //String filePath
        //FileHandle file = Gdx.files.local(MAP_FILE_PATH + fileName + ".json");
        FileHandle file = Gdx.files.absolute(filePath);

        if (file.exists()) {
            // TODO ajouter une vérification des données !!!

            String jsonString = file.readString();
            //System.out.println("jsonString : " + jsonString);
            try {
                //MapData data = json.fromJson(MapData.class, jsonString);
                UnitGroup rootGroup = unitElementSerializer.deserialize(jsonString);
                System.out.println("rootGroup : " + rootGroup);
                //this.rootLoaded = rootGroup;
                return rootGroup;
            }
            catch (Exception e) {
                //e.printStackTrace();
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

    public UnitGroup getRootLoaded() {
        return rootLoaded;
    }

    public void setRootLoaded(UnitGroup rootLoaded) {
        this.rootLoaded = rootLoaded;
    }
}
