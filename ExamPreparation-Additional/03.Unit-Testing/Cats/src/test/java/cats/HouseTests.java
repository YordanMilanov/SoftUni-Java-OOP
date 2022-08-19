package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private static final String CAT_NAME = "Tom";
    private static final String HOUSE_NAME = "Villa";
    private static final int HOUSE_CAPACITY = 10;
    private Cat cat;
    private House house;

    @Before
    public void setUp () {
        house = new House(HOUSE_NAME, HOUSE_CAPACITY);
        cat = new Cat(CAT_NAME);
    }

    //Constructor
    @Test
    public void Constructor_Creates_Successfully (){
       House houseVilla = new House("houseVilla", 15);
        Assert.assertEquals("houseVilla", houseVilla.getName());
        Assert.assertEquals(15, houseVilla.getCapacity());
        Assert.assertEquals(0, houseVilla.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void Constructor_Throws_setName_Null () {
        House houseVilla = new House(null, 15);
    }

    @Test (expected = NullPointerException.class)
    public void Constructor_Throws_setName_Empty () {
        House houseVilla = new House("    ", 15);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Constructor_Throws_Capacity_Negative () {
        House villaHouse = new House(HOUSE_NAME, -1);
    }

    @Test
    public void addCat_Adds_Successfully () {
        Cat tiger = new Cat("Tiger");
        house.addCat(tiger);
        house.addCat(cat);
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCat_Throws_Exception () {
        House houseVilla = new House("houseVilla", 1);
        Cat tiger = new Cat("Tiger");
        houseVilla.addCat(tiger);
        houseVilla.addCat(cat);
    }

    @Test
    public void removeCat_Removes_Successfully () {
        House houseVilla = new House("houseVilla", 15);
        Cat tiger = new Cat("Tiger");
        houseVilla.addCat(tiger);
        houseVilla.addCat(cat);
        houseVilla.removeCat(cat.getName());
        houseVilla.removeCat(tiger.getName());
        Assert.assertEquals(0, houseVilla.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCat_Throws_If_CatNotExist () {
        House houseVilla = new House("houseVilla", 15);
        Cat tiger = new Cat("Tiger");
        Cat lion = new Cat("Lion");
        houseVilla.addCat(tiger);
        houseVilla.addCat(cat);
        houseVilla.removeCat(lion.getName());
        Assert.assertEquals(2, houseVilla.getCount());
    }

    @Test
    public void catIsSetForSale_Successfully () {
        House houseVilla = new House("houseVilla", 15);
        Cat tiger = new Cat("Tiger");
        houseVilla.addCat(tiger);
        houseVilla.addCat(cat);
        Assert.assertEquals(2, houseVilla.getCount());
        houseVilla.catForSale("Tiger");
        Assert.assertFalse(tiger.isHungry());
        houseVilla.catForSale("Tom");
        Assert.assertFalse(tiger.isHungry());
    }

    @Test (expected = IllegalArgumentException.class)
    public void catIsForSale_Throws_IfCatNotExist () {
        House houseVilla = new House("houseVilla", 15);
        Cat tiger = new Cat("Tiger");
        Cat lion = new Cat("Lion");
        houseVilla.addCat(tiger);
        houseVilla.addCat(cat);
        houseVilla.catForSale(lion.getName());
    }
}
