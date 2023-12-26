package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utility.WebEventlogger;
@SuppressWarnings("deprecation")
public class baseClass {
	
	public static WebDriver  driver;
	public static Properties prop;
	FileInputStream fInput;
	public static WebEventlogger logger;
	
	public static EventFiringWebDriver firingDriver;
	
	
	public baseClass() throws IOException {
		 prop=new Properties();
		fInput =new FileInputStream("../STP_magento/src/main/java/Utility/config.properties");
		
		prop.load(fInput);
		
		
	}
	
	
	
	public void initialBrowser() throws IOException {
		driver=new ChromeDriver();
		logger=new WebEventlogger();
		firingDriver=new EventFiringWebDriver(driver);
		firingDriver.register(logger);
		
		driver=firingDriver;
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("baseUrl"));
		
	}
	
	public void browserClose() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
