package src.exercise_04.core;

import jdk.jshell.spi.ExecutionControl;
import src.exercise_04.interfaces.Executable;
import src.exercise_04.interfaces.Repository;
import src.exercise_04.interfaces.Runnable;
import src.exercise_04.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PACKAGE = "src.exercise_04.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result;

        // using Reflection

        String command = getCorrectClassName(data[0]);

        try {
            Class clazz = Class.forName(COMMAND_PACKAGE + command);

            Constructor constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);

            Executable instance = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);

            result = instance.execute();

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();

            result = "Invalid command!";
        }

        // using switch
//		switch (commandName) {
//		case "add":
//			result = new Add(data, this.repository, this.unitFactory).execute();
//			break;
//		case "report":
//			result = new Report(data, this.repository, this.unitFactory).execute();
//			break;
//		case "fight":
//			result = new Fight(data, this.repository, this.unitFactory).execute();
//			break;
//		default:
//			throw new RuntimeException("Invalid command!");
//		}
        return result;
    }

    private String getCorrectClassName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
