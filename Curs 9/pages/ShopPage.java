package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	public WebDriver driver;
	private Select selectOption;
	
	public ShopPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="orderby") public WebElement orderByDropDown;
	@FindBy(className="price") public List<WebElement> bookPrices;
	@FindBy(className="woocommerce-loop-product__title") public List<WebElement> bookLinks;
	
	public void setSortingOrder(String value) {
		selectOption = new Select(orderByDropDown);
		
		selectOption.selectByValue(value);
	}
}
