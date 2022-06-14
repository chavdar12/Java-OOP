package src.exercise_05.core.commands;

import src.exercise_05.interfaces.Repository;

import javax.naming.OperationNotSupportedException;

public class Retire extends Command {
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String execute() {
        String type = this.getData()[1];

        String result;

        try {
            this.repository.removeUnit(type);
            result = type + " retired!";
        } catch (OperationNotSupportedException e) {
            result = e.getMessage();
        }

        return result;
    }

}
