package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver = null;

    public BasePage (WebDriver driver){
        this.driver=driver;
    }

    protected WebElement findElement (By by){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            return driver.findElement(by);
        }catch (Exception e) {
            Assert.fail();
        }
        return null;
    }
    protected void sendKeys (String str, By by) {
        findElement(by).sendKeys(str);
    }
    protected void click(By by){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        findElement(by).click();
    }
    protected void scrollToElement(By by){
        Actions actions = new Actions(driver);
        WebElement element = findElement(by);
    }
    protected void isPresent(By by){
        try {
            findElement(by);
        }catch (Exception e){
            scrollToElement(by);
        }
    }
    protected void scrollExecure(By by){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jsExecutor("arguments[0].scrollIntoView(true);",by);
    }
    private void jsExecutor(String str,By by){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(str,findElement(by));
    }
    private void waitSleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickWithJS(WebElement element) {
        waitSleep(5000L);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

}
