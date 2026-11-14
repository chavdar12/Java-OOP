import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class GettersAndSetters {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .forEach(m -> System.out.printf("%s will return %s%n", m.getName(), m.getReturnType()));
        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .forEach(m -> System.out.printf("%s and will set field of %s%n", m.getName(), m.getParameterTypes()[0]));
    }
}
