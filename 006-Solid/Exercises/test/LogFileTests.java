import models.LogFile;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class LogFileTests {

    @Test
    public void sizeShouldBeSumOfAlphabeticCharacters() {
        LogFile file = new LogFile();
        file.append("ab 1!");
        Assert.assertEquals('a' + 'b', file.getSize());
    }

    @Test
    public void writeShouldCreateMissingFile() throws Exception {
        Path path = Files.createTempDirectory("log").resolve("out.txt");
        LogFile file = new LogFile(path.toString());
        file.append("hello");

        Assert.assertTrue(file.write());
        Assert.assertEquals("hello", Files.readString(path));
    }
}
