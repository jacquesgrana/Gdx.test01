package com.mycompany.test01.Observable;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Entity.Unit.Abstract.UnitGroup;
import com.mycompany.test01.Interface.observer.Observable;
import com.mycompany.test01.Interface.observer.Observer;

public class UnitReinfGroupObservable implements Observable<UnitGroup> {

    private static UnitReinfGroupObservable instance = null;

    private Array<Observer<UnitGroup>> observers = new Array<>();
    private UnitGroup observed;


    public static UnitReinfGroupObservable getInstance() {
        if (instance == null) {
            instance = new UnitReinfGroupObservable();
        }
        return instance;
    }

    private UnitReinfGroupObservable() {
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
        for (Observer<UnitGroup> observer : observers) {
            observer.update(this.observed);
        }
    }

    @Override
    public void setObserved(UnitGroup observed) {
        this.observed = observed;
        //this.notify();
    }
}
