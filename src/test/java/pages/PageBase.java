package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PageBase {
    public WebDriver driver; 
    public JavascriptExecutor js; 
    public Select select; 
    public Actions action; 
    public WebDriverWait wait;
  
    public PageBase(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void clickButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)); // Wait until the button is clickable
        button.click();
    }

    public void setTextElementText(WebElement textElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(textElement)); // Wait until the element is visible
        textElement.sendKeys(value);
    }

    public void scrollToBottom() {
        js.executeScript("scrollBy(0,2500)"); 
    }
    public void scrollIntoViewElement(WebElement element) {
 
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
    
    
    
    
    
    
    
    
}
    
    
    
    