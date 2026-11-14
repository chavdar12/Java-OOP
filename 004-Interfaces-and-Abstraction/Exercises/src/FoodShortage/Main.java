package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            buyers.put(name, tokens.length == 4
                    ? new Citizen(name, age, tokens[2], tokens[3])
                    : new Rebel(name, age, tokens[2]));
        }

        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            Buyer buyer = buyers.get(name);
            if (buyer != null) {
                buyer.buyFood();
            }
            name = scanner.nextLine();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
