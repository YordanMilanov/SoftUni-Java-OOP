package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {1, 2, 3, 4, 5};

    //1.Test Constructor
    //2. Happy path (everything is working fine with the constructor)
    //3. Failed Validation -> too many or few arguments.

    @Before
    public void prepare() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
        database = new Database(NUMBERS);
    }

    @Test
    public void TestCreateDatabase() throws OperationNotSupportedException {

        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length, database.getElements().length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals(NUMBERS[i], dbElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorWithLessArguments() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorWithMoreThan16Arguments() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[20];
        Database database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestAddIfAddingNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void TestAddSuccessfully() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(12);
        Integer[] DBElements = database.getElements();
        int lastElementFromDB = DBElements[DBElements.length - 1];
        Assert.assertEquals(12, lastElementFromDB);
        Assert.assertEquals(initialSize + 1, DBElements.length);
    }

    @Test
    public void TestRemoveSuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();
        Integer[] currentElements = database.getElements();
        Assert.assertEquals(initialSize - 1, currentElements.length);
        Assert.assertEquals(NUMBERS[NUMBERS.length - 2], currentElements[currentElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestThrowExceptionIfArrayIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }

        database.remove();
    }
}


