package src.interfaces;

import src.enums.ReportLevel;

public interface Appender {
    void append(String time, String message, ReportLevel reportLevel);
}
