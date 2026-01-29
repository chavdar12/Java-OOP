package Ferrari;

public class Ferrari implements Car {
    private final String driverName;
    private final String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    public String brakes() {
        return "Brakes!";
    }

    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model, this.brakes(), this.gas(), this.driverName);
    }
}
