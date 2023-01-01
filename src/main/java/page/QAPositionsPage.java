package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class QAPositionsPage extends BasePage {
    private static final By DROPDOWN_FIRST = By.xpath("//*[@id=\"select2-filter-by-location-container\"]");
    private static final By DROPDOWN_BOX_ISTANBUL = By.xpath("//*[contains(@data-select2-id,\"Istanbul, Turkey\")]");
    private static final By APPLY_NOW = By.xpath("(//*[text()=\"Apply Now\"])[1]");
    private static final By APPLY_FOR_THIS_JOB = By.xpath("//*[text()=\"Software Quality Assurance Engineer (Remote)\"]");
    private static final By SWIPE = By.xpath("(//b[@role=\"presentation\"])[1]");
    private static final By REMOVE = By.xpath("(//*[@title=\"Remove all items\"])[1]");
    private static final By LEFT = By.xpath("(//i[@class=\"icon-arrow-left\"])[1]");

    public void clickDropdown(){
        clickWithJS(findElement(DROPDOWN_FIRST));
    }
    public void selectIstanbul(){
        click(DROPDOWN_FIRST);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickWithJS(findElement(DROPDOWN_BOX_ISTANBUL));

        click(DROPDOWN_BOX_ISTANBUL);
    }
    public void clickApplyNow(){
        clickWithJS(findElement(APPLY_NOW));
    }
    public boolean checkJobPage(){
        return findElement(APPLY_FOR_THIS_JOB).isDisplayed();
    }
    public QAPositionsPage(WebDriver driver) {
        super(driver);
    }

}
