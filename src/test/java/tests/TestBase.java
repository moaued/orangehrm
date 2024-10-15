package tests;

import java.util.concurrent.TimeUnit;
import pages.LoginPage;
import utilities.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void startDriver() {
     

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        
        // Browser setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterSuite
    public void stopDriver() {
        if (driver != null) {
        	
            driver.quit(); // Ensure driver quits
        }
    }

    // Take a screenshot when a test case fails
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed: " + result.getName());
            System.out.println("Taking screenshot...");
            // Uncomment and implement the Helper class for taking screenshots
             Helper.captureScreenshot(driver, result.getName());
        }
    }
}
