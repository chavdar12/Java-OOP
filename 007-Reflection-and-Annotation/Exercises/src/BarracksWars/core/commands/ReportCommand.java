package BarracksWars.core.commands;

import BarracksWars.contracts.Inject;
import BarracksWars.contracts.Repository;


public class ReportCommand extends CommandImpl {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
