package src.exercise_05.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
