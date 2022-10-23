package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css="div.bar-notification.success")
	public WebElement resultMsg;
	
	@FindBy(css="span.close")
	public WebElement closeBtn;
	
	public void openChangePasswordPage() {
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		setElementText(oldPasswordTxt, oldPassword);
		setElementText(newPasswordTxt, newPassword);
		setElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
	}
	
	public void closeMessageBar() {
		clickButton(closeBtn);
	}
}
