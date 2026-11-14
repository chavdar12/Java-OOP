import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class WorkingWithAbstractionLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void rhombusOfStars() throws Exception {
        assertEquals("*", run(() -> RhombusOfStars.main(NO_ARGS), "1\n"));
        assertEquals(" *\n* *\n *", run(() -> RhombusOfStars.main(NO_ARGS), "2\n"));
        assertEquals("  *\n * *\n* * *\n * *\n  *", run(() -> RhombusOfStars.main(NO_ARGS), "3\n"));
    }

    @Test
    public void pointInRectangle() throws Exception {
        assertEquals("true\ntrue\nfalse\nfalse\ntrue",
                run(() -> PointInRectangle.Main.main(NO_ARGS), "0 0 3 3\n5\n0 0\n0 1\n4 4\n5 3\n1 2\n"));
        assertEquals("true\ntrue\nfalse\nfalse",
                run(() -> PointInRectangle.Main.main(NO_ARGS), "2 -3 12 3\n4\n8 -1\n11 3\n1 1\n2 4\n"));
    }

    @Test
    public void studentSystem() throws Exception {
        assertEquals("Peter is 20 years old. Excellent student.\nMaria is 18 years old. Average student.",
                run(() -> StudentSystem.Main.main(NO_ARGS),
                        "Create Peter 20 5.50\nCreate Maria 18 4.50\nCreate George 25 3\nShow Peter\nShow Maria\nExit\n"));
        assertEquals("Teo is 19 years old. Very nice person.\nTeo is 19 years old. Very nice person.\nSam is 20 years old. Very nice person.",
                run(() -> StudentSystem.Main.main(NO_ARGS),
                        "Create Teo 19 2.00\nShow Sam\nShow Teo\nCreate Sam 20 3.00\nShow Teo\nShow Sam\nExit\n"));
    }

    @Test
    public void hotelReservation() throws Exception {
        assertEquals("804.00", run(() -> HotelReservation.Main.main(NO_ARGS), "50.25 5 Summer VIP\n"));
        assertEquals("360.00", run(() -> HotelReservation.Main.main(NO_ARGS), "40 10 Autumn SecondVisit\n"));
        assertEquals("721.20", run(() -> HotelReservation.Main.main(NO_ARGS), "120.20 2 Winter None\n"));
    }
}
