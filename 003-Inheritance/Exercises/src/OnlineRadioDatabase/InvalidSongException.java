package OnlineRadioDatabase;

public class InvalidSongException extends Throwable {
    private final String message;

    public InvalidSongException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
