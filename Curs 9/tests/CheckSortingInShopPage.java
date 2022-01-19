package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class CheckSortingInShopPage extends BaseTest {
	ShopPage shopPage;
	NavMenuPage navMenu;
	
	@Test
	public void checkSorting() {
		navMenu = new NavMenuPage(driver);
		shopPage= new ShopPage(driver);
		
		navMenu.navigateTo(navMenu.shopLink);
		
		shopPage.setSortingOrder("price");
		
		assertTrue(Float.parseFloat(shopPage.bookPrices.get(0).getText().substring(1)) < Float.parseFloat(shopPage.bookPrices.get(shopPage.bookPrices.size() - 1).getText().substring(1)), "Checking book prices");
	}
}
