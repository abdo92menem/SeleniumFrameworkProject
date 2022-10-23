package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserLoginTest extends TestBase {
	HomePage home;
	UserLoginPage loginPage;
	
	@Test
	public void userLoginSuccefully() {
		home = new HomePage(driver);
		home.openLoginPage();
		
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin("Abdullah1234@test.com", "Abdo92@@##");
	}	
}
