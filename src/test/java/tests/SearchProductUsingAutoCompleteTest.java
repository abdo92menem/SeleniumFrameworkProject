package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Search;

public class SearchProductUsingAutoCompleteTest extends TestBase{
	
	String searchTxt = "mac";
	String productName = "Apple MacBook Pro 13-inch";
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	
	@Test
	public void userCanSearchForProduct() {
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutocomplete(searchTxt);
		System.out.println(productDetailsPage.productName.getText());
		Assert.assertEquals(productDetailsPage.productName.getText(), productName);
	}
}
