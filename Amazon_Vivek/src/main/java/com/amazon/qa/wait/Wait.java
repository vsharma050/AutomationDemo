package com.amazon.qa.wait;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class Wait extends TestBase{
    

	public void ExplicitWaitClick(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.click();
		
	}
	
    public String ExplicitWaitGetText(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
	    .getText();
		
	}
	
    public void ExplicitWaitClear(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.clear();
		
	}
	
    public void ExplicitWaitSendKeys(WebElement elementToBeLoaded,String sendkey){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.sendKeys(sendkey);
		
	}
	
	
	
	
	
	
	
	
}
