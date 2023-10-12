package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Electronics_Tab_Page {

@FindBy (xpath = "(//span[@class='text-truncate'])[1]")
private WebElement MobilesAndTabletsSubcategory;

@FindBy (xpath = "(//a[@href='/c/electronics/mobiles-tablets/smartphones/777'])[2]")
private WebElement ChooseSmartphones;

@FindBy (xpath = "//img[@src='https://www.jiomart.com/images/product/original/491997699/apple-iphone-13-128-gb-midnight-black-digital-o491997699-p590798548-0-202208221207.jpeg?im=Resize=(360,360)']")
private WebElement Product;

public Electronics_Tab_Page(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void ClickOnMobilesAndTabletsSubcategory()
{
	MobilesAndTabletsSubcategory.click();
}
		
public void ClickOnSmartPhonesInSubCategory() {
	ChooseSmartphones.click();
}

public void ClickOnProductImage() {
	Product.click();
}

		
	

}
