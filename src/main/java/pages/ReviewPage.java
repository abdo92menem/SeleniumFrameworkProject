package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends PageBase{
	
	public ReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextAreaTxt;
	
	@FindBy(id="addproductrating_4")
	WebElement goodRatingBtn;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(css="div.review-title")
	public WebElement reviewResultTitle;
	
	@FindBy(css="div.review-text")
	public WebElement reviewResultText;
	
	public void makeReviewAndSubmit(String reviewTitle, String reviewText) {
		setElementText(reviewTitleTxt, reviewTitle);
		setElementText(reviewTextAreaTxt, reviewText);
		clickButton(goodRatingBtn);
		clickButton(submitReviewBtn);
	}
	
}
