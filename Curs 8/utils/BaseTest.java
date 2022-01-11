package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

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
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot poza = (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(picture, new File("screenshots/" + result.getName() + ".png"));
			} catch(Exception e) {
				System.out.println("Could not take picture");
				
				e.printStackTrace();
			}
		}
	}
}
