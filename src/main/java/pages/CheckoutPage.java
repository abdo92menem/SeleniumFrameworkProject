package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="button.button-1.checkout-as-guest-button")
	WebElement checkoutAsGuestBtn;

	@FindBy(id="ShipToSameAddress")
	WebElement shipToSameAddCheckbox;

	@FindBy(id="billing-address-select")
	WebElement userAdressesList;

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstNameTxt;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastNameTxt;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressTxt;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;

	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continueBtn;

	@FindBy(id="shippingoption_0")
	WebElement groundBtn;

	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;

	@FindBy(id="paymentmethod_0")
	WebElement paymentBtn1;

	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;

	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement continueToConfirmBtn;

	@FindBy(css="a.product-name")
	public WebElement productName;

	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement ConfirmBtn;

	@FindBy(css="h1")
	public WebElement thankYouLbl;

	@FindBy(css="div.title")
	public WebElement successMsg;

	@FindBy(linkText="Click here for order details.")
	public WebElement orderDetailsLink;

	public void registeredUserCheckoutProduct(String countryName,
			String cityName,
			String address1,
			String zipCode,
			String phoneNumber,
			String productName) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);

		setElementText(cityTxt, cityName);
		setElementText(addressTxt, address1);
		setElementText(zipCodeTxt, zipCode);
		setElementText(phoneNumberTxt, phoneNumber);

		clickButton(continueBtn);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueToConfirmBtn);
		Thread.sleep(1000);
	}

	public void confirmOrder() throws InterruptedException {

		clickButton(ConfirmBtn);
		Thread.sleep(1000); 		
	}

	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

	public void CheckoutProductAsGuest(String firstName,
									   String lastName,
									   String email,
									   String countryName,
									   String cityName,
									   String address1,
									   String zipCode,
									   String phoneNumber,
									   String productName) throws InterruptedException {
		
		clickButton(checkoutAsGuestBtn);
		setElementText(firstNameTxt, firstName);
		setElementText(lastNameTxt, lastName);
		setElementText(emailTxt, email);
		
		select = new Select(countryList);
		select.selectByVisibleText(countryName);

		setElementText(cityTxt, cityName);
		setElementText(addressTxt, address1);
		setElementText(zipCodeTxt, zipCode);
		setElementText(phoneNumberTxt, phoneNumber);

		clickButton(continueBtn);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueToConfirmBtn);
		Thread.sleep(1000);
	}

}
