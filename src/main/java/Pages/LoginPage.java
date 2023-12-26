package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class LoginPage  extends baseClass{

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="email") WebElement emailId;
	@FindBy(id="pass") WebElement password;
	@FindBy(id="send2") WebElement btnSignIn;
		@FindBy(xpath = "//span[text()='Customer Login']") WebElement customersLoginText;
		@FindBy(xpath = "(//span[text()='Create an Account'])[3]") WebElement btnCreateAccount;
		
		
	public HomePage verifyLogin() throws IOException {
		
		emailId.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		
		btnSignIn.click();
		
		return new HomePage();
		
	}
	public String verifyLoginText() {
		return customersLoginText.getText();
		
	}
	
	public CreateNewAccountPage verifyCreateAccountBtn() throws IOException {
		btnCreateAccount.click();
		return new CreateNewAccountPage();
	}
	

}
