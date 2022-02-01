package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers {
	public WebDriver driver;
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doubleClick(WebElement element) {
		try {
			Actions action = new Actions(driver);
			
			action.moveToElement(element).doubleClick().perform();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void dragAndDropSlider(WebElement element, int xOffset, int yOffset) {
		try {
//			TODO: add wait for element to be clickable
			
			Actions action = new Actions(driver);
			action.moveToElement(element).dragAndDropBy(element, xOffset, yOffset).perform();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void hoverElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * Method used to send key values (String) to an input field
	 * @param element : WebElement which receives the text input
	 * @param keysToSend : the value to be sent (String)
	 */
	public void sendKeys(WebElement element, String keysToSend) {
		try {
			waitForElementToBeDisplayed(element);
			//element.clear();
			element.sendKeys(keysToSend);
		}catch(Exception e) {
			//log
			
			throw new TestException(String.format("Error in sending to the element!"));
		}
	}
	
	public void waitForElementToBeDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e) {
			//Logging
			e.printStackTrace();
			
			//retry mechanism
			
			throw new TestException("Element not found");
		}
	}
	
	public void click(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			element.click();
		}catch(NoSuchElementException e) {
			//Logging
			e.printStackTrace();
			
			//retry mechanism
			
			throw new TestException("Element not found");
		}
	}
	
	public boolean checkCurrentUrl(String expectedUrl) {
		if(driver.getCurrentUrl().equals(expectedUrl)) {
			return true;
		} else {
			return false;
		}
	}
}
