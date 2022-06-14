package src.exercise_05.core.commands;

import src.exercise_05.interfaces.Repository;
import src.exercise_05.interfaces.Unit;
import src.exercise_05.interfaces.UnitFactory;


public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory factory;

    public Add(String[] data) {
        super(data);

    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.factory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }

}
