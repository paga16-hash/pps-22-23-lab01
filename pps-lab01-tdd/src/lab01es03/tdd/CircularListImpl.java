package lab01es03.tdd;
import java.util.*;
import java.util.function.Predicate;

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
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        for (int i = 0; i < list.size(); i++) {
            Optional<Integer> current = list.next();
            if(current.isPresent() && condition.test(current.get())) {
                return current;
            }
        }
        return Optional.empty();
    }
}
