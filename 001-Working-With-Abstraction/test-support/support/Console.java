package support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.stream.Collectors;

public final class Console {
    @FunctionalInterface
    public interface Program {
        void run() throws Exception;
    }

    private Console() {
    }

    /**
     * Runs a console program with the given stdin and returns its stdout.
     * Line endings are normalised and trailing whitespace on every line is dropped,
     * since the programs print "1 2 3 " style output.
     */
    public static String run(Program program, String input) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        Locale originalLocale = Locale.getDefault();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // printf("%.2f") must not depend on the machine locale (e.g. bg_BG prints a comma)
            Locale.setDefault(Locale.US);
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            program.run();
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            Locale.setDefault(originalLocale);
        }
        return normalise(out.toString(StandardCharsets.UTF_8));
    }

    public static String normalise(String text) {
        return text.replace("\r\n", "\n").lines()
                .map(String::stripTrailing)
                .collect(Collectors.joining("\n"))
                .stripTrailing();
    }
}
