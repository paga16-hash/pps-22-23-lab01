package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int position = 0;

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
    public Optional<Integer> next() {
        if(position == this.size()) {
            position = 0;
        }
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(position++));
    }

    @Override
    public Optional<Integer> previous() {
        if(position == -1) {
            position = this.size() - 1;
        }
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(position--));
    }

    @Override
    public void reset() {
        this.position = 0;
    }
}
