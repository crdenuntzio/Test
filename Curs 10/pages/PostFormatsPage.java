package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class PostFormatsPage extends SeleniumWrappers {
	public PostFormatsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[title='Search for:']") public WebElement searchField;
	@FindBy(linkText = "Audio post") public WebElement audioPostLink;
}
