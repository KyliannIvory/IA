package tests;
import main.Bucket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestBucket {

    @Test
    void testIsFull() {
        Bucket bucket1 = new Bucket(4,4);
        boolean result1 = bucket1.isFull();
        assertTrue(result1,"Le seau devrait être plein");

        Bucket bucket2 = new Bucket(4,2);
        boolean result2 = bucket2.isFull();
        assertFalse(result2,"Le seau ne devrait pas etre plein");
    }

    @Test
    void testIsEmpty() {
        Bucket bucket1 = new Bucket(4,0);
        boolean result1 = bucket1.isEmpty();
        assertTrue(result1,"Le seau devrait être vide");

        Bucket bucket2 = new Bucket(4,2);
        boolean result2 = bucket2.isEmpty();
        assertFalse(result2,"Le seau ne devrait pas etre vide");
    }

    @Test
    void testFill() {
        Bucket bucket1 = new Bucket(4,0);
        bucket1.fill();
        assertEquals(4,bucket1.getCurrentQuantity());

        Bucket bucket2 = new Bucket(34,7);
        bucket2.fill();
        assertEquals(34,bucket2.getCurrentQuantity());
    }

    @Test
    void testEmpty() {
        Bucket bucket1 = new Bucket(4,3);
        bucket1.empty();
        assertEquals(0,bucket1.getCurrentQuantity());

        Bucket bucket2 = new Bucket(34,7);
        bucket2.empty();
        assertEquals(0,bucket2.getCurrentQuantity());

    }

    @Test
    void testTransferTo() {
        Bucket bucket1 = new Bucket(7,0);
        Bucket bucket2 = new Bucket(4,0);
        bucket1.transferTo(bucket2);
        assertEquals(0,bucket1.getCurrentQuantity());
        assertEquals(0,bucket2.getCurrentQuantity());

        bucket1.setCurrentQuantity(4);
        bucket2.setCurrentQuantity(1);
        bucket1.transferTo(bucket2);
        assertEquals(1,bucket1.getCurrentQuantity());
        assertEquals(4,bucket2.getCurrentQuantity());

        bucket2.transferTo(bucket1);
        assertEquals(5,bucket1.getCurrentQuantity());
        assertEquals(0,bucket2.getCurrentQuantity());
    }

}
