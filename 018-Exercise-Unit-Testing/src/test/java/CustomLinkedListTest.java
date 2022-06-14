import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> list;

    @Before
    public void setUp() {
        this.list = new CustomLinkedList<>();
    }

    @Test
    public void creatingLinkedListShouldHaveZeroCount() throws IllegalArgumentException, IllegalAccessException {
        Field field = Arrays.stream(CustomLinkedList.class.getDeclaredFields()).filter(f -> f.getName().equals("count"))
                .findFirst().orElse(null);

        assertNotNull(field);
        field.setAccessible(true);
        int count = (int) field.get(this.list);
        assertEquals(0, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOnEmptyListShouldThrowExceptionWithZeroAsIndex() {
        this.list.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOnEmptyListShouldThrowExceptionWithNegativeAsIndex() {
        this.list.get(-1);
    }
}
