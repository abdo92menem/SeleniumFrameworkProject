package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.Search;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckoutTest extends TestBase {
	
	/*
	 * 1- register user
	 * 2- search for product
	 * 3- add to cart
	 * 4- checkout
	 * 5- logout
	 */
	
	HomePage homePage;
	UserRegistrationPage registrationPage;
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;
	OrderDetailsPage orderDetailsPage;
	
	String firstName = "Abdullah";
	String secondName = "Abdelmonem";
	String email = "AbdullahMen31em1590@test.com";
	String password = "password";
	
	String productName = "Apple MacBook Pro 13-inch";
	
	String countryName = "Egypt";
	String cityName = "Cairo";
	String address = "Elsaff";
	String zipCode = "16856";
	String phoneNumber = "01122365547";
	
	@Test(priority=1)
	public void userRegisteredSuccefully() {
		homePage = new HomePage(driver);
		homePage.openRegistrationPage();
		
		registrationPage = new UserRegistrationPage(driver);
		registrationPage.registerNewUser(firstName, secondName, email, password);
		
		Assert.assertTrue(registrationPage.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void userCanAddProductToShoppingCartTest() {
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		
		searchObject.productSearchUsingAutocomplete(productName);
		
		productDetailsPage.addProductToShoppingCart();
		productDetailsPage.openShoppingCartPage();
		
		shoppingCartPage.openCheckoutPage();
	}
	
	@Test(priority=3)
	public void userCanCheckoutProduct() throws InterruptedException {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.registeredUserCheckoutProduct(countryName, cityName, address, zipCode, phoneNumber, productName);
		Assert.assertTrue(checkoutPage.productName.isDisplayed());
		Assert.assertTrue(checkoutPage.productName.getText().contains(productName));
	}
	
	@Test(dependsOnMethods={"userCanCheckoutProduct"})
	public void userCanConfirmCheckout() throws InterruptedException {
		checkoutPage.confirmOrder();
		Assert.assertTrue(checkoutPage.thankYouLbl.isDisplayed());
		Assert.assertTrue(checkoutPage.successMsg.isDisplayed());
		
		checkoutPage.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsPage = new OrderDetailsPage(driver);
		orderDetailsPage.downloadPDFInvoice();
		orderDetailsPage.printOrderDetails();
	}
	
	@Test(dependsOnMethods= {"userCanConfirmCheckout"})
	public void registeredUserCanLogout() {
		registrationPage.userLogout();
	} 
}
