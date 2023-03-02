package lab01es03.tdd;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the step 3 CircularListImpl implementation
 */
class CircularListTest {
    private final CircularList circularList = new CircularListImpl();

    private void populateList() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
    }

    @Test
    public void testInitiallyEmptyList() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testFilteredNext() {
        populateList();
        assertEquals(Optional.of(2), this.circularList.filteredNext(x -> x > 1));
    }

    @Test
    public void testMultipleFilteredNext() {
        populateList();
        assertEquals(Optional.empty(), this.circularList.filteredNext(x -> x > 3));
        assertEquals(Optional.of(1), this.circularList.filteredNext(x -> x > 0));
        assertEquals(Optional.of(3), this.circularList.filteredNext(x -> x.equals(3)));
    }

    @Test
    public void testFilteredNextFail() {
        populateList();
        assertEquals(Optional.empty(), this.circularList.filteredNext(x -> x > 3));
    }
    @Test
    public void testFilteredNextOnEmptyList() {
        assertEquals(Optional.empty(), this.circularList.filteredNext(x -> x > 1));
    }
}