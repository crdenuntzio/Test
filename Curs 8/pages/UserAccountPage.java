package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserAccountPage {
	WebDriver driver;
	WebElement dropDown;
	Select selectDropDown;
	
	public UserAccountPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public By addressesLink = By.linkText("Addresses");
	public By shippingAddressesLink = By.xpath("//*[text()='Shipping address']/following-sibling::a");
	public By countryDropDown = By.id("shipping_country");
	public By shippingStateDropDown = By.id("shipping_state");
	
	public UserAccountPage navToAddresses() {
		driver.findElement(addressesLink).click();
		
		return new UserAccountPage(driver);
	}
	
	public UserAccountPage navToShippingAddresse() {
		navToAddresses();
		driver.findElement(shippingAddressesLink).click();
		
		return new UserAccountPage(driver);
	}
	
	public void setShippingAddressCountry(int index) {
		dropDown = driver.findElement(countryDropDown);
		selectDropDown = new Select(dropDown);
		
		selectDropDown.selectByIndex(index);
	}
	
	public void setShippingAddressShippingState(String value) {
		dropDown = driver.findElement(shippingStateDropDown);
		selectDropDown = new Select(dropDown);
		
		selectDropDown.selectByValue(value);
	}
	
	public String getSelectedOption(By dropDownToCheck) {
		dropDown = driver.findElement(dropDownToCheck);
		selectDropDown = new Select(dropDown);
		
		return selectDropDown.getFirstSelectedOption().getText();
	}
}
