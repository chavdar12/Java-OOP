package src.exercise_04.core.commands;

import src.exercise_04.interfaces.Repository;
import src.exercise_04.interfaces.UnitFactory;

public class Fight extends Command {

    public Fight(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String execute() {
        // TODO Auto-generated method stub
        return "fight";
    }


}
