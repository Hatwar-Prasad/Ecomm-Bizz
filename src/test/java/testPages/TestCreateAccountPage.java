package testPages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.CreateNewAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.ExcelHandling;

public class TestCreateAccountPage extends baseClass {

	public TestCreateAccountPage() throws IOException {
		super();

	}

	HomePage homePage;
	CreateNewAccountPage createaccountpage;
	
	LoginPage loginPage;
	
	String sheetName="customerDetails";

	@BeforeMethod
	public void lounchBrowser() throws IOException, InterruptedException {
		initialBrowser();
		homePage = new HomePage();
		createaccountpage = new CreateNewAccountPage();
		
		loginPage=new LoginPage();
	}

	@DataProvider
	public Object[][] getaccData() throws EncryptedDocumentException, IOException {
		
			Object[][] accData=ExcelHandling.getTestData(sheetName);
			return accData;
		
	}
	
	@Test (dataProvider = "getaccData")
	public void testCreateAccount_Homepage(String fn,String ln,String email,String pass) throws InterruptedException, IOException {
		homePage.verifyCreateNewAccount();
		createaccountpage.verifyCreateAccount(fn, ln, email, pass);
		
	}

	//@Test(dataProvider = "gettestData")
	public void testCreateAccount_Loginpage(String fn,String ln,String email,String pass) throws IOException, InterruptedException {
		homePage.verifySignIn();
		loginPage.verifyCreateAccountBtn();
		
		createaccountpage.verifyCreateAccount(fn, ln, email, pass);
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		browserClose();
	}
}
