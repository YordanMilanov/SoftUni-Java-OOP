package Vehicles_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] carTokens = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));

        String [] truckTokens = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("Car",car);
        vehicleMap.put("Truck",truck);

        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String [] commandTokens = scanner.nextLine().split("\\s+");
            double quantity = Double.parseDouble(commandTokens[2]);
            Vehicle currentVehicle = vehicleMap.get(commandTokens[1]);

            if ("Drive".equals(commandTokens[0])) {
                System.out.println(currentVehicle.drive(quantity));
            } else if ("Refuel".equals(commandTokens[0])) {
                currentVehicle.refuel(quantity);
            }
        }

        car.printFuelQuantity();
        truck.printFuelQuantity();

    }
}
