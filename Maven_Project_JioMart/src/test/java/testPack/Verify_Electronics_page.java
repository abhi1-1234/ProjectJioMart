package testPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
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

public class Verify_Electronics_page {

	private Header_Section header_Section;
	private Electronics_Tab_Page electronics_Tab_Page;
		WebDriver driver;
		
		static ExtentTest test;
		static ExtentHtmlReporter reporter;
		
	    @Parameters("Browser")
		@BeforeTest
		public void Open_Brower(String Browsername) throws InterruptedException 
		{
	    	 reporter = new ExtentHtmlReporter("test-output\\ExtendReport\\Extent.html");
	            ExtentReports extend = new ExtentReports();
	            extend.attachReporter(reporter);
	            
	    	if(Browsername.equals("Chrome")) 
	    	{
	    		driver = base.Browser.launchChrome();
	    		
				driver.get("https://www.jiomart.com/");
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);
	    	}
	    	if(Browsername.equals("Firefox"))
	    	{
	    		driver = base.Browser.launchFirefox();
	    		
	    		driver.get("https://jiomart.com/");
	    		Thread.sleep(1000);
	    		driver.manage().window().maximize();
	    		Thread.sleep(1000);
	    	}
	    	if(Browsername.equals("Edge"))
	    	{
	    		driver = base.Browser.launchEdge();
	    		
	    		driver.get("https://jiomart.com/");
	    		Thread.sleep(1000);
	    		driver.manage().window().maximize();
	    		Thread.sleep(1000);
	    	}
	    		
		}
	    
	    @BeforeClass
	    public void CreatingPOM_Object()
	    {
	    	header_Section = new Header_Section(driver);
	    	electronics_Tab_Page = new Electronics_Tab_Page(driver);
	    }
	    
		@Test
		public void Verifying_Electronics_page() throws InterruptedException 
		{
		header_Section.ClickOnElectronicsTab();
		Thread.sleep(1000);
		electronics_Tab_Page.ClickOnMobilesAndTabletsSubcategory();
		Thread.sleep(1000);
		electronics_Tab_Page.ClickOnSmartPhonesInSubCategory();
		Thread.sleep(1000);
		electronics_Tab_Page.ClickOnProductImage();
		}
		
		@AfterClass
		public void Clear_POM_Object()
		{
			header_Section = null;
			electronics_Tab_Page = null;
		}
		
		@AfterTest 
		public void Close_Browser() 
		{
			driver.close();
			driver = null;
			System.gc();
		}
		
		
	}


