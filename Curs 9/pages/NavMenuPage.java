package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavMenuPage {
	public WebDriver driver;
	
	public NavMenuPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[class*='popup_login_link']") public WebElement loginLink;
	@FindBy(linkText = "BOOKS") public WebElement shopLink;
	@FindBy(linkText = "BLOG") public WebElement blogLink;
	
	public void navigateTo(WebElement element) {
		element.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
//	navigateTo(shopLink);
}
