package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Helper;

public class jopPage extends PageBase {
	 public jopPage(WebDriver driver) {
	        super(driver);
	    }
	 String startdate=Helper.getTodayDate();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   private By jop = By.xpath("//a[@class='orangehrm-tabs-item'][contains(.,'Job')]"); 
private By JoinedDate= By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
private By JobTitle= By.xpath("(//div[contains(@class,'oxd-select-text--after')])[1]");
private By b=By.xpath ("//*[contains(text(),'Software Engineer')]");

private By IncludeEmploymentContractDetails= By.xpath("//span[contains(@class,'oxd-switch-input oxd-switch-input--active --label-right')]");
	   private By start=By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[3]");
// Page actions
	    public void EditJobDetails() throws InterruptedException {
	    	clickButton(driver.findElement(jop));
//	    	driver.findElement(JoinedDate).sendKeys("2015-06-15");
	    	  setTextElementText(driver.findElement(JoinedDate),"2015-06-15");
	    	  clickButton(driver.findElement(JobTitle));
	    	  Thread.sleep(2000);
	    	
//	    	  scrollIntoViewElement(driver.findElement(e));
//	    	  wait.until(ExpectedConditions.visibilityOfElementLocated(e));
	    	  scrollIntoViewElement(driver.findElement(b));
//	    	  wait.until(ExpectedConditions.visibilityOfElementLocated(b));
	    	  clickButton(driver.findElement(b));
//	    	  
	    	// located element with contains()
//	    	  WebElement m = driver.findElement (By.xpath ("//*[contains(text(),'Get started ')]"));
	    			clickButton(driver.findElement(IncludeEmploymentContractDetails));
	    			  setTextElementText(driver.findElement(start),startdate);
	    }
}
