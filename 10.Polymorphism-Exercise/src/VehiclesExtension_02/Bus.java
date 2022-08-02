package VehiclesExtension_02;

public class Bus extends AbstractVehicle{
    private boolean empty;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String drive(double kilometers) {
        if (empty) {
        return "Bus " + super.drive(kilometers);
        } else {
            setFuelConsumption(getFuelConsumption() + 1.4);
            String result = "Bus " + super.drive(kilometers);
            setFuelConsumption(getFuelConsumption() - 1.4);
            return result;
        }
    }

    @Override
    public void printFuelQuantity() {
        System.out.print("Bus");
        super.printFuelQuantity();
    }
}
