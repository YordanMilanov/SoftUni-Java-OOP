package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.*;

public class DiscovererRepository implements Repository<Discoverer>{

    private Map<String, Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers.values());
    }

    @Override
    public void add(Discoverer entity) {
        discoverers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return discoverers.remove(entity.getName()) != null;
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.get(name);
    }

    @Override
    public String toString() {
     StringBuilder sb = new StringBuilder();
     discoverers.values().forEach(d -> sb.append(d).append(System.lineSeparator()));
     return sb.toString();
    }
}
