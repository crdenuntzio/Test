package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavMenuPage {
	public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loginLink = By.linkText("Login");
	public By singleAuthorLink = By.xpath("//*[text()='Single author']");
	public By shopLink = By.linkText("BOOKS");
	public By settingsLink = By.linkText("Settings");
	public By userName = By.cssSelector("span[class='user_name']");
	
	public void navigateToLogin() {
		driver.findElement(loginLink).click();
	}
	
	public LoginPage navToLogin() {
		driver.findElement(loginLink).click();
		
		return new LoginPage(driver);
	}
	
	public SingleAuthorPage navigateToSingleAuthorPage() {
		driver.findElement(singleAuthorLink).click();
		
		return new SingleAuthorPage(driver);
	}
	
	public ShopPage navToShop() {
		driver.findElement(shopLink).click();
		
		return new ShopPage(driver);
	}
	
	public UserAccountPage navToUserAccount() {
		driver.findElement(userName).click();
		driver.findElement(settingsLink).click();
		
		return new UserAccountPage(driver);
	}

}
