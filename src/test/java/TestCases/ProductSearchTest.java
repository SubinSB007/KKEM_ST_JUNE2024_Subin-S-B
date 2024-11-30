package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.SearchResultPage;

public class ProductSearchTest extends TestBase{
	
	HomePage hp;
	SearchResultPage SRP;
	ProductDetailsPage PRP;
	@Test(priority=1)
	public void testLogoPage() {
		hp=new HomePage(driver);
		boolean r=hp.logoPresent();
		Assert.assertTrue(r);
	}
	
	@Test(priority=2)
	public void testSignInBtn() {
		hp=new HomePage(driver);
		boolean r=hp.checkSigninEnabled();
		Assert.assertTrue(r);
		}
	@Test(priority=3)
	public void testSearchnavigation() {
		hp=new HomePage(driver);
		SRP=new SearchResultPage(driver); 
		PRP=new ProductDetailsPage(driver);
		hp.enterdataSearch(prop.getProperty("phone"));
		hp.clickSearchButton();
		SRP.clickproduct(prop.getProperty("name"));
		Assert.assertTrue(PRP.cartbuttonpresent());
		 }
	
}
