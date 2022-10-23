package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	
	HomePage homePage;
	UserRegistrationPage registerPage;
	
	@Given("The user in the home page")
	public void the_user_in_the_home_page() {
		
		
	}
	
	@When("I click on reigster link")
	public void i_click_on_reigster_link() {
		
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
//	@When("I entered the user date")
//	public void i_entered_the_user_date() {
//		
//		registerPage = new UserRegistrationPage(driver);
//		registerPage.registerNewUser("Abdullah", "Menem", "ab33do@test.com", "password");
//	}
	
	@When("I entered {string}, {string}, {string}, {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(firstname, lastname, email, password);
	}
	
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		
		registerPage.userLogout();
	}
}
