package tests;

import main.*;
import org.junit.jupiter.api.Test;

public class TestStateGenerator {

    @Test
    void testGenerateState(){
        State state = new State(2);
        Open open = new OpenQueue();
        Close close = new Close();
        state.addBucket(new Bucket(3,0));
        state.addBucket(new Bucket(5,0));
        StateGenerator generator = new StateGenerator(new FirstHeuristic(state)); // c'est faux hinnnn
        generator.generateState(state,open,close);
        open.print();
        System.out.println();
        state = open.remove();
        close.add(state);
        generator.generateState(state,open ,close);
        open.print();
    }
}
