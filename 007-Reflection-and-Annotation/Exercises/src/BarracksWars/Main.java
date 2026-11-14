package BarracksWars;

import BarracksWars.contracts.Repository;
import BarracksWars.contracts.Runnable;
import BarracksWars.contracts.UnitFactory;
import BarracksWars.core.CommandInterpreterImpl;
import BarracksWars.core.Engine;
import BarracksWars.core.factories.UnitFactoryImpl;
import BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
        engine.run();
    }
}
