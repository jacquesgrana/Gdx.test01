package com.mycompany.test01.Common;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Map.MapData;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.UnitGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Service.MapFileService;
import com.mycompany.test01.Service.MapService;
import com.mycompany.test01.Util.GraphicUtil;

import java.util.Objects;

public class DesktopArmyFileChooserlistener implements FileChooserListenerInterface {

    //private MapService mapService;
    //private MapFileService mapFileService;
    private ArmyFileService armyFileService;
    private UnitGroupObservable unitGroupObservable;

    public DesktopArmyFileChooserlistener() {
        //mapService = MapService.getInstance();
        //mapFileService = MapFileService.getInstance();
        //unitGroupObservable = new UnitGroupObservable();
        this.unitGroupObservable = UnitGroupObservable.getInstance();

        armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            UnitGroup rootGroup = armyFileService.loadArmyData(file.path());
            armyFileService.setRootLoaded(rootGroup);
            GraphicUtil.printGroup(rootGroup);
            unitGroupObservable.setObserved(rootGroup);
            unitGroupObservable.notifyObservers();
            // TODO utiliser observable pour appeler une méthode de EditMapScreen qui met à jour l'arbre
        }
        else if(Objects.equals(mode, "SAVE")) {
            armyFileService.saveArmyData(file.path());
        }

    }

    @Override
    public void cancellation() {

    }
}
