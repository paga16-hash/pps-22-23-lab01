package lab01es02.tdd;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the step 2 CircularListIteratorImpl implementation
 */
class CircularListTest {
    private final CircularList circularList = new CircularListIteratorImpl();

    @Test
    public void testElementsInsertion() {
        populateList();
        assertEquals(3, this.circularList.size());
    }

    private void populateList() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
    }

    @Test
    public void testInitiallyEmptyList(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testForwardIterator() {
        populateList();
        Iterator<Integer> iterator = this.circularList.forwardIterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }

    @Test
    public void testBackwardIterator() {
        populateList();
        Iterator<Integer> iterator = this.circularList.backwardIterator();
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
    }

    @Test
    public void testEmptyBackwardAndForwardIterator() {
        Iterator<Integer> backwardIterator = this.circularList.backwardIterator();
        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();
        assertThrows(NoSuchElementException.class, backwardIterator::next);
        assertThrows(NoSuchElementException.class, forwardIterator::next);
    }
}