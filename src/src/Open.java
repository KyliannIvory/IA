public interface Open {

    void add(State state);
    boolean contains(State state);
    State remove();
    boolean isEmpty();
    State getFirst();
    void print();

}
