package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.Search;
import pages.ShoppingCartPage;
import tests.TestBase;

public class End2EndTests extends TestBase {
	
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutPage;
	OrderDetailsPage orderDetailsPage;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	@Given("user is on home page")
	public void  user_is_on_home_page() {
		
//		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nobcommerce.com"));
	}
	
	@When("he search for {string}")
	public void he_search_for(String productName) {
		
		searchObject = new Search(driver);
		searchObject.productSearchUsingAutocomplete(productName);
		productDetailsPage = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsPage.productName.getText().equals(productName));
	}
	
	@When("choose to buy two items")
	public void choose_to_buy_two_items() {
		cartPage = new ShoppingCartPage(driver);
		productDetailsPage.addProductToShoppingCart();
		productDetailsPage.openShoppingCartPage();
	}
	
	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutPage = new CheckoutPage(driver);
		cartPage.openCheckoutPage();
		checkoutPage.CheckoutProductAsGuest("test", "user", "Egypt", "tset@test.com", "address", "123456", "3221457755", "Cairo", productName);
		checkoutPage.confirmOrder();
		Assert.assertTrue(checkoutPage.thankYouLbl.isDisplayed());
	}
	
	@Then("he can view the order and download the incoice")
	public void he_can_view_the_order_and_download_the_incoice() throws InterruptedException {
		orderDetailsPage = new OrderDetailsPage(driver);
		checkoutPage.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsPage.downloadPDFInvoice();
		orderDetailsPage.printOrderDetails();
	}
	
	
	
	
}	
