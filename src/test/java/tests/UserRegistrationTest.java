package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;
	String firstName = "Abdullah";
	String secondName = "Abdelmonem";
	String email = "AbdullahbMen3em566@test.com";
	String password = "password";
	
	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(firstName, secondName, email, password);
		
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userRegisteredSuccefully"})
	public void registeredUserCanLogout() {
		registerPage.userLogout();
	} 
	
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void userLoggedInSuccefully() {
		homePage.openLoginPage();
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin(email, password);
		Assert.assertTrue(registerPage.logoutBtn.isDisplayed());
	}
}