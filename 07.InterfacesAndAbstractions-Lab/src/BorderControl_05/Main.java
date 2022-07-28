package BorderControl_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Identifiable> ListOfIdentifiable = new HashMap<>();

        String [] data = scanner.nextLine().split("\\s+");

        while(!data[0].equals("End")) {
            if (data.length == 2) {
                Robot robot = new Robot(data[0], data[1]);
                ListOfIdentifiable.put(robot.getId(), robot);
            } else if (data.length == 3){
                Citizen citizen = new Citizen(data[0],Integer.parseInt(data[1]),data[2]);
                ListOfIdentifiable.put(citizen.getId(), citizen);
            }

            data = scanner.nextLine().split("\\s+");
        }

        String fakeIdEndsWith = scanner.nextLine();

        for (Map.Entry<String, Identifiable> entry : ListOfIdentifiable.entrySet()) {
            if (entry.getKey().endsWith(fakeIdEndsWith)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
