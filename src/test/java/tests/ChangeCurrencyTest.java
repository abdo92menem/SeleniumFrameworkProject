package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Search;

public class ChangeCurrencyTest extends TestBase {
	
	String searchTxt = "mac";
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	
	@Test
	public void userCanChangeCurrency() {
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutocomplete(searchTxt);
		productDetailsPage.changeCurrency();
		System.out.println(productDetailsPage.productPrice.getText());
		Assert.assertTrue(productDetailsPage.productPrice.getText().contains("€"));
	}
}
