package com.mycompany.test01.Common;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;

import java.util.Objects;

public class DesktopArmyRootFileChooserListener implements FileChooserListenerInterface {

    //private MapService mapService;
    //private MapFileService mapFileService;
    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;

    public DesktopArmyRootFileChooserListener() {
        //mapService = MapService.getInstance();
        //mapFileService = MapFileService.getInstance();
        //unitGroupObservable = new UnitGroupObservable();
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();

        armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            // TODO mettre un try/catch avec gestion du catch ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            UnitGroup rootGroup = armyFileService.loadArmyData(file.path());
            armyFileService.setRootLoaded(rootGroup);
            //GraphicUtil.printGroup(rootGroup);
            unitRootGroupObservable.setObserved(rootGroup);
            unitRootGroupObservable.notifyObservers();
        }
        else if(Objects.equals(mode, "SAVE")) {
            armyFileService.saveArmyRootData(file.path());
        }

    }

    @Override
    public void cancellation() {

    }
}
