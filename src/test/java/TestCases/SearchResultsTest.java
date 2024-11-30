package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductDetailsPage;
import PageObjects.SearchResultPage;

public class SearchResultsTest extends TestBase{
	
	SearchResultPage SRP;
	HomePage hp;
	ProductDetailsPage PRP;
	
	@Test(priority=1)
	public void testSortButton() {
		hp=new HomePage(driver);
		SRP=new SearchResultPage(driver); 
		PRP=new ProductDetailsPage(driver);
		hp.enterdataSearch(prop.getProperty("phone"));
		hp.clickSearchButton();
		boolean B=SRP.sortByPresent();
		Assert.assertTrue(B);
	}
	
	@Test(priority=2)
	public void testCustomerReview() {
		SRP=new SearchResultPage(driver);
		boolean B=SRP.customerReviewPresent();
		Assert.assertTrue(B);
	}
	@Test(priority=3)
	public void testbrandpresent() {
		SRP=new SearchResultPage(driver);
		boolean B=SRP.brandPresent();
		Assert.assertTrue(B);
	}
	@Test(priority=4)
	public void testModelyearPresent() {
		SRP=new SearchResultPage(driver);
		boolean B=SRP.modelYearPresetn();
		Assert.assertTrue(B);
	}

}
