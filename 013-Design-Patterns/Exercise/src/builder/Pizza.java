package builder;

import java.util.ArrayList;
import java.util.List;

public final class Pizza {
    private final String size;
    private final List<String> toppings;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.toppings = List.copyOf(builder.toppings);
    }

    public static Builder builder(String size) {
        return new Builder(size);
    }

    @Override
    public String toString() {
        return size + " pizza with " + (toppings.isEmpty() ? "no toppings" : String.join(", ", toppings));
    }

    public static final class Builder {
        private final String size;
        private final List<String> toppings = new ArrayList<>();

        private Builder(String size) {
            this.size = size;
        }

        public Builder topping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
