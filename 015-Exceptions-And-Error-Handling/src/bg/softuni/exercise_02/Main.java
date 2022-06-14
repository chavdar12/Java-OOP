package bg.softuni.exercise_02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start;
        int end;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter start number");
                start = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter end number");
                end = Integer.parseInt(scanner.nextLine());
                printNumbers(start, end);
                validInput = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number\n");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage() + "\n");
            }
        }
    }

    static void printNumbers(int start, int end) throws IllegalArgumentException {
        if (start < 1) {
            throw new IllegalArgumentException("Start number must be greather than 1");
        } else if (end > 100) {
            throw new IllegalArgumentException("End number must be smaller than 100");
        } else if (start > end) {
            throw new IllegalArgumentException("Start number must be smaller than end number");
        } else {
            System.out.printf("1 < %d < %d < 100", start, end);
        }
    }
}
