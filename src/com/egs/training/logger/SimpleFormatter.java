package com.egs.training.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class SimpleFormatter implements Formatter {
    @Override
    public String format(LogRecord logRecord) {
        final String formatted = String.format("%s [%s]: %s -  %s", new Date(logRecord.getTime()).toString(), logRecord.getLevel(),
                logRecord.getLoggerName(), logRecord.getMessage());

        if (logRecord.getThrown() != null) {

            try (PrintWriter writer = new PrintWriter(new StringWriter())) {
                writer.println(formatted);

                logRecord.getThrown().printStackTrace(writer);

                return writer.toString();
            }
        }

        return formatted;
    }
}
