package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.mycompany.test01.Common.DesktopFileChooser;
import com.mycompany.test01.Config.FileConfig;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.FileChooserListener.EditScenarMapFileChooserListener;
import com.mycompany.test01.Interface.common.FileChooserInterface;
import com.mycompany.test01.Util.FileUtil;

public class ScenarFileService {
    private static ScenarFileService instance = null;

    //public static final String GAME_DATA_FILE_PATH = "game_data/";
    //public static final String MAP_FILE_PATH = GAME_DATA_FILE_PATH + "maps/";
    private final Json json;
    private final FileChooserInterface fileChooser;

    public ScenarFileService() {
        json = new Json();
        fileChooser = new DesktopFileChooser(); // Utilisez une implémentation spécifique à la plateforme
    }

    public static ScenarFileService getInstance() {
        if (instance == null) {
            instance = new ScenarFileService();
        }
        return instance;
    }

    public void openLoadMapFileChooser() {
        FileUtil.checkOrInitDirs();
        EditScenarMapFileChooserListener fileChooserlistener = new EditScenarMapFileChooserListener();
        fileChooser.openLoadFileChooser(fileChooserlistener, FileConfig.MAP_FILE_PATH);
    }

    public void openSaveMapFileChooser() {
        FileUtil.checkOrInitDirs();
        EditScenarMapFileChooserListener fileChooserlistener = new EditScenarMapFileChooserListener();
        fileChooser.openSaveFileChooser(fileChooserlistener, FileConfig.MAP_FILE_PATH);
    }

    /*
    private void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(FileConfig.GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle mapDir = Gdx.files.local(FileConfig.MAP_FILE_PATH);
        if(!mapDir.exists()) mapDir.mkdirs();
    }*/

    public void saveMapData(MapData data, String filePath) { //GameData data, String filePath
        FileHandle file = Gdx.files.absolute(filePath);
        data.setCreationDate(data.getCreationDate() == -1 ? System.currentTimeMillis() : data.getCreationDate());
        data.setModificationDate(System.currentTimeMillis());
        String jsonString = json.toJson(data);
        file.writeString(jsonString, false);
    }

    public MapData loadMapData(String filePath) { //String filePath
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
