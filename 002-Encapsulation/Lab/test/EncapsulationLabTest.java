import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class EncapsulationLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void sortByNameAndAge() throws Exception {
        assertEquals("Angel Harizanov is 44 years old.\nAngel Ivanov is 65 years old.\nBoris Angelov is 35 years old.\n"
                        + "Boris Georgiev is 57 years old.\nVeny Ivanov is 27 years old.",
                run(() -> SortByNameAndAge.Main.main(NO_ARGS),
                        "5\nAngel Ivanov 65\nBoris Georgiev 57\nVeny Ivanov 27\nAngel Harizanov 44\nBoris Angelov 35\n"));
    }

    @Test
    public void salaryIncrease() throws Exception {
        assertEquals("Sara Cameron gets 1278.0 leva\nJohn Petrovich gets 961.065 leva\nAnna Glen gets 1746.6 leva\n"
                        + "John Alekseevich gets 2373.0 leva",
                run(() -> SalaryIncrease.Main.main(NO_ARGS),
                        "4\nSara Cameron 21 1200\nJohn Petrovich 53 850.50\nAnna Glen 21 1640\nJohn Alekseevich 43 2100\n13\n"));
    }

    @Test
    public void validationData() throws Exception {
        assertEquals("Age cannot be zero or negative integer\nFirst name cannot be less than 3 symbols\n"
                        + "Last name cannot be less than 3 symbols\nSalary cannot be less than 460 leva\nVentsislav Ivanov gets 660.0 leva",
                run(() -> ValidationData.Main.main(NO_ARGS),
                        "5\nAsen Ivanov -6 2200\nB Borisov 57 3333\nVentsislav Ivanov 27 600\nAsen H 44 666.66\nBoiko Angelov 35 300\n20\n"));
    }

    @Test
    public void firstAndReserveTeam() throws Exception {
        assertEquals("First team have 4 players\nReserve team have 1 players",
                run(() -> FirstAndReserveTeam.Main.main(NO_ARGS),
                        "5\nAsen Ivanov 20 2200\nBoiko Borisov 57 3333\nVentsislav Ivanov 27 600\nGrigor Dimitrov 25 666.66\nBoiko Angelov 35 555\n"));
        assertEquals("First team have 3 players\nReserve team have 1 players",
                run(() -> FirstAndReserveTeam.Main.main(NO_ARGS),
                        "4\nSara Cameron 21 1200\nJohn Petrovich 53 850.50\nAnna Glen 21 475\nJohn Alekseevich 27 2100\n"));
    }
}
