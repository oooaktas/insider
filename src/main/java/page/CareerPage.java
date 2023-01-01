package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage extends BasePage {
    public CareerPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIND_YOUR_DREAM_JOB_BUTTON = By.xpath("(//a[@href=\"https://useinsider.com/open-positions/\"])[1]");
    private static final By FIND_YOUR_CALLING_BLOCK = By.xpath("//*[@id=\"career-find-our-calling\"]");
    private static final By SEE_ALL_TEAMS_BUTTON = By.xpath("//a[text()='See all teams']");
    private static final By OUR_LOCATIONS_BLOCK = By.xpath("//img[@alt=\"New York\"]");
    private static final By LIFE_AT_INSIDER_BLOCK = By.xpath("//*[text()=\"Life at Insider\"]");
    private static final By END_OF_PAGE_ELEMENT = By.xpath("//input[@value=\"Submit\"]");
    private static final By QUALITY_ASSURANCE = By.xpath("//*[text()=\"Quality Assurance\"]");
    private static final By ALL_QA_JOBS = By.xpath("//*[text()=\"See all QA jobs\"]");

    public boolean isDisplayedCareerPage(){
        findElement(FIND_YOUR_DREAM_JOB_BUTTON).isDisplayed();
        return true;
    }
    public void isDisplayedTeams(){
        scrollExecure(FIND_YOUR_CALLING_BLOCK);
    }

    public void isDisplayedOurLocations() {
        scrollExecure(OUR_LOCATIONS_BLOCK);
    }

    public void isDisplayedLifeAtInsider() {
        scrollExecure(LIFE_AT_INSIDER_BLOCK);
    }

    public void clickAllTeamsButton() {
        clickWithJS(findElement(SEE_ALL_TEAMS_BUTTON));

    }

    public void clickQualityAssuranceBox() {
        clickWithJS(findElement(QUALITY_ASSURANCE));
    }

    public QAPositionsPage clickAllQAJobs(){
        clickWithJS(findElement(ALL_QA_JOBS));
        return new QAPositionsPage(driver);
    }
}
