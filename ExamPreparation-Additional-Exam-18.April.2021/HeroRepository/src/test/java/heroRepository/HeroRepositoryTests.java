package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    private Hero Jax;
    private Hero Zac;
    private HeroRepository heroRepository;

    @Before
    public void setUp () {
        Jax = new Hero("Jax", 11);
        Zac = new Hero("Zac", 6);
        heroRepository = new HeroRepository();
    }

    @Test
    public void  createHero_Successfully () {
        heroRepository.create(Jax);
        heroRepository.create(Zac);
        Assert.assertEquals(2, heroRepository.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void createHero_HeroIsNull () {
        heroRepository.create(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createHero_Throw_If_Hero_Already_exist () {
        heroRepository.create(Jax);
        heroRepository.create(Jax);
    }

    @Test
    public void remove_Successfully () {
        heroRepository.create(Jax);
        heroRepository.create(Zac);
        heroRepository.remove("Jax");
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void remove_Throws_If_NameIsNull () {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void remove_Throws_If_NameIsEmpty () {
        heroRepository.remove("    ");
    }

    @Test
    public void getHeroWithHighestLevel_Successfully () {
        heroRepository.create(Jax);
        //Jax Level = 11
        heroRepository.create(Zac);
        //Zac Level = 6
        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(2, heroRepository.getCount());
        Assert.assertEquals(heroWithHighestLevel.getLevel(), Jax.getLevel());
    }


    @Test
    public void getHeroWithHighestLevel_ReturnsNullIfThereIsNoHero () {
      Hero hero = heroRepository.getHeroWithHighestLevel();
      Assert.assertEquals(null, hero);
    }

    @Test
    public void getHero_Successfully () {
        heroRepository.create(Jax);
        //Jax Level = 11
        heroRepository.create(Zac);
        //Zac Level = 6
        Hero targetHero = heroRepository.getHero("Jax");
        Assert.assertEquals(targetHero, Jax);
    }

    @Test
    public void getHero_returnsNullIfThereIsNoSuchHero () {
        heroRepository.create(Jax);
        //Jax Level = 11
        heroRepository.create(Zac);
        //Zac Level = 6
        Hero targetHero = heroRepository.getHero("Ashe");
        Assert.assertEquals(null, targetHero);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getHeroesUnmodifiable () {
        heroRepository.create(Jax);
        //Jax Level = 11
        heroRepository.create(Zac);
        //Zac Level = 6
        heroRepository.getHeroes().add(new Hero("Ashe", 15));
    }
}
