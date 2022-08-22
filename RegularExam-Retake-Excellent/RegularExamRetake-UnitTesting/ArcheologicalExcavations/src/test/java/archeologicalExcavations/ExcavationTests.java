package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private static final String EXCAVATION_NAME = "Egypt";
    private static final int EXCAVATION_CAPACITY = 5;
    private static final String ARCHAEOLOGIST_NAME = "Gondo";
    private static final double ARCHAEOLOGIST_ENERGY = 100;
    private Excavation excavation;
    private Archaeologist archaeologist;


    @Before
    public void setUp() {
        excavation = new Excavation(EXCAVATION_NAME, EXCAVATION_CAPACITY);
        archaeologist = new Archaeologist(ARCHAEOLOGIST_NAME, ARCHAEOLOGIST_ENERGY);
    }

    @Test
    public void constructorExcavation_Successfully() {
        Excavation excavationCreateSuccessfully = new Excavation(EXCAVATION_NAME, EXCAVATION_CAPACITY);
        Assert.assertEquals(EXCAVATION_NAME, excavationCreateSuccessfully.getName());
        Assert.assertEquals(EXCAVATION_CAPACITY, excavationCreateSuccessfully.getCapacity());
        Assert.assertEquals(0, excavationCreateSuccessfully.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void constructorExcavation_Throws_IfNameIsNull() {
        Excavation excavationCreate = new Excavation(null, EXCAVATION_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void constructorExcavation_Throws_IfNameIsEmptyOrWhiteSpace() {
        Excavation excavationCreate = new Excavation("    ", EXCAVATION_CAPACITY);
    }


    @Test(expected = IllegalArgumentException.class)
    public void constructorExcavation_Throws_IfCapacityIsLessThanZero() {
        final int EXCAVATION_NEGATIVE_CAPACITY = -2;
        Excavation excavationCreate = new Excavation(EXCAVATION_NAME, EXCAVATION_NEGATIVE_CAPACITY);
    }

    @Test
    public void addArchaeologist_Successfully() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("Amet", 50));
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologist_Throws_If_Capacity_Is_Full() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("Amet", 50));
        excavation.addArchaeologist(new Archaeologist("Vanko", 60));
        excavation.addArchaeologist(new Archaeologist("Tosho", 70));
        excavation.addArchaeologist(new Archaeologist("Gosho", 80));
        excavation.addArchaeologist(new Archaeologist("Pesho", 90));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologist_Throws_If_Archaeologist_Exists() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void removeArchaeologist_Successfully() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("Vanko", 60));
        excavation.addArchaeologist(new Archaeologist("Tosho", 70));
        Assert.assertEquals(3, excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist(archaeologist.getName()));
        Assert.assertEquals(2, excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist("Vanko"));
        Assert.assertEquals(1, excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist("Tosho"));
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void removeArchaeologist_Returns_False_If_Archaeologist_Does_Not_Exist () {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(new Archaeologist("Vanko", 60));
        Assert.assertFalse(excavation.removeArchaeologist("Sasho"));
        Assert.assertEquals(2, excavation.getCount());
    }
}
