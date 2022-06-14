package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private final Random random;

    public RandomArrayList() {
        super();
        this.random = new Random();
    }

    public T getRandomElement() {
        return this.get(random.nextInt(this.size()));
    }
}