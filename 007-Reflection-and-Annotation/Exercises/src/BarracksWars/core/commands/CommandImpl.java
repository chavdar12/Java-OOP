package BarracksWars.core.commands;

import BarracksWars.contracts.Executable;

public abstract class CommandImpl implements Executable {
    private final String[] data;

    protected CommandImpl(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return data;
    }

}
