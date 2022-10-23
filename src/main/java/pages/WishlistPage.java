package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="div.no-data")
	WebElement emptyWishlistMsg;
	
	@FindBy(css="a.product-name")
	public WebElement productName;
	
	public boolean checkIfWishlistIsEmpty() {
		if (emptyWishlistMsg.getText().equals("The wishlist is empty!")) {
			return true;
		}
		return false;
	}
}
