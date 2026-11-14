package BarracksWars.core.commands;

import BarracksWars.contracts.Inject;
import BarracksWars.contracts.Repository;
import BarracksWars.contracts.UnitFactory;

public class AddCommand extends CommandImpl {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        this.repository.addUnit(this.unitFactory.createUnit(this.getData()[1]));

        return this.getData()[1] + " added!";
    }
}
