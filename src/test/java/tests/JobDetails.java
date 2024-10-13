package tests;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import pages.EditUserPage;
import pages.jopPage;

public class JobDetails extends TestBase {
	jopPage  EditJobDetailsobject;
	 @Test 
		public void Editjop() throws InterruptedException {
			
		 EditJobDetailsobject = new jopPage(driver); 
		 EditJobDetailsobject.EditJobDetails(); 
	

			
	    }
}
