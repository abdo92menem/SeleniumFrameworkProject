package tests;

import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.Search;

public class AddProductToCompareTest extends TestBase{
	
	Search searchObject;
	ProductDetailsPage productDetailsPage;
	ComparePage comparePage = new ComparePage(driver);
	
	String firstProductName = "mac";
	String secondProductName = "asus";
	
	@Test(priority=0)
	public void userCanAddProductToWishlist() {
		searchObject = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		comparePage = new ComparePage(driver);
		
		searchObject.productSearchUsingAutocomplete(firstProductName);
		productDetailsPage.addProductToComparelist();
		searchObject.productSearchUsingAutocomplete(secondProductName);
		productDetailsPage.addProductToComparelist();
		productDetailsPage.openComparelistPage();
		
		comparePage.compareProducts();
	}
	
	@Test(priority=1)
	public void clearCompareList() {
		comparePage.clearCompareTable();
		
//		Assert.assertEquals("You have no items to compare.", comparePage.noDataLbl.getText());
	}
}
