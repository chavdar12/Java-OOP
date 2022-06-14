package src.exercise_04.core.commands;

import src.exercise_04.interfaces.Repository;
import src.exercise_04.interfaces.Unit;
import src.exercise_04.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }

}
