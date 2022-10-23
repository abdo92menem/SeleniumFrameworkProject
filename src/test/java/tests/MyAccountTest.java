package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homePage;
	UserRegistrationPage registerPage;
	MyAccountPage myAccountPage;
	UserLoginPage loginPage;
	String firstName = "Abdullah";
	String secondName = "Abdelmonem";
	String email = "AbdullahMen3sem1192@test.com";
	String oldPassword = "password";
	String newPassword = "newpassword";
	
	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(firstName, secondName, email, oldPassword);
		
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
		registerPage.openMyAccountPage();
	}
	
	@Test(dependsOnMethods= {"userRegisteredSuccefully"})
	public void registeredUserCanChangePassword() {
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.openChangePasswordPage();
		myAccountPage.changePassword(oldPassword, newPassword);
		System.out.println(myAccountPage.resultMsg.getText());
		Assert.assertTrue(myAccountPage.resultMsg.getText().equals("Password was changed"));
		
		myAccountPage.closeMessageBar();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanChangePassword"})
	public void registeredUserCanLogout() {
		registerPage.userLogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void userLoggedInSuccefully() {
		homePage.openLoginPage();
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin(email, newPassword);
//		Assert.assertTrue(registerPage.logoutBtn.isDisplayed());
	}
}
