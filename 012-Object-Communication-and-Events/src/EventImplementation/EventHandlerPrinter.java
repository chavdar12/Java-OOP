package EventImplementation;

public class EventHandlerPrinter implements NameChangeListener {
    @Override
    public void handleOnNameChanged(Event event) {
        System.out.printf("Dispatcher's name changed to %s.%n", event.getChangeName());
    }
}
