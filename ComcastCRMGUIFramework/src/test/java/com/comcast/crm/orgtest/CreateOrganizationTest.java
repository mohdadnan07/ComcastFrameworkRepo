package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {

		// read the data from properties file object

//		FileUtility file = new FileUtility();

		// read the data from JSON file object

//		JsonUtility json = new JsonUtility();

		// read the data from excel file object

//		ExcelUtility excel = new ExcelUtility();

		// read the data from webdriverutility file object

//		String BROWSER = file.getDataFromPropertiesFile("browser");
//		String URL = file.getDataFromPropertiesFile("url");
//		String USERNAME = file.getDataFromPropertiesFile("username");
//		String PASSWORD = file.getDataFromPropertiesFile("password");

//		FileInputStream fis  = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\commondata.properties");
//		
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		
//		String BROWSER = pObj.getProperty("browser");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("username");
//		String PASSWORD = pObj.getProperty("password");

//		System.out.println(BROWSER);
//		System.out.println(URL);
//		System.out.println(USERNAME);
//		System.out.println(PASSWORD);

		// generate the random number

//		Random random = new Random();
//		int randInt = random.nextInt(1000);

//		System.out.println(randInt);
		
		UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		
		// read the data from excel file

		String orgName = excel.getDataFromExcel("org", 1, 1) + jLib.getRandomNumber();

//		FileInputStream fis1  = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\testScriptData.xlsx");
//		
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("org");
//		Row row = sh.getRow(1);
//	    String orgName =	row.getCell(2).toString() + randInt;   
//	    String data = cell.getStringCellValue();
//		System.out.println(orgName);
//		
//		WebDriver driver = null;
//		
//		if(BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		}else if(BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}else if(BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		}else {
//			driver = new ChromeDriver();
//		}

		// step 1: Login to application

//		driver.get(URL);
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

//		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

//		LoginPage lp = new LoginPage(driver);
//		
//		lp.loginToApp("admin", "admin");

//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getLoginBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");

		// step2: Navigate to organization module

		HomePage hp = new HomePage(driver);
//		hp.naviagteToCampaignPage();
		hp.getOrgLink().click();

//		driver.findElement(By.linkText("Organizations")).click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create Org page");

		// step 3: Click on "Create contact" plus button

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Create a new org");

		// step 4: Enter all the details and create new organization

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

//		driver.findElement(By.name("accountname")).sendKeys(orgName);

//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		UtilityClassObject.getTest().log(Status.INFO, orgName+ "=====>Create a new org");

		// verify the header msg expected result

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is verified=====PASS");
		} else {
			System.out.println(orgName + " is not verified=====fail");
		}

//		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(headerInfo.contains(orgName)) {
//			System.out.println(orgName + " is created=====PASS");
//		}else {
//			System.out.println(orgName + " is not created=====fail");
//		}

		// verify the header orgName info expected result

//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if(actOrgName.contains(orgName)) {
//			System.out.println(orgName + " is created=====PASS");
//		}else {
//			System.out.println(orgName + " is not created=====fail");
//		}

		// LOGOUT
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
//		hp.logout();
//		driver.quit();
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustries() throws Throwable {

		String orgName = excel.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industries = excel.getDataFromExcel("org", 4, 4);
		String type = excel.getDataFromExcel("org", 4, 5);

		HomePage hp = new HomePage(driver);
		hp.naviagteToCampaignPage();
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industries, type);

		// step 7: verify the header msg expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		} else {
			System.out.println(orgName + " is not created=====fail");
		}

		// step 8: verify the header orgName info expected result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		} else {
			System.out.println(orgName + " is not created=====fail");
		}

		// step 9: verify the header name of Industry info expected result
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.contains(industries)) {
			System.out.println(industries + " is created=====PASS");
		} else {
			System.out.println(industries + " is not created=====fail");
		}

		// step 10: verify the header name of type info expected result
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.contains(type)) {
			System.out.println(type + " is created=====PASS");
		} else {
			System.out.println(type + " is not created=====fail");
		}

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumber() throws Throwable {

		String orgName = excel.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String PhoneNumber = excel.getDataFromExcel("org", 7, 4);

		HomePage hp = new HomePage(driver);
		hp.naviagteToCampaignPage();
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, PhoneNumber);

		// verify the header msg expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		} else {
			System.out.println(orgName + " is not created=====fail");
		}
		// verify the header orgName info expected result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		} else {
			System.out.println(orgName + " is not created=====fail");
		}

		// verify the header name of phoneNumber info expected result
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhoneNumber.contains(PhoneNumber)) {
			System.out.println(PhoneNumber + " is created====PASS");
		} else {
			System.out.println(PhoneNumber + " is not created====fail");
		}

	}

}
