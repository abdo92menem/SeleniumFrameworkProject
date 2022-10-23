package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends PageBase{

	public Search(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	public void productSearch(String productName) {
		setElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}
	
	public void productSearchUsingAutocomplete(String searchTxt) {
		setElementText(searchTextBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}

}
