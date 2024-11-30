package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	Select sdn; //select class for dropdown
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id=\"nav-logo-sprites\"]") WebElement logo;
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]") WebElement searchbox;
	@FindBy(xpath="//select[@id=\"searchDropdownBox\"]") WebElement categoriesDrop;
	@FindBy(xpath="//span[text()=\"Hello, sign in\"]") WebElement Signin;
	@FindBy(xpath="//input[@type=\"submit\"]") WebElement searchbtn;
	
   //check logo is present or not
	public boolean logoPresent() {
		boolean l=logo.isDisplayed();
		return l;
	}
	
	//enter value to search box
	public void enterdataSearch(String name) {
		searchbox.sendKeys(name);
	}
	
	//select the categories
	public void selectCategory(String cat) {
		Select sdn =new Select(categoriesDrop);
		sdn.selectByVisibleText(cat);
	}
	
	//check check sign is enabled in the home page
	public boolean checkSigninEnabled() {
		boolean t=Signin.isEnabled();
		return t;
	}
	
	//click the search button
	public void clickSearchButton() {
		searchbtn.click();
		}
	
}
