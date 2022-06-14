import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void bubbleShouldSortElements() {
        int[] arrOne = {42, 13, 69, 27};
        int[] arrTwo = {42, 13, 69, 27};

        Bubble.sort(arrOne);
        Arrays.sort(arrTwo);

        Assert.assertArrayEquals(arrOne, arrTwo);
    }
}
