package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(css="h1")
	public WebElement productName;
	
	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(id="price-value-4")
	public WebElement productPrice;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropdownList;
	
	@FindBy(linkText="Add your review")
	WebElement reviewLink;

	@FindBy(css="div.add-to-wishlist")
	WebElement addToWishlistBtn;
	
	@FindBy(linkText="wishlist")
	WebElement wishlistLink;
	
	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToComparelistBtn;
	
	@FindBy(linkText="product comparison")
	WebElement comparePageLink;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToShoppingCartBtn;
	
	@FindBy(linkText="shopping cart")
	WebElement shoppingCartLink;
	
	public void openEmailFriendPage() {
		clickButton(emailFriendBtn);
	}
	
	public void changeCurrency() {
		select = new Select(currencyDropdownList);
		select.selectByIndex(1);
	}
	
	public void openReviewPage() {
		clickButton(reviewLink);
	}
	
	public void addProductToWishlist() {
		clickButton(addToWishlistBtn);
	}
	
	public void openWishlistPage() {
		clickButton(wishlistLink);
	}
	
	public void addProductToComparelist() {
		clickButton(addToComparelistBtn);
	}
	
	public void openComparelistPage() {
		clickButton(comparePageLink);
	}
	
	public void addProductToShoppingCart() {
		clickButton(addToShoppingCartBtn);
	}
	
	public void openShoppingCartPage() {
		clickButton(shoppingCartLink);
	}
}
