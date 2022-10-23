package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductEmailAFriend extends PageBase{

	public ProductEmailAFriend(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement friendEmailTxt;

	@FindBy(id="YourEmailAddress")
	WebElement yourEmailTxt;
	
	@FindBy(id="PersonalMessage")
	WebElement personalMsgTxt;
	
	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	public WebElement resultMsg;
	
	
	public void fillEmailAFriendForm(String friendEmail, String personalMsg) {
		setElementText(friendEmailTxt, friendEmail);
		setElementText(personalMsgTxt, personalMsg);
		clickButton(sendEmailBtn);
	}

}
