package lab01es02.tdd;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularListImpl implements CircularList {

    private final lab01es01.tdd.CircularList list = new lab01es01.tdd.CircularListImpl();
    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                //TODO Gestione caso con lista vuota
                return list.next().orElseThrow();
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                return list.previous().orElseThrow();
            }
        };
    }
}
