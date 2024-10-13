package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	


	   private By pim = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']"); 
private By EmployeeId= By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
private By SearchButton= By.xpath("//button[@type='submit'][contains(.,'Search')]");
	    // Page actions
	    public void NegativeToHomePage() {
	    	clickButton(driver.findElement(pim));
	        
	    }
	    
	    
	    
	    
	    public void SearchForTheEmployee() {
	    	clickButton(driver.findElement(pim));
	        
	    }
	    public void SearchUsingEmployeeId(String id) {
	    	
	    	  setTextElementText(driver.findElement(EmployeeId), id);
	    	  clickButton(driver.findElement(SearchButton));
	        
	    }
//	public Select getCountrySelect() {
//		  return new Select(dropdownList);
//		}

}