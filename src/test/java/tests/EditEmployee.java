package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import pages.EditUserPage;
import utilities.Helper;


public class EditEmployee extends TestBase {
	EditUserPage  EditUserobject;
	String street=Helper.generateRandomStreetName();

	 @Test
	public void SearchForEmployee() throws NoAlertPresentException,InterruptedException {
		 System.out.println(street);
		 EditUserobject = new EditUserPage(driver); 
		 EditUserobject.Edituser(street); 
		 Thread.sleep(5000);

		
    }
}
