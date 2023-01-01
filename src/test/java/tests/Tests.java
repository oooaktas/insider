package tests;

import base.BaseTest;
import base.ListenerTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.CareerPage;
import page.HomePage;
import page.QAPositionsPage;


@Listeners(ListenerTest.class)
public class Tests extends BaseTest {
    HomePage homePage;
    CareerPage careerPage;
    QAPositionsPage qaPositionsPage;

    @BeforeTest
    public void before(){
        homePage = new HomePage(getWebDriver());
    }

    @Test(priority = 1)
    public void homePageDisplayed(){
        homePage.isPresent();
    }

    @Test(priority = 2)
    public void moreMenuPresent(){
        homePage.clickAcceptCookies();
        homePage.clickMore();
        careerPage = homePage.clickCareer();
        Assert.assertTrue(careerPage.isDisplayedCareerPage());
    }

    @Test(priority = 3)
    public void careerPageDisplayed(){
        homePage.clickAcceptCookies();
        homePage.clickMore();
        careerPage = homePage.clickCareer();
        careerPage.isDisplayedTeams();
        careerPage.isDisplayedOurLocations();
        careerPage.isDisplayedLifeAtInsider();
    }

    @Test(priority = 4)
    public void checkIstanbulJobs(){
        homePage.clickAcceptCookies();
        homePage.clickMore();
        careerPage = homePage.clickCareer();
        careerPage.isDisplayedCareerPage();
        careerPage.isDisplayedTeams();
        careerPage.isDisplayedOurLocations();
        careerPage.isDisplayedLifeAtInsider();
        careerPage.clickAllTeamsButton();
        careerPage.clickQualityAssuranceBox();
        qaPositionsPage = careerPage.clickAllQAJobs();
        qaPositionsPage.clickDropdown();
        qaPositionsPage.selectIstanbul();
        qaPositionsPage.clickApplyNow();
        Assert.assertTrue(qaPositionsPage.checkJobPage());
    }
}
