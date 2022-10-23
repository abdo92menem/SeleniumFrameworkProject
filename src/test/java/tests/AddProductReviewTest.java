package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ReviewPage;
import pages.Search;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	HomePage homePage;
	UserRegistrationPage registerPage;
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	ReviewPage reviewPage;
	
	String firstName = "Abdullah";
	String lastName = "Abdelmonem";
	String email = "AbdullahMen3em92555@test.com";
	String password = "password";
	
	String reviewTitle = "Abdullah Review";
	String reviewText = "Good Product";
	
	@Test
	public void userCanRateProduct() {
		homePage = new HomePage(driver);
		registerPage = new UserRegistrationPage(driver);
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		reviewPage = new ReviewPage(driver);
		
		// open register page
		homePage.openRegistrationPage();
		
		// register as a new user
		registerPage.registerNewUser(firstName, lastName, email, password);
		
		// search for a product
		searchObject.productSearchUsingAutocomplete("mac");
		
		// open add review page from product details page
		productDetailsPage.openReviewPage();
		
		// add review and submit
		reviewPage.makeReviewAndSubmit(reviewTitle, reviewText);
		
		System.out.println(reviewPage.reviewResultTitle.getText());
		System.out.println(reviewPage.reviewResultText.getText());
		
		// check if the title and review added are equal to the result
		Assert.assertEquals(reviewPage.reviewResultTitle.getText(), reviewTitle);
		Assert.assertEquals(reviewPage.reviewResultText.getText(), reviewText);
	}
}
