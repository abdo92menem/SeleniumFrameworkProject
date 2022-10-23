package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="button.remove-btn")
	WebElement removeBtn;
	
	@FindBy(id="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css="input.qty-input")
	public WebElement quantityTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(css="div.no-data")
	public WebElement emptyCartMsg;
	
	@FindBy(id="termsofservice")
	WebElement agreeTermsBtn;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public void removeItemFromCart() {
		clickButton(removeBtn);
	}
	
	public void updateProductQuantityInCart(String quantity) {
		clearText(quantityTxt);
		setElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void openCheckoutPage() {
		clickButton(agreeTermsBtn);
		clickButton(checkoutBtn);
	}
}
