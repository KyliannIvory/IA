package main;

import java.util.Comparator;
import java.util.TreeSet;

public class MyListSorted implements MyList{

    private TreeSet<State> list;


    public MyListSorted(){
        list = new TreeSet<>(Comparator.comparing(state -> state.getHeuristicValue()));
    }
    @Override
    public void add(State state) {
        if(!contains(state))
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
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void print() {
        System.out.println(this + "\n\n");
    }

    @Override
    public State remove() {
        return list.pollFirst();
    }

    @Override
    public State getFirst() {
        return list.first();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        boolean first = true;
        for (State state : list) {
            if (!first) {
                sb.append(" ; ");
            }
            sb.append(state);
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }
}
