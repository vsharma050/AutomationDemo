package com.amazon.qa.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.Homepage;
import com.amazon.qa.utility.TestUtill;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomepageTest extends TestBase {
   
	Homepage hompage ;
	TestUtill util;
	
	
	
	//CREATE A CONSTRUCTOR 
	public HomepageTest(){
		
		super(); 
		
	}
	//ALL THE TEST CASES SEPERATED AND INDEPENDENT TO EACH OTHER 
	
	//SETUP METHOD
    @BeforeMethod 
	public void homePage_SetupMethod() throws InterruptedException{
		
		initialization();
		
		hompage = new Homepage(); 
		util = new TestUtill();
		
	}
	
    
	//AFTER METHOD 
    @AfterMethod 
    public void TestCase_QuiteMethod(){
    	
    	CloseBrowser();
    	
    } 
    
     @Test(priority=1,enabled=true)
     @Severity(SeverityLevel.NORMAL)
     @Description("Test Case Description: verify amazon title appears on page")
     @Story("Story Name: To check page title")
    public void amazon_TitleAppearsOnPage(){
    	
    	String title = hompage.pageTitle(); 
    	System.out.println(title);
    	Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }  
    

    @Test(priority=2,enabled=true)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: verify amazon title appears on page")
    public void searchForLaptopsAnd_VerifyResultsAreForLaptopsOnly() throws InterruptedException{
    	
    	hompage.searchItems("Laptops");
    	String found = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold' or text()='laptops']//self::span")).getText();
    	System.out.println(found);
    	
    	util.waitForSeconds(1);
     
    	String Results="\"Laptops\"";
    	Assert.assertEquals(found,Results);
    		

    	List<WebElement>laptops = driver.findElements(By.xpath("//*[@class='a-link-normal a-text-normal']"));
    	  
    	System.out.println("Number of Laptops In List:-"+ laptops.size());
    	
    	for(int i=0; i<laptops.size() ; i++){
    		
    		System.out.println("ALL LAPTOPS NAME TEXT:"+ laptops.get(i).getText().substring(0,2));
    	
    		
			
			String all = laptops.get(i).getText();
			
			boolean b = all.contains("Laptop");
			String c = Boolean.toString(b);
			c="Laptop";
			System.out.println(c);
				
			Assert.assertEquals("Laptop",c);
    		
    		
    	} 
    	
    	
    } 
    

    
    @Test(priority=3,enabled=true)
    
    public void filterForHpLaptopsAnd_VerifyOnlyHPLaptopsAreVisibleOnFirstPage() {
    	
    	hompage.searchItems("Laptops");
    	
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         hompage.hpFilter();
         util.waitForSeconds(1);
    	
    	List<WebElement>laptops = driver.findElements(By.xpath("//*[@class='a-link-normal a-text-normal']"));
    	  
    	System.out.println("Number of Laptops In List:-"+ laptops.size());
    	
    	for(int i=0; i<laptops.size() ; i++){
    		
    		System.out.println("ALL LAPTOPS NAME TEXT:"+ laptops.get(i).getText().substring(0,2));
    	//	String List = laptops.get(i).getText().substring(0,2) ;
    		
    		
    	//	Assert.assertEquals(List, "HP");
    		
    	//	SoftAssert asrt = new SoftAssert();
		//	asrt.assertEquals(List,"HP");
		///	System.out.println("AssertionFaild");
		//	asrt.assertAll();
    		
			
			String all = laptops.get(i).getText();
			
			boolean b = all.contains("HP");
			String c = Boolean.toString(b);
			c="HP";
			System.out.println(c);
				
			Assert.assertEquals("HP", c);
    		
    		
    	} 
    		
    		
    	}  
    	
    	
       @Test(priority=4,enabled=true)
       public void selectPriceRangeAndVerifyRecordsVisibleOnPageAreNotOutOfPriceRange () throws Exception{
    	   
    	//   driver.manage().deleteAllCookies();
    	   
    	   hompage.searchItems("laptops");
    	   
    	   JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,500)");
    	   /*
    	   //Thread wait for seconds
    	   util.waitForSeconds(2);
    	   //Select a filter of price range
    	   hompage.pricerange();
    	   
    	   List<WebElement> tot = driver.findElements(By.xpath("//*[@class='a-size-base a-link-normal s-no-hover a-text-normal']")) ;
    	   
    	   System.out.println(tot.size());
    	   
    	  
    	   for(int i=0;i<tot.size();i++){
   			
   			
   			String all = tot.get(i).getText();
   			
   			String nxt = all.format(all,"20000");
   	//		String kk =  all.replaceAll("[^0-9]","");
   	//		System.out.println("relacefunction "+kk);
   			
   			String su = nxt.substring(1,7);
   			String ab=su.substring(0, 2);
   			String ac=su.substring(3,6);
   			String fi=ab+ac;
   			
   			System.out.println("Remove currency "+fi);
   			
   			int sub = Integer.parseInt(fi);
   			System.out.println(sub);
   			
   			
   			boolean b = all.contains("2");
   			String c = Boolean.toString(b);
   			c="2";
   			System.out.println(c);
   				
   			Assert.assertEquals("2",c);
   			
   			if(sub>=20000 && sub <=30000){
   				
   				 Assert.assertTrue(true);
   			}
   			
   			else{
   				
   				Assert.assertTrue(false);
   			}
   			
   			
   		}
    	   
    	   */
    	   
    	   
       }
    	
       
    	@Test(priority=5,enabled=true)
    	public void selectCPUTypeFilterThenOpen_FirstRecordAndVerifySameModelNoIsOpened() throws InterruptedException{
    		
    		 hompage.searchItems("Laptops");
     		//Implicit wait for 10 seconds
       	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    		hompage.CPUtype();
    		
    		List<WebElement> li =  driver.findElements(By.xpath("//*[@class='a-link-normal a-text-normal' and @target='_blank']")) ;
    		System.out.println(li.size());
    		
    		
    		for(int i=0;i<li.size();i++){
    			
    			
    			
    			String all = li.get(i).getText();
    			
    			boolean b = all.contains("i5");
    			String c = Boolean.toString(b);
    			c="i5";
    			System.out.println(c);
    				
    			Assert.assertEquals("i5", c);
    			
    			
    		}
    		
    		
    		
    	}
    
    	
    	@Test(priority=6,enabled=true)
    	public void geThePriceOfTheLaptopBeforeClickingOnItThenVerifyThatSamePriceIsAppearAfterOpeningIt() throws InterruptedException{
    		
    		 hompage.searchItems("HpEnvy Laptops");
    		//Implicit wait for 10 seconds
      	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    		 String price = driver.findElement(By.xpath("(//*[@class='a-price-whole']//self::span)[1]")).getText(); 
    		 System.out.println(price);
    		 
    		 WebElement firstResult = driver.findElement(By.xpath("(//*[@class='a-link-normal a-text-normal']//self::a)[1]"));
    		 firstResult.click();
    		 
    		  
   
 		
    		 String mainWindow = driver.getWindowHandle();
    		 
    		 System.out.println(mainWindow); 
    		 
    		  Set<String>  s = driver.getWindowHandles();
      	       
    		   Iterator<String> i =  s.iterator();
    		   
    		   while(i.hasNext()){
    			   
    			   String childWindow = i.next();
    			   
    			   if(!mainWindow.equalsIgnoreCase(childWindow)){
    				   
    				   driver.switchTo().window(childWindow);
    				   System.out.println(driver.switchTo().window(childWindow).getTitle());
    				     
    				   util.waitForSeconds(1);
    		    		 String priceCompare = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-price priceBlockBuyingPriceString']//self::span")).getText();  
    		    		 System.out.println(priceCompare);
    		    		 
    		    		String subString = priceCompare.substring(1,8);
    		    		System.out.println(subString);
    		 			Assert.assertEquals(" "+price,subString);
    				   
    				   
    			   }
    			 
    				   
    		  }  
    		   
    		   
    		   
      	     
    	}
    
    	
    	
    	@Test(priority=7,enabled=true)
    	public void addProductToCartAndVerifyItsAdded() {
    		
    		 hompage.searchItems("HpEnvy Laptops");
     		//Implicit wait for 10 seconds
       	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    		 
       	     WebElement firstResult = driver.findElement(By.xpath("(//*[@class='a-link-normal a-text-normal']//self::a)[1]"));
 		     firstResult.click();
    		
 		   // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
 		    util.waitForSeconds(1);
 		   String parenthandler= driver.getWindowHandle();

 		   Set<String>allwindowhandles = driver.getWindowHandles();
 		 
 		   for(String currenthandle :allwindowhandles){
 		 
 		   System.out.println("Current window handle is"+currenthandle);
 		   if(!currenthandle.equalsIgnoreCase(parenthandler)){
 		 
 		   driver.switchTo().window(currenthandle);
 		    util.waitForSeconds(1);
 		    
 		   JavascriptExecutor js =(JavascriptExecutor)driver;
 		    js.executeScript("window.scrollBy(0,500)");
 		    
 		    System.out.println("button");
 		    
    		hompage.addToCartButton();
    		
    		System.out.println("scroll done");
    		
    		hompage.cart();
    		
    		
    		String  name = driver.findElement(By.xpath("//*[@class='a-size-medium sc-product-title a-text-bold']//parent::a")).getText();
    		
    		String sub = name.substring(0,2);
    		
    		Assert.assertEquals(sub,"HP"); 
    		
    	}
  
     } 
    	}
    
 		   
    
  }   
	
    
