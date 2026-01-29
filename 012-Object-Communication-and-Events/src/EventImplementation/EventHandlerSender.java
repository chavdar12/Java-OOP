package EventImplementation;

public class EventHandlerSender implements NameChangeListener {
    @Override
    public void handleOnNameChanged(Event event) {
        System.out.printf("Sending on the web...%n", event.getChangeName());
    }
}
