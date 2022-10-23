package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.Search;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	Search searchObjext;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	
	String totalPrice = "$7,200.00";
	String quantity = "4";
	String cartEmptyMsg = "Your Shopping Cart is empty!";
	
	@Test
	public void userCanAddProductToShoppingCartTest() {
		searchObjext = new Search(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		
		searchObjext.productSearchUsingAutocomplete("mac");
		
		productDetailsPage.addProductToShoppingCart();
		productDetailsPage.openShoppingCartPage();
		
		shoppingCartPage.updateProductQuantityInCart(quantity);
		System.out.println(shoppingCartPage.quantityTxt.getText());
//		Assert.assertEquals(quantity, shoppingCartPage.quantityTxt.getText());
		System.out.println(shoppingCartPage.totalLbl.getText());
		Assert.assertEquals(shoppingCartPage.totalLbl.getText(), totalPrice);
	}
	
	@Test
	public void userCanRemoveItemFromCart() {
		shoppingCartPage.removeItemFromCart();
		Assert.assertEquals(cartEmptyMsg, shoppingCartPage.emptyCartMsg.getText());
	}
}
