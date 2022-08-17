package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FarmvilleTests {
    private Animal chicken;
    private Animal lion;
    private Farm testFarm;

    @Before
    public void setUp () {
        lion = new Animal("lion", 10);
        chicken = new Animal("chicken", 10);
        testFarm = new Farm("SoftUni", 15);
    }

    @Test
    public void Test_Should_Create_Farm_Success () {
        Farm farm = new Farm("SoftUni",15);
        Assert.assertEquals("SoftUni", farm.getName());
        Assert.assertEquals(15, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void Test_Constructor_Should_Throw_Exception_If_Name_Is_Null () {
        Farm farm = new Farm (null, 15);
    }

    @Test (expected = NullPointerException.class)
    public void Test_Constructor_Should_Throw_Exception_If_Name_Is_Empty () {
        Farm farm = new Farm ("    ", 15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_Constructor_Should_Throw_Exception_If_Capacity_IsLessThanZero() {
        new Farm ("SoftUni", -15);
    }

    @Test
    public void Test_Should_Add_Animal_Successfully () {

        testFarm.add(lion);
        Assert.assertEquals(1, testFarm.getCount());
        testFarm.add(chicken);
        Assert.assertEquals(2, testFarm.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_Add_Throws_If_Size_Equals_Capacity () {
        Farm farm = new Farm ("SoftUni", 1);
        farm.add(lion);
        farm.add(chicken);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Test_If_Animal_Exist () {
       testFarm.add(lion);
       testFarm.add(lion);
    }

    @Test
    public void Test_Remove_Animal_Successfully () {
        testFarm.add(lion);
        Assert.assertTrue(testFarm.remove(lion.getType()));
        Assert.assertEquals(0, testFarm.getCount());
    }

    @Test
    public void Test_NotRemove_Animal_Successfully () {
        testFarm.add(lion);
        Assert.assertFalse(testFarm.remove(chicken.getType()));
        Assert.assertEquals(1, testFarm.getCount());
    }
}

