package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Interface.common.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Service.MapFileService;

import java.util.Objects;

// TODO : renommer en DesktopScenarMapFileChooserListener
public class EditScenarMapFileChooserListener implements FileChooserListenerInterface {

    private final EditScenarService editScenarService;
    private final MapFileService mapFileService;
    private final ToastObservable toastObservable;


    public EditScenarMapFileChooserListener() {
        this.editScenarService = EditScenarService.getInstance();
        this.mapFileService = MapFileService.getInstance();
        this.toastObservable = ToastObservable.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {
            MapData mapData = mapFileService.loadMapData(file.path());
            this.editScenarService.getScenario().getMap().setMapData(mapData);
            this.editScenarService.getScenario().getMap().generateBridgesFromRiversAndRoads();
            this.editScenarService.getScenario().getMap().initMap(50f, 180f, Gdx.graphics.getWidth() - 500f, Gdx.graphics.getHeight() - 230f);
            Toast toast = new Toast("Map Loaded", ColorStyleEnum.SUCCESS);
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
        }
        else if(Objects.equals(mode, "SAVE")) {
            /*
            MapData mapData = editScenarService.getMapData();
            mapFileService.saveMapData(mapData, file.path());
            Toast toast = new Toast("Map Saved", ColorStyleEnum.SUCCESS);
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
            */
        }
    }
    /*
            this.setMapWidth(Gdx.graphics.getWidth() - 500f);
        this.setMapHeight(Gdx.graphics.getHeight() - 230f);

        this.setMapX(50);
        this.setMapY(180);
     */

    @Override
    public void cancellation() {

    }
}
