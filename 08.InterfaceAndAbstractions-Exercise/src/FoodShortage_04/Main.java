package FoodShortage_04;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        String[] data = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {

            if (data.length == 3) {
                Person rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                people.add(rebel);
            } else if (data.length == 4) {
                Person citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                people.add(citizen);
            }
            data = scanner.nextLine().split("\\s+");
        }
        data = scanner.nextLine().split("\\s+");

        while (!data[0].equals("End")) {
            String name = data[0];

            for (Person person : people) {
                if (person.getName().equals(name)) {
                    person.buyFood();
                }
            }
            data = scanner.nextLine().split("\\s+");
        }

        int totalFood = 0;
        for (Person person : people) {
            totalFood += person.getFood();
        }
        System.out.println(totalFood);
    }
}
