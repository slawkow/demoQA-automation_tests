package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyBase {
    Properties prop = new Properties();
    InputStream input;

    public PropertyBase() {
    }

    public String getProperty(String propertyName) {
        try {
            String filename = "project.properties";
            input = PropertyBase.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop.getProperty(propertyName);
    }
}
