package com.epam.console;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for parameter using in commands.
 * To create this class, was used Singleton pattern.
 * The Singleton pattern ensures that a class has only one instance
 * and provides a global point of access to that instance.
 */

class Parameter implements ConcreteObserver {
    private List<Observer> observers = new ArrayList<Observer>();
    private String parameter = "$";
    private String path = System.getProperty("user.dir");

    String getParameter() {
        return parameter;
    }

    void setParameter(String parameter) {
        this.parameter = parameter;
        notifyAllObservers();
    }

    String getPath(){
        return path;
    }

    void setPath(String parameter){
        this.path = parameter;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
