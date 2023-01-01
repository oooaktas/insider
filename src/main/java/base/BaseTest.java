package base;

import helper.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver webDriver = null;

    @BeforeTest
    public void setUp() throws IOException {

        Properties properties = ConfigReader.readBrowserConfig();
        if ("chrome".equals(properties.getProperty("browser"))) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            webDriver = new ChromeDriver(options);
        } else if ("firefox".equals(properties.getProperty("browser"))) {
            System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
            FirefoxOptions options1 = new FirefoxOptions();
            webDriver = new FirefoxDriver(options1);
            webDriver.manage().window().maximize();
        }
        webDriver.get("https://useinsider.com/");
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {webDriver.quit();}
    public WebDriver getWebDriver(){return webDriver;}
}
