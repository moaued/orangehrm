package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
  //input[contains(@name,'username')]
    
 
   
    // Define WebElements directly using By locators
    private By usernameInput = By.xpath("//input[contains(@name,'username')]"); // Replace with the actual ID
    private By passwordInput = By.xpath("//input[contains(@type,'password')]"); // Replace with the actual ID
    private By loginButton = By.xpath("//button[@type='submit']"); // Replace with the actual XPath

    // Page actions
    public void UserLogin(String username, String password) {
        setTextElementText(driver.findElement(usernameInput), username);
        setTextElementText(driver.findElement(passwordInput), password);
        clickButton(driver.findElement(loginButton));
    }
}
