package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class CreateNewAccountPage extends baseClass{

	
	public CreateNewAccountPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname") WebElement firstName;
	@FindBy(id="lastname") WebElement lastName;
	@FindBy(id="email_address") WebElement emailAdress;
	@FindBy(id="password") WebElement password;
	@FindBy(id="password-confirmation") WebElement confmPassword;
	
	@FindBy(xpath = "(//span[text()='Create an Account'])[3]") WebElement btnCreateAccount;
	
	
	public void verifyCreateAccount(String fName,String lName,String emailID,String passwd) throws InterruptedException {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emailAdress.sendKeys(emailID);
		password.sendKeys(passwd);
		confmPassword.sendKeys(passwd);
		
		Thread.sleep(4000);
		
		btnCreateAccount.click();
		
		
		
	}

}
