package testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import BaseClass.baseClass;
import Pages.HomePage;

public class TestHomePage extends baseClass {
	HomePage homePage ;

	public TestHomePage() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void lounchBrowser() throws IOException {
		initialBrowser();
		homePage =new HomePage();
	}
	@AfterMethod
	public void quiteBrowser() throws InterruptedException  {
		browserClose();
	}
	
	@Test
	public void testPageTitle() {
		Assert.assertEquals(homePage.verifyPageTitle(), "Magento 2 Commerce (Enterprise) B2B Demo - Magebit");
	}
	
	@Test
	public void testPageLogo() {
		
		Assert.assertTrue(homePage.verifyLogo());
	}
	
	@Test
	public void testSignIn() throws IOException {
		homePage.verifySignIn();
	}
	@Test
	public void testCreateAccount() throws InterruptedException, IOException {
		
		homePage.verifyCreateNewAccount();
	}
	
	
	
	
	

}
