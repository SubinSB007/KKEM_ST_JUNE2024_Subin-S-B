package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	WebDriver driver;
	Properties prop;
	
	public void readProp() throws IOException {
		prop=new Properties();
		FileInputStream fileIn=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   prop.load(fileIn);
	}
	
	@BeforeClass
	public void testSetUp() throws InterruptedException, IOException {
		readProp();
		String browser=prop.getProperty("browser");
		switch(browser.toLowerCase()){
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			default:
				System.out.println("Invalid browser name");
				return;
		}
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
		

	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
