package com.mycompany.test01.FileChooserListener;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Enum.ColorStyleEnum;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Service.EditArmyService;

import java.util.Objects;

public class DesktopArmyGroupFileChooserListener implements FileChooserListenerInterface {

    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;
    private final EditArmyService editArmyService;

    public DesktopArmyGroupFileChooserListener() {
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        armyFileService = ArmyFileService.getInstance();
        editArmyService = EditArmyService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            // TODO mettre un try/catch avec gestion du catch ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            try {
                UnitGroup newGroup = armyFileService.loadArmyData(file.path());
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


                //GraphicUtil.printGroup(armyFileService.getRootToSave());

            }
            catch (Exception e) {
                e.printStackTrace();
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
