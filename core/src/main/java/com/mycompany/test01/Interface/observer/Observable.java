package com.mycompany.test01.Interface.observer;

public interface Observable<T> {
    public void subscribe(Observer<T> observer);
    public void unsubscribe(Observer<T> observer);
    public void notifyObservers();
    public void setObserved(T observed);
}
