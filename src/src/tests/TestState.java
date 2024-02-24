package tests;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestState {

    @Test
    void testAddBucket(){
        Bucket bucket1 = new Bucket(5,2);
        Bucket bucket2 = new Bucket(3,0);
        State state = new State(2);
        state.addBucket(bucket1);
        state.addBucket(bucket2);
        assertEquals(2,state.getStateContent().get(0));
        assertEquals(0,state.getStateContent().get(1));
    }


    @Test
    void testEquals(){
        Bucket bucket1 = new Bucket(5,2);
        Bucket bucket2 = new Bucket(3,0);

        State state = new State(2);
        state.addBucket(bucket1);
        state.addBucket(bucket2);

        State copy = new State(2);
        copy.addBucket(bucket1);
        copy.addBucket(bucket2);
        boolean result = copy.equals(state);
        assertTrue(result,"ils ont les meme valeur donc ils devraient etre égaux...");
    }

    @Test
    void TestCopyConstructorState(){
        Bucket bucket1 = new Bucket(5,2);
        Bucket bucket2 = new Bucket(3,0);
        State state = new State(2);
        state.addBucket(bucket1);
        state.addBucket(bucket2);

        State state1 = new State(state);
        state1.getBucketList().get(0).empty();
        state1.getBucketList().get(1).fill();
        assertNotEquals(state.getStateContent().get(0),state1.getStateContent().get(0));
        assertNotEquals(state.getStateContent().get(1),state1.getStateContent().get(1));
        state1.getBucketList().get(1).empty();
        assertEquals(state.getStateContent().get(1),state1.getStateContent().get(1));
    }
}
