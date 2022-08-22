package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{
    private static final double ARCHAEOLOGIST_DEFAULT_ENERGY = 60.0;
    public Archaeologist(String name) {
        super(name, ARCHAEOLOGIST_DEFAULT_ENERGY);
    }
}
