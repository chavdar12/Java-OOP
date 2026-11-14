package BarracksWars.contracts;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data);
}
