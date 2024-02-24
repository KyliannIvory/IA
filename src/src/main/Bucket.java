package main;

import java.util.ArrayList;
import java.util.List;

public class Bucket implements Observable {

    private final int capacity;
    private int currentQuantity;
    private ArrayList<Observer> observerList = new ArrayList<>();

    public Bucket(int capacity, int currentQuantity) {
        this.capacity = capacity;
        if(currentQuantity > capacity)
            currentQuantity = capacity;
        this.currentQuantity = currentQuantity;
    }

    public Bucket(Bucket bucketToCopy) {
        this.capacity = bucketToCopy.capacity;
        this.currentQuantity = bucketToCopy.currentQuantity;
    }

    public boolean isFull() {
        return currentQuantity == capacity;
    }

    public boolean isEmpty() {
        return currentQuantity == 0;
    }

    public void fill() {
        if (!isFull())
            setCurrentQuantity(capacity);
        notifyAllObserver();
    }

    public void empty() {
        if (!isEmpty())
            setCurrentQuantity(0);
        notifyAllObserver();
    }

    public void transferTo(Bucket destination) {
        if ((!this.isEmpty()) && (!destination.isFull())) {
            if (this.currentQuantity <= destination.remaingCapacity()) {
                destination.setCurrentQuantity(destination.getCurrentQuantity() + this.currentQuantity);
                this.empty();
            } else {
                this.setCurrentQuantity(this.getCurrentQuantity() - destination.remaingCapacity());
                destination.fill();
            }
        }
        notifyAllObserver();
        destination.notifyAllObserver();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int remaingCapacity() {
        return capacity - currentQuantity;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyAllObserver() {
        for(Observer observer : observerList)
            observer.updateStateContent(this);
    }

}
