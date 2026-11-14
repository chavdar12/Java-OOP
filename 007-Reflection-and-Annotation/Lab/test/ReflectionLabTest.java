import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class ReflectionLabTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void reflection() throws Exception {
        assertEquals("This class type: class Reflection\nSuper class type: class java.lang.Object\n"
                        + "Interface: interface java.io.Serializable\nName: Java\nWebAddress: oracle.com\nemail: mail@oracle.com\nzip: 1407",
                run(() -> Main.main(NO_ARGS), ""));
    }

    @Test
    public void gettersAndSetters() throws Exception {
        assertEquals("getEmail will return class java.lang.String\ngetName will return class java.lang.String\n"
                        + "getWebAddress will return class java.lang.String\ngetZip will return int\n"
                        + "setEmail and will set field of class java.lang.String\nsetName and will set field of class java.lang.String\n"
                        + "setWebAddress and will set field of class java.lang.String\nsetZip and will set field of int",
                run(() -> GettersAndSetters.main(NO_ARGS), ""));
    }

    @Test
    public void highQualityMistakes() throws Exception {
        assertEquals("email must be private!\nname must be private!\nwebAddress must be private!\n"
                        + "getWebAddress have to be public!\ngetZip have to be public!\nsetEmail have to be private!",
                run(() -> HighQualityMistakes.main(NO_ARGS), ""));
    }

    @Test
    public void createAnnotation() {
        assertArrayEquals(new String[]{"Test", "Annotations"},
                annotations.Tracker.class.getAnnotation(annotations.Subject.class).categories());
    }

    @Test
    public void codingTracker() throws Exception {
        assertEquals("George: main()\nPeter: printMethodsByAuthor()", run(() -> annotations.Tracker.main(NO_ARGS), ""));
    }
}
