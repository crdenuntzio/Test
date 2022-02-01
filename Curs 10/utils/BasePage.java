package utils;

import pages.AudioPostPage;
import pages.ContactPage;
import pages.EventsPage;
import pages.LoginPage;
import pages.NavMenuPage;
import pages.PostFormatsPage;
import pages.ShopPage;
import pages.SingleEventPage;

public class BasePage extends BaseTest{
	public LoginPage loginPage = new LoginPage(driver);
	public NavMenuPage navMenu = new NavMenuPage(driver);
	public PostFormatsPage postFormats = new PostFormatsPage(driver);
	public ContactPage contactPage = new ContactPage(driver);
	public ShopPage shopPage = new ShopPage(driver);
	public EventsPage eventPage = new EventsPage(driver);
	public SingleEventPage singleEventPage = new SingleEventPage(driver);
	public AudioPostPage audioPostPage = new AudioPostPage(driver);
}
