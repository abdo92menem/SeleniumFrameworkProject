package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSVFiles extends TestBase {

	HomePage homePage;
	UserRegistrationPage registerPage;
	UserLoginPage loginPage;

	CSVReader reader;

	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() throws CsvValidationException, IOException {
		// get csv file path
		String csv_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(csv_file));

		String[] csvCell;

		while((csvCell = reader.readNext()) != null) {

			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];

			homePage = new HomePage(driver);
			homePage.openRegistrationPage();

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
}