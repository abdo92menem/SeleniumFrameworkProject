package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSONFiles extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;
	
	
	
	
	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() throws FileNotFoundException, IOException, ParseException {
		JSONDataReader jsonReader = new JSONDataReader();
		jsonReader.readJsonData();
		
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(jsonReader.firstName, jsonReader.lastName, jsonReader.email, jsonReader.password);
		
		Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
		
		registerPage.userLogout();
		
		homePage.openLoginPage();
		loginPage = new UserLoginPage(driver);
		loginPage.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerPage.logoutBtn.isDisplayed());
		
		registerPage.userLogout();
	}
}