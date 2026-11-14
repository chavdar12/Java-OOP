import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static support.Console.run;

import org.junit.Test;

public class ExceptionsLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void squareRoot() throws Exception {
        assertEquals("4.00\nGood bye", run(() -> SquareRoot.Main.main(NO_ARGS), "16\n"));
        assertEquals("Invalid number\nGood bye", run(() -> SquareRoot.Main.main(NO_ARGS), "-4\n"));
        assertEquals("Invalid number\nGood bye", run(() -> SquareRoot.Main.main(NO_ARGS), "abc\n"));
    }

    @Test
    public void enterNumbersAsksAgainUntilTheRangeIsValid() throws Exception {
        assertEquals("Invalid range, enter both numbers again\nInvalid range, enter both numbers again\n3\n4\n5",
                run(() -> EnterNumbers.Main.main(NO_ARGS), "abc\n5\n2\n3\n5\n"));
    }

    @Test
    public void validPerson() {
        ValidPerson.Person person = new ValidPerson.Person("Peter", "Petrov", 20);
        assertEquals("Peter", person.getFirstName());
        assertThrows(IllegalArgumentException.class, () -> new ValidPerson.Person("", "Petrov", 20));
        assertThrows(IllegalArgumentException.class, () -> new ValidPerson.Person("Peter", null, 20));
        assertThrows(IllegalArgumentException.class, () -> new ValidPerson.Person("Peter", "Petrov", -1));
        assertThrows(IllegalArgumentException.class, () -> new ValidPerson.Person("Peter", "Petrov", 121));
    }

    @Test
    public void customException() {
        assertThrows(ValidPerson.InvalidPersonNameException.class, () -> new ValidPerson.Student("4havdar", "a@b.bg"));
        assertEquals("Chavdar", new ValidPerson.Student("Chavdar", "a@b.bg").getName());
    }
}
