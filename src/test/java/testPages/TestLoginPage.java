package testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.HomePage;
import Pages.LoginPage;


public class TestLoginPage extends baseClass {
	HomePage homePage;
	LoginPage loginPage;

	public TestLoginPage() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void lounchBrowser() throws IOException {
		initialBrowser();
		homePage=new HomePage();
		loginPage=new LoginPage();
		
	}
	
	@AfterMethod
	public void quiteBrowser() throws InterruptedException  {
		browserClose();
	}

	@Test
	public void testLogin() throws IOException {
		
		homePage.verifySignIn();
		loginPage.verifyLogin();
		//Assert.fail();
		
	}
	
	@Test 
	public void testCustomerLoginText() throws IOException {
		homePage.verifySignIn();
		Assert.assertEquals( loginPage.verifyLoginText(), "Customer Login");
	}
	
	@Test
	public void testCreateAccountBtn() throws IOException {
		homePage.verifySignIn();
		loginPage.verifyCreateAccountBtn();
	}
	
	
	
	
}
