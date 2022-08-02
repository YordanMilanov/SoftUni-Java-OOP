package Vehicles_01;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle{

    private double fuelQuantity;
    private double fuelConsumption;

    private DecimalFormat df = new DecimalFormat("#.##");

    protected boolean hasEnoughFuel (double kilometers) {
        double totalFuelCost = kilometers * getFuelConsumption();
        return totalFuelCost < getFuelQuantity();
    }

    protected void consumeFuel (double kilometers) {
        fuelQuantity -= kilometers * fuelConsumption;
    }

    public void refuel (double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    public AbstractVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double kilometers) {
        if (!hasEnoughFuel(kilometers)) {
            return "needs refueling";
        }
        consumeFuel(kilometers);
        return "travelled " + df.format(kilometers) + " km";
    }



    @Override
    public void printFuelQuantity() {
        System.out.println(": " + String.format("%.2f",fuelQuantity));
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


}
