package src.exercise_05.core;

import src.exercise_05.core.commands.Inject;
import src.exercise_05.interfaces.CommandInterpreter;
import src.exercise_05.interfaces.Executable;
import src.exercise_05.interfaces.Repository;
import src.exercise_05.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE = "src.exercise_05.core.commands.";

    private final Repository repository;
    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;

        // using Reflection

        String command = getCorrectClassName(data[0]);

        try {
            Class clazz = Class.forName(COMMAND_PACKAGE + command);

            Constructor constructor = clazz.getDeclaredConstructor(String[].class);

            executable = (Executable) constructor.newInstance(new Object[]{data});

            populateDependencies(executable);

        } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
            // TODO Auto-generated catch block
//			e.printStackTrace();
        }

        return executable;
    }

    private void populateDependencies(Executable executable) {

        Field[] fields = executable.getClass().getDeclaredFields();
        Field[] currentClassFields = this.getClass().getDeclaredFields();

        for (Field requiredField : fields) {
            Inject annotation = null;
            try {
                annotation = requiredField.getAnnotation(Inject.class);
            } catch (ClassCastException ex) {
                continue;
            }
            for (Field currentField : currentClassFields) {
                if (currentField.getClass().equals(requiredField.getClass())) {
                    requiredField.setAccessible(true);
                    try {
                        requiredField.set(executable, currentField.get(this));
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String getCorrectClassName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
