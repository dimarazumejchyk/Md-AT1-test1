package com.it_academy.catalogOnlinerTests.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_FILE = "/endpoints.properties";
    private static final Properties ENDPOINT_PROPERTIES = new Properties();

    static {
        initProperties(ENDPOINT_PROPERTIES, ENDPOINTS_FILE);
    }
    public static String getEndpointProperty(String property) {
        return ENDPOINT_PROPERTIES.getProperty(property);

    }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try(InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);

        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to load properties from " + fileName);
        }
    }
}
