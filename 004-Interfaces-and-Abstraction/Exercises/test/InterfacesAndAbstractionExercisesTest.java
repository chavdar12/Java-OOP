import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class InterfacesAndAbstractionExercisesTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void defineInterfacePerson() throws Exception {
        assertEquals("2\nPeter\n25", run(() -> DefineInterfacePerson.Main.main(NO_ARGS), "Peter\n25\n"));
    }

    @Test
    public void multipleImplementation() throws Exception {
        assertEquals("1\nString\n1\nString",
                run(() -> MultipleImplementation.Main.main(NO_ARGS), "Peter\n25\n9105152287\n15/05/1991\n"));
    }

    @Test
    public void birthdayCelebrations() throws Exception {
        assertEquals("10/10/1990", run(() -> BirthdayCelebrations.Main.main(NO_ARGS),
                "Citizen Peter 22 9010101122 10/10/1990\nPet Sharo 13/11/2005\nRobot MK-13 558833251\nEnd\n1990\n"));
        assertEquals("01/01/2000\n24/12/2000", run(() -> BirthdayCelebrations.Main.main(NO_ARGS),
                "Citizen Stamo 16 0041018380 01/01/2000\nRobot MK-10 12345678\nRobot PP-09 00000001\n"
                        + "Pet Topcho 24/12/2000\nPet Kosmat 12/06/2002\nEnd\n2000\n"));
    }

    @Test
    public void foodShortage() throws Exception {
        // Citizens buy 10 food, rebels 5; unknown names are ignored.
        assertEquals("25", run(() -> FoodShortage.Main.main(NO_ARGS),
                "2\nPeter 25 8904041303 04/04/1989\nStan 27 WildMonkeys\nPeter\nGeorge\nPeter\nStan\nEnd\n"));
    }

    @Test
    public void telephony() throws Exception {
        assertEquals("Calling... 0882134215\nCalling... 0882134333\nCalling... 08992134215\nCalling... 0558123\n"
                        + "Calling... 3333\nCalling... 1\nBrowsing: http://softuni.bg!\nBrowsing: http://youtube.com!\nInvalid URL!",
                run(() -> Telephony.Main.main(NO_ARGS),
                        "0882134215 0882134333 08992134215 0558123 3333 1\nhttp://softuni.bg http://youtube.com http://www.g00gle.com\n"));
    }

    @Test
    public void militaryElite() throws Exception {
        assertEquals("Name: Peter Petrov Id: 1 Salary: 22.22\nName: Stam Stamov Id: 13 Salary: 13.10\nCorps: Airforces\nMissions:\n"
                        + "Name: Tom Tomson Id: 222 Salary: 80.08\nName: John Johnson Id: 3 Salary: 100.00\nPrivates:\n"
                        + "  Name: Tom Tomson Id: 222 Salary: 80.08\n  Name: Peter Petrov Id: 1 Salary: 22.22",
                run(() -> MilitaryElite.Main.main(NO_ARGS), "Private 1 Peter Petrov 22.22\nCommando 13 Stam Stamov 13.1 Airforces\n"
                        + "Private 222 Tom Tomson 80.08\nLieutenantGeneral 3 John Johnson 100 222 1\nEnd\n"));
    }

    @Test
    public void collectionHierarchy() throws Exception {
        assertEquals("0 1 2\n0 0 0\n0 0 0\napple orange peach\npeach orange apple",
                run(() -> CollectionHierarchy.Main.main(NO_ARGS), "apple orange peach\n3\n"));
        assertEquals("0 1 2 3 4 5 6\n0 0 0 0 0 0 0\n0 0 0 0 0 0 0\none two three four\nseven six five four",
                run(() -> CollectionHierarchy.Main.main(NO_ARGS), "one two three four five six seven\n4\n"));
    }
}
