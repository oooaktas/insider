package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By homeIcon = By.id("navigation");
    private static final By moreButton = By.xpath("//span[text()=\"More\"]");
    private static final By careerButton = By.xpath("//a[contains(@href,\"careers\")]");
    private static final By COOKIES_BUTTON = By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]");

    public void isPresent(){
        isPresent(homeIcon);
    }
    public void clickMore(){
        click(moreButton);
    }
    public CareerPage clickCareer(){
        click(careerButton);
        return new CareerPage(driver);
    }
    public void clickAcceptCookies(){
        try{
            click(COOKIES_BUTTON);
        }catch (Exception e){

        }

    }
}
