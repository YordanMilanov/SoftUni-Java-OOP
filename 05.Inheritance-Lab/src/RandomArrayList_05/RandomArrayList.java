package RandomArrayList_05;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement () {
        int randomIndex = new Random().nextInt(super.size());
        return super.remove(randomIndex);
    }
}
