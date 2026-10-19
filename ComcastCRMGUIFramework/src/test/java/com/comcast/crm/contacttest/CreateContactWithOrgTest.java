package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import java.util.Calendar;
//import java.util.Date;
//import java.text.SimpleDateFormat;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {

		// Read the data from properties file

//		FileInputStream fis = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\commondata.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String BROWSER = pObj.getProperty("browser");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("username");
//		String PASSWORD = pObj.getProperty("password");
		
		FileUtility fLib = new FileUtility();

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// Generate the random number
//		Random random = new Random();
//		int randInt = random.nextInt(1000);
		
		JavaUtility jLib = new JavaUtility();

		// Read the data from Excel File
//		FileInputStream fis1 = new FileInputStream(
//				"C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("contact");
//		Row row = sh.getRow(7);
//		String orgName = row.getCell(2).toString() + randInt;
//		String lastName = row.getCell(3).toString() + randInt;
////		System.out.println(lastName);
//		wb.close();
		
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Step 1: Login to Application

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		// step2: Navigate to contact module

		driver.findElement(By.linkText("Organizations")).click();

		// step 3: Click on "Create contact" plus button

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// step 4: Enter all the details and create new organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify the header msg expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		} else {
			System.out.println(orgName + " is not created=====fail");
		}

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// Generate date and after 30 days date
//				Date dateObj = new Date();
//				System.out.println(dateObj);
//				
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			    String startDate = sdf.format(dateObj);
//				System.out.println(startDate);
//				
//				Calendar cal = sdf.getCalendar();
//				cal.add(cal.DAY_OF_MONTH, 30);
//				String endDate = sdf.format(cal.getTime());
//				
//				System.out.println(endDate);

		// step 5: Navigate to contact module

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> it =  set.iterator();
//		while(it.hasNext()) {
//			String windowId = it.next();
//			driver.switchTo().window(windowId);
//			String actUrl = driver.getCurrentUrl();
//			if(actUrl.contains("module=Accounts&action")) {
//				break;
//			}
//		}
		
		WebDriverUtility wLib = new WebDriverUtility();
		
		String partialURL1 = "module=Accounts&action";
		wLib.switchToTabOnURL(driver, partialURL1);
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text() = '"+ orgName +"']")).click();
//		
//		Set<String> set1 = driver.getWindowHandles();
//		Iterator<String> it1 =  set1.iterator();
//		while(it1.hasNext()) {
//			String windowId = it1.next();
//			driver.switchTo().window(windowId);
//			String actUrl = driver.getCurrentUrl();
//			if(actUrl.contains("module=Contacts&action")) {
//				break;
//			}
//		}
		
		String partialURL2 = "module=Contacts&action";
		wLib.switchToTabOnURL(driver, partialURL2);
		
//		Select sel2 = new Select(orgSearch);
		
		

//		driver.findElement(By.name("support_start_date")).clear();
//		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

//		driver.findElement(By.name("support_end_date")).clear();
//		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify the header msg of contact expected result
		String contactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactInfo.contains(lastName)) {
			System.out.println(lastName + " is created=====PASS");
		} else {
			System.out.println(lastName + " is not created=====fail");
		}

		// verify the header contactName lastName info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " is created=====PASS");
		} else {
			System.out.println(lastName + " is not created=====fail");
		}
		
		Thread.sleep(2000);
		
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " is created=====PASS");
		}else {
			System.out.println(orgName + " is not created=====fail");
		}
		
		Thread.sleep(2000);
		
		// verify the header of startDate and endDate
//		String actStartDate = driver.findElement(By.id("dtlview_support startDate")).getText();
//		if (actStartDate.contains(startDate)) {
//			System.out.println(startDate + " is created=====PASS");
//		} else {
//			System.out.println(startDate + " is not created=====fail");
//		}

//		String actEndDate = driver.findElement(By.id("dtlview_support End Date")).getText();
//		if (actEndDate.contains(startDate)) {
//			System.out.println(endDate + " is created=====PASS");
//		} else {
//			System.out.println(endDate + " is not created=====fail");
//		}

		// LOGOUT
//				Actions act = new Actions(driver);
//				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//				driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.quit();

	}

}
