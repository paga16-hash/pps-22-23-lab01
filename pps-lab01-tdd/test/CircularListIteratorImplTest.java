import lab01es02.tdd.CircularList;
import lab01es02.tdd.CircularListImpl;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListIteratorImplTest {
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
    public void testForwardIterator() {
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);

        Iterator<Integer> iterator = this.circularList.forwardIterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }

}