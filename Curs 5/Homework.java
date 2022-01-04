package curs5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	public void searchForBook() throws InterruptedException {
		
		try {
			  driver.findElement(By.cssSelector("input[class='search_field']")).sendKeys("The story about me");
			  driver.findElement(By.cssSelector("input[class='search_field']")).submit();
			}
			catch(Exception e) {
				driver.findElement(By.cssSelector("button[class*='search_submit'][title='Open search']")).click();
				Thread.sleep(500);
				driver.findElement(By.cssSelector("input[class='search_field']")).sendKeys("The story about me");
				driver.findElement(By.cssSelector("input[class='search_field']")).submit();
			}
		
		outerloop:
		while(true) {
			for (WebElement element : driver.findElements(By.cssSelector("h4[class='post_title'] a"))) {
				if (element.getText().equals("The story about me")) {
					driver.findElement(By.cssSelector("a[href='https://keybooks.ro/shop/the-story-about-me/']")).click();
					break outerloop;
				}
			}
			driver.findElement(By.cssSelector("span[class='viewmore_text_1']")).click();
			Thread.sleep(1000);
		}
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-story-about-me/");
		
		driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();
		Thread.sleep(500);
		
		assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-message']")).getText().contains("“The story about me” has been added to your cart."));
		
		driver.findElement(By.cssSelector("a[href='https://keybooks.ro/cart/'][tabindex='1']")).click();
		Thread.sleep(1000);
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/cart/");
	}
	
	@Test (dependsOnMethods = "searchForBook")
	public void checkout() throws InterruptedException {
		WebElement quantity = driver.findElement(By.cssSelector("input[class='input-text qty text']"));

		quantity.clear();
		quantity.sendKeys("2");
		
		driver.findElement(By.cssSelector("button[name='update_cart']")).click();
		Thread.sleep(500);
		
		assertEquals(driver.findElement(By.cssSelector("div[class='woocommerce-message']")).getText(),"Cart updated.");
		
		driver.findElement(By.cssSelector("a[class='checkout-button button alt wc-forward']")).click();
		Thread.sleep(1500);
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/checkout/");
		
		assertEquals(driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields'] h3")).getText(),"Billing details");
		
		assertEquals(driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields'] h3")).getText(),"Additional information");
	}
}
