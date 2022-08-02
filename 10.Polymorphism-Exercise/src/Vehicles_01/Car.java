package Vehicles_01;

public class Car extends AbstractVehicle {
    private static final Double FUEL_INCREASE_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_INCREASE_CONSUMPTION);
    }

    @Override
    public String drive(double kilometers) {
        return "Car " + super.drive(kilometers);
    }

    @Override
    public void printFuelQuantity() {
        System.out.print("Car");
        super.printFuelQuantity();
    }
}
