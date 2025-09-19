package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Interface.common.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Service.EditScenarService;
import com.mycompany.test01.Service.MapFileService;

import java.util.Objects;

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
            this.editScenarService.SetMapData(mapData);
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

    @Override
    public void cancellation() {

    }
}
