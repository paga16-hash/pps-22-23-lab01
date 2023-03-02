package lab01es03.tdd;
import java.util.*;
import java.util.function.Predicate;

public class CircularListImpl implements CircularList {

    private final lab01es01.tdd.CircularList circularList = new lab01es01.tdd.CircularListImpl();
    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        for (int i = 0; i < circularList.size(); i++) {
            Optional<Integer> current = circularList.next();
            if(current.isPresent() && condition.test(current.get())){
                return current;
            }
        }
        return Optional.empty();
    }
}
