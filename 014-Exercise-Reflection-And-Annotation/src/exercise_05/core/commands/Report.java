package src.exercise_05.core.commands;

import src.exercise_05.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();

    }

}
