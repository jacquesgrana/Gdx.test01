package com.mycompany.test01.Common;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;

import java.util.Objects;

public class DesktopArmyRootFileChooserListener implements FileChooserListenerInterface {
    
    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;

    public DesktopArmyRootFileChooserListener() {
        //mapService = MapService.getInstance();
        //mapFileService = MapFileService.getInstance();
        //unitGroupObservable = new UnitGroupObservable();
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        this.armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            // TODO mettre un try/catch avec gestion du catch ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            UnitGroup rootGroup = this.armyFileService.loadArmyData(file.path());
            if(rootGroup.getLevel() == 5) {
                this.armyFileService.setRootLoaded(rootGroup);
                //GraphicUtil.printGroup(rootGroup);
                this.unitRootGroupObservable.setObserved(rootGroup);
                this.unitRootGroupObservable.notifyObservers();
                Toast toast = new Toast("Root Group Loaded", ColorStyleEnum.SUCCESS);
                this.toastObservable.setObserved(toast);
                this.toastObservable.notifyObservers();
            }
            else {
                Toast toast = new Toast("Bad Root Group Level Error", ColorStyleEnum.DANGER);
                this.toastObservable.setObserved(toast);
                this.toastObservable.notifyObservers();
            }


        }
        else if(Objects.equals(mode, "SAVE")) {
            this.armyFileService.saveArmyRootData(file.path());
            Toast toast = new Toast("File Saved", ColorStyleEnum.SUCCESS);
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
        }

    }

    @Override
    public void cancellation() {

    }
}
