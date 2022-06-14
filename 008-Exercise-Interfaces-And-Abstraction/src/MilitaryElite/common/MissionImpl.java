package src.MilitaryElite.common;


import src.MilitaryElite.enumerations.State;
import src.MilitaryElite.interfaces.Mission;

public class MissionImpl implements Mission {
    private final String codeName;
    private final State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
