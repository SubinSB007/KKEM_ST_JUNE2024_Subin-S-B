package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.SearchResultPage;

public class ProductDetailsPageTest extends TestBase{
	
	ProductDetailsPage PRP;
	SearchResultPage SRP;
	HomePage hp;
	@Test(priority=1)
	public void testCartButton() {
		hp=new HomePage(driver);
		SRP=new SearchResultPage(driver); 
		PRP=new ProductDetailsPage(driver);
		hp.enterdataSearch(prop.getProperty("phone"));
		hp.clickSearchButton();
		PRP=new ProductDetailsPage(driver);
		boolean b=PRP.cartbuttonpresent();
		Assert.assertTrue(b);
	}
	@Test(priority=2)
	public void testReviewButtonIsDiplayed() {
		PRP=new ProductDetailsPage(driver);
		boolean b=PRP.reviewButtondisplayed();
		Assert.assertTrue(b);
	
	}
	@Test(priority=3)
	public void testQuantityButton() {
		PRP=new ProductDetailsPage(driver);
		boolean b=PRP.QuantitybtnDisplayed();
		Assert.assertTrue(b);
	}
}
