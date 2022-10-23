package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;
	
	
	@DataProvider(name="testData")
	public static Object[][] userData() {
		return new Object[][] {
			{"Abdullah", "Abdel menem", "abdullah@test.com", "password"},
			{"Ahmed", "Ali", "ali3lah@test.com", "password"}
		};
	}
	
	
	@Test(priority=1, alwaysRun=true, dataProvider = "testData")
	public void userRegisteredSuccefully(String firstName, String secondName, String email, String password) {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(firstName, secondName, email, password);
		
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
		
		registerPage.userLogout();
		
		homePage.openLoginPage();
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin(email, password);
		
		registerPage.userLogout();
	}
}