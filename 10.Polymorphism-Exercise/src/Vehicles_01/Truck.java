package Vehicles_01;

public class Truck extends AbstractVehicle{
        private static final Double FUEL_INCREASE_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_INCREASE_CONSUMPTION);
    }

    @Override
    public String drive(double kilometers) {
        return "Truck " + super.drive(kilometers);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }

    @Override
    public void printFuelQuantity() {
        System.out.print("Truck");
        super.printFuelQuantity();
    }
}
