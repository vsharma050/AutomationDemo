package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

import io.qameta.allure.Step;

public class Homepage extends TestBase {
   
	//***** P A G E - F A C T O R Y *****
	
	//AMAZON HOMEPAGE SEARCH-FIELD 
	@FindBy(how=How.XPATH,using="//*[@type='text' or name='field-keywords']//self::input")
	@CacheLookup
	WebElement searchField;
	 
	//AMAZON HOMEPAGE SEARCH-ICON 
    @FindBy(how=How.XPATH,using="//*[@type='submit' or value='Go']//self::input")
    @CacheLookup
	WebElement searchIcon;
	
	//AMAZON SELECT FILTER DROPDOWN
    @FindBy(how=How.XPATH,using="//*[@name='s' or @id='s-result-sort-select']//self::select")
    @CacheLookup
	WebElement selectDropdown;
    
  //AMAZON SELECT FILTER DROPDOWN
    @FindBy(how=How.XPATH,using="(//*[@class='a-icon a-icon-checkbox'])[2]")
    @CacheLookup
	WebElement selectBrandOption; 
    
  //AMAZON ADD TO CART BUTTON 
    @FindBy(how=How.CSS,using="#add-to-cart-button")
    @CacheLookup
	WebElement addCartButton;  
    
   //CART OPTION 
  //  @FindBy(how=How.CSS,using="#add-to-cart-button")
    @FindBy(how=How.LINK_TEXT,using="Cart")
    @CacheLookup
	WebElement cart;  
    
   //CPU Type 
    @FindBy(how=How.XPATH,using="//*[@class='a-size-base a-color-base' and text()='Intel Core i5']//self::span")
    @CacheLookup
	WebElement i5;
    
    //CART OPTION 
    //@FindBy(how=How.CSS,using="#add-to-cart-button")
      @FindBy(how=How.LINK_TEXT,using="₹20,000 – ₹30,000")
      @CacheLookup
  	WebElement pricerange; 
    
    //HP Filter 
      @FindBy(how=How.XPATH,using="(//*[@class='a-icon a-icon-checkbox'])[3]")
      @CacheLookup
  	WebElement HP; 
      
    
	
	//INITIALIZE ALL OBJECTS-------------------- 
	
	public Homepage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//-----ACTIONS------------------------------- 
	
	@Step("getting amazon page title")
	public String pageTitle(){
		
		String title = driver.getTitle();
		
		return title;
		
	}
	
    @Step("search item in searchfield: {0} step..")
	public void searchItems(String searchItem) {
		
		searchField.sendKeys(searchItem);
		
		searchIcon.click();
		
	}
	
	
	public void selectDropdown(String text){
		
		Select sc = new Select(selectDropdown);
		  
		sc.selectByVisibleText(text);
		
		
	}
	
	public void selectBrandOption(){
		
		selectBrandOption.click();
		
	}
	
	public void addToCartButton(){
		
		
		addCartButton.click();
		
	}
	
	public void cart(){
		
		cart.click();
		
	}
	
	public void  CPUtype(){
		
		i5.click();
		
	}
	
	public void pricerange(){
		
		pricerange.click();
		
	} 
	
	public void hpFilter(){
		
		
		HP.click();
		
	}
	
	
	
	
	
	
}
