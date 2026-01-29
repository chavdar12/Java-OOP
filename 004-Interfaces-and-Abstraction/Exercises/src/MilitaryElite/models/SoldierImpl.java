package MilitaryElite.models;

import MilitaryElite.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
    private final int id;
    private final String firstName;
    private final String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d", this.firstName, this.lastName, this.getId());
    }
}
