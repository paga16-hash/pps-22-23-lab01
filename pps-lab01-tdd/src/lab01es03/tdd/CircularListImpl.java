package lab01es03.tdd;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
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
    public Optional<Collection<Integer>> filteredNext(Predicate<? super Object> condition) {
        Collection<Integer> unmodifiableCollection = this.list.stream().filter(condition).collect(Collectors.toUnmodifiableList());
        return unmodifiableCollection.size() == 0 ?  Optional.of(unmodifiableCollection) : Optional.empty();
    }

}
