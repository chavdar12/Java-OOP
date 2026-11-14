import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class DesignPatternsExerciseTest {
    @Test
    public void factoryCreatesShapesByName() {
        assertEquals(4.0, factory.ShapeFactory.create("square", 2).area(), 1e-9);
        assertEquals(Math.PI, factory.ShapeFactory.create("circle", 1).area(), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> factory.ShapeFactory.create("hexagon", 1));
    }

    @Test
    public void builderAssemblesStepByStep() {
        assertEquals("Large pizza with cheese, ham", builder.Pizza.builder("Large").topping("cheese").topping("ham").build().toString());
        assertEquals("Small pizza with no toppings", builder.Pizza.builder("Small").build().toString());
    }

    @Test
    public void strategyCanBeSwapped() {
        strategy.Checkout checkout = new strategy.Checkout();
        assertEquals(100, checkout.total(100), 1e-9);
        checkout.setPricing(strategy.Checkout.BLACK_FRIDAY);
        assertEquals(50, checkout.total(100), 1e-9);
    }
}
