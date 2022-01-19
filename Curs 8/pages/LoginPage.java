package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submitButton = By.cssSelector("input[class='submit_button']");
	public By userName = By.cssSelector("span[class='user_name']");
	
	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public void loginInApp(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickSubmitButton();
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(userName), "Test User"));
	}

}
