package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Exception.LoadArmyFileException;
import com.mycompany.test01.Interface.common.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitReinfGroupObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Service.EditArmyService;
import com.mycompany.test01.Service.EditScenarService;

import java.util.Objects;

public class DesktopScenarArmyGroupFileChooserListener implements FileChooserListenerInterface {

    private final ArmyFileService armyFileService;
    //private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;
    //private final EditArmyService editArmyService;
    private final EditScenarService editScenarService;
    private final UnitReinfGroupObservable unitReinfGroupObservable;

    public DesktopScenarArmyGroupFileChooserListener() {
        //this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        this.unitReinfGroupObservable = UnitReinfGroupObservable.getInstance();
        this.armyFileService = ArmyFileService.getInstance();
        this.editScenarService = EditScenarService.getInstance();
        //editArmyService = EditArmyService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            try {
                UnitGroup newGroup = armyFileService.loadArmyData(file.path());
                if(newGroup.getCountry().equals(editScenarService.getSelectedOpponent().getCountry())) {
                  editScenarService.setSelectedReinfLandGroup(newGroup);
                    Toast toast = new Toast("Group Loaded", ColorStyleEnum.SUCCESS);
                    this.toastObservable.setObserved(toast);
                    this.toastObservable.notifyObservers();
                    this.unitReinfGroupObservable.setObserved(newGroup);
                    this.unitReinfGroupObservable.notifyObservers();
                }

                /*
                UnitGroup selectedGroup = (UnitGroup) editArmyService.getSelectedUnit();


                if(newGroup.getCountry().equals(selectedGroup.getCountry())) {

                    if(newGroup.getLevel() < selectedGroup.getLevel()) {
                        // trop cool si ca marche !!!! -> ça marche du 1e coup !! trop de la balle !!
                        selectedGroup.addUnit(newGroup);
                        Toast toast = new Toast("Group Loaded", ColorStyleEnum.SUCCESS);
                        this.toastObservable.setObserved(toast);
                        this.toastObservable.notifyObservers();
                        unitRootGroupObservable.setObserved(armyFileService.getRootToSave());
                        unitRootGroupObservable.notifyObservers();
                    }
                    else {
                        Toast toast = new Toast("Bad Group Level Error", ColorStyleEnum.DANGER);
                        this.toastObservable.setObserved(toast);
                        this.toastObservable.notifyObservers();
                    }
                }
                else {
                    Toast toast = new Toast("Bad Country Error", ColorStyleEnum.DANGER);
                    this.toastObservable.setObserved(toast);
                    this.toastObservable.notifyObservers();
                }

                 */
            }
            catch (LoadArmyFileException e) {
                Toast toast = new Toast("Error : " + e.getMessage(), ColorStyleEnum.DANGER);
                this.toastObservable.setObserved(toast);
                this.toastObservable.notifyObservers();
            }

        }
        else if(Objects.equals(mode, "SAVE")) {
            armyFileService.saveArmyGroupData(file.path());
            Toast toast = new Toast("File Saved", ColorStyleEnum.SUCCESS);
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
        }

    }

    @Override
    public void cancellation() {

    }
}
