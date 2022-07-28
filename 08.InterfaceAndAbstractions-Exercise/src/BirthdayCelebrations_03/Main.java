package BirthdayCelebrations_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> Animals = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        String[] data = scanner.nextLine().split("\\s+");

        while (!data[0].equals("End")) {


            if (data[0].equals("Pet")) {
                Birthable pet = new Pet(data[1], data[2]);
                Animals.add(pet);
            } else if (data[0].equals("Robot")) {
                Robot robot = new Robot(data[1], data[2]);
                robots.add(robot);
            } else if (data[0].equals("Citizen")) {
                Birthable citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                Animals.add(citizen);
            }

            data = scanner.nextLine().split("\\s+");
        }

        String searchedYearOfBirth = scanner.nextLine();

        for (Birthable animal : Animals) {
            if (animal.getBirthDate().endsWith(searchedYearOfBirth)) {
                System.out.println(animal.getBirthDate());
            }
        }
    }
}
