package src.exercise_05.core.commands;

import src.exercise_05.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        this.data = data;
    }
}
