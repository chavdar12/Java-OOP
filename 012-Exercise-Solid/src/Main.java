package src;

import src.interfaces.Appender;
import src.interfaces.File;
import src.interfaces.Layout;
import src.interfaces.Logger;
import src.models.*;

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);


        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);


        Logger logger = new MessageLogger(consoleAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

    }
}
