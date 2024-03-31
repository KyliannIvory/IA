package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {

    private StateComparator stateComparator;

    public Sorter(){
        stateComparator = new StateComparator();
    }

    public int findGoodIndex(ArrayList<State> list, State stateToAdd){
        int index = Collections.binarySearch(list,stateToAdd,stateComparator);
        if(index < 0){
            index = -(index + 1);
        }
        return index;
    }

    private class StateComparator implements Comparator<State> {
        @Override
        public int compare(State s1, State s2) {
            return Integer.compare(s1.getHeuristicValue(), s2.getHeuristicValue());
        }
    }
}
