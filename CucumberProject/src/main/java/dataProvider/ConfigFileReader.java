package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader{

    private final String propertyFilePath = "src/main/configs/elemconfiguration.properties";
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("file not found");
        }
        // return properties;
    }

    public String getDemoUrl() {
        String driverPath = properties.getProperty("demourl");

        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getProperty(String elemposition) {
        String elemPath = properties.getProperty(elemposition);
        return elemPath;
    }
}
