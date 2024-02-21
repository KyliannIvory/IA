import java.util.LinkedList;

public class OpenStack implements Open {

    private LinkedList<State> list;

    public OpenStack() {
        list = new LinkedList<>();
    }

    @Override
    public void add(State state) {
        if(!list.contains(state))
            list.addFirst(state);
    }

    @Override
    public boolean contains(State state) {
        for(State s : list){
            if (s.equals(state))
                return true;
        }
        return false;
    }

    @Override
    public State remove() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public State getFirst() {
        return list.peek();
    }
}
