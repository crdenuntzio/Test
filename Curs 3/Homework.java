package curs3;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework {
public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void homework() {
		List<WebElement> categorii= driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		WebElement theForestBook = null;
		
		for (WebElement categorie : categorii) {
			if (!categorie.getAttribute("aria-expanded").equals("true")) {
				categorie.click();
			}
			
			theForestBook = driver.findElement(By.cssSelector("div[style='display: block;'],a[href='the-forest']"));
			
			assertTrue(theForestBook.isDisplayed(),"Check if The Forest book is displayed");
		}
		
		if (!theForestBook.equals(null)) {
			theForestBook.click();
			
			assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-forest/"),"Check if the current URL is https://keybooks.ro/shop/the-forest/");
		}
		
		
	}
}
