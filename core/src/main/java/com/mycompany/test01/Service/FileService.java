package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.mycompany.test01.Entity.DesktopFileChooser;
import com.mycompany.test01.Entity.DesktopMapFileChooserlistener;
import com.mycompany.test01.Entity.MapData;
import com.mycompany.test01.Interface.FileChooser;
import com.mycompany.test01.Interface.FileChooserListener;

import javax.swing.JFileChooser;
import java.io.File;
//import games.spooky.gdx.nativefilechooser.NativeFileChooser;

public class FileService {
    private static FileService instance = null;

    private static final String GAME_DATA_FILE_PATH = "game_data/";
    private static final String MAP_FILE_PATH = GAME_DATA_FILE_PATH + "maps/";
    private final Json json;
    private final FileChooser fileChooser;
    //NativeFileChooser fileChooser;

    public FileService() {
        json = new Json();
        //NativeFileChooser fileChooser = new NativeFileChooser();
        fileChooser = new DesktopFileChooser(); // Utilisez une implémentation spécifique à la plateforme
    }

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public void openLoadFileChooser() {
        DesktopMapFileChooserlistener fileChooserlistener = new DesktopMapFileChooserlistener();
        fileChooser.openLoadFileChooser(fileChooserlistener);
    }

    public void openSaveFileChooser() {
        DesktopMapFileChooserlistener fileChooserlistener = new DesktopMapFileChooserlistener();
        fileChooser.openSaveFileChooser(fileChooserlistener);
    }

    public void saveMapData(MapData data, String filePath) { //GameData data,
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

    public MapData loadMapData(String filePath) {
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
