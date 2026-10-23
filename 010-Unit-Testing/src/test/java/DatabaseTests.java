import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class DatabaseTests {

    private static final Integer[] INITIAL_ELEMENTS = new Integer[]{1, 2, 3};

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThanOneElement() throws OperationNotSupportedException {
        Database db = new Database(); //empty array to constructor and get exception
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Database db = new Database(new Integer[17]); //more than 16 elements in constructor and get exception
    }

    @Test
    public void constructingDatabaseShouldIncreaseElementsCount() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database db = new Database(DatabaseTests.INITIAL_ELEMENTS);

        Field elementsCount = Database.class.getDeclaredField("elementsCount"); // get private field with reflection
        elementsCount.setAccessible(true);
        int fieldCurrentValue = elementsCount.getInt(db);
        Assert.assertEquals(DatabaseTests.INITIAL_ELEMENTS.length, fieldCurrentValue);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTests.INITIAL_ELEMENTS);
        db.add(null);
    }

    @Test
    public void addElementShouldIncreaseElementCount() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTests.INITIAL_ELEMENTS);

        for (int i = 0; i < 3; i++) {
            db.add(i);
        }
        Assert.assertEquals(db.getElements().length, INITIAL_ELEMENTS.length + 3);
    }

    @Test
    public void removeShouldRemoveOnlyLastElement() throws OperationNotSupportedException {
        Database db = new Database(DatabaseTests.INITIAL_ELEMENTS);

        db.remove();

        int length = db.getElements().length;

        Assert.assertEquals(length, INITIAL_ELEMENTS.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToFullDatabaseShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        db.add(17);
    }

    @Test
    public void removeFromEmptyDatabaseShouldThrowAndKeepDatabaseUsable() throws OperationNotSupportedException {
        Database db = new Database(1);
        db.remove();
        try {
            db.remove();
            Assert.fail();
        } catch (OperationNotSupportedException expected) {
            // the failed remove must not corrupt the internal index
        }

        db.add(5);
        Assert.assertArrayEquals(new Integer[]{5}, db.getElements());
    }
}
