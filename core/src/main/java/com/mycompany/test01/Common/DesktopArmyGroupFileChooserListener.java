package com.mycompany.test01.Common;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Unit.ArmyGroup;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.ToastObservable;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Util.GraphicUtil;

import java.util.Objects;

public class DesktopArmyGroupFileChooserListener implements FileChooserListenerInterface {

    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;
    private final ToastObservable toastObservable;

    public DesktopArmyGroupFileChooserListener() {
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        this.toastObservable = ToastObservable.getInstance();
        armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            // TODO mettre un try/catch avec gestion du catch ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            try {
                UnitGroup newGroup = armyFileService.loadArmyData(file.path());
                UnitGroup selectedGroup = (UnitGroup) armyFileService.getSelectedUnit();

                // TODO : vérifier si le level de  newGroup est inférieur à celui de selected group, sinon afficher toast DANGER avec toastObservable
                if(newGroup.getLevel() < selectedGroup.getLevel()) {
                    selectedGroup.addUnit(newGroup);
                    Toast toast = new Toast("Group Loaded", "SUCCESS");
                    this.toastObservable.setObserved(toast);
                    this.toastObservable.notifyObservers();
                }
                else {
                    Toast toast = new Toast("Bad Group Level Error", "DANGER");
                    this.toastObservable.setObserved(toast);
                    this.toastObservable.notifyObservers();
                }
                //GraphicUtil.printGroup(armyFileService.getRootToSave());
                unitRootGroupObservable.setObserved(armyFileService.getRootToSave());
                // trop cool si ca marche !!!! -> ça marche du 1e coup !! trop de la balle !!
                unitRootGroupObservable.notifyObservers();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(Objects.equals(mode, "SAVE")) {
            armyFileService.saveArmyGroupData(file.path());
            Toast toast = new Toast("File Saved", "SUCCESS");
            this.toastObservable.setObserved(toast);
            this.toastObservable.notifyObservers();
        }

    }

    @Override
    public void cancellation() {

    }
}
