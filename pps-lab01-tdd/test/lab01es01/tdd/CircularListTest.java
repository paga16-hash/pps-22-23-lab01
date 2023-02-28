package lab01es01.tdd;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final CircularList circularList = new CircularListImpl();

    @Test
    public void testElementsInsertion(){
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        assertEquals(3, this.circularList.size());
    }

    @Test
    public void testInitiallyEmptyList(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testNextOnEmptyList(){
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testNextOnSingleElementList(){
        this.circularList.add(1);
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    public void testNextWithCircularity(){
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.next();
        this.circularList.next();
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    public void testPreviousOnEmptyList(){
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    public void testPreviousOnSingleElementList(){
        this.circularList.add(1);
        assertEquals(Optional.of(1), this.circularList.previous());
    }

    @Test
    public void testPreviousWithCircularity() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.previous();
        assertEquals(Optional.of(1), this.circularList.previous());
    }

    @Test
    public void testSomePreviousAndNextWithCircularity() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.previous();
        assertEquals(Optional.of(1), this.circularList.previous());
        this.circularList.previous();
        this.circularList.next();
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    public void testReset() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        this.circularList.next();
        assertEquals(Optional.of(2), this.circularList.next());
        this.circularList.reset();
        assertEquals(Optional.of(1), this.circularList.next());
    }
}
