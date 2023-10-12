package testPack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

	@BeforeClass
	public void beforClass() {
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforemethod");
	}

	@Test
	public void test1() {
		System.out.println("test123");
	}
	
	@Test
	public void test12() {
		System.out.println("test123");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	

}
