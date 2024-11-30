package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[starts-with(text(),'Apple')]") List<WebElement> ListProducts;
	@FindBy(xpath="//span[text()=\"Sort by:\"]") WebElement sortBy;
	@FindBy(xpath="//span[text()=\"Customer Reviews\"]") WebElement customerReview;
	@FindBy(xpath="//span[text()=\"Brands\"]") WebElement Brand;
	@FindBy(xpath="//span[text()=\"Electronics Device Model Year\"]") WebElement modelyear;
	
	//check right product is selected
	public void clickproduct(String p) {
		for(WebElement x:ListProducts) {
			String s=x.getText();
			if(s.equals(p)) {
				x.click();
				break;
			}
		}
	}
	
	//check sortbyoption is present
	
	public boolean sortByPresent() {
		boolean b=sortBy.isDisplayed();
		return b;
	}
	
	//check customer review is present
	public boolean customerReviewPresent() {
		boolean b=customerReview.isDisplayed();
		return b;
	}
	
	//check brand option is present
	
	public boolean brandPresent() {
		boolean b=Brand.isDisplayed();
		return b;
	}
	//check model year is present
	public boolean modelYearPresetn() {
		boolean b=modelyear.isDisplayed();
		return b;
	}

}
