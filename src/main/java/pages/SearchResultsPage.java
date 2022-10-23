package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement productNameBreadCrumb;
}
