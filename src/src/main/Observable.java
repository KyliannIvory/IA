package main;

public interface Observable {

    void addObserver(Observer observer);
    void notifyAllObserver();
}
