package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties readBrowserConfig() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(inputStream);
        return properties;
    }
}
