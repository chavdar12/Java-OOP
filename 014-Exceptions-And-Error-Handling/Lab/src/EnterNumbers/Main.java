package EnterNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());
                printNumbers(start, end);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid range, enter both numbers again");
            }
        }
    }

    // Requires 1 < start < end < 100.
    public static void printNumbers(int start, int end) {
        if (start <= 1 || end >= 100 || start >= end) {
            throw new IllegalArgumentException("Invalid range");
        }
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
