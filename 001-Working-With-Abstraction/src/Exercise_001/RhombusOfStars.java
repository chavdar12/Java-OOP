import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        firstPart(n);
        secondPart(n);
    }

    private static void secondPart(int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(repeater(" ", n - (n - i)) + repeater("* ", n - i));
        }
    }

    private static void firstPart(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(repeater(" ", n - i) + repeater("* ", n - (n - i)));
        }
    }

    static String repeater(String symbol, int times) {
        return String.valueOf(symbol).repeat(Math.max(0, times));
    }
}
