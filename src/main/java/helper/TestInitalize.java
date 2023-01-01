package helper;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestInitalize {
    @BeforeSuite(alwaysRun = true)
    public void Initialize() throws IOException {
        ConfigReader.readBrowserConfig();

    }
}
