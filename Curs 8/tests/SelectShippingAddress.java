package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserAccountPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class SelectShippingAddress extends BaseTest {
	
	@Parameters({"user", "pass"})
	@Test
	public void login(String user, String pass) {
		LoginPage login = navMenu.navToLogin();
		login.loginInApp(user, pass);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span[class='user_name']")), "Test User"));
	}
	
	@Test
	public void setAddress() {
		UserAccountPage userAccountPage = navMenu.navToUserAccount();
		userAccountPage = userAccountPage.navToShippingAddresse();
		
		userAccountPage.setShippingAddressCountry(41);
		assertEquals(userAccountPage.getSelectedOption(userAccountPage.countryDropDown), "Canada");
		
		userAccountPage.setShippingAddressShippingState("NL");
		assertEquals(userAccountPage.getSelectedOption(userAccountPage.shippingStateDropDown), "Newfoundland and Labrador");
	}
}
