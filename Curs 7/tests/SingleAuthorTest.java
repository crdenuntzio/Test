package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.SingleAuthorPage;
import utils.BaseTest;

public class SingleAuthorTest extends BaseTest {
	
	@Test
	public void checkPercentages() {
		SingleAuthorPage singleAuthorPage = navMenu.navigateToSingleAuthorPage();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='sc_skills_label']")));
		
		// dintr-un motiv sau altul nu a mers sa iau textul din div cu getText() si nu prea imi dau seama de ce: singleAuthorPage.getDramaPercentage().getText()
		// am incercat si //*[text()='Drama']/../following-sibling::div[1]/div/div/text() si imi dadea eroare.

		assertEquals(singleAuthorPage.getDramaPercentage().getAttribute("data-stop")+"%", "95%");
		assertEquals(singleAuthorPage.getBiographyPercentage().getAttribute("data-stop")+"%", "75%");
		assertEquals(singleAuthorPage.getCookbooksPercentage().getAttribute("data-stop")+"%", "82%");
	}

}
