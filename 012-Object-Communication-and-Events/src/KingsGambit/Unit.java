package KingsGambit;

public abstract class Unit {
    private final String name;


    protected Unit(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
