package com.comcast.crm.contacttest;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author Adnan
 */

public class CreateContactTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		
		
		

		// Read the data from properties file

//		FileInputStream fis = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\commondata.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String BROWSER = pObj.getProperty("browser");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("username");
//		String PASSWORD = pObj.getProperty("password");
		
//		FileUtility fLib = new FileUtility();
//		
//		String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// Generate the random number
		
//		Random random = new Random();
//		int randInt = random.nextInt(1000);
		
//		JavaUtility jLib = new JavaUtility();

		/* Read the data from Excel File*/
		
//		FileInputStream fis1 = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("contact");
//		Row row = sh.getRow(1);
//		String lastName = row.getCell(2).toString() + randInt;
//		System.out.println(lastName);
//		wb.close();
		
//		ExcelUtility eLib = new ExcelUtility();
		String lastName = excel.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

//		WebDriver driver = null;
//
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}

//		driver.get(URL);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//
//		driver.findElement(By.id("submitButton")).click();
		
//		driver.findElement(By.linkText("Contacts")).click();
		
		HomePage hp = new HomePage(driver);
//		hp.naviagteToCampaignPage();
		hp.getContactLink().click();

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

//		driver.findElement(By.name("lastname")).sendKeys(lastName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);

		// verify the header msg of contact expected result
		
//		String contactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		String contactInfo = cp.getContactInfo().getText();
		boolean status = contactInfo.contains(lastName);
		Assert.assertEquals(status, true);
		
		
//		if (contactInfo.contains(lastName)) {
//			System.out.println(lastName + " is created=====PASS");
//		} else {
//			System.out.println(lastName + " is not created=====fail");
//		}

		// verify the header contactName lastName info expected result
		
//		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		String actLastName = cp.getActLastName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
		
//		if (actLastName.contains(lastName)) {
//			System.out.println(lastName + " is created=====PASS");
//		} else {
//			System.out.println(lastName + " is not created=====fail");
//		}

		// LOGOUT
//				Actions act = new Actions(driver);
//				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//				driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
//		driver.quit();

	}
	
	@Test(groups = "regressionTest")
	public void createContactWithsupportDateTest() throws Throwable {
		System.out.println("organistion 2nd regression test");
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		System.out.println("organistion 3nd regression test");
	}

}
