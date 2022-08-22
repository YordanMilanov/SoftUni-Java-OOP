package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer{
    private static final double GEOLOGIST_DEFAULT_ENERGY = 100.0;
    public Geologist(String name) {
        super(name, GEOLOGIST_DEFAULT_ENERGY);
    }
}
