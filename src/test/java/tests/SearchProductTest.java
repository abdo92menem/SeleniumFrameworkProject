package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchResultsPage;
import pages.Search;

public class SearchProductTest extends TestBase{
	
	String productName = "Apple MacBook Pro 13-inch";
	Search searchObject;
	SearchResultsPage searchResults;
	
	@Test
	public void userCanSearchForProduct() {
		searchObject = new Search(driver);
		searchResults = new SearchResultsPage(driver);
		searchObject.productSearch(productName);
		Assert.assertTrue(searchResults.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}
}
