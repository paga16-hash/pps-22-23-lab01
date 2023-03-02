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

    private void populateList() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
    }

    @Test
    public void testElementsInsertion() {
        populateList();
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
        populateList();
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    public void testNextWithCircularity(){
        populateList();
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
        populateList();
        assertEquals(Optional.of(1), this.circularList.previous());
    }

    @Test
    public void testPreviousWithCircularity() {
        populateList();
        this.circularList.previous();
        assertEquals(Optional.of(1), this.circularList.previous());
    }

    @Test
    public void testSomePreviousAndNextWithCircularity() {
        populateList();
        this.circularList.previous();
        assertEquals(Optional.of(1), this.circularList.previous());
        this.circularList.previous();
        this.circularList.next();
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    public void testReset() {
        populateList();
        this.circularList.next();
        assertEquals(Optional.of(2), this.circularList.next());
        this.circularList.reset();
        assertEquals(Optional.of(1), this.circularList.next());
    }

}
