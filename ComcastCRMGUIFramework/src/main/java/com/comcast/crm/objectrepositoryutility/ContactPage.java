package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver) {				// Rule-2: Object initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewContactBtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfo;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;
	
	
//	@FindBy(name = "search_text")
//	private WebElement searchEdt;
//	
//	@FindBy(id = "bas_searchfield")
//	private WebElement searchDD;
//	
//
//	@FindBy(name = "submit")
//	private WebElement searchBtn;
	
	
//	public WebElement getSearchBtn() {
//		return searchBtn;
//	}
//
//	public WebElement getSearchEdt() {
//		return searchEdt;
//	}
//
//	public WebElement getSearchDD() {
//		return searchDD;
//	}
	
	public WebElement getContactInfo() {
		return contactInfo;
	}


	public WebElement getActLastName() {
		return actLastName;
	}


	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

}
