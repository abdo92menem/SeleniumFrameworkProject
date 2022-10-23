package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement fullNameTxt;
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(id="Enquiry")
	WebElement textArea;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement textResult;
	
	public void fillContactUsForm(String fullName, String email, String enquiry) {
		
		setElementText(fullNameTxt, fullName);
		setElementText(emailTxt, email);
		setElementText(textArea, enquiry);
		clickButton(submitBtn);
	}
}
