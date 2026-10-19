package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {
	
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {				// Rule-2: Object initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name = "lastname") 						// Rule-2: Object Creation
	private WebElement contactNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getContactNameEdit() {
		return contactNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContact(String lastName) {
		contactNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
//	@FindBy(name = "accountname") 						// Rule-2: Object Creation
//	private WebElement orgNameEdt;
//	
//	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
//	private WebElement saveBtn;
//	
//	@FindBy(name = "industry")
//	private WebElement industryDD;
//	
//	@FindBy(name = "accounttype")
//	private WebElement typeDD;
//	
//	@FindBy(id="phone")
//	private WebElement phoneNumberEdt;
//	
//	
//	public WebElement getPhoneNumber() {
//		return phoneNumberEdt;
//	}
//
//	public WebElement getIndustryDD() {
//		return industryDD;
//	}
//	
//	public WebElement getTypeDD() {
//		return typeDD;
//	}
//	
//
//	public WebElement getOrgNameEdit() {
//		return orgNameEdt;
//	}
//
//	public WebElement getSaveBtn() {
//		return saveBtn;
//	}
//	
//	public void createContact(String lastName) {
//		orgNameEdt.sendKeys(orgName);
//		saveBtn.click();
//	}
//	
//	public void createOrg(String orgName, String industry, String type) {
//		orgNameEdt.sendKeys(orgName);
//		Select sel1 = new Select(industryDD);
//		sel1.selectByVisibleText(industry);
//		
//		Select sel2 = new Select(typeDD);
//		sel2.selectByVisibleText(type);
//		saveBtn.click();
//	}
//	
//	public void createOrg(String orgName, String phoneNumber) {
//		orgNameEdt.sendKeys(orgName);
//		phoneNumberEdt.sendKeys(phoneNumber);
//		saveBtn.click();
//	}
//	


}
