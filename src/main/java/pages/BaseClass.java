package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;


public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite(){
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();

        ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports/FreeCRM.html"));
        report  = new ExtentReports();
        report.attachReporter(extent);
    }

    @BeforeClass
    public void setup(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getqaURL());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){ //ITestResult is an interface
         if(result.getStatus()==ITestResult.FAILURE) { //result variable will have all the info as soon as TC is complete
             Helper.captureScreenshot(driver);
         }
        if(result.getStatus()==ITestResult.SUCCESS) {
            Helper.captureScreenshot(driver);
        }
        //flush the report
        report.flush();
    }
}
