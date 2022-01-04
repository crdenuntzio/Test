package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pages.NavMenuPage;

public class BaseTest {
	public WebDriver driver;
	public NavMenuPage navMenu;
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//driver.get("https://keybooks.ro/");
		driver.get(url);
		
		navMenu = new NavMenuPage(driver);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
