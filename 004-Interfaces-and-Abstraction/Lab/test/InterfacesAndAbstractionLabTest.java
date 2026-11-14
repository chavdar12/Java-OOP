import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class InterfacesAndAbstractionLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void carShop() throws Exception {
        assertEquals("Leon is gray color and have 110 horse power\nThis is Leon produced in Spain and have 4 tires",
                run(() -> CarShop.Main.main(NO_ARGS), ""));
    }

    @Test
    public void carShopExtended() throws Exception {
        assertEquals("Leon is Gray color and have 110 horse power\nThis is Leon produced in Spain and have 4 tires\n"
                        + "Leon sells for 11111.100000\nA4 is Gray color and have 110 horse power\n"
                        + "This is A4 produced in Germany and have 4 tires\nMinimum rental period of 3 days. Price per day 99.900000",
                run(() -> CarShopExtended.Main.main(NO_ARGS), ""));
    }

    @Test
    public void sayHello() throws Exception {
        assertEquals("Здравей\nHello\nDjydjybydjy", run(() -> SayHello.Main.main(NO_ARGS), ""));
        assertEquals("Здравей\nHello\nDjydjybydjy", run(() -> SayHelloExtended.Main.main(NO_ARGS), ""));
    }

    @Test
    public void borderControl() throws Exception {
        assertEquals("9010101122\n33283122",
                run(() -> BorderControl.Main.main(NO_ARGS), "Peter 22 9010101122\nMK-13 558833251\nMK-12 33283122\nEnd\n122\n"));
        assertEquals("7801211340", run(() -> BorderControl.Main.main(NO_ARGS),
                "Teo 31 7801211340\nAnna 29 8007181534\nIV-228 999999\nSimon 54 3401018380\nKKK-666 80808080\nEnd\n340\n"));
    }

    @Test
    public void ferrari() throws Exception {
        assertEquals("488-Spider/Brakes!/brum-brum-brum-brrrrr/Dominic Toretto",
                run(() -> Ferrari.Main.main(NO_ARGS), "Dominic Toretto\n"));
    }
}
