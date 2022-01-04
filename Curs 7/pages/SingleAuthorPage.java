package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingleAuthorPage {
	public WebDriver driver;
	
	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By dramaPercentage = By.xpath("//*[text()='Drama']/../following-sibling::div[1]/div/div");
	public By biographyPercentage = By.xpath("//*[text()='Biography']/../following-sibling::div[1]/div/div");
	public By cookbooksPercentage = By.xpath("//*[text()='Cookbooks']/../following-sibling::div[1]/div/div");
	
	public WebElement getDramaPercentage() {
		return driver.findElement(dramaPercentage);
	}
	
	public WebElement getBiographyPercentage() {
		return driver.findElement(biographyPercentage);
	}
	
	public WebElement getCookbooksPercentage() {
		return driver.findElement(cookbooksPercentage);
	}
}
