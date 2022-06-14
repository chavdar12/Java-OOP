package src.exercise_05;

import src.exercise_05.core.CommandInterpreterImpl;
import src.exercise_05.core.Engine;
import src.exercise_05.core.factories.UnitFactoryImpl;
import src.exercise_05.data.UnitRepository;
import src.exercise_05.interfaces.CommandInterpreter;
import src.exercise_05.interfaces.Repository;
import src.exercise_05.interfaces.Runnable;
import src.exercise_05.interfaces.UnitFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
