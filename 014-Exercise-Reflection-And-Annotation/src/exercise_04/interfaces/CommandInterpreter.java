package src.exercise_04.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
