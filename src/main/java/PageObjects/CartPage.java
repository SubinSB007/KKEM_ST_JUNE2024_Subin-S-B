package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()=\"Shopping Cart\"]") WebElement shoppingCarthead;
	@FindBy(xpath="//input[@name=\"proceedToRetailCheckout\"]") WebElement checkoutbtn;
	@FindBy(xpath="//span[text()=\"Price\"]") WebElement pricedisplay;
	
	//check shopping cart header is present
	public boolean checkCarthead() {
		boolean b=shoppingCarthead.isDisplayed();
		return b;
	}
	
	//checkout button enabled
	public boolean checkcheckoutbuttonenable() {
		boolean b=checkoutbtn.isEnabled();
		return b;
	}
	
	//click on the checkout button
	public void clickcheckOutbtn() {
		checkoutbtn.click();
	}
	
	//check price  is displayed
	public boolean priceDisplayed() {
		boolean p=pricedisplay.isDisplayed();
		return p;
	}

}
