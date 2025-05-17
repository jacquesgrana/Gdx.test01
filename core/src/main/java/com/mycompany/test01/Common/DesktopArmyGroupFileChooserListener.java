package com.mycompany.test01.Common;

import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Entity.Unit.ArmyGroup;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.FileChooserListenerInterface;
import com.mycompany.test01.Observable.UnitRootGroupObservable;
import com.mycompany.test01.Service.ArmyFileService;
import com.mycompany.test01.Util.GraphicUtil;

import java.util.Objects;

public class DesktopArmyGroupFileChooserListener implements FileChooserListenerInterface {

    private final ArmyFileService armyFileService;
    private final UnitRootGroupObservable unitRootGroupObservable;

    public DesktopArmyGroupFileChooserListener() {
        this.unitRootGroupObservable = UnitRootGroupObservable.getInstance();
        armyFileService = ArmyFileService.getInstance();
    }

    @Override
    public void selected(FileHandle file, String mode) {
        if(Objects.equals(mode, "LOAD")) {

            // TODO mettre un try/catch avec gestion du catch ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            try {
                UnitGroup newGroup = armyFileService.loadArmyData(file.path());
                UnitGroup selectedGroup = (UnitGroup) armyFileService.getSelectedUnit();
                selectedGroup.addUnit(newGroup);
                GraphicUtil.printGroup(armyFileService.getRootToSave());
                unitRootGroupObservable.setObserved(armyFileService.getRootToSave());
                // trop cool si ca marche !!!!
                unitRootGroupObservable.notifyObservers();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(Objects.equals(mode, "SAVE")) {
            armyFileService.saveArmyGroupData(file.path());
        }

    }

    @Override
    public void cancellation() {

    }
}
