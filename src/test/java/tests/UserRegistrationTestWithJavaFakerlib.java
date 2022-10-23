package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFakerlib extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;
	
	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		Faker fakeData = new Faker();
		String firstName = fakeData.name().firstName();
		System.out.println(firstName);
		String lastName = fakeData.name().lastName();
		System.out.println(lastName);
		String email = fakeData.internet().emailAddress();
		System.out.println(email);
		String password = fakeData.number().digits(8).toString();
		System.out.println(password);
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(firstName, lastName, email, password);
		
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
		
		registerPage.userLogout();

		homePage.openLoginPage();
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin(email, password);
		Assert.assertTrue(registerPage.logoutBtn.isDisplayed());

		registerPage.userLogout();
	}
}