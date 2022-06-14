import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static Integer[] numbers = new Integer[]{1, 2, 3};
    private Database database;

    @Before
    public void setDatabaseField() throws OperationNotSupportedException {
        this.database = new Database(numbers);
    }

    @Test
    public void databaseCreationTestShouldCreateObjectWithValidParameters() {

        Integer[] elements = this.database.getElements();
        Assert.assertEquals(numbers.length, elements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShoudThrowOperationNotSupportedException() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShoudThrowOperationNotSupportedExceptionIfElementsMoreThanSixteen()
            throws OperationNotSupportedException {

        this.database = new Database(new Integer[17]);
    }

    @Test
    public void databaseCreationTestShouldSetElementsInCorrectOrder() {
        Integer[] elements = this.database.getElements();

        Assert.assertArrayEquals(numbers, elements);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseFunctionalTestWhenAddingNullElementShouldThrowException()
            throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void databaseFunctionalTestWhenAddingElemntShouldInsertElementAtFirstEmptyIndex()
            throws OperationNotSupportedException {
        this.database.add(42);
        Integer[] elements = this.database.getElements();
        int lastElement = elements[elements.length - 1];
        Assert.assertEquals(42, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseFunctionalTestWhenRemovingFromEmptyDatabaseShouldThrowException()
            throws OperationNotSupportedException {
        for (int i = 0; i < this.numbers.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }

    @Test
    public void databaseFunctionalTestWhenRemovingShouldRemoveElementsInReversedOrder()
            throws OperationNotSupportedException {
        this.database.remove();
        Integer[] elements = this.database.getElements();
        int lastElement = elements[elements.length - 1];

        Assert.assertEquals(2, lastElement);

    }

    @Test
    public void databaseFunctionalTestWhenRemovingAllElementsShouldBeInReversedOrder()
            throws OperationNotSupportedException {
        for (int i = numbers.length - 1; i >= 0; i--) {
            Integer currentElement = this.numbers[i];
            Integer[] elements = this.database.getElements();
            Integer last = elements[elements.length - 1];
            Assert.assertEquals(currentElement, last);
            this.database.remove();
        }
        Assert.assertEquals(0, this.database.getElements().length);
    }
}
