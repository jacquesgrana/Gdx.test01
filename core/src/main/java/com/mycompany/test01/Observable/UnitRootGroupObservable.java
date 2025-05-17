package com.mycompany.test01.Observable;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Unit.UnitGroup;
import com.mycompany.test01.Interface.Observable;
import com.mycompany.test01.Interface.Observer;
import com.mycompany.test01.Util.GraphicUtil;

public class UnitRootGroupObservable implements Observable<UnitGroup> {

    private static UnitRootGroupObservable instance = null;

    private Array<Observer<UnitGroup>> observers = new Array<>();
    private UnitGroup observed;


    public static UnitRootGroupObservable getInstance() {
        if (instance == null) {
            instance = new UnitRootGroupObservable();
        }
        return instance;
    }

    private UnitRootGroupObservable() {
        observers = new Array<>();
        observed = null;
    }

    @Override
    public void subscribe(Observer<UnitGroup> observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<UnitGroup> observer) {
        observers.removeValue(observer, true);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notify observable");
        GraphicUtil.printGroup(this.observed);
        //this.currentHealthData = newData;
        System.out.println("observers size : " + observers.size);
        for (Observer<UnitGroup> observer : observers) {
            observer.update(this.observed);
        }
    }

    /*
    public UnitGroup getObserved() {
        return observed;
    }
    */

    @Override
    public void setObserved(UnitGroup observed) {
        this.observed = observed;
        //this.notify();
    }
}
