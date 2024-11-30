package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//span[text()=\" Add to Cart \"]") WebElement cartBtn;
@FindBy(xpath="//span[@id=\"acrCustomerReviewText\"]") WebElement review;
@FindBy(xpath="//span[@class=\"a-button-inner\"]") WebElement Quantity;



//cartbutton present
public boolean cartbuttonpresent() {
	boolean b=cartBtn.isDisplayed();
	return b;
	}
//review button present
public boolean reviewButtondisplayed() {
	boolean b=review.isDisplayed();
	return b;
}
//Quanity button enabled
public boolean QuantitybtnDisplayed() {
	boolean b=Quantity.isDisplayed();
	return b;
}

//click on  the cart button
public void clickCartButton() {
	cartBtn.click();
	
}


}
