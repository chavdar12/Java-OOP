package bg.softuni.exercise_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        try {
            number = Integer.parseInt(scanner.nextLine());
            System.out.println("The square root of " + number + " is " + Math.sqrt(number));
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }
    }
}
