package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class captureImages {
	
public static void  takeScreenShots_failure(WebDriver driver,String fileName) throws IOException {
		
		TakesScreenshot scrnShots=(TakesScreenshot) driver;
		
		  File source = scrnShots.getScreenshotAs(OutputType.FILE);
		  
		  File dest=new File("../STP_magento/FailedTestCases/"+fileName+".png");
		  
		  FileHandler.copy(source, dest);
		
	}
public static void  takeScreenShots_pass(WebDriver driver,String fileName) throws IOException {
	
	TakesScreenshot scrnShots=(TakesScreenshot) driver;
	
	  File source = scrnShots.getScreenshotAs(OutputType.FILE);
	  
	  File dest=new File("../STP_magento/PassedTestCases/"+fileName+".png");
	  
	  FileHandler.copy(source, dest);
	
}
public static void  takeScreenShots_skipped(WebDriver driver,String fileName) throws IOException {
	
	TakesScreenshot scrnShots=(TakesScreenshot) driver;
	
	  File source = scrnShots.getScreenshotAs(OutputType.FILE);
	  
	  File dest=new File("../STP_magento/SkippedTestCases/"+fileName+".png");
	  
	  FileHandler.copy(source, dest);
	
}

}
