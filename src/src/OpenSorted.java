import java.util.Comparator;
import java.util.TreeSet;

public class OpenSorted implements Open {

    private TreeSet<State> list;

    public OpenSorted() {
        list = new TreeSet<>(Comparator.comparing(state -> state.getHeuristicValue()));
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
        return list.pollFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public State getFirst() {
        return list.first();
    }
}
