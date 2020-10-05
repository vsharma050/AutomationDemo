package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.utility.WebEventListener;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    
    public  static  Properties prop;
	public static   WebDriver driver;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(TestBase.class);
	
	//CREATE TESTBASE METHOD WHERE SET THE PROPERTIES
	public TestBase(){
		
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
	
	//CREATE INITIALIZATION METHOD WHERE INITIALIZE THE BROWSER DRIVER 
	
	public  static void initialization() throws InterruptedException{
		
//	    String browserName= "chrome" ;
        
        String browserName= prop.getProperty("browser");
        System.out.println(browserName);
		
        if(browserName.equalsIgnoreCase("CHROME")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		log.info("Launching the chrome browser...>"); 
		
		
        }
		
        else if(browserName.equalsIgnoreCase("Firefox")){
			
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver(); 
            log.info("Launching the firefox browser...>");
			
			
			
			
		}  
         else if(browserName.equalsIgnoreCase("IE")){
			
			WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver(); 
            log.info("Launching the InternetExplorer browser...>");
		
			
		}
        
         else if(browserName.equalsIgnoreCase("EDGE")){
 			
 			WebDriverManager.edgedriver().setup();
 			driver = new EdgeDriver();
             log.info("Launching the EDGE browser...>");
 			
 			
 			
 		}
        
        e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
        
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		log.info("Opening the URL...>");
        
        
        
		  
		  
		  
		
	}
	
	//CLOSE THE BROWSER  
	
	public static void CloseBrowser(){
		
		
		  driver.quit();
		
		
	}
	
	
	
	
}
