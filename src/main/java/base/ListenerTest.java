package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static base.BaseTest.webDriver;

public class ListenerTest implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        //Create an html report for the suite that is executed
    }

    @Override
    public void onFinish(ISuite suite) {

    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }


    @Override
    public void onTestFailure(ITestResult result) {
        try {

            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String fileName = String.format("Screenshot-%s", Calendar.getInstance().getTimeInMillis());
            try {
                FileHandler.copy(source, new File("./screenshots/" + fileName + ".png"));
                System.out.println("Screenshot taken");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}