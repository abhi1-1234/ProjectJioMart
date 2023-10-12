package testPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.Electronics_Tab_Page;
import pages.Header_Section;
import pages.Product_page;
import utilize.Utility;

public class Verify_Product_page {
	
	private Header_Section header_Section;
	private Electronics_Tab_Page electronics_Tab_Page;
	private Product_page product_page;
	private WebDriver driver;
	private String testID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("Browser")
	@BeforeTest
	public void Open_Browser(String Browsername) throws InterruptedException 
	{
		 reporter = new ExtentHtmlReporter("test-output\\ExtendReport\\Extent.html");
         ExtentReports extend = new ExtentReports();
         extend.attachReporter(reporter);
         
		if(Browsername.equals("Chrome"))
		{
            driver = base.Browser.launchChrome();
			driver.get("https://jiomart.com/");
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
		}
		if(Browsername.equals("Firefox"))
		{
			driver = base.Browser.launchFirefox();
			Thread.sleep(1000);
			driver.get("https://jiomart.com/");
			Thread.sleep(1000);
			driver.manage().window().maximize();
		}
		if(Browsername.equals("Edge"))
		{
            driver = base.Browser.launchEdge();
			driver.get("https://jiomart.com");
			Thread.sleep(1000);
			driver.manage().window().maximize();
		}
	}
	
	@BeforeClass
	public void Creating_POM_Object()
	{
		header_Section = new Header_Section(driver);
		electronics_Tab_Page = new Electronics_Tab_Page(driver);
		product_page = new Product_page(driver);
	}
	
	@Test (priority = 1)
	public void VerifyElectronicsPage() throws InterruptedException {
		testID = "TC_003";
		
		header_Section = new Header_Section(driver);
		header_Section.ClickOnElectronicsTab();
		Thread.sleep(1000);

		electronics_Tab_Page.ClickOnMobilesAndTabletsSubcategory();
		Thread.sleep(1000);
		electronics_Tab_Page.ClickOnSmartPhonesInSubCategory();
		Thread.sleep(1000);
		electronics_Tab_Page.ClickOnProductImage();
		

		WebElement d = driver.findElement(By.xpath("//a[@id='nav_link_4']"));
		String a = d.getText();
		String b = "Electronics";
		boolean h = a.equals(b);
		Assert.assertTrue(h, "Result not Match");
	}
	
	@Test (priority = 2)
	public void VerifyProductpage() throws InterruptedException
	{	
		testID = "TC_004" ;
		
		product_page.ClickOnShareButton();
		Thread.sleep(1000);
		product_page.ClickOnSharePanelClose();
		Thread.sleep(1000);
		product_page.ClickOnViewAllButtonInOffers();
		Thread.sleep(1000);
		product_page.ClickOnOffersPanelClose();
		Thread.sleep(1000);
		product_page.ClickOnAddToCartButton();
		Thread.sleep(1000);
		product_page.ClickOnImageSwipeUpButton();
		Thread.sleep(1000);
		product_page.ClickOnImageSwipeDownButton();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void TakeScreenShot_Of_Failed_Test_Methods(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus() ) {
			Utility.TakeScreenShotOf(driver, testID);
		}
	}
	
	@AfterClass
	public void Clear_Object() 
	{
		header_Section = null;
		electronics_Tab_Page = null;
		product_page = null;
	}
	
	@AfterTest
	public void Close_the_Browser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	

}
