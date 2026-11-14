import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class PolymorphismLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void mathOperation() throws Exception {
        assertEquals("4\n9\n16", run(() -> MathOperation.Main.main(NO_ARGS), ""));
    }

    @Test
    public void shapes() {
        Shapes.Rectangle rectangle = new Shapes.Rectangle(2.0, 3.0);
        assertEquals(10.0, rectangle.getPerimeter(), 1e-9);
        assertEquals(6.0, rectangle.getArea(), 1e-9);
        Shapes.Circle circle = new Shapes.Circle(1.0);
        assertEquals(2 * Math.PI, circle.getPerimeter(), 1e-9);
        assertEquals(Math.PI, circle.getArea(), 1e-9);
    }

    @Test
    public void animals() throws Exception {
        assertEquals("I am Oscar and my favourite food is Whiskas\nMEEOW\nI am Rocky and my favourite food is Meat\nDJAAF",
                run(() -> Animals.Main.main(NO_ARGS), ""));
    }
}
