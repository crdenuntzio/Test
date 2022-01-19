package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public WebDriver driver;
	
	public ProductPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="woocommerce-product-gallery__wrapper") public WebElement coverPicture;
	@FindBy(className="product_title") public WebElement bookTitle;
	@FindBy(className="woocommerce-product-rating") public WebElement bookRating;
	@FindBy(css = "div[class='summary entry-summary'] span[class='woocommerce-Price-amount amount']") public WebElement bookPrice;
	@FindBy(className="woocommerce-product-details__short-description") public WebElement bookDescription;
	@FindBy(className="input-text") public WebElement quantity;
	@FindBy(name="add-to-cart") public WebElement addToCartButton;
	@FindBy(className="product_meta") public WebElement bookMetaData;
}
