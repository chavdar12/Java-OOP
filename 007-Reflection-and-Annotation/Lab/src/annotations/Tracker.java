package annotations;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@Subject(categories = {"Test", "Annotations"})
public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, TreeSet<String>> methodsByAuthor = new TreeMap<>();
        for (Method method : cl.getDeclaredMethods()) {
            Author author = method.getAnnotation(Author.class);
            if (author != null) {
                methodsByAuthor.computeIfAbsent(author.name(), k -> new TreeSet<>()).add(method.getName() + "()");
            }
        }
        methodsByAuthor.forEach((author, methods) -> System.out.printf("%s: %s%n", author, String.join(", ", methods)));
    }
}
