package main;

public interface MyList {

    void add(State state);
    boolean contains(State state);
    boolean isEmpty();
    void print();
    State remove();
    State getFirst();
    String toString();
}
