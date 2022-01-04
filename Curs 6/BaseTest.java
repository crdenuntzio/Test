package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
