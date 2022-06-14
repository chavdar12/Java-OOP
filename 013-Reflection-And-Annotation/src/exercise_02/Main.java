package exercise_02;

import exercise_01.Reflection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        java.lang.reflect.Method[] allMethods = reflection.getDeclaredMethods();

        List<java.lang.reflect.Method> setters = new ArrayList<>();
        List<java.lang.reflect.Method> getters = new ArrayList<>();

        for (java.lang.reflect.Method method : allMethods) {
            if (isSetter(method)) {
                setters.add(method);
            } else if (isGetter(method)) {
                getters.add(method);
            }
        }

        setters.sort((f, s) -> f.getName().compareTo(s.getName()));
        getters.sort((f, s) -> f.getName().compareTo(s.getName()));

        setters.forEach(setter -> System.out.println(formatSetter(setter)));
        getters.forEach(getter -> System.out.println(formatGetter(getter)));
    }

    private static String formatGetter(java.lang.reflect.Method getter) {
        return String.format("%s will return class %s", getter.getName(), getter.getReturnType());
    }

    private static String formatSetter(java.lang.reflect.Method setter) {
        // TODO Auto-generated method stub
        return String.format("%s and will set field of class %s", setter.getName(), setter.getParameterTypes()[0]);
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
