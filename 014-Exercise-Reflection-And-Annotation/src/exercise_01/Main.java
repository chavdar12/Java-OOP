package src.exercise_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class richSoilLand = RichSoilLand.class;

        Field[] declaredFields = richSoilLand.getDeclaredFields();

        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {
            for (Field field : declaredFields) {
                String modifier = Modifier.toString(field.getModifiers());

                if (modifier.equals(input) || input.equals("all")) {
                    String type = field.getType().getSimpleName();
                    String name = field.getName();
                    System.out.printf("%s %s %s%n", modifier, type, name);
                }
            }

            input = scanner.nextLine();
        }

    }
}
