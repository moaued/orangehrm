package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class EditUserPage extends PageBase {

	public EditUserPage(WebDriver driver) {
        super(driver);
    }
	
	private  By editicone=  By.xpath("(//button[contains(@class,'oxd-icon-button oxd-table-cell-action-space')])[1]");
	
	private  By contactDetails= By.xpath("//a[normalize-space()='Contact Details']");
	private By street1=By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[1]//div[1]//div[2]//input[1]");
	
	private By save= By.xpath("//button[@type='submit'][contains(.,'Save')]");
	private By susucessmessage=By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text'][contains(.,'Successfully Updated')]");
	private By addattachment=By.xpath("//button[@type='button'][contains(.,'Add')]");
	private By chooseFile=By.xpath("//input[@class='oxd-file-input']");
	  public void Edituser(String street) throws InterruptedException {
		  Thread.sleep(2000);
		  scrollIntoViewElement(driver.findElement(editicone));
	        driver.findElement(editicone).click();
	       
	        clickButton(driver.findElement(contactDetails));
	        setTextElementText(driver.findElement(street1), street);
	        scrollIntoViewElement(driver.findElement(addattachment));
	        clickButton(driver.findElement(addattachment));
	        Thread.sleep(10000);
	        setTextElementText(driver.findElement(chooseFile), "src/test/resources/testData/imges/21.08.2024_09.06.03_REC.png");
	        try {
	            TimeUnit.SECONDS.sleep(2000); // Sleep for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        clickButton(driver.findElement(save));
	        String text=driver.findElement(susucessmessage).getText();
	        String expectedText = "Successfully Updated";
	        Assert.assertEquals(text,expectedText);
	    }
	
}
