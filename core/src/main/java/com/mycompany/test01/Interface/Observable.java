package com.mycompany.test01.Interface;

import com.mycompany.test01.Entity.Unit.UnitGroup;

public interface Observable<T> {
    public void subscribe(Observer<T> observer);
    public void unsubscribe(Observer<T> observer);
    public void notifyObservers();
    public void setObserved(UnitGroup observed);
}
