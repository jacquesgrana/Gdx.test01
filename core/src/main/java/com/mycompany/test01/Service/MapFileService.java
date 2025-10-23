package com.mycompany.test01.Service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mycompany.test01.Common.DesktopFileChooser;
import com.mycompany.test01.Config.FileConfig;
import com.mycompany.test01.Entity.Map.HexUnits;
import com.mycompany.test01.Entity.Map.Hexagon;
import com.mycompany.test01.Enum.CountryEnum;
import com.mycompany.test01.FileChooserListener.DesktopMapFileChooserListener;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Interface.common.FileChooserInterface;
import com.mycompany.test01.Util.LogUtil;

import java.util.Arrays;

public class MapFileService {
    private static MapFileService instance = null;

    //public static final String GAME_DATA_FILE_PATH = "game_data/";
    //public static final String MAP_FILE_PATH = GAME_DATA_FILE_PATH + "maps/";
    private final Json json;
    private final FileChooserInterface fileChooser;

    public MapFileService() {
        json = new Json();
        fileChooser = new DesktopFileChooser(); // Utilisez une implémentation spécifique à la plateforme
    }

    public static MapFileService getInstance() {
        if (instance == null) {
            instance = new MapFileService();
        }
        return instance;
    }

    public void openLoadMapFileChooser() {
        checkOrInitDirs();
        DesktopMapFileChooserListener fileChooserlistener = new DesktopMapFileChooserListener();
        fileChooser.openLoadFileChooser(fileChooserlistener, FileConfig.MAP_FILE_PATH);
    }

    public void openSaveMapFileChooser() {
        checkOrInitDirs();
        DesktopMapFileChooserListener fileChooserlistener = new DesktopMapFileChooserListener();
        fileChooser.openSaveFileChooser(fileChooserlistener, FileConfig.MAP_FILE_PATH);
    }

    private void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(FileConfig.GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle mapDir = Gdx.files.local(FileConfig.MAP_FILE_PATH);
        if(!mapDir.exists()) mapDir.mkdirs();
    }

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
                // TODO ajouter set du ownerCountry ? Enlever qd assez de maps ok
                data.setDataTab(this.getDataTabWithOwnerCountry(data));
                data.setDataTab(this.getDataTabWithUnits(data));

                //getDataTabWithUnits
                //System.out.println("data : " + data);
                return data;
            }
            catch (Exception e) {
                //System.out.println(e.fillInStackTrace());
                LogUtil.logError("Json deserialize error", e);
            }

            return null;
        }
        return null;
    }

    private Hexagon[][] getDataTabWithOwnerCountry(MapData data) {
        Hexagon[][] dataTab = new Hexagon[data.getLimitI()][data.getLimitJ()];

        for(int i=0; i<data.getLimitI(); i++) {
            for (int j=0; j<data.getLimitJ(); j++) {
                dataTab[i][j] = data.getDataTab()[i][j];
                if(data.getDataTab()[i][j].getOwnerCountry() == null) {
                    dataTab[i][j].setOwnerCountry(CountryEnum.NO_COUNTRY);
                }
            }
        }
        return dataTab;
    }

    private Hexagon[][] getDataTabWithUnits(MapData data) {
        Hexagon[][] dataTab = new Hexagon[data.getLimitI()][data.getLimitJ()];

        for(int i=0; i<data.getLimitI(); i++) {
            for (int j=0; j<data.getLimitJ(); j++) {
                dataTab[i][j] = data.getDataTab()[i][j];
                if(data.getDataTab()[i][j].getUnits() == null) {
                    dataTab[i][j].setUnits(new HexUnits());
                }
            }
        }
        return dataTab;
    }
}
