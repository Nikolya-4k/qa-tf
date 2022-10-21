package org.example.utils;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();

    public static final String BROWSER = prop.getProperty("browser");
    public static final String BASE_URL = prop.getProperty("base.url");
    public static final int DRIVER_WAIT_TIMEOUT = Integer.parseInt(prop.getProperty("driver.wait.timeout"));

    public static final String SELENOID_HUB = prop.getProperty("selenoid.hub");

    public static final boolean isHighlight = Boolean.parseBoolean(prop.getProperty("highlight"));
    private ConfigProvider() {
    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + CONFIG_PATH);
        }
        return properties;
    }
}
