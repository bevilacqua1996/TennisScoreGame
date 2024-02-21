package org.bevilacqua1996.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesSingleton {

    private static Properties appProps;

    private PropertiesSingleton() {
        InputStream rootPath = Objects.requireNonNull(this.getClass().getClassLoader()
                .getResourceAsStream("app.properties"));

        try {
            appProps = new Properties();
            appProps.load(rootPath);
        } catch (IOException e) {
            throw new RuntimeException("Error on reading Properties", e);
        }
    }

    public static Properties getInstance() {
        if(appProps== null || appProps.isEmpty()) {
            PropertiesSingleton propertiesSingleton = new PropertiesSingleton();
            return appProps;
        }

        return appProps;

    }

}
