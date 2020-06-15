package designpattern.observer;

import java.util.Vector;

public abstract class Subject {
    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void delObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifySetvers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
