package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import java.util.Collection;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        museum = new BaseMuseum();
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        this.energy -= 15;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_DISCOVERER_NAME, getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(FINAL_DISCOVERER_ENERGY, getEnergy()));
        sb.append(System.lineSeparator());
        if (getMuseum().getExhibits().isEmpty()) {
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"));
        } else {
            sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, getMuseum().getExhibits())));
        }
        return sb.toString();
    }
}

