package strategy;

import java.util.function.DoubleUnaryOperator;

public class Checkout {
    public static final DoubleUnaryOperator NO_DISCOUNT = price -> price;
    public static final DoubleUnaryOperator BLACK_FRIDAY = price -> price * 0.5;

    private DoubleUnaryOperator pricing = NO_DISCOUNT;

    // The pricing algorithm can be swapped at runtime.
    public void setPricing(DoubleUnaryOperator pricing) {
        this.pricing = pricing;
    }

    public double total(double price) {
        return pricing.applyAsDouble(price);
    }
}
