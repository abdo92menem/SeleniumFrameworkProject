package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Search;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase{
	
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	WishlistPage wishlistPage;
	
	@Test
	public void userCanAddProductToWishlist() {
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		wishlistPage = new WishlistPage(driver);
		
		searchObject.productSearchUsingAutocomplete("mac");
		productDetailsPage.addProductToWishlist();
		productDetailsPage.openWishlistPage();
		
		Assert.assertEquals("Apple MacBook Pro 13-inch", wishlistPage.productName.getText());
	}
}
