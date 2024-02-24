package tests;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNumberManager {

    @Test
    void testFindNumber(){
        State state = new State(3);
        state.addBucket(new Bucket(3,0));
        state.addBucket(new Bucket(5,2));
        state.addBucket(new Bucket(7,7));
        NumberManager numberManager = new NumberManager();
        numberManager.findNumber(state);
        assertEquals(1,numberManager.getNbOfEmpty(state));
        assertEquals(1,numberManager.getNbOfIntermediate(state));
        assertEquals(1,numberManager.getNbOfFull(state));
    }



}

