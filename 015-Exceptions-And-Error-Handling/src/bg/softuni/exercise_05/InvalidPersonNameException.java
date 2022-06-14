package bg.softuni.exercise_05;

public class InvalidPersonNameException extends Exception {
    public InvalidPersonNameException(String errorMessage) {
        super(errorMessage);
    }
}
