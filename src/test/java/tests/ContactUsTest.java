package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	HomePage home;
	ContactUsPage contactUsPage;
	
	String fullName = "Abdullah Abdelmenem";
	String email = "abdullah@test.com";
	String inquiry = "any thing to test";
	String resultMsg = "Your enquiry has been successfully sent to the store owner.";
	
	@Test
	public void contactUsTest() {
		
		home = new HomePage(driver);
		home.openContactUsPage();
		
		contactUsPage = new ContactUsPage(driver);
		contactUsPage.fillContactUsForm(fullName, email, inquiry);
		
		Assert.assertEquals(resultMsg, contactUsPage.textResult.getText());
	}
}
