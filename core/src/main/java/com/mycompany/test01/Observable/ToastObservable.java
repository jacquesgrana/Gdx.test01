package com.mycompany.test01.Observable;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Common.Toast;
import com.mycompany.test01.Interface.Observable;
import com.mycompany.test01.Interface.Observer;

public class ToastObservable implements Observable<Toast> {

    private static ToastObservable instance = null;

    private Array<Observer<Toast>> observers = new Array<>();
    private Toast observed;


    public static ToastObservable getInstance() {
        if (instance == null) {
            instance = new ToastObservable();
        }
        return instance;
    }

    private ToastObservable() {
        observers = new Array<>();
        observed = null;
    }

    @Override
    public void subscribe(Observer<Toast> observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<Toast> observer) {
        observers.removeValue(observer, true);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notify observable");
        //this.currentHealthData = newData;
        System.out.println("observers size : " + observers.size);
        for (Observer<Toast> observer : observers) {
            observer.update(this.observed);
        }
    }

    /*
    public UnitGroup getObserved() {
        return observed;
    }
    */

    @Override
    public void setObserved(Toast observed) {
        this.observed = observed;
        //this.notify();
    }
}
