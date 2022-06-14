package src.exercise_03.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

    void addUnit(Unit unit);

    String getStatistics();

    void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
