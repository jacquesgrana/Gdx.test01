package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Interface.common.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Util.GraphicUtil;
import com.mycompany.test01.Util.UnitUtil;

import java.util.Objects;

public class DesktopScenarArmyRootFileChooserListener implements FileChooserListenerInterface {

    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;

    public DesktopScenarArmyRootFileChooserListener() {
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        this.armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {
            try {

                UnitGroup rootGroup = this.armyFileService.loadArmyData(file.path());
                if(rootGroup.getLevel() == 5) {
                    this.armyFileService.setRootLoaded(rootGroup);
                    //UnitUtil.printGroup(rootGroup);
                    System.out.println("Root Group loaded");
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
            catch (Exception e) {
                e.printStackTrace();
                Toast toast = new Toast("Error :" + e.getMessage(), ColorStyleEnum.DANGER);
                this.toastObservable.setObserved(toast);
                this.toastObservable.notifyObservers();

            }

        }
        else if(Objects.equals(mode, "SAVE")) {
            /*
            this.armyFileService.saveArmyRootData(file.path());
            Toast toast = new Toast("File Saved", ColorStyleEnum.SUCCESS);
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
            */
        }

    }

    @Override
    public void cancellation() {

    }
}
