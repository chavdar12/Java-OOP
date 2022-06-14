package src.exercise_03.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
