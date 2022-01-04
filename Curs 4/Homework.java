package curs4;

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
	public void homework() throws InterruptedException {
		driver.findElement(By.cssSelector("div[aria-hidden='false'] a[href='the-long-road-to-the-deep-silence']")).click();
		driver.findElement(By.cssSelector("a[href='#tab-reviews']")).click();
		
		WebElement consentCheckbox = driver.findElement(By.cssSelector("input[id='wp-comment-cookies-consent']"));
		
		assertTrue(!consentCheckbox.isSelected(), "Check if the consent checkbox is not selected when first clicking on Review");
		
		driver.findElement(By.cssSelector("a[class='star-3']")).click();
		driver.findElement(By.cssSelector("textarea[id='comment']")).sendKeys("Your message");
		driver.findElement(By.cssSelector("input[id='author']")).sendKeys("Name");
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("email@email.com");
		consentCheckbox.click();
		
		assertTrue(consentCheckbox.isSelected(), "Check if the consent checkbox is selected after inputing data");
		
		driver.findElement(By.cssSelector("input[id='submit']")).click();
		Thread.sleep(500);
		
		WebElement approval = driver.findElement(By.cssSelector("em[class='woocommerce-review__awaiting-approval']"));
		assertEquals(approval.getText(),"Your review is awaiting approval");
		
		Thread.sleep(4000);
	}
}
