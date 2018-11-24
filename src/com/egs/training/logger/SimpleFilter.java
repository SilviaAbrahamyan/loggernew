package com.egs.training.logger;

public class SimpleFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return true;
    }
}
