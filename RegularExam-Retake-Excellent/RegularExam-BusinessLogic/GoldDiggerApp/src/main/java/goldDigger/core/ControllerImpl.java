package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int countOfInspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.countOfInspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {

        Discoverer discoverer;

        switch (kind) {
            case"Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case"Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case"Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);

        return String.format(SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToBeRemoved = discovererRepository.byName(discovererName);
        if (discovererToBeRemoved == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discovererRepository.remove(discovererToBeRemoved);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {

        Spot spotToInspect = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();

        List<Discoverer> compatibleDiscoverers = discovererRepository.getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());

        if (compatibleDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        operation.startOperation(spotToInspect, compatibleDiscoverers);
        countOfInspectedSpots++;


        Predicate<Discoverer> filterDiscoverersWithZeroEnergy = d -> d.getEnergy() == 0;
       long countOfZeroEnergyDiscoverers = compatibleDiscoverers.stream().filter(filterDiscoverersWithZeroEnergy).count();
        return String.format(INSPECT_SPOT, spotToInspect.getName(), countOfZeroEnergyDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, countOfInspectedSpots));
        sb.append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO);
        sb.append(System.lineSeparator());
        sb.append(discovererRepository.toString());
        return sb.toString().trim();
    }

}
