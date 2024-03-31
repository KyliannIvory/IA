package main;

import java.util.ArrayList;

public class MyListSorted implements MyList{

    private ArrayList<State> list;
    private Sorter sorter;


    public MyListSorted(){
        list = new ArrayList<>();
        sorter = new Sorter();
    }
    @Override
    public void add(State state) {
        if(!contains(state)){
            int index = sorter.findGoodIndex(list,state);
            list.add(index ,state);
        }
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
        return list.remove(0);
    }

    @Override
    public State getFirst() {
        return list.get(0);
    }

    @Override
    public String toString(){
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
