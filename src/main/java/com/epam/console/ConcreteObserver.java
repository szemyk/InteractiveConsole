package com.epam.console;

interface ConcreteObserver {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyAllObservers();
}
