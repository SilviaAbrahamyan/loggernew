package com.egs.training.logger;

import java.util.HashMap;
import java.util.Map;

public final class LoggerFactory {
    private static final Map<String, Logger> loggers = new HashMap<>();

    private LoggerFactory() {
    }

    public static Logger getLogger(final String name) {
        PropertiesFromFile property=PropertiesFromFile.getPropertyInstance();
        String loggerLevel=property.getLoggerLevel();
        String loggerHandler=property.getLoggerHandler();
        String loggerHandlerFileName=property.getLoggerHandlerFileName();

//        you can achieve the same result with one line! using java8 Map.putIfAbsent ;)
//        return loggers.putIfAbsent(name, new Logger(name));
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        }
        // TODO later handler and formatter will be configured in a file
        else if ("file".equals(loggerHandler)){
            final Logger logger=new Logger(name, new FileHandler(loggerHandlerFileName));
            loggers.put(name,logger);
            return logger;

        }
        else if ("console".equals(loggerHandler)){
            final Logger logger = new Logger(name, new ConsoleHandler(new SimpleFormatter()));
            loggers.put(name, logger);
            return logger;
        }
        else {
            System.out.println("logger level is not correct");
            return null;
        }
    }
}
