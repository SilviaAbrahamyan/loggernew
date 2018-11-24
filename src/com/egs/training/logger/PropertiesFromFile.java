package com.egs.training.logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by user on 12/27/2017.
 */
public class PropertiesFromFile {

    private String loggerLevel;
    private String loggerHandler;
    private String loggerHandlerFileName;
    Properties properties = new Properties();

    static PropertiesFromFile propertyFromFile;

    private PropertiesFromFile(){  }

    public static synchronized PropertiesFromFile getPropertyInstance(){
        if (propertyFromFile==null){
            propertyFromFile=new PropertiesFromFile();
            try {
                propertyFromFile.getProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return propertyFromFile;
        }
        else{
            try {
                propertyFromFile.getProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return propertyFromFile;
        }
    }



    public void getProperties() throws IOException {
        File file = new File("src/com/egs/training/logger/logger.properties");
        Reader reader = new FileReader(file);

        properties.load(reader);

        loggerLevel = properties.getProperty("logger.level");
        loggerHandler = properties.getProperty("logger.handler");
        loggerHandlerFileName = properties.getProperty("logger.handler.file.name");
    }

    public String getLoggerLevel() {
        return loggerLevel;
    }

    public String getLoggerHandler() {
        return loggerHandler;
    }

    public String getLoggerHandlerFileName() {
        return loggerHandlerFileName;
    }
}
