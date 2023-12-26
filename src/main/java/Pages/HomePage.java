package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class HomePage extends baseClass {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='logo']/img")
	WebElement logoImg;
	@FindBy(xpath = "(//li[@class='authorization-link'])[1]")
	WebElement signIn;
	// @FindBy(xpath = "(//span[text()='Create an Account'])[1]") WebElement
	// createNewAccount;
	@FindBy(xpath = "(//button[@class='action switch'])[1]")
	WebElement createNewAccount;

	@FindBy(xpath = "(//a[text()='Create New Customer'])[1]")
	WebElement createCustomer;

	public String verifyPageTitle() {

		return driver.getTitle();
	}

	public boolean verifyLogo() {
		return logoImg.isDisplayed();
	}

	public LoginPage verifySignIn() throws IOException {

		signIn.click();
		return new LoginPage();
	}

	public CreateNewAccountPage verifyCreateNewAccount() throws InterruptedException, IOException {
		Thread.sleep(2000);
		createNewAccount.click();
		Thread.sleep(2000);
		createCustomer.click();

		return new CreateNewAccountPage();

	}

}
