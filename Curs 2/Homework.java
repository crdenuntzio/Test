package curs2;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
	}
	
	@Test
	public void checkWebElements() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.linkText("Login"));
		
		assertTrue(loginButton.isDisplayed(),"Check if login button exists, pre login click;");
		
		WebElement loginInput = driver.findElement(By.className("login_field"));
		WebElement passwordInput = driver.findElement(By.className("password_field"));
		
		assertTrue(!loginInput.isDisplayed(),"Check if login input text area exists, pre login click;");
		assertTrue(!passwordInput.isDisplayed(),"Check if password input text area exists, pre login click;");
		
		loginButton.click();
		Thread.sleep(1000);
		
		assertTrue(loginInput.isDisplayed(),"Check if login input text area exists, post login click;");
		assertTrue(passwordInput.isDisplayed(),"Check if password input text area exists, post login click;");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
