package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {
	
	@FindBy (xpath = "//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/share-desktop-icon.svg']")
	private WebElement ShareButton;
	
	@FindBy (xpath = "//button[text()='View All']")
	private WebElement ViewAllButtonInOffers;
	
	@FindBy (xpath = "(//button[text()='Add to Cart'])[1]")
	private WebElement AddToCartButton;
	
	@FindBy (xpath = "(//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/chevron-down-icon.svg'])[1]")
	private WebElement ImageSwipeUpButton;
	
	@FindBy (xpath = "(//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/chevron-down-icon.svg'])[2]")
	private WebElement ImageSwipeDownButton;
	
	@FindBy (xpath = "(//img[@class='icon offer_back'])[2]")
	private WebElement SharePanelClose;
	
	@FindBy (xpath = "(//img[@class='icon offer_back'])[1]")
	private WebElement OffersPanelClose;
	
	JavascriptExecutor js;
	
	public Product_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
	public void ClickOnShareButton() {
		ShareButton.click();
	}
	
	public void ClickOnViewAllButtonInOffers() throws InterruptedException  {
		js.executeScript("arguments[0].scrollIntoView(true)", ViewAllButtonInOffers);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -100)");
		ViewAllButtonInOffers.click();
	}
	
	public void ClickOnAddToCartButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true)", AddToCartButton);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -100)");
		AddToCartButton.click();
	}
	
	public void ClickOnImageSwipeUpButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true)", ImageSwipeUpButton);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -3000)");
		Thread.sleep(1000);
		ImageSwipeUpButton.click();
	}
	
	public void ClickOnImageSwipeDownButton() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true)", ImageSwipeDownButton);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, 150)");
		ImageSwipeDownButton.click();
	}
	
	public void ClickOnSharePanelClose() {
		SharePanelClose.click();
	}
	
	public void ClickOnOffersPanelClose() {
		OffersPanelClose.click();
	}
	
	
	
}
