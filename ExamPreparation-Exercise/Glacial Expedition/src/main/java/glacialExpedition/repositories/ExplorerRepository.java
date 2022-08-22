package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository<Explorer>{

    private Collection<Explorer> explorers;

    public ExplorerRepository(Collection<Explorer> explorers) {
        this.explorers = new ArrayList<>();
    }


    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers);
    }

    @Override
    public void add(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return explorers.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : explorers) {
            if (explorer.getName().equals(name)) {
                return explorer;
            }
        }
        return null;
    }

    public Collection<Explorer> getExplorers() {
        return explorers;
    }

    public void setExplorers(Collection<Explorer> explorers) {
        this.explorers = explorers;
    }
}
