import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final CircularList circularList = new CircularListImpl();

    @Disabled
    @Test
    public void testTodo(){
        Assertions.fail();
    }

    @Test
    public void testElementsInsertion(){
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        assertEquals(3, this.circularList.size());
    }

    @Test
    public void testEmptyList(){
        assertTrue(this.circularList.isEmpty());
    }

}
