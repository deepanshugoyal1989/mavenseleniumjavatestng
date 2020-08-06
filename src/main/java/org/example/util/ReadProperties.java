package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {


    private final Properties properties = new Properties();

    public ReadProperties() {

        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.PATH_TO_CONFIG_FILE);
            properties.load(fileInputStream);

        } catch (IOException e) {
            Log.getLogger().error("Error in reading config property file : "+e.getMessage());
        }

    }

    public String getProperty(String propertyKey) {
       return properties.getProperty(propertyKey);
    }
}
