package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.ProductPage;
import pages.ShopPage;
import utils.BaseTest;

public class CheckElementsInProduct extends BaseTest {
	ShopPage shopPage;
	ProductPage productPage;
	NavMenuPage navMenu;
	
	@Test
	public void checkForElements() {
		navMenu = new NavMenuPage(driver);
		shopPage = new ShopPage(driver);
		productPage = new ProductPage(driver);
		
		navMenu.navigateTo(navMenu.shopLink);
		
		shopPage.bookLinks.get(1).click();
		
		assertTrue(productPage.coverPicture.isDisplayed(), "Checking book cover");
		assertTrue(productPage.bookTitle.isDisplayed(), "Checking book title");
		assertTrue(productPage.bookRating.isDisplayed(), "Checking book rating");
		assertTrue(productPage.bookPrice.isDisplayed(), "Checking book price");
		assertTrue(productPage.bookDescription.isDisplayed(), "Checking book description");
		assertTrue(productPage.quantity.isDisplayed(), "Checking quantity");
		assertTrue(productPage.addToCartButton.isDisplayed(), "Checking add to cart button");
		assertTrue(productPage.bookMetaData.isDisplayed(), "Checking metadata");
	}
}
