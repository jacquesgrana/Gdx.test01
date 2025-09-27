package com.mycompany.test01.Observable;

import com.badlogic.gdx.utils.Array;
import com.mycompany.test01.Interface.observer.Observable;
import com.mycompany.test01.Interface.observer.Observer;

public class EditScenarLoadMapObservable implements Observable<Boolean> {
    private static EditScenarLoadMapObservable instance = null;

    private Array<Observer<Boolean>> observers = new Array<>();
    private Boolean observed;

    public static EditScenarLoadMapObservable getInstance() {
        if (instance == null) {
            instance = new EditScenarLoadMapObservable();
        }
        return instance;
    }

    private EditScenarLoadMapObservable() {
        observers = new Array<>();
        observed = false;
    }

    @Override
    public void subscribe(Observer<Boolean> observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<Boolean> observer) {
        observers.removeValue(observer, true);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Boolean> observer : observers) {
            observer.update(this.observed);
        }
    }

    @Override
    public void setObserved(Boolean observed) {
        this.observed = observed;
    }
}
