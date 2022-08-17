package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private static final String SPECIE = "Dog";
    private static final int MAX_WEIGHT= 30;
    private static final double MAX_PRICE= 100.00;


    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp () {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIE, MAX_WEIGHT, MAX_PRICE);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetAnimalsShouldReturnUnmodifiableList () {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmptyAndOneWhenSingleAnimalAdded () {
        Assert.assertEquals(0, petStore.getCount());
         petStore.addAnimal(animal);
         Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_OnlyThoseHeavier () {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT - 1);
        petStore.addAnimal(new Animal("TEST", MAX_WEIGHT - 2,MAX_PRICE));
        Assert.assertEquals(1, animals.size());
        Assert.assertEquals(animal.getSpecie(), animals.get(0).getSpecie());


    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_Empty () {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT + 10);
        Assert.assertTrue(animals.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAnimal_Throws_When_Animal_Is_Null () {
        petStore.addAnimal(null);
    }

    @Test
    public void addAnimal_Success () {
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void getTheMostExpensiveAnimal_Returns_Null_IfIsEmpty () {
        Animal animal = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(animal);
    }

    @Test
    public void getTheMostExpensiveAnimal_Returns_MostExpensiveOne () {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal(SPECIE,MAX_WEIGHT, MAX_PRICE - 10));
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(animal.getPrice(), actualAnimal.getPrice(), 0.00);
    }

    @Test
    public void findAllAnimalBySpecie_Should_Return_Empty () {
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        Assert.assertTrue(animals.isEmpty());
    }

    @Test
    public void findAllAnimalBySpecie_Should_Return_ListOfAnimalsWithThisName () {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Goat", 30, 100.0 ));
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        Assert.assertEquals(1, animals.size());
        Assert.assertEquals(SPECIE, animals.get(0).getSpecie());
    }
}

