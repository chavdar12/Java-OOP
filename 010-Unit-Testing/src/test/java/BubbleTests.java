import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import p04_BubbleSortTest.Bubble;

public class BubbleTests {
    @Test
    public void sortsAscending() {
        int[] numbers = {5, -1, 3, 3, 0};
        Bubble.sort(numbers);
        assertArrayEquals(new int[]{-1, 0, 3, 3, 5}, numbers);
    }

    @Test
    public void handlesEmptyAndSingleElementArrays() {
        int[] empty = {};
        Bubble.sort(empty);
        assertArrayEquals(new int[]{}, empty);
        int[] single = {7};
        Bubble.sort(single);
        assertArrayEquals(new int[]{7}, single);
    }
}
