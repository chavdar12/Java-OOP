package Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;
import java.util.function.LongBinaryOperator;

public class Main {
    private static final Map<String, LongBinaryOperator> OPERATIONS = Map.of(
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Long> memory = new ArrayDeque<>();
        LongBinaryOperator pending = null;
        long result = 0;

        for (String token : scanner.nextLine().split("\\s+")) {
            if (token.equals("end")) {
                break;
            }
            if (OPERATIONS.containsKey(token)) {
                pending = OPERATIONS.get(token);
                continue;
            }
            if (token.equals("ms")) {
                memory.push(result);
                continue;
            }
            // "mr" recalls the last saved value and uses it like a typed number
            long number = token.equals("mr") ? memory.pop() : Long.parseLong(token);
            result = pending == null ? number : pending.applyAsLong(result, number);
            pending = null;
        }

        System.out.println(result);
    }
}
