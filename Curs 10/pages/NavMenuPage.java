package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.ActionClassExample;
import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{
	//public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[class*='popup_login_link']") public WebElement loginLink;
	@FindBy(linkText = "BOOKS") public WebElement shopLink;
	@FindBy(linkText = "BLOG") public WebElement blogLink;
	@FindBy(linkText = "CONTACTS") public WebElement contactLink;
	@FindBy(linkText = "EVENTS") public WebElement eventsPage;
	@FindBy(linkText = "Post Formats") public WebElement postFormatsPage;
	
	public void navigateTo(WebElement element) {
		element.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
//	navigateTo(shopLink);
}
