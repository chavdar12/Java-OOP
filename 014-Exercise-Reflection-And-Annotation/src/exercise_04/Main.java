package src.exercise_04;

import src.exercise_04.core.Engine;
import src.exercise_04.core.factories.UnitFactoryImpl;
import src.exercise_04.data.UnitRepository;
import src.exercise_04.interfaces.Repository;
import src.exercise_04.interfaces.Runnable;
import src.exercise_04.interfaces.UnitFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
