package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Adnan
 * 
 * Contains Login page elements & bussiness lib like login()
 * 
 */

public class LoginPage extends WebDriverUtility{								// Rule-1: Create a separate java class
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {				// Rule-2: Object initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name = "user_name") 						// Rule-2: Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	public WebElement getUsernameEdt() {                // Rule-4: Object Encapsulation
		return usernameEdt;								// Rule-5: Object Utilization
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 * Login to application based username, password, url arguments
 * @param url
 * @param username
 * @param password
 */
	
	public void loginToApp(String url, String username, String password) {
		driver.manage().window().maximize();
		waitForPageLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(username);
		loginBtn.click();
	}

}
