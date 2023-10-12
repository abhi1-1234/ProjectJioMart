package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JioMart_Main_page {

	    @FindBy (xpath = "//input[@id='autocomplete-0-input']") 
	    private WebElement SearchBar; 
	    
	    @FindBy (xpath = "//li[@id='autocomplete-0-0-item-0']")
	    private WebElement SearchBarListBox;
	    
	    @FindBy (xpath = "//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/search-icon.svg']")
	    private WebElement SearchIcon;
	    
	    @FindBy(xpath = "//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/list-icon.svg']")
	    private WebElement ListIconInSearchBar;
	    
	    @FindBy (xpath = "//textarea[@id='rel_search_val']")
	    private WebElement TextLineInListIcon;
	    
	    @FindBy (xpath = "//button[text()=' Clear ']")
	    private WebElement ClearButtonInListIcon;
	    
	    @FindBy (xpath = "//button[text()=' Search All ']")
	    private WebElement SearchAllButtonInListIcon;
	    
	    public JioMart_Main_page(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    public void SendKeysInSearchBar(String d)
	    {
	    	SearchBar.sendKeys(d);
	    }
	    
	    public void ClickOnListIconInSearchBar() {
	    	ListIconInSearchBar.click();
	    }
	    
	    public void ChooseOptionSearchBarListBox()
	    {
	    	SearchBarListBox.click();
	    }
	   
	    public void ClickSearchIcon()
	    {
	    	SearchIcon.click();
	    }
	    
	    public void SendKeysInTextLineInListIcon(String k) {
	    	TextLineInListIcon.sendKeys(k);
	    }
	    
	    public void ClickOnClearButton() {
	    	ClearButtonInListIcon.click();
	    }
	    
	    public void ClickOnSearchAllButtonInListIcon() {
	    	SearchAllButtonInListIcon.click();
	    }
	    
	   
	    
		
		
		
	

}
