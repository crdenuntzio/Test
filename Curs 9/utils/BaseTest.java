package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Driver{
	public WebDriver driver;
	public String url = ReadPropertiesFile.config.getProperty("url");
	
	@BeforeClass
	public void setup() {
		driver = initDriver();
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
