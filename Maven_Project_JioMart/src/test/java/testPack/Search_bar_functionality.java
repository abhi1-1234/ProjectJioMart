package testPack;

import java.io.IOException;
import base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import pages.JioMart_Main_page;
import utilize.Utility;

public class Search_bar_functionality extends Browser {
	
private	WebDriver driver;
private	JioMart_Main_page jioMart_Main_page;
private String testID ;

static ExtentTest test;
static ExtentHtmlReporter reporter; 

        @Parameters("Browser")
        @BeforeTest
        public void OpenBrowser(String Browsername) throws InterruptedException
        {
	
	            reporter = new ExtentHtmlReporter("test-output\\ExtendReport\\Extent.html");
	            ExtentReports extend = new ExtentReports();
	            extend.attachReporter(reporter);
	            
		        if(Browsername.equals("Chrome")) 
		        {	
					driver =  launchChrome();
					driver.get("https://www.jiomart.com/");
					Thread.sleep(1000);
					driver.manage().window().maximize();
					Thread.sleep(1000);
		        }
		        if(Browsername.equals("Firefox"))
		        {
		        	driver = launchFirefox(); 
		        	Thread.sleep(1000);
		        	driver.get("https://jiomart.com/");
		        	Thread.sleep(1000);
		        	driver.manage().window().maximize();
		        }
		        if(Browsername.equals("Edge"))
		        {
		        	driver = launchEdge();
		        	Thread.sleep(1000);
		        	driver.get("https://jiomart.com/");
		        	Thread.sleep(1000);
		        	driver.manage().window().maximize();
		        }
        }
	  @BeforeClass
	  public void Creating_POM_Object() 
	  {
		  jioMart_Main_page = new JioMart_Main_page(driver);
	  }
        
        @Test (priority = 1)
        public void SendKeysInSearchBar() throws InterruptedException
        {
        	testID = "TC_001 ";
        	
			jioMart_Main_page.SendKeysInSearchBar("l");
			Thread.sleep(1000);
			jioMart_Main_page.SendKeysInSearchBar("a");
			Thread.sleep(1000);
			jioMart_Main_page.SendKeysInSearchBar("p");
			Thread.sleep(1000);
			jioMart_Main_page.SendKeysInSearchBar("t");
			Thread.sleep(1000);
			jioMart_Main_page.ChooseOptionSearchBarListBox();
			Thread.sleep(1000);
			driver.navigate().back();
	        Thread.sleep(1000);
        }
        
        @Test (priority = 2)
        public void VerifyListIconInSearchBar() throws InterruptedException
        {
        	testID = "TC_002";
        	
			jioMart_Main_page.ClickOnListIconInSearchBar();
			Thread.sleep(1000);
			jioMart_Main_page.SendKeysInTextLineInListIcon("Milk, Bread, Biscuit");
			Thread.sleep(1000);
			jioMart_Main_page.ClickOnClearButton();
			Thread.sleep(1000);
			jioMart_Main_page.SendKeysInTextLineInListIcon("Milk, Bread, Biscuit");
			Thread.sleep(1000);
			jioMart_Main_page.ClickOnSearchAllButtonInListIcon();
			Thread.sleep(1000);
			driver.navigate().back();
        }
        
        @AfterMethod
        public void TakeScreenShot_Of_Failed_Test_Methods(ITestResult result) throws IOException {
        	
        	if(ITestResult.FAILURE == result.getStatus()) {
        		Utility.TakeScreenShotOf(driver, testID);
        	}
        	
        }
		
		@AfterClass
		public void Clear_Object() 
		{
			jioMart_Main_page = null;
		}
		
		@AfterTest
		public void Close_the_Browser() 
		{
			driver.close();
			driver = null;
			System.gc();
		}

}
