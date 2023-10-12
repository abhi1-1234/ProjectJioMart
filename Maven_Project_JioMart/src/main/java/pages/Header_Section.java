package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_Section {

	@FindBy (xpath = "//a[text()='Electronics']")
	private WebElement ElectronicsTab;
	
	@FindBy (xpath = "//img[@id='ham_close']")
	private WebElement HamburgerIcon;
	
	@FindBy (xpath = "//span[text()='Home']")
	private  WebElement HomeLinkInHamburgerIcon;
	
	public Header_Section(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnElectronicsTab()
	{
		ElectronicsTab.click();
	}
	
	public void ClickOnHamburgerIcon() {
		HamburgerIcon.click();
	}
	
	public void ClickOnHomeLinkInHamburgerIcon() {
		HomeLinkInHamburgerIcon.click();
	}
	
}
