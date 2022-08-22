package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        suitcase = new Carton();
    }


    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
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
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        if (getEnergy() <= 7) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy() - 7);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_EXPLORER_NAME, getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(FINAL_EXPLORER_ENERGY, getEnergy()));
        sb.append(System.lineSeparator());
        if (suitcase.getExhibits().size() == 0) {
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
        } else {
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, getSuitcase().getExhibits())));
        }
        return sb.toString();
    }
}
