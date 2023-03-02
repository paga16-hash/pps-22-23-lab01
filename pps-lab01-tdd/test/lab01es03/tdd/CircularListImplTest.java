package lab01es03.tdd;

import lab01es03.tdd.CircularList;
import lab01es03.tdd.CircularListImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListImplTest {
    private final CircularList circularList = new CircularListImpl();
    @Test
    public void testFilteredNext() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        assertEquals(Optional.of(2), this.circularList.filteredNext(x -> x > 1));
    }

    @Test
    public void testFilteredNextFail() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        assertEquals(Optional.empty(), this.circularList.filteredNext(x -> x > 3));
    }
}