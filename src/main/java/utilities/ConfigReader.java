package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        try {
            // If your config file is inside src/test/resources
            FileInputStream ip = new FileInputStream("/Users/abhisheksharma/Downloads/SDETProjects/MagentoSeleniumFramework/src/test/java/resources/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load config.properties file.");
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
