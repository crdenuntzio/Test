package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class DragAndDropSliders extends BaseTest{
	
	@Test
	public void dragAndDropSliders() throws InterruptedException {
		Actions action = new Actions(driver);
		
		action.moveToElement(page.navMenu.blogLink).perform();
		
		action.moveToElement(page.navMenu.postFormatsPage).click().perform();
		
		action.moveToElement(page.postFormats.audioPostLink).click().perform();
		
		action.moveToElement(page.audioPostPage.playAudioButton).click().perform();
		Thread.sleep(1000);
		action.moveToElement(page.audioPostPage.pauseAudioButton).click().perform();
		
		action.dragAndDropBy(page.audioPostPage.trackSliderHandle, 200, 0).perform();
		
		//la ultima actiune, daca puneam 50 de pixeli in orice directie era prea mult asa ca am ales sa dau putin mai incet sonorul
		action.moveToElement(page.audioPostPage.soundSliderHandle).moveByOffset(-5, 0).click().perform();
		
		Thread.sleep(3000);
	}
}
