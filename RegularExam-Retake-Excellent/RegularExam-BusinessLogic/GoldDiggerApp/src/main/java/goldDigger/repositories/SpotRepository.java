package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.*;

public class SpotRepository implements Repository<Spot>{

    private Collection<Spot> spots;

    public SpotRepository() {
        spots = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot entity) {
        spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return spots.remove(entity.getName());
    }

    @Override
    public Spot byName(String name) {
        for (Spot spot : spots) {
            if (spot.getName().equals(name)) {
                return spot;
            }
        }
        return null;
    }

}
