package curs6;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework extends BaseTest {
	
	@Parameters({"user", "pass", "subject", "message"})
	@Test
	public void message(String user, String pass, String subject, String message) throws InterruptedException {
		
		WebElement nameInput = driver.findElement(By.cssSelector("input[name='your-name']"));
		nameInput.sendKeys(user);
		
		WebElement emailInput = driver.findElement(By.cssSelector("input[name='your-email']"));
		emailInput.sendKeys(pass);
		
		WebElement subjectInput = driver.findElement(By.cssSelector("input[name='your-s']"));
		subjectInput.sendKeys(subject);
		
		WebElement messageTextarea = driver.findElement(By.cssSelector("textarea[name='your-message']"));
		messageTextarea.sendKeys(message);
		
		WebElement submitButton = driver.findElement(By.cssSelector("input[class='wpcf7-form-control wpcf7-submit']"));
		submitButton.click();
		
		Thread.sleep(2000);
		
		WebElement messageConfirmation = driver.findElement(By.cssSelector("div[class='wpcf7-response-output']"));
		
		assertEquals(messageConfirmation.getText(), "Thank you for your message. It has been sent.");
	}
}
