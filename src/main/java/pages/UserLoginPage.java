package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
	
	public UserLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Email")
	WebElement emailtxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="RememberMe")
	WebElement rememberCheckBtn;
	
	@FindBy(linkText ="Forgot password?")
	WebElement forgotPassLink;
	
	@FindBy(css ="button.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String email, String password) {
		setElementText(emailtxtBox, email);
		setElementText(passwordTxtBox, password);
		// clickButton(rememberCheckBtn);
		clickButton(loginBtn);
	}
	
	
	
	
	
	
}
