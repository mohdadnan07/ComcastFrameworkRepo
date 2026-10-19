package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void selectDD(WebElement element , String text) {
		Select sel  = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it =  set.iterator();
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {
				break;
			}
		}
		
	}

}
