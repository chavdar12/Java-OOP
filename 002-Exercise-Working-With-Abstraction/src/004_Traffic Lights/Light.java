package TrafficLights;

public class Light {
    private Signal signal;

    public Light(Signal signal) {
        this.signal = signal;
    }

    public void changeSignal() {
        switch (this.signal.name()) {
            case "RED" -> this.signal = Signal.GREEN;
            case "YELLOW" -> this.signal = Signal.RED;
            case "GREEN" -> this.signal = Signal.YELLOW;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}