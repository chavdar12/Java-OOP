import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityMistakes {
    public static void main(String[] args) {
        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = Reflection.class.getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));
        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers()))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));
        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && !Modifier.isPrivate(m.getModifiers()))
                .forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));
    }
}
