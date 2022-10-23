package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a.clear-list")
	WebElement clearListBtn;

	@FindBy(css="div.no-date")
	public WebElement noDataLbl;

	@FindBy(css="table.compare-products-table")
	WebElement compareTable;

	@FindBy(tagName="tr")
	List<WebElement> allRows;

	@FindBy(tagName="td")
	List<WebElement> allCols;

	public void clearCompareTable() {
		clickButton(clearListBtn);
	}

	public void compareProducts() {
		System.out.println(allRows.size());
				
		for (WebElement row : allRows) {
			System.out.println(row.getText());
		}
		
	}

}
