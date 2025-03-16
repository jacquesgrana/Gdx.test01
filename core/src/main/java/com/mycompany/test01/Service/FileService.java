package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.mycompany.test01.Common.DesktopMapFileChooser;
import com.mycompany.test01.Common.DesktopMapFileChooserlistener;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Interface.FileChooser;
//import games.spooky.gdx.nativefilechooser.NativeFileChooser;

public class FileService {
    private static FileService instance = null;

    public static final String GAME_DATA_FILE_PATH = "game_data/";
    public static final String MAP_FILE_PATH = GAME_DATA_FILE_PATH + "maps/";
    private final Json json;
    private final FileChooser fileChooser;
    //NativeFileChooser fileChooser;

    public FileService() {
        json = new Json();
        //NativeFileChooser fileChooser = new NativeFileChooser();
        fileChooser = new DesktopMapFileChooser(); // Utilisez une implémentation spécifique à la plateforme
    }

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public void openLoadFileChooser() {
        checkOrInitDirs();
        DesktopMapFileChooserlistener fileChooserlistener = new DesktopMapFileChooserlistener();
        fileChooser.openLoadFileChooser(fileChooserlistener, MAP_FILE_PATH);
    }

    public void openSaveFileChooser() {
        checkOrInitDirs();
        DesktopMapFileChooserlistener fileChooserlistener = new DesktopMapFileChooserlistener();
        fileChooser.openSaveFileChooser(fileChooserlistener, MAP_FILE_PATH);
    }

    private void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle mapDir = Gdx.files.local(MAP_FILE_PATH);
        if(!mapDir.exists()) mapDir.mkdirs();
    }

    public void saveMapData(MapData data, String filePath) { //GameData data, String filePath
        //FileHandle file = Gdx.files.local(MAP_FILE_PATH + fileName + ".json");
        FileHandle file = Gdx.files.absolute(filePath);
        /*
        if (!file.parent().exists()) {
            file.parent().mkdirs();
        }*/
        data.setCreationDate(data.getCreationDate() == -1 ? System.currentTimeMillis() : data.getCreationDate());
        data.setModificationDate(System.currentTimeMillis());
        String jsonString = json.toJson(data);
        file.writeString(jsonString, false);
    }

    public MapData loadMapData(String filePath) { //String filePath
        //FileHandle file = Gdx.files.local(MAP_FILE_PATH + fileName + ".json");
        FileHandle file = Gdx.files.absolute(filePath);

        if (file.exists()) {
            // TODO ajouter une vérification des données !!!

            String jsonString = file.readString();
            //System.out.println("jsonString : " + jsonString);
            try {
                MapData data = json.fromJson(MapData.class, jsonString);
                System.out.println("data : " + data);
                return data;
            }
            catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }

            return null;
        }
        return null;
    }
}
