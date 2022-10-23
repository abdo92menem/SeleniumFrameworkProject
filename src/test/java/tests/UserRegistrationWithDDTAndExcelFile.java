package tests; 

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcelFile extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException {
		
		// get data from Excel reader class
		ExcelReader excelReader = new ExcelReader();

		return excelReader.getExcelDate();

	}
	
	@Test(priority=1, alwaysRun=true, dataProvider = "ExcelData")
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
		Assert.assertTrue(registerPage.logoutBtn.isDisplayed());
		
		registerPage.userLogout();
	}
}