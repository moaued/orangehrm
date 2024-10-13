package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.Helper;


public class SearchUserTest extends TestBase {
	String empn=Helper.readEmpNumberFromJsonFile();
    LoginPage loginObject;
HomePage homeobject;

    @Test(priority = 2, alwaysRun = true)
    public void RegisteredUserCanLogin() {
        loginObject = new LoginPage(driver); 
        loginObject.UserLogin("admin", "admin123");
        // Ensure these credentials are valid for your test
    }
    
    @Test(dependsOnMethods= {"RegisteredUserCanLogin"})
    public void ClickonPim() {
        homeobject = new HomePage(driver); 
        homeobject.NegativeToHomePage(); // Ensure these credentials are valid for your test
    }
    @Test(dependsOnMethods= {"ClickonPim"})
    public void SearchForEmployee() {
      
//        empNumberUser.useEmpNumber();
        homeobject = new HomePage(driver); 
        homeobject.SearchUsingEmployeeId(empn); // Ensure these credentials are valid for your test
    }
}
