package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
	
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;
	
	@FindBy(id="FirstName")
	WebElement fstNameTxt;
	
	@FindBy(id="LastName")
	WebElement lstNameTxt;
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(id="Password")
	WebElement passwordTxt;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(className="result")
	public WebElement successMessage;
	
	@FindBy(css="a.ico-logout")
	public WebElement logoutBtn;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;
	
	public void registerNewUser(String firstName, String lastName, String email, String password) {
		clickButton(genderRadioBtn);
		setElementText(fstNameTxt, firstName);
		setElementText(lstNameTxt, lastName);
		setElementText(emailTxt, email);
		setElementText(passwordTxt, password);
		setElementText(confirmPasswordTxt, password);
		clickButton(registerBtn);
	}
	
	public void userLogout() {
		clickButton(logoutBtn);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}
}
