package exercise_03;

import exercise_01.Reflection;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Arrays.stream(reflection.getDeclaredFields()).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))

                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        java.lang.reflect.Method[] allMethods = reflection.getDeclaredMethods();

        List<java.lang.reflect.Method> setters = new ArrayList<>();
        List<java.lang.reflect.Method> getters = new ArrayList<>();

        for (java.lang.reflect.Method method : allMethods) {
            int methodModifiers = method.getModifiers();
            if (isSetter(method) && !Modifier.isPrivate(methodModifiers)) {
                setters.add(method);
            } else if (isGetter(method) && !Modifier.isPublic(methodModifiers)) {
                getters.add(method);
            }
        }

        setters.sort((f, s) -> f.getName().compareTo(s.getName()));
        getters.sort((f, s) -> f.getName().compareTo(s.getName()));

        setters.forEach(setter -> System.out.println(formatSetter(setter)));
        getters.forEach(getter -> System.out.println(formatGetter(getter)));
    }

    private static String formatGetter(java.lang.reflect.Method getter) {
        return String.format("%s have to be public!", getter.getName());
    }

    private static String formatSetter(java.lang.reflect.Method setter) {
        // TODO Auto-generated method stub
        return String.format("%s have to be private!", setter.getName());
    }

    private static boolean isGetter(java.lang.reflect.Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getReturnType() == void.class) {
            return false;
        }
        return method.getParameterCount() == 0;
    }

    private static boolean isSetter(java.lang.reflect.Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getReturnType() != void.class) {
            return false;
        }
        return method.getParameterCount() == 1;
    }
}
