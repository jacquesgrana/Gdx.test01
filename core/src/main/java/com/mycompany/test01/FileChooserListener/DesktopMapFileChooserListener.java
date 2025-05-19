package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Service.MapFileService;
import com.mycompany.test01.Service.MapService;

import java.util.Objects;

public class DesktopMapFileChooserListener implements FileChooserListenerInterface {

    private MapService mapService;
    private MapFileService mapFileService;

    public DesktopMapFileChooserListener() {
        mapService = MapService.getInstance();
        mapFileService = MapFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        //System.out.println("test !! : file name : " + file.name());
        //System.out.println("test !! : file path : " + file.path());
        //System.out.println("mode : " + mode);
        if(Objects.equals(mode, "LOAD")) {
            MapData mapData = mapFileService.loadMapData(file.path()); // TODO modifier la méthode du service
            //MapData mapData = fileService.loadMapData(file.path()); // TODO modifier la méthode du service

            mapService.SetMapData(mapData);
            //mapService.drawMap();
        }
        else if(Objects.equals(mode, "SAVE")) {
            MapData mapData = mapService.getMapData();
            mapFileService.saveMapData(mapData, file.path());
            //fileService.saveMapData(mapData, file.path());

        }

    }

    @Override
    public void cancellation() {

    }
}
