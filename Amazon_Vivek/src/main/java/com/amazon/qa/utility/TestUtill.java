package com.amazon.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtill { 
	
	public static WebDriver driver; 
	public static   Properties prop;
	
	public static String CHROME;
	public static String IE;
	public static String Firefox;
	public static String EDGE;
	
	Logger log = Logger.getLogger(TestUtill.class);
	
	
      public TestUtill(){
		
		try{
		 prop = new Properties(); 
		FileInputStream inputstream = new FileInputStream(System.getProperty("user.dir")+"//properties");
		 prop.load(inputstream);
		
		} 
		catch(FileNotFoundException exc){
			
			exc.printStackTrace();
		}
		catch(IOException exc ){
			
			exc.printStackTrace();
			
		}
		
		
	}
	
	
	public void openBrowserAndURL(String browserName)
	{
		
		if(browserName.equalsIgnoreCase(CHROME)){
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(); 
			log.info("Launching the chrome browser...>");
			
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies(); 
			
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));
			log.info("Opening the URL...>"); 	
			
		}
		else if(browserName.equalsIgnoreCase(Firefox)){
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver(); 
            log.info("Launching the firefox browser...>");
			
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies(); 
			
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));
			log.info("Opening the URL...>");
			
			
		}
		
		else if(browserName.equalsIgnoreCase(IE)){
			
			WebDriverManager.iedriver().setup();
			WebDriver driver = new InternetExplorerDriver(); 
            log.info("Launching the InternetExplorer browser...>");
			
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies(); 
			
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));
			log.info("Opening the URL...>");
			
			
			
		}
		
         else if(browserName.equalsIgnoreCase(EDGE)){
			
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new InternetExplorerDriver(); 
            log.info("Launching the EDGE browser...>");
			
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies(); 
			
			driver.manage().window().maximize();
			
			driver.get(prop.getProperty("url"));
			log.info("Opening the URL...>");
			
			
			
		}
		
		
	}
	
	
	

	public void waitForSeconds(int sec){
		
		try{
			
			Thread.sleep(sec * 1000);
			
		}
		catch(Exception e){
			
			System.out.println("Interrupted.");
			e.printStackTrace();
		}
		
		
	}
	
	public static String getScreenshot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}
