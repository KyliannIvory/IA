package main;
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

    @Override
    public void print() {
        System.out.println(this + "\n" + "\n");

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(" ; ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
