package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(css="a.ico-register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="Contact us")
	WebElement contctUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropdownList;
	
	@FindBy(linkText="Computers")
	WebElement computersMenu;
	
	@FindBy(linkText="Notebooks")
	WebElement notebooksLink;
	
	public void openRegistrationPage() {
		clickButton(registerLink);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
	
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contctUsLink);
	}
	
	public void changeCurrency() {
		select = new Select(currencyDropdownList);
		select.selectByValue("Euro");
	}
	
	public void selectNotebooksMenu() {
		action.moveToElement(computersMenu)
			  .moveToElement(notebooksLink)
			  .click()
			  .build()
			  .perform();
	}
}
