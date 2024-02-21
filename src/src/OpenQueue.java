import java.util.ArrayList;

public class OpenQueue implements Open {

    private ArrayList<State> list;

    public OpenQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void add(State state) {
        if(!list.contains(state))
            list.add(state);
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
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public State getFirst() {
        return list.get(0);
    }
}
