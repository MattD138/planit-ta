// Helper utility for retrieving config properties from config.properties

package com.planit.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(file);
        } catch (IOException e) {
            // Todo: can be improved with better logging
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
