package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductEmailAFriend;
import pages.Search;
import pages.UserRegistrationPage;

public class ProductEmailAFriendTest extends TestBase {
	
	ProductEmailAFriend emailAFriendPage;
	HomePage homePage;
	UserRegistrationPage registerPage;
	Search searchPage;
	ProductDetailsPage productDetailsPage;
	
	// user registration
	String fName = "Abdullah";
	String sName = "AbdelMenem";
	String email = "Abdullah195s2@test.com";
	String password = "password";
	
	// search box
	String searchWord = "mac";
	
	// email friend form
	String friendEmail = "Ahmed@test.com";
	String personalMsg = "This website is good";
	
	@Test(priority=1, alwaysRun=true)
	public void userRegisteredSuccefully() {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registerPage = new UserRegistrationPage(driver);
		registerPage.registerNewUser(fName, sName, email, password);
	}
	
	@Test(priority=2)
	public void userCanSearchForProduct() {
		searchPage = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		searchPage.productSearchUsingAutocomplete(searchWord);
		productDetailsPage.openEmailFriendPage();
	}
	
	@Test(priority=3)
	public void emailAFreiendTest() {
		
		emailAFriendPage = new ProductEmailAFriend(driver);
		emailAFriendPage.fillEmailAFriendForm(friendEmail, personalMsg);
		
		Assert.assertEquals(emailAFriendPage.resultMsg.getText(), "Your message has been sent.");
	}
}
