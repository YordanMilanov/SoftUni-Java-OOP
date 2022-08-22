package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer {
    private static final double ANTHROPOLOGIST_DEFAULT_ENERGY = 40.0;

    public Anthropologist(String name) {
        super(name, ANTHROPOLOGIST_DEFAULT_ENERGY);
    }
}
