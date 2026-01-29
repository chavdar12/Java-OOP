package KingsGambit;


import KingsGambit.interfaces.Defender;
import KingsGambit.interfaces.Target;

import java.util.Map;

public class King extends Unit implements Target {

    private final Map<String, Defender> guards;

    public King(String name, Map<String, Defender> guards) {
        super(name);
        this.guards = guards;
    }


    @Override
    public void onAttacked() {
        System.out.printf("King %s is under attack!%n", this.getName());
        this.fireOnAttackEvent();
    }

    private void fireOnAttackEvent() {
        for (Map.Entry<String, Defender> guard : guards.entrySet()) {
            System.out.println(guard.getValue().respondToAttack());
        }
    }
}
